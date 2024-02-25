package com.shmelev.iptv;

import java.io.Serializable;

public class Channel implements Serializable {

    String name;
    String image;
    String url;

    public Channel(String name, String image, String url) {
        this.name = name;
        this.image = image;
        this.url = url;
    }

}
