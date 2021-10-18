import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TwoDArray extends JFrame implements ActionListener { 
  private int colSize = 3;
  private int rowSize = 4;
  public JLabel headerLabel;

  public TwoDArray() {
    super();
    Container contentPane = getContentPane();
    setSize(350, 350);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setTitle("2D Array of Buttons");
    contentPane = getContentPane();
    contentPane.setBackground(Color.yellow);
    contentPane.setLayout(new BorderLayout());
    createArrayOfButtons(contentPane, rowSize, colSize);
  }

  public void createArrayOfButtons(Container contentPane, int rowSize, int colSize) {
    JPanel exitAppPanel = new JPanel();
    exitAppPanel.setBackground(Color.white);
    exitAppPanel.setLayout(new GridLayout(1, 2));
    JButton exitBtn = new JButton("Exit App");
    exitBtn.setActionCommand("EXIT");
    exitBtn.setFont(new Font("Calibri", Font.BOLD, 8));
    exitBtn.setBackground(Color.white);
    exitBtn.addActionListener(this);
    exitAppPanel.add(exitBtn);
    headerLabel = new JLabel("Press a button", SwingConstants.CENTER);
    headerLabel.setForeground(Color.black);
    headerLabel.setFont(new Font("Calibri", Font.BOLD, 8));
    exitAppPanel.add(headerLabel);
    contentPane.add(exitAppPanel, BorderLayout.NORTH);
    JPanel btnPanel = new JPanel();
    btnPanel.setBackground(Color.white);
    btnPanel.setLayout(new GridLayout(rowSize, colSize));
    int i = 0;
    JButton[][] button = new JButton[rowSize][colSize];
    for (int r = 0; r < rowSize; r++) {
      for (int c = 0; c < colSize; c++) {
        button[r][c] = new JButton(String.valueOf(i));
        button[r][c].setActionCommand("row " + r + " and column" + c);
        button[r][c].addActionListener(this);
        button[r][c].setBackground(Color.white);
        btnPanel.add(button[r][c]);
        i++;
      }
    }
    contentPane.add(btnPanel, BorderLayout.CENTER);
  }
  public void actionPerformed(ActionEvent event) {
    headerLabel.setText("Pressed " + event.getActionCommand());
    if (event.getActionCommand().equals("EXIT"))
      System.exit(0);
  }

}
