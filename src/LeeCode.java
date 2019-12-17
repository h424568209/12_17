import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LeeCode {
    /**
     *
     * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置
     * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
     *
     *
     * 直接的思路，判断每个子串是否符合，符合就把下标保存起来，最后返回即可
     * @param s 字符串
     * @param words 长度相同的单词的集合
     * @return 所有能串联的起始位置
     */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        int wordNum = words.length;
        if(wordNum == 0){
            return res;
        }
        int worldlen = words[0].length();
        //保存所有的单词在map1
        //单词--出现的次数对
        HashMap<String ,Integer> allWords = new HashMap<>();
        for(String w:words){
            int val = allWords.getOrDefault(w,0);
            allWords.put(w,val+1);
        }
        //遍历所有子串
        for(int i = 0 ; i < s.length() -wordNum*worldlen+1; i++){
            HashMap<String ,Integer> haswords = new HashMap<>();
            int num = 0;
            //判断该子串是否符合
            while(num < wordNum){
                String word = s.substring(i+num*worldlen,i+(num+1)*worldlen);
                //判断该单词在map1中
                if(allWords.containsKey(word)){
                    int val = haswords.getOrDefault(word,0);
                    haswords.put(word,val+1);
                    //判断当前的单词的val和map1中的val
                    if(haswords.get(word) > allWords.get(word)){
                        break;
                    }
                }else{
                    break;
                }
                num++;
            }
            //判断是不是所有的单词都符合
            if(num == wordNum)
                res.add(i);
        }
        return res;
    }
    public static void main(String[] args) {
        String s = "fooabbsfooabb";
        String []words = {"foo","abb"};
        LeeCode l  = new LeeCode();
        System.out.println(l.findSubstring(s,words));
    }
}
