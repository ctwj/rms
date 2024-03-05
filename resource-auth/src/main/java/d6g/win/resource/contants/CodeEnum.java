package d6g.win.resource.contants;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

@Getter
public enum CodeEnum {

    OK(200, "正常"),
    Error(400, "错误"),
    Error_Invalid_Parameter(400001, "参数错误"),

    Error_Token_Expire(400002, "登陆token已过期，请重新登录"),
    Error_Website_Maintain(400003, "网站正在维护"),
    Error_Website_Close(400004, "网站当前已关闭"),

    // Auth module
    Error_Auth_InvalidUser(401001, "无效用户"),
    Error_Auth_InvalidPassword(401002, "无效密码"),
    Error_Auth_ExistsUser(401003, "用户已经存在"),
    Error_Auth_KeyExpire(401004, "激活码已过期"),
    Error_Auth_NoNeedActive(401005, "用户已激活无需激活"),
    Error_Auth_ExistsEmail(401006, "邮箱已经存在"),

    // Other module


    // 在上面添加Code
    Finish(8888, "无效值，保正添加Code时，全部逗号结尾");

    @EnumValue
    private Integer code;

    private String comment;

    CodeEnum(Integer code, String comment) {
        this.code = code;
        this.comment = comment;
    }
}
