package d6g.win.resource.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.springframework.boot.context.properties.bind.DefaultValue;

@Data
public class LoginRequest {

    @NotBlank(message = "请输入用户信息")
    @JsonProperty("username")
    @Pattern(regexp = "^(?!\\d+$)[a-zA-Z0-9]+$", message = "用户名不能为纯数字")
    private String username;

    @NotBlank(message = "请输入密码")
    @JsonProperty("password")
    private String password;

    @JsonProperty("remember")
    private Boolean remember;
}
