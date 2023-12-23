import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class SoldManager {

    private TreeMap<SoldGood, Integer> map;

    public SoldManager() {
        map = new TreeMap<>(Comparator.comparing(o -> o.name));
    }

    public void addSoldGood(SoldGood soldGood) {
        if (map.containsKey(soldGood)) {
            map.put(soldGood, map.get(soldGood) + 1);
        } else {
            map.put(soldGood, 1);
        }
    }

    public void listSoldGoods() {
        for (Map.Entry<SoldGood, Integer> entry : map.entrySet()) {
            System.out.println("Товар: " + entry.getKey().getName() + " был продан " + entry.getValue() + " раз(а).");
        }
    }

    public void salesAmount() {
        double sum = 0;
        for (Map.Entry<SoldGood, Integer> entry : map.entrySet()) {
            sum += entry.getKey().getPrice() * entry.getValue();
        }
        System.out.println("Общая сумма продаж составляет " + sum);
    }

    public void popularGood() {
        int maxSales = 0;
        String good = "";
        for (Map.Entry<SoldGood, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxSales) {
                maxSales = entry.getValue();
                good = entry.getKey().getName();
            }
        }
        System.out.println("Самый часто покупаемый товар - " + good + ". Его купили " + maxSales + " раз(а).");
    }

    public static void main(String[] args) {
        SoldManager soldManager = new SoldManager();

        soldManager.addSoldGood(new SoldGood("Товар 1",  17.0));
        soldManager.addSoldGood(new SoldGood("Товар 2",  12.5));
        soldManager.addSoldGood(new SoldGood("Товар 3",  19.7));
        soldManager.addSoldGood(new SoldGood("Товар 1",  17.0));
        soldManager.addSoldGood(new SoldGood("Товар 4",  23.4));

        soldManager.listSoldGoods();

        soldManager.salesAmount();

        soldManager.popularGood();
    }
}
