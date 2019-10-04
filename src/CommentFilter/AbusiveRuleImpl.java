package CommentFilter;

class AbusiveRuleImpl extends Rule{
    AbusiveRuleImpl(String[] strings){
        for (String string: strings) {
            words.addElement(string);
        }
    }
}
