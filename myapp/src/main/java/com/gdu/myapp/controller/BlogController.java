package com.gdu.myapp.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gdu.myapp.service.BlogService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/blog")
@RequiredArgsConstructor
@Controller
public class BlogController {

  private final BlogService blogService;
  
  @GetMapping("/list.page")
  public String list() {
    return "blog/list";
  }
  /*그동안은 목록을 가지고 갔다면, 이번에는 그냥 감.. 거기서 자바스크립트가 불러올거임*/

  @GetMapping("/write.page")
  public String writePage() {
    return "blog/write";
  }
  
  @PostMapping(value="/summernote/imageUpload.do", produces="application/json")
  public ResponseEntity<Map<String, Object>> summernoteImageUpload(@RequestParam("image") MultipartFile multipartFile, MultipartHttpServletRequest multipartRequest) {
    return blogService.summernoteImageUpload(multipartFile, multipartRequest.getContextPath());
  }
  
  
  @PostMapping("/register.do")
  public String register(HttpServletRequest request, RedirectAttributes redirectAttributes) {
    redirectAttributes.addFlashAttribute("insertCount", blogService.registerBlog(request));
    return "redirect:/blog/list.page";
  }
  
  @GetMapping(value="/getBlogList.do", produces="application/json")
  public ResponseEntity<Map<String,Object>> getBlogList(HttpServletRequest request){
    return blogService.getBlogList(request);
  }
  
  @GetMapping("/updateHit.do")
  public String updateHit(@RequestParam int blogNo) {
    blogService.updateHit(blogNo);
    return "redirect:/blog/detail.do?blogNo=" + blogNo;
  }
  
  @GetMapping("/detail.do")
  public String detail(@RequestParam int blogNo, Model model) {
    model.addAttribute("blog", blogService.getBlogByNo(blogNo));
    return "blog/detail";
  }
  
  
  @PostMapping(value="/registerComment.do", produces = "application/json")
  public ResponseEntity<Map<String, Object>> registerComment(HttpServletRequest request){
    
   /* 
     return new ResponseEntity<Map<String,Object>>(Map.of("insertCount", blogService.registerComment(request))
                                                  , HttpStatus.OK);
   */
    return ResponseEntity.ok(Map.of("insertCount", blogService.registerComment(request)));
    
  }
  
  @GetMapping(value="/comment/list.do", produces="application/json")
  public ResponseEntity<Map<String, Object>> commentList(HttpServletRequest request){
    
    /*
    return new ResponseEntity<>(blogService.getCommentList(request)
                              , HttpStatus.OK);
    */
    return ResponseEntity.ok(blogService.getCommentList(request));
  }
  
  @PostMapping(value="/comment/registerReply.do", produces="application/json")
  public ResponseEntity<Map<String, Object>> registerReply(HttpServletRequest request){
    
    return ResponseEntity.ok(Map.of("insertReplyCount", blogService.registerReply(request)));
  }
  
  /**/
  @GetMapping("/removeBlog.do")
  public String removeBlog(@RequestParam int blogNo, RedirectAttributes redirectAttributes) {
      redirectAttributes.addFlashAttribute("removeBlogCount",blogService.removeBlog(blogNo));
      return "redirect:/blog/list.do";
  }
  
  
}
