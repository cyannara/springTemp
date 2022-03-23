package com.yedam.app;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.app.user.service.UserService;
import com.yedam.app.user.service.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/config/*-context.xml")
public class UserServiceClient {

	@Autowired
	UserService userService;
	
	@Test
	public void list() {
		List<UserVO> list = userService.getUserList(null);
		System.out.println(list);
	}
}
