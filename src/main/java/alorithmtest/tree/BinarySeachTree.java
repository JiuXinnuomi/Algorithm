package alorithmtest.tree;

/**
 * 二叉搜索树
 */

public class BinarySeachTree {

    private int data;
    BinarySeachTree left;
    BinarySeachTree right;

    public BinarySeachTree(int data) {
        this.data = data;
        this.left = null;
        this.right = null;

    }

    public int getData() {
        return data;
    }

    public BinarySeachTree getLeft() {
        return left;
    }

    public BinarySeachTree getRight() {
        return right;
    }

    public static void main(String[] args) {
        BinarySeachTree tree = new BinarySeachTree(5);
        tree.insert(tree,3);
        tree.insert(tree,6);
        tree.insert(tree,2);
        tree.insert(tree,7);
        tree.insert(tree,9);
        tree.find(tree,7);
        tree.in(tree);
    }

    /*二叉搜索树插入*/
    public void insert(BinarySeachTree root,int data){
        //默认root != null;
        if (root.data < data){
            if (root.right != null){
                insert(root.right,data);
            }else{
                root.right = new BinarySeachTree(data);
            }
        }else {
            if (root.left != null){
                insert(root.left,data);
            }else {
                root.left = new BinarySeachTree(data);
            }
        }
    }

    /*二叉搜索树查找*/
    public void find(BinarySeachTree root,int data){  //时间复杂度O(logn)
        if (root != null){
            if (root.data < data){
                find(root.right,data);
            }else if (root.data > data){
                find(root.left,data);
            }else {
                System.out.println("找到了： " + root.data);
                return;
            }
        }
    }

    /*中序遍历*/
    public void in(BinarySeachTree root){
        if (root.getLeft() != null){
            in(root.getLeft());
        }
        System.out.print(root.getData());
        if (root.getRight() != null){
            in(root.getRight());
        }
    }
}
