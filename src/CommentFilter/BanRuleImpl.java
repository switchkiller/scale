package CommentFilter;

class BanRuleImpl extends Rule{
    String[] words;
    BanRuleImpl(String[] strings){
        words = strings;
    }

    @Override
    void addWordToDictionary() {
        for(String word : words){
            Rule.words.addElement(word);
        }
    }
}
