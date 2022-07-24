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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author 20032049
 *
 */
public class ShoesMemberDetailsService implements UserDetailsService{

	
	@Autowired
	private ShoesMemberRepository ShoesMemberRepository;
	
	@Override
	public ShoesMemberDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		ShoesMember ShoesMember = ShoesMemberRepository.findByUsername(username);
		
		if (ShoesMember == null) {
			throw new UsernameNotFoundException("Could not find user");
		}
		return new ShoesMemberDetails(ShoesMember);
	}
}
