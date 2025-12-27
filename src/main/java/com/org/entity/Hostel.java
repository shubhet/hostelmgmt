package com.example.hostel.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "hostel")
public class Hostel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String studentName;
    private String roomNumber;
    private String hostelName;
    private int age;

    public Long getId() {
        return id;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getHostelName() {
        return hostelName;
    }

    public int getAge() {
        return age;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setHostelName(String hostelName) {
        this.hostelName = hostelName;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
