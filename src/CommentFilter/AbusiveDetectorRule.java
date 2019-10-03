package CommentFilter;

public class AbusiveDetectorRule extends Rule{
    AbusiveDetectorRule(String str){
        addWord(str);
    }
}
