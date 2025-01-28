package electricity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateInformation extends JFrame implements ActionListener {

    JButton cancel, update;
    JTextField tfaddress, tfcity, tfstate, tfemail, tfphone;

    JLabel name;
    String meter;
    UpdateInformation(String meter) {
        this.meter = meter;
        setBounds(300,150,1050,450);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("UPDATE CUSTOMER INFORMATION");
        heading.setBounds(110,0,400,30);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(heading);

        JLabel lb1name = new JLabel("Name");
        lb1name.setBounds(30,70,100,20);
        add(lb1name);

        name = new JLabel("");
        name.setBounds(230,70,200,20);
        add(name);

        JLabel lb1meternumber = new JLabel("Meter Number");
        lb1meternumber.setBounds(30,110,100,20);
        add(lb1meternumber);

        JLabel meternumber = new JLabel("");
        meternumber.setBounds(230,110,200,20);
        add(meternumber);

        JLabel lb1address = new JLabel("Address");
        lb1address.setBounds(30,150,100,20);
        add(lb1address);

        tfaddress = new JTextField();
        tfaddress.setBounds(230,150,200,20);
        add(tfaddress);

        JLabel lb1city = new JLabel("City");
        lb1city.setBounds(30,190,100,20);
        add(lb1city);

        tfcity = new JTextField();
        tfcity.setBounds(230,190,200,20);
        add(tfcity);

        JLabel lb1state = new JLabel("State");
        lb1state.setBounds(30,230,100,20);
        add(lb1state);

        tfstate = new JTextField();
        tfstate.setBounds(230,230,200,20);
        add(tfstate);

        JLabel lb1email = new JLabel("Email");
        lb1email.setBounds(30,270,100,20);
        add(lb1email);

        tfemail = new JTextField();
        tfemail.setBounds(230,270,200,20);
        add(tfemail);

        JLabel lb1phone = new JLabel("Phone");
        lb1phone.setBounds(30,310,100,20);
        add(lb1phone);

        tfphone = new JTextField();
        tfphone.setBounds(230,310,200,20);
        add(tfphone);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where meter_no = '"+ meter +"' ");
            while (rs.next()) {
                name.setText(rs.getString("name"));
                tfaddress.setText(rs.getString("address"));
                tfcity.setText(rs.getString("city"));
                tfstate.setText(rs.getString("state"));
                tfemail.setText(rs.getString("email"));
                tfphone.setText(rs.getString("phone"));
                meternumber.setText(rs.getString("meter_no"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        update = new JButton("Update");
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setBounds(70, 360,100,25);
        add(update);
        update.addActionListener(this);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(230, 360,100,25);
        add(cancel);
        cancel.addActionListener(this);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/update.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(550,50,400,300);
        add(image);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == update) {
            String address = tfemail.getText();
            String city = tfcity.getText();
            String state = tfstate.getText();
            String email = tfemail.getText();
            String phone = tfphone.getText();

            try {
                Conn c = new Conn();
                c.s.executeUpdate("update customer set address = '"+address+"', city = '"+city+"',state = '"+state+"',email = '"+email+"',phone = '"+phone+"'");

                JOptionPane.showMessageDialog(null,"User Information Updated Successfully");
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new UpdateInformation("");
    }
}
