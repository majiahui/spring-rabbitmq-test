package service;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import entity.HisAddress;

@ContextConfiguration(locations = { "classpath*:applicationContext.xml" })
public class HisAddressTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private HisAddressService hisAddressService;
	
	@Test
	public void testGetAddressById() {
		HisAddress address = hisAddressService.getAddressById(223L);
		System.out.println(address);
	}
	
	@Test
	@Rollback(false)
	public void testInsert() {
		HisAddress addr = new HisAddress();
		addr.setDomain("test");
		addr.setGuid("1111");
		addr.setRecordTime(new Date());
		addr = hisAddressService.insert(addr);
		System.out.println(addr);
	}
}
