package CommentFilter;

import java.util.Scanner;
import java.util.Vector;

abstract class Rule {
    protected static Vector<String> words;

    Rule(){
        words = new Vector<>();
    }

    boolean match(String str){
        for(String string : words){
            System.out.println(string);
        }
        Scanner tokenize = new Scanner(str);
        while(tokenize.hasNext()){
            if (words.contains(tokenize.next()))
                return true;
        }
        return false;
    }
}
