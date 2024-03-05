package d6g.win.resource.interceptor;

import cn.hutool.core.util.StrUtil;
import com.auth0.jwt.interfaces.DecodedJWT;
import d6g.win.resource.contants.CodeEnum;
import d6g.win.resource.utils.JWTUtils;
import d6g.win.resource.utils.JsonResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;

@Configuration
public class AuthInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        String requestURI = request.getRequestURI();

        if (requestURI.contains("/auth/login") || requestURI.contains("/error")) {
            return true;
        }

        // 前端api 大部分不需要token
        String token = request.getHeader("token");
        if (token == null) {
            return true;
        }

        if (StrUtil.isEmpty(token)) {
            setReturn(request, response, CodeEnum.Error_Token_Expire);
            return false;
        }

        DecodedJWT verify = JWTUtils.decode(token);
        if (verify == null) {
            setReturn(request, response, CodeEnum.Error_Token_Expire);
            return false;
        }

        String userId = String.valueOf(verify.getClaim("userId"));
        request.setAttribute("userId", userId);
        return true;
    }


    //返回错误信息
    private static void setReturn(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, String msg) throws IOException {
        httpServletResponse.setContentType("application/json;charset=utf-8");
        httpServletResponse.setHeader("Access-Control-Allow-Origin", httpServletRequest.getHeader("Origin"));
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "POST, GET");
        httpServletResponse.setHeader("Access-Control-Max-Age", "3600");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept,Referer,User-Agent,ticket,loginId,loginTerminal,cityCode,source");
        httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");
        try {
            httpServletResponse.getWriter().write(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void setReturn(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, CodeEnum code) throws IOException {
        httpServletResponse.setContentType("application/json;charset=utf-8");
        httpServletResponse.setHeader("Access-Control-Allow-Origin", httpServletRequest.getHeader("Origin"));
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "POST, GET");
        httpServletResponse.setHeader("Access-Control-Max-Age", "3600");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept,Referer,User-Agent,ticket,loginId,loginTerminal,cityCode,source");
        httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");
        try {
            JsonResponse res = JsonResponse.error(CodeEnum.Error_Token_Expire);
            httpServletResponse.getWriter().write(res.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
