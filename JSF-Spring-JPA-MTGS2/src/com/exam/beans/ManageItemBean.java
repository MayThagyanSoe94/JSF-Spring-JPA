package com.exam.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import com.exam.common.SystemException;
import com.exam.entity.Item;
import com.exam.interfaces.IItemService;

@ManagedBean(name = "ManageItemBean")
@SessionScoped
public class ManageItemBean {
	@ManagedProperty("#{ItemService}")
	private IItemService itemService;
	private Item item;
	private boolean createNew;
	private int stockIn;
	private int stockOut;
	private List<Item> itemList;

	@PostConstruct
	public void init() {
		prepareForAdd();
		itemList = itemService.findAllItem();
	}

	public void prepareForAdd() {
		item = new Item();
		createNew = true;		
	}

	public void prepareForUpdate(Item item) {
		this.item = item;
		createNew = false;		
	}

	public void add() {
		try {
				itemService.addNewItem(item);
				String message = item.getName() + " have been added";
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, message, null));
				prepareForAdd();
				itemList = itemService.findAllItem();
		} catch (SystemException ex) {
			ex.printStackTrace();
			String message = "Failed to add Item (" + item.getName() + "(";
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));
		}
	}
	
	public void updateItem() {
		try {
				System.out.println("UpdateItem Enter");
				int total = (item.getTotalQty() + stockIn) - stockOut;
				System.out.println("TotalQty : " + item.getTotalQty());
				System.out.println("Stock In : " + stockIn);
				System.out.println("Stock Out : " + stockOut);
				item.setTotalQty(total);
				System.out.println("Final Total : "+total);
				itemService.updateItem(item);
				itemList = itemService.findAllItem();
				stockIn = 0;
				stockOut = 0;
				String message = item.getName() + " have been updated";
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, message, null));
				prepareForAdd();
				
		} catch (SystemException ex) {
			ex.printStackTrace();
			String message = "Failed to update Item (" + item.getName() + "(";
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));
		}
	}

	public void deleteItem(Item item) {
		try {
			itemService.deleteItem(item);
			String message = item.getName() + " have been deleted";
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, message, null));
			prepareForAdd();
			itemList = itemService.findAllItem();
		} catch (SystemException ex) {
			ex.printStackTrace();
			String message = "Failed to delete Item (" + item.getName() + "(";
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));
		}
	}

	public IItemService getItemService() {
		return itemService;
	}

	public void setItemService(IItemService itemService) {
		this.itemService = itemService;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public void setCreateNew(boolean createNew) {
		this.createNew = createNew;
	}

	public boolean isCreateNew() {
		return createNew;
	}

	public int getStockIn() {
		return stockIn;
	}

	public void setStockIn(int stockIn) {
		this.stockIn = stockIn;
	}

	public int getStockOut() {
		return stockOut;
	}

	public void setStockOut(int stockOut) {
		this.stockOut = stockOut;
	}
	/*public List<Item> getItemList() {
		return itemService.findAllItem();
	}*/

	
	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}

	public List<Item> getItemList() {
		return itemList;
	}

}
