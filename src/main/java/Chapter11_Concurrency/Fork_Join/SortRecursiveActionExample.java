package Chapter11_Concurrency.Fork_Join;

import java.util.Arrays;
import java.util.concurrent.RecursiveAction;

public class SortRecursiveActionExample extends RecursiveAction {
    private static final int THRESHOLD = 1000;
    private int[] data;
    private int start;
    private int end;

    public SortRecursiveActionExample(int[] data, int start, int end) {
        this.data = data;
        this.start = start;
        this.end = end;
    }
    @Override
    protected void compute() {
        if(end - start <= THRESHOLD) {
            Arrays.sort(data, start, end);
        } else {
            int halfWay = ((end - start) / 2) + start;
            SortRecursiveActionExample a1 = new SortRecursiveActionExample(data, start, halfWay);
            SortRecursiveActionExample a2 = new SortRecursiveActionExample(data, halfWay, end);
            invokeAll(a1, a2);      // shortcut for fork() and join()
            if (data[halfWay-1] <= data[halfWay]) {
                return;     // already sorted
            }
            // merging of sorted subsections begins here
            int[] temp = new int[end - start];
            int s1 = start, s2 = halfWay, d = 0;
            while(s1 < halfWay && s2 < end) {
                if (data[s1] < data[s2]) {
                    temp[d++] = data[s1++];
                } else if (data[s1] > data[s2]) {
                    temp[d++] = data[s2++];
                } else {
                    temp[d++] = data[s1++];
                    temp[d++] = data[s2++];
                }
            }
            if(s1 != halfWay) {
                System.arraycopy(data, s1, temp, d, temp.length - d);
            } else if (s2 != end) {
                System.arraycopy(data, s2, temp, d, temp.length - d);
            }
            System.arraycopy(temp, 0, data, start, temp.length);
        }
    }
}
