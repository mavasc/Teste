package spring.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;
import spring.blog.models.Post;
import spring.blog.models.User;
import spring.blog.services.UserService;

import javax.validation.Valid;

@Controller
public class UsersController {
	
	@Autowired
	private UserService userService;


	@RequestMapping("/users")
	public String index(Model model, @PageableDefault(sort = {"userName"}, value = 5) Pageable pageable){		
		// Get the content of the table, TODO. find a way to paginate
		Page<User> users = this.userService.findAll(pageable);
		
		// Define variables to be passed to view
		model.addAttribute("users", users);
		// Return the view model itself
		return "users/index";
	}


}
