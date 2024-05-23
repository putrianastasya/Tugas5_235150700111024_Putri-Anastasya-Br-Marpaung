package praktikumformmahasiswa;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Matakuliah extends JFrame {
    JLabel labelJudul, labelTugas, labelKuis, labelUTS, labelUAS, labelHasil;
    JTextField inputTugas, inputKuis, inputUTS, inputUAS, inputHasil;
    JButton tombolHitung, tombolTampilkanSemua;
    JRadioButton radioPemlan, radioASD, radioMatkomlan, radioProbstat;
    JTextArea areaHasil;
    ButtonGroup grupMataKuliah;
    MataKuliah mataKuliahTerpilih;
    double nilaiPemlan, nilaiASD, nilaiMatkomlan, nilaiProbstat;

    public Matakuliah() {
        setLayout(null);

        labelJudul = new JLabel("Hitung Nilai Akhir");
        labelJudul.setFont(new Font("Arial", Font.BOLD, 14));
        add(labelJudul);
        labelJudul.setBounds(100, 10, 170, 20);

        radioPemlan = new JRadioButton("Pemlan");
        radioASD = new JRadioButton("ASD");
        radioMatkomlan = new JRadioButton("Matkomlan");
        radioProbstat = new JRadioButton("Probstat");

        grupMataKuliah = new ButtonGroup();
        grupMataKuliah.add(radioPemlan);
        grupMataKuliah.add(radioASD);
        grupMataKuliah.add(radioMatkomlan);
        grupMataKuliah.add(radioProbstat);

        radioASD.setBounds(10, 40, 100, 20);
        radioPemlan.setBounds(110, 40, 100, 20);
        radioMatkomlan.setBounds(210, 40, 100, 20);
        radioProbstat.setBounds(310, 40, 100, 20);

        add(radioPemlan);
        add(radioASD);
        add(radioMatkomlan);
        add(radioProbstat);

        labelTugas = new JLabel("Tugas : ");
        add(labelTugas);
        labelTugas.setBounds(50, 70, 62, 20);

        inputTugas = new JTextField("0");
        add(inputTugas);
        inputTugas.setBounds(150, 70, 60, 20);

        labelKuis = new JLabel("Kuis : ");
        add(labelKuis);
        labelKuis.setBounds(50, 100, 70, 20);

        inputKuis = new JTextField("0");
        add(inputKuis);
        inputKuis.setBounds(150, 100, 60, 20);

        labelUTS = new JLabel("UTS : ");
        add(labelUTS);
        labelUTS.setBounds(50, 130, 70, 20);

        inputUTS = new JTextField("0");
        add(inputUTS);
        inputUTS.setBounds(150, 130, 60, 20);

        labelUAS = new JLabel("UAS : ");
        add(labelUAS);
        labelUAS.setBounds(50, 160, 70, 20);

        inputUAS = new JTextField("0");
        add(inputUAS);
        inputUAS.setBounds(150, 160, 60, 20);

        labelHasil = new JLabel("Hasil : ");
        add(labelHasil);
        labelHasil.setBounds(50, 190, 70, 20);

        inputHasil = new JTextField("0");
        add(inputHasil);
        inputHasil.setBounds(150, 190, 60, 20);
        inputHasil.setEditable(false);

        tombolHitung = new JButton("Hitung");
        add(tombolHitung);
        tombolHitung.setBounds(50, 220, 100, 20);

        tombolTampilkanSemua = new JButton("Tampilkan nilai semua matkul");
        add(tombolTampilkanSemua);
        tombolTampilkanSemua.setBounds(100, 370, 200, 20);

        areaHasil = new JTextArea();
        areaHasil.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(areaHasil);
        scrollPane.setBounds(50, 250, 300, 100);
        add(scrollPane);

        tombolHitung.addActionListener(new HitungAction());
        tombolTampilkanSemua.addActionListener(new TampilkanSemuaAction());
        radioPemlan.addActionListener(new MataKuliahAction());
        radioASD.addActionListener(new MataKuliahAction());
        radioMatkomlan.addActionListener(new MataKuliahAction());
        radioProbstat.addActionListener(new MataKuliahAction());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 450);
        setTitle("Hitung Nilai Akhir");
        setVisible(true);
    }

    class MataKuliahAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            inputTugas.setText("0");
            inputKuis.setText("0");
            inputUTS.setText("0");
            inputUAS.setText("0");
            inputHasil.setText("0");

            if (event.getSource() == radioPemlan) {
                mataKuliahTerpilih = new Pemlan();
            } else if (event.getSource() == radioASD) {
                mataKuliahTerpilih = new ASD();
            } else if (event.getSource() == radioMatkomlan) {
                mataKuliahTerpilih = new Matkomlan();
            } else if (event.getSource() == radioProbstat) {
                mataKuliahTerpilih = new Probstat();
            }
        }
    }

    class HitungAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            try {
                int tugas = Integer.parseInt(inputTugas.getText().trim());
                int kuis = Integer.parseInt(inputKuis.getText().trim());
                int UTS = Integer.parseInt(inputUTS.getText().trim());
                int UAS = Integer.parseInt(inputUAS.getText().trim());

                if (mataKuliahTerpilih != null) {
                    double hasil = mataKuliahTerpilih.hitungNilaiAkhir(tugas, kuis, UTS, UAS);
                    inputHasil.setText(String.format("%.2f", hasil));

                    if (mataKuliahTerpilih instanceof ASD) {
                        nilaiASD = hasil;
                    } else if (mataKuliahTerpilih instanceof Pemlan) {
                        nilaiPemlan = hasil;
                    } else if (mataKuliahTerpilih instanceof Matkomlan) {
                        nilaiMatkomlan = hasil;
                    } else if (mataKuliahTerpilih instanceof Probstat) {
                        nilaiProbstat = hasil;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Pilih mata kuliah terlebih dahulu!", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                inputHasil.setText("Error");
            }
        }
    }

    class TampilkanSemuaAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            areaHasil.setText("");
            areaHasil.append("HASIL NILAI SEMUA MATA KULIAH\n");
            areaHasil.append("ASD: " + String.format("%.2f", nilaiASD) + "\n");
            areaHasil.append("Pemlan: " + String.format("%.2f", nilaiPemlan) + "\n");
            areaHasil.append("Matkomlan: " + String.format("%.2f", nilaiMatkomlan) + "\n");
            areaHasil.append("Probstat: " + String.format("%.2f", nilaiProbstat) + "\n");
        }
    }

    public static void main(String[] args) {
        new Matakuliah();
    }
}

abstract class MataKuliah {
    abstract double hitungNilaiAkhir(int tugas, int kuis, int UTS, int UAS);
    abstract String getNama();
}

class Pemlan extends MataKuliah {
    double hitungNilaiAkhir(int tugas, int kuis, int UTS, int UAS) {
        return (tugas * 0.3) + (kuis * 0.2) + (UTS * 0.25) + (UAS * 0.25);
    }

    String getNama() {
        return "Pemlan";
    }
}

class ASD extends MataKuliah {
    double hitungNilaiAkhir(int tugas, int kuis, int UTS, int UAS) {
        return (tugas * 0.25) + (kuis * 0.25) + (UTS * 0.25) + (UAS * 0.25);
    }

    String getNama() {
        return "ASD";
    }
}

class Matkomlan extends MataKuliah {
    double hitungNilaiAkhir(int tugas, int kuis, int UTS, int UAS) {
        return (tugas * 0.2) + (kuis * 0.3) + (UTS * 0.2) + (UAS * 0.3);
    }

    String getNama() {
        return "Matkomlan";
    }
}

class Probstat extends MataKuliah {
    double hitungNilaiAkhir(int tugas, int kuis, int UTS, int UAS) {
        return (tugas * 0.25) + (kuis * 0.25) + (UTS * 0.2) + (UAS * 0.3);
    }

    String getNama() {
        return "Probstat";
    }
}
