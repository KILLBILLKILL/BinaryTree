import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;
public class Trees {
    public static Node bulidTree()
    {
        Node a=new Node('A');
        Node b=new Node('B');
        Node c=new Node('C');
        Node d=new Node('D');
        Node e=new Node('E');
        Node f=new Node('F');
        Node g=new Node('G');
        Node h=new Node('H');

        a.left=b;a.right=c;
        b.left=d;b.right=e;
        e.right=h;
        c.left=f;c.right=g;
        d.left=null;
        d.right=null;

        e.left=null;
        f.left=null;
        f.right=null;
        g.left=null;
        g.right=null;
        h.left=null;
        h.right=null;
        return a;


    }
    public static void preOrderTraversal(Node root)
    {
        if(root==null)
            return ;
         //根+左子树+右子树
        System.out.println(root.value);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);



    }
    public static  void inOrederTraversal(Node root)
    {

        if(root==null)
            return ;
        inOrederTraversal(root.left);
        inOrederTraversal(root.right);
        System.out.println(root.value);
    }
    public static void postOrderTraversal(Node root)
    {
        if(root==null)
            return;
        System.out.println(root.value);
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);



    }

    public static void main(String[] args) {
        Node root=bulidTree();
        preOrderTraversal(root);
        System.out.println("=======");
        inOrederTraversal(root);
        System.out.println("======");
        postOrderTraversal(root);
        System.out.println("======");
        System.out.println(preOrder(root));
        System.out.println("======");
        Trees a=new Trees();
        System.out.println(a.preOrderTraversal2(root));
        System.out.println("=======");
        calcCount(root);
        System.out.println(count);
        System.out.println("================");
        System.out.println(calcCount2(root));
        System.out.println("================");
        System.out.println(calcLeafCount(root));
        System.out.println("================");
        calcLeafCount2(root);
        System.out.println(leafcount);
        System.out.println("================");
        System.out.println(clacHeight(root));
        System.out.println("================");
        System.out.println(calcKLevel(root,8));
        System.out.println("================");
        System.out.println(search(root,'C'));
        System.out.println("========");
        System.out.println(search2(root,'A'));
        System.out.println("=============");


    }
    public static List<Character> preOrder(Node root)
    {
        if(root==null)
            return new ArrayList<>();
        List<Character> list=new ArrayList<>();
        List<Character> leftPreOrder=preOrder(root.left);
        List<Character> rightpreOrder=preOrder(root.right);

        list.add(root.value);
        list.addAll(leftPreOrder);
        list.addAll(rightpreOrder);

        return list;

    }
    List<Character> list;
     public void preOrder2(Node root)
    {
        if(root==null)
            return ;
        list.add(root.value);
        preOrder2(root.left);
        preOrder2(root.right);
    }
    public List<Character> preOrderTraversal2(Node root)
    {
        list=new ArrayList<>();
        preOrder2(root);
        return list;
    }
    static int count=0;
    public static void calcCount(Node root)
    {
        if(root==null)
            return;

        count++;
        calcCount(root.left);
        calcCount(root.right);


    }

    public static int calcCount2(Node root)
    {
        if(root==null)
            return 0;
        int left=calcCount2(root.left);
        int right=calcCount2(root.right);
        int count=left+right+1;
        return count;


    }
    static int leafcount=0;
    public static int calcLeafCount(Node root)
    {
        //代表空树
    if(root==null)
        return 0;
    //代表只有一个节点的树
    if(root.left==null&&root.right==null)
        return 1;
    int left=calcLeafCount(root.left);
    int right=calcLeafCount(root.right);
    return left+right;
    }
    public static void calcLeafCount2(Node root)
    {
       if(root==null)
           return ;
       calcLeafCount2(root.left);
       if(root.left==null&&root.right==null)
       {
           leafcount++;
       }
       //中序判断
       calcLeafCount2(root.right);
}
      public static int clacHeight(Node root)
      {
          if(root==null)
              return 0;
          int left=clacHeight(root.left);
          int right=clacHeight(root.right);
          int height=Math.max(left,right)+1;
          return height;
      }

      public static int calcKLevel(Node root ,int k)
      {
          if(root==null)
              return 0;
          if(k==1)
              return 1;
          int left=calcKLevel(root.left,k-1);
          int right=calcKLevel(root.right,k-1);
          return left+right;
      }

      public static  Node search(Node root,char val)
      {
        if(root==null)
            return null;
        if(root.value==val)
            return root;
        //去左子树查找
          Node left=search(root.left,val);
          if(left!=null)
              return left;
          //去右子树查找
          Node right=search(root.right,val);
                  if(right!=null)
                      return right;
                  return null;
      }
      public static boolean search2(Node root,char val)
      {
          if(root==null)
              return false;
          if(root.value==val)
              return true;
          if(search2(root.left,val))
              return true;
        return search2(root.right,val);

      }
//      Node bulidTree1(List<Character>preorder,List<Character> inorder)
//      {
//          char rootValue=preorder.get(0);
//          int leftCount=inorder.indexOf(rootValue);
//          int rightCount=preorder.size()-leftCount-1;
//          Node root=new Node(rootValue);
//
//
//
//          List<Character> leftPreorder;
//          List<Character> leftInorder;
//          Node left=bulidTree(leftPreorder,leftInorder);
//          root.left=left;
//
//          List<Character> rightPreOrder;
//          List<Character> rightInorder;
//          Node right=bulidTree(rightInorder,rightPreOrder);
//          root.right=right;
//
//          return root;
//
//
//      }
}
