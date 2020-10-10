package zhousai;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ThroneInheritance {
    List<String> curOrder = new ArrayList<>();
    Map<String, TreeNode> map = new HashMap<>();
    TreeNode king;
    public ThroneInheritance(String kingName) {
        king = new TreeNode(kingName);
    }

    public void birth(String parentName, String childName) {
        TreeNode parent = map.get(parentName);
        TreeNode child = new TreeNode(childName);
        child.parent = parent;
        parent.childs.add(child);
        map.put(childName, child);
        successor(parentName);
    }

    public void death(String name) {
        TreeNode node = map.get(name);
        node.dead = true;
    }

    public List<String> getInheritanceOrder() {
        return curOrder;
    }

    private String successor(String name){
        TreeNode x = map.get(name);
        Set<String> set = new HashSet<>();
        set.addAll(curOrder);
        if(x.childs.isEmpty() || set.containsAll(x.childs)){
            if(x == king){
                return null;
            }else{
                successor(x.parent.name);
            }
        }else{
            for(TreeNode child : x.childs){
                if(!set.contains(child.name)){
                    successor(child.name);
                }
            }
        }
        return null;
    }

    class TreeNode{
        TreeNode parent;
        List<TreeNode> childs;
        String name;
        boolean dead;
        public TreeNode(String name){
            this.name = name;
            this.dead = false;
            childs = new ArrayList<>();
        }
    }
}
