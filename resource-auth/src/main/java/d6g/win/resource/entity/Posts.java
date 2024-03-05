package d6g.win.resource.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author ctwj
 * @since 2024-03-05
 */

public class Posts implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long postAuthor;

    private LocalDateTime postDate;

    private LocalDateTime postDateGmt;

    private String postTitle;

    private String postContent;

    private String postExcerpt;

    private String commentStatus;

    private String postPassword;

    private String postName;

    private LocalDateTime postModified;

    private LocalDateTime postModifiedGmt;

    private String postMimeType;

    private Integer commentCount;

    private String postPrice;

    private String postType;

    private Integer postParent;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPostAuthor() {
        return postAuthor;
    }

    public void setPostAuthor(Long postAuthor) {
        this.postAuthor = postAuthor;
    }

    public LocalDateTime getPostDate() {
        return postDate;
    }

    public void setPostDate(LocalDateTime postDate) {
        this.postDate = postDate;
    }

    public LocalDateTime getPostDateGmt() {
        return postDateGmt;
    }

    public void setPostDateGmt(LocalDateTime postDateGmt) {
        this.postDateGmt = postDateGmt;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public String getPostExcerpt() {
        return postExcerpt;
    }

    public void setPostExcerpt(String postExcerpt) {
        this.postExcerpt = postExcerpt;
    }

    public String getCommentStatus() {
        return commentStatus;
    }

    public void setCommentStatus(String commentStatus) {
        this.commentStatus = commentStatus;
    }

    public String getPostPassword() {
        return postPassword;
    }

    public void setPostPassword(String postPassword) {
        this.postPassword = postPassword;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public LocalDateTime getPostModified() {
        return postModified;
    }

    public void setPostModified(LocalDateTime postModified) {
        this.postModified = postModified;
    }

    public LocalDateTime getPostModifiedGmt() {
        return postModifiedGmt;
    }

    public void setPostModifiedGmt(LocalDateTime postModifiedGmt) {
        this.postModifiedGmt = postModifiedGmt;
    }

    public String getPostMimeType() {
        return postMimeType;
    }

    public void setPostMimeType(String postMimeType) {
        this.postMimeType = postMimeType;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public String getPostPrice() {
        return postPrice;
    }

    public void setPostPrice(String postPrice) {
        this.postPrice = postPrice;
    }

    public String getPostType() {
        return postType;
    }

    public void setPostType(String postType) {
        this.postType = postType;
    }

    public Integer getPostParent() {
        return postParent;
    }

    public void setPostParent(Integer postParent) {
        this.postParent = postParent;
    }

    @Override
    public String toString() {
        return "Posts{" +
            "id = " + id +
            ", postAuthor = " + postAuthor +
            ", postDate = " + postDate +
            ", postDateGmt = " + postDateGmt +
            ", postTitle = " + postTitle +
            ", postContent = " + postContent +
            ", postExcerpt = " + postExcerpt +
            ", commentStatus = " + commentStatus +
            ", postPassword = " + postPassword +
            ", postName = " + postName +
            ", postModified = " + postModified +
            ", postModifiedGmt = " + postModifiedGmt +
            ", postMimeType = " + postMimeType +
            ", commentCount = " + commentCount +
            ", postPrice = " + postPrice +
            ", postType = " + postType +
            ", postParent = " + postParent +
        "}";
    }
}
