package electricity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewInformation extends JFrame implements ActionListener {

    JButton cancel;
    ViewInformation(String meter) {
        setBounds(350,110,850,630);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("VIEW CUSTOMER INFORMATION");
        heading.setBounds(250,0,500,40);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(heading);

        JLabel lb1name = new JLabel("Name");
        lb1name.setBounds(70,80,100,20);
        add(lb1name);

        JLabel name = new JLabel("");
        name.setBounds(250,80,100,20);
        add(name);

        JLabel lb1meternumber = new JLabel("Meter Number");
        lb1meternumber.setBounds(70,140,100,20);
        add(lb1meternumber);

        JLabel meternumber = new JLabel("");
        meternumber.setBounds(250,140,100,20);
        add(meternumber);

        JLabel lb1address = new JLabel("Address");
        lb1address.setBounds(70,200,100,20);
        add(lb1address);

        JLabel address = new JLabel("");
        address.setBounds(250,200,100,20);
        add(address);

        JLabel lb1city = new JLabel("City");
        lb1city.setBounds(70,260,100,20);
        add(lb1city);

        JLabel city = new JLabel("");
        city.setBounds(250,260,100,20);
        add(city);

        JLabel lb1state = new JLabel("State");
        lb1state.setBounds(500,80,100,20);
        add(lb1state);

        JLabel state = new JLabel("");
        state.setBounds(650,80,100,20);
        add(state);

        JLabel lb1email = new JLabel("Email");
        lb1email.setBounds(500,140,100,20);
        add(lb1email);

        JLabel email = new JLabel("");
        email.setBounds(650,140,100,20);
        add(email);

        JLabel lb1phone = new JLabel("Phone");
        lb1phone.setBounds(500,200,100,20);
        add(lb1phone);

        JLabel phone = new JLabel("");
        phone.setBounds(650,200,100,20);
        add(phone);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where meter_no = '"+ meter +"' ");
            while (rs.next()) {
                name.setText(rs.getString("name"));
                address.setText(rs.getString("address"));
                city.setText(rs.getString("city"));
                state.setText(rs.getString("state"));
                email.setText(rs.getString("email"));
                phone.setText(rs.getString("phone"));
                meternumber.setText(rs.getString("meter_no"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(350, 340,100,25);
        add(cancel);
        cancel.addActionListener(this);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bill.png"));
        Image i2 = i1.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(20,350,600,300);
        add(image);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
    }
    public static void main(String[] args) {
        new ViewInformation("");
    }

}
