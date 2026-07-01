import java.io.*;
import java.util.*;

class Student implements Serializable {

    private int rollNo;
    private String name;
    private String grade;

    public Student(int rollNo, String name, String grade) {
        this.rollNo = rollNo;
        this.name = name;
        this.grade = grade;
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    public String getGrade() {
        return grade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Roll No : " + rollNo +
                "\nName : " + name +
                "\nGrade : " + grade;
    }
}

public class StudentManagementSystem {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        loadData();

        int choice;

        do {

            System.out.println("\n========== STUDENT MANAGEMENT ==========");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Edit Student");
            System.out.println("6. Save Data");
            System.out.println("7. Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    removeStudent();
                    break;

                case 3:
                    searchStudent();
                    break;

                case 4:
                    displayStudents();
                    break;

                case 5:
                    editStudent();
                    break;

                case 6:
                    saveData();
                    break;

                case 7:
                    saveData();
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 7);
    }

    static void addStudent() {

        System.out.print("Roll No : ");
        int roll = sc.nextInt();

        sc.nextLine();

        System.out.print("Name : ");
        String name = sc.nextLine();

        while(name.trim().isEmpty()){
            System.out.print("Name cannot be empty. Enter again: ");
            name = sc.nextLine();
        }

        System.out.print("Grade : ");
        String grade = sc.nextLine();

        students.add(new Student(roll, name, grade));

        System.out.println("Student Added Successfully.");
    }

    static void removeStudent() {

        System.out.print("Enter Roll Number: ");
        int roll = sc.nextInt();

        Iterator<Student> it = students.iterator();

        while(it.hasNext()){

            Student s = it.next();

            if(s.getRollNo()==roll){

                it.remove();

                System.out.println("Student Removed.");

                return;
            }
        }

        System.out.println("Student Not Found.");
    }

    static void searchStudent(){

        System.out.print("Enter Roll Number: ");

        int roll=sc.nextInt();

        for(Student s:students){

            if(s.getRollNo()==roll){

                System.out.println(s);

                return;
            }
        }

        System.out.println("Student Not Found.");
    }

    static void displayStudents(){

        if(students.isEmpty()){

            System.out.println("No Students Available.");

            return;
        }

        for(Student s:students){

            System.out.println("-----------------------");

            System.out.println(s);
        }
    }

    static void editStudent(){

        System.out.print("Enter Roll Number : ");

        int roll=sc.nextInt();

        sc.nextLine();

        for(Student s:students){

            if(s.getRollNo()==roll){

                System.out.print("New Name : ");

                String name=sc.nextLine();

                while(name.trim().isEmpty()){
                    System.out.print("Name cannot be empty. Enter again: ");
                    name=sc.nextLine();
                }

                System.out.print("New Grade : ");

                String grade=sc.nextLine();

                s.setName(name);

                s.setGrade(grade);

                System.out.println("Student Updated.");

                return;
            }
        }

        System.out.println("Student Not Found.");
    }

    static void saveData(){

        try{

            ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("students.dat"));

            out.writeObject(students);

            out.close();

            System.out.println("Data Saved.");

        }

        catch(Exception e){

            System.out.println("Error Saving Data.");
        }
    }

    @SuppressWarnings("unchecked")
    static void loadData(){

        try{

            ObjectInputStream in=new ObjectInputStream(new FileInputStream("students.dat"));

            students=(ArrayList<Student>) in.readObject();

            in.close();

        }

        catch(Exception e){

        }
    }
}