package com.bpd.bean;

public class Goods {

	private Integer id;

	private String name;
	private String datea;
	private double price;
	private int status;
	private Type type;

	public Goods() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Goods(Integer id, String name, String datea, double price, int status, Type type) {
		super();
		this.id = id;
		this.name = name;
		this.datea = datea;
		this.price = price;
		this.status = status;
		this.type = type;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDatea() {
		return datea;
	}

	public void setDatea(String datea) {
		this.datea = datea;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

}
