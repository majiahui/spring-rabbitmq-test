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
	@RequestMapping(value = "/v1")
	public String send() {
		return rabbitMQService.sendMessage();
	}
}
