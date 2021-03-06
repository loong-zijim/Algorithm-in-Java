/*

Parenthesis 圆括号 /pə'rɛnθəsɪs/
给出N对括号，返回它的permutations

N = 3, all valid permutations are ["((()))", "(()())", "(())()", "()(())", "()()()"]

 */

/*
k = 2
cur[,,,]

             xhelper(cur[,,,], 2, 2, 0, [])    
                       /  r[(()),()()]                      
            left>0                            
            cur[(,,,]
            helper(cur[(,,,], 1, 2, [])
                / r[(())]               \ r[(()),()()]
        left = 1 > 0                   right = 2 > 0      
        cur[(,(,,]                     cur[(,),,]
        helper(cur[(,(,,], 0, 2, [])   helper(cur[(,),,], 1, 1, r[(())])
        / r[(())]                                     / r[(()),()()]
   left = 0 !>                                  left = 1 > 0
   right > 0                                    cur[(,),(,]
   cur[(,(,),]                                  helper(cur[(,),(,], 0, 1, r[(())]) 
   helper(cur[(,(,),], 0, 1, [])                      \ r[(()),()()]
    \ r[(())]                                      left = 0 
  left = 0                                         right = 1 > 0
  right > 0                                        cur[(,),(,)]
  cur[(,(,),)]                                     helper(cur[(,),(,)], 0, 0, r[(())]) 
  helper(cur[(,(,),)], 0, 0, [])                            |  r[(()),()()]
        |                                               r[(()),()()] 
    r[(())]
   
        
                                                        output: r[(()),()()]
*/


import java.util.*;

public class PermutationsParenthesis1 {
    public List<String> perenthesis(int k) {
        List<String> result = new ArrayList<String>();
        // 最后的字符串会有2*k个字符，因为括号是一对的
        char[] cur = new char[k*2];
        helper(cur, k, k, 0, result);
        return result;
    }

    // left: 我地种有多少个"("
    // right: 我地种有多少个")"
    // index: 在cur字符数组目前的位置，我地会用"("或者")"去填充

    private void helper(char[] cur, int left, int right, int index, List<String> result) {
        // 中止：当我地冇剩余的括号时候
        if (left == 0 && right == 0) {
            result.add(new String(cur));
            return;
        }
        
        // 当我地添加"("，种有多少"("可以用
        if (left > 0) {
            cur[index] = '(';
            helper(cur, left - 1, right, index + 1, result);
        }

        if (right > left) {      // 剩下的右括号必须比左边多
            cur[index] = ')';
            helper(cur, left, right - 1, index + 1, result);
        }   
    }
    
    public static void main(String[] args) {
        PermutationsParenthesis1 pe = new PermutationsParenthesis1();
        System.out.println(pe.perenthesis(3));
        System.out.println(pe.perenthesis(2));
    }
}
