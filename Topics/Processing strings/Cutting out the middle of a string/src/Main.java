import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int inputLength = input.length();
        for (int i = 0; i < inputLength; i++) {
            if (inputLength % 2 == 0) {
                if (i == inputLength / 2 || i == inputLength / 2 - 1) {
                    System.out.print("");
                    continue;
                }
            } else {
                if (i == inputLength / 2) {
                    System.out.print("");
                    continue;
                }
            }
            System.out.print(input.charAt(i));
        }
    }
}