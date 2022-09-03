import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Search implements ActionListener{
    
        // Search & Traverser
        JFrame frame2;
        JLabel search_head, by_head, traverser_head;
        JTextField search_id;
        JButton go,t_left, t_right, all;
        JTextArea text;
        JScrollPane scroll;

        public int n_tra = -1;


    public Search(){
        frame2 = new JFrame("Search");
        frame2.getContentPane().setBackground(new Color(195,195,198));
        search_head = new JLabel("Search & Traverser");
        search_head.setFont(new Font("Segoe UI", 0, 50));
        search_head.setBounds(200, 10, 450, 60);
        frame2.add(search_head);

        by_head = new JLabel("Search by ID:");
        by_head.setFont(new Font("Segoe UI", 0, 30));
        by_head.setBounds(100, 100, 350, 40);
        frame2.add(by_head);
        search_id = new JTextField();
        search_id.setFont(new Font("Segoe UI", 0, 30));
        search_id.setBounds(300, 105, 350, 40);
        frame2.add(search_id);
        go = new JButton("Go");
        go.setBackground(new Color(29,95,139));
        go.setForeground(new Color(255,255,255));
        go.setFont(new Font("Segoe UI", 0, 25));
        go.setBounds(660, 105, 70, 40);
        frame2.add(go);


        traverser_head = new JLabel("Traverser:");
        traverser_head.setFont(new Font("Segoe UI", 0, 30));
        traverser_head.setBounds(145, 155, 300, 40);
        frame2.add(traverser_head);

        t_left = new JButton("<--");
        t_left.setBackground(new Color(7,25,177));
        t_left.setFont(new Font("Segoe UI", 0, 25));
        t_left.setForeground(new Color(255,255,255));
        t_left.setBounds(300, 155, 80, 40);
        frame2.add(t_left);

        t_right = new JButton("-->");
        t_right.setFont(new Font("Segoe UI", 0, 25));
        t_right.setBackground(new Color(7,25,177));
        t_right.setForeground(new Color(255,255,255));
        t_right.setBounds(400, 155, 80, 40);
        frame2.add(t_right);

        all = new JButton("See all");
        all.setFont(new Font("Segoe UI", 0, 25));
        all.setBackground(new Color(62,111,45));
        all.setForeground(new Color(255,255,255));
        all.setBounds(500, 155, 150, 40);
        frame2.add(all);

        text = new JTextArea();
        scroll = new JScrollPane(text);
        
        text.setBackground(new Color(220,220,220));
        text.setFont(new Font("Segoe UI", 0, 24));
        scroll.setBounds(150, 220, 600, 500);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        frame2.add(scroll);
        
        go.addActionListener(this);
        t_left.addActionListener(this);
        t_right.addActionListener(this);
        all.addActionListener(this);


        frame2.setLayout(null);
        frame2.setResizable(false);
        frame2.setSize(900, 800);
        frame2.setVisible(true);
    
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
        for (int i = 0; i < point; i++){
            if (find_id.equals(id[i])){
                text.setText(text.getText()+
            "\t"+(n+1) + "." + " ID: "+id[i] +"\n\t Name: "+name[i] + " " + last[i]
            + "\n\t Pay a Week: " + money[i]+" Baht." + "\n\t Date: " + day[i] + "\n\n");
            ++n;
            }
        }
        if (n == 0){
            text.setText(text.getText() + "Not found ID: " + find_id);
        }
    }

    public void Traverser_right(){
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
        if (n_tra <= point-2){
            ++n_tra;
            text.setText(text.getText()+
            "\t"+(n_tra+1) + "." + " ID: "+id[n_tra] +"\n\t Name: "+name[n_tra] + " " + last[n_tra]
            + "\n\t Pay a Week: " + money[n_tra]+" Baht." + "\n\t Date: " + day[n_tra]);
        }
        else{ n_tra = point; text.setText(text.getText()+"\tIndex out of range!");}
            
            
        


    }

    public void Traverser_left(){
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
        --n_tra; 
        if (n_tra >= 0){
            text.setText(text.getText()+
            "\t"+(n_tra+1) + "." + " ID: "+id[n_tra] +"\n\t Name: "+name[n_tra] + " " + last[n_tra]
            + "\n\t Pay a Week: " + money[n_tra]+" Baht." + "\n\t Date: " + day[n_tra]);
        }
        else{text.setText(text.getText()+"\tIndex out of range!"); n_tra = -1;}
    }
    public static void main(String [] args){
        new Search();
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource().equals(all)){
            text.setText("");
            n_tra = -1;
            see_All();
        }
        else if (e.getSource().equals(go)){
            n_tra = -1;
            text.setText("");
            String find = search_id.getText();
            Serch_id(find);
        }
        else if (e.getSource().equals(t_right)){
            text.setText("");
            Traverser_right();
        }
        else if ( e.getSource().equals(t_left)){
            text.setText("");
            Traverser_left();
        }
    }
}
