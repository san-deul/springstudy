package com.gdu.prj09.dao;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Map;

import com.gdu.prj09.dto.AddressDto;
import com.gdu.prj09.dto.MemberDto;

public interface MemberDao {
  
  int insertMember(MemberDto member);
  int insertAddress(AddressDto address);
  int updateMember(MemberDto member);
  int deleteMember(int memberNo);
  int deleteMemebers(List<String> memberNoList);
  //member_no=1 과 member_no='1'이 같으니까 int로 주나 List로 주나 
  int getTotalMemberCount(); //목록 가져올 것1
  List<AddressDto> getMemberList(Map<String, Object> map);//목록 가져올 것2
  MemberDto getMemberByNo(int memberNo);
  int getTotalAddressCountByNo(int memberNo);
  List<AddressDto> getAddressListByNo(Map<String, Object> map);
}

