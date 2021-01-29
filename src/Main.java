//****************************************************************************************
// CLASS: Main (Main.java)
//
// DESCRIPTION
// Contains the main driver for the program.
//
// COURSE AND PROJECT INFO
// CSE205 Object Oriented Programming and Data Structures, Spring 2021
// Project Number: 2
//
// AUTHORS
// Teodoro Salgado, tjsalgad, tsalgado96@gmail.com
// Isaac Pena, ipena5, ippenaisaac@gmail.com
// Stephen Elledge, saelledg, saelledg@asu.edu
// ****************************************************************************************
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    
    /**
     * Instantiate a Main object and call run() on the object. Note that essentially now, run()
     * becomes the starting point of execution for the program.
     */
    public static void main(String[] pArgs){
        new Main().run();
    } // End main()


    /**
     * Calls other methods to implement the sw requirements.
     */
    private void run(){

        // Declare ArrayList<Student> object named studentList and initialize it to null
        ArrayList<Student> studentList = new ArrayList<>();

        // In the try-catch block we try to read the list of students from p02-students.txt
        // storing the students in the studentList list. If we cannot open the input file for
        // reading, then we output an error message and terminate the program.
        try {
            studentList = readFile();
        }
        catch (FileNotFoundException pException){
            System.out.println("Sorry, could not open 'p02-students.txt' for reading. Stopping.");
            System.exit(-1);
        }

        // Calculate the tuition for each Student in studentList
        calcTuition(studentList);

        // Sort the students in studentList into ascending order based on student identifier
        // Note that Sorter.insertionSort() is a static/class method so we do not have to instantiate
        // an object of the Sorter class, we just write class-name.static-method-name() to call a
        // static method in a class.
        Sorter.insertionSort(studentList, Sorter.SORT_ASCENDING);

        // In the try-catch block we try to write the list of students and their calculated tuitions
        // to p02-tuition.txt If we cannot open the output file for writing, then we output an error
        // message and terminate the program.
        try {
            writeFile(studentList);
        }
        catch (FileNotFoundException pException){
            System.out.println("Sorry, could not open 'p02-tuition.txt' for writing. Stopping.");
            System.exit(-1);
        }
    } // End run()


    /**
     * Calculates the tuition for each Student in pStudentList. Write an enhanced for loop that
     * iterates over each Student in pStudentList. For each Student, call calcTuition() on that
     * Student object.
     */
    private void calcTuition(ArrayList<Student> pStudentList) {
        for (Student student : pStudentList) {
            student.calcTuition();
        }
    } // End calcTuition()


    /**
     * Reads the student information from "p02-students.txt" and returns the list of students as
     * an ArrayList<Student> object. Note that this method throws FileNotFoundException if the
     * input file could not be opened. The exception is caught and handled in run().
     */
    private ArrayList<Student> readFile() throws FileNotFoundException {
        // Declare and create an ArrayList<Student> object named studentList
        ArrayList<Student> studentList = new ArrayList<>();

        // Open "p02-students.txt" for reading using a Scanner object named in
        Scanner in = new Scanner(new File("p02-students.txt"));

        while (in.hasNext()){
            String studentType = in.next();
            if (studentType.equals("C")){
                studentList.add(readOnCampusStudent(in));
            }
            else {
                studentList.add(readOnlineStudent(in));
            }
        } // End while

        in.close();
        return studentList;

    } // End readFile()


    /**
     * Reads the information for an on-campus student from the input file.
     */
    private OnCampusStudent readOnCampusStudent(Scanner pIn){
        // Declare String object id and assign pIn.next() to id
        String id = pIn.next();
        // Declare String object named lname and assign pIn.next() to lname
        String lname = pIn.next();
        // Declare String object named fname and assign pIn.next() to fname
        String fname = pIn.next();

        // Declare and create an OnCampusStudent object. Pass id, fname, and lname as params to ctor.
        OnCampusStudent student = new OnCampusStudent(id, fname, lname);

        // Declare String object named res and assign pIn.next() to res
        String res = pIn.next();
        // Declare double variable named fee and assign pIn.nextDouble() to fee
        double fee = pIn.nextDouble();
        // Declare int variable named credits and assign pIn.nextInt() to credits
        int credits = pIn.nextInt();

        if (res.equals("R")){
            student.setResidency(OnCampusStudent.RESIDENT);
        }
        else {
            student.setResidency(OnCampusStudent.NON_RESIDENT);
        }

        // Call setProgramFee(fee) on student
        student.setProgramFee(fee);

        // Call setCredits(credits) on student
        student. setCredits(credits);

        return student;
    } // End readOnCampusStudent()


    /**
     * Reads the information for an online student from the input file.
     */
    private OnlineStudent readOnlineStudent(Scanner pIn){
        // Declare String object id and assign pIn.next() to id
        String id = pIn.next();
        // Declare String object named lname and assign pIn.next() to lname
        String lname = pIn.next();
        // Declare String object named fname and assign pIn.next() to fname
        String fname = pIn.next();

        // Declare and create an OnlineStudent student. Pass id, fname, lname as params to the ctor.
        OnlineStudent student = new OnlineStudent(id, fname, lname);

        // Declare String object named fee and assign pIn.next() to fee
        String fee = pIn.next();
        // Declare int variable named credits and assign pIn.nextInt() to credits
        int credits = pIn.nextInt();

        if (fee.equals("T")){
            student.setTechFee(true);
        }
        else {
            student.setTechFee(false);
        }

        // Call setCredits(credits) on student
        student.setCredits(credits);

        return student;
    } // End readOnlineStudent()


    /**
     * Writes the output to "p02-tuition.txt" per the software requirements. Note that this method
     * throws FileNotFoundException if the output file could not be opened. The exception is caught
     * and handled in run().
     */
    private void writeFile(ArrayList<Student> pStudentList) throws FileNotFoundException {
        // Declare and create a PrintWriter object named out, opening "p02-tuition.txt" for writing
        PrintWriter out = new PrintWriter("p02-tuition.txt");

        // Enhanced ForEach student in pStudentList Do
        // Using out.printf() output the student information per SW Requirement 3
        for (Student student : pStudentList){
            out.printf("%-16s%-20s%-15s%8.2f\n",student.getId(), student.getLastName(), student.getFirstName(), student.getTuition());
        }

        out.close();
    } // End writeFile()
} // End Main
