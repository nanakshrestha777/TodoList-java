import java.util.ArrayList;

public class ToDoList {
    private ArrayList<Task> tasks;

    public ToDoList() {
        tasks = new ArrayList<>();
    }

    public void addTask(String description) {
        tasks.add(new Task(description));
    }

    public void editTask(int index, String newDescription) {
        if (index >= 0 && index < tasks.size()){
            tasks.get(index).setDescription(newDescription);
        }


    }

    public void completeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).markAsCompleted();
        } else {
            System.out.println("No task completed..");
        }
    }
    public void showTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to show");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }
    public void showCompletedTask() {
        for(int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).isCompleted()) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    public void showPendingTasks() {
        boolean hasPendingTasks = false;
        for (int i = 0;
         i < tasks.size();
         i++){
            if (!tasks.get(i).isCompleted()) {
                System.out.println("...List of Pending Tasks...");
                System.out.println((i + 1) + ". " + tasks.get(i));
                hasPendingTasks = true;
            }
        }
        if (!hasPendingTasks) {
            System.out.println("No pending tasks..");
        }



    }

    

    public void removeTask(int index){
        if (index >= 0 == index < tasks.size()) {
            tasks.remove(index);
            System.out.println("Task removed Successfully");
        } else {
            System.out.println("No task removed.");
        }
    

    }


    public void saveTasks(String filename, TaskFileManager fileManager) {
        fileManager.saveToFile(filename, tasks);
    }

    public void LoadTasks(String filename, TaskFileManager fileManager) {
        tasks = fileManager.loadFromFile(filename);
    }
    


}
