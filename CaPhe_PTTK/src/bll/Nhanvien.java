/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bll;

import dao.ExcuteData;
import dao.NhanvienDB;
import dao.SuCoDB;
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
public class Nhanvien {
    private NhanvienDB nvdb;
    
    public Nhanvien(ExcuteData ex) {
         nvdb = new NhanvienDB(ex);
    }
    public ArrayList<Nhanvien_pojo> laydanhsachNV_SC()
    {
        return nvdb.getDataNV_SC();
    }
}
