package in.himtech.learn.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import in.himtech.learn.student.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value={"/login", "/"}, method = RequestMethod.GET)
	public String getLoginPage() {
		return "login";
	}
	
	@RequestMapping(value={"/login"}, method = RequestMethod.POST)
	public String authenticateLogin(@RequestParam String userName, @RequestParam String password, ModelMap modelMap) {
		Boolean isAuthenticated = loginService.authenticateLogin(userName, password);
		if(isAuthenticated) {
			modelMap.addAttribute("userName", userName);
			return "welcome";
		} else {
			modelMap.addAttribute("loginError", "Invalid Credential!!");
			return "login";
		}
	}
	
}
