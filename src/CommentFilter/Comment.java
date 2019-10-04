package CommentFilter;

class Comment {
    private String userComment;
    private Filter filter;

    Comment(String comment, Filter filter){
        userComment = comment;
        this.filter = filter;
    }

    boolean isValid(){
        return filter.isValid(userComment);
    }
}
