import sun.jvm.hotspot.oops.ArrayKlass;
import sun.jvm.hotspot.oops.IntField;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

/**
 * Created by jason on 9/30/16.
 */
public class Chapter8 {
    public static int countWay(int n)
    {
        if(n < 0)
            return -1;
        if(n < 3)
            return n;
        int[] step = new int[n+1];
        step[1] = 1;
        step[2] = 2;
        step[3] = 4;
        for(int i = 4; i < n+1; i++)
        {
            step[i] = step[i-1]+step[i-2]+step[i-3];
        }
        return step[n];
    }
    static HashSet magicFast(int[] array)
    {
        HashSet<Integer> list = new HashSet<>();
        magicFast(list, array, 0, array.length);
        return list;

    }
    static int magicFast(HashSet list, int[] array, int left, int right)
    {
        if(left > right)
            return -1;
        int mid = (left + right) / 2;
        if(array[mid] == mid)
            return mid;
        int leftValue;
        int rightValue;
        if(array[mid] > mid)
        {
            leftValue = magicFast(list,array, left, mid -1);
            rightValue = magicFast(list,array, array[mid], right);
        }
        else
        {
            leftValue = magicFast(list,array, mid + 1, right);
            rightValue = magicFast(list,array, left, array[mid]);
        }
        if(leftValue != -1)
        {
            list.add(leftValue);
            return leftValue;
        }
        else if(rightValue != -1)
        {
            list.add(rightValue);
            return rightValue;
        }
        else
            return -1;
    }

    static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index)
    {
        ArrayList<ArrayList<Integer>> allsubsets;
        if(set.size() == index)
        {
            allsubsets = new ArrayList<ArrayList<Integer>>();
            allsubsets.add(new ArrayList<>());
        }
        else
        {
            allsubsets = getSubsets(set, index+1);
            int item = set.get(index);
            ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>();
            for(ArrayList<Integer> subset : allsubsets)
            {
                ArrayList<Integer> newsubset = new ArrayList<Integer>();
                newsubset.addAll(subset);
                newsubset.add(item);
                moresubsets.add(newsubset);
            }
            allsubsets.addAll(moresubsets);
        }
        return allsubsets;
    }
    static int multiply(int sum, int a, int b)
    {
        if(b == 0)
            return sum;
        return multiply(sum+a,a,--b);
    }

    class Tower
    {
        private Stack<Integer> disks;
        private int index;
        public Tower(int i)
        {
            disks = new Stack<Integer>();
            index = i;
        }

        public int index()
        {
            return index;
        }

        public void add(int d)
        {
            if(!disks.isEmpty() && disks.peek() <= d)
            {
                System.out.println("Error placing disk");
            }
            else
            {
                disks.push(d);
            }
        }
        public void moveTopTo(Tower t)
        {
            int top = disks.pop();
            t.add(top);
        }

        public void moveDisks(int n, Tower destination, Tower buffer)
        {
            if(n > 0)
            {
                moveDisks(n-1, buffer, destination);
                moveTopTo(destination);
                moveDisks(n-1,destination,this);
            }
        }
    }

//    public static ArrayList<String> getPerm(String str)
//    {
//        if(str == null)
//            return null;
//        ArrayList<String> permutations = new ArrayList<String>();
//        if(str.length() == 0)
//        {
//            permutations.add("");
//            return permutations;
//        }
//        char first = str.charAt(0);
//        String remainder = str.substring(1);
//        ArrayList<String> words = getPerm(remainder);
//        for(String word : words)
//        {
//            for(int j = 0; j <= word.length();j++)
//            {
//                String s = insertCharAt(word, first,j);
//                permutations.add(s);
//            }
//        }
//        return permutations;
//    }
//
//    static String insertCharAt(String word, char c, int i)
//    {
//        String start = word.substring(0,i);
//        String end = word.substring(i);
//        return start+c+end;
//    }
    public static ArrayList<String> getPerm(String remainder)
    {
        int len = remainder.length();
        ArrayList<String> result = new ArrayList<String>();
        if(len == 0)
        {
            result.add("");
            return result;
        }

        for(int i = 0; i < len; i++)
        {
            String before = remainder.substring(0,i);
            String after = remainder.substring(i+1, len);
            ArrayList<String> partials = getPerm(before+after);
            for(String s : partials)
            {
                result.add(remainder.charAt(i) + s);
            }
        }
        return result;
    }
//    static int makeChange(int amount, int[] denoms, int index) {
//        if(amount == 0)
//            return 1;
//        if(amount < 0)
//            return -1;
//        int res = 0;
//        for(int i = 0; i < denoms.length; i++)
//        {
//            int remain = amount - denoms[i];
//            int way = makeChange(remain,denoms, index+1);
//            if(way != -1)
//                res += way;
//        }
//        return res;
//    }

    static int makeChange(int amount, int[] denoms, int index)
    {
        if(index >= denoms.length-1)
            return 1;
        int way = 0;
        int denomAmount = denoms[index];
        for(int i = 0; denomAmount * i <= amount; i++)
        {
            int remain = amount- denomAmount * i;
            way += makeChange(remain, denoms, index+1);
        }
        return way;
    }



    public static void main(String[] args)
    {
        int[] denoms = {5,2,1};
        System.out.println(makeChange(5, denoms, 0));

    }
}
