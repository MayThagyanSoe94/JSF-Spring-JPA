package com.exam.interfaces;

import java.util.List;

import com.exam.common.SystemException;
import com.exam.entity.Item;

public interface IItemService {
	public Item findById(String id);
	public void addNewItem(Item item) throws SystemException;
	public Item updateItem(Item item) throws SystemException;
	public void deleteItem(Item item) throws SystemException;
	public List<Item> findAllItem()throws SystemException;
}
