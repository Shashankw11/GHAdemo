package org.revature.springbootdemo.exceptions;

public class UserNotFoundException extends Exception{


    public String getMessage(){
       return "This method cannot be performed due to BAD REQUEST";
    }

}
