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
@SessionAttributes({ "manager" })
@RequestMapping("/manager")
public class ManagerController {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private AuthorRepository authorRepository;
	@Autowired
	private TypeRepository typeRepository;
	@Autowired
	private PublishmentRepository publishmentRepository;
	@Autowired
	private LendRepository lendRepository;
	
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
	 * 增加用户
	 */
	@RequestMapping(value="/adduser",method=RequestMethod.GET)
	public String addUser(@Valid User user,Errors errors ,HttpSession session,Model model) {
		if (errors.hasErrors()) {
			return "userlist";
		}
		User newuser=userRepository.addUser(user);
		String string="";
		if (newuser==null) {
			string="添加用户失败";
		}else {
			string="添加用户成功";
		}
		model.addAttribute("tipMessage", string);
		return "tips";
	}
	
	/**
	 * 删除用户
	 */
	@RequestMapping(value="/deleteuser")
	public String deleteUser(@RequestParam(value="id",defaultValue="0") int id,Model model){
		int row=userRepository.removeUser(id);
		String string="";
		if (row==0) {
			string="删除用户失败";
		}else {
			string="删除用户成功";
		}
		model.addAttribute("tipMessage", string);
		return "tips";
	}
	
	/**
	 * 禁用用户
	 */
	@RequestMapping(value="/checkuser",method=RequestMethod.GET)
	public String checkUser(@RequestParam(value="id",defaultValue="0") int id,Model model) {
		int rows=userRepository.checkUserById(id);
		if (rows==0) {
			model.addAttribute("tipMessage","禁用失败");
		}else {
			model.addAttribute("tipMessage","禁用成功");
		}
		return "tips";
	}
	
	/**
	 * 恢复用户
	 */
	@RequestMapping(value="/backuser",method=RequestMethod.GET)
	public String backUser(@RequestParam(value="id",defaultValue="0") int id,Model model) {
		int rows=userRepository.backUserById(id);
		if (rows==0) {
			model.addAttribute("tipMessage","解禁失败");
		}else {
			model.addAttribute("tipMessage","解禁成功");
		}
		return "tips";
	}
	
	
	/**
	 * 查询单个用户
	 */
	@RequestMapping(value="/searchuser",method=RequestMethod.GET)
	public String SelectUserList(@RequestParam(value="username",defaultValue="")String username,@RequestParam(value="pageNo",defaultValue="1")int pageNo,@RequestParam(value="pageSize",defaultValue="10") int pageSize,Model model) {
		model.addAttribute("userpaginationSupport",userRepository.findPageByUserName(pageNo, pageSize, username));
		model.addAttribute("user",new User());
		return "userList" ;
	}
	
	/**
	 * 获取分类列表
	 * @param pageNo
	 * @param pageSize
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/managetype",method=RequestMethod.GET)
	public String TypeList(@RequestParam(value="pageNo",defaultValue="1")int pageNo,@RequestParam(value="pageSize",defaultValue="10") int pageSize,Model model) {
		model.addAttribute("typepaginationSupport",typeRepository.findPage(pageNo, pageSize));
		model.addAttribute("type",new Type());
		return "manageType" ;
	}
	
	/**
	 * 增加分类
	 * @param type
	 * @param errors
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/addtype",method=RequestMethod.GET)
	public String addType(@Valid Type type,Errors errors ,HttpSession session,Model model) {
		if (errors.hasErrors()) {
			return "manageType";
		}
		Type newtype = typeRepository.addType(type);
		String string="";
		if (newtype==null) {
			string="添加分类失败";
		}else {
			string="添加分类成功";
		}
		model.addAttribute("tipMessage", string);
		return "tips";
	}
	
	
	/**
	 * 删除分类
	 */
	@RequestMapping(value="/deletetype")
	public String deleteType(@RequestParam(value="id",defaultValue="0") int id,Model model){
		int row=typeRepository.removeType(id);
		String string="";
		if (row==0) {
			string="删除分类失败";
		}else {
			string="删除分类成功";
		}
		model.addAttribute("tipMessage", string);
		return "tips";
	}
	
	
	/**
	 * 获取出版社列表
	 * @param pageNo
	 * @param pageSize
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/managepublishment",method=RequestMethod.GET)
	public String PublishmentList(@RequestParam(value="pageNo",defaultValue="1")int pageNo,@RequestParam(value="pageSize",defaultValue="10") int pageSize,Model model) {
		model.addAttribute("publishmentpaginationSupport",publishmentRepository.findPage(pageNo, pageSize));
		model.addAttribute("publishment",new Publishment());
		return "managePublishment" ;
	}
	
	/**
	 * 删除出版社
	 */
	@RequestMapping(value="/deletepublishment")
	public String deletePublishment(@RequestParam(value="id",defaultValue="0") int publishId,Model model){
		int row=publishmentRepository.removePublishment(publishId);
		String string="";
		if (row==0) {
			string="删除出版社失败";
		}else {
			string="删除出版社成功";
		}
		model.addAttribute("tipMessage", string);
		return "tips";
	}
	
	/**
	 * 增加出版社
	 * @param publishment
	 * @param errors
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/addpublishment",method=RequestMethod.GET)
	public String addPblishment(@Valid Publishment publishment,Errors errors ,HttpSession session,Model model) {
		if (errors.hasErrors()) {
			return "managePublishment";
		}
		Publishment newpublishment = publishmentRepository.addPublishment(publishment);
		String string="";
		if (newpublishment==null) {
			string="添加出版社失败";
		}else {
			string="添加出版社成功";
		}
		model.addAttribute("tipMessage", string);
		return "tips";
	}
	
	
	/**
	 * 获取作者列表
	 * @param pageNo
	 * @param pageSize
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/manageauthor",method=RequestMethod.GET)
	public String AuthorList(@RequestParam(value="pageNo",defaultValue="1")int pageNo,@RequestParam(value="pageSize",defaultValue="10") int pageSize,Model model) {
		model.addAttribute("authorpaginationSupport",authorRepository.findPage(pageNo, pageSize));
		model.addAttribute("author",new Author());
		return "manageAuthor" ;
	}
	
	/**
	 * 删除作者
	 */
	@RequestMapping(value="/deleteauthor")
	public String deleteAuthor(@RequestParam(value="id",defaultValue="0") int authorId,Model model){
		int row=authorRepository.removeAuthor(authorId);
		String string="";
		if (row==0) {
			string="删除作者失败";
		}else {
			string="删除作者成功";
		}
		model.addAttribute("tipMessage", string);
		return "tips";
	}
	
	/**
	 * 增加作者
	 * @param author
	 * @param errors
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/addauthor",method=RequestMethod.GET)
	public String addAuthor(@Valid Author author,Errors errors ,HttpSession session,Model model) {
		if (errors.hasErrors()) {
			return "manageAuthor";
		}
		Author newauthor = authorRepository.addAuthor(author);
		String string="";
		if (newauthor==null) {
			string="添加作者失败";
		}else {
			string="添加作者成功";
		}
		model.addAttribute("tipMessage", string);
		return "tips";
	}
	
	
	
	/**
	 * 获取记录列表
	 * @param pageNo
	 * @param pageSize
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/managelend",method=RequestMethod.GET)
	public String LendList(@RequestParam(value="pageNo",defaultValue="1")int pageNo,@RequestParam(value="pageSize",defaultValue="10") int pageSize,Model model) {
		model.addAttribute("lendpaginationSupport",lendRepository.findPage(pageNo, pageSize));
		model.addAttribute("lend",new Lend());
		return "manageLend" ;
	}
	
	/**
	 * 删除记录
	 */
	@RequestMapping(value="/deletelend")
	public String deleteLend(@RequestParam(value="id",defaultValue="0") int id,Model model){
		int row=lendRepository.removeLend(id);
		String string="";
		if (row==0) {
			string="删除记录失败,此书未归还";
		}else {
			string="删除记录成功";
		}
		model.addAttribute("tipMessage", string);
		return "tips";
	}
	
	
	/**
	 * 用书名查询书
	 * @param bookname
	 * @param pageNo
	 * @param pageSize
	 * @param model
	 * @return
	 */
	@RequestMapping(value="managersearchbook" , method=RequestMethod.GET)
	public String SelectBookList(@RequestParam(value="bookname",defaultValue="")String bookname,@RequestParam(value="pageNo",defaultValue="1")int pageNo,@RequestParam(value="pageSize",defaultValue="10") int pageSize,Model model) {
		model.addAttribute("bookpaginationSupport", bookRepository.findPageByBookName(pageNo, pageSize,bookname));
		model.addAttribute("book", new Book());
		return "manageBook";
		
	}
	
	/**
	 * 所有书的列表
	 * @param pageNo
	 * @param pageSize
	 * @param model
	 * @return
	 */
	@RequestMapping(value="managebook" , method=RequestMethod.GET)
	public String BookList(@RequestParam(value="pageNo",defaultValue="1")int pageNo,@RequestParam(value="pageSize",defaultValue="10") int pageSize,Model model) {
		model.addAttribute("bookpaginationSupport", bookRepository.findPage(pageNo, pageSize));
		model.addAttribute("type", new Type());
		model.addAttribute("book", new Book());
		model.addAttribute("publishment", new Publishment());
		model.addAttribute("author", new Author());
		return "manageBook";
	}
	
	/**
	 * 增加书籍
	 * @param book
	 * @param errors
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/addbook",method=RequestMethod.GET)
	public String addBook(@Valid Book book,Errors errors ,HttpSession session,Model model) {
		if (errors.hasErrors()) {
			return "manageBook";
		}
		Book newbook = bookRepository.addBook(book);
		String string="";
		if (newbook==null) {
			string="添加图书失败";
		}else {
			string="添加图书成功";
		}
		model.addAttribute("tipMessage", string);
		return "tips";
	}

	
	
}
