package fukushima;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class Sample1 {
	JFrame frame = new JFrame("試験画面");
	JButton button = new JButton("Push");
	JLabel label = new JLabel("Message Area");
	JLabel label2 = new JLabel("Message Area2");
	JTextField txt = new JTextField(20);
	
	public static void main(String[] args) {
		Sample1 sample1 = new Sample1();
		sample1.testLayout();
	}
	private void testLayout() {
		frame.setBounds(300, 200, 300, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container container = frame.getContentPane();
		container.setLayout(new FlowLayout());
		label.setForeground(Color.RED);
		txt.setBackground(Color.LIGHT_GRAY);
		txt.setForeground(Color.BLUE);
		button.setBackground(Color.CYAN);
		container.add(label);
		container.add(txt);
		container.add(button);
		container.add(label2);
		button.addActionListener(e -> label.setText("Hello," + txt.getText()));
		Timer timer = new Timer(1000, e -> label2.setText(getDateString()));
		timer.start();
		frame.setVisible(true);
	}
	private String getDateString() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}
}
