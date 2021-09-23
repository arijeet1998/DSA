import java.util.LinkedList;
import java.util.Queue;

class Node{
    int data;
    Node left,right;

    Node(int data){
        this.data=data;
        left=right=null;
    }
}
class BinaryTree{
    Node root;

    BinaryTree(){
        root=null;
    }


    int getHeight(Node root){
        if(root==null){
            return 0;
        }
        int hleft=getHeight(root.left);
        int hright=getHeight(root.right);

        if(hleft>hright){
            return hleft+1;
        }else{
            return  hright+1;
        }
    }
    void printLevelOrder(){//O(n) due to queue
        Queue<Node> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            Node rem=q.poll();
            System.out.println(rem.data);
            //add the left node
            if(rem.left!=null){
                q.add(rem.left);
            }
            if(rem.right!=null){
                q.add(rem.right);
            }

        }
        
    }


    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.right.right=new Node(6);
        //     1
        //     /\
        //    2 3
        //    /\
        //    4 5
        //      /\
        //      N  6      
        System.out.println("Height "+tree.getHeight(tree.root));
        // tree.getLevelOrder(tree.root);
        tree.printLevelOrder();
        

    }

    

}