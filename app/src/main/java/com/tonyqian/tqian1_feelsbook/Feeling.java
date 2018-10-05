package com.tonyqian.tqian1_feelsbook;

import java.util.Date;

public class Feeling {
    private String emotion;
    private String comment;
    private Date date;

    public Feeling (String emotion, String comment, Date date) {
        this.emotion = emotion;
        this.comment = comment;
        this.date = date;
    }

    public String getEmotion() {
        return emotion;
    }

    public void setEmotion(String emotion) {
        this.emotion = emotion;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
