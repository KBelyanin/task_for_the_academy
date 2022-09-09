class task1 {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int mm = Integer.parseInt(args[1]);
        int m = mm%n == 0 ? n : mm%n;


        int[] arr = new int[n];
        for (int i = 1; i <= arr.length; i++) {
            arr[i-1] = i;
        }


        int lastDigit = 0;
        int i = 0;
        while (lastDigit != 1) {
            System.out.print(arr[i]);

            i = (i+m<=arr.length) ? (i+m-1) : (i+m-n-1);
            lastDigit = arr[i];
        }
    }
}
