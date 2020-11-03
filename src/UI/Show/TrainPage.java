package UI.Show;

import Logical.Data.OpData;
import Logical.Operation.Operation;
import Logical.Operation.Operator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrainPage {

    JButton btnNew = new JButton("��һ��");   //���ⰴť
    //JButton startJButton = new JButton("��ʼ");   //���ⰴť
    JLabel lblA = new JLabel(); // ������A
    JLabel lblOp = new JLabel(); // ����Op
    JLabel lblB = new JLabel(); // ������B
    JLabel label5 = new JLabel(); // =��
    JTextField txtAnswer = new JTextField();    //�𰸿�

    private int count1 = 0;    //��¼������
    JLabel sumExercise = new JLabel();

    private int count2 = 0;    //��¼��ȷ����
    JLabel rightExercise = new JLabel();


    Integer a = 0, b = 0;
    String op = "+";
    int result = 0;

    public void show(){

        Operator operator = new Operation();
        OpData data = operator.RandomData();
        a = data.getData1();
        b = data.getData2();
        result = operator.Op_rule(data);
        int c = data.getData3();
        switch(c) {
            case 0:op="+";break;
            case 1:op="-";break;
        }

        JFrame frame = new JFrame();
        JPanel panel;
        panel = (JPanel) frame.getContentPane();
        panel.setLayout(null);



        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        ImageIcon backgroundIcon = new ImageIcon("./source/imgs/����2.jpg");
        JLabel imageJLabel = new JLabel(backgroundIcon);

        // ��ȡ��Ļ��С
        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        // ���ô�����Ϣ
        int frameWidth = 800;
        int frameHeight = 550;
        int frameX = (screenWidth - frameWidth) / 2;
        int frameY = (screenHeight - frameHeight) / 2;
        // ��������������Ļ����
        frame.setBounds(frameX, frameY, frameWidth, frameHeight);
        imageJLabel.setBounds(0, 0, frame.getWidth(), frame.getHeight());
        frame.getLayeredPane().add(imageJLabel, Integer.MIN_VALUE);


        btnNew.setFont(new Font("Dialog", Font.BOLD, 25));
        btnNew.setBounds(117, 191, 127, 50);
        btnNew.setBackground(new Color(224, 255, 255));
        panel.add(btnNew);


        lblA.setBounds(92, 122, 61, 36);
        lblA.setText(a.toString());
        //��������
        lblA.setFont(new Font("Dialog",Font.PLAIN,24));
        panel.add(lblA);

        lblOp.setBounds(170, 121, 51, 37);
        lblOp.setText(op);
        lblOp.setFont(new Font("Dialog",Font.PLAIN,24));
        panel.add(lblOp);

        lblB.setBounds(241, 122, 61, 36);
        lblB.setText(b.toString());
        lblB.setFont(new Font("Dialog",Font.PLAIN,24));
        panel.add(lblB);

        label5.setBounds(321, 122, 42, 36);
        label5.setText("=");
        label5.setFont(new Font("Dialog",Font.PLAIN,24));
        panel.add(label5);


        txtAnswer.setBounds(379, 122, 113, 48);
        txtAnswer.setFont(new Font("Dialog",Font.PLAIN,24));
        panel.add(txtAnswer);

        sumExercise.setBounds(600, 100, 113, 48);
        sumExercise.setText("������:"+count1);
        sumExercise.setFont(new Font("����",Font.PLAIN,24));
        panel.add(sumExercise);

        rightExercise.setBounds(600, 150, 115, 48);
        rightExercise.setText("��ȷ����:"+count2);
        rightExercise.setFont(new Font("����",Font.PLAIN,20));
        panel.add(rightExercise);


        btnNew.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = txtAnswer.getText();
                Integer d = null;
                if(str.length()!=0)
                    d = Integer.valueOf(str);
                if(d==null||d!=result) {
                    return;
                }
                String disp = ""+ " "+a +" "+ op +" "+ b +" "+ "=" +" "+ str +" ";
                count2++;
                count1++;
                Operator operator = new Operation();
                OpData data = operator.RandomData();
                a = data.getData1();
                b = data.getData2();
                result = operator.Op_rule(data);
                int c = data.getData3();
                switch(c) {
                    case 0:op="+";break;
                    case 1:op="-";break;
                }
                sumExercise.setText("������:"+count1);
                rightExercise.setText("��ȷ����:"+count2);
                lblA.setText(a.toString());
                lblB.setText(b.toString());
                lblOp.setText(op);
                txtAnswer.setText("");
            }
        });



        panel.add(imageJLabel);
        panel.setOpaque(false);    //�������������Ϊ͸��������ͼƬλ����������·�
        frame.setVisible(true);
    }

    public static void main(String[] arg0){
        TrainPage trainPage = new TrainPage();
        trainPage.show();
    }
}
