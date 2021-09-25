public class verticalTraversal {
    static class Node{
        int data;
        Node left,right;

        Node(int data){
            this.data=data;
            left=right=null;
        }
    }
    static class Values{
        int min,max;
    }
    public static void findMax(Node root,Values min,Values max,int hd){
        //base case
        if(root==null){
            return;
        }
        //if(hd is lesser than min min=hd){
            if(hd<min.min){
                min.min=hd;
        //if had id greater than max max=hd
            }else if(hd>max.max){
                max.max=hd;
            }

            //now traverse the left subtree with the horisontal distance --1
            findMax(root.left, min, max, hd-1);
            //now traverse the right subtree with the horisontal distance ++1
            findMax(root.right, min, max, hd+1);
        }


    public static void PrintVerticalLine(Node root,int line_no,int hd){
        //base case
        if(root==null){
            return;
        }
        //if(hd==line no then print the value)
        if(hd==line_no){
            System.out.print(root.data+"\t");
        }
        //if moved to left tree reduce the hd by -1
        PrintVerticalLine(root.left, line_no, hd-1);
        //if moved to the right tree increse the hd by 1
        PrintVerticalLine(root.right, line_no, hd+1);
    }

    public static void VerticalOrder(Node root,Values val){
        //I will get the min max of the tree 
        findMax(root,val, val, 0);
         // Iterate through all possible vertical lines starting
        // from the leftmost line and print nodes line by line
        for(int line_no=val.min;line_no<=val.max;line_no++){
            PrintVerticalLine(root, line_no, 0);
            System.out.println();
        }
        
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
    
            Values val= new Values();// values to get the max and min values in a single code only thus static class created

            VerticalOrder(node, val);
    
        }
    }

