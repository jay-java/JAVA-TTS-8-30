package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.User;

@Controller
public class UserController {

//	@RequestMapping("/")
//	public String indexPage(HttpServletRequest request) {
//		request.setAttribute("num", 123);
//		request.setAttribute("name", "my Name is here");
//		List myList = new ArrayList();
//		myList.add(123);
//		myList.add("String");
//		myList.add(23465765);
//		myList.add(345.45);
//		myList.add(false);
//		request.setAttribute("list", myList);	
//		return "index";
//	}

	@RequestMapping("/index")
	public String indexPage(Model m) {
		m.addAttribute("num", 123);
		m.addAttribute("name", "my Name is here");
		List myList = new ArrayList();
		myList.add(123);
		myList.add("String");
		myList.add(23465765);
		myList.add(345.45);
		myList.add(false);
		m.addAttribute("list", myList);
		return "index";
	}

	@RequestMapping("/")
	public String homePage() {
		return "home";
	}

	@RequestMapping("/register")
	public String registerPage() {
		return "register";
	}

//	@RequestMapping(value = "/add", method = RequestMethod.POST)
//	public String addUser(HttpServletRequest request) {
//		String name = request.getParameter("name");
//		String con = request.getParameter("contact");
//		String address = request.getParameter("address");
//		String email = request.getParameter("email");
//		String pass = request.getParameter("password");
//		System.out.println(name);
//		System.out.println(con);
//		System.out.println(address);
//		System.out.println(email);
//		System.out.println(pass);
//		return "home";
//	}

//	@RequestMapping(value = "/add", method = RequestMethod.POST)
//	public String addUser(@RequestParam("name") String name, 
//			@RequestParam("contact") long contact,
//			@RequestParam("address") String address,
//			@RequestParam("email") String email,
//			@RequestParam("password") String password) {
//		System.out.println(name + contact + address + email + password);
//		return "home";
//	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addUser(@ModelAttribute User u) {
		System.out.println(u);
		return "home";
	}

}
