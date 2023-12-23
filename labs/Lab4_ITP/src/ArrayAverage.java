public class ArrayAverage {
    public static void main(String[] args) {
        String[] arr = {"1", "2", "3", "4", "5"};
        int sum = 0;

        try {
            for (int i = 0; i <= arr.length; i++) {
                sum += Integer.parseInt(arr[i]);
            }
            System.out.println(sum / arr.length);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Вы вышли за границы массива");
        } catch (NumberFormatException e) {
            System.out.println("В массиве присутствуют неверные данные");
        }
    }
}
