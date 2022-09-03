
import javax.swing.*;
import javax.swing.event.AncestorListener;
import javax.swing.plaf.DimensionUIResource;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.net.http.WebSocket.Listener;
import java.nio.Buffer;
import java.util.Random;
import java.util.RandomAccess;


public class Add implements ActionListener{


    // ADD student object
    JFrame frame1;
    JLabel title, head, get_type, head_id, head_name, head_last, head_pay, unit, date, save;
    JTextField field_id ,field_name, field_last, field_pay, field_day, field_mount, field_year;
    JButton submit, reset;
    
    public Add(String type){
        frame1 = new JFrame("ADD");
        frame1.getContentPane().setBackground(new Color(207,230,218));

        title = new JLabel("ADD STUDENT DATA");
        title.setFont(new Font("Segoe UI", 0, 38));
        title.setBounds(200, 10, 400, 42);
        frame1.add(title);

        head = new JLabel("User_Type:");
        head.setFont(new Font("Segoe UI", 0, 25));
        head.setBounds(250, 80, 150, 35);
        frame1.add(head);

        get_type = new JLabel(type);
        if (type.equals("Teacher")) { get_type.setForeground(new Color(0,120,200)); } // setColor type
        get_type.setFont(new Font("Segoe UI", 0, 25));
        get_type.setBounds(380, 80, 150, 35);
        frame1.add(get_type);

        head_id = new JLabel("ID:");
        head_id.setFont(new Font("Segoe UI", 0, 25));
        head_id.setBounds(90, 150, 150, 35);
        frame1.add(head_id);
        field_id = new JTextField();
        field_id.setFont(new Font("Segoe UI", 0, 18));
        field_id.setBounds(140, 155, 200, 30);
        frame1.add(field_id);

        head_name = new JLabel("Name:");
        head_name.setFont(new Font("Segoe UI", 0, 25));
        head_name.setBounds(50, 200, 100, 35);
        frame1.add(head_name);
        field_name = new JTextField();
        field_name.setFont(new Font("Segoe UI", 0, 18));
        field_name.setBounds(140, 205, 200, 30);
        frame1.add(field_name);

        head_last = new JLabel("Surname:");
        head_last.setFont(new Font("Segoe UI", 0, 25));
        head_last.setBounds(350, 200, 150, 35);
        frame1.add(head_last);
        field_last = new JTextField();
        field_last.setFont(new Font("Segoe UI", 0, 18));
        field_last.setBounds(460, 205, 200, 30);
        frame1.add(field_last);

        head_pay = new JLabel("Pay:");
        head_pay.setFont(new Font("Segoe UI", 0, 25));
        head_pay.setBounds(80, 250, 100, 35);
        frame1.add(head_pay);
        field_pay = new JTextField();
        field_pay.setFont(new Font("Segoe UI", 0, 18));
        field_pay.setBounds(140, 255, 200, 30);
        frame1.add(field_pay);
        unit = new JLabel("Baht.");
        unit.setFont(new Font("Segoe UI", 0, 20));
        unit.setBounds(350, 255, 200, 30);
        frame1.add(unit);

        date = new JLabel("Date:");
        date.setFont(new Font("Segoe UI", 0, 25));
        date.setBounds(70, 300, 100, 35);
        frame1.add(date);

        field_day = new JTextField();
        field_day.setFont(new Font("Segoe UI", 0, 18));
        field_day.setBounds(140, 305, 40, 30);
        frame1.add(field_day);
        JLabel s = new JLabel("/");
        s.setFont(new Font("Segoe UI", 0, 25));
        s.setBounds(185, 305, 40, 30);
        frame1.add(s);
        field_mount = new JTextField();
        field_mount.setFont(new Font("Segoe UI", 0, 18));
        field_mount.setBounds(205, 305, 40, 30);
        frame1.add(field_mount);
        JLabel s2 = new JLabel("/");
        s2.setFont(new Font("Segoe UI", 0, 25));
        s2.setBounds(250, 305, 40, 30);
        frame1.add(s2);
        field_year = new JTextField();
        field_year.setFont(new Font("Segoe UI", 0, 18));
        field_year.setBounds(265, 305, 60, 30);
        frame1.add(field_year);

        submit = new JButton("Submit");
        submit.setBounds(140, 350, 100, 50);
        submit.setBackground(new Color(0,102,51));
        submit.setForeground(new Color(255,255,255));
        frame1.add(submit);




        reset = new JButton("Clear");
        reset.setBounds(260, 350, 100, 50);
        reset.setBackground(new Color(0,50,108));
        reset.setForeground(new Color(255,255,255));
        frame1.add(reset);

        save = new JLabel("");
        save.setFont(new Font("Segoe UI", 0, 30));
        save.setForeground(new Color(5,150,0));
        save.setBounds(400, 350, 300, 50);
        
        frame1.add(save);



        // field_id.addActionListener(this); field_name.addActionListener(this); field_last.addActionListener(this);
        // field_pay.addActionListener(this);
        // field_day.addActionListener(this); field_mount.addActionListener(this); field_year.addActionListener(this);

        submit.addActionListener(this);
        reset.addActionListener(this);

        frame1.setLayout(null);
        frame1.setResizable(false);
        frame1.setSize(800, 500);
        frame1.setVisible(true);
        
    }

    
    public void Write_DB(String Id, String Name, String Last, Double Money, String Day){
        BufferedReader read_buffer, read_id,read_name, read_last, read_money, read_day;
        int buffer = 0;
        try{
            read_buffer = new BufferedReader(new FileReader("buffer.txt"));
            buffer = Integer.parseInt(read_buffer.readLine());
            read_buffer.close();
        }catch (IOException f){
            f.printStackTrace();
        }
        int point = 0; // pointor index;
        String[] id = new String [buffer];
        String[] name = new String [buffer];
        String[] last = new String[buffer];
        double[] money = new double [buffer];
        String[] day = new String [buffer];

        try{
            read_buffer = new BufferedReader(new FileReader("buffer.txt"));
            read_name = new BufferedReader(new FileReader("DB_name.txt"));
            read_last = new BufferedReader(new FileReader("DB_lastName.txt"));
            read_money = new BufferedReader(new FileReader("DB_money.txt"));
            read_day = new BufferedReader(new FileReader("DB_date.txt"));
            read_id = new BufferedReader(new FileReader("DB_id.txt"));
            String data_id, data_name, data_last, data_day;
            double data_money;

            while((data_id = read_id.readLine()) != null){
                if (point == buffer-1){
                    buffer+=5;
                }
                data_name = read_name.readLine();
                data_last = read_last.readLine();
                data_money = Double.parseDouble(read_money.readLine());
                data_day = read_day.readLine();
                id[point] = data_id;
                name[point] = data_name;
                last[point] = data_last;
                money[point] = data_money;
                day[point] = data_day;
                ++point;
            }

            read_id.close(); read_name.close(); read_last.close(); read_money.close(); read_day.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        
            
    
    
        boolean n = true;
        int at = 0;
        for (int i = point-1; i > -1; i--){
            if (Id.equals(id[i])){
                n = false;
                at = i;
            }
        }

        if (n == true){
            id[point] = Id;
            name[point] = Name; last[point] = Last;
            money[point] = Money;
            day[point] = Day;
            ++point;
        }else{
            for (int i = point-1; i > at; i--){
                id[i+1] = id[i];
                name[i+1] = name[i]; last[i+1] = last[i];
                money[i+1] = money[i];
                day[i+1] = day[i];
            }
            id[at+1] = Id;
            name[at+1] = Name; last[at+1] = Last;
            money[at+1] = Money;
            day[at+1] = Day;
            ++point;
        }
        
        // Write to file.txt
        try{
            BufferedWriter write_buffer, write_id, write_name, write_last, write_money,write_day;
            write_buffer = new BufferedWriter(new FileWriter("buffer.txt"));
            write_id = new BufferedWriter(new FileWriter("DB_id.txt"));
            write_name = new BufferedWriter(new FileWriter("DB_name.txt"));
            write_last = new BufferedWriter(new FileWriter("DB_lastName.txt"));
            write_money = new BufferedWriter(new FileWriter("DB_money.txt"));
            write_day = new BufferedWriter(new FileWriter("DB_date.txt"));

            write_buffer.write(String.valueOf(buffer)); write_buffer.close();
        
        for (int i = 0; i < point; i++){
        if (i != point-1){
            write_id.write(id[i] +"\n");
            write_name.write(name[i] +"\n");
            write_last.write(last[i] +"\n");
            write_money.write(String.valueOf(money[i]) +"\n");
            write_day.write(day[i] +"\n");
        }else{
            write_id.write(id[i]);
            write_name.write(name[i]);
            write_last.write(last[i]);
            write_money.write(String.valueOf(money[i]));
            write_day.write(day[i]);
        }
        }
        write_id.close(); write_name.close(); write_last.close(); write_money.close(); write_day.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args){
       new Add("Student");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(submit)){
            String Id = field_id.getText();
            String Name = field_name.getText();
            String Last = field_last.getText();
            Double Money = Double.parseDouble(field_pay.getText());
            String Day = field_day.getText() + "/" + 
            field_mount.getText() + "/" + field_year.getText();

            Write_DB(Id, Name, Last, Money, Day);
            save.setText("Save Successfully.");

            
        }

        else if (e.getSource().equals(reset)){
            field_id.setText(""); field_name.setText(""); field_last.setText(""); field_pay.setText("");
            field_day.setText(""); field_mount.setText(""); field_year.setText("");
            save.setText("");
        }


    }
}
