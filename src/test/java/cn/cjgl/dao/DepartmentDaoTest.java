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

import cn.cjgl.dao.DepartmentDao;
import cn.cjgl.model.Department;
import cn.cjgl.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:*.xml")
@Commit
public class DepartmentDaoTest {
	private static Logger logger = Logger.getLogger(DepartmentDaoTest.class);
	
	@Autowired
	private DepartmentDao departmentDao;

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
	public void testAddDepartment() {
		Department department = new Department();
		department.setName("礼部");
		this.departmentDao.addDepartment(department);
		
		logger.info("testAddDepartment###");
		testQueryDepartments();
	}

	@Test
	public void testModDepartment() {
		Department department = new Department();
		department.setId(0);
		department.setName("刑部");
		this.departmentDao.modDepartment(department);
		
		logger.info("testModDepartment###");
		testQueryDepartments();
	}

	@Test
	public void testDelDepartment() {
		Department department = new Department();
		department.setId(1);
		this.departmentDao.delDepartment(department);
		
		logger.info("testDelDepartment###");
		testQueryDepartments();
	}

	@Test
	public void testQueryDepartments() {
		Department department = new Department();
		List<Department> departmentList = this.departmentDao.queryDepartments(department);
		
		logger.info("testQueryDepartments");
		for(Department e : departmentList){
			logger.info("id : " + e.getId() + "; name : " + e.getName());
			if(e.getUsers().size() > 0){
				List<User> users = e.getUsers();
				for(User u : users){
					logger.info("userid : " + u.getId() + "; username : " + u.getName());
				}
			}
		}
	}
	
	@Test
	public void testQueryDepartments1() {
		Department department = new Department();
		List<Department> departmentList = this.departmentDao.queryDepartments1(department);
		
		logger.info("testQueryDepartments");
		for(Department e : departmentList){
			logger.info("id : " + e.getId() + "; name : " + e.getName());
			if(e.getUsers().size() > 0){
				List<User> users = e.getUsers();
				for(User u : users){
					logger.info("userid : " + u.getId() + "; username : " + u.getName());
				}
			}
		}
	}

}
