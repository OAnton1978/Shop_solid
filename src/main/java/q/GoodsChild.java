package q;

public class GoodsChild extends Goods {

    int sertificateNumber;
    int ageChild;

    public GoodsChild(String goodsName, double goodsPrice, int sertificateNumber, int ageChild) {
        super(goodsName, goodsPrice);
        this.sertificateNumber = sertificateNumber;
        this.ageChild = ageChild;
    }

    public int getAgeChild() {
        return ageChild;
    }

    @Override
    public String toString() {
        return "Наименование = '" + goodsName + '\'' +
                ", Цена = " + goodsPrice + ", Сертификат № " + sertificateNumber +
                ", Возраст (лет) " + ageChild;
    }
}
