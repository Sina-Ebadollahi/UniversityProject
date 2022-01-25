import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Graphical Interface Class
 * @author Melika Maleki
 * @author Sina Ebadollahi
 * @version 1.0
 */
public class UI {
    // creating components
    private JFrame frame = new JFrame();
    private JTextArea txtArea = new JTextArea();
    private JTextArea txtArea2 = new JTextArea();
    private JButton sumBtn = new JButton("Sum");
    private JButton subBtn = new JButton("Subtraction");
    private JButton multBtn = new JButton("Multiply");
    private JButton divBtn = new JButton("Division");
    private JLabel authorLabel = new JLabel("About Coders");
    // components function invoke
    public void mainFunction() {
        mainFrame();
        setSubBtn();
        setSumBtn();
        setMultBtn();
        setDivBtn();
        setTxtArea();
        setTxtArea2();
        setAuthorLabel();
    }
    // GUI main frame
    public void mainFrame() {
        this.frame.setSize(500, 600);
        this.frame.getContentPane().setBackground(new Color(32,194,14));
        this.frame.setLayout(null);
        this.frame.setResizable(false);
        this.frame.setVisible(true);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // adding Components
        this.frame.add(sumBtn);
        this.frame.add(subBtn);
        this.frame.add(txtArea);
        this.frame.add(txtArea2);
        this.frame.add(multBtn);
        this.frame.add(divBtn);
        this.frame.add(authorLabel);
    }
    // Sum button
    public void setSumBtn() {
        this.sumBtn.setBounds(280, 400, 150, 100);
        this.sumBtn.setBackground(Color.cyan);
        this.sumBtn.addActionListener(this::sumActionListener);
        this.sumBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        mouseAction(this.sumBtn);

    }
    // Subtraction button
    public void setSubBtn() {
        this.subBtn.setBounds(80, 400, 150, 100);
        this.subBtn.setBackground(Color.cyan);
        this.subBtn.addActionListener(this::subActionListener);
        this.subBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        mouseAction(this.subBtn);

    }
    // Multiply button
    public void setMultBtn(){
        this.multBtn.setBounds(80, 300, 150, 100);
        this.multBtn.setBackground(Color.cyan);
        this.multBtn.addActionListener(this::multActionListner);
        this.multBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        mouseAction(this.multBtn);
    }
    // Division button
    public void setDivBtn(){
        this.divBtn.setBounds(280, 300, 150, 100);
        this.divBtn.setBackground(Color.cyan);
        this.divBtn.addActionListener(this::divActionListner);
        this.divBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        mouseAction(this.divBtn);
    }
    // mouse actions on Buttons
    public void mouseAction(JButton btn){
        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                btn.setForeground(Color.black);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                btn.setBackground(new Color(189, 59, 59));
                btn.setForeground(new Color(243, 216, 216));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                btn.setBackground(Color.cyan);
                btn.setForeground(Color.black);
            }
        });
        btn.setBorderPainted(false);
    }
    // multiply button Click Event
    public void multActionListner(ActionEvent e){
        String firstTxtArea = this.txtArea.getText();
        String secondTxtArea = this.txtArea2.getText();
        setTextCheckFunc(firstTxtArea, secondTxtArea, "Mult", this.txtArea);
    }
    // Sum button Click Event
    public void sumActionListener(ActionEvent e) {
        String firstTxtArea = this.txtArea.getText();
        String secondTxtArea = this.txtArea2.getText();
        setTextCheckFunc(firstTxtArea, secondTxtArea, "Sum", this.txtArea);
    }
    // Division button Click Event
    public void divActionListner(ActionEvent e){
        String firstTxtArea = this.txtArea.getText();
        String secondTxtArea = this.txtArea2.getText();
        setTextCheckFunc(firstTxtArea, secondTxtArea, "Div", this.txtArea);
    }
    // Subtraction button Click Event
    public void subActionListener(ActionEvent e) {
        String firstTxtArea = this.txtArea.getText();
        String secondTxtArea = this.txtArea2.getText();
        setTextCheckFunc(firstTxtArea, secondTxtArea, "Sub", this.txtArea);
    }
    // first text area component design
    public void setTxtArea() {
        this.txtArea.setBounds(60, 100, 170, 100);
        this.txtArea.setVisible(true);
        this.txtArea.setBackground(new Color(231, 231, 216));
    }
    // second text area component design
    public void setTxtArea2() {
        this.txtArea2.setBounds(265, 100, 170, 100);
        this.txtArea2.setVisible(true);
        this.txtArea2.setBackground(new Color(231, 231, 216));
    }
    // about label  component design
    public void setAuthorLabel() {
        this.authorLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.authorLabel.setForeground(new Color(50, 50, 200));
        this.authorLabel.setBounds(0, 0, 150, 50);
        this.authorLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(frame, "Melika Maleki && Sina Ebadollahi");
            }
        });
    }
    // the function that checks which button clicked and performing callback action and responding with calculation
    void setTextCheckFunc(String firstTxtArea, String secondTxtArea, String requestID, JTextArea textArea){
        if (!firstTxtArea.isBlank() && !secondTxtArea.isBlank()) {
            sum s = new sum();
            String result = s.mainAction(firstTxtArea, secondTxtArea, requestID);
            // no respond from sum class would result in 0
            if (result.equals("")) {
                textArea.setText("0");
            } else {
                // checking that there is no duplicate in the first part of the sentence
                if (result.charAt(0) == '+' && result.charAt(1) == '-') {
                    textArea.setText(result.split("\\+")[1]);
                } else {
                    textArea.setText(result);
                }
            }
        } else {
            return;
        }
    }

}
