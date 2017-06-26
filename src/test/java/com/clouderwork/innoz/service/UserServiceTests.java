package com.clouderwork.innoz.service;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.clouderwork.innoz.domain.User;
import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTests {
	
	@Autowired
	UserService userService;

	@Test
	public void getAllUser() {
		User user= userService.getUser(2);
		Assert.assertEquals(1, user.getId().intValue());
	}

}
