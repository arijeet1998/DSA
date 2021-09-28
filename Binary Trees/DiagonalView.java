import java.util.*;

/**
 * DiagonalView
 */
public class DiagonalView {

    static class Node{
        int data;
        Node left,right;

        Node(int data){
            this.data=data;
            left=right=null;
        }
    }

    public static void diagonalPrint(Node root,int d,TreeMap<Integer, List<Integer>> tm){

        //return null  if root is null
        if(root==null){
            return;
        }
        //if d not present in treemap make it
        if(!tm.containsKey(d)){
            tm.put(d,new ArrayList<Integer>());
        }
        //add the node in the arrayList present in it
        tm.get(d).add(root.data);

        //in case of the left tree the diagonal value will change by 1
        diagonalPrint(root.left,d+1,tm);

        //Incase of the right subtree the diagonal value wont change
        diagonalPrint(root.right,d,tm);
    }


    public static void diagonalPrint(Node root){
        TreeMap<Integer, List<Integer>> tm= new TreeMap<>();
        diagonalPrint(root,0,tm);

        for(int key: tm.keySet()){
            System.out.println(tm.get(key));
        }

    }


    public static void main(String[] args) {
        
        Node root = new Node(8);
        root.left = new Node(3);
        root.right = new Node(10);
        root.left.left = new Node(1);
        root.left.right = new Node(6);
        root.right.right = new Node(14);
        root.right.right.left = new Node(13);
        root.left.right.left = new Node(4);
        root.left.right.right = new Node(7);
         
        diagonalPrint(root);
    }
}