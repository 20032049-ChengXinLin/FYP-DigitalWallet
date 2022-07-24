/**
 * 
 * I declare that this code was written by me, 20032049. 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Cheng Xin Lin
 * Student ID: 20032049
 * Class: C372-4D-E62F-A
 * Date created: 2022-Jan-14 8:09:54 pm 
 * 
 */
package FYP.SOI20220012.DigitalWallet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
/**
 * @author 20032049
 *
 */
@Controller
public class CustomerOrderController {
	@Autowired
	private CustomerOrderRepository CustomerOrderRepository;
		
	@GetMapping("/customerorders")
	public String viewCustomerOrders(Model model, @Param("keyword") String keyword) {
		List<CustomerOrder> listCustomer = CustomerOrderRepository.findAll();
		model.addAttribute("listCustomer", listCustomer);

		return "view_customer_orders";
	}

	@GetMapping(path = "/customerorders/member/{id}")
	public String getOrdersbyMember(@PathVariable Integer id, Model model, @Param("keyword") String keyword) {

		List<CustomerOrder> listCustomer = CustomerOrderRepository.findByMember_MemberId(id);

		model.addAttribute("listCustomer", listCustomer);

		return "view_customer_orders";
	}
}
