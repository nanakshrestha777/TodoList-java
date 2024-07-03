import java.util.Scanner;

public class ToDoListApp {
    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("To-Do List Application");
            System.out.println("1. Add Task");
            System.out.println("2. Complete Task");
            System.out.println("3. Show Tasks");
            System.out.println("4. Remove Task");
            System.out.println("5. Exit");
            System.out.println("6. Edit Task");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    toDoList.addTask(description);
                    break;
                case 2:
                    System.out.print("Enter task number to complete: ");
                    int taskNumber = scanner.nextInt();
                    toDoList.completeTask(taskNumber - 1);
                    break;
                case 3:
                    toDoList.showTasks();
                    break;
                case 5:
                    running = false;
                    break;
                case 4:
                    System.out.println("Enter task number to remove: ");
                    int removeTaskNumber = scanner.nextInt();
                    toDoList.removeTask(removeTaskNumber - 1);
                    break;

                case 6:
                    System.out.println("Enter task number to edit: ");
                    int editTaskNumber = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter new task description: ");
                    String newDescription = scanner.nextLine();
                    toDoList.editTask(editTaskNumber - 1, newDescription);
                    break;

                    

                    
                default:
                    System.out.println("Invalid option. Please try again.");


            }

            System.out.println();
        }

        scanner.close();
    }
}
