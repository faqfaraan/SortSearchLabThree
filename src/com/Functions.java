package com;

public class Functions {

    public static int[] mergeSort(int[] input) {
       return mergeSortBody(input, 0, input.length);
    }

    public static int[] mergeSortBody(int[] input, int start, int end) {

        if (end - start < 2) {
            return input;
        }

        int mid = (start + end) / 2;
        mergeSortBody(input, start, mid);
        mergeSortBody(input, mid, end);
        return merge(input, start, mid, end);

    }

    public static int[] merge(int[] input, int start, int mid, int end) {

        if (input[mid - 1] <= input[mid]) {
            return input;
        }

        int i = start;
        int j = mid;
        int tempIndex = 0;

        int[] temp = new int[end - start];
        while (i < mid && j < end) {
            temp[tempIndex++] = input[i] <= input[j] ? input[i++] : input[j++];
        }

        System.arraycopy(input, i, input, start + tempIndex, mid - i);
        System.arraycopy(temp, 0, input, start, tempIndex);

        return input;
    }

    public static int rBinarySearch(int[] data, int key){
        return rBinarySearchBody(data, 0, data.length, key);
    }

    public static int rBinarySearchBody(int[] input, int start, int end, int key) {
        if (start >= end) {
            return -1;
        }

        int mid = (start + end) / 2;

        if (input[mid] == key) {
            return mid;
        }
        else if (input[mid] < key) {
            return rBinarySearchBody(input, mid + 1, end, key);
        }
        else {
            return rBinarySearchBody(input, start, mid, key);
        }
    }

    public static int iBinarySearch(int[] data, int key){
        int start = 0;
        int end = data.length;

        while (start < end) {
            int mid = (start + end) / 2;
            if (data[mid] == key) {
                return mid;
            }
            else if (data[mid] < key) {
                start = mid + 1;
            }
            else {
                end = mid;
            }
        }
        return -1;
    }
}
