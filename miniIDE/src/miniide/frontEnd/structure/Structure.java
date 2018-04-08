/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniide.frontEnd.structure;

import java.awt.Color;
import java.awt.ComponentOrientation;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

/**
 *
 * @author angel
 */
public class Structure {

    private int tabs = 0;

    public void appendEndCom(String endCom, JTextPane panel) {
        appendCBlack(endCom, panel);
        appendLineJump(panel);
        addTabs(tabs, panel);
    }

    public void appendImport(String imprt, String parAbierto, String cadena, String parCerrado, String endCom, JTextPane panel) {
        appendCPurple(imprt, panel);
        appendSpace(panel);
        appendCBlack(parAbierto, panel);
        appendCBrown(cadena, panel);
        appendCBlack(parCerrado, panel);
        appendCBlack(endCom, panel);
        appendLineJump(panel);

    }

    public void appendClaseID(String visibilidad, String claseID, String id, JTextPane panelComandos) {
        appendLineJump(panelComandos);
        appendCPurple(visibilidad, panelComandos);
        appendSpace(panelComandos);
        appendCPurple(claseID, panelComandos);
        appendSpace(panelComandos);
        appendCBlack(id, panelComandos);
    }

    public void extiendeID(String ext, String id, JTextPane panelComandos) {
        appendSpace(panelComandos);
        appendCPurple(ext, panelComandos);
        appendSpace(panelComandos);
        appendCBlack(id, panelComandos);
    }

    public void appendCorCerrado(String corCerrado, JTextPane panelComandos, boolean StructIf) {
        appendLineJump(panelComandos);
        appendCBlack(corCerrado, panelComandos);
        tabs--;
        if (!StructIf) {
            appendLineJump(panelComandos);
        }
        addTabs(tabs, panelComandos);
    }

    public void appendCorAbierto(String corAbierto, JTextPane panelComandos) {
        appendCBlack(corAbierto, panelComandos);
        appendLineJump(panelComandos);
        tabs++;
        addTabs(tabs, panelComandos);
    }

    /**
     * Nos permite colorear cualquier palabra con un color en especifico en el
     * JTextPane que le hemos enviado como paramentro
     *
     * @param c
     * @param cadena
     * @param panelComandos
     */
    public void appendString(Color c, String cadena, JTextPane panelComandos) {
        append(c, cadena, panelComandos);
    }

    /**
     * Este lo utilizamos para colorear los comentarios
     *
     * @param cadena
     * @param panelComandos
     */
    public void appendCGreen(String cadena, JTextPane panelComandos) {
        append(Color.GREEN, cadena + "\n", panelComandos);
        addTabs(tabs, panelComandos);
    }

    /**
     * Este lo utilizaremos para colorear los enteros
     *
     * @param cadena
     * @param panelComandos
     */
    public void appendCOrange(String cadena, JTextPane panelComandos) {
        appendString(Color.orange, cadena + " ", panelComandos);
    }

    /**
     * Lo utilizaremos para pintar: El nombre de un Entero El nombre de un
     * Decimal El nombre de una Cadena El nombre de un Entero El nombre de un
     * Booleano Vacio Devolver Si_SC, Si_NoSi_SC, SiNo_SC, Mientras_SC,
     * Hacer_SC, Desde_SC, Hasta_SC, Incremento_SC
     *
     * @param cadena
     * @param panelComandos
     */
    public void appendCBlue(String cadena, JTextPane panelComandos) {
        appendString(Color.cyan, cadena + " ", panelComandos);
    }

    /**
     * Pintamos los datos decimales
     *
     * @param cadena
     * @param panelComandos
     */
    public void appendCRed(String cadena, JTextPane panelComandos) {
        appendString(Color.red, cadena + " ", panelComandos);
    }

    /**
     * Pintamos las datos tipo cadena
     *
     * @param cadena
     * @param panelComandos
     */
    public void appendCBrown(String cadena, JTextPane panelComandos) {
        appendString(Color.LIGHT_GRAY, cadena + " ", panelComandos);
    }

    /**
     * Pintamos los datos tipo Boleano true & false
     *
     * @param cadena
     * @param panelComandos
     */
    public void appendCYellow(String cadena, JTextPane panelComandos) {
        appendString(Color.yellow, cadena + " ", panelComandos);
    }

    /**
     * Nos servira para pintar: mas, memons, por, div add1, less1 mayor, menor,
     * mayorIg, menorIg, igual, diferente and, or, not, asignacion
     *
     * @param cadena
     * @param panelComandos
     */
    public void appendDarkBlue(String cadena, JTextPane panelComandos) {
        appendString(Color.blue, cadena + " ", panelComandos);
    }

    /**
     * Nos sirve para pintar: EndCom, identificador, ParAbierto, ParCerrrado,
     * CorAbierto, CorCerrado,Coma
     *
     * @param cadena
     * @param panelComandos
     */
    public void appendCBlack(String cadena, JTextPane panelComandos) {
        appendString(Color.black, cadena + " ", panelComandos);
    }

    /**
     * Nos sirve para pintar: Publico, Protegido, Privado Nuevo, Importar,
     * Clase, Extiende, Imprimir
     *
     * @param cadena
     * @param panelComandos
     */
    public void appendCPurple(String cadena, JTextPane panelComandos) {
        appendString(Color.blue, cadena + " ", panelComandos);
    }

    /**
     * cualquier otro comando q ha halla sido considerado con un color en
     * especifico color: negro
     *
     * @param cadena
     * @param panelComandos
     */
    public void appendEverythingElse(String cadena, JTextPane panelComandos) {
        appendString(Color.black, cadena + " ", panelComandos);
    }

    /**
     * Agrega un salto de linea
     *
     * @param panelComandos
     */
    public void appendLineJump(JTextPane panelComandos) {
        appendString(Color.black, "\n", panelComandos);
    }

    /**
     * Agrega un salto de linea
     *
     * @param panelComandos
     */
    public void appendSpace(JTextPane panelComandos) {
        appendString(Color.black, " ", panelComandos);
    }

    /**
     * Se agrega la cantidad de tabs necesarios para la indentacion
     *
     * @param tabs
     * @param panel
     */
    public void addTabs(int tabs, JTextPane panel) {
        String salida = "";
        for (int i = 0; i < tabs; i++) {
            salida += "\t";
        }
        appendString(Color.WHITE, salida, panel);
    }

    private void append(Color c, String s, JTextPane panelComandos) {
        StyleContext sc = StyleContext.getDefaultStyleContext();
        AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, c);

        int len = panelComandos.getText().length();
        panelComandos.setCaretPosition(len);
        panelComandos.setCharacterAttributes(aset, false);
        panelComandos.replaceSelection(s);
    }
}
