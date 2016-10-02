import java.util.Stack;

/**
 * Created by jason on 10/1/16.
 */
public class Chapter3 {
    public static class MyQueue<T>
    {
        Stack<T> stackNewest, stackOldest;

        void add(T value)
        {
            stackNewest.push(value);
        }
        private void shiftStacks()
        {
            if(stackOldest.isEmpty())
            {
                while(!stackNewest.isEmpty())
                {
                    stackOldest.push(stackNewest.pop());
                }
            }
        }
        private T remove()
        {
            shiftStacks();
            return stackOldest.pop();
        }
    }

    void sort(Stack<Integer> s)
    {
        Stack<Integer> r = new Stack<Integer>();
        while(!s.isEmpty())
        {
            if(r.isEmpty())
            {
                r.push(s.pop());
            }
            else
            {
                int tmp = s.pop();
                if(tmp >= r.peek())
                {
                    r.push(tmp);
                }
                else
                {
                    int index = 0;
                    while(tmp < r.peek())
                    {
                        s.push(r.pop());
                        index++;
                    }
                    r.push(tmp);
                    while(index>0)
                    {
                        r.push(s.pop());
                    }
                }
            }
        }
        while(!r.isEmpty())
        {
            s.push(r.pop());
        }
    }

    public static class StackWithMin2 extends Stack<Integer>
    {
        Stack<Integer> minstack = new Stack<Integer>();
        public int getMin()
        {
            if(minstack.isEmpty())
                return Integer.MAX_VALUE;
            return minstack.pop();
        }
        public void push(int value)
        {
            if(value <= getMin())
            {
                minstack.push(value);
            }
            super.push(value);
        }
        public Integer pop()
        {
            if(super.pop() == getMin())
                minstack.pop();
            return super.pop();
        }
    }
    public static void main(String[] args)
    {
        StackWithMin2 stack2 = new StackWithMin2();
        stack2.push(5);
        stack2.push(3);
        stack2.push(4);
        stack2.pop();
        System.out.println(stack2.getMin());
    }
}
