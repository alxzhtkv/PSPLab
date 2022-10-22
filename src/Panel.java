import javax.swing.*;
import java.awt.event.*;

import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Panel extends JFrame{
    Object box;
    JList list;
    JList list1;
    JTextArea text1;
    String[] myList={"Бремя страстей человеческих","Три товарища","Поющие в терновнике","Маленькие женщины","Демиан","Великий Гэтсби","Сто лет одиночества"};
    String[] myList1={"Бремя страстей ","Два товарища","Поющие в кустах","Маленькие женщины","Дэмиан","Великий Гэтсби","Что лет одиночества"};
    Panel(){
        super("Сравнение списков");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 1000);


         DefaultListModel listModel = new DefaultListModel();
         DefaultListModel listModel1 = new DefaultListModel();


        for(String string:myList){
            listModel.add(0,string);
        }
        list  = new JList(listModel);

        for(String string:myList1){
            listModel1.add(0,string);
        }
        list1  = new JList(listModel1);


        text1 = new JTextArea();
        JTextField newRecord=new JTextField();
        JTextField newRecord1=new JTextField();
        JButton addButton = new JButton("Add");
        JButton addButton1 = new JButton("Add");
        JButton compareButton = new JButton("Compare");
        JButton deleteButton = new JButton("Delete");
        JButton deleteButton1 = new JButton("Delete");
        JButton editButton = new JButton("Edit");
        JButton editButton1 = new JButton("Edit");
        JButton clearButton = new JButton("Clear");
        JButton clearButton1 = new JButton("Clear");
        JDialog dialog = new JDialog();


        setLayout(null);

        text1.setEditable (false);

//        JScrollPane scrollPane = new JScrollPane(list);

//        JScrollPane scrollPane = new JScrollPane();
//        scrollPane.getViewport().setView(list);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String element = newRecord.getText();
                listModel.addElement(element);
                int index = listModel.size() - 1;

                list.setSelectedIndex(index);
                list.ensureIndexIsVisible(index);
                newRecord.setText(null);

            }
        });

        addButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String element = newRecord1.getText();

                listModel1.addElement(element);
                int index1 = listModel1.size() - 1;

                list1.setSelectedIndex(index1);
                list1.ensureIndexIsVisible(index1);
                newRecord1.setText(null);

            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                listModel.remove(list.getSelectedIndex());

            }
        });

        deleteButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                listModel1.remove(list1.getSelectedIndex());

            }
        });

        compareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int count=0;
                text1.setText(null);

                int maxNumber=Math.max(listModel.size(),listModel1.size());

                if(maxNumber==listModel.size() || listModel1.size()==listModel.size() ){
                    for(int i=0;i<listModel.size();i++){
                        count=0;
                        for(int j=0;j<listModel1.size();j++) {
                            if(listModel.elementAt(i)==listModel1.elementAt(j))
                                count++;
                        }
                        if(count==0) {
                            text1.setText(text1.getText()+"\n"+(String)listModel.elementAt(i));
                        }
                    }

                }
                else {

                    for(int i=0;i<listModel1.size();i++){
                        count=0;
                        for(int j=0;j<listModel.size();j++) {
                            if(listModel1.elementAt(i)==listModel.elementAt(j))
                                count++;
                        }
                        if(count==0)
                            text1.setText(text1.getText()+"\n"+(String)listModel1.elementAt(i));
                    }

                }
                dialog.add(text1);
                dialog.setVisible(true);


            }
        });

        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                newRecord.setText(list.getSelectedValue().toString());
            }
        });

        list1.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                newRecord1.setText(list1.getSelectedValue().toString());
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newRecord.setText(null);
            }
        });

        clearButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newRecord1.setText(null);
            }
        });

        editButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String element = newRecord1.getText();
                int g = list1.getSelectedIndex();
                listModel1.add(g,element);
                listModel1.remove(g+1);
                newRecord1.setText(null);

            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String element = newRecord.getText();
                int g = list.getSelectedIndex();
                listModel.add(g,element);
                listModel.remove(g+1);
                newRecord.setText(null);

            }
        });



        compareButton.setBounds(600,100,100,50);
        addButton.setBounds(10,320,100,50);
        add(addButton);
        deleteButton.setBounds(160,320,100,50);
        add(deleteButton);

        addButton1.setBounds(310,320,100,50);
        add(addButton1);
        deleteButton1.setBounds(460,320,100,50);
        add(deleteButton1);

        list.setSize(250, 300);
        list1.setSize(250, 300);
        list.setLocation(10,10);
        list1.setLocation(310,10);
        text1.setSize(250, 500);
//        text1.setLocation(600,155);

        newRecord.setSize(250,20);
        newRecord.setLocation(10,390);

        newRecord1.setSize(250,20);
        newRecord1.setLocation(310,390);

        editButton.setBounds(10,420,250,20);
        editButton1.setBounds(310,420,250,20);

        clearButton.setBounds(10,450,250,20);
        clearButton1.setBounds(310,450,250,20);

        dialog.setSize(250,400);
        dialog.setLocation(600,200);

        add(list);
        add(list1);
        add(compareButton);
        add(newRecord);
        add(newRecord1);
        add(editButton);
        add(editButton1);

        add(clearButton);
        add(clearButton1);

    }

}
