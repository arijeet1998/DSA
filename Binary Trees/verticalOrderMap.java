import java.util.*;

public class verticalOrderMap {
    static class Node{
        int data;
        Node left,right;

        Node(int data){
            this.data=data;
        }
    }
    public static void verticalTraversalMap(Node root){
        Queue<Node> qn=new LinkedList<>();
        Queue<Integer> qi=new LinkedList<>();
        int min,max;
        min=max=0;
        Map<Integer, List<Integer>> hm= new TreeMap();
        qn.add(root);
        qi.add(0);
        
        while(!qn.isEmpty()){   
            Map<Integer,List<Integer>> tm= new TreeMap();//Everytime its created to maintain the level   
            int size=qn.size();
            for(int i=0;i<size;i++){
                Node rem=qn.poll();
                int idx=qi.poll();
                if(!tm.containsKey(idx)){
                    tm.put(idx,new ArrayList<Integer>());
                }
                tm.get(idx).add(rem.data);

                //check whether the idx is less than min or  higher than max
                if(idx<min){
                    min=idx;
                }else if(idx>max){
                    max=idx;
                }
                //add the left  child with idx--
                if(rem.left!=null){
                    qn.add(rem.left);
                    qi.add(idx-1);
                }
                //add the right child with idx++
                if(rem.right!=null){
                    qn.add(rem.right);
                    qi.add(idx+1);
                }
            }
            for(int key :tm.keySet()){
                if(!hm.containsKey(key)){
                    hm.put(key,new ArrayList<Integer>());
                }
                List<Integer> al= tm.get(key);
                //index if same sort the list
                Collections.sort(al);
                //now add the element
                hm.get(key).addAll(al);
            }
        }
        System.out.println(hm);
        List<Integer>  al= new ArrayList<>();
        for(int key: hm.keySet()){
            int val= hm.get(key).get(0);
            al.add(val);
        }
        System.out.println("Top Order traversal "+al);

    }

    public static void main(String[] args) {
        Node node= new Node(1);
        node.left=new Node(2);
        node.right=new Node(6);
        node.left.right=new Node(7);
        node.right.left=new Node(3);
        node.left.right.left=new Node(4);
        node.left.right.right=new Node(5);
        node.left.right.right.left=new Node(8);
        node.right.right=new Node(10);
        node.right.right.right=new Node(20);

        // Values val= new Values();// values to get the max and min values in a single code only thus static class created

        verticalTraversalMap(node);

    }

}
