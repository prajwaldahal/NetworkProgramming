package Unit2;

import java.util.Scanner;

public class SpamCheck {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        // Prompt the user for an email message
        System.out.print("Enter an email message: ");
        String message = scanner.nextLine();
        
        // Check if the message is spam
        if (isSpam(message)) {
            System.out.println("This message is spam.");
        } else {
            System.out.println("This message is not spam.");
        }
        
        scanner.close();
    }
    
    public static boolean isSpam(String message) {
        
        // Define a list of spam keywords
        String[] spamKeywords = {"buy", "free", "limited time", "offer", "win"};
        
        // Count the frequency of each spam keyword in the message
        int[] keywordCounts = new int[spamKeywords.length];
        for (int i = 0; i < spamKeywords.length; i++) {
            keywordCounts[i] = countKeywordOccurrences(message, spamKeywords[i]);
        }
        
        // Check if the message contains enough spam keywords to be classified as spam
        int spamThreshold = 2;
        int spamKeywordCount = 0;
        for (int count : keywordCounts) {
            if (count > 0) {
                spamKeywordCount++;
            }
            if (spamKeywordCount >= spamThreshold) {
                return true;
            }
        }
        
        // If no spam keywords were found, the message is not spam
        return false;
    }
    
    public static int countKeywordOccurrences(String message, String keyword) {
        
        // Split the message into individual words
        String[] words = message.split("\\s+");
        
        // Count the frequency of the keyword in the message
        int count = 0;
        for (String word : words) {
            if (word.equalsIgnoreCase(keyword)) {
                count++;
            }
        }
        
        return count;
    }
    
}
