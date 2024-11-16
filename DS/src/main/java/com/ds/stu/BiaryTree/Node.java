package com.ds.stu.BiaryTree;
public class Node {
    public Integer val;
    public boolean IsNull=false;
    public Node left=null;
    public Node right=null;
    public Node() {
        IsNull=true;
    }
    public Node(Integer val) {
        if(val==null) {
            IsNull = true;
        }else {
            this.val = val;
        }
    }
    @Override
    public String toString() {
        if(IsNull) return "Node{null}";
        return "Node{" +
                "val=" + val +
                '}';}
    public boolean IsEmpty() {
        return IsNull == true;
    }
}
