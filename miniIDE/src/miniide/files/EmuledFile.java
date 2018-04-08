/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniide.files;

/**
 *
 * @author angel
 */
public class EmuledFile {

    String name;
    boolean Directory;

    public EmuledFile(String name, boolean Directory) {
        this.name = name;
        this.Directory = Directory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDirectory() {
        return Directory;
    }

    public void setDirectory(boolean Directory) {
        this.Directory = Directory;
    }

}
