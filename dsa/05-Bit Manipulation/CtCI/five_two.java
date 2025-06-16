public class five_two {
    public static void main(String[] args) {
        double N = 0.625;

        if (N >= 1 || N <= 0) {
            System.out.println("ERROR");
        }

        StringBuilder binary = new StringBuilder();
        binary.append(".");

        double frac = 0.5;
        while (N > 0) {
            if (binary.length() > 32) {
                System.out.println("ERROR");
                break;
            }

            if (N >= frac) {
                binary.append("1");
                N -= frac;
            } else {
                binary.append(0);
            }

            frac /= 2;
        }
        System.out.println(binary.toString());
    }
}