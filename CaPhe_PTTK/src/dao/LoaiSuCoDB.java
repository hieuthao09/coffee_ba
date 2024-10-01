/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojo.LoaiSuCo_pojo;

/**
 *
 * @author HieuThao
 */
public class LoaiSuCoDB {
    private ExcuteData ex;
    
    public LoaiSuCoDB(ExcuteData ex) {
        this.ex = ex;
    }
    public ArrayList<LoaiSuCo_pojo> getDataLSC()
    {
        try {
             ArrayList<LoaiSuCo_pojo> dslsc = new ArrayList<>();
            ex.createStatement();
            ex.getKn().setRs(ex.getKn().getSt().executeQuery("select * from LoaiSuCo"));
             while(ex.getKn().getRs().next())
            {
                LoaiSuCo_pojo ml = new LoaiSuCo_pojo(ex.getKn().getRs().getString(1), ex.getKn().getRs().getString(2));
                dslsc.add(ml);
            }
            return dslsc;
        } catch (SQLException ex) {
            Logger.getLogger(LoaiSuCoDB.class.getName()).log(Level.SEVERE, null, ex);
        }
           
        return null;
    }
}
