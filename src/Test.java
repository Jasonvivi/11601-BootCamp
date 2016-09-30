import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by jason on 9/26/16.
 */
public class Test {
   public static int  binarySearch(int[] arr, int key)
   {
       int res = helper1(arr,0,arr.length -1 );
       return res;
   }
   public static int helper(int[] array, int key, int left, int right)
   {
       while(left <= right)
       {
           int mid = (left + right) / 2;
           if(array[mid] == key)
               return mid;
           else if(array[mid] < key)
               left = mid + 1;
           else
               right = mid - 1;
       }
       return -1;
   }
   public static int helper1(int []array, int left, int right)
   {
       while(left+1 != right)
       {
           int mid = (left + right) /2 ;
           if(array[mid] <= array[right])
           {
               right = mid;
           }
           else
           {
               left = mid;
           }
       }
       if(array[left] < array[right])
           return left;
       else return right;
   }
   static int zombieCluster(String[] zombies)
   {
       int[][] matrix = new int[zombies.length][zombies.length];
       for(int i = 0; i < matrix.length; i ++)
       {
           for(int j = 0; j < matrix.length; j++)
           {
               char a= zombies[i].charAt(j);
               matrix[i][j] = a - '0';
           }
       }
       int count = zombies.length;
       ArrayList<HashSet<Integer>> array = new ArrayList<HashSet<Integer>>();
       for(int i = 0 ; i < matrix.length; i++)
           for(int j = 0; j < matrix.length; j++)
           {
               if(i != j && matrix[i][j] == 1)
               {
                   int flag = 0;
                   for(HashSet<Integer> sets : array) {
                       if (sets.contains(i) || sets.contains(j)) {
                           flag = 1;
                       }
                   }
                   if(flag == 0)
                   {
                       HashSet<Integer> newset = new HashSet<Integer>();
                       newset.add(i);
                       newset.add(j);
                       array.add(newset);
                       count--;
                   }
               }
           }
           return count;
   }
        public static void main(String[] args) {
//            int rows = 10;
//            for(int i =0;i<rows;i++) {
//                int number = 1;
//                for(int j=0;j<=i;j++) {
//                    if(j!= 0)
//                        System.out.print(" ");
//                    System.out.print(number);
//                    number = number * (i - j) / (j + 1);
//                }
//                System.out.println();
//            }
            System.out.println((16*76)%77);

        }

}
