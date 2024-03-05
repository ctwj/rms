package d6g.win.resource.controller.frontend;

import d6g.win.resource.contants.CodeEnum;
import d6g.win.resource.contants.MetaConstant;
import d6g.win.resource.entity.UserEntity;
import d6g.win.resource.entity.UserMetaEntity;
import d6g.win.resource.request.LoginRequest;
import d6g.win.resource.request.RegisterRequest;
import d6g.win.resource.service.IAuthService;
import d6g.win.resource.service.IOptionService;
import d6g.win.resource.utils.ErrorHandler;
import d6g.win.resource.utils.JWTUtils;
import d6g.win.resource.utils.JsonResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/auth")
@Tag(name="认证", description = "认证相关接口")
public class AuthController {

    @Autowired
    private IAuthService IAuthService;

    @Autowired
    private IOptionService IOptionService;


    @PostMapping("/register")
    @Operation(
            summary = "注册用户",
            description = "注册用户",
            parameters = {
                    @Parameter(name="request", description = "请求表单", required = true)
            },
            responses = {
                    @ApiResponse(responseCode = "200", description = "ok")
            }
    )
    public JsonResponse register (@Validated @RequestBody RegisterRequest request, BindingResult result) {

        // 参数校验
        if (result.hasErrors() || !Objects.equals(request.getPassword(), request.getPasswordRepeat())) {
            System.out.println("===> user: "+request);
            return ErrorHandler.HandleInvalidParameter(result);
        }

        // 如果需要校验，则必须存在邮箱
        if (IOptionService.isEnableActive() && !Objects.equals(request.getEmail(), null)) {
            System.out.println("isWebsiteMaintian");
            return ErrorHandler.HandleInvalidParameter(result);
        }

        // 检测用户名是否重复， 检测邮箱是否重复
        if (IAuthService.isEmailExists(request.getEmail())) {
            System.out.println("isEmailExists");
            return JsonResponse.error(CodeEnum.Error_Auth_ExistsEmail);
        }

        // 用户名重复判断
        if (IAuthService.isNameExists(request.getUsername())) {
            System.out.println("isNameExists");
            return JsonResponse.error(CodeEnum.Error_Auth_ExistsUser);
        }

        // 判断网站是否正在维护
        if (IOptionService.isWebsiteMaintian()) {
            System.out.println("isWebsiteMaintian");
            return JsonResponse.error(CodeEnum.Error_Website_Maintain);
        }

        // 创建一个用户
        UserEntity user = IAuthService.createNewUser(request.getUsername(), request.getPassword());

        // 邮箱填充
        if (!Objects.equals(request.getEmail(), null)) {
            user.setUserEmail(request.getEmail());
        }

        // 注册
        boolean registerOk = IAuthService.register(user);
        if (registerOk) {
            return JsonResponse.success();
        }

        return JsonResponse.error(CodeEnum.Error);
    }

    @PostMapping("/login")
    @Operation()
    public JsonResponse login (@Validated @RequestBody LoginRequest loginRequest, BindingResult result) {
        if (result.hasErrors()) {
            return ErrorHandler.HandleInvalidParameter(result);
        }
        boolean remember = loginRequest.getRemember();
        UserEntity user = IAuthService.login(loginRequest.getUsername(), loginRequest.getPassword());
        if (user == null) {
            return JsonResponse.error(CodeEnum.Error_Auth_InvalidPassword);
        }

        Map<String, String> payload = new HashMap<String, String>();
        payload.put("userId", String.valueOf(user.getId()));
        payload.put("userLogin", user.getUserLogin());
        System.out.println(user);

        // 从 meta 中取出需要的数据
        List<UserMetaEntity> metas = user.getMetaEntities();
        metas.forEach(meta-> {
            // 返回值中添加权限
            if (Objects.equals(meta.getMetaKey(), MetaConstant.UserMetaRole)) {
                payload.put("role", meta.getMetaValue());
            }
        });

        // jwt
        String token = JWTUtils.getToken(payload, remember);
        payload.put("token", token);

        return JsonResponse.data(payload);
    }
}
