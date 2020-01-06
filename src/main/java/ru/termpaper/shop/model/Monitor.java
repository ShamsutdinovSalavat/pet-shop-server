package ru.termpaper.shop.model;

import javax.persistence.*;

@Entity
@Table(name = "monitor")
public class Monitor extends Product {
	String diagonal;
	String resolution;
	String matrix;

	public String getDiagonal() {
		return diagonal;
	}

	public void setDiagonal(String diagonal) {
		this.diagonal = diagonal;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public String getMatrix() {
		return matrix;
	}

	public void setMatrix(String matrix) {
		this.matrix = matrix;
	}
}
