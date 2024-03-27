package com.gdu.prj09.service;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;

import com.gdu.prj09.dto.MemberDto;

public interface MemberService {

  /*
   * service는 dao를 1:1로 처리하지 않음
   * 하나의 서비스는 여러개의 다오를 부를 수 있음*/
  
  // 서비스가 반환하는 값 다 호출
  //@ResponseBody를 품고있는대 ..@ResponseBody
  ResponseEntity<Map<String, Object>> getMembers(int page, int display);
  //파라미터 받아올것:display,page
  
  /*스프링에서 파라미터 받는방법 3가지
  HttpServletRequest
  @RequestParam
    MyPageUtils
    */
/*prk09/members?page=1&display=20  <이제껏 햇던 방식 @requdstParm*/
  /*prk09/members/page/1/display/20 <새로운 방식> 경로포함된 데이터:@PathVralable*/
// 둘 다 변수로 받을 수있듬
  
/*  -------> getMembers(int page, int display)------->GetTotalNemberCount()
                                               GETMEMBERlIST(MAP,AMP)                                              
*/
  ResponseEntity<Map<String,Object>> getMemberByNo(int memberNo);
  ResponseEntity<Map<String, Object>> registerMember(Map<String, Object> map, HttpServletResponse response);
  ResponseEntity<Map<String, Object>> modifyMember(Map<String, Object> map);
  ResponseEntity<Map<String, Object>> removeMember(int memberNo);
  ResponseEntity<Map<String, Object>> removeMembers(String memberNoList);
  
  
}
