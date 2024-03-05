package d6g.win.resource.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author ctwj
 * @since 2024-03-05
 */
public class Postmeta implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "meta_id", type = IdType.AUTO)
    private Long metaId;

    private Long postId;

    private String metaKey;

    private String metaValue;

    public Long getMetaId() {
        return metaId;
    }

    public void setMetaId(Long metaId) {
        this.metaId = metaId;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getMetaKey() {
        return metaKey;
    }

    public void setMetaKey(String metaKey) {
        this.metaKey = metaKey;
    }

    public String getMetaValue() {
        return metaValue;
    }

    public void setMetaValue(String metaValue) {
        this.metaValue = metaValue;
    }

    @Override
    public String toString() {
        return "Postmeta{" +
            "metaId = " + metaId +
            ", postId = " + postId +
            ", metaKey = " + metaKey +
            ", metaValue = " + metaValue +
        "}";
    }
}
