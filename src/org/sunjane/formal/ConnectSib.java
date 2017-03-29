package org.sunjane.formal;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectSib {
    public void connect(TreeLinkNode root) {
        Queue<TreeLinkNode> q = new LinkedList<TreeLinkNode>();
        if (root == null) return;
        q.add(root);
        TreeLinkNode curNode = null, preNode = null;
        int layerLen = 0;
        int preLayerLen = 1;
        while (!q.isEmpty()) {
            while (preLayerLen-- > 0) {
            	curNode = q.poll();
            	if (preNode != null) {
            		preNode.next = curNode;
            	}
            	if (curNode.left != null) {
            		q.add(curNode.left);
            		layerLen++;
            	}
            	if (curNode.right != null) {
            		q.add(curNode.right);
            		layerLen++;
            	}
            	preNode = curNode;
            }
            curNode.next = null;
            preNode = null;
            preLayerLen = layerLen;
            layerLen = 0;
        
        }
    }
}
