package com.dsl.FindMyBus2;

import com.dsl.FindMyBus2.dao.BusDao;
import com.dsl.FindMyBus2.dao.BusJourneyDao;
import com.dsl.FindMyBus2.dto.Bus;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.dsl.FindMyBus2.dto.BusJourney;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;


import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller {

    @Autowired
    BusDao busdao;

    @Autowired
    BusJourneyDao busjourneydao;

	
	@GetMapping("/getBus")
	public String home() throws JsonProcessingException{
      
            ObjectMapper objectMapper = new ObjectMapper();
       
               objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
       
                List<BusJourney> bj=busjourneydao.getBusJourneyByFromAndToPoint("chennai", "villupuram");

                List<Bus> b=new ArrayList<>();

                 Iterator bji=bj.iterator();

                while(bji.hasNext()){
                    BusJourney busj=(BusJourney)bji.next();
                    b.add(busdao.getSingleBusByName(busj.getBusName()));
                }


               String arrayToJson = objectMapper.writeValueAsString(b);

               return arrayToJson; 
       
    }
    



}
