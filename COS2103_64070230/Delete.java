
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;


public class Delete implements ActionListener{

    JFrame frame ;
    JLabel head, search_head, number, suc;
    JTextField seach_id , get_number;
    JButton go, see_all, del;
    JTextArea text;
    JScrollPane scroll;
    
    public Delete(){
    frame = new JFrame();
    frame.getContentPane().setBackground(new Color(242,216 ,216));
    
    head = new JLabel("Delate Data");
    head.setFont(new Font("Segoe UI", 0, 50));
    head.setBounds(350, 10, 500, 60);
    frame.add(head);

    text = new JTextArea();
    scroll = new JScrollPane(text);
    scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
    text.setFont(new Font("Segoe UI", 0, 24));
    scroll.setBounds(170, 100, 600, 450);
    text.setBackground(new Color(255,245,245));
    frame.add(scroll);

    see_all = new JButton("All data");
    see_all.setBounds(400, 560, 120, 60);
    see_all.setFont(new Font("Segoe UI", 0, 24));
    see_all.setForeground(new Color(255,255,255));
    see_all.setBackground(new Color(120,34,34));
    frame.add(see_all);

    search_head = new JLabel("Search by id:");
    search_head.setFont(new Font("Segoe UI", 0, 20));
    search_head.setBounds(170, 650, 120, 40);
    frame.add(search_head);
    seach_id = new JTextField();
    seach_id.setFont(new Font("Segoe UI", 0, 20));
    seach_id.setBounds(290, 655, 400, 35);
    frame.add(seach_id);

    go = new JButton("Search");
    go.setFont(new Font("Segoe UI", 0, 20));
    go.setBounds(700, 655, 100, 35);
    go.setForeground(new Color(255,255,255));
    go.setBackground(new Color(20,95,171));
    frame.add(go);
    
    number = new JLabel("Index to Delete:");
    number.setFont(new Font("Segoe UI", 0, 20));
    number.setBounds(140, 700, 150, 40);
    frame.add(number);
    get_number = new JTextField();
    get_number.setFont(new Font("Segoe UI", 0, 20));
    get_number.setBounds(290, 705, 50, 35);
    frame.add(get_number);
    del = new JButton("Delete");
    del.setFont(new Font("Segoe UI", 0, 20));
    del.setBounds(350, 705, 100, 35);
    frame.add(del);

    suc = new JLabel("");
    suc.setFont(new Font("Segoe UI", 0, 20));
    suc.setBounds(480, 705, 300, 35);
    frame.add(suc);


    see_all.addActionListener(this);
    go.addActionListener(this);
    del.addActionListener(this);


    frame.setLayout(null);
    frame.setResizable(false);
    frame.setSize(1000, 900);
    frame.setVisible(true);

    }

    public void see_All(){
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

        for (int i = 0; i < point; i++){
            text.setText(text.getText()+
            "\t"+(i+1) + "." + " ID: "+id[i] +"\n\t Name: "+name[i] + " " + last[i]
            + "\n\t Pay a Week: " + money[i]+" Baht." + "\n\t Date: " + day[i] + "\n\n");
        }

    }

    public void Serch_id(String find_id){
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
        int n = 0;
        boolean c = true;
        for (int i = 0; i < point; i++){
            if (find_id.equals(id[i])){
                text.setText(text.getText()+
            "\t"+(n+1) + "." + " ID: "+id[i] +"\n\t Name: "+name[i] + " " + last[i]
            + "\n\t Pay a Week: " + money[i]+" Baht." + "\n\t Date: " + day[i] + "\n\n");
            c = false;
            }
            ++n;
        }
        if (c){
            text.setText( "\tNot found ID: " + find_id);
        }
    }
    
    public void Del(int index){

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

        for (int i = index; i < point;i++){
            id[i] = id[i+1];
            name[i] = name[i+1];
            last[i] = last[i+1];
            money[i] = money[i+1];
            day[i] = day[i+1];
        }
        --point;
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
        suc.setText("Successfully deleted.");
    }




    public static void main(String [] args){
    }



    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource().equals(see_all)){
            suc.setText("");
            text.setText("");
            see_All();
        }
        else if (e.getSource().equals(go)){
            suc.setText("");
            text.setText("");
            String find = seach_id.getText();
            Serch_id(find);
        }
        else if (e.getSource().equals(del)){
            int index = Integer.parseInt(get_number.getText()) -1;
            text.setText("");
            Del(index);
        }
    }
    
}


