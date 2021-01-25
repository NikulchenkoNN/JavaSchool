package HomeWork10;


import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class FIleReadToListTest {
    @Test
    public void testReader() throws IOException {
        FIleReadToList d = new FIleReadToList();
        List<Integer> list = d.readToList("E:\\Proj.txt");
        for (Integer integer : list) {
            ThreadClass threadClass = new ThreadClass(integer);
            threadClass.run();
            System.out.println();
        }
    }


}