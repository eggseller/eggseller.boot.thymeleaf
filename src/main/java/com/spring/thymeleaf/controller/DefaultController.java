package com.spring.thymeleaf.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.spring.thymeleaf.domain.User;
import com.spring.thymeleaf.repository.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DefaultController {

	private UserMapper userMapper;

	@Autowired
	public DefaultController(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	// inject via application.properties
	@Value("${welcome.message}")
	private String message;

	private List<String> tasks = Arrays.asList("a", "b", "c", "d", "e", "f", "g");

	@GetMapping("/")
	public String main(Model model) {
		model.addAttribute("message", message);
		model.addAttribute("tasks", tasks);

		return "index";
	}

	@GetMapping("/getUser")
	public String getUser(ModelMap model, @RequestParam(value = "id") String id) throws Exception {

		try {
			User user = userMapper.getUser(id);
			Map<String, Object> map = userMapper.getUserMap(id);
			System.out.println("########### map:" + map);
			System.out.println("########### user:" + user);
			model.put("map", map);
			model.put("user", user);
		} catch (Exception e) {
			e.printStackTrace();
			return "errors/error_500";
		}

		return "index";
	}

	@GetMapping("/getBoard")
	public String getBoard(ModelMap model, @RequestParam(value = "id") String id) throws Exception {

		try {
			Map<String, Object> map = userMapper.getBoardMap(id);
			System.out.println("########### map:" + map);
			model.put("map", map);
		} catch (Exception e) {
			e.printStackTrace();
			return "errors/error_500";
		}

		return "index";
	}

	// /hello?name=kotlin
	@GetMapping("/hello")
	public String mainWithParam(@RequestParam(name = "name", required = false, defaultValue = "") String name,
			ModelMap model) {

		model.addAttribute("message", name);

		return "welcome";
	}

	// @GetMapping(value = { "", "/" })
	// public String home(ModelMap model, HttpServletRequest request,
	// HttpServletResponse response,
	// @CookieValue(value = "sess", defaultValue = "") String sess,
	// @RequestParam(value = "name", defaultValue = "", required = true) String
	// name) {

	// // List<Map<String, Object>> home = new ArrayList<Map<String,Object>>();

	// Map<String, Object> map = new HashMap<String, Object>();
	// map.put("welcome", "I'm welcome from Map");

	// model.put("home", map);
	// model.put("welcome", "안녕 홈이야");

	// return "home";
	// }

	@PutMapping(value = { "/getUsers" })
	@ResponseBody
	public String getUsers(ModelMap model, @RequestParam(value = "page") String page) {

		System.out.println(page);
		return page;
	}
}
