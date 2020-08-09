package abc.wuyan.model;

public class Pri {
    private Integer id;
    private String pri_name;
    private String pri_url;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPri_name() {
        return pri_name;
    }

    public void setPri_name(String pri_name) {
        this.pri_name = pri_name;
    }

    public String getPri_url() {
        return pri_url;
    }

    public void setPri_url(String pri_url) {
        this.pri_url = pri_url;
    }

    @Override
    public String toString() {
        return "Pri{" +
                "id=" + id +
                ", pri_name='" + pri_name + '\'' +
                ", pri_url='" + pri_url + '\'' +
                '}';
    }
}
