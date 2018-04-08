/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniide.treeManager;

import javax.swing.tree.DefaultMutableTreeNode;
import miniide.exceptions.NodeNotFoundException;
import miniide.exceptions.NotFolderException;

/**
 *
 * @author angel
 */
public class AddElement {

    String path = "";
    String nameProyect = "";
    boolean isDirectory;

    public AddElement(String path, boolean isDirectory) {
        this.path = path;
        this.isDirectory = isDirectory;
    }

    public void execute(treeController control) {
        DefaultMutableTreeNode baseNode = control.getBaseNodeOfPath(path);
        if (isDirectory) {
            try {
                control.createDirectory(baseNode, path.split(treeController.SEPARATOR));
            } catch (NodeNotFoundException | NotFolderException e) {
                System.out.println("\nError al agregar la carpeta " + e + "\n");
            }
        } else {
            try {
                control.createFile(baseNode, path.split(treeController.SEPARATOR));
            } catch (NodeNotFoundException | NotFolderException e) {
                System.out.println("\nError al agregar el archivo " + e + "\n");
            }
        }
    }

    public String getNameProyect() {
        return nameProyect;
    }

    public void setNameProyect(String nameProyect) {
        this.nameProyect = "/" + nameProyect;
    }

}
