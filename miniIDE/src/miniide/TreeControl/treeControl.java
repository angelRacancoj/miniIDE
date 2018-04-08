/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniide.TreeControl;

import java.awt.Component;
import java.util.List;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

/**
 *
 * @author angel
 */
public class treeControl extends JScrollPane {

    DefaultMutableTreeNode nodeRoot = new DefaultMutableTreeNode("Proyect");
    DefaultTreeModel treeModel = new DefaultTreeModel(nodeRoot);
    JTree tree = new JTree(treeModel);

    public treeControl() {
        tree.setCellRenderer(new DefaultTreeCellRenderer() {

            @Override
            public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
                super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);

                Object node = ((DefaultMutableTreeNode) value).getUserObject();
                if (node instanceof Inode) {
                    setIcon(((Inode) node).getTypeFile().getIcon());
                } else {
                    setIcon(null);
                }
                return this;
            }
        });
        tree.setRootVisible(false);
        tree.setShowsRootHandles(true);
        super.setViewportView(tree);
    }

    public void loadNewProyect(Inode Proyect) {
        DefaultMutableTreeNode proyectRoot = new DefaultMutableTreeNode(Proyect);
        this.loadChild(Proyect.getChilds(), proyectRoot);
        treeModel.insertNodeInto(proyectRoot, nodeRoot, nodeRoot.getChildCount());
        treeModel.nodeStructureChanged((TreeNode) treeModel.getRoot());

    }

    public void loadChild(List<Inode> child, DefaultMutableTreeNode nodeRoot) {
        for (Inode inode : child) {
            DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(nodeRoot);
            nodeRoot.add(newNode);
            loadChild(inode.getChilds(), newNode);
        }
    }

    public DefaultMutableTreeNode getNodeRoot() {
        return nodeRoot;
    }

    public DefaultTreeModel getTreeModel() {
        return treeModel;
    }

}
