package CommentFilter;

public class EmoticonRuleImpl extends Rule {
    String[] words;
    EmoticonRuleImpl(String[] strings){
        words = strings;
    }

    @Override
    void addWordToDictionary() {
        for(String word : words){
            Rule.words.addElement(word);
        }
    }
}
