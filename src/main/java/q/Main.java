package q;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int minSumOrder = 1000;    //Минимальная сумма заказа для доставки
        double totalSum = 0;    //Общая сумма заказа
        int priceBread = 34;   //цена хлеба
        int pricePear = 250;    //цена груш
        int priceBiscuit = 250;  //цена печенья
        int priceDiaper = 1500;  //цена подгузников
        double countBiscuitStock = 2433.3;  //Начальное количество печенья на складе
        double countPearStock = 243.3;  //Начальное количество груш на складе
        double countBreadStock = 24363.3;  //Начальное количество хлеба на складе
        double countDiaperStock = 241;  //Начальное количество подгузников на складе
        int sertificateNumber = 425151; //Номер сертификата подгузников
        int ageChild = 1; //Возраст на который расчитаны подгузники
        Goods goods;
        HashMap<Goods, Double> orderCurrent = new HashMap<Goods, Double>();
        HashMap<Goods, Double> stock = new HashMap<Goods, Double>();
        Goods biscuit = new Goods("Печенье", priceBiscuit);
        stock.put(biscuit, countBiscuitStock);
        Goods pear = new Goods("Груши", pricePear);
        stock.put(pear, countPearStock);
        Goods bread = new Goods("Хлеб", priceBread);
        stock.put(bread, countBreadStock);
        GoodsChild diaper = new GoodsChild("Подгузники", priceDiaper, sertificateNumber, ageChild);
        stock.put(diaper, countDiaperStock);
        System.out.println("На складах есть следующие товары");
        showStock(stock);
        String input = "";
        double countGoods;
        while (true) {
            System.out.println("Напишите что желаете добавить в заказ или нажмите `end` для перехода к доставке");
            Scanner scanner = new Scanner(System.in);
            input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            } else {
                goods = searchObjectByName(stock, input);
            }
            if (goods.getGoodsName() != null) {
                System.out.println("Сколько " + goods.getGoodsName() + " хотите добавить в заказ?");
                Scanner scanner1 = new Scanner(System.in);
                countGoods = scanner1.nextDouble();  //ввели количество
                orderCurrent.put(goods, countGoods);
                System.out.println("У вас в корзине");
                totalSum = showOrder(orderCurrent);
                System.out.println("\nНа складе остались следующие товары");
                double count = stock.get(goods) - countGoods;
                stock.remove(goods);
                stock.put(goods, count);
                showStock(stock);
            } else {
                System.out.println("Такого товара нет на складе магазина");
            }
        }
        Boolean minSumOrderFlag = false;
        int delivery = 0;
        while (minSumOrderFlag == false) {
            System.out.println("\nВыберете способ доставки" +
                    "\n1-Курьер" +
                    "\n2-Почта" +
                    "\n3-DHL" +
                    "\n4-Самовывоз");
            Scanner scanner2 = new Scanner(System.in);
            delivery = scanner2.nextInt();
            if (delivery == 4 || totalSum >= minSumOrder) {
                minSumOrderFlag = true;
            } else {
                System.out.println("Сумма Вашего заказа не достаточна для данного типа доставки, воспользуйтесь самовывозом");
            }
        }
        DeliveryByCash deliveryByCash = new DeliveryByCash();
        DeliveryFree deliveryFree = new DeliveryFree();
        switch (delivery) {
            case 1:
                deliveryByCash.sendCourier(orderCurrent);
                break;
            case 2:
                deliveryByCash.sendPost(orderCurrent);
                break;
            case 3:
                deliveryByCash.sendDHL(orderCurrent);
                break;
            case 4:
                deliveryFree.sendPickup(orderCurrent);
                break;
        }
    }

    private static void showStock(HashMap<Goods, Double> list) {
        for (HashMap.Entry<Goods, Double> item : list.entrySet()) {
            System.out.printf("%s, Доступное количество: %s \n", item.getKey(), item.getValue());
        }
    }

    private static double showOrder(HashMap<Goods, Double> list) {
        double totalSum = 0;
        for (HashMap.Entry<Goods, Double> item : list.entrySet()) {
            System.out.printf("%s, Количество в заказе: %s \n", item.getKey(), item.getValue());
            totalSum += item.getKey().getGoodsPrice() * item.getValue();
        }
        System.out.println("\nОбщая сумма заказа " + totalSum);
        return totalSum;
    }

    private static Goods searchObjectByName(HashMap<Goods, Double> stock, String input) {
        Goods goods = new Goods();
        for (HashMap.Entry<Goods, Double> item : stock.entrySet()) {
            if (item.getKey().getGoodsName().equals(input))
                goods = item.getKey();
        }
        return goods;
    }
}