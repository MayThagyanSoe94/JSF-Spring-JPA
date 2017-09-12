package com.exam.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.exam.common.DAOException;
import com.exam.entity.Item;
import com.exam.interfaces.IItemDAO;
@Repository("ItemDAO")
public class ItemDAO implements IItemDAO{

	@PersistenceContext(name = "JPA")
	protected EntityManager em;
	
	private Logger logger = Logger.getLogger(this.getClass());
	@Transactional(propagation = Propagation.REQUIRED)
	public void insert(Item item) throws DAOException {
		try {
			logger.debug("insert() method has been started.");
			em.persist(item);
			em.flush();
			logger.debug("insert() method has been successfully finisehd.");
		} catch (PersistenceException pe) {
			logger.error("insert() method has been failed.", pe);
			throw new DAOException("Failed to insert Item", pe);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Item update(Item item) throws DAOException {
		try {
			logger.debug("update() method has been started.");
			em.merge(item);
			em.flush();
			logger.debug("update() method has been successfully finisehd.");
		} catch (PersistenceException pe) {
			logger.error("update() method has been failed.", pe);
			throw new DAOException("Failed to insert Item", pe);
		}
		return item;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Item delete(Item item) throws DAOException {
		try {
			logger.debug("delete() method has been started.");
			item = em.merge(item);
			em.remove(item);
			em.flush();
			logger.debug("delete() method has been successfully finisehd.");
		} catch (PersistenceException pe) {
			logger.error("delete() method has been failed.", pe);
			throw new DAOException("Failed to insert Item", pe);
		}
		return item;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public List<Item> findAll() throws DAOException {
		List<Item> result = null;
		try {
			logger.debug("findAll() method has been started.");
			Query query = em.createNamedQuery("Item.findAll");
			result = query.getResultList();
			em.flush();
			logger.debug("findAll() method has been successfully finisehd.");
		} catch (PersistenceException pe) {
			logger.error("findAll() method has been failed.", pe);
			throw new DAOException("Failed to insert Item", pe);
		}
		return result;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Item findById(String id) {
		return em.find(Item.class, id);
	}

}
