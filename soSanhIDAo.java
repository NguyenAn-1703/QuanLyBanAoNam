package quanLyBanAoNam;

public class soSanhIDAo implements Comparator{
    @Override
    public int compareID(ao o1, ao o2){
        return o1.getId().compareTo(o2.getId());
    }
}
