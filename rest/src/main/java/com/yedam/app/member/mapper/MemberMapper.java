package com.yedam.app.member.mapper;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.yedam.app.member.service.MemberVO;

public interface MemberMapper {

    int insertMember(MemberVO memberVO);

    int updateMember(MemberVO memberVO);

    int deleteMember(MemberVO memberVO);

    @Select("select * from member where id = #{memberId}")
    MemberVO selectMemberById(@Param("memberId") String memberId);

    @Select("SELECT * FROM member")
    List<MemberVO> selectMemberList();

    @Select("SELECT * FROM member WHERE id = #{memberId} and password = #{password}")
    Optional<MemberVO> login(@Param("memberId") String memberId, @Param("password")String password);
}
