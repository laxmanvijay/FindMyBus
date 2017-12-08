package com.dsl.FindMyBus2.dto;

import javax.persistence.*;
import javax.annotation.*;

@Entity
@Table(name="BusJourney")
public class BusJourney{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column
    private String busName;

    @Column
    private String cities;

    public int getId(){
        return this.id;
    }

    public void setid(int id){
        this.id=id;
    }

    
    public String getBusName(){
        return this.busName;
    }

    public void setBusName(String busName){
        this.busName=busName;
    }

    public String getCities(){
        return this.cities;
    }

    public void setCities(String cities){
        this.cities=cities;
    }
}

