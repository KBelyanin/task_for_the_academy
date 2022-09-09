import java.util.Arrays;

class task2 {
    public static void main(String[] args) {
        int[] arr = new int[args.length];
        for (int i = 0; i< arr.length; i++) {
            arr[i] = Integer.parseInt(args[i]);
        }

        int runs = 0; // счётчик для решения
        // флаг для запуска и остановки цикла, является защитой циклов от деления на ноль
        boolean flag = arr.length == 0? true : false;

        int sum = Arrays.stream(arr).sum(); // сумма элементов

        int mid = 0; // искомое для приведения число
        if (arr.length == 0) {
            System.out.println(0);
        }
        else if (arr.length % 2 == 1) { // если массив нечётный, придётся искать медиану.
            mid = (int) findMedian(arr);
        } else { // если чётный - среднее арифметическое
            // в чётном массиве не имеет значение в какую сторону будет округление, потому просто вниз через int.
            mid = sum / arr.length;
        }

        while (!flag) {
            for (int j = 0; j < arr.length; j++) { //проход по списку с изменением объектов
                // если число равно, действия не будет, счётчик не увеличивается, ибо он в теле цикла.
                if (arr[j] != mid) {
                    // увеличение/уменьшение числа
                    arr[j] = arr[j] < mid ? arr[j] + 1 : arr[j] - 1;
                    runs++; // увеличение счётчика
                }
            }
            flag = allEqual(arr, mid); // флаг выхода из цикла
        }
        System.out.println(runs); // вывод результата
    }

    public static boolean allEqual(int[] array, int middle) {
        if (array == null || array.length == 0) {
            return true; // защита от пустого массива
        }
        for (int e : array) {
            if (e != middle) {
                return false; // хотя бы один элемент не равен
            }
        }
        return true; // все элементы равны
    }

    public static double findMedian(int[] array) {
        if (array == null || array.length == 0) {
            return 0; // защита от пустого массива
        }
        int[] copy = array.clone(); // массив для сортировки
        Arrays.sort(copy);
        if (copy.length % 2 == 0) {
            return ((copy[copy.length / 2] + copy[copy.length / 2 - 1]) / 2f);
        }
        return copy[copy.length / 2]; // вывод медианы
    }
}
