import javax.swing.*;
import java.awt.*;

public class Task6 {

    // Main method to run the app
    public static void main(String[] args) {
        new Task6().createUI();
    }

    // Method to build the GUI
    public void createUI() {
        JFrame frame = new JFrame("To-Do List App");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Create components
        DefaultListModel<String> taskListModel = new DefaultListModel<>();
        JList<String> taskList = new JList<>(taskListModel);
        JTextField taskInput = new JTextField("enter text here");
        JButton addButton = new JButton("Add List");
        JButton deleteButton = new JButton("Delete List");

        // Panel for input + buttons
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(taskInput, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        inputPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Add task to list
        addButton.addActionListener(e -> {
            String task = taskInput.getText().trim();
            if (!task.isEmpty()) {
                taskListModel.addElement(task);
                taskInput.setText("");
            }
        });

        // Delete selected task
        deleteButton.addActionListener(e -> {
            int selected = taskList.getSelectedIndex();
            if (selected != -1) {
                taskListModel.remove(selected);
            }
        });

        // Add components to frame
        frame.add(new JScrollPane(taskList), BorderLayout.CENTER);
        frame.add(inputPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}
