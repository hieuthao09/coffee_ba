/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import bll.TaiKhoan;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojo.TaiKhoan_pojo;

/**
 *
 * @author HieuThao
 */
public class TaiKhoanDB {
    private ExcuteData ex;
    
    public TaiKhoanDB(ExcuteData ex) {
        this.ex = ex;
    }
    public boolean check(TaiKhoan_pojo tk)
    {
        String strSQL = String.format("select * from taikhoan where tendn = '%s' and matkhau = '%s'", tk.getTenDN(), tk.getMatKhau());
        return ex.check(strSQL);
    }
     public ArrayList getDataTK(String strSQL)
    {
        try {
            ArrayList<TaiKhoan_pojo> dstk = new ArrayList<TaiKhoan_pojo>();
            ex.createStatement();
            ex.getKn().setRs(ex.getKn().getSt().executeQuery(strSQL));
            while(ex.getKn().getRs().next())
            {
                TaiKhoan_pojo tk = new TaiKhoan_pojo(ex.getKn().getRs().getString(0), ex.getKn().getRs().getString(1), ex.getKn().getRs().getString(2));
                dstk.add(tk);
            }
            return dstk;
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
