package ru.termpaper.shop.model;



import javax.persistence.*;

@Entity
@Table(name = "keyboard")
public class Keyboard extends Product {
	String color;
	String keyboardType;
	String connectionType;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getKeyboardType() {
		return keyboardType;
	}

	public void setKeyboardType(String keyboardType) {
		this.keyboardType = keyboardType;
	}

	public String getConnectionType() {
		return connectionType;
	}

	public void setConnectionType(String connectionType) {
		this.connectionType = connectionType;
	}
}
