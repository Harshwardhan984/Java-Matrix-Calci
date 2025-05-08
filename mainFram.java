import java.awt.*;
import javax.swing.*;

public class mainFram {
    public static void main(String[] arg){
        //for(int i = 0; i < 100000; i++) System.out.println(i);
        JFrame background = new JFrame("Background");
        background.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        background.setSize(1000, 500);
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        background.add(panel);
        JLabel label = new JLabel("Welcome to the Matrix Program", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        label.setForeground(Color.BLUE);
        panel.add(label, BorderLayout.CENTER);
        JButton button = new JButton("Start");
        button.setFont(new Font("Arial", Font.BOLD, 18));
        button.setBackground(Color.GREEN);
        button.setForeground(Color.WHITE);
        button.setBorderPainted(true);
        button.setFocusPainted(true);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        button.setContentAreaFilled(true);
        button.setPreferredSize(new Dimension(100, 50));
        button.addActionListener(e -> {
            // Action to perform when the button is clicked
            System.out.println("Button clicked! Starting the program...");
            // You can add your program logic here

        });
        panel.add(button, BorderLayout.SOUTH);
        panel.setBackground(Color.LIGHT_GRAY);
        label.setOpaque(true);
        label.setBackground(Color.LIGHT_GRAY);
        label.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        button.setOpaque(true);
        button.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.setToolTipText("Click to start the program");
        button.setRolloverEnabled(true);
        button.setRolloverIcon(new ImageIcon("path/to/your/icon.png")); // Add rollover icon if needed
        button.setPressedIcon(new ImageIcon("path/to/your/icon_pressed.png")); // Add pressed icon if needed
        button.setDisabledIcon(new ImageIcon("path/to/your/icon_disabled.png")); // Add disabled icon if needed
        
        
       

        background.setVisible(true);
    }
}
