package com.example.lv_music.Model;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class SongItem {

    private String id;
    private String name;
    private String image;
    private String link;
    private List<String> lst_singer_names = null; // dùng jsonschemapojo => tên sai lstSingerNames... (nếu xóa đi serialize)

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public List<String> getLstSingerNames() {
        return lst_singer_names;
    }

    public void setLstSingerNames(List<String> lstSingerNames) {
        this.lst_singer_names = lstSingerNames;
    }

    @Override
    public String toString() {
        return "SongItem{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", link='" + link + '\'' +
                ", lst_singer_names=" + lst_singer_names +
                '}';
    }
}