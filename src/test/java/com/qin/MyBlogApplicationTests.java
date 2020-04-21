package com.qin;

import com.qin.mapper.BlogMapper;
import com.qin.pojo.Blog;
import com.qin.pojo.PageRequest;
import com.qin.pojo.Type;
import com.qin.service.BlogService;
import com.qin.service.TypeService;
import com.qin.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MyBlogApplicationTests
{

	@Autowired
	UserService userService;

	@Autowired
	TypeService typeService;

	@Autowired
	BlogService blogService;

	@Autowired
	BlogMapper blogMapper;

	@Value("${comment.avatar}")
	private String avatar;
	@Test
	void contextLoads()
	{
		System.out.println(avatar);
	}

}
