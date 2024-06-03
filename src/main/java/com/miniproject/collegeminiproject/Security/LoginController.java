package com.miniproject.collegeminiproject.Security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
class LoginController {
	@RequestMapping("/login")
	String login() {
		return "login";
	}
}