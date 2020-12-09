package HomeWork01.Converter;

public class Converter {
    public static void main(String[] args) {
        System.out.println(converter(36.6));
        System.out.println(decoverter(45.75));
    }

    public static double converter(double t) {
        return t*1.25;
    }

    public static double decoverter(double t) {
        return t/1.25;
    }
}
