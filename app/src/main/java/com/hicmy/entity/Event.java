package com.hicmy.entity;

import java.io.Serializable;

/**
 * Created by guangyuyang on 04/07/2017.
 */

public class Event implements Serializable {
    private static final long serialVersionUID=1L;
    private int id;
    private String title;
    private String content;
    public Event(int s_id,String s_title,String s_content){
        id=s_id;
        title=s_title;
        content=s_content;
    }

    public String getTitle(){
        return title;
    }

    public String getContent(){
        return content;
    }

    public int getId(){
        return id;
    }

    public void setTitle(String s_title){
        title=s_title;
    }

    public void setContent(String s_content){
        content=s_content;
    }

    public void setId(int s_id){
        id=s_id;
    }
}
