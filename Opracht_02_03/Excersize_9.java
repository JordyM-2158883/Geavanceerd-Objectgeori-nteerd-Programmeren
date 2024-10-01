class Excersize_9 {
    public static void main(String[] args) {
        boolean prime;

        System.out.println(1);
        for (int i = 2; i < 10; i++) {
            prime = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    prime = false;
                    break;
                }
            }
            if (prime) {
                System.out.println(i);
            }
        }
    }
}