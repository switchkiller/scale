package CommentFilter;

class Main {
    public static void main(String[] args) {
        Rule emoticonRule = new EmoticonRuleImpl(new String[]{"word1", "word2", "word3"});
        Rule abusiveRule = new AbusiveRuleImpl(new String[]{"word4", "word5", "word6"});
        Rule banWordRule = new BanRuleImpl(new String[]{"word7", "word8", "word9"});
        Filter filter = new Filter();
        filter.addRule(abusiveRule);
        filter.addRule(banWordRule);
        filter.addRule(emoticonRule);
        Comment comment = new Comment("A B C word7", filter);
        System.out.println(comment.isValid());
    }
}
