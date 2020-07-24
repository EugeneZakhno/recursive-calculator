package io.github.euegenezakhno;

import java.util.ArrayList;
import java.util.List;

public class Runner {
     /*------------------------------------------------------------------
     * PARSER RULES
     *------------------------------------------------------------------*/
//    expr : plusminus* EOF ;
//    plusminus: multdiv ( ( '+' | '-' ) multdiv )* ;
//    multdiv : factor ( ( '*' | '/' ) factor )* ; если компилятор встречает умножение или деление, то выполняет действие после скобок вторым
//    factor : NUMBER | '(' expr ')' ;  если компилятор встречает число или скобку, то выполняет действие первым, причем ижет скобки парные
//    NUMBER | '(' expr ')'     ( ( '*' | '/' )   NUMBER | '(' expr ')' ) *

    public static void main(String[] args) {
        String expressionText = "22 + 3 - 2 * (2 * 5 + 2) * 4";
    }

    public  enum LexemeType {
        LEFT_BRACKET,     //    (
        RIGHT_BRACKET,    //    )
        OP_PLUS,          //    +
        OP_MINUS,         //    -
        OP_MUL,           //    *
        OP_DIV,           //    /
        NUMBER,           // ...  -11  -10  - 9 ...  0  1  2 3 4 5 6 7 8 9 10 11 12 ...
        EOF;              //  END OF FILAMENT - КОНЕЦ СТРОКИ (НИТИ, ВОЛОКНАБ ВОЛОСКА)
    }

    // This class imagine lexemes, means how it's introduces in text.
    public static class Lexeme {

        LexemeType type;
        String value;

        public Lexeme(LexemeType type, String value) {
            this.type = type;
            this.value = value;
        }
        public Lexeme(LexemeType type, Character value) {
            this.type = type;
            this.value = value.toString();
        }

        // Now lets write method for lexical analise
        public static List<Lexeme> LexAnalise (String expText){
            ArrayList<Lexeme> lexemes  = new ArrayList<>();
            int pos = 0;
            while (pos < expText.length()) {
                char c  = expText.charAt(pos);
                switch (c) {
                    case '(':
                        lexemes.add (new Lexeme(LexemeType.LEFT_BRACKET, c));
                        pos++;
                        continue;
                    case ')':
                        lexemes.add(new Lexeme(LexemeType.RIGHT_BRACKET, c));
                        pos++;
                        continue;
                    case '+':
                        lexemes.add(new Lexeme(LexemeType.OP_PLUS, c));
                        pos++;
                        continue;
                    case '-':
                        lexemes.add(new Lexeme(LexemeType.OP_MINUS, c));
                        pos++;
                        continue;
                    case '*':
                        lexemes.add(new Lexeme(LexemeType.OP_MUL, c));
                        pos++;
                        continue;
                    case '/':
                        lexemes.add(new Lexeme(LexemeType.OP_DIV, c));
                        pos++;
                        continue;

                    default:
                        if (c <= '9' && c >= '0' ){
                            StringBuilder sb = new StringBuilder();
                            do {
                                sb.append(c);
                                pos++;
                                if (pos >= expText.length()){
                                    break;
                                }
                                c = expText.charAt(pos);
                            } while (c<='9' && c>='0');
                            lexemes.add(new Lexeme(LexemeType.NUMBER, sb.toString()));
            }
        }


    }




}
