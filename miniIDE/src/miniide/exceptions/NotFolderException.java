/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package miniide.exceptions;

/**
 * JFlex_CUP
 * @author jose - 01.03.2018 
 * @Title: NotFolderException
 * @Description: description
 *
 * Changes History
 */
public class NotFolderException extends Exception {

    /**
     * Creates a new instance of <code>NotFolderException</code> without detail message.
     */
    public NotFolderException() {
    }


    /**
     * Constructs an instance of <code>NotFolderException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public NotFolderException(String msg) {
        super(msg);
    }
}
