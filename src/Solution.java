import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Solution {
   private static final String alphabet = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЭЮЯабвгдеёжзийклмнопрстуфхцчшщъьэюя.,:-!? \"";


    public static void main(String[] args) {
        boolean work = true;
        while (work) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("1 - зашифровать, 2 - расшифровать, 3 - брутфорс шифра. 4 - выход");
            System.out.print("Выберите действие: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> encrypt();
                case 2 -> decrypt();
                case 3 -> brute_force();
                case 4 -> work = false;
            }
        }
    }


    public static void encrypt() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите путь до файла, который надо зашифровать: ");
        String sourceFilePath = scanner.nextLine();
        System.out.print("Введите путь до зашифрованного файла: ");
        String encryptedFilePath = scanner.nextLine();
        System.out.print("Введите шаг шифрования: ");
        int shiftNumber = scanner.nextInt();
        crypt_data_from_file(sourceFilePath, encryptedFilePath, shiftNumber, true);
    }


    public static void decrypt() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите путь до файла, который надо расшифровать: ");
        String sourceFilePath = scanner.nextLine();
        System.out.print("Введите путь до расшифрованного файла: ");
        String encryptedFilePath = scanner.nextLine();
        System.out.print("Введите шаг расшифрования: ");
        int shiftNumber = scanner.nextInt();
        crypt_data_from_file(sourceFilePath, encryptedFilePath, shiftNumber, false);
    }


    public static void brute_force(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите путь до файла, который надо дешифровать: ");
        String sourceFilePath = scanner.nextLine();
        System.out.print("Введите путь до дешифрованного файла файла: ");
        String encryptedFilePath = scanner.nextLine();
        for (int shift = 0; shift <= alphabet.length(); shift++) {
            crypt_data_from_file(sourceFilePath, encryptedFilePath, shift, false);
        }
    }


    private static void crypt_data_from_file(String planTextFile, String encryptedFile, int shift, boolean enc_flag) {
        try(FileReader reader = new FileReader(planTextFile);
            FileWriter writer = new FileWriter(encryptedFile,true)
        ) {
            int character;
            while ((character = reader.read()) !=-1) {
                writer.write(symbol_right_shift((char) character, shift, enc_flag));
            }
            writer.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static char symbol_right_shift(char symbol, int shift, boolean enc_flag) {
        String reversedString = new StringBuffer(alphabet).reverse().toString();
        if (alphabet.indexOf(symbol) != -1 && enc_flag) {
            return alphabet.charAt((alphabet.indexOf(symbol) + shift) % alphabet.length());
        }else if (alphabet.indexOf(symbol) != -1 && !enc_flag) {
            return reversedString.charAt((reversedString.indexOf(symbol) + shift) % reversedString.length());
        } else {
            return symbol;
        }
    }
}
