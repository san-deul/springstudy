package com.gdu.myapp.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UserService {
  void signin(HttpServletRequest request, HttpServletResponse response); // 로그인
  void signout(HttpServletRequest request, HttpServletResponse response); // 로그아웃
  void signup(HttpServletRequest request, HttpServletResponse response); // 가입
  void leave(HttpServletRequest request, HttpServletResponse response); // 탈퇴
}
