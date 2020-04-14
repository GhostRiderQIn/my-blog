package com.qin;

import com.qin.pojo.PageRequest;
import com.qin.pojo.Type;
import com.qin.service.TypeService;
import com.qin.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyBlogApplicationTests
{

	@Autowired
	UserService userService;

	@Autowired
	TypeService typeService;
	@Test
	void contextLoads()
	{
		System.out.println(typeService.listType(new PageRequest(1, 2)).getContent());
	}

}
