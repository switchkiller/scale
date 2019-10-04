package CommentFilter;

import java.util.Vector;

class Filter {
    private Vector<Rule> rules;

    Filter(){
        rules = new Vector<>();
    }

    public void addRule(Rule rule){
        rules.addElement(rule);
        rule.addWordToDictionary();
    }

    public boolean isValid(String str){
        for (int i = 0; i < rules.size(); i++){
            Rule newRule = rules.get(i);
            if (newRule.match(str)) return false;
        }
        return true;
    }

}
