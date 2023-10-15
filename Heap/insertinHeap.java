package Heap;

import java.util.ArrayList;

public class insertinHeap {
    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data) {
            // add data at last index
            arr.add(data);

            int x = arr.size() - 1;
            int parent = (x - 1) / 2;
            while (arr.get(x) < arr.get(parent)) {
                int temp = arr.get(x);
                arr.set(x, arr.get(parent));
                arr.set(parent, temp);
            }
            x=parent;
            parent = (x-1)/2;
        }

        public int peek() {
            return arr.get(0);
        }
    }

    public static void main(String[] args) {

    }
}
