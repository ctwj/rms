package d6g.win.resource.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import d6g.win.resource.contants.UserStatus;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@TableName("users")
@Data
public class UserEntity implements Serializable {

    @TableId(value="id", type= IdType.AUTO)
    private Integer id;

    @TableField(exist = false)
    private List<UserMetaEntity> metaEntities;

    @TableField("user_login")
    @JsonProperty("userLogin")
    private String userLogin;

    @TableField("user_pass")
    @JsonProperty("userPass")
    private String userPass;

    @TableField("user_nickname")
    private String userNickname;

    @TableField("user_phone")
    private String userPhone;

    @TableField("user_email")
    private String userEmail;

    @TableField(value = "user_url")
    private String userUrl;

    @TableField(value = "user_registered")
    private LocalDateTime userRegistered;

    @TableField("user_activation_key")
    private String userActivationKey;

    @TableField("user_status")
    private UserStatus userStatus;

    @TableField("display_name")
    private String displayName;

}
