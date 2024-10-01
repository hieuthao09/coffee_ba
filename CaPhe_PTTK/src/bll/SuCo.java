/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bll;

import dao.ExcuteData;
import dao.SuCoDB;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojo.LoaiSuCo_pojo;
import pojo.Nhanvien_pojo;
import pojo.SuCo_pojo;

/**
 *
 * @author HieuThao
 */
public class SuCo {
    private SuCoDB scdb;
    public SuCo(ExcuteData ex) {
        scdb = new SuCoDB(ex);
    }
    public ArrayList<SuCo_pojo> laydanhsach()
    {
        return scdb.getdata();
    }
    //insert into SuCo_pojo(tensc, MotaCT, HinhThuc, ChiPhi, TGXayRa, TGKetThuc, NguoiLap, MaLoai) values(N'%s', N'%s', N'%s', %s, '%s', '%s', '%s', %s)
    public boolean them(SuCo_pojo sc)
    {
       return scdb.insert(sc);
    }
    public boolean capnhat(SuCo_pojo sc)
    {
        return scdb.update(sc);
    }
    public boolean xoa(String masc)
    {
        return scdb.delete(masc);
    }
     public ArrayList<SuCo_pojo> timKiemSC(String masc)
    {
        return scdb.timKiemSC(masc);
    }
}
