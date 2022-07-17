/**
*
* I declare that this code was written by me, 20008303.
* I will not copy or allow others to copy my code.
* I understand that copying code is considered as plagiarism.
*
* Student Name: Cheng Xin Lin (20032049), Koh Siew Gek (20008303), Chen Wan Ting (20009334)
* Team ID: SOI-2022-0012
* Team Project ID: SOI-2022-2210-0049
* Project: [IP] Digital Wallet
* Date created: 2022-Jul-10 12:27:44 am
*
*/
package FYP.SOI20220012.DigitalWallet;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 20008303
 *
 */
public interface HelpRepository extends JpaRepository<Help, Integer> {
	
	public List<Help> findByAccount_AccountId(int accountid);

}
