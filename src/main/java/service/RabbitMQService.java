package service;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQService {

	@Autowired
    private AmqpTemplate amqpTemplate;
	
	public String sendMessage() {
		DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
		String dateStr = new DateTime().toString(fmt);
		String msg = "Hello " + dateStr;
		amqpTemplate.convertAndSend("test.one", msg);
		return msg;
	}
	
	public void receiveMessage(String msg) {
		System.out.println("receive message : " + msg);
		throw new RuntimeException();
	}
}
