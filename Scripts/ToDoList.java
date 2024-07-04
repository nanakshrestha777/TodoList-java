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
        }
    }

    public void showTasks() {
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
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
        for (int i = 0;
         i < tasks.size();
         i++){
            if (!tasks.get(i).isCompleted()) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
         }



    }

    

    public void removeTask(int index){
        if (index >= 0 == index < tasks.size());
        tasks.remove(index);

    }


    public void saveTasks(String filenmae, TaskFileManager fileManager) {
        fileManager.saveToFile(filenmae, tasks);
    }

    public void LoadTasks(String filename, TaskFileManager fileManager) {
        tasks = fileManager.loadFromFile(filename);
    }
    


}
