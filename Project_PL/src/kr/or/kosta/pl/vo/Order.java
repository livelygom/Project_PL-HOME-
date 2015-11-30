package kr.or.kosta.pl.vo;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable{
	
	private int orderNumber;
	private String customerId;
	private int storeId;
	private int itemId;
	private int orderCount;
	private Date orderDate;
	private int orderStatus;
	private String itemName;
	private int itemPrice;
	private int categoryId;
	private String categoryName;
	private String storeName;
	private String customerName;
	private String customerPhone;
	
	public Order() {}

	//주문 테이블만의 생성자
	public Order(int orderNumber, String customerId, int storeId, int itemId, int orderCount, Date orderDate,
			int orderStatus) {
		super();
		this.orderNumber = orderNumber;
		this.customerId = customerId;
		this.storeId = storeId;
		this.itemId = itemId;
		this.orderCount = orderCount;
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
	}

	//아이템 정보와 카테고리, 상점이름, 고객이름&전번까지 모두 담은 생성자
	public Order(int orderNumber, String customerId, int storeId, int itemId, int orderCount, Date orderDate,
			int orderStatus, String itemName, int itemPrice, int categoryId, String categoryName, String storeName,
			String customerName, String customerPhone) {
		super();
		this.orderNumber = orderNumber;
		this.customerId = customerId;
		this.storeId = storeId;
		this.itemId = itemId;
		this.orderCount = orderCount;
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.storeName = storeName;
		this.customerName = customerName;
		this.customerPhone = customerPhone;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getOrderCount() {
		return orderCount;
	}

	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public int getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
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

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + categoryId;
		result = prime * result + ((categoryName == null) ? 0 : categoryName.hashCode());
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((customerName == null) ? 0 : customerName.hashCode());
		result = prime * result + ((customerPhone == null) ? 0 : customerPhone.hashCode());
		result = prime * result + itemId;
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result + itemPrice;
		result = prime * result + orderCount;
		result = prime * result + ((orderDate == null) ? 0 : orderDate.hashCode());
		result = prime * result + orderNumber;
		result = prime * result + orderStatus;
		result = prime * result + storeId;
		result = prime * result + ((storeName == null) ? 0 : storeName.hashCode());
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
		Order other = (Order) obj;
		if (categoryId != other.categoryId)
			return false;
		if (categoryName == null) {
			if (other.categoryName != null)
				return false;
		} else if (!categoryName.equals(other.categoryName))
			return false;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (customerName == null) {
			if (other.customerName != null)
				return false;
		} else if (!customerName.equals(other.customerName))
			return false;
		if (customerPhone == null) {
			if (other.customerPhone != null)
				return false;
		} else if (!customerPhone.equals(other.customerPhone))
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
		if (orderCount != other.orderCount)
			return false;
		if (orderDate == null) {
			if (other.orderDate != null)
				return false;
		} else if (!orderDate.equals(other.orderDate))
			return false;
		if (orderNumber != other.orderNumber)
			return false;
		if (orderStatus != other.orderStatus)
			return false;
		if (storeId != other.storeId)
			return false;
		if (storeName == null) {
			if (other.storeName != null)
				return false;
		} else if (!storeName.equals(other.storeName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Order [orderNumber=" + orderNumber + ", customerId=" + customerId + ", storeId=" + storeId + ", itemId="
				+ itemId + ", orderCount=" + orderCount + ", orderDate=" + orderDate + ", orderStatus=" + orderStatus
				+ ", itemName=" + itemName + ", itemPrice=" + itemPrice + ", categoryId=" + categoryId
				+ ", categoryName=" + categoryName + ", storeName=" + storeName + ", customerName=" + customerName
				+ ", customerPhone=" + customerPhone + "]";
	}

	
	

}
