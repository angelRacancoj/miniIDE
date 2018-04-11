package miniide;

import java_cup.runtime.*;
import javax.swing.JTextPane;
import miniide.sym;

%%

%public
%class Lexer
%cup
%cupdebug
%line
%column

LineTerminator = \r|\n|\r\n|null
InputCharacter = [^\r\n]
WhiteSpace     = {LineTerminator} | [ \t\f]

Comment = {TraditionalComment} | {EndOfLineComment} 

TraditionalComment   = "$*" [^*] ~"*$"  //"$*" [^*] ~"*$"
EndOfLineComment     = "//" {InputCharacter}* {LineTerminator}?

entero = [-]? [:digit:]+
decimal = entero [.][:digit:]+
cadena = "\"" [^*] ~"\""
identificador = [:jletter:]([:jletterdigit:] | [-] | [_])*
boolID = "true" | "false"



%{
	private JTextPane panel;
	private Structure painting;
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

  	public Lexer (java.io.Reader in, JTextPane panelSalida, Structure paintText) {
		this.zzReader = in;
		this.panel = panelSalida;
		this.painting = paintText;
	}

	private void imprimirToken(String textSalida){
		System.out.println("Leido: >> " + textSalida + " <<");
	}
%}

%%

<YYINITIAL>{
	
	"entero" 			{imprimirToken(yytext()); return symbol(NamEntero, yytext());}
	"decimal" 			{imprimirToken(yytext()); return symbol(NamDecimal, yytext());}
	"cadena"			{imprimirToken(yytext()); return symbol(NamCadena, yytext());}
	"boolean" 			{imprimirToken(yytext()); return symbol(NamBoolean, yytext());}
	"vacio" 			{imprimirToken(yytext()); return symbol(Vacio, yytext());}
	"devolver" 			{imprimirToken(yytext()); return symbol(Devolver, yytext());}
	"publico" 			{imprimirToken(yytext()); return symbol(Publico, yytext());}
	"protegido" 		{imprimirToken(yytext()); return symbol(Protegido, yytext());}
	"privado" 			{imprimirToken(yytext()); return symbol(Privado, yytext());}
	"nuevo" 			{imprimirToken(yytext()); return symbol(Nuevo, yytext());}
	"importar"			{imprimirToken(yytext()); return symbol(Importar, yytext());}
	"clase" 			{imprimirToken(yytext()); return symbol(Clase, yytext());}
	"extiende" 			{imprimirToken(yytext()); return symbol(Extiende, yytext());}
	"+" 				{imprimirToken(yytext()); return symbol(Mas, yytext());}
	"-" 				{imprimirToken(yytext()); return symbol(Menos, yytext());}
	"*" 				{imprimirToken(yytext()); return symbol(Por, yytext());}
	"/" 				{imprimirToken(yytext()); return symbol(Div, yytext());}
	"++" 				{imprimirToken(yytext()); return symbol(Add1, yytext());}
	"--" 				{imprimirToken(yytext()); return symbol(Less1, yytext());}
	">" 				{imprimirToken(yytext()); return symbol(Mayor, yytext());}
	"<" 				{imprimirToken(yytext()); return symbol(Menor, yytext());}
	">=" 				{imprimirToken(yytext()); return symbol(MayorIg, yytext());}
	"<=" 				{imprimirToken(yytext()); return symbol(MenorIg, yytext());}
	"==" 				{imprimirToken(yytext()); return symbol(Igual, yytext());}
	"=!" 				{imprimirToken(yytext()); return symbol(Diferente, yytext());}
	"||" 				{imprimirToken(yytext()); return symbol(Or, yytext());}
	"&&" 				{imprimirToken(yytext()); return symbol(And, yytext());}
	"!!" 				{imprimirToken(yytext()); return symbol(Not, yytext());}
	":=" 				{imprimirToken(yytext()); return symbol(Asignacion, yytext());}
	";" 				{imprimirToken(yytext()); return symbol(EndCom, yytext());}
	"[" 				{imprimirToken(yytext()); return symbol(CorAbierto, yytext());}
	"]" 				{imprimirToken(yytext()); return symbol(CorCerrado, yytext());}
	"(" 				{imprimirToken(yytext()); return symbol(ParAbierto, yytext());}
	")" 				{imprimirToken(yytext()); return symbol(ParCerrado, yytext());}
	"," 				{imprimirToken(yytext()); return symbol(Coma, yytext());}
	"SI" 				{imprimirToken(yytext()); return symbol(Si_SC, yytext());}
	"SI_NOSI" 			{imprimirToken(yytext()); return symbol(Si_NoSi_SC, yytext());}
	"SINO" 				{imprimirToken(yytext()); return symbol(SiNo_SC, yytext());}
	"MIENTRAS" 			{imprimirToken(yytext()); return symbol(Mientras_SC, yytext());}
	"HACER" 			{imprimirToken(yytext()); return symbol(Hacer_SC, yytext());}
	"DESDE" 			{imprimirToken(yytext()); return symbol(Desde_SC, yytext());}
	"HASTA" 			{imprimirToken(yytext()); return symbol(Hasta_SC, yytext());}
	"INCREMENTO" 		{imprimirToken(yytext()); return symbol(Incremento_SC, yytext());}
	"imprimir" 			{imprimirToken(yytext()); return symbol(Imprimir, yytext());}
	{Comment} 			{imprimirToken(yytext()); return symbol(Comment, yytext()); painting.appendCGreen(yytext(),panel);}
	{boolID}		 	{imprimirToken(yytext()); return symbol(Boolean, yytext());}
	{entero} 			{imprimirToken(yytext()); return symbol(Entero, yytext());}
	{decimal} 			{imprimirToken(yytext()); return symbol(Decimal, yytext());}
	{cadena} 			{imprimirToken(yytext()); return symbol(Cadena, yytext());}
	{identificador} 	{imprimirToken(yytext()); return symbol(Identificador, yytext());}
	{WhiteSpace} 		{/*Nothing to do*/}
	{LineTerminator} 	{/*Nothing to do*/}
}

[^] {error("Simbolo invalido <"+ yytext()+">");}
<<EOF>>                 { return symbol(EOF); }