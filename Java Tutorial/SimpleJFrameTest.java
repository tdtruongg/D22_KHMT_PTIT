import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleJFrameTest {
    public static void main(String[] args) {
        // Sử dụng SwingUtilities.invokeLater để đảm bảo GUI chạy trên Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            // Tạo JFrame
            JFrame frame = new JFrame("Test JFrame");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1500, 1000);
            frame.setLayout(null); // Sử dụng layout tự do

            // Tạo JLabel
            JLabel label = new JLabel();
            label.setBounds(50, 50, 300, 30); // Đặt vị trí và kích thước của JLabel
            frame.add(label);

            // Tạo JButton
            JButton button = new JButton("Click me!");
            button.setBounds(50, 100, 100, 30); // Đặt vị trí và kích thước của JButton
            frame.add(button);

            // Thêm sự kiện ActionListener cho nút
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    label.setText("Hello, JFrame is working!");
                }
            });

            // Hiển thị JFrame
            frame.setVisible(true);
        });
    }
}
