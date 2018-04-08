/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniide.treeManager;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.Stack;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import miniide.exceptions.NodeNotFoundException;
import miniide.exceptions.NotFolderException;
import miniide.files.EmuledFile;

/**
 *
 * @author angel
 */
public class treeController {

    Stack<String> Directory = new Stack<>();

    public static final String SEPARATOR = "/";
    public static final String ROOT = "/";

    DefaultMutableTreeNode rootNode;
    DefaultTreeModel model;
    String currentLocation;
    JTree jTree;

    public treeController(JTree jTree) {
        this.jTree = jTree;
        this.rootNode = this.createDirectoryNode(ROOT);
        this.model = new DefaultTreeModel(rootNode);
        this.jTree.setModel(model);
        this.jTree.setExpandsSelectedPaths(true);
        resetPath();
    }

    public DefaultMutableTreeNode createDirectoryNode(String name) {
        return new DefaultMutableTreeNode(this.createDirectoryObject(name));
    }

    public EmuledFile createDirectoryObject(String name) {
        return new EmuledFile(name, true);
    }

    public final void resetPath() {
        this.selectNode(this.rootNode, ROOT);
    }

    public void selectNode(DefaultMutableTreeNode node, String path) {
        this.selectNodeInTree(node);
        this.changeCurrentLocation(path);
    }

    public void selectNodeInTree(DefaultMutableTreeNode node) {
        this.jTree.getSelectionModel().setSelectionPath(new TreePath(node.getPath()));
    }

    public void changeCurrentLocation(String path) {
        if (path.startsWith(ROOT)) {
            this.currentLocation = path;
        } else if (ROOT.equals(this.currentLocation)) {
            this.currentLocation = this.currentLocation + path;
        } else {
            this.currentLocation = this.currentLocation + SEPARATOR + path;
        }
    }

    public DefaultMutableTreeNode findNode(DefaultMutableTreeNode baseNode, String name) throws NodeNotFoundException {
        EmuledFile baseFile = (EmuledFile) baseNode.getUserObject();
        Enumeration<DefaultMutableTreeNode> children = baseNode.children();
        while (children.hasMoreElements()) {
            DefaultMutableTreeNode child = children.nextElement();
            EmuledFile item = (EmuledFile) child.getUserObject();
            if (item.getName().equals(name)) {
                return child;
            }
        }
        throw new NodeNotFoundException("No se encuentra el item: >>" + name + "<< en >>"
                + baseFile.getName());
    }

    public DefaultMutableTreeNode createDirectory(DefaultMutableTreeNode baseNode, String[] paths) throws NodeNotFoundException, NotFolderException {
        String newDirectoryName = paths[paths.length - 1];
        DefaultMutableTreeNode newDirectoryNode = this.createDirectoryNode(newDirectoryName);
        DefaultMutableTreeNode newDirectoryBaseNode = this.getLastParent(baseNode, paths);
        newDirectoryBaseNode.add(newDirectoryNode);
        return newDirectoryNode;
    }

    public DefaultMutableTreeNode getLastParent(DefaultMutableTreeNode baseNode, String[] paths) throws NodeNotFoundException, NotFolderException {
        String[] basePaths = Arrays.copyOf(paths, paths.length - 1);
        return this.navigateToNode(baseNode, basePaths);
    }

    public DefaultMutableTreeNode navigateToNode(DefaultMutableTreeNode baseNode, String[] paths) throws NodeNotFoundException, NotFolderException {
        DefaultMutableTreeNode nextBaseNode = baseNode;
        for (String path : paths) {
            if (path.length() > 0) {
                nextBaseNode = this.findNode(nextBaseNode, path);
            }
        }
        EmuledFile newDirBaseFile = (EmuledFile) nextBaseNode.getUserObject();
        if (!newDirBaseFile.isDirectory()) {
            throw new NotFolderException("El path: " + String.join(SEPARATOR, paths) + " no es un directorio.");
        }
        return nextBaseNode;
    }

    public DefaultMutableTreeNode createFile(DefaultMutableTreeNode baseNode, String[] paths) throws NodeNotFoundException, NotFolderException {
        String newFileName = paths[paths.length - 1];
        DefaultMutableTreeNode newFileBaseNode = this.getLastParent(baseNode, paths);
        DefaultMutableTreeNode newFileNode = this.createFileNode(newFileName);
        newFileBaseNode.add(newFileNode);
        return newFileNode;
    }

    public DefaultMutableTreeNode createFileNode(String name) {
        return new DefaultMutableTreeNode(this.createFileObject(name));
    }

    public EmuledFile createFileObject(String name) {
        return new EmuledFile(name, false);
    }

    public void expandNodeInTree(DefaultMutableTreeNode node) {
        this.jTree.expandPath(new TreePath(node.getPath()));
    }

    public EmuledFile findLastItem(DefaultMutableTreeNode baseNode, String[] paths) throws NodeNotFoundException, NotFolderException {
        DefaultMutableTreeNode lastNode = findLastNode(baseNode, paths);
        return (EmuledFile) lastNode.getUserObject();
    }

    public DefaultMutableTreeNode findLastNode(DefaultMutableTreeNode baseNode, String[] paths) throws NodeNotFoundException, NotFolderException {
        DefaultMutableTreeNode lastParentNode = this.getLastParent(baseNode, paths);
        return this.findNode(lastParentNode, paths[paths.length - 1]);
    }

    public DefaultMutableTreeNode getBaseNodeOfPath(String path) {
        DefaultMutableTreeNode baseNode;
        if (path.startsWith(SEPARATOR)) {//absolute path, root node is the parent
            baseNode = this.getRootNode();
        } else {//relative path, current node as parent
            baseNode = this.getSelectedNode();
        }
        return baseNode;
    }

    public DefaultMutableTreeNode getRootNode() {
        return rootNode;
    }

    public DefaultMutableTreeNode getSelectedNode() {
        return (DefaultMutableTreeNode) this.jTree.getLastSelectedPathComponent();
    }

    public String path(String nombre) {
        Directory.push(nombre);
        String tempPath = "";

        for (int i = 0; i < Directory.size(); i++) {
            tempPath += ("/" + Directory.get(i));
        }
        return tempPath;
    }
}
