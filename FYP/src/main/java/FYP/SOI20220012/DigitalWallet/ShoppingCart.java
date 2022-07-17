/**
*
* I declare that this code was written by me, 20032049.
* I will not copy or allow others to copy my code.
* I understand that copying code is considered as plagiarism.
*
* Student Name: Cheng Xin Lin (20032049), Koh Siew Gek (20008303), Chen Wan Ting (20009334)
* Team ID: SOI-2022-0012
* Team Project ID: SOI-2022-2210-0049
* Project: [IP] Digital Wallet
* Date created: 2022-May-05 3:43:47 pm
*
*/
package FYP.SOI20220012.DigitalWallet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

/**
 * @author 20032049
 *
 */
@Entity
public class ShoppingCart {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int shoppingCartId;
	
	@ManyToOne
	@JoinColumn(name = "productsId", nullable = false)
	private Products product;
	
	private int quantity;
	private String shoesize;
	
	@Transient
	private double subTotal;

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

	public Products getProduct() {
		return product;
	}

	public void setProduct(Products product) {
		this.product = product;
	}

	public int getShoppingCartId() {
		return shoppingCartId;
	}

	public void setShoppingCartId(int shoppingCartId) {
		this.shoppingCartId = shoppingCartId;
	}

	public String getShoesize() {
		return shoesize;
	}

	public void setShoesize(String shoesize) {
		this.shoesize = shoesize;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
