/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regEx;

public class TestSimpleReader {
    public static void main(String[] args) {
        SimpleReader f = new SimpleReader("log-small.txt");
        int i = 1;
        String s = f.readLine();
        while (s != null) {
            System.out.println(i + ": " + s);
            i++;
            s = f.readLine();
        }
        f.close();
    }
}

