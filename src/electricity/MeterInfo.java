package electricity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MeterInfo extends JFrame implements ActionListener {

    JTextField tfname, tfaddress, tfstate, tfcity, tfemail, tfphone;
    JButton next, cancel;
    JLabel lb1meter;
    Choice meterlocation, metertype, phasecode, billtype;
    String meternumber;

    MeterInfo(String meternumber) {
        this.meternumber = meternumber;

        setSize(700, 500);
        setLocation(400, 200);

        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(173, 216, 230));
        add(p);

        JLabel heading = new JLabel("Meter Information");
        heading.setBounds(180, 10, 200, 25);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 24));
        p.add(heading);

        JLabel lb1name = new JLabel("Meter Number");
        lb1name.setBounds(100, 80, 100, 20);
        p.add(lb1name);

        JLabel lb1meternumber = new JLabel(meternumber);
        lb1meternumber.setBounds(240, 80, 100, 20);
        p.add(lb1meternumber);

        JLabel lb1meterno = new JLabel("Meter Location");
        lb1meterno.setBounds(100, 120, 100, 20);
        p.add(lb1meterno);

        meterlocation = new Choice();
        meterlocation.add("Outside");
        meterlocation.add("Inside");
        meterlocation.setBounds(240,120,200,20);
        p.add(meterlocation);

        JLabel lb1address = new JLabel("Meter Type");
        lb1address.setBounds(100,160,100,20);
        p.add(lb1address);

        metertype = new Choice();
        metertype.add("Electric Meter");
        metertype.add("Solar Meter");
        metertype.add("Smart Meter");
        metertype.setBounds(240,160,200,20);
        p.add(metertype);

        JLabel lb1city = new JLabel("Phase Code");
        lb1city.setBounds(100,200,100,20);
        p.add(lb1city);

        phasecode = new Choice();
        phasecode.add("011");
        phasecode.add("022");
        phasecode.add("033");
        phasecode.add("044");
        phasecode.add("055");
        phasecode.add("066");
        phasecode.add("077");
        phasecode.add("088");
        phasecode.add("099");
        phasecode.setBounds(240,200,200,20);
        p.add(phasecode);

        JLabel lb1state = new JLabel("Bill Type");
        lb1state.setBounds(100,240,100,20);
        p.add(lb1state);

        billtype = new Choice();
        billtype.add("Normal");
        billtype.add("Industrial");
        billtype.setBounds(240,240,200,20);
        p.add(billtype);

        JLabel lb1email = new JLabel("Days");
        lb1email.setBounds(100,280,100,20);
        p.add(lb1email);

        JLabel lb1emails = new JLabel("30 Days");
        lb1emails.setBounds(240,280,100,20);
        p.add(lb1emails);

        JLabel lb1phone = new JLabel("Note");
        lb1phone.setBounds(100,320,100,20);
        p.add(lb1phone);

        JLabel lb1phones = new JLabel("By Default Bill is calculated for 30 days only");
        lb1phones.setBounds(240,320,500,20);
        p.add(lb1phones);

        next = new JButton("Submit");
        next.setBounds(220,390,100,25);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        p.add(next);

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

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            String meter = meternumber;
            String location = meterlocation.getSelectedItem();
            String type = metertype.getSelectedItem();
            String code = phasecode.getSelectedItem();
            String typebill = billtype.getSelectedItem();
            String days = "30";

            String query = "insert into meter_info values ('"+ meter +"','"+ location +"','"+ type +"', '"+ code +"', '"+ typebill +"','"+ days +"')";

            try {
                Conn c = new Conn();
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Meter Information Added Successfully");
                setVisible(false);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }


public static void main(String[] args) {
        new MeterInfo("");
    }
}

