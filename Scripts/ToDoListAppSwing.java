import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
public class ToDoListAppSwing extends JFrame {

    private ToDoList toDoList;
    private TaskFileManager fileManager;
    private DefaultListModel<String> taskListModel;
    private JList<String> taskList;
    private JTextField taskTextField;
    private JButton addButton, completeButton, removeButton, editButton,
            saveTasksButton, loadTasksButton, showCompletedButton, showPendingButton;
    private JLabel statusLabel;

    public ToDoListAppSwing() {
        toDoList = new ToDoList();
        fileManager = new TaskFileManager();
        taskListModel = new DefaultListModel<>();
        taskList = new JList<>(taskListModel);
        taskTextField = new JTextField();
        addButton = new JButton("Add Task");
        completeButton = new JButton("Complete Task");
        removeButton = new JButton("Remove Task");
        editButton = new JButton("Edit Task");
        saveTasksButton = new JButton("Save Tasks");
        loadTasksButton = new JButton("Load Tasks");
        showCompletedButton = new JButton("Show Completed");
        showPendingButton = new JButton("Show Pending");
        statusLabel = new JLabel(" ");

        // Set up the frame
        setTitle("To-Do List");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Set up the task list panel
        JPanel taskListPanel = new JPanel(new BorderLayout());
        taskListPanel.add(new JScrollPane(taskList), BorderLayout.CENTER);
        taskListPanel.add(taskTextField, BorderLayout.NORTH);

        // Set up the button panel
        JPanel buttonPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        buttonPanel.add(addButton);
        buttonPanel.add(completeButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(editButton);
        buttonPanel.add(saveTasksButton);
        buttonPanel.add(loadTasksButton);
        buttonPanel.add(showCompletedButton);
        buttonPanel.add(showPendingButton);

        // Set up the status bar
        JPanel statusBar = new JPanel(new FlowLayout(FlowLayout.LEFT));
        statusBar.add(statusLabel);

        // Add components to the frame
        add(taskListPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        add(statusBar, BorderLayout.NORTH);

        // Add action listeners
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String description = taskTextField.getText();
                if (!description.isEmpty()) {
                    toDoList.addTask(description);
                    updateTaskList();
                    taskTextField.setText("");
                    statusLabel.setText("Task added successfully.");
                } else {
                    statusLabel.setText("Please enter a task description.");
                }
            }
        });

        completeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = taskList.getSelectedIndex();
                if (selectedIndex != -1) {
                    toDoList.completeTask(selectedIndex);
                    updateTaskList();
                    statusLabel.setText("Task marked as completed.");
                } else {
                    statusLabel.setText("Please select a task to complete.");
                }
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = taskList.getSelectedIndex();
                if (selectedIndex != -1) {
                    toDoList.removeTask(selectedIndex);
                    updateTaskList();
                    statusLabel.setText("Task removed successfully.");
                } else {
                    statusLabel.setText("Please select a task to remove.");
                }
            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = taskList.getSelectedIndex();
                if (selectedIndex != -1) {
                    String currentDescription = taskListModel.getElementAt(selectedIndex);
                    String newDescription = JOptionPane.showInputDialog(
                            ToDoListAppSwing.this, "Edit task:", currentDescription);
                    if (newDescription != null && !newDescription.isEmpty()) {
                        toDoList.editTask(selectedIndex, newDescription);
                        updateTaskList();
                        statusLabel.setText("Task edited successfully.");
                    } else {
                        statusLabel.setText("No changes made.");
                    }
                } else {
                    statusLabel.setText("Please select a task to edit.");
                }
            }
        });

        saveTasksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toDoList.saveTasks("tasks.txt", fileManager);
                statusLabel.setText("Tasks saved successfully.");
            }
        });

        loadTasksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toDoList.LoadTasks("tasks.txt", fileManager);
                updateTaskList();
                statusLabel.setText("Tasks loaded successfully.");
            }
        });

        showCompletedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toDoList.showCompletedTask();
                statusLabel.setText("Completed tasks shown.");
            }
        });

        showPendingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toDoList.showPendingTasks();
                statusLabel.setText("Pending tasks shown.");
            }
        });

        // Initialize the task list
        updateTaskList();
        setVisible(true);
    }

    private void updateTaskList() {
        taskListModel.clear();
        for (Task task : toDoList.showTasks()) {
            taskListModel.addElement((task.isCompleted() ? "[X] " : "[ ] ") + task.getDescription());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ToDoListAppSwing();
            }
        });
    }
}