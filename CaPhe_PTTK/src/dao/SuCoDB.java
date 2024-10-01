/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import bll.SuCo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojo.LoaiSuCo_pojo;
import pojo.Nhanvien_pojo;
import pojo.SuCo_pojo;

/**
 *
 * @author HieuThao
 */
public class SuCoDB {
    
    private ExcuteData ex;
    
    public SuCoDB(ExcuteData ex) {
        this.ex = ex;
    }
    public ArrayList<SuCo_pojo> getdata()
    {
        try {
            ArrayList<SuCo_pojo> dssc = new ArrayList<>();
            ex.createStatement();
            ex.getKn().setRs(ex.getKn().getSt().executeQuery("select masc, tensc, MotaCT, HinhThuc, ChiPhi, CONVERT(nvarchar,TGXayRa), CONVERT(nvarchar,TGKetThuc), sc.MaLoai, TenLoai, nv.MaNV, nv.HoTen, nv.NgaySinh, nv.SDT, nv.CMND from SuCo sc, LoaiSuCo lsc, NhanVien nv where sc.MaLoai = lsc.MaLoai and sc.NguoiLap = nv.MaNV"));
            while(ex.getKn().getRs().next())
            {
                LoaiSuCo_pojo ml = new LoaiSuCo_pojo(ex.getKn().getRs().getString(8), ex.getKn().getRs().getString(9));
                Nhanvien_pojo nv =  new Nhanvien_pojo(ex.getKn().getRs().getString(10),ex.getKn().getRs().getString(11),ex.getKn().getRs().getString(12),ex.getKn().getRs().getString(13),ex.getKn().getRs().getString(14));
                SuCo_pojo sc = new SuCo_pojo(ex.getKn().getRs().getString(1), ex.getKn().getRs().getString(2),ex.getKn().getRs().getString(3), ex.getKn().getRs().getString(4),ex.getKn().getRs().getDouble(5), ex.getKn().getRs().getString(6),ex.getKn().getRs().getString(7),nv,ml);
                dssc.add(sc);
            }
            return dssc;
        } catch (SQLException ex) {
            Logger.getLogger(SuCoDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    //insert into SuCo_pojo(tensc, MotaCT, HinhThuc, ChiPhi, TGXayRa, TGKetThuc, NguoiLap, MaLoai) values(N'%s', N'%s', N'%s', %s, '%s', '%s', '%s', %s)
    public boolean insert(SuCo_pojo sc)
    {
        String strSQL = String.format("insert into SuCo(tensc, MotaCT, HinhThuc, ChiPhi, TGXayRa, TGKetThuc, NguoiLap, MaLoai) values(N'%s', N'%s', N'%s', %s, '%s', '%s', '%s', %s)",  sc.getTensc(), sc.getMotaCT(), sc.getHinhThuc(), sc.getChiPhi(), sc.getTGXayRa(), sc.getTGKetThuc(), sc.getNguoiLap().getMaNV(), sc.getMaLoai().getMaloai());
        return ex.excuteDataDB(strSQL);
    }
    public boolean update(SuCo_pojo sc)
    {
        String strSQL = String.format("update SuCo set tensc = N'%s', MotaCT = N'%s', HinhThuc = N'%s', ChiPhi = %s,  TGXayRa = '%s', TGKetThuc = '%s', NguoiLap = '%s', MaLoai = %s where MaSC = %s", sc.getTensc(), sc.getMotaCT(), sc.getHinhThuc(), sc.getChiPhi(), sc.getTGXayRa(), sc.getTGKetThuc(), sc.getNguoiLap().getMaNV(), sc.getMaLoai().getMaloai(), sc.getMasc());
        return ex.excuteDataDB(strSQL);
    }
    public boolean delete(String masc)
    {
        String strSQL = String.format("Delete from suco where MaSC = %s", masc);
        return ex.excuteDataDB(strSQL);
    }
     public ArrayList<SuCo_pojo> timKiemSC(String masc)
    {
        try {
            ArrayList<SuCo_pojo> dssc = new ArrayList<>();
            ex.createStatement();
            ex.getKn().setRs(ex.getKn().getSt().executeQuery(String.format("select masc, tensc, MotaCT, HinhThuc, ChiPhi, CONVERT(nvarchar,TGXayRa), CONVERT(nvarchar,TGKetThuc), sc.MaLoai, TenLoai, nv.MaNV, nv.HoTen, nv.NgaySinh, nv.SDT, nv.CMND from SuCo sc, LoaiSuCo lsc, NhanVien nv where sc.MaLoai = lsc.MaLoai and sc.NguoiLap = nv.MaNV and sc.MaSC = %s",masc )));
            while(ex.getKn().getRs().next())
            {
                LoaiSuCo_pojo ml = new LoaiSuCo_pojo(ex.getKn().getRs().getString(8), ex.getKn().getRs().getString(9));
                Nhanvien_pojo nv =  new Nhanvien_pojo(ex.getKn().getRs().getString(10),ex.getKn().getRs().getString(11),ex.getKn().getRs().getString(12),ex.getKn().getRs().getString(13),ex.getKn().getRs().getString(14));
                SuCo_pojo sc = new SuCo_pojo(ex.getKn().getRs().getString(1), ex.getKn().getRs().getString(2),ex.getKn().getRs().getString(3), ex.getKn().getRs().getString(4),ex.getKn().getRs().getDouble(5), ex.getKn().getRs().getString(6),ex.getKn().getRs().getString(7),nv,ml);
                dssc.add(sc);
            }
            return dssc;
        } catch (SQLException ex) {
            Logger.getLogger(SuCoDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
