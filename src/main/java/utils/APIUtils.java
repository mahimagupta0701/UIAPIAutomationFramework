package utils;



import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

    public class APIUtils {
        public static String loadPayload(String filePath) {
            try {
                return new String(Files.readAllBytes(Paths.get(filePath)));
            } catch (IOException e) {
                throw new RuntimeException("Failed to read payload: " + e.getMessage());
            }
        }

        public static String replacePayloadPlaceholders(String payload, String name, String category, String photoUrl, String tag, String status) {
            return payload
                    .replace("{{name}}", name)
                    .replace("{{category}}", category)
                    .replace("{{photoUrl}}", photoUrl)
                    .replace("{{tag}}", tag)
                    .replace("{{status}}", status);
        }

        public static String readJsonFromFile(String filePath) {
            try {
                return new String(Files.readAllBytes(Paths.get(filePath)));
            } catch (IOException e) {
                throw new RuntimeException("Failed to read JSON file: " + filePath, e);
            }
        }
    }


