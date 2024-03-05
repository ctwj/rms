package d6g.win.resource.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@TableName("usermeta")
@Data
public class UserMetaEntity implements Serializable {
    @TableId(value="meta_id", type= IdType.AUTO)
    private Integer id;

    @TableField("user_id")
    private Integer userId;

    @TableField("meta_key")
    private String metaKey;

    @TableField("meta_value")
    private String metaValue;
}
