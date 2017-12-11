package com.dsl.FindMyBus2.dao;

import com.dsl.FindMyBus2.dto.BusJourney;

import java.util.List;


public interface BusJourneyDao{


    boolean createBusJourney(BusJourney bj);
    boolean updateBusJourney(BusJourney bj);
    boolean deleteBusJourney(BusJourney bj);


    List<BusJourney> getBusByCityName(String cityName);
    List<BusJourney> getCities(String name);
    BusJourney getBusJourneyById(int id);
    BusJourney getBusJourneyByBusName(String busName);
    List<BusJourney> getBusJourneyByFromAndToPoint(String from,String to);
   
}










