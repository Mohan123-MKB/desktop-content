import java.util.*;
public class StringQn{
    //reverse string
    static String rev(String s){
        String r="";
        for(char c:s.toCharArray()){
            r =c+r;
        }
        return r;
    }
    //check palindrome
    static boolean palindrome(String s){
        String ori=s;
        String rev="";
         for(char ch:s.toCharArray()){
            rev =ch+rev;
        }
        if(ori.equals(rev)){
            return true;
        }
        return false;
    }
    //count vowels and consonants
    static void countVowelsConsonants(String s){
        int v=0,c=0;
        for(char ch:s.toLowerCase().toCharArray()){
            if(Character.isLetter(ch)){
                if("aeiou".indexOf(ch) !=-1){
                    v++;
                }
                c++;
            }
        }
        System.out.println("vowels: "+v+" "+"consonants: "+c);
    }
    //remove duplicates
    static String removeDuplicates(String s){
        StringBuilder res=new StringBuilder();
        for(char ch:s.toCharArray()){
            if(res.indexOf(String.valueOf(ch))==-1){
                res.append(ch);
            }
        }
        return res.toString();
    }
    
    public static void main(String ar[]){
        System.out.println(rev("balaji hi"));
        System.out.println(palindrome("MADAM"));
        countVowelsConsonants("applesOrange");
        System.out.println(removeDuplicates("aapplle"));
        
    }

}