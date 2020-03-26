package com.wuyi.leetcode.stackandqueue;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class TreeNode {
 int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}

class Command {
    String item;
    TreeNode node;
    public Command(String item, TreeNode node){
        this.item = item;
        this.node = node;
    }
}

public class Solution_145 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null)
            return res;

        LinkedList<Command> stack = new LinkedList<>();
        stack.push(new Command("go", root));
        while(!stack.isEmpty()) {
            Command command = stack.pop();
            if("print".equals(command.item))
                res.add(command.node.val);
            else {
                if(command.node.right != null)
                    stack.push(new Command("go", command.node.right));

                if(command.node.left != null)
                    stack.push(new Command("go", command.node.left));

                stack.push(new Command("print", command.node));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution_145 s = new Solution_145();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        List<Integer> res = s.inorderTraversal(root);
        System.out.println(res);
    }
}