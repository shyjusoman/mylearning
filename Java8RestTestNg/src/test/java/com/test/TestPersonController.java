package com.test;


//import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.nio.charset.Charset;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.hamcrest.Matchers.*;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@SpringBootTest
@WebAppConfiguration
public class TestPersonController extends AbstractTestNGSpringContextTests {

@Autowired
WebApplicationContext webApplicationContext;

MockMvc mockMvc;


private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
        MediaType.APPLICATION_JSON.getSubtype(),
        Charset.forName("utf8"));

@BeforeMethod
private void prepare(){
	mockMvc=webAppContextSetup(webApplicationContext).build();
}
@Test
public void testGetAllPersons1() throws Exception {
	//mockMvc=webAppContextSetup(webApplicationContext).build();
	mockMvc.perform(get("/persons/")).andExpect(status().isOk())
	.andExpect(content().contentType(contentType))
       .andExpect(jsonPath("$", hasSize(4))).andExpect(jsonPath("$[0].name", anything()));
  }

@Test
public void testGetAllPersons2() throws Exception {
	//mockMvc=webAppContextSetup(webApplicationContext).build();
	mockMvc.perform(get("/persons/")).andExpect(status().isOk())
	.andExpect(content().contentType(contentType))
       .andExpect(jsonPath("$", hasSize(4))).andExpect(jsonPath("$[0].name", anything()));
  }
}
