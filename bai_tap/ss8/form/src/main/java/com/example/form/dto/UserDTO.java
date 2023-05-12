package com.example.form.dto;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

public class UserDTO implements Validator {
    private Integer id;

    @NotBlank(message = "First name cannot be empty")
    @Size(min = 5, max = 45, message = "Input more than 5 character and less than 45 character")
    private String firstName;

    @NotBlank(message = "Last name cannot be empty")
    @Size(min = 5, max = 45, message = "Input more than 5 character and less than 45 character")
    private String lastName;

    @NotBlank(message = "Phone number cannot be empty")
    @Pattern(regexp = "^\\d{2}-0\\d{9}$", message = "Incorrect phone number syntax. Example: 0xxxxxxxxx")
    private String phoneNumber;

    @NotNull(message = "Age cannot be empty")
    @Min(18)
    private Integer age;

    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Incorrect email syntax example xxx@xxx.xxx (xxx: (A-Z)or (a-z) or number or character special)")
    private String email;

    public UserDTO() {
    }

    public UserDTO(Integer id, String firstName, String lastName, String phoneNumber, Integer age, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
