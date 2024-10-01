/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bll;

import dao.ExcuteData;
import dao.TaiKhoanDB;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojo.TaiKhoan_pojo;
/**
 *
 * @author HieuThao
 */
public class TaiKhoan {
    private TaiKhoanDB tkdb;
    public TaiKhoan(ExcuteData ex) {
        tkdb = new TaiKhoanDB(ex);
    }
    
    public boolean timkiemTaiKhoan(TaiKhoan_pojo tk)
    {
        return tkdb.check(tk);
    }
}
