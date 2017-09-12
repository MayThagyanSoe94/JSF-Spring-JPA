
package com.exam.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.exam.common.DAOException;
import com.exam.common.SystemException;
import com.exam.entity.Item;
import com.exam.interfaces.IItemDAO;
import com.exam.interfaces.IItemService;

@Service(value = "ItemService")
public class ItemService implements IItemService {
	//private Logger logger = Logger.getLogger(this.getClass());

	@Resource(name = "ItemDAO")
	private IItemDAO itemDAO;

	@Transactional(propagation = Propagation.REQUIRED)
	public Item findById(String id) {
		return itemDAO.findById(id);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void addNewItem(Item item) throws SystemException {
		try {
			itemDAO.insert(item);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Item updateItem(Item item) throws SystemException {
		try {
			item= itemDAO.update(item);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return item;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteItem(Item item) throws SystemException {
		try {
		itemDAO.delete(item);
	} catch (DAOException e) {
		e.printStackTrace();
	}
		
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public List<Item> findAllItem() throws SystemException {
		List<Item> result = null;
		try {
			result = itemDAO.findAll();
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	

}
