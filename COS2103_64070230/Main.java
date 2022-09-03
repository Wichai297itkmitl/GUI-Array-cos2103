
import javax.swing.*;
import javax.swing.event.AncestorListener;
import javax.swing.plaf.DimensionUIResource;

import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.Field;
import java.net.http.WebSocket.Listener;
import java.nio.Buffer;

public class Main implements ActionListener{
    // Main object
    JFrame frame;
    JLabel label_head, label_intro, label_userHead, label_name, label_typeHead,
    label_typeName;
    JButton Add_student, Search, Del,logout;

    String type_user, Name;

    public Main(String Name , String type){
        
        type_user = type;
        this.Name = Name;
        frame = new JFrame("COS2103 Array");
        frame.getContentPane().setBackground(new Color(180,180,170));
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        label_head = new JLabel("COS2103 Array Application");
        label_head.setBounds(70, 10, 520, 40);
        label_head.setFont(new Font("Segoe UI", 0, 36));
        frame.add(label_head);

        label_intro = new JLabel("Welcome to array application");
        label_intro.setBounds(140, 80, 350, 32);
        label_intro.setFont(new Font("Segoe UI", 0, 22));
        frame.add(label_intro);

        label_userHead = new JLabel("ID/Username:");
        label_userHead.setFont(new Font("Segoe UI", 0, 18));
        label_userHead.setBounds(120, 125, 180, 20);
        frame.add(label_userHead);

        label_name = new JLabel(Name);
        label_name.setBounds(240, 125, 180, 20);
        label_name.setFont(new Font("Segoe UI", 0, 18));
        frame.add(label_name);

        label_typeHead = new JLabel("Type user:");
        label_typeHead.setBounds(150, 150, 180, 20);
        label_typeHead.setFont(new Font("Segoe UI", 0, 18));
        frame.add(label_typeHead);

        label_typeName = new JLabel(type);

        if (type.equals("Teacher")) { label_typeName.setForeground(new Color(0,120,120)); } // setColor type
            

        label_typeName.setBounds(240, 150, 180, 20);
        label_typeName.setFont(new Font("Segoe UI", 0, 18));
        frame.add(label_typeName);

        logout = new JButton("Logout");
        logout.setBounds(310, 152, 75, 16);
        logout.setBackground(new Color(204,51,0));
        logout.setForeground(new Color(255,255,255));
        frame.add(logout);


        if (type_user.equals("Teacher")){
            Add_student = new JButton("ADD STUDENT");
            Add_student.setBounds(40, 200, 150, 75);
            Add_student.setBackground(new Color(0,102,51));
            Add_student.setForeground(new Color(255,255,255));
            frame.add(Add_student);

            Search = new JButton("Search & Traverser");
            Search.setBounds(220, 200, 150, 75);
            Search.setBackground(new Color(102,0,102));
            Search.setForeground(new Color(255,255,255));
            frame.add(Search);

            Del = new JButton("Delete");
            Del.setBounds(400, 200, 150, 75);
            Del.setBackground(new Color(153,0,51));
            Del.setForeground(new Color(255,255,255));
            frame.add(Del);

        }else{
            Add_student = new JButton("ADD STUDENT");
            Add_student.setBounds(100, 200, 150, 75);
            Add_student.setBackground(new Color(0,102,51));
            Add_student.setForeground(new Color(255,255,255));
            frame.add(Add_student);

            Search = new JButton("Search & Traverser");
            Search.setBounds(300, 200, 150, 75);
            Search.setBackground(new Color(102,0,102));
            Search.setForeground(new Color(255,255,255));
            frame.add(Search);
        }


        Add_student.addActionListener(this);
        logout.addActionListener(this);
        Search.addActionListener(this);
        if (type_user.equals("Teacher"))
            Del.addActionListener(this);
        
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setLayout(null);
        frame.setSize(600,350);
        frame.setResizable(false);
        frame.setVisible( true );
    }
   
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(Add_student)){
            new Add(type_user);
        }
        else if (e.getSource().equals(logout)){
            frame.dispose();
            new Login();
        }
        else if (e.getSource().equals(Search)){
            new Search();
        }
        else if (e.getSource().equals(Del)){
            new Delete();
        }
        
    }  
}


