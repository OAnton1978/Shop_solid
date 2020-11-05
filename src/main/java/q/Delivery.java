package q;

import java.util.HashMap;

interface Post {
    void sendPost(HashMap<Goods, Double> orderCurrent);
}

interface DHL {
    void sendDHL(HashMap<Goods, Double> orderCurrent);
}

interface Courier {
    void sendCourier(HashMap<Goods, Double> orderCurrent);
}

interface Pickup {
    void sendPickup(HashMap<Goods, Double> orderCurrent);
}

