import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String subString = scanner.nextLine();
        String[] splitInput = input.split(subString);
        int lengthAfterSplit = 0;
        for (String word : splitInput) {
            lengthAfterSplit += word.length();
        }
        int output = (input.length() - lengthAfterSplit) / subString.length();
        System.out.println(output);
    }
}