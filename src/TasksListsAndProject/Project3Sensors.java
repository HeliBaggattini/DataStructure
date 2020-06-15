/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TasksListsAndProject;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import utilities.SimpleReader;

/**
 *
 * @author 1511 FOX
 */

/*
    Centrals
    Alpha=0.4926,0.6989; 
    Bravo=0.1253,0.6775; 
    Charlie=0.8014,0.6313; 
    Delta=0.4458,0.2681; 
    Echo=0.4092,0.0431; 
    Foxtrot=0.6645,0.4028; 
    Golf=0.6751,0.8003; 
    Hotel=0.4298,0.6014; 
    India=0.4371,0.9866; 
    Juliet=0.5729,0.1587.
 */
public class Project3Sensors {

    //central aux class
    public static class Central {

        String name;
        double x;
        double y;

        public Central(String name, double x, double y) {
            this.name = name;
            this.x = x;
            this.y = y;
        }

        public boolean isInRange(Sensor sensor) {
            boolean ok = false;

            double distance = Math.sqrt(Math.pow((sensor.x - this.x), 2) + Math.pow((sensor.y - this.y), 2));

            if (distance <= 0.25) {
                ok = true;
            }

            return ok;
        }

    }

    //sensor aux class
    public static class Sensor {

        double x;
        double y;

        public Sensor(double x, double y) {
            this.x = x;
            this.y = y;
        }

    }

    //generates a map with the central's position, its ranges and the location of the sensors
    public static void generateMap(ArrayList<Central> centrals, Map<Sensor, ArrayList<Central>> sensors) {
        int width = 1000;
        int height = 1000;

        //Construction of the BufferedImage
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        //drawing component
        Graphics2D g2d = bufferedImage.createGraphics();

        //filling the image background with white
        g2d.setColor(Color.white);
        g2d.fillRect(0, 0, width, height);

        //creating the central range area
        for (Central c : centrals) {
            //create a circle with green
            g2d.setColor(new Color(43, (int) (Math.random() * 171) + 70, 19));
            g2d.fillOval((int) (c.x * 1000) - 250, (int) (c.y * 1000) - 250, 500, 500);
        }

        //creating the central position
        for (Central c : centrals) {
            //create a circle with black
            g2d.setColor(Color.black);
            g2d.fillOval((int) (c.x * 1000) - 5, (int) (c.y * 1000) - 5, 10, 10);
            //create a string with blue
            g2d.setColor(Color.blue);
            g2d.drawString(c.name, (int) (c.x * 1000) - 5, (int) (c.y * 1000) - 5);
        }

        //marking the sersor positions
        sensors.keySet().forEach((sens) -> {
            // create a circle with black
            g2d.setColor(Color.red);
            g2d.fillRect((int) (sens.x * 1000) - 1, (int) (sens.y * 1000) - 1, 2, 2);
        });

        //closing the drawing component
        g2d.dispose();

        //Saving image as PNG
        File file = new File("Map.png");
        try {
            ImageIO.write(bufferedImage, "png", file);
        } catch (IOException ex) {
            Logger.getLogger(Project3Sensors.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        //centrals
        ArrayList<Central> centrals = new ArrayList<>();
        centrals.add(new Central("Alpha", 0.4926, 0.6989));
        centrals.add(new Central("Bravo", 0.1253, 0.6775));
        centrals.add(new Central("Charlie", 0.8014, 0.6313));
        centrals.add(new Central("Delta", 0.4458, 0.2681));
        centrals.add(new Central("Echo", 0.4092, 0.0431));
        centrals.add(new Central("Foxtrot", 0.6645, 0.4028));
        centrals.add(new Central("Golf", 0.6751, 0.8003));
        centrals.add(new Central("Hotel", 0.4298, 0.6014));
        centrals.add(new Central("India", 0.4371, 0.9866));
        centrals.add(new Central("Juliet", 0.5729, 0.1587));

        //reader
        SimpleReader sr = new SimpleReader("sensors.txt");

        //Dictionary
        Map<Sensor, ArrayList<Central>> sensorMap = new HashMap<>();

        //reading sensors
        String s = sr.readLine();
        while (s != null) {
            sensorMap.put(new Sensor(
                    Double.parseDouble(s.substring(0, 6)),
                    Double.parseDouble(s.substring(7, 13))),
                    new ArrayList<Central>());
            s = sr.readLine();
        }
        sr.close();

        //verifaing sensor in range of central
        sensorMap.keySet().forEach((sens) -> {
            for (Central c : centrals) {
                if (c.isInRange(sens)) {
                    sensorMap.get(sens).add(c);
                }
            }
        });

        //generate plot
        generateMap(centrals, sensorMap);

        //print list of sensors ordered by Centrals in range using java 8 sintax
        System.out.println("x\t y\t n. centrais");
        sensorMap.
                entrySet().
                stream().
                sorted(Map.Entry.comparingByValue((o1, o2) -> {
                    return o1.size() - o2.size();
                })).
                forEach(entry -> {
                    System.out.print(entry.getKey().x + "\t" + entry.getKey().y + "\t" + entry.getValue().size() + "\t(");
                    for (Central cent : entry.getValue()) {
                        System.out.print(cent.name + ";");
                    }
                    System.out.println(")");
                });
        System.out.println("\n");

        //data from sensors map
        AtomicInteger inRange = new AtomicInteger(0);
        AtomicInteger outOfRange = new AtomicInteger(0);
        Map<Central, Integer> sensPerCentral = new HashMap();

        //processing info from sensors map using java 8 sintax
        sensorMap.entrySet().forEach((entry) -> {
            if (entry.getValue().size() >= 1) {
                inRange.getAndIncrement();
            }
            if (entry.getValue().isEmpty()) {
                outOfRange.getAndIncrement();
            }
            if (entry.getValue().size() == 1) {
                if (!sensPerCentral.containsKey(entry.getValue().get(0))) {
                    sensPerCentral.put(entry.getValue().get(0), 1);
                } else {
                    sensPerCentral.put(entry.getValue().get(0), sensPerCentral.get(entry.getValue().get(0)) + 1);
                }
            }
        });

        //printing data obtained from sensors map data
        System.out.println("Quantidade total de sensores: " + (outOfRange.get() + inRange.get()));
        System.out.println("Sensores sem Cobertura: " + outOfRange);
        System.out.println("Sensores com Cobertura(1 Central ou +): " + inRange);
        System.out.println("Quantidade de sensores cobertos por apenas uma Central(Por Central): ");
        sensPerCentral.entrySet().stream().
                sorted(Map.Entry.comparingByValue((o1, o2) -> {
                    return o1 - o2;
                })).forEach(entry -> System.out.println("\t" + entry.getKey().name + ": " + entry.getValue()));
        
    }

}
