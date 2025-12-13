package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dao.UserDao;
import com.model.User;

@Controller
public class UserController {

	@Autowired
	private UserDao dao;

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
	public String homePage(Model m) {
		m.addAttribute("list", this.dao.getAllUsers());
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
	public String addUser(@ModelAttribute User u, Model m) {
		this.dao.insertOrUpdateUser(u);
		m.addAttribute("list", this.dao.getAllUsers());
		return "home";
	}

	@RequestMapping("/edit/{id}")
	public ModelAndView editUser(@PathVariable("id") int id) {
		User u = this.dao.fetchUserById(id);
		ModelAndView m = new ModelAndView();
		m.addObject("u", u);
		m.setViewName("update");
		return m;
	}

	@RequestMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") int id, Model m) {
		this.dao.deleteUser(id);
		m.addAttribute("list", this.dao.getAllUsers());
		return "home";
	}
}
