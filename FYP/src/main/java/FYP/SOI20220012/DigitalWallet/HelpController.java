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
* Date created: 2022-Jul-10 12:25:35 am
*
*/
package FYP.SOI20220012.DigitalWallet;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.bytebuddy.utility.RandomString;

/**
 * @author 20008303
 *
 */

@Controller
public class HelpController {
	
	@Autowired
	private HelpRepository helpRepository;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private NotificationsRepository notificationsRepository;
	
	@Autowired
	private NotificationsService notificationsService;
	
	@GetMapping("/help")
	public String sendHelpMsg(Model model, Help help) {
		
		AccountDetails loggedInAccount = (AccountDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		int loggedInAccountId = loggedInAccount.getAccount().getAccountId();
		
		List<Help> listHelpMsg = helpRepository.findAll();
		model.addAttribute("listHelpMsg", listHelpMsg);
		
		int unread = notificationsService.unreadNotificiations();
		model.addAttribute("unread", unread);
		
		return "help";
	}
	
	public void sendEmail(String to, String subject, String body) {
		SimpleMailMessage msg = new SimpleMailMessage();
		String fromAddress = "finantierpay@outlook.com";
		msg.setFrom(fromAddress);
		msg.setTo(to);
		msg.setSubject(subject);
		msg.setText(body);
		javaMailSender.send(msg);
	}
	
	
	@PostMapping("/process_help")
	public String processHelp(@Valid Help help, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			return "help";
		}
		
		AccountDetails loggedInAccount = (AccountDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		int loggedInAccountId = loggedInAccount.getAccount().getAccountId();
		
		Account account = accountRepository.getById(loggedInAccountId);
		
		LocalDateTime currentDateTime = LocalDateTime.now();
		Notifications notifications = new Notifications();
		notifications.setAccount(account);
		notifications.setDateTime(currentDateTime);
		notifications.setTitle("Help Message Sent!");

		notifications.setMessage("You have sent a help message regarding to the " + help.getTitle() + "." + 
								"It will take 3 to 5 working days to response, through your email, " + account.getEmail() + ".");

		notificationsRepository.save(notifications);
		
		String subject = "You have sent a Help message!";
		String body = "Dear " + account.getUsername() + ",\n\nIt will take 3 to 5 working days to response on your feedback/question regarding to the "
						+ help.getTitle() + ".\nThank you for your patience.\n\nBest Regards, \nFinantierPay Help";
		String to = account.getEmail();
		sendEmail(to, subject, body);
		
		help.setAccount(account);
		help.setStatus("In progress");
		helpRepository.save(help);
		
		int unread = notificationsService.unreadNotificiations();
		model.addAttribute("unread", unread);
		
		return "help_success";
	}
	
	@GetMapping("/help/update/{id}")
	public String updateHelp(@PathVariable("id") Integer id, Model model) {
		
		Help help = helpRepository.getById(id);
		model.addAttribute("help", help);
		
		int unread = notificationsService.unreadNotificiations();
		model.addAttribute("unread", unread);
		
		return "update_help";
	}

	@PostMapping("/help/update/{id}")
	public String saveHelp(@PathVariable("id") int helpMsgId, @RequestParam("status") String status, RedirectAttributes redirectAttributes, Model model) {

		Help help = helpRepository.getById(helpMsgId);

		// Set these of the account object retrieved
		help.setStatus(status);
		redirectAttributes.addFlashAttribute("success", "Successfully updated the status of Help Message");
		
		// Save the account back to the accountRepository
		helpRepository.save(help);
		
		int unread = notificationsService.unreadNotificiations();
		model.addAttribute("unread", unread);
		
		return "redirect:/help";
	}

}
