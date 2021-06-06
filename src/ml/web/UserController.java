package ml.web;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import ml.db.UserRepository;
import ml.domain.User;

@Controller
@SessionAttributes({ "user" })
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	/**
	 * 进入注册页面
	 * @return
	 */
	@RequestMapping(value="/registerpage",method=RequestMethod.GET)
	public String RegisterPage(Model model) {
		model.addAttribute(new User());
		return "register";
	}
	/**
	 * 注册提交
	 * @param user
	 * @param errors
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String Register(@Valid User user, Errors errors,
			HttpSession session,Model model) {
		if(errors.hasErrors()) {
			return "register";
		}
		if((userRepository.findByUserName(user.getUserName())==null)) {
			userRepository.addUser(user);
			model.addAttribute("tipMessage", "注册成功");
			return "tips";
		}
		else {
			model.addAttribute("logined", "注册失败,用户名已存在");
			return "register";
		}
		
	}
	
	
	
	/**
	 * 进入个人中心
	 */
	@RequestMapping(value="/usercenter",method=RequestMethod.GET)
	public String Center() {
		
		return "userInformation";
	}
	
	/**
	 * 返回主页面
	 * @return
	 */
	@RequestMapping(value = "/home",method = RequestMethod.GET)//相应的请求方法
	public String HomePage() {
		
		return "redirect:/";// 返回首页
	}

}
