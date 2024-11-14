public abstract class thongke {
    protected DS_HoaDon ds;
    protected int tongsoluongsanpham ;
    protected DS_AO dsaodaban ;
    public void ghivaodanhsach (DS_AO ao){
        dsaodaban.add(ao);

    }
    public abstract void thongketheothang();
    public abstract void thongketheoquy();
    public abstract void thongketheonam();

}
