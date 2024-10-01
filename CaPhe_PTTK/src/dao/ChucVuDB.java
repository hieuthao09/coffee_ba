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
public class ChucVuDB {
    private ExcuteData ex;
    
    public ChucVuDB(ExcuteData ex) {
        this.ex = ex;
    }
    public ChucVu_pojo getData_DK(String macv)
    {
        try {
            ex.createStatement();
            ex.getKn().setRs(ex.getKn().getSt().executeQuery(String.format("select * from ChucVu where macv = '%s'", macv)));
            while(ex.getKn().getRs().next())
            {
                ChucVu_pojo cv = new ChucVu_pojo(ex.getKn().getRs().getString(1), ex.getKn().getRs().getString(2));
                return cv;
            }
        } catch (SQLException ml) {
            Logger.getLogger(ChucVuDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
