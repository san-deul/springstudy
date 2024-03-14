package com.gdu.prj03.dao;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.gdu.prj03.dto.BoardDto;


// @Component
// Spring Container(IoC Container) 에 bean을 생성해둔다.
// Component Scan 에 의해서 찾을 수 있다. (servlet-context.xml)

//bean만드는:        @Controller  @Service  @Repository
//            view - controller - service - dao


@Repository  // DAO 에서 사용하는 @Component
public class BoardDaoImpl implements BoardDao {

  //목록
  private List<BoardDto> boardList = Arrays.asList(
        new BoardDto(1, "제목1", "내용1"),
        new BoardDto(2, "제목2", "내용2"),
        new BoardDto(3, "제목3", "내용3")
      );

  
  
  @Override
  public List<BoardDto> getBoardList() {
    return boardList;
  }

  @Override
  public BoardDto getBoardByNo(int boardNo) {
    BoardDto board = null;
    for(int i = 0, size = boardList.size(); i < size; i++) {
      if(boardNo == boardList.get(i).getBoardNo()) {
        board = boardList.get(i);
        break;
      }
    }
    return board;
  }

}
