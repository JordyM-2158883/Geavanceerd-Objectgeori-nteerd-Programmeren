import java.util.Random;

public class Excersize_7 {
    public static void main(String[] args) {
        Random rand = new Random();
        for (int i = 0; i < 25; i++) {
            int a = rand.nextInt(25);
            int b = rand.nextInt(25);
            if (a > b) {
                System.out.println(a + " is greater than " + b);
            } else if (a < b) {
                System.out.println(a + " is less than " + b);
            } else {
                System.out.println(a + " is equal to " + b);
            }
        }
    }
}
