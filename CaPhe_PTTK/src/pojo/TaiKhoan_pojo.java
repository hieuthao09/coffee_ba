/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pojo;


/**
 *
 * @author HieuThao
 */
public class TaiKhoan_pojo {
    private String TenDN;
    private String MatKhau;
    private String NgayTao;

    public TaiKhoan_pojo(String TenDN, String MatKhau, String NgayTao) {
        this.TenDN = TenDN;
        this.MatKhau = MatKhau;
        this.NgayTao = NgayTao;
    }

    public TaiKhoan_pojo() {
    }

    public String getTenDN() {
        return TenDN;
    }

    public void setTenDN(String TenDN) {
        this.TenDN = TenDN;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public String getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(String NgayTao) {
        this.NgayTao = NgayTao;
    }

    public TaiKhoan_pojo(String TenDN, String MatKhau) {
        this.TenDN = TenDN;
        this.MatKhau = MatKhau;
    }
    
    
}
