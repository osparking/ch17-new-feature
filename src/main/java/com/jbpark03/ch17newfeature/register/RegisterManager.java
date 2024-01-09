package com.jbpark03.ch17newfeature.register;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import lombok.Getter;

@Getter
@Service
public class RegisterManager implements ApplicationContextAware{
  private ApplicationContext context;

  @Override
  public void setApplicationContext(ApplicationContext context)
      throws BeansException {
    this.context = context;
  }
}
