/**
 * 
 * I declare that this code was written by me, 20032049. 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Cheng Xin Lin
 * Student ID: 20032049
 * Class: C372-4D-E62F-A
 * Date created: 2022-Jan-13 9:55:30 am 
 * 
 */
package FYP.SOI20220012.DigitalWallet;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author 20032049
 *
 */
public class ShoesMemberDetails implements UserDetails {
	
	private ShoesMember ShoesMember;
	
	public ShoesMemberDetails(ShoesMember ShoesMember) {
		this.ShoesMember = ShoesMember;
	}
	public ShoesMember getShoesMember() {
		return ShoesMember;
	}

	public void setMember(ShoesMember ShoesMember) {
		this.ShoesMember = ShoesMember;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority authority = new SimpleGrantedAuthority(ShoesMember.getRole());
		return Arrays.asList(authority);
	}
	
	@Override
	public String getPassword() {
		return ShoesMember.getPassword();
		
	}
	
	@Override 
	public String getUsername() {
		return ShoesMember.getUsername();
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
	@Override
	public boolean isEnabled() {
		return true;
	}
}
