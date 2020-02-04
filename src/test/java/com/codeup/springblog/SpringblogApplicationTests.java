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
public class SpringblogApplicationTests {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private UserRepository userDao;

    @Autowired
    private PasswordEncoder pen;

    private User testUser;

    private HttpSession session;


    public void setUpTestUser() {
        testUser = userDao.findByUsername("testUser");
        if (testUser == null){
            testUser = new User();
            testUser.setUsername("testUser");
            testUser.setEmail("test@email.com");
            testUser.setPassword(pen.encode("password"));
            this.testUser = userDao.save(testUser);
        }

        System.out.println("=============" + testUser.getUsername());
        System.out.println("=============" + testUser.getPassword());

    }

    private void setUpSession() throws Exception {
        session = mvc.perform(post("/login").with(csrf())
                .param("username", testUser.getUsername())
                .param("password", "password")
        )
                .andExpect(status().isFound())
                .andReturn()
                .getRequest()
                .getSession();
    }

    @Before
    public void setUp() throws Exception {
        setUpTestUser();
        setUpSession();
    }

    @Test
    public void sessionIsValid() {
        assertNotNull(session);
    }

//    @Test
//    void contextLoads() {
//    }
//
//    @Test public void twoIsTwo(){
//        assertEquals(2,2);
//    }

    @Test
    public void testMvcNotNull(){
        assertNotNull(mvc);
    }

    @Test
    public void testAboutPage() throws Exception {
        mvc.perform(get("/landing").session((MockHttpSession) session))
                .andExpect(status().isOk())
                .andExpect(view().name("landing"))
                .andExpect(content().string(containsString("landing page")));
    }

    @After
    public void cleanUp(){
        userDao.delete(testUser);
    }

}
