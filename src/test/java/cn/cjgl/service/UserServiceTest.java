package cn.cjgl.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.cjgl.model.User;
import cn.cjgl.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:*.xml")
@Commit
public class UserServiceTest {
	private static Logger logger = Logger.getLogger(UserServiceTest.class);
	
	@Autowired
	private UserService userService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddUser() {
		User user = new User();
		user.setName("Tom");
		this.userService.addUser(user);
		user = new User();
		user.setName("Jerry");
		this.userService.addUser(user);
		testQueryUsers();
	}

	@Test
	public void testModUser() {
		User user = new User();
		user.setId(1);
		user.setName("Jerry1");
		this.userService.modUser(user);
		testQueryUsers();
	}

	@Test
	public void testDelUser() {
		User user = new User();
		user.setId(1);
		this.userService.delUser(user);
		testQueryUsers();
	}

	@Test
	public void testQueryUsers() {
		User user = new User();
		List<User> userList = this.userService.queryUsers(user);
		for(User u : userList){
			logger.info(u.getId()+":"+u.getName());
		}
	}

}
