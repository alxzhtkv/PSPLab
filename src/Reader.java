import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class Reader extends JFrame {
    String text1;
    String selectedServices="";;
    int k;
    Object boxA, boxB, boxC,boxD;
    File file = new File("C://Users//Александра//Desktop//учёба//3 курс//5 сем//псп//reservation.txt");
    static JLabel l1, l2, l3, l4,l5,l6,l7,l8;
    JComboBox box_1, box_2, box_3,box_4;
    JRadioButton flag1, flag2,flag3, flag4;
    ButtonGroup bg;

    static JList DepartureCities,ArrivalCities;
    static JButton b, del;
    static JTextField text;
    static JTextArea area;

    JCheckBox services1,services2,services3,services4,services5;
    static String[] box1 = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
    static String[] box2 = {"январь","февраль","март","апрель","май","июнь","июль","август","сентябрь","октябрь","ноябрь","декабрь"};
    static String[] box3 = {"2022","2023","2024","2025"};

    String[] DepartureCitiesBox ={"Минск","Москва","Санкт-Петербург", "Люксембург", "Лондон"};

    String[] ArrivalCitiesBox ={"Тбилиси","Каир","Стамбул","Вена","Осло","Амстердам"};

    String[] daysBox ={"3","4","5","6","7"," 8 и более>"};


    public Reader(String str){
        super(str);
        setSize(700, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        b = new JButton("Сохранить");
        del = new JButton("Очистить");
        text = new JTextField(9);
        area = new JTextArea(9, 9);
        l1 = new JLabel("Ваше имя");
        l2 = new JLabel("Город вылета");
        l3 = new JLabel("Город прибытия");
        l4 = new JLabel("Дата начала тура");
        l5 = new JLabel("Количество дней");
        l6 = new JLabel("Зведность отеля");
        l7 = new JLabel("Услуги и удобства");
        l8 = new JLabel("Дополнительные пожелания");
        box_1 = new JComboBox(box1);
        box_2 = new JComboBox(box2);
        box_3 = new JComboBox<Object>(box3);
        flag1 = new JRadioButton("3 звезды");
        flag2 = new JRadioButton("4 звезды");
        flag3 = new JRadioButton("5 звезд");
        flag4 = new JRadioButton("любая");

        DepartureCities=new JList(DepartureCitiesBox);
        ArrivalCities = new JList(ArrivalCitiesBox);

        box_4 = new JComboBox(daysBox);
        services1 = new JCheckBox("Бесплатный интернет");
        services2 = new JCheckBox("С животными");
        services3 = new JCheckBox("Бассейн");
        services4 = new JCheckBox("Рестораны a la card");
        services5 = new JCheckBox("Без детей");


        bg = new ButtonGroup();
        bg.add(flag1);
        bg.add(flag2);
        bg.add(flag3);
        bg.add(flag4);

        setLayout(null);
        text.setSize(220,25);
        text.setLocation(250, 20);
        DepartureCities.setSize(200,130);
        DepartureCities.setLocation(30,90);

        ArrivalCities.setSize(200,130);
        ArrivalCities.setLocation(250,90);

        l1.setSize(200,25);
        l1.setLocation(30, 20);
        l2.setSize(220, 25);
        l2.setLocation(30, 60);
        l3.setSize(200, 25);
        l3.setLocation(250, 60);
        l4.setSize(200, 25);
        l4.setLocation(30, 250);
        l5.setSize(200, 25);
        l5.setLocation(30, 300);
        l6.setSize(200, 25);
        l6.setLocation(30, 340);
        l7.setSize(220,25);
        l7.setLocation(30, 380);
        l8.setSize(220,25);
        l8.setLocation(30, 490);


        box_1.setSize(40,25);
        box_1.setLocation(250,250);
        box_2.setSize(100, 25);
        box_2.setLocation(300, 250);
        box_3.setSize(70, 25);
        box_3.setLocation(410, 250);
        box_4.setSize(200,25);
        box_4.setLocation(250,300);

        flag1.setSize(100,25);
        flag1.setLocation(250, 340);

        flag2.setSize(100, 25);
        flag2.setLocation(350, 340);

        flag3.setSize(100,25);
        flag3.setLocation(450, 340);

        flag4.setSize(100, 25);
        flag4.setLocation(550, 340);

        services1.setSize(200,25);
        services1.setLocation(250, 380);

        services2.setSize(150,25);
        services2.setLocation(250, 400);

        services3.setSize(150,25);
        services3.setLocation(250, 420);

        services4.setSize(150,25);
        services4.setLocation(250, 440);

        services5.setSize(150,25);
        services5.setLocation(250, 460);

        area.setSize(400,75);
        area.setLocation(250,500);

        b.setSize(200,30);
        b.setLocation(250, 600);
        del.setSize(100, 30);
        del.setLocation(30, 600);




        add(b);
        add(del);
        add(text);
        add(DepartureCities);
        add(ArrivalCities);

        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(l5);
        add(l6);
        add(l7);
        add(l8);
        add(box_1);
        add(box_2);
        add(box_3);
        add(box_4);
        add(flag1);
        add(flag2);
        add(flag3);
        add(flag4);
        add(services1);
        add(services2);
        add(services3);
        add(services4);
        add(services5);
        add(area);

        b.addActionListener(new ButtonActionListener());
        flag1.addActionListener(new FlagActionListener());
        flag2.addActionListener(new FlagActionListener());
        del.addActionListener(new DelActionListener());
        box_1.addActionListener(new BoxActionListener());
        box_2.addActionListener(new BoxActionListener());
        box_3.addActionListener(new BoxActionListener());
        box_4.addActionListener(new BoxActionListener());

        services1.addActionListener(new MarkerActionListener());
        services2.addActionListener(new MarkerActionListener());
        services3.addActionListener(new MarkerActionListener());
        services4.addActionListener(new MarkerActionListener());
        services5.addActionListener(new MarkerActionListener());
    }

    public class ButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try{
                if(!file.exists()){
                    file.createNewFile();
                }
                FileWriter out = new FileWriter(file, true);
                try{
                    out.write("Имя клиента:  " +text.getText()+ "\n");
                    out.write("Город вылета: "+ DepartureCities.getSelectedValue()+"\n");
                    out.write("Город прибытия: "+ ArrivalCities.getSelectedValue()+"\n");
                    out.write(" (Дата начала тура:" + boxA + " " + boxB + " " + boxC + ")"+"\n");
                    out.write(" (Количество дней:" + boxD + ")"+"\n");
//                    String text1 = text.getText();
//                    String area2 = area.getText();
//                    out.write(text1 + " - ");
//                    out.write(area2 + "\n");
                    if(k == 1)
                        out.write("Звездность отеля: " +flag1.getText()+ "\n");
                    else if(k == 2)
                        out.write("Звездность отеля: " +flag2.getText()+ "\n");
                    else if (k==3)
                        out.write("Звездность отеля: " +flag3.getText()+ "\n");
                    else if (k==4)
                        out.write("Звездность отеля: " +flag4.getText()+ "\n");
                    out.write(" Услуги и удобства :" + selectedServices + "\n");
                    selectedServices="";
                    out.write("Дополнительные пожелания:" + area.getText() + "\n\n");




                } finally{
                    out.close();
                }
            }catch(IOException e1){
                throw new RuntimeException(e1);
            }
        }
    }

    public class FlagActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            k = 0;
            if(e.getSource() == flag1){
                k=1;
            }
            else if(e.getSource() == flag2){
                k=2;
            }
            else if(e.getSource() == flag3){
                k=3;
            }
            else if(e.getSource() == flag4){
                k=4;
            }
        }
    }

    public class MarkerActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {


            k = 0;
            if(e.getSource() == services1){
                selectedServices+=services1.getText()+", ";
            }
            else if(e.getSource() == services2){
                selectedServices+=services2.getText()+", ";
            }
            else if(e.getSource() == services3){
                selectedServices+=services3.getText()+", ";
            }
            else if(e.getSource() == services4){
                selectedServices+=services4.getText()+", ";
            }
            else if(e.getSource() == services5){
                selectedServices+=services5.getText()+",";
            }
        }
    }
    public class DelActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == del){
                text.setText(null);
                area.setText(null);
                DepartureCities.clearSelection();
                ArrivalCities.clearSelection();
                bg.clearSelection();
                services1.setSelected(false);
                services2.setSelected(false);
                services3.setSelected(false);
                services4.setSelected(false);
                services5.setSelected(false);
                box_1.setSelectedItem(null);
                box_2.setSelectedItem(null);
                box_3.setSelectedItem(null);
                box_4.setSelectedItem(null);




            }
        }
    }
    public class BoxActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == box_1){
                boxA = box_1.getSelectedItem();
            }
            if(e.getSource() == box_2){
                boxB = box_2.getSelectedItem();
            }
            if(e.getSource() == box_3){
                boxC = box_3.getSelectedItem();
            }
            if(e.getSource() == box_4) {
                boxD = box_4.getSelectedItem();
            }
        }
    }
}
