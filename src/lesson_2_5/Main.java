package lesson_2_5;

import java.util.Arrays;

public class Main {

    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;
    static final int QUARTER = SIZE / 4;

    public static void main(String[] args) {
        float[] arr = new float[SIZE];

        fillArr(arr);
        fillArrSize(arr);

        fillArr(arr);
        fillArrHalf(arr);

        fillArr(arr);
        fillArrQuarter(arr);
    }

    public static void fillArr(float[] arr) {
        Arrays.fill(arr, 1);
    }

    public static void fillArrSize(float[] arr) {
        long startT = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) *
                    Math.cos(0.4f + i / 2));
        }
        long finishT = System.currentTimeMillis();
        System.out.println("1. The operation took " + (finishT - startT) + " ms to complete");
        System.out.println("Quarter position: " + arr[QUARTER]);
        System.out.println("Half position: " + arr[HALF] + "\n");
    }

    public static void fillArrHalf(float[] arr) {
        long startT = System.currentTimeMillis();
        float[] a1 = new float[HALF];
        float[] a2 = new float[HALF];

        System.arraycopy(arr, 0, a1, 0, HALF);
        System.arraycopy(arr, HALF, a2, 0, HALF);

        Thread thread1 = perform(a1, 0);
        Thread thread2 = perform(a2, HALF);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(a1, 0, arr, 0, HALF);
        System.arraycopy(a2, 0, arr, HALF, HALF);
        long finishT = System.currentTimeMillis();

        System.out.println("2. The operation took " + (finishT - startT) + " ms to complete");
        System.out.println("Quarter position: " + arr[QUARTER]);
        System.out.println("Half position: " + arr[HALF] + "\n");
    }

    public static void fillArrQuarter(float[] arr) {
        long startT = System.currentTimeMillis();
        float[] a1 = new float[QUARTER];
        float[] a2 = new float[QUARTER];
        float[] a3 = new float[QUARTER];
        float[] a4 = new float[QUARTER];

        System.arraycopy(arr, 0, a1, 0, QUARTER);
        System.arraycopy(arr, QUARTER, a2, 0, QUARTER);
        System.arraycopy(arr, (QUARTER * 2), a3, 0, QUARTER);
        System.arraycopy(arr, (QUARTER * 3), a4, 0, QUARTER);

        Thread thread1 = perform(a1, 0);
        Thread thread2 = perform(a2, QUARTER);
        Thread thread3 = perform(a3, (QUARTER * 2));
        Thread thread4 = perform(a4, (QUARTER * 3));

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(a1, 0, arr, 0, QUARTER);
        System.arraycopy(a2, 0, arr, QUARTER, QUARTER);
        System.arraycopy(a3, 0, arr, (QUARTER * 2), QUARTER);
        System.arraycopy(a4, 0, arr, (QUARTER * 3), QUARTER);

        long finishT = System.currentTimeMillis();

        System.out.println("3. The operation took " + (finishT - startT) + " ms to complete");
        System.out.println("Quarter position: " + arr[QUARTER]);
        System.out.println("Half position: " + arr[HALF]);
    }

    public static Thread perform(float[] arr, int n) {
        return new Thread(() -> {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = (float) (arr[i] * Math.sin(0.2f + (i + n) / 5) * Math.cos(0.2f + (i + n) / 5) *
                        Math.cos(0.4f + (i + n) / 2));
            }
        });
    }
}
