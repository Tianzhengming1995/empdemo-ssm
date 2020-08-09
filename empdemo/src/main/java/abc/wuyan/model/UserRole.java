package abc.wuyan.model;

public class UserRole {
    private Integer user_Id;
    private Integer role_Id;

    public Integer getUser_Id() {
        return user_Id;
    }

    public void setUser_Id(Integer user_Id) {
        this.user_Id = user_Id;
    }

    public Integer getRole_Id() {
        return role_Id;
    }

    public void setRole_Id(Integer role_Id) {
        this.role_Id = role_Id;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "user_Id=" + user_Id +
                ", role_Id=" + role_Id +
                '}';
    }
}
