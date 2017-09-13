package com.exam.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.exam.common.TableName;

@SuppressWarnings("serial")
@Entity
@Table(name = TableName.ITEM)
@TableGenerator(name = "ITEM_GEN", table = "ID_GEN", pkColumnName = "GEN_ITEM", valueColumnName = "GEN_VAL", pkColumnValue = "ITEM_GEN", allocationSize = 10)
@NamedQueries(value = {
		@NamedQuery(name = "Item.findAll", query = "SELECT i FROM Item i "),
		@NamedQuery(name = "Item.findById", query = "SELECT i FROM Item i WHERE i.id = :id") })
@Access(value = AccessType.FIELD)
public class Item implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private String id;
	private String name;
	private String category;
	private String brand;
	private String description;
	private String serialNo;
	private int totalQty;
	private double buyingPrice;
	private double sellingPrice;
	@Temporal(TemporalType.DATE)
	private Date date;
	private String bestSeller="Yes";
	
	public Item() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public int getTotalQty() {
		return totalQty;
	}

	public void setTotalQty(int totalQty) {
		this.totalQty = totalQty;
	}

	public double getBuyingPrice() {
		return buyingPrice;
	}

	public void setBuyingPrice(double buyingPrice) {
		this.buyingPrice = buyingPrice;
	}

	public double getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getBestSeller() {
		return bestSeller;
	}

	public void setBestSeller(String bestSeller) {
		this.bestSeller = bestSeller;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", category=" + category + ", brand=" + brand + ", description="
				+ description + ", serialNo=" + serialNo + ", totalQty=" + totalQty + ", buyingPrice=" + buyingPrice
				+ ", sellingPrice=" + sellingPrice + ", date=" + date + ", bestSeller=" + bestSeller + "]";
	}
	
	
}
