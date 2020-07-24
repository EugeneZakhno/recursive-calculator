package io.github.euegenezakhno;

public class Runner {


     /*------------------------------------------------------------------
     * PARSER RULES
     *------------------------------------------------------------------*/

//    expr : plusminus* EOF ;
//
//    plusminus: multdiv ( ( '+' | '-' ) multdiv )* ;
//
//    multdiv : factor ( ( '*' | '/' ) factor )* ; если компилятор встречает умножение или деление, то выполняет действие после скобок вторым
//
//    factor : NUMBER | '(' expr ')' ;  если компилятор встречает число или скобку, то выполняет действие первым, причем ижет скобки парные


  //    NUMBER | '(' expr ')'     ( ( '*' | '/' )   NUMBER | '(' expr ')' ) *

    public static void main(String[] args) {
        String expressionText = "22 + 3 - 2 * (2 * 5 + 2) * 4";
    }

    public  enum LexemeType {
        LEFT_BRACKET, RIGHT_BRACKET,
        OP_PLUS, OP_MINUS,
        OP_MUL, OP_DIV,
        NUMBER,
        EOF; // END OF FILAMENT - КОНЕЦ СТРОКИ (НИТИ, ВОЛОКНАБ ВОЛОСКА)
    }

}
