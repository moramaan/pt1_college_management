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
public class Teacher extends Member {

    private String startDate;
    private ArrayList<String> subjectsTaught = new ArrayList<>();

    public Teacher() {
    }

    public Teacher(String startDate, String dni, String firstName, String lastNames) {
        super(dni, firstName, lastNames);
        this.startDate = startDate;
    }

    @Override
    public void addSubject(String subject) {
        subjectsTaught.add(subject);
    }

    @Override
    public boolean searchSubject(String subject) {
        boolean found = false;
        int i = 0;
        while (!found && i < subjectsTaught.size()) {
            if (subject.equalsIgnoreCase(subjectsTaught.get(i))) {
                found = true;
            } else {
                i++;
            }
        }
        return found;
    }

    @Override
    public String showData() {
        return "Dni: " + getDni() + "\nFirst Name: " + getFirstName() + "\nLast Names: " + getLastNames();
    }

}
