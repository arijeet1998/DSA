import java.util.*;
    
//User function Template for Java

/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class Solution
{
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root)
    {
        Map<Integer,List<Integer>> hm= new TreeMap<>();
        // int min,max;
        // min=max=0;
        Queue<Node> qn= new LinkedList<>();
        Queue<Integer> qi= new LinkedList<>();
        qn.add(root);
        qi.add(0);//which is not null
        while(!qn.isEmpty()){
            Map<Integer,List<Integer>> tm= new TreeMap<>();
            int size=qn.size();
            for(int i=0;i<size;i++){
                Node rem=qn.poll();
                int idx=qi.poll();
                if(!tm.containsKey(idx)){
                    tm.put(idx,new ArrayList<Integer>());
                }
                tm.get(idx).add(rem.data);
                //check the min and max // since I am using the TreeMap I dont need the min and max respectively
                // if(idx<min){
                //     min=idx;
                // }else if(idx>max){
                //     max=idx;
                // }
                //move to the left if node present and make idx idx-1
                if(rem.left!=null){
                    qn.add(rem.left);
                    qi.add(idx-1);
                }
                //move to the right if node present and make idx idx+1
                if(rem.right!=null){
                    qn.add(rem.right);
                    qi.add(idx+1);
                }
            }
            for(int key: tm.keySet()){
                if(!hm.containsKey(key)){
                    hm.put(key, new ArrayList<>());
                }
                List<Integer> al= tm.get(key);
                Collections.sort(al);
                hm.get(key).addAll(al);
            }
        }
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(int key:hm.keySet()){
            int val=hm.get(key).get(0);
            res.add(val);
        }
        return res;
    }
}
    

