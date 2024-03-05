package d6g.win.resource.contants;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

@Getter
public enum UserStatus {

    OK(0, "正常"),
    NeedActivation(1, "需要激活"),
    Forbit(2, "被禁用");

    @EnumValue
    private Integer user_status;

    private String comment;

    UserStatus(Integer user_status, String comment) {
        this.user_status = user_status;
        this.comment = comment;
    }

}
