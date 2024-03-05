package d6g.win.resource.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class RegisterRequest {

    @NotBlank(message = "请输入用户信息")
    @JsonProperty("username")
    @Pattern(regexp = "^(?!\\d+$)[a-zA-Z0-9]+$", message = "用户名不能为纯数字")
    private String username;

    @JsonProperty("email")
    @NotBlank(message = "请输入邮箱地址")
    private String email;

    @NotBlank(message = "请输入密码")
    @JsonProperty("password")
    private String password;

    @NotBlank(message = "请输入重复密码")
    @JsonProperty("password_repeat")
    private String passwordRepeat;

    @JsonProperty("username_type")
    private String usernameType;
}
