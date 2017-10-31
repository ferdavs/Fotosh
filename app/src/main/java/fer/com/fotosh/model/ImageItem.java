package fer.com.fotosh.model;

import fer.com.fotosh.model.base.BaseItem;

/**
 * Created by f on 7/18/17.
 */

public class ImageItem extends BaseItem {

    private String previewURL;
    private String webformatURL;
    private String url;

    public ImageItem() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String _url) {
        this.url = _url;
    }

    public String getPreviewURL() {
        return previewURL;
    }

    public void setPreviewURL(String previewURL) {
        this.previewURL = previewURL;
    }

    public String getWebformatURL() {
        return webformatURL;
    }

    public void setWebformatURL(String webformatURL) {
        this.webformatURL = webformatURL;
    }

}
