package cn.cjgl.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:*.xml" }) 
@Transactional
public class UserControllerTest {
	
	@Autowired
    WebApplicationContext wac;
	
	@Autowired
	MockHttpServletRequest request;
	
	@Autowired
	MockHttpSession session;

    MockMvc mockMvc;
    
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.mockMvc = webAppContextSetup(this.wac).build();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testQueryUsers() throws Exception {
		request.setAttribute("rID", "123");
		session.setAttribute("sID", "sID=test");
		
		mockMvc.perform(post("/user/queryUsers.do").session(session)
				.accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(status().isOk())
				.andDo(print());
		
		mockMvc.perform(get("/user/queryUsers.do")
				.accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testAddUser() throws Exception {
		mockMvc.perform(post("/user/addUser.do")
				.param("name","Tom")
				.param("pwd", "123456")
				.accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(status().isOk()).andDo(print());
		
		mockMvc.perform(post("/user/queryUsers.do")
				.accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(status().isOk())
				.andDo(print());
	}

	@Test
	public void testDelUser() throws Exception {
		mockMvc.perform(post("/user/delUser.do")
				.param("id","1")
				.accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(status().isOk())
				.andDo(print());
		
		mockMvc.perform(post("/user/queryUsers.do")
				.accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(status().isOk())
				.andDo(print());
	}

	@Test
	public void testModUser() throws Exception {
		mockMvc.perform(post("/user/modUser.do")
				.param("id","1")
				.param("name", "Jerry")
				.accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(status().isOk()).andDo(print());
		
		mockMvc.perform(post("/user/queryUsers.do")
				.accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(status().isOk())
				.andDo(print());
	}

}
