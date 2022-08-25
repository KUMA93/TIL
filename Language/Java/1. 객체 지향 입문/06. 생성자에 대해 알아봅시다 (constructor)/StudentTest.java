package ch06;

public class StudentTest {
    public static void main(String[] args) {

        Student studentLee = new Student();
        System.out.println(studentLee.showStudentInfo());

        Student studentChoi = new Student(14, "Choi", 3);
//        studentChoi.grade=3;
//        studentChoi.studentName="Choi";
//        studentChoi.studentNumber=14;
        System.out.println(studentChoi.showStudentInfo());
    }
}