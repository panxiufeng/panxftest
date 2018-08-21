package com.pxf.project.springbootrabbitmq;

import com.pxf.project.springbootrabbitmq.model.User;
import com.pxf.project.springbootrabbitmq.object.ObjectSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ObjectTest {

	@Autowired
	private ObjectSender sender;

	@Test
	public void sendOject() throws Exception {
		User user=new User();
		user.setName("pxf");
		user.setPassword("123456");
		sender.send(user);
	}

}