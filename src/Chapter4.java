import com.sun.source.tree.ParameterizedTypeTree;
import com.sun.source.tree.Tree;

import java.util.*;

/**
 * Created by jason on 9/24/16.
 */
public class Chapter4 {
    public class Node
    {
        public String name;
        public Node[] adjacent;
        public State state;
    }
    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode parent;
        public int size;
        public TreeNode(int x) {
            val = x;
        }
        public TreeNode getIthNode(int i)
        {
            int leftSize = left == null? 0: left.size;
            if(i < leftSize)
                return new TreeNode(1);
            return new TreeNode(1);
        }
    }

//    public class Graph
//    {
//        public Node[] nodes;
//    }
    enum State{Visited, Visiting, Unvisited;}


    //4.2 Minimal Tree
    TreeNode createMinBST(int[] array)
    {
        return createMinBST(array, 0, array.length - 1);
    }
    TreeNode createMinBST(int []array, int left, int right)
    {
        if(left > right)
            return null;
        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(array[mid]);
        node.left = createMinBST(array, left, mid - 1);
        node.right = createMinBST(array, mid+1, right);
        return node;
    }

    //4.3 levelNode
    //DFS BFS both run in O(n), DFS uses O(logN) extra space, but both of them use O(N) in big O.
    //solution1: BFS
    ArrayList<LinkedList<TreeNode>> createLevelListBFS(TreeNode root)
    {
        ArrayList<LinkedList<TreeNode>> list = new ArrayList<LinkedList<TreeNode>>();
        LinkedList<TreeNode> current = new LinkedList<>();
        current.add(root);
        while(current != null)
        {
            list.add(current);
            LinkedList<TreeNode> parent = current;
            current = new LinkedList<>();
            for(TreeNode node : parent)
            {
                if(node.left != null)
                    current.add(node.left);
                if(node.right != null)
                    current.add(node.right);
            }
        }
        return list;
    }
    //solution2: DFS
    ArrayList<LinkedList<TreeNode>> createLevelListDFS(TreeNode root)
    {
        ArrayList<LinkedList<TreeNode>> list = new ArrayList<LinkedList<TreeNode>>();
        createLevelListDFS(root, list, 0);
        return list;
    }
    void createLevelListDFS(TreeNode node, ArrayList<LinkedList<TreeNode>> list, int level)
    {
        if(node == null)
            return;
        LinkedList<TreeNode> levellist;
        if(list.size() == level) {
            levellist = new LinkedList<>();
            list.add(levellist);
        }
        else
        {
            levellist = list.get(level);
        }
        levellist.add(node);
        createLevelListDFS(node.left, list, level+1);
        createLevelListDFS(node.right, list, level+1);
    }

    //4.4 check balanced of a binary tree

    int checkDepth(TreeNode root)
    {
        if(root == null)
            return 0;
        int leftHeight = checkDepth(root.left);
        int rightHeight = checkDepth(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    int checkBalanced(TreeNode root)
    {
        if(root == null)
            return 0;
        int leftHeight = checkBalanced(root.left);
        int rightHeight = checkBalanced(root.right);
        if(leftHeight == -1|| rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1)
            return -1;
        return Math.max(leftHeight,rightHeight) + 1;
    }
    boolean isBalanced(TreeNode root)
    {
        return checkBalanced(root) != -1;
    }

    //4.5 Validate BST
    //time complexity is O(N), space complexity is O(logn)
    boolean checkBST(TreeNode node)
    {
        return checkBST(node, null, null);
    }

    boolean checkBST(TreeNode node, Integer left, Integer right)
    {
        if(node == null)
            return true;
        boolean leftValid = checkBST(node.left,left,node.val);
        boolean rightValid = checkBST(node.right, node.val + 1,right);
        if(!leftValid || !rightValid)
            return false;
        if((left != null && node.val < left) || (right != null && node.val >= right))
            return false;
        return true;
    }
    //4.6 find successor
    /*
        there are some situations:
            1. has right child -> go right subtree left most chiled;
            2. has no right child :
                2.1 is left child-> go parent;
                2.2 is right child-> go parent and see parent's location if the parents == null means no success.
     */
    TreeNode findSuccessor(TreeNode node)
    {
        if(node.right != null)
        {
            node = node.right;
            while(node.left != null)
            {
                node = node.left;
            }
            return node;
        }
        if(node.parent == null)
            return null;
        if(node.parent.left == node)
            return node.parent;
        else
        {
            node = node.parent;
            while(node.parent!=null)
            {
                if(node.parent.left == node)
                    return node.parent;
                else
                    node = node.parent;
            }
        }
        return node.parent;
    }
    boolean subTree(TreeNode t1, TreeNode t2)
    {
        if(t1 == null)
            return false;
        else if(match(t1,t2))
            return true;
        return subTree(t1.left,t2) || subTree(t1.right, t2);
    }

    boolean match(TreeNode t1, TreeNode t2)
    {
        if(t1 == null && t2 == null)
            return true;
        if(t1 == null || t2 == null)
            return false;
        if(t1.val != t2.val )
            return false;
        return match(t1.left,t2.left) && match(t1.right,t2.right);
    }

    class Tree
    {
        TreeNode root = null;

        public int size()
        {
            return root.size;
        }

        public TreeNode getRandomNode()
        {
            if(root == null)
                return null;
            Random random = new Random();
            int i = random.nextInt(size());
            return root.getIthNode(i);

        }
    }

    /*
    4.12 Paths with Sum

     */
    int countPathWithSum(TreeNode node, int target)
    {
        if(node == null)
            return 0;
        int rootSum = countPathFromNode(node, target, 0);
        int left = countPathWithSum(node.left, target);
        int right = countPathWithSum(node.right, target);
        return rootSum + left + right;
    }
    int countPathFromNode(TreeNode node, int target, int curSum)
    {
        if(node == null)
            return 0;
        int totalpath = 0;
        if(target == curSum + node.val)
            return totalpath ++;
        if(target < curSum + node.val)
            return totalpath;
        return countPathFromNode(node.left, target, node.val) +
                countPathFromNode(node.right, target, node.val);
    }

    Graph buildGraph(String[] projects, String[][] dependencies)
    {
        Graph graph = new Graph();
        for(String poj: projects)
        {
            graph.getOrCreateNode(poj);
        }
        for(String[]dependency : dependencies)
        {
            String first = dependency[0];
            String second = dependency[1];
            graph.addEdge(first, second);
        }
        return graph;
    }

    Project[] orderProjects(ArrayList<Project> projects)
    {
        Project[] order = new Project[projects.size()];
        int endofList = addNonDependent(order, projects, 0);
        int toBeProcessed = 0;
        while(toBeProcessed < order.length)
        {
            Project cur = order[toBeProcessed];
            if(cur == null)
                return null;
            ArrayList<Project> children = cur.children;

        }
    }

    int addNonDependent(Project[] order, ArrayList<Project> projects, int offset)
    {
        for(Project project : projects)
            if(project.dependencies == 0)
            {
                order[offset] = project;
                offset ++;
            }
            return offset;
    }

    public class Project
    {
        ArrayList<Project> children = new ArrayList<>();
        HashMap<String, Project> map = new HashMap<>();
        String name;
        int dependencies = 0;
        public Project(String str)
        {
            name = str;
        }
        public void addNeighbor(Project node)
        {
            if(!map.containsKey(node.name))
            {
                children.add(node);
                map.put(node.name, node);
                node.dependencies++;
            }
        }
    }
    public class Graph
    {
        ArrayList<Project> nodes = new ArrayList<Project>();
        HashMap<String, Project> map = new HashMap<String, Project>();

        Project getOrCreateNode(String name)
        {
            if(map.containsKey(name))
            {
                Project node = new Project(name);
                nodes.add(node);
                map.put(name, node);
            }
            return map.get(name);
        }

        void addEdge(String start, String end)
        {
            Project startpoj = getOrCreateNode(start);
            Project endpoj = getOrCreateNode(end);
            startpoj.addNeighbor(endpoj);
        }
    }

    TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q)
    {
        if(root == null)
            return null;
        if(root == p && root == q)
            return root;
        TreeNode x = commonAncestor(root.left, p, q);
        if(x != null && x != p && x != q)
            return x;
        TreeNode y = commonAncestor(root.right, p ,q);
        if(y != null && y != p && y != q)
            return y;
        if(x != null && y != null)
            return root;

    }

    public static void main(String[] args)
    {
        System.out.println("hello");
    }

}
