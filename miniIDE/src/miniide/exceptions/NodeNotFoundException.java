/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package miniide.exceptions;

/**
 * JFlex_CUP
 * @author jose - 01.03.2018 
 * @Title: NodeNotFoundException
 * @Description: description
 *
 * Changes History
 */
public class NodeNotFoundException extends Exception {

    /**
     * Creates a new instance of <code>NodeNotFoundException</code> without detail message.
     */
    public NodeNotFoundException() {
    }


    /**
     * Constructs an instance of <code>NodeNotFoundException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public NodeNotFoundException(String msg) {
        super(msg);
    }
}
