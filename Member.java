/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pt1_college_management;

/**
 *
 * @author moraman
 */
public abstract class Member {

    protected String dni;
    protected String firstName;
    protected String lastNames;

    public Member() {
    }

    public Member(String dni, String firstName, String lastNames) {
        this.dni = dni;
        this.firstName = firstName;
        this.lastNames = lastNames;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastNames() {
        return lastNames;
    }

    public void setLastNames(String lastNames) {
        this.lastNames = lastNames;
    }

    public abstract void addSubject(String subject);

    public abstract boolean searchSubject(String subject);

    public abstract String showData();
}
