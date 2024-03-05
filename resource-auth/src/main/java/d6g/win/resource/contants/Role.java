package d6g.win.resource.contants;

public enum Role {

    Administrator("administrator", "管理员"),
    Author("author", "作者"),
    Viewer("viewer", "访问者");

    private String role;
    private String comment;

    Role(String role, String comment) {
        this.role = role;
        this.comment = comment;
    }
}
