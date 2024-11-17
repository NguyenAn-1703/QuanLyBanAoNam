package quanLyBanAoNam.hoaDon;

public class chiTietHoaDon {
    private String idChiTietBan;
    private int soLuongChiTietBan;
    
    public chiTietHoaDon(String idChiTietBan, int soLuongChiTietBan) {
        this.idChiTietBan = idChiTietBan;
        this.soLuongChiTietBan = soLuongChiTietBan;
    }

    public String getIdChiTietBan() {
        return idChiTietBan;
    }

    public void setIdChiTietBan(String idChiTietBan) {
        this.idChiTietBan = idChiTietBan;
    }

    public int getSoLuongChiTietBan() {
        return soLuongChiTietBan;
    }

    public void setSoLuongChiTietBan(int soLuongChiTietBan) {
        this.soLuongChiTietBan = soLuongChiTietBan;
    }

    
}
