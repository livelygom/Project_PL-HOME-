package kr.or.kosta.pl.vo;

import java.util.Date;

public class Cart {
	
	private int cartNumber;
	private String customerId;
	private int storeId;
	private int itemId;
	private int cartCount;
	private Date cartDate;
	private String itemName;
	private int itemPrice;
	private int categoryId;
	private String categoryName;
	private String storeName;
	
	private int totalPrice;		//mapper에서는 못받는 자체 vo값
	
	
	public Cart(){}

	//단순 장바구니 정보
	public Cart(int cartNumber, String customerId, int storeId, int itemId, int cartCount, Date cartDate) {
		super();
		this.cartNumber = cartNumber;
		this.customerId = customerId;
		this.storeId = storeId;
		this.itemId = itemId;
		this.cartCount = cartCount;
		this.cartDate = cartDate;
	}

	//장바구니+아이템정보+카테고리 정보
	public Cart(int cartNumber, String customerId, int storeId, int itemId, int cartCount, Date cartDate,
			String itemName, int itemPrice, int categoryId, String categoryName, String storeName) {
		super();
		this.cartNumber = cartNumber;
		this.customerId = customerId;
		this.storeId = storeId;
		this.itemId = itemId;
		this.cartCount = cartCount;
		this.cartDate = cartDate;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.storeName = storeName;
		this.totalPrice = cartCount*itemPrice;
	}

	public int getCartNumber() {
		return cartNumber;
	}

	public void setCartNumber(int cartNumber) {
		this.cartNumber = cartNumber;
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

	public int getCartCount() {
		return cartCount;
	}

	public void setCartCount(int cartCount) {
		this.cartCount = cartCount;
	}

	public Date getCartDate() {
		return cartDate;
	}

	public void setCartDate(Date cartDate) {
		this.cartDate = cartDate;
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

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cartCount;
		result = prime * result + ((cartDate == null) ? 0 : cartDate.hashCode());
		result = prime * result + cartNumber;
		result = prime * result + categoryId;
		result = prime * result + ((categoryName == null) ? 0 : categoryName.hashCode());
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + itemId;
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result + itemPrice;
		result = prime * result + storeId;
		result = prime * result + ((storeName == null) ? 0 : storeName.hashCode());
		result = prime * result + totalPrice;
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
		Cart other = (Cart) obj;
		if (cartCount != other.cartCount)
			return false;
		if (cartDate == null) {
			if (other.cartDate != null)
				return false;
		} else if (!cartDate.equals(other.cartDate))
			return false;
		if (cartNumber != other.cartNumber)
			return false;
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
		if (itemId != other.itemId)
			return false;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		if (itemPrice != other.itemPrice)
			return false;
		if (storeId != other.storeId)
			return false;
		if (storeName == null) {
			if (other.storeName != null)
				return false;
		} else if (!storeName.equals(other.storeName))
			return false;
		if (totalPrice != other.totalPrice)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cart [cartNumber=" + cartNumber + ", customerId=" + customerId + ", storeId=" + storeId + ", itemId="
				+ itemId + ", cartCount=" + cartCount + ", cartDate=" + cartDate + ", itemName=" + itemName
				+ ", itemPrice=" + itemPrice + ", categoryId=" + categoryId + ", categoryName=" + categoryName
				+ ", storeName=" + storeName + ", totalPrice=" + totalPrice + "]";
	}

	
	

}
