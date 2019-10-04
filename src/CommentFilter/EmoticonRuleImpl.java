package CommentFilter;

public class EmoticonRuleImpl extends Rule {

    EmoticonRuleImpl(String[] strings){
        for (String string : strings) {
            words.addElement(string);
        }
    }

}
