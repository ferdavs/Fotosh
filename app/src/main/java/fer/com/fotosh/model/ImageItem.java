package fer.com.fotosh.model;

/**
 * Created by f on 7/18/17.
 */

public class ImageItem {
    private int id;
    private String url;
    private String user;
    private String previewURL;
    private String tags;
    private String webformatURL;

    public ImageItem(String s, String s1) {

    }


    public String getUser() {
        return user;
    }

    public void setUser(String auth) {
        this.user = auth;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String _url) {
        this.url = _url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPreviewURL() {
        return previewURL;
    }

    public void setPreviewURL(String previewURL) {
        this.previewURL = previewURL;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getWebformatURL() {
        return webformatURL;
    }

    public void setWebformatURL(String webformatURL) {
        this.webformatURL = webformatURL;
    }
}
