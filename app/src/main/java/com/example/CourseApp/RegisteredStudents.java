package com.example.CourseApp;

public class RegisteredStudents {

    private String courseName;
    private String email;
    private String name;
    private String phone;

    public RegisteredStudents(String eMail,String courseName, String name, String phone){
        this.setCourseName(courseName);
        this.setEmail(eMail);
        this.setName(name);
        this.setPhone(phone);
    }

    private void setEmail(String eMail) {
        this.email = eMail;
    }

    public String getEmail() {
        return email;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


}
