package com.gdu.prj09.dao;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import com.gdu.prj09.dto.AddressDto;
import com.gdu.prj09.dto.MemberDto;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class MemberDaoImpl implements MemberDao {

  private final SqlSessionTemplate sqlSessionTemplate;
  
  public final static String Ns = "com.gdu.prj09.mybatis.mapper.member_t.";
  
  
  @Override
  public int insertMember(MemberDto member) {
    return sqlSessionTemplate.insert(Ns + "insertMember", member);
  }
  
  @Override
  public int insertAddress(AddressDto address) {
    return sqlSessionTemplate.insert(Ns + "insertAddress", address);
  }

  @Override
  public int updateMember(MemberDto member) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int deleteMember(int memberNo) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int deleteMemebers(List<String> memberNoList) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int getTotalMemberCount() {

    return sqlSessionTemplate.selectOne(Ns + "getTotalMemberCount");
  }

  @Override
  public List<AddressDto> getMemberList(Map<String, Object> map) {
    // TODO Auto-generated method stub
    return sqlSessionTemplate.selectList(Ns +"getMemberList",map);
  }

  @Override
  public MemberDto getMemberByNo(int memberNo) {
    return sqlSessionTemplate.selectOne(Ns + "getMemberByNo", memberNo);
  }
  
  @Override
  public int getTotalAddressCountByNo(int memberNo) {
    return sqlSessionTemplate.selectOne(Ns + "getTotalAddressCountByNo" , memberNo);
  }

  @Override
  public List<AddressDto> getAddressListByNo(Map<String, Object> map) {
    return sqlSessionTemplate.selectList(Ns + "getAddressListByNo", map);
  }
    //List를 반환하든 MemberDto를 반환하든, MemeberDto를 반환하는 거임
}
