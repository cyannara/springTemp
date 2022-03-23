package com.yedam.app;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.app.member.mapper.MemberMapper;
import com.yedam.app.member.service.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/config/*-context.xml")
public class MemberMapperClient {

	@Autowired MemberMapper mapper;
	
	//@Test
	public void listTest() {
		List<MemberVO> list = mapper.selectMemberList();
		System.out.println(list);
		
	}
	
	@Test
	public void selectTest() {
		MemberVO vo = mapper.selectMemberById("kim");
		System.out.println(vo);
		assertEquals(vo.getId(), "kim");
	}
	
	//@Test
	public void insertTest() {
		MemberVO vo = new MemberVO();
		vo.setId("park");
		vo.setPassword("111");
		//vo.setAuthor("kima");
		vo.setTel("011");
		vo.setName("김길동");
		vo.setAddress("대구");
		int r = mapper.insertMember(vo);
		assertEquals(r, 1);
	}
}
