/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojo.ChucVu_pojo;
import pojo.LoaiSuCo_pojo;
import pojo.Nhanvien_pojo;

/**
 *
 * @author HieuThao
 */
public class NhanvienDB {
    private ExcuteData ex;
    
    public NhanvienDB(ExcuteData ex) {
        this.ex = ex;
    }
    public ArrayList<Nhanvien_pojo> getDataNV_SC()
    {
        try {
            ArrayList<Nhanvien_pojo> dsnv = new ArrayList<>();
            ex.createStatement();
            ex.getKn().setRs(ex.getKn().getSt().executeQuery("select MaNV, HoTen, NgaySinh, SDT, CMND, nv.MACV, TenCV, GioiTinh from NhanVien nv, ChucVu cv where cv.MaCV = nv.MaCV"));
            while(ex.getKn().getRs().next())
            {
                ChucVu_pojo cv = new ChucVu_pojo(ex.getKn().getRs().getString(6), ex.getKn().getRs().getString(7));
                Nhanvien_pojo nv = new Nhanvien_pojo(ex.getKn().getRs().getString(1), ex.getKn().getRs().getString(2),ex.getKn().getRs().getString(3),ex.getKn().getRs().getString(4),ex.getKn().getRs().getString(5),cv,ex.getKn().getRs().getString(8));
                dsnv.add(nv);
            }
            return dsnv;
        } catch (SQLException ml) {
            Logger.getLogger(LoaiSuCo_pojo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
