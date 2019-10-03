package CommentFilter;

class BanWordDetectorRule extends Rule{
    BanWordDetectorRule(String str){
        addWord(str);
    }
}
