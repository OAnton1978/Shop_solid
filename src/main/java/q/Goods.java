package q;

public class Goods {
    String goodsName;
    double goodsPrice;

    public Goods(String goodsName, double goodsPrice) {
        this.goodsName = goodsName;
        this.goodsPrice = goodsPrice;
    }

    public Goods() {
    }

    public double getGoodsPrice() {
        return goodsPrice;
    }

    public String getGoodsName() {
        return goodsName;
    }

    @Override
    public String toString() {
        return "Наименование = '" + goodsName + '\'' +
                ", Цена = " + goodsPrice;
    }
}
