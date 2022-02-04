//Lab 2 Java Cipher Code
//C18302166
//Date of completion: 29/09/2021
import java.util.Scanner;
public class Cyper {
    
    public static void main(final String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.println("enter which cypher you want to do, enter either Caesar or Vigenere");
        final String choice = input.nextLine();
        input.close();

        switch (choice) {
            case "Ceasar":
                Ceasarcipher();
                break;
                
            case "Vigenere":
                Vigenerecipher();
                break;
            
            default:
                System.out.println("invalid input");
        }
        
    }
    // This method implements the Ceasar Cypher
    public static void Ceasarcipher() {
        Scanner sc = new Scanner(System.in);
        System.out.println(" Input the plaintext message: ");
        String plaintext = sc.nextLine();
        sc.close();

        System.out.println(" Enter the value by which each character in the plaintext message gets shifted : ");
        final int shift = sc.nextInt();

        sc.close();

        /*Both variables are assigned values so that all 
        the if statements in the method can use the variables*/
        String ciphertext = "";
        char alphabet = ' ';
        for (int i = 0; i < plaintext.length(); i++) {
            // Shifts one letter in the text at a time
            alphabet = plaintext.charAt(i);

            // if alphabet lies between a and z
            if (alphabet >= 'a' && alphabet <= 'z') {
                // shift alphabet
                alphabet = (char) (alphabet + shift);
                //if shift alphabet greater than 'z'
                if (alphabet > 'z') {
                    // reshift to starting position
                    alphabet = (char) (alphabet + 'a' - 'z' - 1);
                }
            }
            ciphertext = ciphertext + alphabet;
        }

        // if statement for when the alphabet is between A and Z
        if (alphabet >= 'A' && alphabet <= 'Z') {
            // shift alphabet
            alphabet = (char) (alphabet + shift);

            // if greater than Z reshift the alphabet
            if (alphabet > 'Z') {
                // reshift to starting position
                alphabet = (char) (alphabet + 'A' - 'Z' - 1);
            }
            ciphertext = ciphertext + alphabet;
        } 
        else {
            ciphertext = ciphertext + alphabet;
        }
        System.out.println(" ciphertext : " + ciphertext);

    }

    //this static method implements the Vigenere cipher
    public static void Vigenerecipher() {
        // input plaintext and key]
        Scanner sc = new Scanner();
        System.out.println("enter your plaintext");
        String plaintext = sc.nextLine();
        sc.close();

        System.out.println("enter the key");
        String key = sc.nextLine();
        sc.close();

        // Converts plaintext to char array
        final char message[] = plaintext.toCharArray();
        final int messageLength = message.length;
        int i, j;

        // Code that creates new character arrays
        final char keyArray[] = new char[messageLength];
        final char encryptedMessage[] = new char[messageLength];
        final char decryptedMessage[] = new char[messageLength];
            
            //for loop that generates a key based on the legth of the message
            for(i = 0, j = 0; i < messageLength; ++i, ++j){      
            if(j == key.length()){
            j = 0;
            }
            keyArray[i] = key.charAt(j);
            }
  
            //for loop that encrypts the message
            for(i = 0; i < messageLength; ++i)
             encryptedMessage[i] = (char) (((message[i] + keyArray[i]) % 26) + 'A');
 
            //for loop that decrypts the message
            for(i = 0; i < messageLength; ++i)
                decryptedMessage[i] = (char)((((encryptedMessage[i] - keyArray[i]) + 26) % 26) + 'A');
  
            System.out.println("Original Message: " + plaintext);  
            System.out.println("Keyword: " + key);
            // String.valueOf() method converts char[] to String 
            System.out.println("Key: " + String.valueOf(key));
            System.out.println("Encrypted Message: " + String.valueOf(encryptedMessage));     
            System.out.println("Decrypted Message: " + String.valueOf(decryptedMessage));
    
        }       
