package abc.wuyan.model;

public class Role {
    private Integer id;
    private String role_name;
    private int role_pri;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public int getRole_pri() {
        return role_pri;
    }

    public void setRole_pri(int role_pri) {
        this.role_pri = role_pri;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", role_name='" + role_name + '\'' +
                ", role_pri=" + role_pri +
                '}';
    }
}
