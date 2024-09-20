package Unit2;

import java.util.Scanner;

public class TestSpamCheck {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your message: ");
        String message = input.nextLine();

        // Spam keywords to check against
        String[] spamKeywords = {"buy", "free", "limited time", "offer", "win", "lottery", "free money", "make money fast"};

        // Check if the message contains any spam keywords
        boolean isSpam = false;
        for (String keyword : spamKeywords) {
            if (message.toLowerCase().contains(keyword)) {
                isSpam = true;
                break;
            }
        }

        // Output the result
        if (isSpam) {
            System.out.println("Your message contains spam.");
        } else {
            System.out.println("Your message is clean.");
        }
    }
}
