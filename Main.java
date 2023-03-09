/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pt1_college_management;

import java.util.Scanner;

/**
 *
 * @author moraman
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Variables declaration
        int userChoice;
        String idSearched;

        //Instantiation of college and loading dummy data
        College cl = new College("UAB");
        loadData(cl);

        //Main loop
        do {
            userChoice = menu();
            System.out.println();
            switch (userChoice) {
                case 1:
                    cl.showMembers();
                    break;
                case 2:
                    cl.showMembers("Student");
                    break;
                case 3:
                    cl.showMembers("PhDStudent");
                    break;
                case 4:
                    cl.showMembers("Teacher");
                    break;
                case 5:
                    idSearched = askId();
                    System.out.println();
                    cl.showMember(idSearched);
                    break;
                case 6:
                    idSearched = askId();
                    System.out.println();
                    cl.removeMember(idSearched);
                    break;
                case 7:
                    cl.showSubjects();
                    break;
                default:
                    System.out.println("Exit...");
            }
        } while (userChoice != 8);
    }

    /**
     * Method which loads dummy data that the program works with.
     *
     * @param cl Instance of the college which we work with
     */
    public static void loadData(College cl) {
        //Setting up all instances
        Student st1 = new Student("12345678A", "John", "Smith Johnson");
        Student st2 = new Student("87654321B", "Jane", "Doe Garcia");
        Student st3 = new Student("56789012C", "Michael", "Johnson Martinez");
        ScholarshipStudent st4 = new ScholarshipStudent("Complete", "34567890D", "Emma", "Garcia Rodriguez");
        ScholarshipStudent st5 = new ScholarshipStudent("Mid", "90123456E", "William", "Lee Perez");
        ScholarshipStudent st6 = new ScholarshipStudent("Basic", "78901234F", "Sofia", "Rodriguez Hernandez");
        Teacher t1 = new Teacher("01/05/2020", "45678901G", "David", "Martinez Castro");
        Teacher t2 = new Teacher("03/09/2016", "23456789H", "Olivia", "Gonzalez Ramirez");
        Teacher t3 = new Teacher("18/02/2007", "01234567I", "James", "Hernandez Castro");
        PhDStudent st7 = new PhDStudent(t1, "14/09/2021", "Permanent", "89012345J", "Emily", "Perez Rodriguez");
        PhDStudent st8 = new PhDStudent(t2, "14/09/2020", "Till 01/06/2023", "67890123K", "Daniel", "Castro Gonzalez");
        PhDStudent st9 = new PhDStudent(t3, "14/09/2022", "Permanent", "45678901L", "Isabella", "Ramirez Garcia");

        //Adding subjects to "subjects" college ArrayList
        cl.addSubject("Computer Net and Security");
        cl.addSubject("AI and Machine Learning");
        cl.addSubject("Database Systems and Management");
        cl.addSubject("Software Engineering and Development");
        cl.addSubject("Web Development");
        cl.addSubject("OS and Programming");
        cl.addSubject("UX and UI Development");
        cl.addSubject("Computer Architecture and Organization");
        cl.addSubject("Algorithm Design and Analysis");
        cl.addSubject("Distributed Systems and Cloud Computing");
        cl.addSubject("Computer Vision and Image Processing");
        cl.addSubject("Natural Language Processing");
        cl.addSubject("Big Data and Data Mining");
        cl.addSubject("Bioinformatics and Computational Biology");
        cl.addSubject("Computer Ethics");
        cl.addSubject("Cryptography and Network Security");
        cl.addSubject("Robotics and Autonomous Systems");
        cl.addSubject("Computer Science Theory and Foundations");
        cl.addSubject("Parallel Computing and High Performance Computing");
        cl.addSubject("Computer Graphics and Multimedia");

        //Adding all members to "members" college ArrayList
        cl.addMember(st1);
        cl.addMember(st2);
        cl.addMember(st3);
        cl.addMember(st4);
        cl.addMember(st5);
        cl.addMember(st6);
        cl.addMember(st7);
        cl.addMember(st8);
        cl.addMember(st9);
        cl.addMember(t1);
        cl.addMember(t2);
        cl.addMember(t3);

        //Setting up all members' subjects
        cl.setRandomMemberSubjects(st1);
        cl.setRandomMemberSubjects(st2);
        cl.setRandomMemberSubjects(st3);
        cl.setRandomMemberSubjects(st4);
        cl.setRandomMemberSubjects(st5);
        cl.setRandomMemberSubjects(st6);
        cl.setRandomMemberSubjects(st7);
        cl.setRandomMemberSubjects(st8);
        cl.setRandomMemberSubjects(st9);
        cl.setRandomMemberSubjects(t1);
        cl.setRandomMemberSubjects(t2);
        cl.setRandomMemberSubjects(t3);

    }

    /**
     * Method to display the menu. Asks user what he wants to do and returns
     * chosen option.
     *
     * @return user choice.
     */
    public static int menu() {
        Scanner scn = new Scanner(System.in);
        //boolean read = false;
        int userChoice = 0;
        System.out.println("\n        COLLEGE MANAGEMENT\n"
                + "=====================================\n"
                + "1. Show all College Members.\n"
                + "2. Show all Students.\n"
                + "3. Show PhD Students.\n"
                + "4. Show Teachers.\n"
                + "5. Search Member.\n"
                + "6. Remove Member.\n"
                + "7. Show all Subjects with their related Teachers and Students\n"
                + "8. Exit.\n");
        System.out.print("Choose an option: ");

        do {
            if (scn.hasNextInt()) {
                userChoice = scn.nextInt();
                if (userChoice > 8 || userChoice < 1) {
                    System.out.print("Error! Enter a number between 1 and 8: ");
                }
            } else {
                System.out.print("Error! Enter an Integer number between 1 and 8: ");
                scn.nextLine();
            }
        } while (userChoice < 1 || userChoice > 8);
        return userChoice;
    }

    public static String askId() {
        Scanner scn = new Scanner(System.in);
        String id;

        System.out.print("Enter the ID of the member: ");
        id = scn.next();

        return id;
    }
}
