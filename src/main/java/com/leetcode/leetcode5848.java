package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class leetcode5848 {
    public static void main(String[] args) {
        LockingTree hand=new LockingTree(new int[]{-1, 6, 5, 5, 7, 0, 7, 0, 0, 6});
        System.out.println(hand.lock(5,36));
        System.out.println(hand.upgrade(0,1));
    }
    static class LockingTree {
        int[] parent;
        int[]lockByPerson;
        HashMap<Integer,ArrayList<Integer>>childs;//父节点-所有子节点的列表
        ArrayList<Integer> resList=new ArrayList<>();;
        public LockingTree(int[] parent) {
            this.parent=parent;
            this.lockByPerson=new int[parent.length];
            Arrays.fill(lockByPerson,0);
            this.childs= new HashMap<>();
            for(int i=0;i<parent.length;i++){
                if(childs.containsKey(parent[i])){
                    childs.get(parent[i]).add(i);
                }else{
                    ArrayList<Integer> t=new ArrayList<>();
                    t.add(i);
                    childs.put(parent[i],t);
                }
            }
        }

        public boolean lock(int num, int user) {
            if(lockByPerson[num]!=0){
                return false;
            }
            lockByPerson[num]=user;
            return true;
        }

        public boolean unlock(int num, int user) {
            if(lockByPerson[num]==user){
                lockByPerson[num]=0;
                System.out.println(user);
                return true;
            }
            return false;
        }

        public boolean upgrade(int num, int user) {
            if(lockByPerson[num]!=0||findLockParent(num)){
                return false;
            }
            ArrayList<Integer> list=new ArrayList<>();
            resList=new ArrayList<>();
            list.add(num);
            dfsLockChild(list);
            if(resList.size()==0){
                return false;
            }
            for (Integer integer : resList) {
                lockByPerson[integer] = 0;
            }
            lockByPerson[num]=user;
            return true;
        }
        private void dfsLockChild(ArrayList<Integer>list){
            for(int i=0;i<list.size();i++){
                if(lockByPerson[list.get(i)]!=0){//list。get（i）是父节点，要找含有父节点的
                    resList.add(list.get(i));
                }
                if(childs.containsKey(list.get(i))){//如果childs里有，继续找，childs是 有子节点的父节点，这里的逻辑没有考虑自身是否上锁？
                    dfsLockChild(childs.get(list.get(i)));//前一步考虑了上锁
                }
            }
        }
        private boolean findLockParent(int num){
            if(parent[num]==-1){
                return false;
            }
            if(lockByPerson[parent[num]]!=0){
                return true;
            }
            return findLockParent(parent[num]);
        }
    }



//    ["LockingTree","upgrade","upgrade","unlock","lock","upgrade"]
//            [[[-1,0,3,1,0]],[4,5],[3,8],[0,7],[2,7],[4,6]]
//            ["LockingTree","lock","unlock","unlock","lock","upgrade","lock"]
//            [[[-1,0,0,1,1,2,2]],[2,2],[2,3],[2,2],[4,5],[0,1],[0,1]]
/**
 * Your LockingTree object will be instantiated and called as such:
 * LockingTree obj = new LockingTree(parent);
 * boolean param_1 = obj.lock(num,user);
 * boolean param_2 = obj.unlock(num,user);
 * boolean param_3 = obj.upgrade(num,user);
 */
}
