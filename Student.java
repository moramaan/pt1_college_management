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

    public Student(String dni, String firstName, String lastName) {
        super(dni, firstName, lastName);
    }

    @Override
    public void addSubject(String subject) {
        enrolledSubjects.add(subject);
    }

    @Override
    public boolean searchSubject(String subject) {
        boolean found = false;
        int i = 0;
        while (!found && i < enrolledSubjects.size()) {
            if (subject.equalsIgnoreCase(enrolledSubjects.get(i))) {
                found = true;
            } else {
                i++;
            }
        }
        return found;
    }

    @Override
    public String showData() {
        return "Dni: " + getId() + "\nFirst Name: " + getFirstName() + "\nLast Name: " + getLastName();
    }

}
