package quanlychothuexe;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class QuanLyXeGUI extends JFrame {
    private DefaultTableModel tableModel;
    private JTable table;
    private ArrayList<Oto> danhSachXe = new ArrayList<>();
    private int currentMaOto = 1000;  // Tự động tăng mã ô tô

    public QuanLyXeGUI() {
        setTitle("Quản Lý Cho Thuê Xe Ô Tô");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Bảng hiển thị thông tin xe
        tableModel = new DefaultTableModel(new Object[]{"Mã Ô Tô", "Loại Xe", "Mức Tiền Thuê", "Số Xe"}, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        // Các nút chức năng
        JButton btnNhapMoi = new JButton("Nhập Mới");
        JButton btnXoa = new JButton("Xóa");
        JButton btnSua = new JButton("Sửa");
        JButton btnLuuFile = new JButton("Lưu File");

        // Panel chứa các nút
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnNhapMoi);
        buttonPanel.add(btnXoa);
        buttonPanel.add(btnSua);
        buttonPanel.add(btnLuuFile);

        // Sự kiện cho các nút
        btnNhapMoi.addActionListener(e -> nhapMoi());
        btnXoa.addActionListener(e -> xoaXe());
        btnSua.addActionListener(e -> suaXe());
        btnLuuFile.addActionListener(e -> luuFile());

        // Layout chính
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Tải dữ liệu từ file nếu có
        taiDuLieu();
    }

    private void nhapMoi() {
        // Hiển thị dialog để nhập thông tin
        String loaiXe = JOptionPane.showInputDialog("Nhập Loại Xe:");
        double mucTienThue = Double.parseDouble(JOptionPane.showInputDialog("Nhập Mức Tiền Thuê:"));
        int soXe = Integer.parseInt(JOptionPane.showInputDialog("Nhập Số Xe:"));

        // Tạo đối tượng Oto và thêm vào danh sách
        Oto xe = new Oto(currentMaOto++, loaiXe, mucTienThue, soXe);
        danhSachXe.add(xe);

        // Cập nhật bảng hiển thị
        tableModel.addRow(new Object[]{xe.getMaOto(), xe.getLoaiXe(), xe.getMucTienThue(), xe.getSoXe()});
    }

    private void xoaXe() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            danhSachXe.remove(selectedRow);
            tableModel.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một hàng để xóa.");
        }
    }

    private void suaXe() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            Oto xe = danhSachXe.get(selectedRow);
            String loaiXe = JOptionPane.showInputDialog("Nhập Loại Xe:", xe.getLoaiXe());
            double mucTienThue = Double.parseDouble(JOptionPane.showInputDialog("Nhập Mức Tiền Thuê:", xe.getMucTienThue()));
            int soXe = Integer.parseInt(JOptionPane.showInputDialog("Nhập Số Xe:", xe.getSoXe()));

            xe.setLoaiXe(loaiXe);
            xe.setMucTienThue(mucTienThue);
            xe.setSoXe(soXe);

            // Cập nhật lại bảng
            tableModel.setValueAt(loaiXe, selectedRow, 1);
            tableModel.setValueAt(mucTienThue, selectedRow, 2);
            tableModel.setValueAt(soXe, selectedRow, 3);
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một hàng để sửa.");
        }
    }

    private void luuFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("OTO.DAT"))) {
            oos.writeObject(danhSachXe);
            JOptionPane.showMessageDialog(this, "Lưu thành công vào file OTO.DAT");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void taiDuLieu() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("OTO.DAT"))) {
            danhSachXe = (ArrayList<Oto>) ois.readObject();
            currentMaOto = danhSachXe.stream().mapToInt(Oto::getMaOto).max().orElse(999) + 1;

            for (Oto xe : danhSachXe) {
                tableModel.addRow(new Object[]{xe.getMaOto(), xe.getLoaiXe(), xe.getMucTienThue(), xe.getSoXe()});
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            QuanLyXeGUI frame = new QuanLyXeGUI();
            frame.setVisible(true);
        });
    }
}
