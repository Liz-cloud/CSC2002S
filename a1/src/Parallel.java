import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;
public class Parallel {
    static long startTime = 0;

    private static void tick() {
        startTime = System.currentTimeMillis();
    }

    private static float tock() {
        return (System.currentTimeMillis() - startTime) / 1000.0f;
    }

    static final ForkJoinPool fjp = new ForkJoinPool();

    static Integer basins(float[][]terrain_grid) {
        return fjp.invoke(new Basins(terrain_grid,0,terrain_grid.length,0,terrain_grid[0].length));
    }
    /**
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
/**
 * read the text files to populate the grid terrain
 */
        FileReader file = new FileReader(args[0]);
        String line;
        Terrain t = null;
        int r;
        int c;
        try {
            BufferedReader reader = new BufferedReader(file);
            line = reader.readLine();
            String[] row_column = line.split(" ");
            r = Integer.valueOf(row_column[0]);
            c = Integer.valueOf(row_column[1]);
            int y_axis = 0, x_axis = 0;
            t = new Terrain(r, c);
            String[] heights = null;

            /**
             * populating the Grid terrain
             */
            //         heights=reader.readLine().split(" ");
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

        } catch (IOException exception) {
            exception.printStackTrace();
        }


        /**
         * find the time elapsed in milliseconds store the results in designated txt files
         * use an iterator find all the coordinates of the basins found in the grid terrain and store them in a txt file
         */
             Scanner input = new Scanner(System.in);
             System.out.println("Enter file  name for time : ");
             String times_file = "\\src\\results\\parallel\\"+ input.nextLine()+".txt";
             float[][] grid = t.Grid();
//         ArrayList<String>basins_coordinates =new ArrayList<>();
        int basins_coordinates=0;
             try (
                     FileWriter fstream = new FileWriter(times_file);
                     BufferedWriter info = new BufferedWriter(fstream)) {
                 float sum_time=0;
                 float time_passed=0;
                 basins_coordinates=basins(grid);
                 info.write("number of basins found:"+basins_coordinates+"\r\n");
                 info.write("time elapsed for the 25 find operations :"+"\r\n");
                 for (int i = 0; i < 25; i++) {

                     System.gc();
                     tick();
                     basins_coordinates = basins(grid);
                      time_passed = tock();
                     info.write(time_passed + "\r\n");
                     sum_time+=time_passed;
                 }
                 float average_time=sum_time/25;
                 info.write("average time elapsed for the data set:"+average_time+"\r\n");

             } catch (FileNotFoundException ex) {
                 ex.printStackTrace();
             } catch (IOException exception) {
                 exception.printStackTrace();
             }

//         System.out.println("Enter file  name for output : ");
//         String out_file = "\\src\\results\\parallel\\"+ input.nextLine()+".txt";
//         try (FileWriter fstream = new FileWriter(out_file);
//              BufferedWriter info1 = new BufferedWriter(fstream)) {
//             basins_coordinates=basins(grid);
//             int number_of_basins = basins_coordinates.size();
//             info1.write(number_of_basins +"\r\n");
////             Iterator<String> i = basins_coordinates.iterator();
//             while (i.hasNext()) {
//                 info1.write(i.next() + "\r\n");
//             }
//
//         }

//         catch (FileNotFoundException e) {
//             e.printStackTrace();
//         } catch (IOException exception) {
//             exception.printStackTrace();
//         }

//            /**
//             * finding the number of basins by calling the
//             */
//            System.gc();
//            float[][] grid = t.Grid();
//            tick();
//            ArrayList basins = basins(grid);
//            float time = tock();
//             System.out.println("Run process run took " + time + " seconds");
//            System.out.println("number of found in grid train basins is: " + basins.toString());

    }
}

