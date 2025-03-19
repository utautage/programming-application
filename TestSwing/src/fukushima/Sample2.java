package fukushima;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

public class Sample2 {
	private JFrame frame = new JFrame("Sample2");
	private JButton button = new JButton("Push");
	private JTextField txt = new JTextField(20);
	private JLabel label = new JLabel("Message Area");
	private JProgressBar pgb = new JProgressBar(0, 8);
	private Fib fib = null;
	public static void main(String[] args) {
		Sample2 sample2 = new Sample2();
		sample2.exec();
	}
	private void exec() {
		frame.setBounds(300, 200, 300, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container container = frame.getContentPane();
		container.setLayout(new FlowLayout());
		label.setForeground(Color.RED);
		txt.setBackground(Color.LIGHT_GRAY);
		txt.setForeground(Color.BLUE);
		button.setBackground(Color.CYAN);
		container.add(txt);
		container.add(button);
		container.add(label);
		container.add(pgb);
		button.addActionListener(e -> {
			if (fib != null) {
				fib.stop();
				return;
			}
			int n = 0;
			try {
				n = Integer.parseInt(txt.getText());
			} catch(NumberFormatException ex) {}
			if (fib != null) return;
			fib = new Fib(n, (ans, stage) -> {					
				if (ans != Fib.WORKING) {
					fib = null;
					label.setText("ans=" + ans);
					pgb.setValue(0);
				} else {
					label.setText("stage=" + stage);
					pgb.setValue(stage);
				}
			});
			Thread th = new Thread(fib);
			th.start();
		});
		frame.setVisible(true);
	}
}
