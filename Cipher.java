import java.util.Scanner;

public class Cipher {
    String cipheredString = "";

    public void encryption(String text, int key) {
        String cipheredString = "";
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String text1 = text.toLowerCase();

        for (int i = 0; i < text.length(); i++) {
            char c = text1.charAt(i);
            if (Character.isLetter(c)) {
                int index = alphabet.indexOf(c);
                int encryptedIndex = (index + key) % 26;
                cipheredString = cipheredString + alphabet.charAt(encryptedIndex);
            } else {
                cipheredString = cipheredString + c;
            }
        }

        System.out.println("Encrypted text: " + cipheredString);

        int m = 1;
        for (int i = 25; i != -1; i--) {
            String cipheredString1 = "";
            key = i;
            for (int j = 0; j < text.length(); j++) {
                char c = cipheredString.charAt(j);
                if (Character.isLetter(c)) {
                    int index = alphabet.indexOf(c);
                    int encryptedIndex = (index + key) % 26;
                    cipheredString1 = cipheredString1 + alphabet.charAt(encryptedIndex);
                } else {
                    cipheredString1 = cipheredString1 + c;
                }
            }
            System.out.println("");
            System.out.print("At key "+m);
            System.out.println("." + cipheredString1);
            m++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the plain text:");
        String text = sc.nextLine();
        System.out.println("Enter the key:");
        int key = sc.nextInt();
        Cipher cipher = new Cipher();
        cipher.encryption(text, key);
        sc.close();
    }
}
