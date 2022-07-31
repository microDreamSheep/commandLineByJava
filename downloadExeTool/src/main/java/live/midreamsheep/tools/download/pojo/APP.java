package live.midreamsheep.tools.download.pojo;


public class APP {
    private String name;
    private String url;

    public APP() {
    }

    public APP(String name, String url) {
        this.name = name;
        this.url = url;
    }

    @Override
    public String toString() {
        return "APP{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
