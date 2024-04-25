import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Micro1Viewer extends JFrame {
    private static final long serialVersionUID = 1L;

    private JPanel controlPanel;
    private JTextField[] registerFields;
    private JButton stepButton, loadButton, memoryButton, registersButton;

    public Micro1Viewer() {
        super("Micro-1 Processor Simulation");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLayout(new BorderLayout());

        controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(6, 2));
        add(controlPanel, BorderLayout.CENTER);

        registerFields = new JTextField[16];
        for (int i = 0; i < 16; i++) {
            registerFields[i] = new JTextField("Register " + i, 10);
            registerFields[i].setEditable(false);
            controlPanel.add(registerFields[i]);
        }

        stepButton = new JButton("Step");
        controlPanel.add(stepButton);
        stepButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Call Console step method
            }
        });

        loadButton = new JButton("Load");
        controlPanel.add(loadButton);
        loadButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Call Console load method
            }
        });

        memoryButton = new JButton("Memory");
        controlPanel.add(memoryButton);
        memoryButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Call Console memory method
            }
        });

        registersButton = new JButton("Registers");
        controlPanel.add(registersButton);
        registersButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Call Console registers method
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Micro1Viewer viewer = new Micro1Viewer();
                viewer.setVisible(true);
            }
        });
    }
}
