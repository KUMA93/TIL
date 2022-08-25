package ch06;

public class Student {

    public int studentNumber;
    public String studentName;
    public int grade;

    public Student(){} // 오버로딩으로 디폴트 생성자를 직접 추가로 만들어줘서 Student()로도 객체를 만들 수 있게 한다.

    public Student(int studentNumber, String studentName, int grade) {

        this.studentNumber = studentNumber;
        this.studentName = studentName;
        this.grade = grade;

    }

    public String showStudentInfo() {

        return studentName + "학생의 학번은 " + studentNumber + "이고, " + grade + "학년 입니다.";
    }
}
