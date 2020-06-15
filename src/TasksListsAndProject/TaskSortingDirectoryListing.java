/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TasksListsAndProject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author 1511 FOX
 */
public class TaskSortingDirectoryListing {

    public static void main(String[] args) {

        //Listing l = new Listing("C:\\Users\\1511 FOX\\Desktop\\musicas\\Imagine Dragons - Origins (Deluxe)");
        Listing l = new Listing("C:\\Users\\1511 FOX\\Desktop\\prob");

        //listing  by size
        System.out.println("By size\n");
        l.listBySize();
        
        //listing by date
        System.out.println("\n\nBy Date(lastModified)\n");
        l.listByDate();
        
        //listing by name
        System.out.println("\n\nBy name\n");
        l.listByName();
        
    }

    
    //Listing classs
    public static class Listing {

        private File folder;
        public String path;
        

        public Listing(String path) {
            this.path = path;
        }

        //list by size
        public void listBySize() {
            this.folder = new File(this.path);
            
            //get files from dir
            List<File> arch = new ArrayList<>();
            arch.addAll(Arrays.asList(folder.listFiles()));

            //sorting
            Collections.sort(arch, new SortBySize());
            
            //print
            for(File f: arch){
                System.out.println(f.length()/1024 + " kb \t " + f.getName());
            }

        }

        //list by date
        public void listByDate() {
            this.folder = new File(this.path);
            
            //date formater
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            
            //get Files from dir
            List<File> arch = new ArrayList<>();
            arch.addAll(Arrays.asList(folder.listFiles()));

            //sorting 
            Collections.sort(arch, new SortByDate());

            //print
            for (File f: arch){
                System.out.println(sdf.format(new Date(f.lastModified())) + " \t " + f.getName());
            }
        }

        //list by name
        public void listByName() {

            try (Stream<Path> walk = Files.walk(Paths.get(this.path))) {

                List<String> result = walk.filter(Files::isRegularFile)
                        .map(x -> x.getFileName().toString()).collect(Collectors.toList());

                result.forEach(System.out::println);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    
    //class sort by size
    public static class SortBySize implements Comparator<File>{

        @Override
        public int compare(File f1, File f2) {
            if(f1.length() != f2.length()){
                return (int)(long)(f1.length() - f2.length());
            }else{
                return f1.compareTo(f2);
            }
        }
        
    }
    
    
    //class sort by size
    public static class SortByDate implements Comparator<File>{

        @Override
        public int compare(File f1, File f2) {
            return (int)(long)(f1.lastModified() - f2.lastModified());
        }
        
    }
 
}
