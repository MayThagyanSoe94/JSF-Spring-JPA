package com.exam.interfaces;

import java.util.List;

import com.exam.common.DAOException;
import com.exam.entity.Item;

public interface IItemDAO {
	public void insert(Item item) throws DAOException;
	public Item update(Item item) throws DAOException;
	public Item delete(Item item) throws DAOException;
	public List<Item> findAll()throws DAOException;
	public Item findById(String id);
}
