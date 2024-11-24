package quanLyBanAoNam.phieuNhap;

public class chiTietPhieuNhap {
    private String idChiTietNhap;
    private int soLuongChiTietNhap;
    
    public chiTietPhieuNhap(String idChiTietNhap, int soLuongChiTietNhap) {
        this.idChiTietNhap = idChiTietNhap;
        this.soLuongChiTietNhap = soLuongChiTietNhap;
    }

    public String getIdChiTietNhap() {
        return idChiTietNhap;
    }

    public void setIdChiTietNhap(String idChiTietNhap) {
        this.idChiTietNhap = idChiTietNhap;
    }

    public int getSoLuongChiTietNhap() {
        return soLuongChiTietNhap;
    }

    public void setSoLuongChiTietNhap(int soLuongChiTietNhap) {
        this.soLuongChiTietNhap = soLuongChiTietNhap;
    }
}
