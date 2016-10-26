import java.util.ArrayList;

/**
 * Created by jason on 10/23/16.
 */
public class Chapter5 {
    static int longestSequence(int n)
    {
        if ( n== -1) {
            return 32;
        }
        ArrayList<Integer> sequences = getAlternatingSequences(n);
//        return findLongestSequence(sequences);
        return 1;
    }

    public static ArrayList<Integer> getAlternatingSequences(int n)
    {
        ArrayList<Integer> sequences = new ArrayList<Integer>();
        int searchingFor = 0;
        int counter = 0;

        for(int i = 0; i < 32; i++)
        {
            if((n&1) != searchingFor)
            {
                sequences.add(counter);
                searchingFor = n & 1;
                counter = 0;
            }
            counter ++;
            n>>>=1;
        }
        sequences.add(counter);
        return sequences;
    }


    public static void main(String[] args)
    {
        longestSequence(1772);
    }
}
