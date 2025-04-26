import javax.swing.*;
import java.awt.*;

public class MyGUI {
  public static void main(String[] args) {
    JFrame frame = new JFrame("All about Matrices !");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Main vertical panel
    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

    // Title label
    JLabel label = new JLabel("Select Matrix Size :");
    label.setFont(new Font("Arial", Font.BOLD, 28));
    label.setAlignmentX(Component.CENTER_ALIGNMENT);

    // Radio buttons
    JRadioButton radio2x2 = new JRadioButton("2x2 Matrix");
    JRadioButton radio4x4 = new JRadioButton("4x4 Matrix");
    radio2x2.setFont(new Font("Arial", Font.BOLD, 18));
    radio4x4.setFont(new Font("Arial", Font.BOLD, 18));
    radio2x2.setFocusPainted(false);
    radio4x4.setFocusPainted(false);
    radio2x2.setAlignmentX(Component.CENTER_ALIGNMENT);
    radio4x4.setAlignmentX(Component.CENTER_ALIGNMENT);

    ButtonGroup matrixGroup = new ButtonGroup();
    matrixGroup.add(radio2x2);
    matrixGroup.add(radio4x4);

    // Proceed Button
    JButton proceedButton = new JButton("Proceed");
    proceedButton.setFont(new Font("Arial", Font.PLAIN, 16));
    proceedButton.setFocusPainted(false);
    proceedButton.setAlignmentX(Component.CENTER_ALIGNMENT);

    // Matrix panel
    JPanel matrixPanel = new JPanel();
    matrixPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

    // Scroll pane for matrix panel
    JScrollPane scrollPane = new JScrollPane(matrixPanel);
    scrollPane.setPreferredSize(new Dimension(250, 180));
    scrollPane.setAlignmentX(Component.CENTER_ALIGNMENT);

    // "Set" button
    JButton setButton = new JButton("Set");
    setButton.setFont(new Font("Arial", Font.PLAIN, 16));
    setButton.setFocusPainted(false);
    setButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    setButton.setVisible(false); // hidden at first, shown after Proceed

    // Proceed button action
    proceedButton.addActionListener(_ -> {
      matrixPanel.removeAll(); // Clear matrix grid
      setButton.setVisible(false); // Hide "Set" button until grid is ready

      int size = 0;
      if (radio2x2.isSelected()) {
        size = 2;
      } else if (radio4x4.isSelected()) {
        size = 4;
      } else {
        JOptionPane.showMessageDialog(frame, "Please select a matrix size.");
        return;
      }

      matrixPanel.setLayout(new GridLayout(size, size, 5, 5)); // compact grid

      for (int i = 0; i < size * size; i++) {
        JTextField tf = new JTextField();
        tf.setPreferredSize(new Dimension(40, 40)); // smaller size
        tf.setHorizontalAlignment(JTextField.CENTER);
        tf.setFont(new Font("Arial", Font.PLAIN, 14));
        matrixPanel.add(tf);
      }

      matrixPanel.revalidate();
      matrixPanel.repaint();
      panel.revalidate();
      panel.repaint();
      frame.pack();

      setButton.setVisible(true); // Show "Set" button
    });

    // Placeholder action for "Set" button (you can customize)
    setButton.addActionListener(_ -> {
      JOptionPane.showMessageDialog(frame, "Matrix values set successfully !");
    });
    setButton.setFocusPainted(false);

    // Add all to panel
    panel.add(Box.createVerticalStrut(20));
    panel.add(label);
    panel.add(Box.createVerticalStrut(10));
    panel.add(radio2x2);
    panel.add(radio4x4);
    panel.add(Box.createVerticalStrut(10));
    panel.add(proceedButton);
    panel.add(Box.createVerticalStrut(20));
    panel.add(scrollPane);
    panel.add(Box.createVerticalStrut(10));
    panel.add(setButton);

    // Finalize frame
    frame.setContentPane(panel);
    frame.setLocationRelativeTo(null); // center window
    frame.pack();
    frame.setVisible(true);
  }
}
