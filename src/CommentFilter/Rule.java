package CommentFilter;

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
        return (words.contains(str));
    }
}
