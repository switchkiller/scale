package CommentFilter;

import java.util.Vector;

class Rule {
    private Vector<String> words;

    Rule(){
        words = new Vector<>();
    }

    boolean match(String str){
        return  (words.contains(str));
    }

    void addWord(String str){
        words.addElement(str);
    }
}
