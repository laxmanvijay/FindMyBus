package com.dsl.FindMyBus2.dto;


import javax.annotation.Generated;
import javax.persistence.*;

@Entity
@Table(name="bus")
public class Bus{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column
    private String busName;

    @Column
    private String startPoint;

    @Column
    private String endPoint;

    @Column
    private boolean availability;

    @Column
    private int costFactor;

    @Column
    private int no_of_seats;


    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id=id;
    }

    public int getCostFactor(){
        return this.costFactor;
    }

    public void setNo_of_seats(int no_of_seats){
        this.no_of_seats=no_of_seats;
    }

    public int getNo_of_seats(){
        return this.no_of_seats;
    }

    public void setCostFactor(int costFactor){
        this.costFactor=costFactor;
    }

    public String getStartPoint(){
        return this.startPoint;
    }
    public void setStartPoint(String startPoint){
        this.startPoint=startPoint;
    }

    public String getBusName(){
        return this.busName;
    }
    public void setBusName(String busName){
        this.busName=busName;
    }

    public String getEndPoint(){
        return this.endPoint;
    }

    public void setEndPoint(String endPoint){
        this.endPoint=endPoint;
    }

    public boolean getAvailability(){
        return this.availability;
    }
    public void setAvailability(boolean availability){
        this.availability=availability;
    }


}

