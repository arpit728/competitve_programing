package algo;

import java.util.*;
import static java.lang.Integer.max;

/**
 * Created by hardCode on 4/10/2017.
 */
public class BST {

    TreeNode root;

    int maxLevel;

    public BST() {
        root=null;
    }

    class TreeNode{
        TreeNode left,right;
        int data;

        public TreeNode() {
        }
        public TreeNode(int data) {
            this.data = data;
        }

    }

    void insert(int data){
        root=insert(root,data);
    }

    TreeNode insert(TreeNode root, int data){

        if (root==null){
            root=new TreeNode();
            root.data=data;
        }
        else {
            if (data<=root.data){
                root.left=insert(root.left,data);
            }
            else {
                root.right=insert(root.right,data);
            }
        }
        return root;

    }

    ArrayList<Integer> inorder(){

        ArrayList<Integer>list=new ArrayList<>();
        inorder(root,list);
        return list;
    }
    void inorder(TreeNode root,ArrayList<Integer> list){

        if (root!=null){
            inorder(root.left,list);
            list.add(root.data);
            inorder(root.right,list);
        }
    }

    ArrayList<Integer>levelOrder(){
        ArrayList<Integer>levelOrderList=new ArrayList<>();
        Queue<TreeNode>queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode temp=queue.poll();
            if (temp.left!=null){
                queue.add(temp.left);
            }
            if (temp.right!=null){
                queue.add(temp.right);
            }
            levelOrderList.add(temp.data);

        }
        return levelOrderList;

    }

    ArrayList<Integer>leftView(){
        ArrayList<Integer>leftViewList=new ArrayList<>();
        Queue<TreeNode>queue=new LinkedList<>();
        queue.add(root);
        queue.add(null);
        TreeNode temp;
        while (!queue.isEmpty()){
            temp= queue.poll();
            boolean flag=true;
            while (temp!=null){

                //Adding first node of every node to the leftView list.
                if (flag){
                    leftViewList.add(temp.data);
                    flag=false;
                }

                if (temp.left!=null) queue.add(temp.left);
                if (temp.right!=null) queue.add(temp.right);

                temp=queue.poll();

                if (temp==null)
                    queue.add(null);
            }
        }
        return leftViewList;
    }
    
    ArrayList<Integer>leftViewRecursive(){
        maxLevel=0;
        ArrayList<Integer>leftViewList=new ArrayList<>();
        leftViewRecursive(root,leftViewList,1);
        maxLevel=0;
        return leftViewList;
    }

    private void leftViewRecursive(TreeNode root, ArrayList<Integer> leftViewList, int level) {

        if (root!=null){

            if (level>maxLevel){
                maxLevel=level;
                leftViewList.add(root.data);
            }
            leftViewRecursive(root.left,leftViewList,level+1);
            leftViewRecursive(root.right,leftViewList,level+1);

        }

    }

    ArrayList<Integer> levelOrderSpiral(){
        ArrayList<Integer>list=new ArrayList<>();
        Stack<TreeNode>stack=new Stack<>();
        Queue<TreeNode>queue=new LinkedList<>();
        queue.add(root);
        queue.add(null);
        int level=1;
        TreeNode temp;
        while (!queue.isEmpty()){
            temp=queue.poll();
            while (temp!=null){

                stack.push(temp);
                temp=queue.poll();

                if (temp==null){
                    TreeNode stackTemp;
                    while (!stack.isEmpty()) {
                        stackTemp = stack.pop();
                        list.add(stackTemp.data);

                        if (level % 2 == 1) {
                            if (stackTemp.right != null)
                                queue.add(stackTemp.right);
                            if (stackTemp.left != null)
                                queue.add(stackTemp.left);
                        }
                        else {
                            if (stackTemp.left != null)
                                queue.add(stackTemp.left);
                            if (stackTemp.right != null)
                                queue.add(stackTemp.right);
                        }
                    }
                    level++;
                    queue.add(null);
                }
            }
        }
        return list;

    }

    ArrayList<Integer>levelOrderSpiralStack(){

        ArrayList<Integer>list=new ArrayList<>();
        Stack<TreeNode>stack1=new Stack<>();
        Stack<TreeNode>stack2=new Stack<>();
        stack1.add(root);
        TreeNode temp;

        while (!stack1.isEmpty() || !stack2.isEmpty()){

            while (!stack1.isEmpty()){
                temp=stack1.pop();
                list.add(temp.data);
                if (temp.right!=null)
                    stack2.push(temp.right);
                if (temp.left!=null)
                    stack2.push(temp.left);
            }

            while (!stack2.isEmpty()){
                temp=stack2.pop();
                list.add(temp.data);

                if (temp.left!=null)
                    stack1.push(temp.left);
                if (temp.right!=null)
                    stack1.push(temp.right);
            }
        }
        return list;
    }

    ArrayList<Integer>boundaryOrder(){

        //tem[0] and temp[1] points to the left most and the right most element in the tree,
        // so that they could be ignored when we are printing leaf nodes otherwise they will get printed twice.
        TreeNode temp[]=new TreeNode[2];
        ArrayList<Integer>list=new ArrayList<>();

        list.add(root.data);
        leftBoundary(root.left, list, temp);

        leafNodes(root.left,list,temp);
        leafNodes(root.right,list,temp);

        rightBoundary(root.right, list, temp);

        return list;
    }

    private void leafNodes(TreeNode root, ArrayList<Integer> list, TreeNode[] temp) {

        if (root!=null){

            /*
            The condition in comment ensures that, if left most and right most elements are also the leaf nodes
            so that could be ignored as they are already being printed by leftBoundary and rightBoundary function
            */
            if (root.left==null && root.right==null /*&& root!=temp[0] && root !=temp[1]*/)
                list.add(root.data);
            leafNodes(root.left,list,temp);
            leafNodes(root.right,list,temp);
        }
    }

    private void rightBoundary(TreeNode root, ArrayList<Integer> list, TreeNode[] temp) {

        //right boundary is printed in bottom up manner
        if (root!=null){

            //Make temp[1] points to the right most element
            /*if (root.right==null)
                temp[1]=root;*/

            rightBoundary(root.right, list, temp);
            //this condition ensures that leaf nodes doesn't get printed as there is entirely different function for printing leaf nodes.
            if (root.left != null || root.right != null)
                list.add(root.data);
        }
    }

    private void leftBoundary(TreeNode root, ArrayList<Integer> list, TreeNode[] temp) {

        //left boundary is printed in top down manner.
        if (root!=null){

            if (root.left != null || root.right != null)
                list.add(root.data);
            /*if (root.left==null)
                temp[0]=root;*/

            //this condition ensures that leaf nodes doesn't get printed as there is entirely different function for printing leaf nodes.
            leftBoundary(root.left,list,temp);
        }
    }

    ArrayList<Integer> rootToLeafSumPath(int sum){

        ArrayList<Integer>list=new ArrayList<>();

        rootToLeafSumPath(root,list,sum);

        Collections.reverse(list);

        return list;
    }

    private boolean rootToLeafSumPath(TreeNode root, ArrayList<Integer> list,int sum) {

        if(root!=null){
            boolean x=rootToLeafSumPath(root.left,list,sum-root.data)||rootToLeafSumPath(root.right,list,sum-root.data);
            if (x)
            {
                list.add(root.data);
                return true;
            }
        }
        if (sum==0)return true;

        return false;
    }

    private int maxWidth() {
        Queue<TreeNode> queue = new LinkedList<>();
        int maxWidth = 0;
        queue.add(root);
        queue.add(null);
        TreeNode temp = null;
        while (!queue.isEmpty()) {
            int currentWirdth = 0;
            while ((temp = queue.poll()) != null) {
                currentWirdth++;
                if (temp.left != null) {
                    queue.add(temp.left);
                }

                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
            maxWidth = Integer.max(currentWirdth, maxWidth);
            if (!queue.isEmpty()) {
                queue.add(null);
            }

        }
        return maxWidth;
    }

    private ArrayList<Integer> nodesAtLevelK(int level) {
        ArrayList<Integer>list=new ArrayList<>();
        nodesAtLevelK(root, 0, level, list);
        return list;
    }

    private void nodesAtLevelK(TreeNode root, int currentLevel, int level, ArrayList<Integer> list) {

        if (root != null) {
            if (currentLevel == level) {
                list.add(root.data);
            }
            nodesAtLevelK(root.left, currentLevel + 1, level, list);
            nodesAtLevelK(root.right, currentLevel + 1, level, list);
        }
    }

    private int maxHeight() {
        return maxHeight(root);
    }

    private int maxHeight(TreeNode root) {
        if (root == null) {
            return -1;
        }

        return max(maxHeight(root.left), maxHeight(root.right))+1;
    }


    public static void main(String[] args) {
        BST bst=new BST();
        bst.insert(20);
        bst.insert(8);
        bst.insert(4);
        bst.insert(12);
        bst.insert(10);
        bst.insert(14);
        bst.insert(22);
        bst.insert(25);

       /* bst.insert(3);
        bst.insert(1);*/
        System.out.println(bst.inorder());
        System.out.println(bst.levelOrder());
        System.out.println(bst.leftView());
        System.out.println(bst.leftViewRecursive());
        System.out.println(bst.levelOrderSpiral());
        System.out.println(bst.levelOrderSpiralStack());
        System.out.println(bst.boundaryOrder());
        System.out.println(bst.rootToLeafSumPath(28));
        System.out.println(bst.maxWidth());
        System.out.println(bst.maxHeight());
        System.out.println(bst.nodesAtLevelK(2));
    }



}
