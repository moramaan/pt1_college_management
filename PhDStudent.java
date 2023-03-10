/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pt1_college_management;

/**
 *
 * @author moraman
 */
public class PhDStudent extends Student {

    private Teacher manager;
    private String startDate;
    private String agreementType;

    public PhDStudent() {
    }

    public PhDStudent(Teacher manager, String startDate, String agreementType, String id, String firstName, String lastName) {
        super(id, firstName, lastName);
        this.manager = manager;
        this.startDate = startDate;
        this.agreementType = agreementType;
    }

    public Teacher getManager() {
        return manager;
    }

    public void setManager(Teacher manager) {
        this.manager = manager;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getAgreementType() {
        return agreementType;
    }

    public void setAgreementType(String agreementType) {
        this.agreementType = agreementType;
    }

    @Override
    public String showData() {
        return super.showData() + "\nTeacher: " + manager.getFirstName()
                + ", " + manager.getLastName() + "\nStart Date: " + getStartDate() + "\nAgreement Type: " + getAgreementType();
    }

}
