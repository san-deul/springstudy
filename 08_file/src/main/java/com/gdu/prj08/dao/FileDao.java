package com.gdu.prj08.dao;

import java.util.List;

import com.gdu.prj08.dto.FileDto;

public interface FileDao {
  int registerContact(FileDto file);
  int modifyContact(FileDto file);
  int removeContact(int fileNo);
  List<FileDto> getContactList();
  FileDto getContactByNo(int fileNo);
}