package com.gdu.prj03.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdu.prj03.dao.BoardDao;
import com.gdu.prj03.dto.BoardDto;

import lombok.RequiredArgsConstructor;

//bean만드는:        @Controller  @Service  @Repository
//            view - controller - service - dao

@RequiredArgsConstructor
@Service  // Service 에서 사용하는 @Component
public class BoardServiceImpl implements BoardService {

  //서비스가 필요로하는 건 다오이기때문에 서비스는 필드를 잡아야함
   
   private final BoardDao boardDao;
  
  @Override
  public List<BoardDto> getBoardList() {
    return boardDao.getBoardList();
  }

  @Override
  public BoardDto getBoardByNo(int boardNo) {
    return boardDao.getBoardByNo(boardNo);
  }

}
