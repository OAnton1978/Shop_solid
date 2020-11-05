package q;

import java.util.HashMap;

public class DeliveryByCash implements Post, DHL, Courier {

    @Override
    public void sendPost(HashMap<Goods, Double> orderCurrent) {
        System.out.println("Ваш заказ отправлен Почтой, ожидайте в течении недели");
    }

    @Override
    public void sendDHL(HashMap<Goods, Double> orderCurrent) {
        System.out.println("Ваш заказ отправлен DHL, ожидайте в течении дня");
    }

    @Override
    public void sendCourier(HashMap<Goods, Double> orderCurrent) {
        System.out.println("Ваш заказ отправлен курьером, ожидайте в течении 5 часов");
    }
}
