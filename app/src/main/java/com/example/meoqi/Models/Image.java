package com.example.meoqi.Models;

public class Image {
    String height,width,url;

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Image{" +
                "height='" + height + '\'' +
                ", width='" + width + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
