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
    private ArrayList<Member> members = new ArrayList<>(); //List of members that the College has. They can be Teachers or any type of Student.
    private ArrayList<String> subjects = new ArrayList<>(); //List of subjects that the University has available for teaching or enrollment.

    public College() {
    }

    public College(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addSubject(String s) {
        subjects.add(s);
    }

    public void setRandomMemberSubjects(Member m) {
        Random rnd = new Random();
        String subject;
        int count = 0;
        if (m instanceof Student) {
            m = (Student) m;
            while (count < 4) {
                do {
                    subject = subjects.get(rnd.nextInt(20));
                } while (m.searchSubject(subject));
                m.addSubject(subject);
                count++;
            }
        } else {
            m = (Teacher) m;
            while (count < 2) {
                do {
                    subject = subjects.get(rnd.nextInt(20));
                } while (m.searchSubject(subject));
                m.addSubject(subject);
                count++;
            }
        }
    }

    public void addMember(Member m) {
        members.add(m);
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
            System.out.println("----------------------------");
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
                    System.out.println("----------------------------");
                }
            } else {
                if (memberType.equalsIgnoreCase("Student")) {
                    if (m instanceof Student) {
                        System.out.println(m.showData());
                        System.out.println("----------------------------");
                    }
                } else if (memberType.equalsIgnoreCase("PhDStudent")) {
                    if (m instanceof PhDStudent) {
                        System.out.println(m.showData());
                        System.out.println("----------------------------");
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
            /*if (m.getClass().getSimpleName().equalsIgnoreCase(memberType)) {
                if (m instanceof Teacher) {
                    m = (Teacher) m;
                    if (m.searchSubject(subject)) {
                        System.out.println(m.showData());
                        //System.out.println(m.getFirstName() + ", " + m.getLastNames());
                    }
                } else {
                    if (m instanceof Student) {
                        m = (Student) m;
                        if (m.searchSubject(subject)) {
                            System.out.println(m.showData());
                        }
                    } else {
                        if (m instanceof PhDStudent) {
                            m = (PhDStudent) m;
                            if (m.searchSubject(subject)) {
                                System.out.println(m.showData());
                            }
                        } else {
                            m = (ScholarshipStudent) m;
                            if (m.searchSubject(subject)) {
                                System.out.println(m.showData());
                            }
                        }
                    }
                }
            }*/
            if (memberType.equals("Teacher")) {
                if (m instanceof Teacher) {
                    m = (Teacher) m;
                    if (m.searchSubject(subject)) {
                        System.out.println(m.showData());
                        //System.out.println(m.getFirstName() + ", " + m.getLastNames());
                    }
                }
            }

            if (memberType.equals("Student")) {
                if (m instanceof Student) {
                    m = (Student) m;
                    if (m.searchSubject(subject)) {
                        System.out.println(m.showData());
                    }
                } else {
                    if (m instanceof PhDStudent) {
                        m = (PhDStudent) m;
                        if (m.searchSubject(subject)) {
                            System.out.println(m.showData());
                        }
                    } else {
                        m = (ScholarshipStudent) m;
                        if (m.searchSubject(subject)) {
                            System.out.println(m.showData());
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
                    m = (Teacher) m;
                    System.out.println("Teacher\n" + m.showData());
                    break;
                case "Student":
                    m = (Student) m;
                    System.out.println("Student\n" + m.showData());
                    break;
                case "ScholarshipStudent":
                    m = (ScholarshipStudent) m;
                    System.out.println("ScholarshipStudent\n" + m.showData());
                    break;
                default:
                    m = (PhDStudent) m;
                    System.out.println("PhDStudent\n" + m.showData());
                    break;
            }
        } else {
            System.out.println("There's not any Member with this Id in the list.");
        }
    }

    /**
     * Method to show all subjects taught at the University.
     */
    public void showSubjects() {
        for (String sub : subjects) {
            System.out.println(sub + ":\n============\n");
            System.out.println("Teachers {");
            showMembers("Teacher", sub);
            System.out.println("}");

            System.out.println("Students {");
            showMembers("Students", sub);
            System.out.println("}");
        }
    }
}
