package com.codegym.model;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
public class User implements Validator{
    private String firstName;
    private String lastName;
    private int age;
    private String phoneNumber;
    private String email;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @Override
   public boolean supports(Class<?> clazz){
        return User.class.isAssignableFrom(clazz);
    }
    @Override
    public void validate(Object target,Errors errors){
        User user = (User) target;
        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        int age = user.getAge();
        String phoneNumber = user.getPhoneNumber();
    String email = user.getEmail();
        ValidationUtils.rejectIfEmpty(errors,"firstName","firstName.empty");
        ValidationUtils.rejectIfEmpty(errors,"lastName","lastName.empty");
        ValidationUtils.rejectIfEmpty(errors,"age","age.empty");
        ValidationUtils.rejectIfEmpty(errors,"phoneNumber","phoneNumber.empty");
        ValidationUtils.rejectIfEmpty(errors,"email","email.empty");
        if(firstName.length()<1 || firstName.length()>45) {
        errors.rejectValue("firstName", "firstName.length");
    }
        if(lastName.length()<1 || lastName.length()>45){
        errors.rejectValue("lastName","lastName.length");
    }
        if(age < 5 ){
        errors.rejectValue("age","age.errorAge");
    }
        if (!phoneNumber.matches("(^$|[0-9]*$)")){
        errors.rejectValue("phoneNumber","phoneNumber.matches");
    }
        if (!email.matches( "^(.+)@(.+)$")){
        errors.rejectValue("email","email.matches");
    }
}
}
