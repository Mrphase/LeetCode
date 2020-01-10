package AmazonOA2;
import java.util.*;
public class SlidWindow_String_PrintAll {
    public static void main(String[] args) {
        System.out.println(substringsWithKDistinctChars("pqpqs",2));
    }
    public static int substringsWithKDistinctChars(String s, int k)
{
    int index = 0;
    int hi = 0, lo = 0;
    int[] ch = new int[26];
    int[] forIndex = new int[26];
    int sum = 0;
    int count = 0;
    int countForIndex = 0;
    int flag = 0;
    // An edge case where k is bigger than s.length is not tested here

    for(int i = 0; i < s.length(); i++)
    {
        if(flag == 0)
        {
            ch[s.charAt(i) - 'a']++;
            if(ch[s.charAt(i) - 'a'] == 1)
                count++;
        }
        flag = 0;
        if(count < k)
            continue;
        else if(count == k)
        {
            for(int j = 0; j < ch.length; j++)
                forIndex[j] = ch[j];
            countForIndex = count;
            index = lo;
            while(countForIndex == k)
            {
                if(forIndex[s.charAt(index) - 'a'] == 1)
                    countForIndex--; // Equivalent to break (supposed to be)
                else
                {
                    forIndex[s.charAt(index) - 'a']--;
                    index++;
                }
            }
            sum = sum + index - lo + 1;
        }
        else // count > k
        {
            flag = 1;
            while(count > k)
            {
                ch[s.charAt(lo) - 'a']--;
                if(ch[s.charAt(lo) - 'a'] == 0)
                    count--;
                lo++;
            }
            i--;
        }
    }
    return sum;
}
}
