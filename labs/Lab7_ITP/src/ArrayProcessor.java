import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ArrayProcessor {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        int numThreads = 2;

        int chunkSize = array.length / numThreads;

        ExecutorService executorService = Executors.newFixedThreadPool(numThreads);

        Future<Integer>[] results = new Future[numThreads];

        for (int i = 0; i < numThreads; i++) {
            int startIndex = i * chunkSize;
            int endIndex;
            if (i == numThreads - 1) {
                endIndex = array.length;
            } else {
                endIndex =  startIndex + chunkSize;
            }

            results[i] = executorService.submit(new ArraySum(array, startIndex, endIndex));
        }

        executorService.shutdown();

        int totalSum = 0;
        for (int i = 0; i < numThreads; i++) {
            try {
                totalSum += results[i].get();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println("Общая сумма: " + totalSum);
    }
}

class ArraySum implements Callable<Integer> {
    private final int[] array;
    private final int startIndex;
    private final int endIndex;

    public ArraySum(int[] array, int startIndex, int endIndex) {
        this.array = array;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = startIndex; i < endIndex; i++) {
            sum += array[i];
        }
        return sum;
    }
}
