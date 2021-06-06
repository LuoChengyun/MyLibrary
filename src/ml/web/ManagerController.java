package ml.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import ml.db.AuthorRepository;
import ml.db.BookRepository;
import ml.db.BorrowRepository;
import ml.db.PublishRepository;
import ml.db.TypeRepository;
import ml.db.UserRepository;
import ml.domain.User;

@Controller
@SessionAttributes({ "manager" })
@RequestMapping("/manager")
public class ManagerController {
	
	@Autowired
	private UserRepository userRepository;
//	@Autowired
//	private BookRepository bookRepository;
//	@Autowired
//	private AuthorRepository authorRepository;
//	@Autowired
//	private TypeRepository typeRepository;
//	@Autowired
//	private PublishRepository publishRepository;
//	@Autowired
//	private BorrowRepository borrowRepository;
	
	/**
	 * 退出登录
	 */
	@RequestMapping(value = "/logoutpage", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		// 删除整个会话
		session.invalidate();
		return "redirect:/";// 返回首页
	}
	
	/**
	 * 进入个人中心
	 */
	@RequestMapping(value="/usercenter",method=RequestMethod.GET)
	public String Center() {
		
		return "managerInformation";
	}
	
	
	/**
	 * 获取用户列表
	 * @param pageNo
	 * @param pageSize
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/userlist",method=RequestMethod.GET)
	public String UserList(@RequestParam(value="pageNo",defaultValue="1")int pageNo,@RequestParam(value="pageSize",defaultValue="10") int pageSize,Model model) {
		model.addAttribute("userpaginationSupport",userRepository.findPage(pageNo, pageSize));
		model.addAttribute("user",new User());
		return "userList" ;
	}
	
	/**
	 * 查询单个用户
	 */
	@RequestMapping(value="/searchuser",method=RequestMethod.GET)
	public String SelectUserList(@RequestParam(value="account",defaultValue="")String account,@RequestParam(value="pageNo",defaultValue="1")int pageNo,@RequestParam(value="pageSize",defaultValue="10") int pageSize,Model model) {
		model.addAttribute("userpaginationSupport",userRepository.findPageByUserName(pageNo, pageSize, account));
		model.addAttribute("user",new User());
		return "userList" ;
	}
	

}
