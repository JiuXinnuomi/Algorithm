package alorithmtest.tree;

class TreeNode{

    private char data;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(char data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public char getData() {
        return data;
    }

    public void setData(char data) {
        this.data = data;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

}

public class BinaryTree {

    public static void main(String[] args) {
        TreeNode D = new TreeNode('D',null,null);
        TreeNode H = new TreeNode('H',null,null);
        TreeNode K = new TreeNode('K',null,null);
        TreeNode G = new TreeNode('G',H,K);
        TreeNode C = new TreeNode('C',D,null);
        TreeNode F = new TreeNode('F',G,null);
        TreeNode B = new TreeNode('B',null,C);
        TreeNode E = new TreeNode('E',null,F);
        TreeNode A = new TreeNode('A',B,E);

        BinaryTree mytree = new BinaryTree();
        mytree.pre(A);
        System.out.println("前序");
        mytree.in(A);
        System.out.println("中序");
        mytree.beh(A);
        System.out.println("后序");

    }

    public void print(TreeNode root){
        System.out.print(root.getData());
    }

    /*前序遍历*/
    public void pre(TreeNode root){
        print(root);
        if (root.getLeft() != null){
            pre(root.getLeft());
        }
        if (root.getRight() != null){
            pre(root.getRight());
        }
    }

    /*中序遍历*/
    public void in(TreeNode root){
        if (root.getLeft() != null){
            in(root.getLeft());
        }
        print(root);
        if (root.getRight() != null){
            in(root.getRight());
        }
    }

    /*后序遍历*/
    public void beh(TreeNode root){

        if (root.getLeft() != null){
            beh(root.getLeft());
        }
        if (root.getRight() != null){
            beh(root.getRight());
        }
        print(root);
    }

}
