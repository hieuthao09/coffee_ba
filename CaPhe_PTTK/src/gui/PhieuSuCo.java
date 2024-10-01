/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui;

import bll.LoaiSuCo;
import bll.Nhanvien;
import bll.SuCo;
import dao.ExcuteData;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import pojo.LoaiSuCo_pojo;
import pojo.Nhanvien_pojo;
import pojo.SuCo_pojo;

/**
 *
 * @author HieuThao
 */
public class PhieuSuCo extends javax.swing.JPanel {

    /**
     * Creates new form PhieuSuCo
     */
    public PhieuSuCo() {
        initComponents();
    }
     JComponent com;
     ExcuteData ex;
     boolean flag;
     SuCo sc_bll ;
     LoaiSuCo lsc_bll ;
     Nhanvien nv;
    public PhieuSuCo(JComponent com, ExcuteData ex, boolean flag) {
        initComponents();
        this.com = com;
        this.ex = ex;
        this.flag = flag;
        this.sc_bll = new SuCo(ex);
        this.nv = new Nhanvien(ex);
        this.lsc_bll = new LoaiSuCo(ex);
        loadComboxLoaiSC();
        loadComboxNV();
        checkTaomoi_CapNhat();
    }
    SuCo_pojo sc =null;
    public PhieuSuCo(JComponent com, ExcuteData ex, boolean flag, SuCo_pojo sc) {
        initComponents();
        this.com = com;
        this.ex = ex;
        this.flag = flag;
        this.sc_bll = new SuCo(ex);
        this.nv = new Nhanvien(ex);
        this.lsc_bll = new LoaiSuCo(ex);
        loadComboxLoaiSC();
        checkTaomoi_CapNhat();
        this.sc = sc;
        loadComboxNV();
        loadInfoSC();
    }
    private void loadInfoSC()
    {
        if(sc!=null)
        {
            DecimalFormat decimalFormat = new DecimalFormat("#,###");
            txt_ChiPhi.setText(decimalFormat.format(sc.getChiPhi()));
            txt_Masc.setText(sc.getMasc());
            txt_hinhthuc.setText(sc.getHinhThuc());
            if(sc.getMotaCT()!=null && !sc.getMotaCT().isEmpty())
            {
                StringBuilder result = new StringBuilder();
                int wordCount = 0;
                int maxWordsPerLine = 10;

                String[] words = sc.getMotaCT().split("\\s+"); // Tách các từ trong đoạn văn bản
                
                for (String word : words) {
                    result.append(word).append(" ");
                    wordCount++;

                    if (wordCount == maxWordsPerLine) {
                        result.append("\n"); // Xuống dòng sau khi đạt đến số từ nhất định
                        wordCount = 0;
                    }
                }
                txta_Mota.setText(result.toString());
            }
            txt_tensc.setText(sc.getTensc());
            String pattern = "yyyy-MM-dd";
            SimpleDateFormat format = new SimpleDateFormat(pattern);
            Date date = null;
            try {
                date = format.parse(sc.getTGXayRa());
                dtc_batdau.setDate(date);
                Date date1 = null;
                date1 = format.parse(sc.getTGKetThuc());
                dtc_ketthuc.setDate(date1);
            } catch (ParseException ex) {
                Logger.getLogger(PhieuSuCo.class.getName()).log(Level.SEVERE, null, ex);
            }
            int index = searchIndexCombobox_NV(cbb_NguoiLap, sc.getNguoiLap());
            if(index!=-1)
            {
                cbb_NguoiLap.setSelectedIndex(index);
                
            }
            index = searchIndexCombobox_LSC(cbb_loaisuco, sc.getMaLoai());
            if(index!=-1)
            {
                cbb_loaisuco.setSelectedIndex(index);
                
            }
            
            
        }
    }
    private int searchIndexCombobox_NV(JComboBox t, Nhanvien_pojo value)
    {
        DefaultComboBoxModel<Nhanvien_pojo> model = (DefaultComboBoxModel<Nhanvien_pojo>) cbb_NguoiLap.getModel();
        for(int i = 0; i< model.getSize(); i++)
        {
            Nhanvien_pojo nhanvien = model.getElementAt(i);
            if (nhanvien.getMaNV().equals(value.getMaNV()))
            {
                return i;
            }
        }
        return -1;
    }
    private int searchIndexCombobox_LSC(JComboBox t, LoaiSuCo_pojo value)
    {
        DefaultComboBoxModel<LoaiSuCo_pojo> model = (DefaultComboBoxModel<LoaiSuCo_pojo>) cbb_loaisuco.getModel();
        for(int i = 0; i< model.getSize(); i++)
        {
            LoaiSuCo_pojo lsc = model.getElementAt(i);
            if (lsc.getMaloai().equals(value.getMaloai()))
            {
                return i;
            }
        }
        return -1;
    }
    private void loadComboxLoaiSC()
    {
        ArrayList<LoaiSuCo_pojo> dslsc = new ArrayList<>();
        dslsc = lsc_bll.laydanhsachLSC();
        DefaultComboBoxModel<LoaiSuCo_pojo> LoaiSuCoModel = new DefaultComboBoxModel<>();
        for(LoaiSuCo_pojo t : dslsc )
        {
            LoaiSuCoModel.addElement(t);
            
        }
        cbb_loaisuco.setModel(LoaiSuCoModel);
    }
    private void checkTaomoi_CapNhat()
    {
        if(!flag)
        {
           txt_Masc.setEnabled(false);
           txt_Masc.setVisible(true);
           lbl_masc.setVisible(true);
           btn_Xoa.setEnabled(true);
        }
        else
            if(flag)
            {
                txt_Masc.setVisible(false);
                lbl_masc.setVisible(false);
                btn_Xoa.setEnabled(false);
            }
    }
    private void loadComboxNV()
    {
        ArrayList<Nhanvien_pojo> dslnv = new ArrayList<Nhanvien_pojo>();
        dslnv= nv.laydanhsachNV_SC();
        DefaultComboBoxModel<Nhanvien_pojo> nhanvienModel = new DefaultComboBoxModel<>();
        for(Nhanvien_pojo t : dslnv )
        {
             nhanvienModel.addElement(t);
        }
        cbb_NguoiLap.setModel(nhanvienModel);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_trove = new javax.swing.JButton();
        btn_Luu = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lbl_masc = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txta_Mota = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbb_NguoiLap = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cbb_loaisuco = new javax.swing.JComboBox<>();
        txt_Masc = new javax.swing.JTextField();
        txt_tensc = new javax.swing.JTextField();
        txt_hinhthuc = new javax.swing.JTextField();
        dtc_batdau = new com.toedter.calendar.JDateChooser();
        dtc_ketthuc = new com.toedter.calendar.JDateChooser();
        txt_ChiPhi = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        btn_Xoa = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 204));
        setMinimumSize(new java.awt.Dimension(780, 600));
        setPreferredSize(new java.awt.Dimension(780, 600));

        btn_trove.setBackground(new java.awt.Color(102, 102, 255));
        btn_trove.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btn_trove.setText("<");
        btn_trove.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_trove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_troveActionPerformed(evt);
            }
        });

        btn_Luu.setBackground(new java.awt.Color(255, 204, 204));
        btn_Luu.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btn_Luu.setText("Lưu");
        btn_Luu.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_Luu.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                btn_LuuFocusLost(evt);
            }
        });
        btn_Luu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LuuActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lbl_masc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_masc.setText("Mã sự cố");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Tên sự cố");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Hình thức");

        txta_Mota.setColumns(20);
        txta_Mota.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txta_Mota.setRows(5);
        jScrollPane1.setViewportView(txta_Mota);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Mô tả");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Thời gian kết thúc");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Thời gian bắt đầu");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Người lập");

        cbb_NguoiLap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Loại sự cố");

        cbb_loaisuco.setKeySelectionManager(null);

        txt_Masc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txt_tensc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txt_hinhthuc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txt_ChiPhi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Chi Phí");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel3)
                        .addComponent(jLabel2)
                        .addComponent(jLabel4)
                        .addComponent(jLabel9))
                    .addComponent(lbl_masc))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txt_hinhthuc)
                            .addComponent(txt_Masc)
                            .addComponent(txt_tensc)
                            .addComponent(cbb_NguoiLap, 0, 185, Short.MAX_VALUE)
                            .addComponent(txt_ChiPhi, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(jLabel8)))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dtc_batdau, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                            .addComponent(dtc_ketthuc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbb_loaisuco, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(14, 14, 14))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_masc)
                    .addComponent(txt_Masc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbb_NguoiLap, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_tensc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)))
                    .addComponent(dtc_batdau, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_hinhthuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel6))
                    .addComponent(dtc_ketthuc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txt_ChiPhi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(cbb_loaisuco, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(46, 46, 46))
        );

        btn_Xoa.setBackground(new java.awt.Color(0, 153, 153));
        btn_Xoa.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btn_Xoa.setText("Xóa");
        btn_Xoa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_Xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(btn_trove, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(146, 146, 146)
                .addComponent(btn_Luu, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btn_Xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(62, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(btn_trove, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Luu, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_troveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_troveActionPerformed
        // TODO add your handling code here:
        XuLySuCo psc = new XuLySuCo(com, ex);
        psc.setVisible(true);
        com.removeAll();
        // Thêm form PhieuSuCo vào JComponent
        com.add(psc);
        // Cập nhật giao diện
        com.revalidate();
        com.repaint();
        // Hiển thị lại JComponent
        com.setVisible(true);
    }//GEN-LAST:event_btn_troveActionPerformed

    private void btn_LuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LuuActionPerformed
        // TODO add your handling code here:
        if(flag)
        {
            {
                SuCo_pojo sc = new SuCo_pojo();
                sc.setMasc(txt_Masc.getText());
                sc.setTensc(txt_tensc.getText());
                sc.setChiPhi(Double.parseDouble(txt_ChiPhi.getText()));
                sc.setMotaCT(txta_Mota.getText());
                sc.setHinhThuc(txt_hinhthuc.getText());
                if(dtc_batdau.getDate()!=null)
                {
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(dtc_batdau.getDate());
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String t = dateFormat.format(calendar.getTime());
                    sc.setTGXayRa(t);
                    if(dtc_ketthuc.getDate()!=null)
                    {
                        calendar.setTime(dtc_ketthuc.getDate());
                        t = dateFormat.format(calendar.getTime());
                        sc.setTGKetThuc(t);
                    }
                    else
                    {
                        Date date = new Date();
                        calendar.setTime(date);
                        t = dateFormat.format(calendar.getTime());
                        sc.setTGKetThuc(t);
                    }

                    
                }
                sc.setMaLoai((LoaiSuCo_pojo)cbb_loaisuco.getSelectedItem());
                sc.setNguoiLap((Nhanvien_pojo)cbb_NguoiLap.getSelectedItem());
                if(JOptionPane.showConfirmDialog(com, "Bạn chắc chắn thêm không?")==JOptionPane.YES_NO_OPTION)
                {
                    if(sc_bll.them(sc))
                    {
                        JOptionPane.showMessageDialog(com, String.format("Bạn đã thêm sự cố %s thành công", sc.getTensc()));
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(com, String.format("Xin lỗi vì một số sự cố mà không thêm được sự cố %s cho bạn", sc.getTensc()));
                    }
                }
            }
        }else
        {
            if(txt_Masc.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(this, "Bạn chưa điền mã sự cố");
                return;
            }
            else
            {
                SuCo_pojo sc = new SuCo_pojo();
                sc.setMasc(txt_Masc.getText());
                sc.setTensc(txt_tensc.getText());
                String formattedNumber = txt_ChiPhi.getText().replaceAll("\\.", "");
                sc.setChiPhi(Double.parseDouble(formattedNumber));
                sc.setMotaCT(txta_Mota.getText());
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(dtc_batdau.getDate());
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String t = dateFormat.format(calendar.getTime());
                sc.setTGXayRa(t);
                calendar.setTime(dtc_ketthuc.getDate());
                t = dateFormat.format(calendar.getTime());
                sc.setTGKetThuc(t);
                sc.setMaLoai((LoaiSuCo_pojo)cbb_loaisuco.getSelectedItem());
                sc.setNguoiLap((Nhanvien_pojo)cbb_NguoiLap.getSelectedItem());
                sc.setHinhThuc(txt_hinhthuc.getText());
                if(JOptionPane.showConfirmDialog(this, "Bạn muốn cập nhật phải không?")==JOptionPane.YES_NO_OPTION)
                {
                    if(sc_bll.capnhat(sc))
                    {
                        JOptionPane.showMessageDialog(this, String.format("Bạn đã cập nhật sự cố %s thành công", sc.getTensc()));
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(this, String.format("Xin lỗi vì một số sự cố mà không cập nhật được sự cố %s cho bạn", sc.getTensc()));
                    }
                }
            }
        }
            
    }//GEN-LAST:event_btn_LuuActionPerformed

    private void btn_XoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XoaActionPerformed
        // TODO add your handling code here:
        if(!flag)
        {
            if(JOptionPane.showConfirmDialog(this, "Bạn muốn cập nhật phải không?")==JOptionPane.YES_NO_OPTION)
                {
                    if(sc_bll.xoa(sc.getMasc()))
                    {
                        JOptionPane.showMessageDialog(this, String.format("Bạn đã xóa sự cố %s thành công", sc.getTensc()));
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(this, String.format("Xin lỗi vì một số sự cố mà không xóa được sự cố %s cho bạn", sc.getTensc()));
                    }
                }
        }
    }//GEN-LAST:event_btn_XoaActionPerformed

    private void btn_LuuFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btn_LuuFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_LuuFocusLost
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Luu;
    private javax.swing.JButton btn_Xoa;
    private javax.swing.JButton btn_trove;
    private javax.swing.JComboBox<Nhanvien_pojo> cbb_NguoiLap;
    private javax.swing.JComboBox<LoaiSuCo_pojo> cbb_loaisuco;
    private com.toedter.calendar.JDateChooser dtc_batdau;
    private com.toedter.calendar.JDateChooser dtc_ketthuc;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_masc;
    private javax.swing.JTextField txt_ChiPhi;
    private javax.swing.JTextField txt_Masc;
    private javax.swing.JTextField txt_hinhthuc;
    private javax.swing.JTextField txt_tensc;
    private javax.swing.JTextArea txta_Mota;
    // End of variables declaration//GEN-END:variables
}
