package  miniide.frontEnd;

import java_cup.runtime.*;
import javax.swing.JTextPane;

%%

%public
%class LexerArch
%cup
%cupdebug
%line
%column

LineTerminator = \r|\n|\r\n
WhiteSpace     = {LineTerminator} | [ \t\f]

termArch = "mcf"
nombreArch = [:jletter:]([:jletterdigit:] | [-] | [_])*[.]?{termArch}?
month = "enero" | "febrero" | "marzo" | "abril" | "mayo" | "junio" | "julio" | "agosto" | "septiembre" | "octubre" | "noviembre" | "diciembre"
dateCreate = [:digit:]+[-] {month} [-][:digit:]+
rutaTxt	= "\"" [^*] ~"\""

%{
  	StringBuilder string = new StringBuilder();
  
  	private Symbol symbol(int type) {
    	return new Symbol(type, yyline+1, yycolumn+1);
  	}

  	private Symbol symbol(int type, Object value) {
    	return new Symbol(type, yyline+1, yycolumn+1, value);
  	}

  	private void error(String message) {
    	System.out.println("Error en linea line "+(yyline+1)+", columna "+(yycolumn+1)+" : "+message);
  	}
/*
  	public LexerArch (java.io.Reader in) {
		this.zzReader = in;
	}
*/
	private void imprimirToken(String textSalida){
		System.out.println("Leido: >> " + textSalida + " <<");
	}
%}

%%

<YYINITIAL>{
	"<proyecto>"		{imprimirToken(yytext()); return symbol(proyectoOp, yytext());}
	"</proyecto>"		{imprimirToken(yytext()); return symbol(proyectoCl, yytext());}
	"<nombre>"			{imprimirToken(yytext()); return symbol(nombreOp, yytext());}
	"</nombre>"			{imprimirToken(yytext()); return symbol(nombreCl, yytext());}
	"<creacion>"		{imprimirToken(yytext()); return symbol(creacionOp, yytext());}
	"</creacion>"		{imprimirToken(yytext()); return symbol(creacionCl, yytext());}
	"<ruta>"			{imprimirToken(yytext()); return symbol(rutaOp, yytext());}
	"</ruta>"			{imprimirToken(yytext()); return symbol(rutaCl, yytext());}
	"<archivo>"			{imprimirToken(yytext()); return symbol(archivoOp, yytext());}
	"</archivo>"		{imprimirToken(yytext()); return symbol(archivoCl, yytext());}
	"<paquete>"			{imprimirToken(yytext()); return symbol(paqueteOp, yytext());}
	"</paquete>"		{imprimirToken(yytext()); return symbol(paqueteCl, yytext());}
	"<archs>"			{imprimirToken(yytext()); return symbol(lsArchOp, yytext());}
	"</archs>"			{imprimirToken(yytext()); return symbol(lsArchCl, yytext());}
	{dateCreate}		{imprimirToken(yytext()); return symbol(CreateDate, yytext());}
	{nombreArch}		{imprimirToken(yytext()); return symbol(nameArch, yytext());}
	{rutaTxt}			{imprimirToken(yytext()); return symbol(fileRote, yytext());}
	{WhiteSpace} 		{/*Nothing to do*/}
	{LineTerminator} 	{/*Nothing to do*/}
}

[^] {error("Simbolo invalido <"+ yytext()+">");}
<<EOF>>                 { return symbol(EOF); }