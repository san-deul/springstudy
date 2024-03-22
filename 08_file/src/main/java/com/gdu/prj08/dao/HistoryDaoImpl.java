package com.gdu.prj08.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.gdu.prj08.dto.FileDto;
import com.gdu.prj08.dto.HistoryDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class HistoryDaoImpl implements HistoryDao {

  private final SqlSessionTemplate sqlSessionTemplate;

  public final static String NS = "com.gdu.prj08.mybatis.mapper.file_t."; 
  
  @Override
  public int registerContact(HistoryDto history) {
    int insertCount = sqlSessionTemplate.insert(NS + "registerContact", history);
    return insertCount;
  }

  @Override
  public int modifyContact(HistoryDto history) {
    int updateCount = sqlSessionTemplate.update(NS + "modifyContact", history);
    return updateCount;
  }

  @Override
  public int removeContact(int historyNo) {
    int deleteCount = sqlSessionTemplate.delete(NS + "removeContact", historyNo);
    return deleteCount;
  }

  @Override
  public List<HistoryDto> getContactList() {
    List<HistoryDto> contactList = sqlSessionTemplate.selectList(NS + "getContactList");
    return contactList;
  }

  @Override
  public HistoryDto getContactByNo(int historyNo) {
    HistoryDto history = sqlSessionTemplate.selectOne(NS + "getContactByNo", historyNo);
    return history;
  }

}