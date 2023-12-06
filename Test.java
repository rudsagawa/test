import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Test extends Frame {
    private boolean shouldDrawText = false; // 新增标志变量

    public Test() {
        super("掷硬币");
        setSize(2000, 1000);
        setVisible(true);
        setLayout(null); // 使用绝对定位

        Button flipButton = new Button("coin");
        flipButton.setBounds(1000, 300, 100, 50); // 设置按钮的位置和大小
        flipButton.setForeground(Color.BLACK); // 设置按钮的前景色
        add(flipButton);

        flipButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shouldDrawText = true; // 点击按钮时设置标志变量为 true
                repaint(); // 强制重绘
            }
        });

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                System.exit(0);
            }
        });
    }

    public void paint(Graphics g) {
        Random random = new Random();
        super.paint(g);

        Font font = new Font("Serif", Font.PLAIN, 30);
        g.setFont(font);

        g.setColor(Color.BLACK);
        if (shouldDrawText) { // 当标志变量为 true 时才绘制文本
            int num = random.nextInt(10);
            System.out.println("打印"+num);
            if (num % 2 != 0) {
                g.drawString("硬币正面",  1000, 400);
            } else {
                g.drawString("硬币反面",  1000, 400);
            }
        }
    }

    public static void main(String[] args) {
        Test test = new Test();
    }
}
