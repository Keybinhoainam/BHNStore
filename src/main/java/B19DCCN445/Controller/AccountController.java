package B19DCCN445.Controller;


import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Producer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import B19DCCN445.domain.Account;
import B19DCCN445.exception.StorageException;
import B19DCCN445.model.AccountDTO;
import B19DCCN445.service.AccountService;

// import BHNStore.model.Account;



@Controller
@RequestMapping("/")
//@SessionAttributes("account")
public class AccountController {
    @Autowired
    AccountService accountService; 
    @Autowired
    private HttpSession session;
    private Long accountid;
    @GetMapping("/login")
    public String login(ModelMap model)
    {
        model.addAttribute("account",new AccountDTO());
        return "customer/login";
    }
    @PostMapping("/login")
    public ModelAndView Login(ModelMap model, @Valid @ModelAttribute("account") AccountDTO dto, BindingResult result)
    { 
        if(result.hasErrors())
        {
        	model.addAttribute("message", "Login Failed");
            return new ModelAndView("forward:/login", model);
        }
        Optional<Account> optExist=accountService.findByUserName(dto.getUsername());
        if(optExist.isPresent() && dto.getPassword().equals(optExist.get().getPassword()))
        {
        	session.setAttribute("accountid", optExist.get().getId());
        	session.setAttribute("isadmin", optExist.get().isIsadmin());
            model.addAttribute("accountid",optExist.get().getId());
            session.setAttribute("username", dto.getUsername());
            Object ruri=session.getAttribute("redirect-uri");
            model.addAttribute("message","Logged in successfully");
        	if(ruri !=null && ruri!="/login") {
        		session.removeAttribute("redirect-uri");
        		return new ModelAndView("redirect:"+ruri);
        	}
        	if(!optExist.get().isIsadmin()) {
        		
	            return new ModelAndView("redirect:/customer/home",model);
        	}
        	else {
        		return new ModelAndView("redirect:/admin/products/list",model);
        	}
	       
            
        }
        model.addAttribute("message","Login Failed");
        model.addAttribute("account",dto);
        return new ModelAndView("customer/login",model);

        
        // return new ModelAndView("forward:/",model);
    }
    @RequestMapping("logout")
    public String logout(Model model)
    {
    	session.setAttribute("accountid", null);
    	model.addAttribute("account",new AccountDTO());
    	return "redirect:/login";
    }
    
    @GetMapping("/dangky")    
    public String Dangky(Model model)
    {
        model.addAttribute("account", new AccountDTO());

        return "customer/dangky";
    }
   
    @RequestMapping("/save")
    public ModelAndView dangky(ModelMap model, @ModelAttribute("account") AccountDTO dto) throws StorageException
    {
        
        Account entity=new Account();
        Optional<Account> optExist=accountService.findByUserName(dto.getUsername());
        if(!optExist.isPresent() && dto.getPassword().equals(dto.getConfirm_password()))
        {
        	System.out.println("1");
            BeanUtils.copyProperties(dto, entity);
            System.out.println(dto.getUsername());
            System.out.println(dto.getPassword());
            System.out.println(entity.getPassword());
            accountService.save(entity);
            model.addAttribute("message","Đăng ký thành công");
            model.addAttribute("accountid",dto.getId());
            return new ModelAndView("forward:/login", model);
        }
        else 
        {
            model.addAttribute("message","Signup Failed");
            return new ModelAndView("customer/dangky",model);
        }
    }
//    @ModelAttribute("account")
//    public Long getaccountid() {
//    	return (long) 1000;
//    }
}
