package ml.web;

import javax.servlet.http.HttpSession;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ml.db.*;
import ml.domain.*;

/**
 * 控制类
 * @author luochengyun
 *
 */
@Controller // 控制定义
@RequestMapping("/") // 相对web路径
public class HomeController {
	@Autowired
	private UserRepository userRepository;
	
	
	
	@RequestMapping(method = RequestMethod.GET)//相应的请求方法
	public String HomePage(Model model) {
		model.addAttribute("user",new User());
		return "login";
	}
	
	/**
	 * 进入登录页面
	 */
	@RequestMapping(value = "/loginpage", method = RequestMethod.GET)
	public String loginPage() {
		return "login";
	}
	
	/**
	 * 资源访问错误
	 */
	@RequestMapping(value = "/notfoundpage", method = RequestMethod.GET)
	public String notFoundPage() {
		return "404";
	}
	/**
	 * 提交登录
	 * @param account
	 * @param password
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String Login(
			@RequestParam(value="account",defaultValue="") String account,
			@RequestParam(value="password",defaultValue="") String password,
			HttpSession session,Model model) {
		User user=userRepository.findByAccount(account, password);
		if(user!=null) {
			if(user.getUserState()==0) {//账号可用
				session.setAttribute("user", user);
				//普通用户登录
				if(user.getUserIdentity()==0) {
					return "redirect:/user/booklist";
				}
				//管理员登录
				else {
					return "redirect:/manager/userlist";//登录成功返回管理员首页
				}
			}
			else {
				model.addAttribute("logined","登陆失败，账号已被禁用");
				return "login";
			}
			
		}
		else {
			model.addAttribute("logined", "登录失败，用户名不存在或密码错误");
			return "login";// 登录失败返回登录失败提醒页面
		}
		
		

		
	}
	
	/**
	 * 退出登录
	 */
	@RequestMapping(value = "/logoutpage", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		// 删除整个会话
		session.invalidate();
		return "redirect:/";// 返回首页
	}
	

}
