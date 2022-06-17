package com.example.CourseApp;

public class Courses {

    private String name;
    private int targetNumber;
    private int remainingChairs;

    public Courses(String name, int targetNumber, int remainingChairs){

        this.setName(name);
        this.setTargetNumber(targetNumber);
        this.setRemainingChairs(remainingChairs);
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getTargetNumber() {
        return targetNumber;
    }
    public void setTargetNumber(int targetNumber) {
        this.targetNumber = targetNumber;
    }
    public int getRemainingChairs() {
        return remainingChairs;
    }
    public void setRemainingChairs(int remainingChairs) {
        this.remainingChairs = remainingChairs;
    }
}