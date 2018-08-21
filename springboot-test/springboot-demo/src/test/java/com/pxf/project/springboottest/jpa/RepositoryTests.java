package com.pxf.project.springboottest.jpa;

import com.pxf.project.springboottest.jpa.interfaces.UserAuthIdSymbolRepository;
import com.pxf.project.springboottest.jpa.model.UserAuthIdSymbol;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RepositoryTests {

	@Autowired
	private UserAuthIdSymbolRepository userAuthIdSymbolRepository;

	@Test
	public void test() throws Exception {
		UserAuthIdSymbol userAuthIdSymbol =  userAuthIdSymbolRepository.findByAuthId("AUTH00001");
		System.out.println("userAuthIdSymbol---------->"+userAuthIdSymbol.toString());
	}

}