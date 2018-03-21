/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniide;

import miniide.frontEnd.principal;

/**
 *
 * @author angel
 */
public class MiniIDE {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        principal startWindow = new principal();
        startWindow.setVisible(true);
    }
}
