/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SetClasses.tests;

import SetClasses.UniqueSet;

/**
 *
 * @author helimar.baggattini
 */
public class UStest {
    
    public static void main(String[] args) {
        
        UniqueSet ss1 = new UniqueSet();
        ss1.add("java");
        ss1.add("go");
        
        UniqueSet ss2 = new UniqueSet();
        ss2.add("java");
        ss2.add("python");
        
        UniqueSet ss3 = ss1.union(ss2);

        //automated Tests
        if(!ss3.toString().equals("[go, java, python]")){
            System.out.println("fail 1");
        }
        
        UniqueSet ss4 = new UniqueSet();
        ss4.add("c++");
        ss4.add("c#");
        
        UniqueSet ss6 = ss3.union(ss4);
        
        //automated Tests
        if(!ss6.toString().equals("[c#, c++, go, java, python]")){
            System.out.println("fail 2");
        }
        
        //automated Tests
        if(!ss6.intersection(ss4).toString().equals("[c#, c++]")){
            System.out.println("fail 3");
        }
        
        //automated Tests
        if(!ss6.difference(ss4).toString().equals("[go, java, python]")){
            System.out.println("fail 4");
        }
        
        //automated Tests
        if(!ss4.difference(ss6).toString().equals("[]")){
            System.out.println("fail 5");
        }
        
        ss6.removeAll(ss4);
        
        if(!ss6.toString().equals("[go, java, python]")){
            System.out.println("fail 6");
        }

    }
    
}
