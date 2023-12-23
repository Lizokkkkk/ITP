import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MaxElementFinder {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int rows = matrix.length;

        ExecutorService executorService = Executors.newFixedThreadPool(rows);

        Future<Integer>[] maxElements = new Future[rows];

        for (int i = 0; i < rows; i++) {
            maxElements[i] = executorService.submit(new MaxElement(matrix[i]));
        }

        executorService.shutdown();

        int maxElem = 0;
        for (int i = 0; i < maxElements.length; i++) {
            try {
                if (maxElements[i].get() > maxElem) {
                    maxElem = maxElements[i].get();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println("Наибольший элемент матрицы: " + maxElem);
    }
}

class MaxElement implements Callable<Integer> {
    private final int[] array;

    public MaxElement(int[] array) {
        this.array = array;
    }

    @Override
    public Integer call() throws Exception {
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
}