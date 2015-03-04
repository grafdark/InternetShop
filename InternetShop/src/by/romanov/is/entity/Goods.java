package by.romanov.is.entity;

import java.io.Serializable;

public class Goods implements Serializable {

	private static final long serialVersionUID = 1L;
	private int numberGoods;
	private String nameGoods;
	private String imgGoods;
	private String description;
	private String category;
	private int price;

	public int getNumberGoods() {
		return numberGoods;
	}

	public String getNameGoods() {
		return nameGoods;
	}

	public String getDescription() {
		return description;
	}

	public void setNumberGoods(int numberGoods) {
		this.numberGoods = numberGoods;
	}

	public void setNameGoods(String nameGoods) {
		this.nameGoods = nameGoods;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getImgGoods() {
		return imgGoods;
	}

	public void setImgGoods(String imgGoods) {
		this.imgGoods = imgGoods;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Goods [numberGoods=" + numberGoods + ", nameGoods=" + nameGoods
				+ ", imgGoods=" + imgGoods + ", description=" + description
				+ ", category=" + category + ", price=" + price + "]";
	}

}
