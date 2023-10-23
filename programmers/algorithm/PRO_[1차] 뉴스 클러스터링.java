// 대문자와 소문자 차이는 무시한다. -> 대문자 또는 소문자로 전부 변환
// 다중집합 원소로 변경해서 저장 -> 공백이나 숫자, 특수문자가 있을 경우 버린다.
// 중복이 있을 수 있기 때문에 str1, str2 따로 다중집합 원소를 list에 저장


import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        double answer = 0;

        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<String> intersection = new ArrayList<>();
        List<String> union = new ArrayList<>();
        // 소문자로 변환
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        // 각 문자열 다중집합 원소 list1, list2에 저장
        for(int i = 0 ; i < str1.length() - 1 ; ++i){
            char c1 = str1.charAt(i);
            char c2 = str1.charAt(i + 1);

            if(c1 >= 'a' && c1 <= 'z' && c2 >= 'a' && c2 <= 'z'){
                list1.add(str1.substring(i, i + 2));
            }
        }
        for(int i = 0 ; i < str2.length() - 1 ; ++i){
            char c1 = str2.charAt(i);
            char c2 = str2.charAt(i + 1);

            if(c1 >= 'a' && c1 <= 'z' && c2 >= 'a' && c2 <= 'z'){
                list2.add(str2.substring(i, i + 2));
            }
        }
        
        for(String str : list1) {
            // 교집합
            if(list2.remove(str)) {
                intersection.add(str);
            }
            // 합집합 -> list1을 합집합list에 추가
            union.add(str);
        }
        
        // 합집합 완성 -> 기존 list2에서 list1의 교집합을 제거한 부분을 합집합에 추가
        for(String str : list2) {
            union.add(str);
        }
        // 0으로 나눌 경우 ArithmeticException발생 합집합이 0이면 answer를 1로 설정
        if(union.size() == 0) {
            answer = 1;
        }else {
            answer = (double)intersection.size() / (double)union.size(); 
        }
        return (int)(answer * 65536);

    }
}
