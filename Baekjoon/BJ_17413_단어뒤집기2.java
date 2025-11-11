package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_17413_단어뒤집기2 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();

    StringBuilder sb = new StringBuilder();
    StringBuilder word = new StringBuilder();
    boolean inTag = false;

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);

      if (c == '<') {
        sb.append(word.reverse());
        word.setLength(0);

        inTag = true;
        sb.append(c);
      } else if (c == '>') {
        inTag = false;
        sb.append(c);
      } else if (inTag) {
        sb.append(c);
      } else {
        if (c == ' ') {
          sb.append(word.reverse());
          word.setLength(0);
          sb.append(' ');
        } else {
          word.append(c);
        }
      }
    }
    sb.append(word.reverse());
    System.out.println(sb);
  }
}
