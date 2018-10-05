package com.tonyqian.tqian1_feelsbook;

import java.util.Date;

/**
 Feeling is a class that represents a single emotion entry that the user has created. It contains
 an EMOTION, which is a string describing Love, Hate etc, a COMMENT (optional) and a DATE for when
 it was added.
 */
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
