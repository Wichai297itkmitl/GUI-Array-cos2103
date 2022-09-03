
import javax.swing.*;
import javax.swing.event.AncestorListener;
import javax.swing.plaf.DimensionUIResource;

import java.awt.*;
import java.awt.event.*;
import java.net.http.WebSocket.Listener;

public class Login implements ActionListener{
    JFrame frame ;
    JLabel label_head ;
    JLabel label_user ;
    JComboBox type_list;
    JButton login_user;
    JTextField Get_user ;
    String name;
    String type_user;

    public Login(){
        
        frame = new JFrame("COS2103 Array"); 
        frame.getContentPane().setBackground(new Color(180,180,200));
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        
        label_head = new JLabel("Welcome to Array COS2103"); // Title lable
        label_head.setBounds(50,5, 500, 40);
        label_head.setFont(new Font("Segoe UI", 0, 36));
        frame.add(label_head);

        label_user = new JLabel("ID/Username:");
        label_user.setBounds(50,80, 110, 20);
        label_user.setFont(new Font("Segoe UI", 0, 18));
        frame.add(label_user);

        Get_user = new JTextField();
        Get_user.setBounds(165, 80, 200, 20);
        frame.add(Get_user);
        
        type_list  = new JComboBox<>(new String[] {"Studen", "Teacher"});
        type_list.setBounds(165, 110, 100, 20);
        frame.add(type_list);

        login_user = new JButton("Login");
        login_user.setBounds(165, 140, 80, 30);
        login_user.setBackground(new Color(51,51,51));
        login_user.setForeground(new Color(255,255,255));
        login_user.addActionListener(this);
        frame.add(login_user);


        // 
        frame.setLayout(null);
        frame.setSize(560,250);
        frame.setResizable(false);
        frame.setVisible( true );

    }
    public static void main(String[] args){
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(login_user)){
            frame.dispose();
            name = Get_user.getText();
            type_user = type_list.getSelectedItem().toString();
            new Main(name, type_user);
        }
    }
}

