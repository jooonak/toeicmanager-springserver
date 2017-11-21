package com.toeic.web;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.toeic.mapper.TestMapper;

import lombok.extern.java.Log;

@Log
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class DBTest {

	@Inject
	DataSource ds;
	
	@Inject
	TestMapper mapper;
	
	//DB Connection Test
	@Test
	public void test1() throws Exception {
		log.info("DATA SOURCE: " + ds.getConnection());	
	}
	
	//Mapper Scan Test
	@Test
	public void test2() {
		log.info("TIME: " + mapper.connectionTest());
	}
}
