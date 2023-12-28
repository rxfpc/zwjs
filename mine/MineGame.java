package com.java.mine;
import com.sun.xml.internal.ws.message.MimeAttachmentSet;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
public class MineGame extends JFrame implements ActionListener {
        JMenuBar bar;
        JMenu fileMenu1, fileMenu2;
        JMenuItem 初级,中级,高级,自定义,扫雷榜;
        JMenuItem 介绍,玩法;
        MineGame mineArea = null;
        File 英雄榜= new File("英雄榜.txt");
        Hashtable hashtable = null;
        ShowHeroRecord showHeroRecord = null;
        JDialog set = null;
        JPanel panel, panel1, panel2, panel3, panel4;
    JLabel label, label1, label2, label3;
    JTextField row = null, column = null, mine = null;
    JButton 确认,取消;
    JDialog introduce = null, play = null;
    JLabel label4, label5;

    MineGame(){
        mineArea = new MineGame();
        add(mineArea, BorderLayout.CENTER);//边框布局
        bar = new JMenuBar();
        fileMenu1= new JMenu("游戏");
        初级= new JMenuItem("初级");
        中级= new JMenuItem("中级");
        高级= new JMenuItem("'高级");
        自定义= new JMenuItem("自定义");
        扫雷榜= new JMenuItem("扫雷榜");
        fileMenu1.add(初级);
        fileMenu1.add(中级);
        fileMenu1.add(高级);
        fileMenu1.add(自定义);
        fileMenu1.add(扫雷榜);
        fileMenu2 = new JMenu("帮助");
            介绍= new JMenuItem("介绍");
            玩法= new JMenuItem("玩法");
            fileMenu2.add(介绍);
            fileMenu2.add(玩法);
            bar.add(fileMenu1);
            bar.add(fileMenu2);
            setJMenuBar(bar);// 设置窗体的菜单栏
            初级.addActionListener(this);
            中级.addActionListener(this);
            高级.addActionListener(this);
            自定义.addActionListener(this);
            扫雷榜.addActionListener(this);
            介绍.addActionListener(this);
            玩法.addActionListener(this);
            hashtable = new Hashtable();
            hashtable.put("初级","初级#"+ 999 +"#匿名");
            hashtable.put("中级","中级#"+ 999 +"#匿名");
            hashtable.put("高级","高级#"+ 999 +"#匿名");
            if(!英雄榜.exists()){
                try {
                    FileOutputStream out = new FileOutputStream(英雄榜);
                    ObjectOutputStream objectOut = new ObjectOutputStream(out);
            objectOut.writeObject(hashtable);
            objectOut.close();
            out.close();
        } catch (IOException e) {
                }
                }
            showHeroRecord = new ShowHeroRecord();
            setBounds(300,160,480,560);// 移动组件并调整大小
            setVisible(true);//使Window可见
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭Window的同时关闭资源
            validate();//再次布置子组件
    }
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == 初级) {
                    mineArea.initMineArea(9, 9, 10, 1);
                    setBounds(360, 100, 276, 350);
                }
                if (e.getSource() == 中级) {
                    mineArea.initMineArea(16, 16, 40, 2);
                    setBounds(366, 160, 480, 560);
                }
                if (e.getSource() == 高级) {
                    mineArea.initMineArea(16, 30, 99, 3);
                    setBounds(100, 100, 900, 560);
                }
                if (e.getSource() == 自定义) {
                    set = new JDialog();
                    set.setTitle("自定义难度");
                    set.setBounds(380, 160, 380, 139);
                    set.setResizable(false);//设置大小不可变
                    set.setModal(true);//设置为对话框模式
                    panel = new JPanel();
                    panel.setLayout(new BorderLayout());
                    panel1 = new JPanel();
                    panel2 = new JPanel();
                    panel3 = new JPanel();
                    panel4 = new JPanel();
                    label = new JLabel("请输入行列数与地雷数:", JLabel.CENTER);
                    label1 = new JLabel("行:", JLabel.CENTER);
                    label2 = new JLabel("列:", JLabel.CENTER);
                    label3 = new JLabel("地雷数:", JLabel.CENTER);
                    row = new JTextField();
                    row.setText("16");
                    row.setSize(1, 6);
                    column = new JTextField();
                    column.setText("16");
                    mine = new JTextField();
                    mine.setText("46");
                    确认 = new JButton("确认");
                    确认.addActionListener(this);
                    取消 = new JButton("取消");
                    取消.addActionListener(this);
                    panel1.add(label1);
                    panel1.add(row);
                    panel2.add(label2);
                    panel2.add(column);
                    panel3.add(label3);
                    panel3.add(mine);
                    panel4.add(确认);
                    panel4.add(取消);
                    panel.add(panel1);
                    panel.add(panel2);
                    panel.add(panel3);
                    set.add(label, BorderLayout.NORTH);
                    set.add(panel, BorderLayout.CENTER);
                    set.add(panel4, BorderLayout.SOUTH);
                    set.setVisible(true);
                }
                if (e.getSource() == 扫雷榜) {
                    if (showHeroRecord != null)
                        showHeroRecord.setVisible(true);
                }
                if (e.getSource() == 确认) {
                    int rowNum = Integer.parseInt(row.getText());
                    int columnNum = Integer.parseInt(column.getText());
                    int mineNum = Integer.parseInt(mine.getText());
                    if (rowNum < 9)
                        rowNum = 9;
                    if (rowNum > 16)
                        rowNum = 16;
                    if (columnNum < 9)
                        columnNum = 9;
                    if (columnNum > 30)
                        columnNum = 30;
                    if (mineNum < 10) ;
                        mineNum = 10;
                    if (mineNum > 99) ;
                        mineNum = 99;
                    mineArea.initMineArea(rowNum,
                            columnNum, mineNum, 4);
                    setBounds(168, 180, columnNum * 30, rowNum * 38 + 80);
                    set.setVisible(false);
                }
                if (e.getSource() == 取消) {
                    set.setVisible(false);
                }
                if (e.getSource() == 介绍) {
                    introduce = new JDialog();
                    introduce.setTitle("扫雷介绍");
                    introduce.setBounds(380, 100, 380, 360);
                    introduce.setResizable(false);
                    introduce.setModal(true);
                    label4 = new JLabel();
                    label4.setSize(280, 250);
                    introduce.add(label4);
                    introduce.setVisible(true);
                }
                if (e.getSource() == 玩法) {
                    play = new JDialog();
                    play.setTitle("游戏玩法");
                    play.setBounds(300, 100, 300, 300);
                    play.setResizable(false);
                    play.setModal(true);
                    label4 = new JLabel();
                    label4.setSize(280, 250);
                    play.add(label4);
                    play.setVisible(true);
                }
                validate();
            }
    private void initMineArea(int rowNum, int columnNum, int mineNum, int i) {
    }
}