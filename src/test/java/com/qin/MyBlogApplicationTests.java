package com.qin;

import com.qin.pojo.PageRequest;
import com.qin.pojo.Type;
import com.qin.service.BlogService;
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

	@Autowired
	BlogService blogService;
	@Test
	void contextLoads()
	{

		System.out.println(blogService.listBlog(new PageRequest(1, 2),null));
		System.out.println(blogService.getBlogById(1l));
	}

}
