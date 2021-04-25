package com.jacob.tree;

public class BinaryTree {
    private Node root;

    public void setRoot(Node root) {
        this.root = root;
    }
    public void preOrder(){
        if (root != null){
            System.out.println("前序遍历");
            root.preOrder();
        }else {
            System.out.println("空");
        }
    }
    public void midOrder(){
        if (root != null){
            System.out.println("中序遍历");
            root.midOrder();
        }else {
            System.out.println("空");
        }
    }
    public void postOrder(){
        if (root != null){
            System.out.println("后序遍历");
            root.postOrder();
        }else {
            System.out.println("空");
        }
    }

    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree();
        Node node1 = new Node("1","aa");
        Node node2 = new Node("2","bb");
        Node node3 = new Node("3","cc");
        Node node4 = new Node("4","dd");
        binaryTree.setRoot(node1);
        node1.setLeft(node2);
        node1.setRight(node3);
        node3.setRight(node4);
        binaryTree.preOrder();
        System.out.println("-----------------------");
        binaryTree.midOrder();
        System.out.println("-----------------------");
        binaryTree.postOrder();
    }

}
//先创建节点
class Node{
    private String no;
    private String name;
    private Node left;
    private Node right;

    public Node(String no, String name) {
        this.no = no;
        this.name = name;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
    @Override
    public String toString() {
        return "Node{" +
                "no='" + no + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    //前序遍历
    public void preOrder(){
        System.out.println(this.toString());
        if (this.left != null){
            this.left.preOrder();
        }
        if (this.right != null){
            this.right.preOrder();
        }
    }
    //中序遍历
    public void midOrder(){
        if(this.left != null){
            this.left.midOrder();
        }
        System.out.println(this.toString());
        if (this.right != null){
            this.right.midOrder();
        }
    }
    //后续遍历
    public void postOrder(){
        if(this.left != null){
            this.left.postOrder();
        }
        if (this.right != null){
            this.right.postOrder();
        }
        System.out.println(this.toString());
    }
}