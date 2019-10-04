package CommentFilter;

class AbusiveRuleImpl extends Rule{
    String[] words;
    AbusiveRuleImpl(String[] strings){
        words = strings;
    }

    @Override
    void addWordToDictionary() {
        for(String word : words){
            Rule.words.addElement(word);
        }
    }
}
