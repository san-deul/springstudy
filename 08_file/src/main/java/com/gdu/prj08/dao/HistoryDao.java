package com.gdu.prj08.dao;

import java.util.List;

import com.gdu.prj08.dto.HistoryDto;



public interface HistoryDao {
  int registerContact(HistoryDto history);
  int modifyContact(HistoryDto history);
  int removeContact(int historyNo);
  List<HistoryDto> getContactList();
  HistoryDto getContactByNo(int historyNo);
}