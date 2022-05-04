package com.example.recyclerview2;

public class Item {
    private String titleKor;
    private String titleEng;
    private int imgId;

    public Item(String titleKor, String titleEng, int imgId) {
        this.titleKor = titleKor;
        this.titleEng = titleEng;
        this.imgId = imgId;
    }

    public String getTitleKor() {
        return titleKor;
    }

    public void setTitleKor(String titleKor) {
        this.titleKor = titleKor;
    }

    public String getTitleEng() {
        return titleEng;
    }

    public void setTitleEng(String titleEng) {
        this.titleEng = titleEng;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }
}
