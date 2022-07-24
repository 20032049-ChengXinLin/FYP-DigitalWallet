/**
 * 
 * I declare that this code was written by me, 20032049. 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Cheng Xin Lin
 * Student ID: 20032049
 * Class: C372-4D-E62F-A
 * Date created: 2022-Feb-03 10:00:37 pm 
 * 
 */
package FYP.SOI20220012.DigitalWallet;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author 20032049
 *
 */
public interface CustomerOrderRepository
		extends JpaRepository<CustomerOrder, Integer>, PagingAndSortingRepository<CustomerOrder, Integer> {
	// Select all the cart items that belongs to a member
	public List<CustomerOrder> findByMember_MemberId(int id);

	
}
