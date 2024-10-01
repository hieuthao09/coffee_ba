/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pojo;

/**
 *
 * @author HieuThao
 */
public class Nhanvien_pojo {
    private String MaNV;
    private String HoTen;
    private String NgaySinh;
    private String SDT;
    private String CMND;
    private ChucVu_pojo MaCV;
    private String GioiTinh;

    @Override
    public String toString() {
        return HoTen ;
    }
    
    public Nhanvien_pojo() {
    }

    public Nhanvien_pojo(String MaNV, String HoTen, String NgaySinh, String SDT, String CMND, ChucVu_pojo MaCV, String GioiTinh) {
        this.MaNV = MaNV;
        this.HoTen = HoTen;
        this.NgaySinh = NgaySinh;
        this.SDT = SDT;
        this.CMND = CMND;
        this.MaCV = MaCV;
        this.GioiTinh = GioiTinh;
    }

    public Nhanvien_pojo(String MaNV, String HoTen, String NgaySinh, String SDT, String CMND) {
        this.MaNV = MaNV;
        this.HoTen = HoTen;
        this.NgaySinh = NgaySinh;
        this.SDT = SDT;
        this.CMND = CMND;
    }
    
    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public ChucVu_pojo getMaCV() {
        return MaCV;
    }

    public void setMaCV(ChucVu_pojo MaCV) {
        this.MaCV = MaCV;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }
    
}
