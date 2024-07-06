import java.util.Scanner;
import java.util.InputMismatchException;

public class ToDoListApp {
    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();
        Scanner scanner = new Scanner(System.in);
        TaskFileManager fileManager = new TaskFileManager();

        boolean running = true;

        while (running) {
                 
            System.out.println("To-Do List Application");
            System.out.println("----------  Choose an option  ---------- ");

            System.out.println("1. Add Task");
            System.out.println("2. Complete Task");
            System.out.println("3. Show Tasks");
            System.out.println("4. Remove Task");
            System.out.println("5. Edit Task");
            System.out.println("6. Show Completed Tasks");
            System.out.println("7. Show Pending Tasks");
            System.out.println("8. Save Tasks");
            System.out.println("9. Load Tasks");
            System.out.println("10. Exit");
            System.out.println("---------------------------");
            

     

            try {
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
                    case 4:
                        System.out.println("Enter task number to remove: ");
                        int removeTaskNumber = scanner.nextInt();
                        toDoList.removeTask(removeTaskNumber - 1);
                        break;    
                    case 5:
                        System.out.println("Enter task number to edit: ");
                        int editTaskNumber = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Enter new task description: ");
                        String newDescription = scanner.nextLine();
                        toDoList.editTask(editTaskNumber - 1, newDescription);
                        break;
                  

                    case 6:
                        toDoList.showCompletedTask();

                        break;

                    case 7:
                        toDoList.showPendingTasks();
                        break;


                    case 8:
                        toDoList.saveTasks("tasks.txt", fileManager);
                        
                        break;

                    case 9:
                        toDoList.LoadTasks("tasks.txt", fileManager);

                        break;
                    case 10:
                        running = false;

                        break;

                        

                        
                    default:
                        System.out.println("Invalid option. Please try again.");


                }
            } catch (InputMismatchException e){
                System.out.println("Invalid Option!!!");
                scanner.nextLine();
            }


            System.out.println();
        }

        scanner.close();
    }
}
