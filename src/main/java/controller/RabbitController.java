package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.RabbitMQService;

@Controller
@RequestMapping(value = "/test")
public class RabbitController {

	@Autowired
	private RabbitMQService rabbitMQService;
	
	@ResponseBody
	@RequestMapping(value = "/s1")
	public String send() {
		return rabbitMQService.sendMessage();
	}
	
	@ResponseBody
	@RequestMapping(value = "/s2")
	public String send2() {
		return rabbitMQService.sendMessage2();
	}
	
	@ResponseBody
	@RequestMapping(value = "/r2")
	public void receive2() {
		rabbitMQService.receiveMessage2();
	}
}
