package com.dsl.FindMyBus2;

import com.dsl.FindMyBus2.dao.BusDao;
import com.dsl.FindMyBus2.dao.BusJourneyDao;
import com.dsl.FindMyBus2.dto.Bus;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.util.List;

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

	
	@GetMapping("/")
	public String home() throws JsonProcessingException{
      
            ObjectMapper objectMapper = new ObjectMapper();
       
               objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
       

               String arrayToJson = objectMapper.writeValueAsString(busjourneydao.getBusJourneyByFromAndToPoint("chennai", "madurai"));

               return arrayToJson; 
       
    }
    



}
