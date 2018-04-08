/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniide.TreeControl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author angel
 */
public class Node implements Inode {

    private TypeFile type;
    private String name;
    private String path;
    private List<Inode> childs;

    public Node() {
        childs = new ArrayList<>();
    }

    public Node(TypeFile type, String name, String path) {
        this();
        this.type = type;
        this.name = name;
        this.path = path;
    }

    public TypeFile getType() {
        return type;
    }

    public void setType(TypeFile type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void addChild(Node node) {
        childs.add(node);
    }

    public void addChilds(Node... node) {
        childs.addAll(Arrays.asList(node));
    }

    public void addChilds(List<Node> nodes) {
        childs.addAll(nodes);
    }

    @Override
    public TypeFile getTypeFile() {
        return this.type;
    }

    @Override
    public List<Inode> getChilds() {
        return this.childs;
    }

    @Override
    public Inode getChild() {
        return this;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
