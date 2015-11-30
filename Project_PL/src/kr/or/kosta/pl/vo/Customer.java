package kr.or.kosta.pl.vo;

public class Customer {
	
	private String customerId;
	private String customerPassword;
	private String customerName;
	private String customerAddress;
	private String customerBirth;
	private int customerGender;
	private String customerPhone;
	private String customerEmail;
	private int customerPoint;
	private int storeId;
	
	public Customer(){}
	
	

	public Customer(String customerId, String customerPassword, String customerName, String customerAddress,
			String customerBirth, int customerGender, String customerPhone, String customerEmail) {
		super();
		this.customerId = customerId;
		this.customerPassword = customerPassword;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.customerBirth = customerBirth;
		this.customerGender = customerGender;
		this.customerPhone = customerPhone;
		this.customerEmail = customerEmail;
		this.customerPoint = 0;
		this.storeId = 0;
	}



	public Customer(String customerId, String customerPassword, String customerName, String customerAddress,
			String customerBirth, int customerGender, String customerPhone, String customerEmail, int customerPoint) {
		this.customerId = customerId;
		this.customerPassword = customerPassword;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.customerBirth = customerBirth;
		this.customerGender = customerGender;
		this.customerPhone = customerPhone;
		this.customerEmail = customerEmail;
		this.customerPoint = customerPoint;
		this.storeId = 0;
	}

	public Customer(String customerId, String customerPassword, String customerName, String customerAddress,
			String customerBirth, int customerGender, String customerPhone, String customerEmail, int customerPoint,
			int storeId) {
		super();
		this.customerId = customerId;
		this.customerPassword = customerPassword;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.customerBirth = customerBirth;
		this.customerGender = customerGender;
		this.customerPhone = customerPhone;
		this.customerEmail = customerEmail;
		this.customerPoint = customerPoint;
		this.storeId = storeId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerBirth() {
		return customerBirth;
	}

	public void setCustomerBirth(String customerBirth) {
		this.customerBirth = customerBirth;
	}

	public int getCustomerGender() {
		return customerGender;
	}

	public void setCustomerGender(int customerGender) {
		this.customerGender = customerGender;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public int getCustomerPoint() {
		return customerPoint;
	}

	public void setCustomerPoint(int customerPoint) {
		this.customerPoint = customerPoint;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerAddress == null) ? 0 : customerAddress.hashCode());
		result = prime * result + ((customerBirth == null) ? 0 : customerBirth.hashCode());
		result = prime * result + ((customerEmail == null) ? 0 : customerEmail.hashCode());
		result = prime * result + customerGender;
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((customerName == null) ? 0 : customerName.hashCode());
		result = prime * result + ((customerPassword == null) ? 0 : customerPassword.hashCode());
		result = prime * result + ((customerPhone == null) ? 0 : customerPhone.hashCode());
		result = prime * result + customerPoint;
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
		Customer other = (Customer) obj;
		if (customerAddress == null) {
			if (other.customerAddress != null)
				return false;
		} else if (!customerAddress.equals(other.customerAddress))
			return false;
		if (customerBirth == null) {
			if (other.customerBirth != null)
				return false;
		} else if (!customerBirth.equals(other.customerBirth))
			return false;
		if (customerEmail == null) {
			if (other.customerEmail != null)
				return false;
		} else if (!customerEmail.equals(other.customerEmail))
			return false;
		if (customerGender != other.customerGender)
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
		if (customerPassword == null) {
			if (other.customerPassword != null)
				return false;
		} else if (!customerPassword.equals(other.customerPassword))
			return false;
		if (customerPhone == null) {
			if (other.customerPhone != null)
				return false;
		} else if (!customerPhone.equals(other.customerPhone))
			return false;
		if (customerPoint != other.customerPoint)
			return false;
		if (storeId != other.storeId)
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerPassword=" + customerPassword + ", customerName="
				+ customerName + ", customerAddress=" + customerAddress + ", customerBirth=" + customerBirth
				+ ", customerGender=" + customerGender + ", customerPhone=" + customerPhone + ", customerEmail="
				+ customerEmail + ", customerPoint=" + customerPoint + ", storeId=" + storeId + "]";
	}
	
	
	
	
	
	

}
