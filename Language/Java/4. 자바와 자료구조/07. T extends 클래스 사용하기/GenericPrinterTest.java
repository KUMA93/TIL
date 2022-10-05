package ch07;


public class GenericPrinterTest {

    public static void main(String[] args) {

        Powder powder = new Powder();
        GenericPrinter<Powder> powderPrinter = new GenericPrinter<>();
        powderPrinter.setMaterial(powder);

        Plastic plastic = new Plastic();
        GenericPrinter<Plastic> plasticPrinter = new GenericPrinter<>();
        plasticPrinter.setMaterial(plastic);

        Powder p = powderPrinter.getMaterial();
        System.out.println(powderPrinter.toString());
        System.out.println(p);

        System.out.println(plasticPrinter.toString());
    }
}
