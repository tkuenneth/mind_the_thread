package java_examples;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;

public class BadButtonDemo extends JFrame {

    public BadButtonDemo() {
        super(BadButtonDemo.class.getSimpleName());
        JPanel centerPanel = new JPanel();
        centerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JLabel result = new JLabel();
        result.setFont(result.getFont().deriveFont(72f));
        result.setText("---");
        centerPanel.add(result);
        JPanel southPanel = new JPanel();
        JButton button = new JButton("Do it");
        button.addActionListener(e -> {
            bad(result);
            // good(result);
        });
        southPanel.add(button);
        getContentPane().add(centerPanel, BorderLayout.CENTER);
        getContentPane().add(southPanel, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void bad(JLabel result) {
        int i;
        do {
            i = (int) (Math.random() * Integer.MAX_VALUE);
            System.out.println(i);
        }
        while (i != Integer.MAX_VALUE / 3);
        result.setText(Integer.toString(i));
    }

    private void good(JLabel result) {
        new Thread(() -> {
            int i;
            do {
                i = (int) (Math.random() * Integer.MAX_VALUE);
                System.out.println(i);
            }
            while (i != Integer.MAX_VALUE / 3);
            final int ii = i;
            SwingUtilities.invokeLater(() -> {
                result.setText(Integer.toString(ii));
            });
        }).start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame f = new BadButtonDemo();
            f.setVisible(true);
        });
    }
}
