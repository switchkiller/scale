package CommentFilter;

class BanRuleImpl extends Rule{
    BanRuleImpl(String[] strings){
        for (String string:strings) {
            words.addElement(string);
        }
    }
}
