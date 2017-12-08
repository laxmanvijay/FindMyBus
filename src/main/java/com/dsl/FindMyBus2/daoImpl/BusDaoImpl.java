package com.dsl.FindMyBus2.daoImpl;


import javax.persistence.*;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.dsl.FindMyBus2.dao.BusDao;
import com.dsl.FindMyBus2.dto.Bus;
import java.util.List;

@Transactional
@Repository
public class BusDaoImpl implements BusDao{


    @PersistenceContext
    private EntityManager em;


	@Override
	public boolean createBus(Bus b) {
        try {

            em.persist(b);
            return true;
        } catch (Exception e) {
        return false;
        }
	}

	@Override
	public boolean updateBus(Bus b) {
		try {
            em.merge(b);
            return true;
        } catch (Exception e) {
           return false;
        }
	}

	@Override
	public boolean deleteBus(Bus b) {
        try{
            em.remove(b);
            return true;
        }
        catch(Exception e){
            return false;
        }
	}


	@Override
	public Bus getSingleBusById(int id) {
       return em.find(Bus.class, id);
	}

	@Override
	public Bus getSingleBusByName(String busName) {
        String hql="FROM Bus WHERE busName=:busName";
        Query q=em.createQuery(hql);
        q.setParameter("busName",busName);
        return (Bus)q.getSingleResult();
	}

	@Override
	public List<Bus> getBusByStartPoint(String startPoint) {
        String hql="FROM Bus WHERE startPoint=:startPoint";
        Query q=em.createQuery(hql);
        q.setParameter("startPoint",startPoint);
        return q.getResultList();
    }

	@Override
	public List<Bus> getBusByEndPoint(String endPoint) {
        String hql="FROM Bus WHERE endPoint=:endPoint";
        Query q=em.createQuery(hql);
        q.setParameter("endPoint",endPoint);
        return q.getResultList();
	}
}