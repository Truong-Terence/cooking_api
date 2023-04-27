package com.tp.cuisine.model;

public class Recipe {
    private Long id;
    private String name;
    private String image_url;
    private String content;
    private int duration;
    private String level;
    private Tag tag;

    public Recipe(Long id, String name, String image_url, String content, int duration, String level, Tag tag) {
        this.id = id;
        this.name = name;
        this.image_url = image_url;
        this.content = content;
        this.duration = duration;
        this.level = level;
        this.tag = tag;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImage_url() {
        return image_url;
    }

    public String getContent() {
        return content;
    }

    public int getDuration() {
        return duration;
    }

    public String getLevel() {
        return level;
    }

    public Tag getTag() {
        return tag;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }
}
