package com.patientservice.patientservice.Exceptions;

public class EmailAlreadyExists extends RuntimeException {
    public EmailAlreadyExists(String emailAlreadyExists) {
      super(emailAlreadyExists);
    }
}
