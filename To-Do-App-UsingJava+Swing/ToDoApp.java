import java.awt.*;
import javax.swing.*;

public class ToDoApp {
    private DefaultListModel<String> taskListModel;
    private JList<String> taskList;
    private JTextField taskField;

    public ToDoApp() {
        JFrame frame = new JFrame("ToDo App");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        taskListModel = new DefaultListModel<>();
        taskList = new JList<>(taskListModel);

        taskField = new JTextField(20);
        JButton addButton = new JButton("Add Task");
        JButton deleteButton = new JButton("Delete Task");

        JPanel panel = new JPanel();
        panel.add(taskField);
        panel.add(addButton);
        panel.add(deleteButton);

        frame.add(new JScrollPane(taskList), BorderLayout.CENTER);
        frame.add(panel, BorderLayout.SOUTH);

        addButton.addActionListener(e -> {
            String task = taskField.getText().trim();
            if (!task.isEmpty()) {
                taskListModel.addElement(task);
                taskField.setText("");
            }
        });

        deleteButton.addActionListener(e -> {
            int selectedIndex = taskList.getSelectedIndex();
            if (selectedIndex != -1) {
                taskListModel.remove(selectedIndex);
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ToDoApp::new);
    }
}
