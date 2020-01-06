package ru.termpaper.shop.model;


import javax.persistence.*;

@Entity
@Table(name = "mouse")
public class Mouse extends Product {
	Integer dpi;
	String connectionType;

	public Integer getDpi() {
		return dpi;
	}

	public void setDpi(Integer dpi) {
		this.dpi = dpi;
	}

	public String getConnectionType() {
		return connectionType;
	}

	public void setConnectionType(String connectionType) {
		this.connectionType = connectionType;
	}
}
