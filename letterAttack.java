//Lab 3
//java letter frequency attack
//C18302166
//12/10/2021

import java.util.*;

public class letterAttack{

    public static void main(String[] args){
    // sample ciphertext
    String S = "PB QDPH LV PLFKDHO WHQQBVRQ";
    int N = S.length();
    printString(S, N);

}

public static void printString(String S, int N){
    //plaintext string array
    String []plaintext = new String[5];
    int freq[] = new int[26];
    int freqSorted[] = new int[26];

    int Used[] = new int[26];
    for (int i = 0; i < N; i++) {
        if (S.charAt(i) != ' ') {
            freq[S.charAt(i) - 'A']++;
        }
    }

    for (int i = 0; i < 26; i++) {
        freqSorted[i] = freq[i];
    }
    String T = "ETAOINSHRDLCUMWFGYPBVKJXQZ";
    Arrays.sort(freqSorted);
    freqSorted= reverse(freqSorted);
    // Itearate over the range 0-5
    for (int i = 0; i < 5; i++) {

        int ch = -1;
        // Iterate over the range 0-26
        for (int j = 0; j < 26; j++) {

            if (freqSorted[i] == freq[j] && Used[j] == 0) {
                Used[j] = 1;
                ch = j;
                break;
            }
        }
        if (ch == -1)
            break;
        int x = T.charAt(i) - 'A';

        x = x - ch;
        String curr = "";
        for (int k = 0; k < N; k++) {
            if (S.charAt(k) == ' ') {
                curr += (char)' ';
                continue;
            }
            int y = S.charAt(k) - 'A';
            y += x;

            if (y < 0){
                y += 26;
            }
            if (y > 25){
                y -= 26;
            }
            curr += (char)('A' + y);
        }
        plaintext[i] = curr;
    }
    // loop that prints 5 possible plaintexts
    for (int i = 0; i < 5; i++) {
        System.out.print(plaintext[i] +"\n");
    }
}
static int[] reverse(int a[]) {
    int i, n = a.length, t;
    for (i = 0; i < n / 2; i++) {
        t = a[i];
        a[i] = a[n - i - 1];
        a[n - i - 1] = t;
    }
    return a;
}

}


