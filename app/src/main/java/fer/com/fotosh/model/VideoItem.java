package fer.com.fotosh.model;

import org.json.JSONException;

import java.util.Map;

import fer.com.fotosh.model.base.BaseItem;

/**
 * Created by f on 10/31/17.
 */

public class VideoItem extends BaseItem {

    private String pageURL;
    private String userImageURL;
    private Map<String, VideoObject> videos;

    public enum VideoSize {
        large, medium, small, tiny
    }

    public String getUrlForSize(VideoSize size) throws JSONException {
        if (videos == null) throw new NullPointerException("videos list is empty");

        return videos.get(size.name()).url;
    }

    public String getUrlForLarge() throws JSONException {
        return getUrlForSize(VideoSize.large);
    }

    public String getUrlForMedium() throws JSONException {
        return getUrlForSize(VideoSize.medium);
    }

    public String getUrlForSmall() throws JSONException {
        return getUrlForSize(VideoSize.small);
    }

    public String getUrlForTiny() throws JSONException {
        return getUrlForSize(VideoSize.tiny);
    }

    public String getPageURL() {
        return pageURL;
    }

    public void setPageURL(String pageURL) {
        this.pageURL = pageURL;
    }

    public String getUserImageURL() {
        return userImageURL;
    }

    public void setUserImageURL(String userImageURL) {
        this.userImageURL = userImageURL;
    }

    public Map<String, VideoObject> getVideos() {
        return videos;
    }

    public void setVideos(Map<String, VideoObject> videos) {
        this.videos = videos;
    }
}
