package CommentFilter;

class Main {
    public static void main(String[] args) {
        Rule abusiveRule = new AbusiveDetectorRule("not");
        Rule banWordRule = new BanWordDetectorRule("okay");
        Filter filter = new Filter();
        filter.addRule(abusiveRule);
        filter.addRule(banWordRule);
        Comment comment = new Comment("okay", filter);
        System.out.println(comment.isValid());
    }
}
