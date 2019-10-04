package CommentFilter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Vector;

public class EmoticonRuleImpl extends Rule {

    EmoticonRuleImpl(String[] strings){
        for (String string : strings) {
            words.addElement(string);
        }
    }

}
