/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pt1_college_management;

/**
 *
 * @author moraman
 */
public class ScholarshipStudent extends Student {

    private String scholarchipType;

    public ScholarshipStudent() {
    }

    public ScholarshipStudent(String scholarchipType, String dni, String firstName, String lastNames) {
        super(dni, firstName, lastNames);
        this.scholarchipType = scholarchipType;
    }

    public String getScholarchipType() {
        return scholarchipType;
    }

    public void setScholarchipType(String scholarchipType) {
        this.scholarchipType = scholarchipType;
    }

    @Override
    public String showData() {
        return super.showData() + "\nScholarship Type: " + getScholarchipType();
    }

}
