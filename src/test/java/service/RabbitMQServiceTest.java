package service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

public class RabbitMQServiceTest extends SpringBaseTest {

	@Autowired
	private RabbitMQService rabbitmqService;
	
	@Test
	public void testSend() throws InterruptedException {
		rabbitmqService.sendMessage();
		Thread.sleep(10000);
	}
}
