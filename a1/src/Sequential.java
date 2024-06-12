import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

public class Sequential {
   static long start_time;

   /**
    * set the start time
    */
   private static void tick() {
      start_time = System.currentTimeMillis();
   }

   /**
    * @return time elapsed since process started
    */
   private static float tock() {
      return (System.currentTimeMillis() - start_time) / 1000.0f;
   }

   /**
    * method to return number of basins found in the terrain
    *
    * @param grid
    * @return
    */
   private static int basinFinder(float[][] grid) {
      boolean basin = false;
      float cut = (float) 0.01;
      int number_of_basins = 0;
      //exclude last row ,last column,first row and first column in your basin checks as they are non-basins
      for (int y = 1; y < grid.length - 1; y++) {
         for (int x = 1; x < grid[0].length - 1; x++) {
            Float height = grid[y][x] + cut;
            float a, b, d, e, f, g, h, i;
            a = grid[y][x + 1];
            b = grid[y + 1][x];
            d = grid[y + 1][x + 1];
            e = grid[y][x - 1];
            f = grid[y + 1][x - 1];
            g = grid[y - 1][x + 1];
            h = grid[y - 1][x - 1];
            i = grid[y - 1][x];
            if (((a >= height) & (b >= height)) & (d >= height)) {
               if ((e >= height) & (f >= height)) {
                  if (((g >= height) & (h >= height)) & (i >= height)) {
                     basin = true;
                  }
               }
            }
            if (basin == true) {
               number_of_basins += 1;
            }
            basin = false;
         }
      }
      return number_of_basins;
   }

   /**
    * method to return all basins found in the grid as an ArrayList
    *
    * @param grid
    * @return
    */
   private static ArrayList<String> allBasins(float[][] grid) {
      boolean basin = false;
      float cut = (float) 0.01;
      ArrayList<String> basin_point = new ArrayList<String>();
      //exclude last row ,last column,first row and first column in your basin check as they are non basins
      for (int y = 1; y < grid.length - 1; y++) {
         for (int x = 1; x < grid[0].length - 1; x++) {
            String point = y + " " + x;
            Float height = grid[y][x] + cut;
         
            if (((grid[y - 1][x - 1] >= height) & (grid[y - 1][x] >= height)) & (grid[y - 1][x + 1] >= height)) {
               if ((grid[y][x - 1] >= height) & (grid[y][x + 1] >= height)) {
                  if (((grid[y + 1][x - 1] >= height) & (grid[y + 1][x] >= height)) & (grid[y + 1][x + 1] >= height)) {
                     basin = true;
                  }
               }
            }
            if (basin == true) {
               basin_point.add(point);
            }
            basin = false;
         }
      }
      return basin_point;
   }

   /**
    * main method used to populate the graph using file contents
    * call tick() and tock() methods to calculate time difference and write the times to a txt file
    * call allBasins() method to display coordinates of all basins in grid terrain
    * call basinFinder() method to count how many basins are in the grid terrain
    *
    * @param args
    * @throws IOException
    */
   public static void main(String[] args) throws IOException {
      FileReader file = new FileReader(args[0]);
      String line;
      Terrain t = null;
      try {
         BufferedReader reader = new BufferedReader(file);
         line = reader.readLine();
         String[] row_column = line.split(" ");
         int r = Integer.valueOf(row_column[0]);
         int c = Integer.valueOf(row_column[1]);
         int y_axis = 0, x_axis = 0;
         t = new Terrain(r, c);
         String[] heights = null;
      
         /**
          * populating the Grid terrain
          */
         while ((line = reader.readLine()) != null) {
            heights = line.split(" ");
            for (String x : heights) {
               if (x_axis >= c) {
                  y_axis++;
                  x_axis = 0;
               }
               float height = Float.valueOf(x);
               t.setHeight(x_axis, y_axis, height);
               x_axis++;
            }
         }
      } 
      catch (FileNotFoundException e) {
         e.printStackTrace();
      } 
      catch (IOException e) {
         e.printStackTrace();
      }
      /**
       * find the time elapsed in milliseconds store the results in designated txt files
       * use an iterator find all the coordinates of the basins found in the grid terrain and store them in a txt file
       */
   //      System.gc();
   //      float[][] grid = t.Grid();
   //      tick();
   //      int num_of_basins = basinFinder(grid);
   //      float time = tock();
   //      System.out.println("Run process run took " + time + " seconds");
   //      System.out.println("number of found in grid train basins is: " + num_of_basins);
   
   
      Scanner input = new Scanner(System.in);
      System.out.println("Enter file name for times: ");
      String times_file ="C:\\Users\\Linda\\Desktop\\csc2002\\A1\\src\\results\\sequential\\"+ input.nextLine()+".txt";
      try (
              FileWriter fstream = new FileWriter(times_file);
              BufferedWriter info = new BufferedWriter(fstream)) {
         float sum_time=0;
         float time_passed=0;
         info.write("time elapsed for the 25 find operations :"+"\r\n");
         for (int i = 0; i < 25; i++) {
            System.gc();
            tick();
            int basins = basinFinder(t.Grid());
            time_passed = tock();
            info.write(time_passed + "\r\n");
            sum_time+=time_passed;
         }
         // System.out.println(sum_time);
         float average=sum_time/25;
         info.write("Average time elapsed for find  operation :"+average+"\r\n");
      } 
      catch (FileNotFoundException ex) {
         ex.printStackTrace();
      }
      System.out.println("Enter file name for basins : ");
      String basins_file = "C:\\Users\\Linda\\Desktop\\csc2002\\A1\\src\\results\\sequential\\"+ input.nextLine()+".txt";
      try (
                 FileWriter fstream = new FileWriter(basins_file);
                 BufferedWriter info1 = new BufferedWriter(fstream)) {
         int number_of_basins = basinFinder(t.Grid());
         info1.write(number_of_basins +"\r\n");
         Iterator<String> i = allBasins(t.Grid()).iterator();
         while (i.hasNext()) {
            info1.write(i.next() + "\r\n");
         }
      } 
      catch (FileNotFoundException e) {
         e.printStackTrace();
      }
   
   }
}

      



