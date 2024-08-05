package com.distribuida.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.distribuida.entities.FacturaDetalle;
@Repository
public class FacturaDetalleDAOImpl implements FacturaDetalleDAO{

	//SELECT *FROM Factura --->>SQL
	//from Factura  --->>HQL
	//SELECT cl.* FROM Factura AS cl --->>> SQL
	//SELECT CL FROM Factura cl  ----HQL
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	@Transactional
	////ACTUALIZACION
	public List<FacturaDetalle> findAll(){
		//
		Session session = sessionFactory.getCurrentSession();
		
		return session.createQuery("from FacturaDetalle",FacturaDetalle.class).getResultList();
		
	}
	
	

	@Override
	@Transactional
	public FacturaDetalle findOne(int id) {
		// TODO Auto-generated method stub
		Session session =sessionFactory.getCurrentSession();
		return session.get(FacturaDetalle.class,id);
	}

	@Override
	@Transactional
	public void add(FacturaDetalle facturaDetalle) {
	Session session=sessionFactory.getCurrentSession();	// TODO Auto-generated method stub
	session.saveOrUpdate(facturaDetalle);
	
	}

	@Override
	@Transactional
	public void up(FacturaDetalle facturaDetalle) {
		Session session=sessionFactory.getCurrentSession();	// TODO Auto-generated method stub
		session.saveOrUpdate(facturaDetalle);
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional
	public void del(int id) {
		Session session=sessionFactory.getCurrentSession();
		session.delete(findOne(id));
		// TODO Auto-generated method stub

	}

}