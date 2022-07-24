/**
 * 
 * I declare that this code was written by me, 20032049. 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Cheng Xin Lin
 * Student ID: 20032049
 * Class: C372-4D-E62F-A
 * Date created: 2021-Dec-02 6:00:09 pm 
 * 
 */
package FYP.SOI20220012.DigitalWallet;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author 20032049
 *
 */

@Entity
public class CustomerOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerOrderId;
	@ManyToOne
	@JoinColumn(name = "productId", nullable = false)
	private Products product;
	// Many member can have cart item
	@ManyToOne
	@JoinColumn(name = "member_id")
	private ShoesMember member;
	
	private String transactionId;
	private String address;
	private String postalCode;
	private int quantity;
	private double total_amount;
	private String shoesize;

	public int getCustomerOrderId() {
		return customerOrderId;
	}

	public void setCustomerOrderId(int customerOrderId) {
		this.customerOrderId = customerOrderId;
	}

	public Products getProduct() {
		return product;
	}

	public void setProduct(Products product) {
		this.product = product;
	}

	public ShoesMember getMember() {
		return member;
	}

	public void setMember(ShoesMember member) {
		this.member = member;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(double total_amount) {
		this.total_amount = total_amount;
	}

	public String getShoesize() {
		return shoesize;
	}

	public void setShoesize(String shoesize) {
		this.shoesize = shoesize;
	}


}
