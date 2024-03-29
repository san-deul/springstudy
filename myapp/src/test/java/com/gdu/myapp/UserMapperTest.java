package com.gdu.myapp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.gdu.myapp.dto.UserDto;
import com.gdu.myapp.mapper.UserMapper;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations="file:sr/main/webapp/WEB-INF/spring/root-contex.xml")
class UserMapperTest {

   @Autowired
  private UserMapper userMapper;
  
  void test() {
    assertEquals(1, userMapper.insertUser(new UserDto()));
  }
}
