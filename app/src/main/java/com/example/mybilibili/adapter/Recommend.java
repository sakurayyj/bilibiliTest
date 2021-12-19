package com.example.mybilibili.adapter;

public class Recommend {
    private int id1;
    private String txt1;
    private int id2;
    private String txt2;
    private int id3;
    private String txt3;

    public Recommend(int id1,String txt1,int id2,String txt2,int id3,String txt3){
        this.id1 = id1;
        this.txt1 = txt1;
        this.id2 = id2;
        this.txt2 = txt2;
        this.id3 = id3;
        this.txt3 = txt3;
    }

    public int getId1() {
        return id1;
    }

    public void setId1(int id1) {
        this.id1 = id1;
    }

    public String getTxt1() {
        return txt1;
    }

    public void setTxt1(String txt1) {
        this.txt1 = txt1;
    }

    public int getId2() {
        return id2;
    }

    public void setId2(int id2) {
        this.id2 = id2;
    }

    public String getTxt2() {
        return txt2;
    }

    public void setTxt2(String txt2) {
        this.txt2 = txt2;
    }

    public int getId3() {
        return id3;
    }

    public void setId3(int id3) {
        this.id3 = id3;
    }

    public String getTxt3() {
        return txt3;
    }

    public void setTxt3(String txt3) {
        this.txt3 = txt3;
    }
}
