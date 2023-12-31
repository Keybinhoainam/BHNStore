package B19DCCN445.Controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import B19DCCN445.domain.Account;
import B19DCCN445.service.AccountService;



public class CheckLogin {
	@Autowired
	public static AccountService accountService;
	@Autowired
	public static HttpSession session;
	 
	public static Boolean CheckLoginAdmin() {
		Long accountid=(Long) session.getAttribute("accountid");
		if(accountid==null)return false;
		Optional<Account> o=accountService.findById(accountid);
		if(o.isPresent() && o.get().isIsadmin()) {
			return true;
		}
		
		return false;
	}
	public static Boolean CheckLoginCustomer() {
		Long accountid=(Long) session.getAttribute("accountid");
		if(accountid==null)return false;
		Optional<Account> o=accountService.findById(accountid);
		if(o.isPresent() ) {
			return true;
		}
		
		return false;
	}
}
