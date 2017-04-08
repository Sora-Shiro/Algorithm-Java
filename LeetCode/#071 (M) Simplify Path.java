/*
Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"

Corner Cases:
Did you consider the case where path = "/../"?
In this case, you should return "/".
Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
In this case, you should ignore redundant slashes and return "/home/foo".
 */

public class Solution {
    public String simplifyPath(String path) {
        char[] paths = (path+'/').toCharArray();
        StringBuilder sb = new StringBuilder();
        List<String> list = new LinkedList<>();
        for(char c : paths) {
            if(c != '/') {
                sb.append(c);
            } else if (sb.length() != 0){
                String test = sb.toString();
                if(test.equals("..")) {
                    if(list.size() != 0) list.remove(list.size()-1);
                } else if(!test.equals(".")){
                    list.add(test);
                }
                sb.delete(0, sb.length());
            }
        }
        for(String p : list) {
            sb.append('/');
            sb.append(p);
        }
        if(sb.length() == 0) return "/";
        return sb.toString();
    }
}