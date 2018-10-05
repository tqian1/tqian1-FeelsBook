package com.tonyqian.tqian1_feelsbook;

import java.util.Date;

/**
 Feeling is a class that represents a single emotion entry that the user has created. It contains
 an EMOTION, which is a string describing Love, Hate etc, a COMMENT (optional) and a DATE for when
 it was added. The class implements Comparable and has a custom comparator so that the
 ViewFeelingsActivity can display the Feelings in sorted order by Date.
 */
public class Feeling implements Comparable<Feeling> {
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

    @Override
    public int compareTo(Feeling f) {
        return getDate().compareTo(f.getDate());
    }
}
