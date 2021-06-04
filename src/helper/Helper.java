package helper;

import java.util.Arrays;
import java.util.List;

public class Helper {
    public static int[] convert(final List<Integer> list)
    {
        final int[] out = new int[list.size()];
        Arrays.setAll(out, list::get);
        return out;
    }
}
