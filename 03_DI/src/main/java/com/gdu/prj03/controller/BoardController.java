package com.gdu.prj03.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gdu.prj03.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;


//bean만드는:        @Controller  @Service  @Repository
//            view - controller - service - dao

@RequiredArgsConstructor
@Controller // Controller 에서 사용하는 @Component
public class BoardController {

  /**************** DI ****************************************************************/
  /*
   * Dependency Injection
   * 1. 의존 주입
   * 2. Spring Container 에 저장된 bean 을 특정 객체에 넣어 주는 것을 의미한다.
   * 3. 방법 
   *    1) 필드 주입
   *    2) 생성자 주입
   *    3) setter 주입
   * 4. 사용 가능한 annotation
   *    1) @Inject
   *    2) @Resource, @Qualifier
   *    3) @Autowired ★★★ (대부분 이걸 사용한다.)
   *        
   * */
  
  
  // 1. 필드 주입.....타입을 기본으로해서, 타입이 같은거 가져옴
  // @Autowired
  // private BoardService boardService;
  
  // 2. 생성자 주입.....생성자의 매개변수로 자동주입됨...autowired가 타입일치하는 애를 찾아줄거임
  // 1) 생성자의 매개변수로 주입된다.
  // 2) @Autowired 를 생략할 수 있다.
 
  // private BoardService boardService;
  // public BoardController(BoardService boardService) {
  //   super();
  //   this.boardService = boardService;
  //  }

  
  // 3 setter 주입 
  //  1) 메소드의 매개변수로 주입된다.
  //  2) @AutoWired를 생략할 수 없다.
  //  3) 사실 메소드명은 상관이 없다.
  
  //private BoardService boardService;
  //@Autowired
  //public void setBoardService(BoardService boardService) {
  //  this.boardService = boardService;
  //}
  
  // 앞으로 사용할 한 가지 방식
  // final 필드 + 생성자 주입(lombok 의 @RequiredArgsConstructor를 이용해서 매개변수의 null 체크를 수행함)
  
  private final BoardService boardService; // 생성자 선언함으로써 오류사라짐..
  // 맨위에 @allargus~~선언함으로써 생성자해줫음

  
  
  
  @GetMapping("/board/list.do")
  public String list(Model model) {
    model.addAttribute("boardList", boardService.getBoardList());
    return "board/list";
  }
  
  //상세보기
  @GetMapping("/board/detail.do")
  public String detail(int boardNo, Model model) {
    model.addAttribute("board", boardService.getBoardByNo(boardNo));
    return "board/detail";
  }
  
}
