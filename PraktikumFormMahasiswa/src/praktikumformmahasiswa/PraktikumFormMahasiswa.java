package praktikumformmahasiswa;

import javax.swing.*;
import java.awt.event.*;

public class PraktikumFormMahasiswa {
    public static void main(String[] args) {
        JFrame utamaFrame = new JFrame();
        utamaFrame.setSize(480, 370);
        utamaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel utamaPanel = new JPanel();
        utamaFrame.add(utamaPanel);
        tambahkanKomponen(utamaPanel);

        utamaFrame.setVisible(true);
    }

    private static void tambahkanKomponen(JPanel utamaPanel) {
        utamaPanel.setLayout(null);

        JLabel labelNamaLengkap = new JLabel("Nama Lengkap:");
        labelNamaLengkap.setBounds(10, 20, 120, 30);
        utamaPanel.add(labelNamaLengkap);

        JTextField textNamaLengkap = new JTextField(20);
        textNamaLengkap.setBounds(180, 20, 240, 30);
        utamaPanel.add(textNamaLengkap);

        JLabel labelTanggalLahir = new JLabel("Tanggal Lahir:");
        labelTanggalLahir.setBounds(10, 60, 120, 30);
        utamaPanel.add(labelTanggalLahir);

        JTextField textTanggalLahir = new JTextField(20);
        textTanggalLahir.setBounds(180, 60, 240, 30);
        utamaPanel.add(textTanggalLahir);

        JLabel labelNomorDaftar = new JLabel("Nomor Pendaftaran:");
        labelNomorDaftar.setBounds(10, 100, 144, 30);
        utamaPanel.add(labelNomorDaftar);

        JTextField textNomorDaftar = new JTextField(20);
        textNomorDaftar.setBounds(180, 100, 240, 30);
        utamaPanel.add(textNomorDaftar);

        JLabel labelNoTelepon = new JLabel("No. Telp:");
        labelNoTelepon.setBounds(10, 140, 120, 30);
        utamaPanel.add(labelNoTelepon);

        JTextField textNoTelepon = new JTextField(20);
        textNoTelepon.setBounds(180, 140, 240, 30);
        utamaPanel.add(textNoTelepon);

        JLabel labelAlamatLengkap = new JLabel("Alamat:");
        labelAlamatLengkap.setBounds(10, 180, 120, 30);
        utamaPanel.add(labelAlamatLengkap);

        JTextField textAlamatLengkap = new JTextField(20);
        textAlamatLengkap.setBounds(180, 180, 240, 30);
        utamaPanel.add(textAlamatLengkap);

        JLabel labelAlamatEmail = new JLabel("E-mail:");
        labelAlamatEmail.setBounds(10, 220, 120, 30);
        utamaPanel.add(labelAlamatEmail);

        JTextField textAlamatEmail = new JTextField(20);
        textAlamatEmail.setBounds(180, 220, 240, 30);
        utamaPanel.add(textAlamatEmail);

        JButton tombolSubmit = new JButton("Submit");
        tombolSubmit.setBounds(180, 260, 96, 30);
        utamaPanel.add(tombolSubmit);

        tombolSubmit.addActionListener((ActionEvent e) -> {
            String namaLengkap = textNamaLengkap.getText();
            String tanggalLahir = textTanggalLahir.getText();
            String nomorDaftar = textNomorDaftar.getText();
            String noTelepon = textNoTelepon.getText();
            String alamatLengkap = textAlamatLengkap.getText();
            String alamatEmail = textAlamatEmail.getText();

            if (namaLengkap.isEmpty() || tanggalLahir.isEmpty() || nomorDaftar.isEmpty() || noTelepon.isEmpty() || alamatLengkap.isEmpty() || alamatEmail.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Semua kolom harus terisi.");
            } else {
                int response = JOptionPane.showConfirmDialog(null, "Apakah anda yakin data yang Anda isi sudah benar?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                if (response == JOptionPane.YES_OPTION) {
                    JFrame hasilFrame = new JFrame("Data Mahasiswa");
                    hasilFrame.setSize(360, 240);
                    JPanel hasilPanel = new JPanel();
                    hasilFrame.add(hasilPanel);
                    hasilPanel.setLayout(null);

                    JLabel hasilLabel = new JLabel("<html>"
                            + "<table>"
                            + "<tr><td style='width: 120px;'>Nama:</td><td>" + namaLengkap + "</td></tr>"
                            + "<tr><td style='width: 120px;'>Tanggal Lahir:</td><td>" + tanggalLahir + "</td></tr>"
                            + "<tr><td style='width: 120px;'>Nomor Pendaftaran:</td><td>" + nomorDaftar + "</td></tr>"
                            + "<tr><td style='width: 120px;'>No. Telp:</td><td>" + noTelepon + "</td></tr>"
                            + "<tr><td style='width: 120px;'>Alamat:</td><td>" + alamatLengkap + "</td></tr>"
                            + "<tr><td style='width: 120px;'>E-mail:</td><td>" + alamatEmail + "</td></tr>"
                            + "</table>"
                            + "</html>");
                    hasilLabel.setBounds(10, 10, 340, 190);
                    hasilPanel.add(hasilLabel);

                    hasilFrame.setVisible(true);
                }
            }
        });
    }
}
