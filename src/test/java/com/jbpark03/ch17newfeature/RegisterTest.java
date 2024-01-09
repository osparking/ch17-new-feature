package com.jbpark03.ch17newfeature;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import com.jbpark03.ch17newfeature.beans.TestBeans;
import com.jbpark03.ch17newfeature.model.Passenger;
import com.jbpark03.ch17newfeature.register.PassengerRegisterEvent;
import com.jbpark03.ch17newfeature.register.RegisterManager;

@Import(TestBeans.class)
@SpringBootTest
class RegisterTest {
  @Autowired
  private RegisterManager manager;
  @Autowired
  private Passenger passenger;

  @Test
  void test() {
    var event = new PassengerRegisterEvent(passenger);
    System.out.println("등록전 승객 정보: " + passenger);
    manager.getContext().publishEvent(event);
    assertTrue(passenger.isRegistered());
  }
}
