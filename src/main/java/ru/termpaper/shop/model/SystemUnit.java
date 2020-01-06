package ru.termpaper.shop.model;

import javax.persistence.Entity;

import javax.persistence.*;

@Entity
@Table(name = "system_unit")
public class SystemUnit extends Product {
	String hd;
	String ram;
	String hdSel;
	String ramSel;
	String processor;

	public String getHd() {
		return hd;
	}

	public void setHd(String hd) {
		this.hd = hd;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getHdSel() {
		return hdSel;
	}

	public void setHdSel(String hdSel) {
		this.hdSel = hdSel;
	}

	public String getRamSel() {
		return ramSel;
	}

	public void setRamSel(String ramSel) {
		this.ramSel = ramSel;
	}

	public String getProcessor() {
		return processor;
	}

	public void setProcessor(String processor) {
		this.processor = processor;
	}
}
