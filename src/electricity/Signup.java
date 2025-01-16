package electricity;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class Signup extends JFrame implements ActionListener {
    JButton create, back;
    Choice accountType;
    JTextField meter, username, password,name;
    Signup() {
        super("Signup");
        setBounds(450,150,700,400);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(30,30,650,300);
        panel.setBorder(new TitledBorder(new LineBorder(new Color(173,216, 230),2),
                "Create-Account", TitledBorder.LEADING,TitledBorder.TOP, null,new Color(172,216,230)));
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        panel.setForeground(new Color(34, 139,34));
        add(panel);

        JLabel heading = new JLabel("Create Account");
        heading.setBounds(100,50,140,20);
        heading.setForeground(Color.GRAY);
        heading.setFont(new Font("Tahoma",Font.BOLD, 14));
        panel.add(heading);

        accountType = new Choice();
        accountType.add("Admin");
        accountType.add("Customer");
        accountType.setBounds(260,50,150,20);
        panel.add(accountType);

        JLabel lb1meter = new JLabel("Meter Number");
        lb1meter.setBounds(100,90,140,20);
        lb1meter.setForeground(Color.GRAY);
        lb1meter.setFont(new Font("Tahoma",Font.BOLD, 14));
        panel.add(lb1meter);

        meter = new JTextField();
        meter.setBounds(260,90, 150,20);
        panel.add(meter);

        JLabel lb1username = new JLabel("Username");
        lb1username.setBounds(100,130,140,20);
        lb1username.setForeground(Color.GRAY);
        lb1username.setFont(new Font("Tahoma",Font.BOLD, 14));
        panel.add(lb1username);

        username = new JTextField();
        username.setBounds(260,130, 150,20);
        panel.add(username);

        JLabel lb1name = new JLabel("Name");
        lb1name.setBounds(100,170,140,20);
        lb1name.setForeground(Color.GRAY);
        lb1name.setFont(new Font("Tahoma",Font.BOLD, 14));
        panel.add(lb1name);

        name = new JTextField();
        name.setBounds(260,170, 150,20);
        panel.add(name);

        JLabel lb1password = new JLabel("Password");
        lb1password.setBounds(100,210,140,20);
        lb1password.setForeground(Color.GRAY);
        lb1password.setFont(new Font("Tahoma",Font.BOLD, 14));
        panel.add(lb1password);

        password = new JTextField();
        password.setBounds(260,210, 150,20);
        panel.add(password);

        create = new JButton("Create");
        create.setBackground(Color.black);
        create.setForeground(Color.white);
        create.setBounds(140,260,120,25);
        create.addActionListener(this);
        panel.add(create);

        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(300,260,120,25);
        back.addActionListener(this);
        panel.add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/signupImage.png"));
        Image i2 = i1.getImage().getScaledInstance(250,250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(415,30,250,250);
        panel.add(image);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == create) {
            String atype = accountType.getSelectedItem();
            String susername = username.getText();
            String sname = name.getText();
            String spassword = password.getText();
            String smeter = meter.getText();

            try {
                Conn c = new Conn();
                String query = "insert into login values(' "+ smeter +" ','" + susername+"', '"+ sname +"', '"+ spassword +"', '"+ atype +"')";

                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Account Created Successfully");
                setVisible(false);
                new Login();
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == back) {
            setVisible(false);

            new Login();
        }
    }
    public static void main(String[] args) {
        new Signup();
    }
}
