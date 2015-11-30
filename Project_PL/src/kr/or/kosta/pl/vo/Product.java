package kr.or.kosta.pl.vo;

import java.io.Serializable;
import java.util.Date;

public class Product implements Serializable {

	private int itemId;
	private String itemName;
	private int itemPrice;
	private int categoryId;
	private String categoryName;
	private int storeId;
	private Date itemExpirationDate;
	private int itemCount;
	private int serverIndex;

	public Product() {
	}

	public Product(int itemId, String itemName, int itemPrice, int categoryId, String categoryName) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}

	public Product(int itemId, String itemName, int itemPrice, int categoryId, String categoryName, int storeId,
			Date itemExpirationDate, int itemCount, int serverIndex) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.storeId = storeId;
		this.itemExpirationDate = itemExpirationDate;
		this.itemCount = itemCount;
		this.serverIndex = serverIndex;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getcategoryName() {
		return categoryName;
	}

	public void setcategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public Date getItemExpirationDate() {
		return itemExpirationDate;
	}

	public void setItemExpirationDate(Date itemExpirationDate) {
		this.itemExpirationDate = itemExpirationDate;
	}

	public int getItemCount() {
		return itemCount;
	}

	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}

	public int getServerIndex() {
		return serverIndex;
	}

	public void setServerIndex(int serverIndex) {
		this.serverIndex = serverIndex;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + categoryId;
		result = prime * result + ((categoryName == null) ? 0 : categoryName.hashCode());
		result = prime * result + itemCount;
		result = prime * result + ((itemExpirationDate == null) ? 0 : itemExpirationDate.hashCode());
		result = prime * result + itemId;
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result + itemPrice;
		result = prime * result + serverIndex;
		result = prime * result + storeId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (categoryId != other.categoryId)
			return false;
		if (categoryName == null) {
			if (other.categoryName != null)
				return false;
		} else if (!categoryName.equals(other.categoryName))
			return false;
		if (itemCount != other.itemCount)
			return false;
		if (itemExpirationDate == null) {
			if (other.itemExpirationDate != null)
				return false;
		} else if (!itemExpirationDate.equals(other.itemExpirationDate))
			return false;
		if (itemId != other.itemId)
			return false;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		if (itemPrice != other.itemPrice)
			return false;
		if (serverIndex != other.serverIndex)
			return false;
		if (storeId != other.storeId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Product [itemId=" + itemId + ", itemName=" + itemName + ", itemPrice=" + itemPrice + ", categoryId="
				+ categoryId + ", categoryName=" + categoryName + ", storeId=" + storeId + ", itemExpirationDate="
				+ itemExpirationDate + ", itemCount=" + itemCount + ", serverIndex=" + serverIndex + "]";
	}

}