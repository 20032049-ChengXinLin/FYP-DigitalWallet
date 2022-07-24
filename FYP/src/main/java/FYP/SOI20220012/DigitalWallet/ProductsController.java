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
* Date created: 2022-May-05 4:08:37 pm
*
*/
package FYP.SOI20220012.DigitalWallet;

import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * @author 20032049
 *
 */
@Controller
public class ProductsController {

	@Autowired
	private ProductsRepository ProductsRepository;
	
	@GetMapping("/pagetwo/{id}")
	public String viewSingleProduct(@PathVariable("id") Integer productsId, Model model) {
		Products listProducts = ProductsRepository.getById(productsId);
		model.addAttribute("listProducts", listProducts);
		model.addAttribute("shoppingcart", new ShoppingCart());
		return "pagetwo";
	}
	
}
