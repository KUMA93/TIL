package ch10;

public class BirthDayTest {
    public static void main(String[] args) {
        BirthDay date = new BirthDay();
        BirthDay wrongDate = new BirthDay();

        date.setYear(2019);
        date.setMonth(12);
        date.setDay(30);

        wrongDate.setYear(2020);
        wrongDate.setMonth(14);
        wrongDate.setDay(24);

        date.showDate();
        wrongDate.showDate();
    }
}
