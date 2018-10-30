import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Scanner;


public class SierpinskiMain extends JPanel
{

    protected final int dimension = 600;
    protected final int margin = 20;
    protected int limit = dimension;


    public SierpinskiMain()
    {
        setPreferredSize(new Dimension(dimension + 2 * margin, dimension + 2 * margin));
        setBackground(Color.white);
        setForeground(Color.black);

        new Timer(1000, (ActionEvent e) -> {
            limit /= 2;
            if (limit <= 1)
                limit = dimension;
            repaint();
        }).start();
    }


    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("If you want to see Sierpinski's Triangle choice: 1.");
        System.out.println("If you want to see Sierpinski's Carpet choice: 2.");
        System.out.println("If you want to both Sierpinski's fractals choice: 3.");

        int choice = in.nextInt();

        switch (choice) {
            case 1: {
                SwingUtilities.invokeLater(() -> {
                    JFrame f = new JFrame();
                    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    f.setTitle("Sierpinski's triangle");
                    f.setResizable(false);
                    f.add(new SierpinskiTriangle(), BorderLayout.CENTER);
                    f.pack();
                    //f.setLocation(200, 200);
                    f.setLocationRelativeTo(null);
                    f.setVisible(true);
                });
                break;
            }
            case 2: {
                SwingUtilities.invokeLater(() -> {
                    JFrame f = new JFrame();
                    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    f.setTitle("Sierpinski's carpet");
                    f.setResizable(false);
                    f.add(new SierpinskiCarpet(), BorderLayout.CENTER);
                    f.pack();
                    //f.setLocation(1000,200);
                    f.setLocationRelativeTo(null);
                    f.setVisible(true);
                });
                break;
            }
            case 3: {
                SwingUtilities.invokeLater(() -> {
                    JFrame f = new JFrame();
                    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    f.setTitle("Sierpinski's fractals");
                    f.setResizable(false);
                    f.add(new SierpinskiTriangle(), BorderLayout.WEST);
                    f.add(new SierpinskiCarpet(), BorderLayout.EAST);
                    f.pack();
                    f.setLocation(300,200);
                    f.setSize(1275,675);
                    f.setVisible(true);
                });
                break;
            }
        }
    }
}

