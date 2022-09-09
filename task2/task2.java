import java.util.Arrays;

class task2 {
    public static void main(String[] args) {
        int[] arr = new int[args.length];
        for (int i = 0; i< arr.length; i++) {
            arr[i] = Integer.parseInt(args[i]);
        }

        int runs = 0;

        boolean flag = arr.length == 0? true : false;

        int sum = Arrays.stream(arr).sum();

        int mid = 0;
        if (arr.length == 0) {
            System.out.println(0);
        }
        else if (arr.length % 2 == 1) {
            mid = (int) findMedian(arr);
        } else {

            mid = sum / arr.length;
        }

        while (!flag) {
            for (int j = 0; j < arr.length; j++) {
                
                if (arr[j] != mid) {

                    arr[j] = arr[j] < mid ? arr[j] + 1 : arr[j] - 1;
                    runs++;
                }
            }
            flag = allEqual(arr, mid);
        }
        System.out.println(runs);
    }

    public static boolean allEqual(int[] array, int middle) {
        if (array == null || array.length == 0) {
            return true;
        }
        for (int e : array) {
            if (e != middle) {
                return false;
            }
        }
        return true;
    }

    public static double findMedian(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int[] copy = array.clone();
        Arrays.sort(copy);
        if (copy.length % 2 == 0) {
            return ((copy[copy.length / 2] + copy[copy.length / 2 - 1]) / 2f);
        }
        return copy[copy.length / 2];
    }
}
