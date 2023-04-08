package chucknorris;

import java.util.Scanner;

public class Main {

    final static String BADDECODERESULT = "Encoded string is not valid.";
    final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (userMenu()){

        }
    }

    public static boolean userMenu() {
        System.out.println("Please input operation (encode/decode/exit):");
        String operation = scanner.nextLine();
        switch (operation.trim().toLowerCase()) {
            case "encode" -> {
                System.out.println("Input string:");
                String input = scanner.nextLine();
                System.out.println("Encoded string:");
                System.out.println(encode(input));
            }
            case "decode" -> {
                try {
                    System.out.println("Input encoded string:");
                    String input = scanner.nextLine();
                    String result = decode(input);
                    System.out.println(result);
                } catch (Exception e) {
                    System.out.println(BADDECODERESULT);
                }
            }
            case "exit" -> {
                System.out.println("Bye!");
                return false;
            }
            default -> System.out.println("There is no '" + operation + "' operation");
        }

        System.out.println();
        return true;
    }

    public static String convertToBinaryString(String message) {
        StringBuilder binaryString = new StringBuilder();
        for (char x : message.toCharArray()) {
            binaryString.append(String.format("%7s", Integer.toBinaryString(x)).replace(" ", "0"));
        }
        return binaryString.toString();
    }

    public static String encode(String message) {
        String result = "";
        String binaryString = convertToBinaryString(message);

//            System.out.println(binaryString);
        int i = 0;
        while (i < binaryString.length()) {
            result = String.format("%s%s", result, binaryString.charAt(i) == '0' ? "00 " : "0 ");
            char currentChar = binaryString.charAt(i);
            while (currentChar == binaryString.charAt(i)) {
                result = String.format("%s%s", result, "0");
                i++;
                if (i == binaryString.length()) {
                    break;
                }
            }
            result = String.format("%s%s", result, " ");
        }
        return result;
    }

    public static boolean checkInput(String[] splitString){
        int binaryLength = 0;
        for(int i = 0; i < splitString.length; i += 2){
            if(!(splitString[i].equals("0") || splitString[i].equals("00"))){
                return false;
            }
        }

        for(int i = 1; i < splitString.length; i += 2){
            for(char letter : splitString[i].toCharArray()){
                if(letter != '0'){
                    return false;
                }
            }
            binaryLength += splitString[i].length();
        }

        return binaryLength % 7 == 0;
    }
    public static String decode(String encodedString) {
        String result = "";
        String binaryString = "";

        String[] splitString = encodedString.split(" ");
        if(!checkInput(splitString)){
            return BADDECODERESULT;
        }
        for (int i = 0; i < splitString.length; i += 2) {
            binaryString = String.format("%s%s", binaryString, splitString[i].equals("00") ? splitString[i + 1] : splitString[i + 1].replace('0', '1'));
        }
        for (String letter : binaryString.split("(?<=\\G.{" + 7 + "})")) {
            int val = Integer.parseInt(letter, 2);
            String c = Character.toString(val);
            result = String.format("%s%s", result, c);
        }

        System.out.println("Decoded string:");
        return result;
    }
}