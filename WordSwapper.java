import java.io.*;
import java.nio.file.*;
import java.util.*;

public class WordSwapper {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Введіть шлях до файлу: ");
        String filePath = scanner.nextLine();
        
        try {
            String content = readFileContent(filePath);
            String swappedContent = swapAdjacentWords(content);
            
            System.out.println("\nОригінальний текст:");
            System.out.println(content);
            
            System.out.println("\nТекст з переставленими словами:");
            System.out.println(swappedContent);
            
        } catch (IOException e) {
            System.err.println("Помилка при читанні файлу: " + e.getMessage());
        }
        
        scanner.close();
    }
    
    /**
     * Зчитує весь вміст файлу як рядок
     */
    private static String readFileContent(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)), "UTF-8");
    }
    
    /**
     * Міняє місцями кожні два сусідніх слова в тексті
     */
    private static String swapAdjacentWords(String text) {
        String[] words = text.split("\\s+");
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < words.length; i += 2) {
            if (i + 1 < words.length) {
                result.append(words[i + 1]).append(" ").append(words[i]);
                if (i + 2 < words.length) {
                    result.append(" ");
                }
            } else {
                result.append(words[i]);
            }
        }
        
        return result.toString();
    }
}