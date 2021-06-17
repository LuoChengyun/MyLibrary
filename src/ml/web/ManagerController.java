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
	 * 进入个人资料编辑页面
	 */
	@RequestMapping(value="/altermanagerpage",method=RequestMethod.GET)
	public String Altermanager(@RequestParam(value = "userId", defaultValue = "0") int userId, Model model) {
		User user=userRepository.findByUserId(userId);
		model.addAttribute("user", user);
		return "alterManager";
	}
	
	/**
	 * 提交修改个人信息
	 */
	@RequestMapping(value="/altermanager",method=RequestMethod.GET)
	public String Submitalter(@RequestParam(value = "userName", defaultValue = "")String userName ,
			@RequestParam(value = "userAccount", defaultValue = "")String userAccount ,
			@RequestParam(value = "userPassword", defaultValue = "")String userPassword ,HttpSession session,Model model) {
		
		// 从session中取出用户对象
		User user= (User)session.getAttribute("user");
				//添加新用户信息到数据库
				User newuser = new User(user.getUserId(),userName,userAccount,userPassword);
				user=userRepository.alterManager(newuser);
				session.setAttribute("user", newuser);
				model.addAttribute("tipMessage", "修改成功");
			return "tips";
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
		return "manageUser" ;
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
	 * 初始化用户密码
	 */
	@RequestMapping(value="/initializepwd")
	public String initializeUserPassword(@RequestParam(value="userId",defaultValue="0") int userId,Model model){
		int row=userRepository.initializeUserPass(userId);
		String string="";
		if (row==0) {
			string="初始化密码失败";
		}else {
			string="初始化密码成功";
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
	 * 进入分类编辑页面
	 */
	@RequestMapping(value="/altertypepage",method=RequestMethod.GET)
	public String Altertype(@RequestParam(value = "typeId", defaultValue = "0") int typeId, HttpSession session,Model model) {
		Type type=typeRepository.findByTypeId(typeId);
		model.addAttribute("type", type);
		session.setAttribute("type", type);
		return "alterType";
	}

	/**
	 * 提交修改分类
	 */
	@RequestMapping(value="/altertype",method=RequestMethod.GET)
	public String SubmitAlterType(@RequestParam(value = "typeName", defaultValue = "")String typeName ,HttpSession session,Model model) {
		Type type= (Type)session.getAttribute("type");
		Type newtype = new Type(type.getTypeId(),typeName);
		type=typeRepository.alterType(newtype);
		session.setAttribute("type", type);
		return "redirect:/manager/managetype";
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
	 * 进入出版社编辑页面
	 */
	@RequestMapping(value="/alterpublishpage",method=RequestMethod.GET)
	public String AlterPublishment(@RequestParam(value = "publishId", defaultValue = "0") int publishId, HttpSession session,Model model) {
		Publishment publishment=publishmentRepository.findByPublishId(publishId);
		model.addAttribute("publishment", publishment);
		session.setAttribute("publishment", publishment);
		return "alterPublishment";
	}

	/**
	 * 提交修改出版社
	 */
	@RequestMapping(value="/alterpublishment",method=RequestMethod.GET)
	public String SubmitAlterPublishment(@RequestParam(value = "publishName", defaultValue = "")String publishName ,
			@RequestParam(value = "publishLocal", defaultValue = "")String publishLocal ,HttpSession session,Model model) {
		Publishment publishment= (Publishment)session.getAttribute("publishment");
		Publishment newpublishment = new Publishment(publishment.getPublishId(),publishName,publishLocal);
		publishment=publishmentRepository.alterPublishment(newpublishment);
		session.setAttribute("publishment", publishment);
		return "redirect:/manager/managepublishment";
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
	 * 进入作者编辑页面
	 */
	@RequestMapping(value="/alterauthorpage",method=RequestMethod.GET)
	public String AlterAuthor(@RequestParam(value = "authorId", defaultValue = "0") int authorId, HttpSession session,Model model) {
		Author author=authorRepository.findByAuthorId(authorId);
		model.addAttribute("author", author);
		session.setAttribute("author", author);
		return "alterAuthor";
	}

	/**
	 * 提交修改作者
	 */
	@RequestMapping(value="/alterauthor",method=RequestMethod.GET)
	public String SubmitAlterAuthor(@RequestParam(value = "authorName", defaultValue = "")String authorName ,
			@RequestParam(value = "authorSex", defaultValue = "")int authorSex ,
			@RequestParam(value = "authorIntroduct", defaultValue = "")String authorIntroduct ,HttpSession session,Model model) {
		Author author= (Author)session.getAttribute("author");
		
			Author newauthor = new Author(author.getAuthorId(),authorName,authorSex,authorIntroduct);
			author=authorRepository.alterAuthor(newauthor);
			session.setAttribute("author", author);
			return "redirect:/manager/manageauthor";
		
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
		model.addAttribute("lendpaginationSupport",lendRepository.findPage_1_3(pageNo, pageSize));
		return "manageLend" ;
	}
	
	/**
	 * 获取申请借书列表
	 * @param pageNo
	 * @param pageSize
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/manageapply",method=RequestMethod.GET)
	public String ApplyLendList(@RequestParam(value="pageNo",defaultValue="1")int pageNo,@RequestParam(value="pageSize",defaultValue="10") int pageSize,Model model) {
		model.addAttribute("lendpaginationSupport",lendRepository.findPage_0(pageNo, pageSize));
		model.addAttribute("lend",new Lend());
		return "manageApply" ;
	}
	
	
	/**
	 * 审核通过借书
	 * @param lendId
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/passapply",method=RequestMethod.GET)
	public String PassApply(@RequestParam(value="lendId",defaultValue="0") int lendId,Model model) {
		int row=lendRepository.passApply(lendId);
		String string="";
		if (row==0) {
			string="审核失败";
		}else {
			string="审核通过";
		}
		model.addAttribute("tipMessage", string);
		return "tips";
	}
	
	
	/**
	 * 获取申请还书列表
	 * @param pageNo
	 * @param pageSize
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/manageback",method=RequestMethod.GET)
	public String BackLendList(@RequestParam(value="pageNo",defaultValue="1")int pageNo,@RequestParam(value="pageSize",defaultValue="10") int pageSize,Model model) {
		model.addAttribute("lendpaginationSupport",lendRepository.findPage_2(pageNo, pageSize));
		model.addAttribute("lend",new Lend());
		return "manageBack" ;
	}
	
	/**
	 * 审核通过还书
	 * @param lendId
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/passback",method=RequestMethod.GET)
	public String PassLend(@RequestParam(value="lendId",defaultValue="0") int lendId,Model model) {
		int row=lendRepository.passBack(lendId);
		String string="";
		if (row==0) {
			string="还书失败";
		}else {
			string="还书成功";
		}
		model.addAttribute("tipMessage", string);
		return "tips";
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
	
	
	/**
	 * 删除书籍
	 */
	@RequestMapping(value="/deletebook")
	public String deleteBook(@RequestParam(value="bookId",defaultValue="0") int bookId,Model model){
		int row=bookRepository.removeByBookId(bookId);
		String string="";
		if (row==0) {
			string="删除书籍失败";
		}else {
			string="删除书籍成功";
		}
		model.addAttribute("tipMessage", string);
		return "tips";
	}
	
	

	
	
}
