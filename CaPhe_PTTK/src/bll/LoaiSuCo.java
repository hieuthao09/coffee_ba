/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bll;

import dao.ExcuteData;
import dao.LoaiSuCoDB;
import java.util.ArrayList;
import pojo.LoaiSuCo_pojo;


/**
 *
 * @author HieuThao
 */
public class LoaiSuCo {
    private LoaiSuCoDB lscdb;
    
    public LoaiSuCo(ExcuteData ex) {
        lscdb = new LoaiSuCoDB(ex);
    }
    public ArrayList<LoaiSuCo_pojo> laydanhsachLSC()
    {
        return lscdb.getDataLSC();
    }
}
