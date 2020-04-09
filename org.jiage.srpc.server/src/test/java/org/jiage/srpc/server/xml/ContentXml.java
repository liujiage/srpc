package org.jiage.srpc.server.xml;

import java.util.List;

public class ContentXml {

    private List<String> texts;
    private List<String> images;
    private List<String> videos;

    public ContentXml() {
    }

    public ContentXml(List<String> texts, List<String> images, List<String> videos) {
        this.texts = texts;
        this.images = images;
        this.videos = videos;
    }

    public List<String> getTexts() {
        return texts;
    }

    public void setTexts(List<String> texts) {
        this.texts = texts;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public List<String> getVideos() {
        return videos;
    }

    public void setVideos(List<String> videos) {
        this.videos = videos;
    }
}
