package ml.web;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import ml.db.AuthorRepository;
import ml.db.BookRepository;
import ml.db.LendCarRepository;
import ml.db.LendRepository;
import ml.db.PublishmentRepository;
import ml.db.TypeRepository;
import ml.db.UserRepository;
import ml.domain.Author;
import ml.domain.Book;
import ml.domain.Lend;
import ml.domain.Publishment;
import ml.domain.Type;
import ml.domain.User;

@Controller
@SessionAttributes({ "user" })
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private AuthorRepository authorRepository;
	@Autowired
	private TypeRepository TypeRepository;
	@Autowired
	private PublishmentRepository publishmentRepository;
	@Autowired
	private LendRepository lendRepository;
	@Autowired
	private LendCarRepository lendCarRepository;
	/**
	 * 进入注册页面
	 * @return
	 */
	@RequestMapping(value="/registerpage",method=RequestMethod.GET)
	public String RegisterPage(Model model) {
		model.addAttribute("user", new User());
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
			return "registesuccess";
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
	
	/**
	 * 用书名查询书
	 * @param bookname
	 * @param pageNo
	 * @param pageSize
	 * @param model
	 * @return
	 */
	@RequestMapping(value="searchbook" , method=RequestMethod.GET)
	public String SelectBookList(@RequestParam(value="bookname",defaultValue="")String bookname,@RequestParam(value="pageNo",defaultValue="1")int pageNo,@RequestParam(value="pageSize",defaultValue="10") int pageSize,Model model) {
		model.addAttribute("bookpaginationSupport", bookRepository.findPageByBookName(pageNo, pageSize,bookname));
		return "booklist";
		
	}
	/**
	 * 所有书的列表
	 * @param pageNo
	 * @param pageSize
	 * @param model
	 * @return
	 */
	@RequestMapping(value="booklist" , method=RequestMethod.GET)
	public String BookList(@RequestParam(value="pageNo",defaultValue="1")int pageNo,@RequestParam(value="pageSize",defaultValue="10") int pageSize,Model model) {
		model.addAttribute("bookpaginationSupport", bookRepository.findPage(pageNo, pageSize));
		return "booklist";
	}
	/**
	 * 进入一本书的详情页面
	 * @param bookid
	 * @param pageNo
	 * @param pageSize
	 * @param model
	 * @return
	 */
	@RequestMapping(value="bookinformation" , method=RequestMethod.GET)
	public String BookInformation(@RequestParam(value="bookId",defaultValue="")int bookId,@RequestParam(value="pageNo",defaultValue="1")int pageNo,@RequestParam(value="pageSize",defaultValue="10") int pageSize,Model model) {
		model.addAttribute("bookpaginationSupport", bookRepository.findPageByBookId(pageNo, pageSize,bookId));
		return "bookInformation";
	}
	
	@RequestMapping(value="applybook" , method=RequestMethod.GET)
	public String LendBook(@RequestParam(value="bookId",defaultValue="0") int bookId,@RequestParam(value="userId",defaultValue="0") int userId,Model model) {
		int rows = lendRepository.applyLend(bookId, userId);
		if (rows==0) {
			model.addAttribute("tipMessage","已经申请");
		}else {
			model.addAttribute("tipMessage","无法申请");
		}
		return "usertips";
	}

	/**
	 * 添加借阅车
	 * @param bookid
	 * @param userid
	 * @param model
	 * @return
	 */
	@RequestMapping(value="addlendcar" , method=RequestMethod.GET)
	public String addLendCar(@RequestParam(value="bookId",defaultValue="0") int bookId,@RequestParam(value="userId",defaultValue="0") int userId,Model model) {
		int rows=lendCarRepository.addBookToCart(userId, bookId);
		if (rows==0) {
			model.addAttribute("tipMessage","添加失败");
		}else {
			model.addAttribute("tipMessage","添加成功");
		}
		return "usertips";
	}
	
	/**
	 * 获取用户记录列表
	 * @param pageNo
	 * @param pageSize
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/userlend",method=RequestMethod.GET)
	public String LendList(@RequestParam(value="userId",defaultValue="0") int userId,@RequestParam(value="pageNo",defaultValue="1")int pageNo,@RequestParam(value="pageSize",defaultValue="10") int pageSize,Model model) {
		model.addAttribute("lendpaginationSupport",lendRepository.findPageByUserId(userId,pageNo, pageSize));
		model.addAttribute("lend",new Lend());
		return "userlend" ;
	}

}
