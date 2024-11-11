public class soSanhNgay implements Comparator {
    @Override
    public int compare(hoaDon o1, hoaDon o2) {
        return o1.getNgayNhap().compareTo(o2.getNgayNhap());
    }
    
}
