package kr.or.kosta.pl.vo;

import java.io.Serializable;

public class Owner implements Serializable{
	private String ownerId;
	private String ownerPassword;
	private String ownerName;
	private String ownerPhone;
	
	
	public Owner() {
		super();
	}


	public Owner(String ownerId, String ownerPassword, String ownerName, String ownerPhone) {
		super();
		this.ownerId = ownerId;
		this.ownerPassword = ownerPassword;
		this.ownerName = ownerName;
		this.ownerPhone = ownerPhone;
	}


	public String getOwnerId() {
		return ownerId;
	}


	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}


	public String getOwnerPassword() {
		return ownerPassword;
	}


	public void setOwnerPassword(String ownerPassword) {
		this.ownerPassword = ownerPassword;
	}


	public String getOwnerName() {
		return ownerName;
	}


	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}


	public String getOwnerPhone() {
		return ownerPhone;
	}


	public void setOwnerPhone(String ownerPhone) {
		this.ownerPhone = ownerPhone;
	}


	@Override
	public String toString() {
		return "Owner [ownerId=" + ownerId + ", ownerPassword=" + ownerPassword + ", ownerName=" + ownerName
				+ ", ownerPhone=" + ownerPhone + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ownerId == null) ? 0 : ownerId.hashCode());
		result = prime * result + ((ownerName == null) ? 0 : ownerName.hashCode());
		result = prime * result + ((ownerPassword == null) ? 0 : ownerPassword.hashCode());
		result = prime * result + ((ownerPhone == null) ? 0 : ownerPhone.hashCode());
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
		Owner other = (Owner) obj;
		if (ownerId == null) {
			if (other.ownerId != null)
				return false;
		} else if (!ownerId.equals(other.ownerId))
			return false;
		if (ownerName == null) {
			if (other.ownerName != null)
				return false;
		} else if (!ownerName.equals(other.ownerName))
			return false;
		if (ownerPassword == null) {
			if (other.ownerPassword != null)
				return false;
		} else if (!ownerPassword.equals(other.ownerPassword))
			return false;
		if (ownerPhone == null) {
			if (other.ownerPhone != null)
				return false;
		} else if (!ownerPhone.equals(other.ownerPhone))
			return false;
		return true;
	}
	
	
	
	
}
