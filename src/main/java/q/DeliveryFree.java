package q;

import java.util.HashMap;

public class DeliveryFree implements Pickup {

    @Override
    public void sendPickup(HashMap<Goods, Double> orderCurrent) {
        System.out.println("Приезжайте за заказом мы ждем Вас");
    }
}
