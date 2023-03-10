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

        //Declaration of college, loading dummy data and instantiation of cl
        College cl;
        cl = loadData();

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
     * @return Instance of College
     */
    public static College loadData() {
        //Setting up all instances
        College cl = new College("UAB");
        Teacher t1 = new Teacher("01/05/2020", "45678901G", "David", "Martinez Castro");
        Teacher t2 = new Teacher("03/09/2016", "23456789H", "Olivia", "Gonzalez Ramirez");
        Teacher t3 = new Teacher("18/02/2007", "01234567I", "James", "Hernandez Castro");
        Teacher t4 = new Teacher("02/09/2002", "89012345V", "Sofia", "Rodriguez Hernandez");
        Teacher t5 = new Teacher("14/09/2006", "67890123W", "William", "Lee Perez");
        Teacher t6 = new Teacher("20/06/2010", "34567890X", "Sophie", "Gonzalez Rodriguez");
        Teacher t7 = new Teacher("05/03/2014", "90123456Y", "Robert", "Hernandez Fernandez");
        Teacher t8 = new Teacher("09/11/2018", "78901234Z", "Isabella", "Castro Martinez");
        Teacher t9 = new Teacher("22/08/2005", "56789012A", "Andrew", "Lee Perez");
        Teacher t10 = new Teacher("12/07/2012", "12345678B", "Maria", "Ramirez Hernandez");
        Student st1 = new Student("12345678A", "John", "Smith Johnson");
        Student st2 = new Student("87654321B", "Jane", "Doe Garcia");
        Student st3 = new Student("56789012C", "Michael", "Johnson Martinez");
        ScholarshipStudent st4 = new ScholarshipStudent("Complete", "34567890D", "Emma", "Garcia Rodriguez");
        ScholarshipStudent st5 = new ScholarshipStudent("Mid", "90123456E", "William", "Lee Perez");
        ScholarshipStudent st6 = new ScholarshipStudent("Basic", "78901234F", "Sofia", "Rodriguez Hernandez");
        PhDStudent st7 = new PhDStudent(t1, "14/09/2021", "Permanent", "89012345J", "Emily", "Perez Rodriguez");
        PhDStudent st8 = new PhDStudent(t2, "14/09/2020", "Till 01/06/2023", "67890123K", "Daniel", "Castro Gonzalez");
        PhDStudent st9 = new PhDStudent(t3, "14/09/2022", "Permanent", "45678901L", "Isabella", "Ramirez Garcia");
        Student st10 = new Student("23456789M", "Maria", "Rodriguez Fernandez");
        Student st11 = new Student("89012345N", "Carlos", "Gonzalez Diaz");
        Student st12 = new Student("67890123J", "Ana", "Hernandez Lopez");
        ScholarshipStudent st13 = new ScholarshipStudent("Basic", "45678901P", "Luis", "Garcia Torres");
        ScholarshipStudent st14 = new ScholarshipStudent("Mid", "23456789Q", "Ana", "Perez Soto");
        ScholarshipStudent st15 = new ScholarshipStudent("Complete", "01234567R", "Juan", "Hernandez Reyes");
        PhDStudent st16 = new PhDStudent(t1, "14/09/2020", "Till 01/06/2023", "89012345S", "Maria", "Torres Fernandez");
        PhDStudent st17 = new PhDStudent(t4, "14/09/2021", "Permanent", "67890123T", "Carlos", "Diaz Ramirez");
        PhDStudent st18 = new PhDStudent(t5, "14/09/2022", "Permanent", "45678901U", "Ana", "Lopez Soto");
        Student st19 = new Student("34567890V", "Oliver", "Taylor");
        Student st20 = new Student("90123456W", "Sophia", "Garcia Martinez");

        /*


         */
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
        cl.addMember(st10);
        cl.addMember(st11);
        cl.addMember(st12);
        cl.addMember(st13);
        cl.addMember(st14);
        cl.addMember(st15);
        cl.addMember(st16);
        cl.addMember(st17);
        cl.addMember(st18);
        cl.addMember(st19);
        cl.addMember(st20);
        cl.addMember(t1);
        cl.addMember(t2);
        cl.addMember(t3);
        cl.addMember(t4);
        cl.addMember(t5);
        cl.addMember(t6);
        cl.addMember(t7);
        cl.addMember(t8);
        cl.addMember(t9);
        cl.addMember(t10);

        //Setting up all students' subjects
        cl.assignRandomSubjects(st1, cl.getSubjectsAssignControl());
        cl.assignRandomSubjects(st2, cl.getSubjectsAssignControl());
        cl.assignRandomSubjects(st3, cl.getSubjectsAssignControl());
        cl.assignRandomSubjects(st4, cl.getSubjectsAssignControl());
        cl.assignRandomSubjects(st5, cl.getSubjectsAssignControl());
        cl.assignRandomSubjects(st6, cl.getSubjectsAssignControl());
        cl.assignRandomSubjects(st7, cl.getSubjectsAssignControl());
        cl.assignRandomSubjects(st8, cl.getSubjectsAssignControl());
        cl.assignRandomSubjects(st9, cl.getSubjectsAssignControl());
        cl.assignRandomSubjects(st10, cl.getSubjectsAssignControl());
        cl.assignRandomSubjects(st11, cl.getSubjectsAssignControl());
        cl.assignRandomSubjects(st12, cl.getSubjectsAssignControl());
        cl.assignRandomSubjects(st13, cl.getSubjectsAssignControl());
        cl.assignRandomSubjects(st14, cl.getSubjectsAssignControl());
        cl.assignRandomSubjects(st15, cl.getSubjectsAssignControl());
        cl.assignRandomSubjects(st16, cl.getSubjectsAssignControl());
        cl.assignRandomSubjects(st17, cl.getSubjectsAssignControl());
        cl.assignRandomSubjects(st18, cl.getSubjectsAssignControl());
        cl.assignRandomSubjects(st19, cl.getSubjectsAssignControl());
        cl.assignRandomSubjects(st20, cl.getSubjectsAssignControl());

        //Setting up all teachers' subjects 
        cl.assignRandomSubjects(t1, cl.getSubjectsAssignControl());
        cl.assignRandomSubjects(t2, cl.getSubjectsAssignControl());
        cl.assignRandomSubjects(t3, cl.getSubjectsAssignControl());
        cl.assignRandomSubjects(t4, cl.getSubjectsAssignControl());
        cl.assignRandomSubjects(t5, cl.getSubjectsAssignControl());
        cl.assignRandomSubjects(t6, cl.getSubjectsAssignControl());
        cl.assignRandomSubjects(t7, cl.getSubjectsAssignControl());
        cl.assignRandomSubjects(t8, cl.getSubjectsAssignControl());
        cl.assignRandomSubjects(t9, cl.getSubjectsAssignControl());
        cl.assignRandomSubjects(t10, cl.getSubjectsAssignControl());
        return cl;
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

    /**
     * Method to ask the user an id
     * @return id entered by user 
     */
    public static String askId() {
        Scanner scn = new Scanner(System.in);
        String id;

        System.out.print("Enter the ID of the member: ");
        id = scn.next();

        return id;
    }
}
