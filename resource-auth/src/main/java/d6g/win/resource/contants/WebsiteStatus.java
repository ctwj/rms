package d6g.win.resource.contants;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

@Getter
public enum WebsiteStatus {
    Normal("normal", "正常"),
    Maintain("maintain", "website 正在维护中"),
    Close("close", "website 已关闭");

    @EnumValue
    private String status;

    private String comment;

    WebsiteStatus(String status, String comment) {
        this.status = status;
        this.comment = comment;
    }
}
