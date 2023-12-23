import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class GoodsTransporter {
    public static AtomicInteger totalWeight = new AtomicInteger(0);
    public static final int maxWeight = 150;

    public static void main(String[] args) {

        Warehouse warehouse1 = new Warehouse();
        Warehouse warehouse2 = new Warehouse();

        warehouse1.addGood(new Good("Товар 1", 160));
        warehouse1.addGood(new Good("Товар 2", 50));
        warehouse1.addGood(new Good("Товар 3", 75));
        warehouse1.addGood(new Good("Товар 4", 40));
        warehouse1.addGood(new Good("Товар 5", 80));
        warehouse1.addGood(new Good("Товар 6", 60));
        warehouse1.addGood(new Good("Товар 7", 15));
        warehouse1.addGood(new Good("Товар 8", 150));
        warehouse1.addGood(new Good("Товар 9", 45));

        List<Good> goodsToMove = new ArrayList<Good>();
        for (Good good : warehouse1.getGoods()) {
            if (good.getWeight() <= maxWeight) {
                goodsToMove.add(good);
            }
        }

        while (!goodsToMove.isEmpty()) {
            ForkJoinPool forkJoinPool = new ForkJoinPool(3);
            List<Future<?>> futures = new ArrayList<>();

            for (Good good : goodsToMove) {
                if (totalWeight.get() >= 150) {
                    break;
                }
                futures.add(forkJoinPool.submit(new Transportation(goodsToMove, warehouse1, warehouse2, good)));
            }

            for (Future<?> future : futures) {
                try {
                    future.get();
                } catch (Exception e) {
                    System.out.println("Error: " + e);
                }
            }

            forkJoinPool.shutdown();
            System.out.println("Общий вес перенесенных товаров: " + totalWeight.get() + " кг");
            totalWeight = new AtomicInteger(0);
        }
    }
}

class Good {
    private String name;
    private int weight;

    public Good(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }
}

class Warehouse {
    private List<Good> goods;

    public Warehouse() {
        this.goods = new ArrayList<>();
    }

    public void addGood(Good good) {
        goods.add(good);
    }

    public List<Good> getGoods() {
        return goods;
    }

    public void removeGood(Good good) {
        this.goods.remove(good);
    }
}

class Transportation implements Runnable {
    private List<Good> goodsToMove;
    private Warehouse warehouse1;
    private Warehouse warehouse2;
    private Good good;

    public Transportation(List<Good> goodsToMove, Warehouse warehouse1, Warehouse warehouse2, Good good) {
        this.goodsToMove = goodsToMove;
        this.warehouse1 = warehouse1;
        this.warehouse2 = warehouse2;
        this.good = good;
    }

    @Override
    public void run() {
        if (GoodsTransporter.totalWeight.addAndGet(good.getWeight()) <= GoodsTransporter.maxWeight) {
            warehouse2.addGood(good);
            warehouse1.removeGood(good);
            goodsToMove.remove(good);
            System.out.println("Перенос " + good.getName() + " весом: " + good.getWeight() + " кг");
        } else {
            GoodsTransporter.totalWeight.addAndGet(-good.getWeight());
        }
    }
}