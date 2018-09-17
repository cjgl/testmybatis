package cn.cjgl.dao;

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

import cn.cjgl.dao.UserDao;
import cn.cjgl.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:*.xml")
@Commit
public class UserDaoTest {
	private static Logger logger = Logger.getLogger(UserDaoTest.class);
	
	@Autowired
	private UserDao userDao;

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
		this.userDao.addUser(user);
		user = new User();
		user.setName("Jerry");
		this.userDao.addUser(user);
		
		logger.info("testAddUser###");
		testQueryUsers();
	}

	@Test
	public void testModUser() {
		User user = new User();
		user.setId(1);
		user.setName("Tom1");
		this.userDao.modUser(user);
		
		logger.info("testModUser###");
		testQueryUsers();
	}

	@Test
	public void testDelUser() {
		User user = new User();
		user.setId(1);
		this.userDao.delUser(user);
		
		logger.info("testDelUser###");
		testQueryUsers();
	}

	@Test
	public void testQueryUsers() {
		User user = new User();
		List<User> userList = this.userDao.queryUsers(user);
		
		logger.info("testQueryUsers");
		for(User u : userList){
			logger.info("id : " + u.getId() + ", name : " + u.getName());
			if(u.getDepartment() != null){
				logger.info("departmentid : " + u.getDepartment().getId() + ", department : " + u.getDepartment().getName());
			}
		}
	}
	
	@Test
	public void testQueryUsers1() {
		User user = new User();
		List<User> userList = this.userDao.queryUsers1(user);
		
		logger.info("testQueryUsers1");
		for(User u : userList){
			logger.info("id : " + u.getId() + ", name : " + u.getName());
			if(u.getDepartment() != null){
				logger.info("departmentid : " + u.getDepartment().getId() + ", department : " + u.getDepartment().getName());
			}
		}
	}

}
