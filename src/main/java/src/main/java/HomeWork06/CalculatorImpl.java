package HomeWork06;

public class CalculatorImpl implements Calculator {
    private final String a = "a";
    private final String b = "b";
    private final String c = "1";
    public int s;

    //Task 1
    public CalculatorImpl() {
    }

    @Override
    public int calc(int number) {
        if (number <= 1) {
            return 1;
        } else {
            return number * calc(number - 1);
        }
    }


}
