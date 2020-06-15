package regEx;

import SetClasses.UniqueSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IpRegex {

    public static void main(String[] args) {
        
        Pattern pattern = Pattern.compile("((\\d{1,3}\\.){3}(\\d{1,3}))");
        Matcher matcher;
        UniqueSet us = new UniqueSet();
        //SimpleReader f = new SimpleReader("log-small.txt"); //small file ips: 13
        SimpleReader f = new SimpleReader("log-large.txt"); //large file ips: 3701
        
        String s = f.readLine();
        while (s != null) {
            matcher = pattern.matcher(s);
            while (matcher.find()) {
                if (!matcher.group(1).equals("127.0.0.1")) {
                    us.add(matcher.group(1));
                }
            }
            s = f.readLine();
        }
        f.close();

        System.out.println("Numero de Ips distintos encontrados: " + us.size());
    }
    
}
