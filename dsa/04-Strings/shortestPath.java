public class shortestPath {
    public static void main(String[] args) {
        String path = "WNEENESENNN";
        System.out.println(getDisplacement(path));
    }

    private static double getDisplacement(String path) {
        int x = 0, y = 0;

        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == 'N') {
                y++;
            } else if (path.charAt(i) == 'S') {
                y--;
            } else if (path.charAt(i) == 'W') {
                x--;
            } else {
                x++;
            }
        }
        int x2 = x * x;
        int y2 = y * y;
        return Math.sqrt(x2 + y2);
    }
}
