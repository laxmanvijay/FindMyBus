package com.dsl.FindMyBus2.dao;


import com.dsl.FindMyBus2.dto.Bus;
import java.util.*;

public interface BusDao{


    boolean createBus(Bus b);
    boolean updateBus(Bus b);
    boolean deleteBus(Bus b);

    Bus getSingleBusById(int id);
    Bus getSingleBusByName(String busName);
    List<Bus> getBusByStartPoint(String startPoint);
    List<Bus> getBusByEndPoint(String endPoint);



}