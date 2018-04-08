/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniide.treeManager;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author angel
 */
public class FileDir {

    String name;
    String path;
    boolean Dir;
    List<FileDir> listFiles = new LinkedList<>();

    public FileDir(String name, String path, boolean Dir, List<FileDir> listFiles) {
        this.name = name;
        this.path = path;
        this.Dir = Dir;
        this.listFiles = listFiles;
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

    public boolean isDir() {
        return Dir;
    }

    public void setDir(boolean Dir) {
        this.Dir = Dir;
    }

    public List<FileDir> getListFiles() {
        return listFiles;
    }

    public void setListFiles(List<FileDir> listFiles) {
        this.listFiles = listFiles;
    }

}
