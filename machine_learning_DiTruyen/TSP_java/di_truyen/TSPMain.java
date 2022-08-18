package di_truyen;

public class TSPMain {
    //danganhphu 61134177
    public static void main(String[] args) {
        TSP anhPhu = new TSP();
        anhPhu.khoiTao();
        for (int i = 0; i < 10; i++)
        {
            anhPhu.danhGiaThichNghi();
            anhPhu.inKetQua();
            anhPhu.chonLoc();
            anhPhu.laiGhep();
            anhPhu.dotBien();
        }
    }
}
