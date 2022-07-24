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


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author 20032049
 *
 */
public interface ShoesMemberRepository extends JpaRepository<ShoesMember, Integer> {

	public ShoesMember findByUsername(String username);

	@Query("SELECT m FROM ShoesMember m WHERE m.email = ?1")
	public ShoesMember findByEmail(String email);

}
