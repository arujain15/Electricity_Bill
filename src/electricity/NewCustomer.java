package electricity;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.awt.event.*;

public class NewCustomer extends JFrame implements ActionListener{
    JTextField tfname, tfaddress, tfcity, tfstate, tfemail, tfphone;
    JButton next,cancel;
    JLabel lb1meter;

    NewCustomer() {
        setSize(700,500);
        setLocation(400,200);

        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(173, 216,230));
        add(p);

        JLabel heading = new JLabel("New Customer");
        heading.setBounds(180, 10, 200,25);
        heading.setFont(new Font("Tahoma", Font.PLAIN,24));
        p.add(heading);

        JLabel lb1name = new JLabel("Customer Name");
        lb1name.setBounds(100,80,100,20);
        p.add(lb1name);

        tfname = new JTextField();
        tfname.setBounds(240,80,200,20);
        p.add(tfname);

        JLabel lb1meterno = new JLabel("Meter Number");
        lb1meterno.setBounds(100,120,100,20);
        p.add(lb1meterno);

        lb1meter = new JLabel("");
        lb1meter.setBounds(240,120,100,20);
        p.add(lb1meter);

        Random ran = new Random();
        long number = ran.nextLong() % 1000000;
        lb1meter.setText("" + Math.abs(number));

        JLabel lb1address = new JLabel("Address");
        lb1address.setBounds(100,160,100,20);
        p.add(lb1address);

        tfaddress = new JTextField();
        tfaddress.setBounds(240,160,200,20);
        p.add(tfaddress);

        JLabel lb1city = new JLabel("City");
        lb1city.setBounds(100,200,100,20);
        p.add(lb1city);

        tfcity = new JTextField();
        tfcity.setBounds(240,200,200,20);
        p.add(tfcity);

        JLabel lb1state = new JLabel("State");
        lb1state.setBounds(100,240,100,20);
        p.add(lb1state);

        tfstate = new JTextField();
        tfstate.setBounds(240,240,200,20);
        p.add(tfstate);

        JLabel lb1email = new JLabel("Email");
        lb1email.setBounds(100,280,100,20);
        p.add(lb1email);

        tfemail = new JTextField();
        tfemail.setBounds(240,280,200,20);
        p.add(tfemail);

        JLabel lb1phone = new JLabel("Phone Number");
        lb1phone.setBounds(100,320,100,20);
        p.add(lb1phone);

        tfphone = new JTextField();
        tfphone.setBounds(240,320,200,20);
        p.add(tfphone);

        next = new JButton("Next");
        next.setBounds(120,390,100,25);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        p.add(next);

        cancel = new JButton("Cancel");
        cancel.setBounds(250,390,100,25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        p.add(cancel);

        setLayout(new BorderLayout());

        add(p,"Center");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/hicon1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(150,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image,"West");

        getContentPane().setBackground(Color.WHITE);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            String name = tfname.getText();
            String meter = lb1meter.getText();
            String address = tfaddress.getText();
            String city = tfcity.getText();
            String state = tfstate.getText();
            String email = tfemail.getText();
            String phone = tfphone.getText();

            String query1 = "insert into customer values ('"+ name +"','"+ meter +"','"+ address +"', '"+ city +"', '"+ state +"','"+ email +"','"+ phone +"')";
            String query2 = "insert into login values('"+ meter +"','"+ name +"','', '')";

            try {
                Conn c = new Conn();
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null,"Customer Details Added Successfully");
                setVisible(false);

                // new frame
                new MeterInfo(meter);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new NewCustomer();
    }
}
