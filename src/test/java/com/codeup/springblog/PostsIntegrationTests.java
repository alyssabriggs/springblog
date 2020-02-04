package com.codeup.springblog;

import com.codeup.springblog.models.User;
import com.codeup.springblog.repositories.UserRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.servlet.http.HttpSession;

import static junit.framework.TestCase.assertNotNull;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringblogApplication.class)
@AutoConfigureMockMvc
public class PostsIntegrationTests {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private UserRepository userDao;

	@Autowired
	private PasswordEncoder pen;

	private User testUser;

	private HttpSession session;


	private void setUpTestUser(){
		this.testUser = userDao.findByUsername("testUser");
		if (testUser == null){
			testUser = new User();
			testUser.setUsername("testUser");
			testUser.setEmail("testUser@mail.com");
			testUser.setPassword(pen.encode("password"));
			this.testUser = userDao.save(testUser);
		}
	}

	private void setUpSession() throws Exception {
		this.session = mvc.perform(post("/login").with(csrf())
				.param("username", testUser.getUsername())
				.param("password", "password"))
				.andExpect(status().isFound())
				.andReturn()
				.getRequest()
				.getSession();
	}
}
