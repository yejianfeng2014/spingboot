package com.example.demo.entry;

public class Email {



    private  int id;

    private  String title;


    private  String content;


    private String beizhu;


    private  String biaoji;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBeizhu() {
        return beizhu;
    }

    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu;
    }

    public String getBiaoji() {
        return biaoji;
    }

    public void setBiaoji(String biaoji) {
        this.biaoji = biaoji;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Email{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", beizhu='" + beizhu + '\'' +
                ", biaoji='" + biaoji + '\'' +
                '}';
    }
}
