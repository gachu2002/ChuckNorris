import java.util.Arrays;

import static java.util.Arrays.*;
class Counter {

    int current;
    int[] test = {0,1,2,3,4};
    // write your methods here
    void inc() {
        this.current++;
        Arrays.sort(test);
        sort(test);
    }

    int getCurrent() {
        return this.current;
    }
}