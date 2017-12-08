package com.dsl.FindMyBus2.daoImpl;

import com.dsl.FindMyBus2.dao.BusJourneyDao;
import com.dsl.FindMyBus2.dto.BusJourney;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;



@Repository
@Transactional
public class BusJourneyDaoImpl implements BusJourneyDao{


    @PersistenceContext
    private EntityManager em;


	@Override
	public boolean createBusJourney(BusJourney bj) {
		try {

            em.persist(bj);
            return true;
        } catch (Exception e) {
           return false;
        }
	}

	@Override
	public boolean updateBusJourney(BusJourney bj) {
		try {
            em.merge(bj);
            return true;
        } catch (Exception e) {
           return false;
        }
	}

	@Override
	public boolean deleteBusJourney(BusJourney bj) {
	try {
        em.remove(bj);
        return true;
    } catch (Exception e) {
       return false;
    }
	}

	@Override
	public List<BusJourney> getBusByCityName(String cityName) {
        String hql="FROM BusJourney WHERE cities=:cities";
        Query q=em.createQuery(hql);
        q.setParameter("cities",cityName);
        return q.getResultList();
    }

	@Override
	public BusJourney getBusJourneyById(int id) {
		return (BusJourney)em.find(BusJourney.class, id);
	}

	@Override
	public BusJourney getBusJourneyByBusName(String busName) {
        String hql="FROM BusJourney WHERE busName=:busName";
        Query q=em.createQuery(hql);
        q.setParameter("busName",busName);
        return (BusJourney)q.getSingleResult();
    }
    
    public List<BusJourney> getBusJourneyByFromAndToPoint(String from,String to){
        String hql="FROM BusJourney WHERE cities=:cities";
        Query q=em.createQuery(hql);
        q.setParameter("cities",from);
        List<BusJourney> start= q.getResultList();

      
        q.setParameter("cities",to);
        List<BusJourney> end = q.getResultList();

        Iterator starti=start.iterator();
        Iterator endi=end.iterator();

        List<BusJourney> finalList=new ArrayList<>();

        while(starti.hasNext()&&endi.hasNext()){
            BusJourney s=(BusJourney)starti.next();
            BusJourney e=(BusJourney)endi.next();
            if(s.getBusName()==e.getBusName()){
                finalList.add(s);
            }
        }
        return finalList;
    }

}