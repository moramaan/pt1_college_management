/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pt1_college_management;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author moraman
 */
public class College {

    private String name;
    //List of members that the College has. They can be Teachers or any type of Student.
    private ArrayList<Member> members = new ArrayList<>();
    //List of subjects that the University has available for teaching or enrollment.
    private ArrayList<String> subjects = new ArrayList<>();
    //Array to limit the quantity of assignments that each subjects can have, being teachers or students. Row 1 Teachers, Row 2 Students
    private int[][] subjectsAssignControl = new int[2][20];

    public College() {
    }

    public College(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int[][] getSubjectsAssignControl() {
        return subjectsAssignControl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addSubject(String s) {
        subjects.add(s);
    }

    public void addMember(Member m) {
        members.add(m);
    }
    
    /**
     * Method for randomly assigning to one Member of the University the subjects available in the College.
     * @param m instance to which the method assigns the subjects.
     * @param subjectsAssignControl double array of int that controls the assignment limit for Student(all) and Teacher.
     */
    public void assignRandomSubjects(Member m, int[][] subjectsAssignControl) {
        Random rnd = new Random();
        String subject;
        int count, subjectPos;
        count = 0;
        if (m instanceof Student) {
            m = (Student) m;
            while (count < 4) {
                do {
                    subjectPos = rnd.nextInt(20);
                } while (subjectsAssignControl[1][subjectPos] == 4);
                subject = subjects.get(subjectPos);
                m.addSubject(subject);
                subjectsAssignControl[1][subjectPos] += 1;
                count++;
            }
        } else {
            m = (Teacher) m;
            while (count < 2) {
                do {
                    subjectPos = rnd.nextInt(20);
                } while (subjectsAssignControl[0][subjectPos] != 0);
                subject = subjects.get(subjectPos);
                m.addSubject(subject);
                subjectsAssignControl[0][subjectPos] = 1;
                count++;
            }
        }
    }

    /**
     * Method to search a specific Member of the list by its ID.
     *
     * @param id ID of the member we want to find.
     * @return if member is found, its position in ArrayList, else -1.
     */
    public int searchMember(String id) {
        boolean found = false;
        int pos, i;
        i = 0;
        pos = -1;
        while (!found && i < members.size()) {
            if (id.equalsIgnoreCase(members.get(i).getDni())) {
                found = true;
                pos = i;
            } else {
                i++;
            }
        }
        return pos;
    }

    /**
     * Method to remove a Member of the list searching by its ID.
     *
     * @param id ID of the member we want to remove.
     */
    public void removeMember(String id) {
        Scanner scn = new Scanner(System.in);
        Member m;
        String response;
        int pos;
        pos = searchMember(id);
        if (pos != -1) {
            m = members.get(pos);
            System.out.printf("Do you confirm that you want to remove %s %s [Y/N]?\n", m.getFirstName(), m.getLastNames());
            response = scn.next();
            if (response.equalsIgnoreCase("y")) {
                members.remove(pos);
                System.out.println("Removed!!");
            } else {
                System.out.println("Not removed!!");
            }
        } else {
            System.out.println("There's not any Member with this Id in the list.");
        }
    }

    /**
     * Method to show all members in the list.
     */
    public void showMembers() {
        System.out.printf("Showing all Members in %s\n"
                + "====================================\n", getName());
        for (Member m : members) {
            System.out.println(m.getClass().getSimpleName());
            System.out.println(m.showData());
            System.out.println();
//            System.out.println("----------------------------");
        }
        System.out.println();
    }

    /**
     * Method to show all members, only matching their instance with memberType.
     *
     * @param memberType String to compare with instance of member in the list
     */
    public void showMembers(String memberType) {
        System.out.printf("Showing all %s" + "s" + " in %s\n"
                + "====================================\n", memberType, getName());
        for (Member m : members) {
            if (memberType.equalsIgnoreCase("Teacher")) {
                if (m instanceof Teacher) {
                    System.out.println(m.showData());
                    System.out.println();
//                    System.out.println("----------------------------");
                }
            } else {
                if (memberType.equalsIgnoreCase("Student")) {
                    if (m instanceof Student) {
                        System.out.println(m.showData());
                        System.out.println();
//                        System.out.println("----------------------------");
                    }
                } else if (memberType.equalsIgnoreCase("PhDStudent")) {
                    if (m instanceof PhDStudent) {
                        System.out.println(m.showData());
                        System.out.println();
//                        System.out.println("----------------------------");
                    }
                }
            }
        }
        System.out.println();
    }

    /**
     * Method to show only members matching with both params.
     *
     * @param memberType instance of Teacher, Student or descendants.
     * @param subject subject that Teacher taughts or Student is enrolled on.
     */
    public void showMembers(String memberType, String subject) {
        for (Member m : members) {
            if (memberType.equals("Teacher")) {
                if (m instanceof Teacher) {
                    if (m.searchSubject(subject)) {
                        System.out.println(m.showData());
                        System.out.println();
                    }
                }
            } else {
                if (m instanceof Student) {
                    if (m.searchSubject(subject)) {
                        System.out.println(m.showData());
                        System.out.println();
                    }
                } else {
                    if (m instanceof PhDStudent) {
                        if (m.searchSubject(subject)) {
                            System.out.println(m.showData());
                            System.out.println();
                        }
                    }
                    if (m instanceof ScholarshipStudent) {
                        if (m.searchSubject(subject)) {
                            System.out.println(m.showData());
                            System.out.println();
                        }
                    }
                }
            }
        }
    }

    /**
     * Method to show a member searching by its ID.
     *
     * @param id ID of the member we want to display.
     */
    public void showMember(String id) {
        Member m;
        int pos;
        String instance;
        pos = searchMember(id);
        if (pos != -1) {
            m = members.get(pos);
            instance = m.getClass().getSimpleName();
            switch (instance) {
                case "Teacher":
                    System.out.println("Teacher\n" + m.showData());
                case "Student":
                    System.out.println("Student\n" + m.showData());
                    break;
                case "ScholarshipStudent":
                    System.out.println("ScholarshipStudent\n" + m.showData());
                    break;
                default:
                    System.out.println("PhDStudent\n" + m.showData());
                    break;
            }
        } else {
            System.out.println("There's not any Member with this Id in the list.");
        }
    }

    /**
     * Method to show all subjects taught at the University. It also displays
     * the related members for each one.
     */
    public void showSubjects() {
        for (String sub : subjects) {
            System.out.println("\n" + sub + ":\n" + "=".repeat(sub.length() + 1));
            System.out.println("Teachers {");
            showMembers("Teacher", sub);
            System.out.println("}");

            System.out.println("\nStudents {");
            showMembers("Student", sub);
            System.out.println("}");
        }
    }
}
