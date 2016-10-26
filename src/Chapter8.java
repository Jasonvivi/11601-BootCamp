import java.util.*;

/**
 * Created by jason on 9/30/16.
 */
public class Chapter8 {
//    public static int countWay(int n)
//    {
//        if(n < 0)
//            return -1;
//        if(n < 3)
//            return n;
//        int[] step = new int[n+1];
//        step[1] = 1;
//        step[2] = 2;
//        step[3] = 4;
//        for(int i = 4; i < n+1; i++)
//        {
//            step[i] = step[i-1]+step[i-2]+step[i-3];
//        }
//        return step[n];
//    }
//    static HashSet magicFast(int[] array)
//    {
//        HashSet<Integer> list = new HashSet<>();
//        magicFast(list, array, 0, array.length);
//        return list;
//
//    }
//    static int magicFast(HashSet list, int[] array, int left, int right)
//    {
//        if(left > right)
//            return -1;
//        int mid = (left + right) / 2;
//        if(array[mid] == mid)
//            return mid;
//        int leftValue;
//        int rightValue;
//        if(array[mid] > mid)
//        {
//            leftValue = magicFast(list,array, left, mid -1);
//            rightValue = magicFast(list,array, array[mid], right);
//        }
//        else
//        {
//            leftValue = magicFast(list,array, mid + 1, right);
//            rightValue = magicFast(list,array, left, array[mid]);
//        }
//        if(leftValue != -1)
//        {
//            list.add(leftValue);
//            return leftValue;
//        }
//        else if(rightValue != -1)
//        {
//            list.add(rightValue);
//            return rightValue;
//        }
//        else
//            return -1;
//    }
//
//    static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index)
//    {
//        ArrayList<ArrayList<Integer>> allsubsets;
//        if(set.size() == index)
//        {
//            allsubsets = new ArrayList<ArrayList<Integer>>();
//            allsubsets.add(new ArrayList<>());
//        }
//        else
//        {
//            allsubsets = getSubsets(set, index+1);
//            int item = set.get(index);
//            ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>();
//            for(ArrayList<Integer> subset : allsubsets)
//            {
//                ArrayList<Integer> newsubset = new ArrayList<Integer>();
//                newsubset.addAll(subset);
//                newsubset.add(item);
//                moresubsets.add(newsubset);
//            }
//            allsubsets.addAll(moresubsets);
//        }
//        return allsubsets;
//    }
//    static int multiply(int sum, int a, int b)
//    {
//        if(b == 0)
//            return sum;
//        return multiply(sum+a,a,--b);
//    }
//
//    class Tower
//    {
//        private Stack<Integer> disks;
//        private int index;
//        public Tower(int i)
//        {
//            disks = new Stack<Integer>();
//            index = i;
//        }
//
//        public int index()
//        {
//            return index;
//        }
//
//        public void add(int d)
//        {
//            if(!disks.isEmpty() && disks.peek() <= d)
//            {
//                System.out.println("Error placing disk");
//            }
//            else
//            {
//                disks.push(d);
//            }
//        }
//        public void moveTopTo(Tower t)
//        {
//            int top = disks.pop();
//            t.add(top);
//        }
//
//        public void moveDisks(int n, Tower destination, Tower buffer)
//        {
//            if(n > 0)
//            {
//                moveDisks(n-1, buffer, destination);
//                moveTopTo(destination);
//                moveDisks(n-1,destination,this);
//            }
//        }
//    }
//
////    public static ArrayList<String> getPerm(String str)
////    {
////        if(str == null)
////            return null;
////        ArrayList<String> permutations = new ArrayList<String>();
////        if(str.length() == 0)
////        {
////            permutations.add("");
////            return permutations;
////        }
////        char first = str.charAt(0);
////        String remainder = str.substring(1);
////        ArrayList<String> words = getPerm(remainder);
////        for(String word : words)
////        {
////            for(int j = 0; j <= word.length();j++)
////            {
////                String s = insertCharAt(word, first,j);
////                permutations.add(s);
////            }
////        }
////        return permutations;
////    }
////
////    static String insertCharAt(String word, char c, int i)
////    {
////        String start = word.substring(0,i);
////        String end = word.substring(i);
////        return start+c+end;
////    }
//    public static ArrayList<String> getPerm(String remainder)
//    {
//        int len = remainder.length();
//        ArrayList<String> result = new ArrayList<String>();
//        if(len == 0)
//        {
//            result.add("");
//            return result;
//        }
//
//        for(int i = 0; i < len; i++)
//        {
//            String before = remainder.substring(0,i);
//            String after = remainder.substring(i+1, len);
//            ArrayList<String> partials = getPerm(before+after);
//            for(String s : partials)
//            {
//                result.add(remainder.charAt(i) + s);
//            }
//        }
//        return result;
//    }
////    static int makeChange(int amount, int[] denoms, int index) {
////        if(amount == 0)
////            return 1;
////        if(amount < 0)
////            return -1;
////        int res = 0;
////        for(int i = 0; i < denoms.length; i++)
////        {
////            int remain = amount - denoms[i];
////            int way = makeChange(remain,denoms, index+1);
////            if(way != -1)
////                res += way;
////        }
////        return res;
////    }
//
//    static int makeChange(int amount, int[] denoms, int index)
//    {
//        if(index >= denoms.length-1)
//            return 1;
//        int way = 0;
//        int denomAmount = denoms[index];
//        for(int i = 0; denomAmount * i <= amount; i++)
//        {
//            int remain = amount- denomAmount * i;
//            way += makeChange(remain, denoms, index+1);
//        }
//        return way;
//    }
//    static int GRID_SIZE = 8;
//    static void placeQueen(int row, Integer[] columns, ArrayList<Integer[]> result)
//    {
//        if(row == GRID_SIZE)
//        {
//            result.add(columns.clone());
//        }
//        else
//        {
//            for(int col = 0; col < GRID_SIZE; col++)
//            {
//                if(check(col, columns, row))
//                {
//                    columns[row] = col;
//                    placeQueen(row + 1, columns, result);
//                }
//            }
//        }
//    }
//

//    int createStack(ArrayList<Box> boxes) {
//        Collections.sort(boxes, new BoxComparator<Box>());
//       int[] stackMap = new int[boxes.size()];
//        return createStack(boxes, null, 0, stackMap);
//    }
//
//    int createStack(ArrayList<Box> boxes, Box bottom, int offset, int[] stackMap)
//    {
//        if(offset >= boxes.size())
//            return 0;
//
//        Box newBottom = boxes.get(offset);
//        int heightWithBottom = 0;
//        if(bottom == null || newBottom.canBeAbove(bottom))
//        {
//            if(stackMap[offset] == 0)
//            {
//                stackMap[offset] = createStack(boxes, newBottom, offset + 1, stackMap);
//                stackMap[offset] += newBottom.height;
//            }
//            heightWithBottom = stackMap[offset];
//        }
//
//        int heightWithoutBottom = createStack(boxes, bottom, offset+1,stackMap);
//        return Math.max(heightWithBottom, heightWithoutBottom);
//    }
//
//    class BoxComparator implements Comparator<Box>
//    {
//        @Override
//        public int compara(Box x, Box y)
//        {
//            return y.height - x.height;
//        }
//    }
//
//    Set<String> generateParens(int remaining)
//    {
//        Set<String> set = new HashSet<>();
//        if(remaining == 0)
//            set.add("");
//        else
//        {
//            Set<String> prevSet = generateParens(remaining - 1);
//            for(String str : prevSet)
//            {
//                for(int i = 0; i < str.length(); i++)
//                {
//                    if(str.charAt(i) == '(');
//                    {
//                        String s = InsertInside(str, i);
//                        set.add(s);
//                    }
//                }
//                set.add("()" + str);
//            }
//        }
//        return set;
//    }
//    static boolean check(int col, Integer[] columns, int row)
//    {
//        for(int  row1 = 0;  row1 < row; row1 ++)
//        {
//            int column2 = columns[row1];
//            if(column2 != col)
//                return false;
//            int colDistance = Math.abs(columns[row] - col);
//            int rowDistance = row - row1;
//            if(colDistance == rowDistance)
//                return false;
//        }
//        return true;
//    }

    public static ArrayList<String> permutations(String s)
    {
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        ArrayList<String> result = new ArrayList<String>();
        StringBuilder sb = new StringBuilder(String.valueOf(charArray));
        addToList(result,sb,"");
        return result;
    }
    public static void addToList(ArrayList list, StringBuilder sb, String str)
    {
        if(sb.length() == 0)
        {
            list.add(str);
        }
        for(int i = 0; i < sb.length(); i++)
        {
            char c = sb.charAt(i);
            if(i > 0 && sb.charAt(i) == sb.charAt(i-1))
                continue;
            sb.deleteCharAt(i);
            addToList(list, sb, str+c);
            sb.insert(i,c);
        }
    }

//    public static ArrayList<ArrayList<Integer>> permutation(int[] nums)
//    {
//        Arrays.sort(nums);
//        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
//        ArrayList<Integer> array = new ArrayList<Integer>();
//        for(int i = 0; i < nums.length; i++)
//        {
//            array.add(nums[i]);
//        }
//        addToList(result, array, nums);
//        return result;
//    }
    public static void addToList(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> array, ArrayList<Integer> nums)
    {
        if(array.size() == 0)
        {
            result.add(new ArrayList<>(nums));
        }
        for(int i = 0; i < array.size(); i++)
        {
            int tmp = array.get(i);
            nums.add(array.get(i));
            array.remove(i);
            addToList(result,array,nums);
            nums.remove(nums.size() - 1);
            array.add(i,tmp);
        }
    }
//    public static ArrayList<ArrayList<Integer>> permutation2(ArrayList<String> nums)
//    {
//        Arrays.sort(nums);
//        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
//        ArrayList<Integer> array = new ArrayList<Integer>();
//        boolean[] isUsed = new boolean[nums.length];
//        perm(result, array, nums, isUsed);
//        return result;
//    }
//
//    public static void perm(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> array, int[] nums, boolean[] isUsed)
//    {
//        if(array.size() == nums.length)
//            result.add(new ArrayList<>(array));
//        for(int i = 0; i < nums.length; i++)
//        {
//            if(isUsed[i]==true|| i>0 && nums[i] == nums[i-1])
//                continue;
//            isUsed[i] = true;
//            array.add(nums[i]);
//            perm(result, array, nums, isUsed);
//            array.remove(array.size() - 1);
//            isUsed[i] = false;
//        }
//    }

    public static ArrayList<String> parens(int num)
    {
        ArrayList<String> result = new ArrayList<String>();
        ArrayList<String> array = new ArrayList<String>();
        array.add("()");
        char[] str = new char[num*2];
        parenHelper(result,num ,num, str, 0);
        return result;
    }
    public static void parenhelper(ArrayList<String> result, ArrayList<String> tmpArray, int num, int index)
    {
        ArrayList<String> newtmp = new ArrayList<String>();
        if(index == num)
        {
            result.addAll(tmpArray);
            return;
        }
        for(String str: tmpArray)
        {
            for(int i = 0; i < str.length();i++)
            {
                if(str.charAt(i) == '(')
                {
                   String s = insertParen(i,str);
                    newtmp.add(s);
                }
            }
            newtmp.add("()"+str);
        }

        parenhelper(result,newtmp,num,index+1);
    }
    public static void parenHelper(ArrayList<String> result, int leftNum, int rightNum, char[] str, int index)
    {
        if(leftNum < 0 || leftNum > rightNum)
            return;
        if(leftNum == 0 && rightNum == 0)
        {
            result.add(new String(str));
            return;
        }
        str[index] = '(';
        parenHelper(result,leftNum-1,rightNum,str,index+1);
        str[index]= ')';
        parenHelper(result,leftNum,rightNum-1,str,index+1);
    }



    public static String insertParen(int index, String str)
    {
        StringBuilder sb = new StringBuilder(str);
        sb.insert(index+1,"()");
        return sb.toString();
    }

    enum Color{red, green, blue}
    public static void paintFill(Color[][] picture, int r, int c, Color color, Color prev)
    {
        if(!isBoundary(picture, r, c)  || picture[r][c] != prev)
            return;
        picture[r][c] = prev;
        paintFill(picture,r+1,c,color,prev);
        paintFill(picture,r,c+1,color,prev);
        paintFill(picture,r-1,c,color,prev);
        paintFill(picture,r,c-1,color,prev);
    }

    static boolean isBoundary(Color[][] picture, int r,int c)
    {
        if(c < 0 || r < 0 || r >= picture.length || c >= picture[0].length)
            return false;
        return true;
    }

    static int makeChange(int num)
    {
        int[] money = {3,2,1};
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        return makeChange(num, money,0, map);
    }
    static int makeChange(int amount, int[] money, int index,HashMap<Integer,Integer> map)
    {
        if(map.containsKey(amount))
            return map.get(amount);
        if(index == money.length -1)
            return 1;
        int sum = 0;
        for(int i = 0 ; i*money[index] <= amount; i++)
        {
            int remain = amount -i*money[index];
            sum += makeChange(remain,money,index+1,map);
        }
        map.put(amount,sum);
        return sum;
    }

    int GRID_SIZE = 8;
    void placeQueen(int row, Integer[] columns,ArrayList<Integer[]> result)
    {
        if(row > GRID_SIZE)
            return;
        if(row == GRID_SIZE)
            result.add(columns.clone());
        for(int col = 0; col < GRID_SIZE; col++)
        {
            if(check(col, row, columns))
            {
                columns[row] = col;
                placeQueen(row + 1,columns,result);
            }
        }
    }
    boolean check(int col, int row, Integer[] columns)
    {
        for(int row1 = 0; row1 < row; row1++)
        {
            if(columns[row1] == col)
                return false;
            int rowdiff= row-row1;
            int coldiff = Math.abs(col-columns[row1]);
            if(rowdiff == coldiff)
                return false;
        }
        return true;
    }

    class Box
    {
        int height;
        int width;
        int depth;
    }

    int createStack(ArrayList<Box> boxes, int index, HashMap<Integer,Integer> map, Box bottom)
    {
        if(index >= boxes.size())
        {
            return 0;
        }
        Box newBottom = boxes.get(index);
        int heightWithBottom = 0;
        if(bottom == null || canAbove(newBottom,bottom))
        {
            if(!map.containsKey(index))
            {
                int height = createStack(boxes, index+1,map,newBottom);
                height+=newBottom.height;
                map.put(index, height);
            }
            heightWithBottom = map.get(index);
        }
        int heightWithoutBottom = createStack(boxes, index+1, map, bottom);
        return Math.max(heightWithBottom,heightWithoutBottom);

    }
    static boolean canAbove(Box cur, Box prev)
    {
        if(cur.height > prev.height && cur.width > prev.width && cur.depth > prev.depth)
            return true;
        return false;
    }

    class TeslaVehicle {
        public String getModelName() {
            return "";
        }
    }
    class ModelP85 extends TeslaVehicle{
        public String getModelName()
        {
            return "model85";
        }
    }
    class ModelX extends TeslaVehicle{
        public String getModelName()
        {
            return "modelx";
        }
    }
    TeslaVehicle[] getTesla(int cars, int suvs)
    {
        TeslaVehicle[] t= new TeslaVehicle[cars+suvs];
        for(int i = 0; i < cars;i++)
        {
            ModelP85 m = new ModelP85();
            t[i] = m;
        }
        for(int j = cars; j < cars+suvs; j++)
        {
            ModelX m = new ModelX();
            t[j] = m;
        }
        return t;
    }
//    int countEval(String s, boolean result, HashMap<String, Integer> memo)
//    {
//        if(s.length() == 0)
//            return 0;
//        if(s.length() == 1)
//            return stringToBool(s) == result? 1:0;
//        if(memo.containsKey(result+s))
//            return memo.get(result+s);
//        int ways = 0;
//        for(int i = 1; i < s.length(); i+=2)
//        {
//            char c = s.charAt(i);
//            String left = s.substring(0,i);
//            String right = s.substring(i+1,s.length());
//
//        }
//
//    }
    int minProduct(int a, int b)
    {
        int bigger = a < b? b:a;
        int smaller = a < b? a:b;
        return minProductHelper(smaller, bigger);
    }
    int minProductHelper(int smaller, int bigger)
    {
        if(smaller == 0)
            return 0;
        else if(smaller == 1)
            return bigger;

        int s = smaller >> 1;
        int side1 = minProduct(s,bigger);
        int side2 = side1;
        if(smaller %2 == 1)
            side2 = minProductHelper(smaller - s, bigger);
        return side1 + side2;
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

    }
    static int maximum_XOR(int a, int b) {
        int sum = 0;
        for(int i = a; i< b; i++)
            for(int j =a;j<b;j++)
            {
                int num = i ^ j;
                if(num > sum)
                    sum = num;
            }

        return sum;

    }

    public static void main(String[] args)
    {
        System.out.println(10^15);
    }
}
