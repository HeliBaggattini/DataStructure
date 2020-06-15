package SetClasses.tests;

import SetClasses.SimpleSet;


public class SStest {
    public static void main(String[] args) {
        SimpleSet ss = new SimpleSet();        
        ss.add("a");
        ss.add("b");
        ss.add("c");
        
        SimpleSet ss2 = new SimpleSet();
        ss2.add("c");
        ss2.add("b");
        ss2.add("a");
        
        System.out.println(ss);
        System.out.println(ss2);
        System.out.println(ss2.size());
        System.out.println(ss.equals(ss2));
        
    }
}
