package com.dsl.FindMyBus2.dto;

public class SearchQuery{

    private String from;
    private String to;

    public String getFrom(){
        return this.from;
    }
    public void setFrom(String from){
        this.from=from;
    }

    public String getTo(){
        return this.to;
    }
    public void setTo(String to){
        this.to=to;
    }

}