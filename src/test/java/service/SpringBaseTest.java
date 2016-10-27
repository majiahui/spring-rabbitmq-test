package service;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

@ContextConfiguration(locations = { "classpath*:applicationContext.xml" })
public class SpringBaseTest extends AbstractTransactionalJUnit4SpringContextTests {

}
