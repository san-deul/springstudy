package com.gdu.prj08.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.gdu.prj08.dto.FileDto;
import com.gdu.prj08.dto.HistoryDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FileDaoImpl implements FileDao {

  private final SqlSessionTemplate sqlSessionTemplate;

  public final static String NS = "com.gdu.prj08.mybatis.mapper.file_t."; 
  
  @Override
  int insertFile(FileDto file) {
    
  }
  
  
  
  
  @Override
  public int registerContact(FileDto file) {
    int insertCount = sqlSessionTemplate.insert(NS + "registerContact", file);
    return insertCount;
  }

  @Override
  public int modifyContact(FileDto file) {
    int updateCount = sqlSessionTemplate.update(NS + "modifyContact", file);
    return updateCount;
  }

  @Override
  public int removeContact(int fileNo) {
    int deleteCount = sqlSessionTemplate.delete(NS + "removeContact", fileNo);
    return deleteCount;
  }

  @Override
  public List<FileDto> getContactList() {
    List<FileDto> contactList = sqlSessionTemplate.selectList(NS + "getContactList");
    return contactList;
  }

  @Override
  public FileDto getContactByNo(int fileNo) {
    FileDto file = sqlSessionTemplate.selectOne(NS + "getContactByNo", fileNo);
    return file;
  }

}