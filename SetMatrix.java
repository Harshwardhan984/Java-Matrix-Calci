/* 
import javax.swing.*;
import java.awt.*;

public class SetMatrix {
  int size = 0;
  public double[][] GiveMatrix() {
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
    proceedButton.addActionListener(e -> {
      matrixPanel.removeAll(); // Clear matrix grid
      setButton.setVisible(false); // Hide "Set" button until grid is ready

      
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
    double[][] ans = new double[size][size]; // Initialize matrix
    // Placeholder action for "Set" button (you can customize)
    setButton.addActionListener(e -> {
      for (int i = 0; i < size * size; i++) {
        JTextField tf = (JTextField) matrixPanel.getComponent(i);
        String text = tf.getText();
        if (!text.isEmpty()) {
          ans[i / size][i % size] = Double.parseDouble(text); // Store values in ans
        } else {
          JOptionPane.showMessageDialog(frame, "Please fill all fields.");
          return;
        }
      }
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

    return ans; // return the matrix
  } 

  public static void main(String[] args) {
    SetMatrix sm = new SetMatrix();
    double[][] matrix = sm.GiveMatrix();
    // Print the matrix to verify (optional)
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
  }
}

*/
 import javax.swing.*;
import java.awt.*;

public class SetMatrix {
    private int size = 0;
    private double[][] matrix;

    public void GiveMatrix() {
        JFrame frame = new JFrame("Matrix Input");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel label = new JLabel("Select Matrix Size:");
        label.setFont(new Font("Arial", Font.BOLD, 20));

        JRadioButton radio2x2 = new JRadioButton("2x2");
        JRadioButton radio4x4 = new JRadioButton("4x4");

        ButtonGroup group = new ButtonGroup();
        group.add(radio2x2);
        group.add(radio4x4);

        JButton proceedButton = new JButton("Proceed");
        JButton setButton = new JButton("Set");
        setButton.setVisible(false);

        JPanel matrixPanel = new JPanel();
        JScrollPane scrollPane = new JScrollPane(matrixPanel);

        proceedButton.addActionListener(e -> {
            matrixPanel.removeAll();
            setButton.setVisible(false);

            if (radio2x2.isSelected()) {
                size = 2;
            } else if (radio4x4.isSelected()) {
                size = 4;
            } else {
                JOptionPane.showMessageDialog(frame, "Select a matrix size.");
                return;
            }

            matrix = new double[size][size]; // Initialize matrix

            matrixPanel.setLayout(new GridLayout(size, size, 5, 5));
            for (int i = 0; i < size * size; i++) {
                JTextField tf = new JTextField();
                tf.setHorizontalAlignment(JTextField.CENTER);
                matrixPanel.add(tf);
            }

            matrixPanel.revalidate();
            matrixPanel.repaint();
            setButton.setVisible(true);
            frame.pack();
        });

        setButton.addActionListener(e -> {
            for (int i = 0; i < size * size; i++) {
                JTextField tf = (JTextField) matrixPanel.getComponent(i);
                String text = tf.getText();
                if (!text.isEmpty()) {
                    matrix[i / size][i % size] = Double.parseDouble(text);
                } else {
                    JOptionPane.showMessageDialog(frame, "Fill all fields.");
                    return;
                }
            }
            JOptionPane.showMessageDialog(frame, "Matrix values saved!");

            // Print matrix after values are set
            printMatrix();
        });

        panel.add(label);
        panel.add(radio2x2);
        panel.add(radio4x4);
        panel.add(proceedButton);
        panel.add(scrollPane);
        panel.add(setButton);

        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
    }

    private void printMatrix() {
        System.out.println("Matrix:");
        for (double[] row : matrix) {
            for (double val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        SetMatrix sm = new SetMatrix();
        sm.GiveMatrix();
    }
}

 
