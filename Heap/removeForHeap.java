package Heap;

import java.util.ArrayList;



public class removeForHeap {
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

                x=parent;
                parent = (x-1)/2;
                
            }
        }

        public int peek() {
            return arr.get(0);
        }

        private void heapify(int idx) {
            int left = 2 * idx + 1;
            int right = 2 * idx + 2;
            int minIdx = idx;

            if (left < arr.size() && arr.get(minIdx) > arr.get(left)) {
                minIdx = left;
            }

            if (right < arr.size() && arr.get(minIdx) > arr.get(right)) {
                minIdx = right;
            }
            if (minIdx != idx) {
                //
                int temp = arr.get(idx);
                arr.set(idx, arr.get(minIdx));
                arr.set(minIdx, temp);
                heapify(minIdx);
            }

        }

        public int remove() {
            int data = arr.get(0);

            // step 1 swap last & first element 
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size() - 1));
            arr.set(arr.size() - 1, temp);

            // step 2 delet last
            arr.remove(arr.size() - 1);

            // step 3
            heapify(0);
            return data;
        }
        public boolean isEmpty(){
            return arr.size() == 0;
        }

        public static void main(String[] args) {
                    Heap h = new Heap();
                    h.add(3);
                    h.add(4);
                    h.add(1);
                    h.add(5);

                    while(!h.isEmpty()){
                        System.out.println(h.peek());
                        h.remove();
                    }
        }
    }
}