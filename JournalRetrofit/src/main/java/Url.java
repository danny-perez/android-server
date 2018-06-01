
public enum Url {
    ECONAMICS("economics.json"),
    PHYSICS("mathematical.json"),
    MATHEMATICAL("physics.json");

    public static final String BASE_URL = "https://dl.dropboxusercontent.com/u/17192683/rest/journals/";
    private String url;
    Url(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
