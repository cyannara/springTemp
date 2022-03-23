package com.yedam.app.member.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.google.common.net.MediaType;
import com.yedam.app.member.mapper.MemberMapper;
import com.yedam.app.member.service.MemberVO;

/*
 * rest uri
 */
@RestController
@CrossOrigin(origins = {"http://127.0.0.1:5500"})
public class MemberRestController {

	@Autowired MemberMapper mapper;
	
	@GetMapping("/movie")
	public Map movie() {
		RestTemplate template = new RestTemplate();
		String url = "https://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchWeeklyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=20220320";
		Map map = template.getForObject(url, Map.class);
		return map;
	}
	
	@GetMapping(value = "/test",  produces = "text/plain")
	public ResponseEntity<String> test(@RequestParam int num){
		if(num <10) {  //error
			return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("error");
		} else {
			return ResponseEntity.status(HttpStatus.OK).body("success");
		}
	}
	//, produces = {MediaType.JSON_UTF_8, MediaType.XML_UTF_8}
	@GetMapping(value="/member", produces = {"application/json", "application/xml"})
	//@ResponseBody //jackson : Object -> json string
	public List<MemberVO> list(){
		return mapper.selectMemberList();
	}
	
	@PostMapping("/member")
	public MemberVO insert(MemberVO vo){
		mapper.insertMember(vo);
		return vo;
	}
	
	@PutMapping("/member")
	public MemberVO update(@RequestBody MemberVO vo){
		
		mapper.updateMember(vo);
		return vo;
	}
	
	@GetMapping("/member/{id}")
	public MemberVO select(@PathVariable String id){	
		return mapper.selectMemberById(id);
	}
	
	@DeleteMapping("/member/{id}")
	public MemberVO update(@PathVariable String id){
		MemberVO vo = new MemberVO();
		vo.setId(id);
		mapper.deleteMember(vo);
		return vo;
	}
}
