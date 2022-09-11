package ch14;

public class CalculatorTest {
    public static void main(String[] args){

        CompleteCalc calc = new CompleteCalc();

        calc.description();

        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(Calc.total(arr));

    }
}
