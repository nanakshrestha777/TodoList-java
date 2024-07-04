import java.io.*;
import java.util.ArrayList;

public class TaskFileManager {
    public void saveToFile(String filename, ArrayList<Task> tasks) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Task task : tasks) {
                writer.println(task.getDescription() + "|" + task.isCompleted());
            }
        } catch (IOException e) {
            System.out.println("Error saving tasks.");
        }
    }

    public ArrayList<Task> loadFromFile(String filename) {
        ArrayList<Task> tasks = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                String description = parts[0];
                boolean isCompleted = Boolean.parseBoolean(parts[1]);
                Task task = new Task(description);
                if (isCompleted) {
                    task.markAsCompleted();
                }
                tasks.add(task);
            }
        } catch (IOException e) {
            System.out.println("Error loading tasks.");
        }
        return tasks;
    }
}
