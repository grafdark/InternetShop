package by.romanov.is.entity;

public class Order {
	private int numberOrder;
	private int sum;
	private String nameGoods;
	private String dateOrder;
	private String paymentOrder;
	private int quantityGoods;

	public int getNumberOrder() {
		return numberOrder;
	}

	public int getSum() {
		return sum;
	}

	public String getNameGoods() {
		return nameGoods;
	}

	

	public String getPaymentOrder() {
		return paymentOrder;
	}

	public int getQuantityGoods() {
		return quantityGoods;
	}

	public void setNumberOrder(int numberOrder) {
		this.numberOrder = numberOrder;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public void setNameGoods(String nameGoods) {
		this.nameGoods = nameGoods;
	}

	

	public void setPaymentOrder(String payment) {
		this.paymentOrder = payment;
	}

	public void setQuantityGoods(int quantityGoods) {
		this.quantityGoods = quantityGoods;
	}
	public String getDateOrder() {
		return dateOrder;
	}

	public void setDateOrder(String dateOrder) {
		this.dateOrder = dateOrder;
	}

	@Override
	public String toString() {
		return "Order [numberOrder=" + numberOrder + ", sum=" + sum
				+ ", nameGoods=" + nameGoods + ", dateOrder=" + dateOrder
				+ ", paymentOrder=" + paymentOrder + ", quantityGoods="
				+ quantityGoods + "]";
	}

}
