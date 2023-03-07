/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pt1_college_management;

import java.util.ArrayList;

/**
 *
 * @author moraman
 */
public class Student extends Member {

    private ArrayList<String> enrolledSubjects = new ArrayList<>();

    public Student() {
    }

    public Student(String dni, String firstName, String lastNames) {
        super(dni, firstName, lastNames);
    }

    @Override
    public String showData() {
        return "Dni: " + getDni() + "\nFirst Name: " + getFirstName() + "\nLast Names: " + getLastNames();
    }

}
