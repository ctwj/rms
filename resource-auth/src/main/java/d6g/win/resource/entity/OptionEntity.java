package d6g.win.resource.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@TableName("options")
@Data
public class OptionEntity implements Serializable {

    @TableId(value="option_id", type= IdType.AUTO)
    private Integer id;

    @TableField("option_name")
    private String optionName;

    @TableField("option_value")
    private String optionValue;

    @TableField("autoload")
    private String autoload;
}
