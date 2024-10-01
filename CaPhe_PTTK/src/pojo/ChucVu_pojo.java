/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pojo;

/**
 *
 * @author HieuThao
 */
public class ChucVu_pojo {
    private String MaCV;
    private String TenCV;

    public String getMaCV() {
        return MaCV;
    }

    public void setMaCV(String MaCV) {
        this.MaCV = MaCV;
    }

    public String getTenCV() {
        return TenCV;
    }

    public void setTenCV(String TenCV) {
        this.TenCV = TenCV;
    }
    
    

    public ChucVu_pojo(String MaCV, String TenCV) {
        this.MaCV = MaCV;
        this.TenCV = TenCV;
    }
}
