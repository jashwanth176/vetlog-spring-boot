package com.jos.dem.vetlog.validator

import org.springframework.validation.Validator
import org.springframework.validation.Errors
import org.springframework.stereotype.Component

import com.jos.dem.vetlog.command.UserCommand

@Component
class UserValidator implements Validator {

  @Override
  public boolean supports(Class<?> clazz) {
    return UserCommand.class.equals(clazz)
  }	

  @Override
  public void validate(Object target, Errors errors) {
    UserCommand UserCommand = (UserCommand) target
  }

}