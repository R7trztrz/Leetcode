package Review.ReviewTool;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ReviewTool {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of problems to review: ");
        int count;
        try {
            count = scanner.nextInt();
            if (count <= 0) {
                System.err.println("Count must be a positive integer.");
                return;
            }
        } catch (Exception e) {
            System.err.println("Invalid input. Please enter a positive integer.");
            return;
        } finally {
            scanner.close();
        }

        Path mdPath = Paths.get("src", "Review", "ReviewTool", "finished.md");
        if (!Files.exists(mdPath)) {
            System.err.println("finished.md not found at: " + mdPath.toAbsolutePath());
            return;
        }

        String content;
        try {
            content = new String(Files.readAllBytes(mdPath)).trim();
        } catch (IOException e) {
            System.err.println("Failed to read finished.md: " + e.getMessage());
            return;
        }

        if (content.isEmpty()) {
            System.err.println("finished.md is empty.");
            return;
        }

        // split on comma and optional whitespace
        List<String> items = Arrays.stream(content.split(",\\s*"))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList());

        if (items.isEmpty()) {
            System.err.println("No items found in finished.md.");
            return;
        }

        if (count > items.size()) {
            System.err.println("Requested " + count + " items but only " + items.size()
                    + " available. Selecting all available items instead.");
            count = items.size();
        }

        Collections.shuffle(items, new Random());
        List<String> pick = items.subList(0, count);

        System.out.println("Today's review (" + count + "):");
        for (int i = 0; i < pick.size(); i++) {
            System.out.println((i + 1) + ". " + pick.get(i));
        }
    }
}
