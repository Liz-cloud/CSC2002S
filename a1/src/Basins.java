import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Stream;

//public class Basins extends RecursiveTask<ArrayList<String>>
//{
//   float[][]grid;
//   int row_low;
//   int row_high;
//   int column_low;
//   int column_high;
//   static final int ROW_CUTOFF=1500;
//   static final int COLUMN_CUTOFF=1500;
//
//
//   /**
//    * @param h
//    * @param l1
//    * @param hi1
//    * @param l2
//    * @param hi2
//    */
//   Basins(float[][]h ,int l1,int hi1,int l2,int hi2 ){
//      this.grid=h;
//      this.row_low=l1;
//      this.row_high=hi1;
//      this.column_high=hi2;
//      this.column_low=l2;
//   }
//
//   /**
//    *
//    * @return ArrayList of grid terrain points found
//    */
//   @Override
//   protected ArrayList<String>compute() {
//      ArrayList basins=new ArrayList();
//      if((row_high-row_low)<=COLUMN_CUTOFF &&(column_high-column_low)<=COLUMN_CUTOFF){
//         boolean flag =false;
//         float cut = (float)0.01;
//         ArrayList<String> basin_point = new ArrayList<String>();
//         for (int y = 1; y < row_high-1; y++) {
//            for (int x = 1; x < column_high - 1; x++) {
//               String point = y+ " " + x;
//               Float height = grid[y][x] + cut;
//               float a, b, d, e, f, g, h, i;
//               a = grid[y][x + 1];
//               b = grid[y + 1][x];
//               d = grid[y + 1][x + 1];
//               e = grid[y][x - 1];
//               f = grid[y + 1][x - 1];
//               g = grid[y - 1][x + 1];
//               h = grid[y - 1][x - 1];
//               i = grid[y - 1][x];
//               if (((a >= height) & (b >= height)) & (d >= height)) {
//                  if ((e >= height) & (f >= height)) {
//                     if (((g >= height) & (h >= height)) & (i >= height)) {
//                        flag= true;
//                     }
//                  }
//               }
//               if (flag == true) {
//                  basin_point.add(point);
//               }
//               flag=false;
//            }
//         }
//         return basin_point;
//      }
//      else {
//         int row_mid=row_low+((row_high-row_low));
//         int column_mid=column_low+((column_high));
//         Basins top_left = new Basins(grid, row_low, row_mid,column_low,column_mid);
//         Basins top_right = new Basins(grid, row_mid,row_high,column_low,column_mid);
//         // order of next 4 lines
//         // essential â€“ why?
//         top_left.fork();
//         ArrayList rightAns = top_right.compute();
//         ArrayList leftAns = top_left.join();
//         leftAns.addAll(rightAns);
//         return leftAns;
//      }
//
//   }
//
//
//}
//public class Basins extends RecursiveTask<ArrayList<String>>
//{
//   float[][]grid;
//   int row_low;
//   int row_high;
//   int column_low;
//   int column_high;
//   static final int ROW_CUTOFF=1500;
//   static final int COLUMN_CUTOFF=1500;
//
//
//   /**
//    * @param h
//    * @param l1
//    * @param hi1
//    * @param l2
//    * @param hi2
//    */
//   Basins(float[][]h ,int l1,int hi1,int l2,int hi2 ){
//      this.grid=h;
//      this.row_low=l1;
//      this.row_high=hi1;
//      this.column_high=hi2;
//      this.column_low=l2;
//   }
//
//   /**
//    *
//    * @return ArrayList of grid terrain points found
//    */
//   @Override
//   protected ArrayList<String>compute() {
//      ArrayList basins=new ArrayList();
//      if((row_high-row_low)<=COLUMN_CUTOFF &&(column_high-column_low)<=COLUMN_CUTOFF){
//         boolean flag =false;
//         float cut = (float)0.01;
//         ArrayList<String> basin_point = new ArrayList<String>();
//         for (int y = 1; y < row_high-1; y++) {
//            for (int x = 1; x < column_high - 1; x++) {
//               String point = y+ " " + x;
//               Float height = grid[y][x] + cut;
//               float a, b, d, e, f, g, h, i;
//               a = grid[y][x + 1];
//               b = grid[y + 1][x];
//               d = grid[y + 1][x + 1];
//               e = grid[y][x - 1];
//               f = grid[y + 1][x - 1];
//               g = grid[y - 1][x + 1];
//               h = grid[y - 1][x - 1];
//               i = grid[y - 1][x];
//               if (((a >= height) & (b >= height)) & (d >= height)) {
//                  if ((e >= height) & (f >= height)) {
//                     if (((g >= height) & (h >= height)) & (i >= height)) {
//                        flag= true;
//                     }
//                  }
//               }
//               if (flag == true) {
//                  basin_point.add(point);
//               }
//               flag=false;
//            }
//         }
//         return basin_point;
//      }
//      else {
//         int row_mid=row_low+((row_high-row_low));
//         int column_mid=column_low+((column_high));
//         Basins top_left = new Basins(grid, row_low, row_mid,column_low,column_mid);
//         Basins top_right = new Basins(grid, row_mid,row_high,column_low,column_mid);
//         // order of next 4 lines
//         // essential â€“ why?
//         top_left.fork();
//         ArrayList rightAns = top_right.compute();
//         ArrayList leftAns = top_left.join();
//         leftAns.addAll(rightAns);
//         return leftAns;
//      }
//
//   }
//
//
//}
//public class Basins extends RecursiveTask<ArrayList<String>>
//{
//   float[][]grid;
//   int row_low;
//   int row_high;
//   int column_low;
//   int column_high;
//   static final int ROW_CUTOFF=1500;
//   static final int COLUMN_CUTOFF=1500;
//
//
//   /**
//    * @param h
//    * @param l1
//    * @param hi1
//    * @param l2
//    * @param hi2
//    */
//   Basins(float[][]h ,int l1,int hi1,int l2,int hi2 ){
//      this.grid=h;
//      this.row_low=l1;
//      this.row_high=hi1;
//      this.column_high=hi2;
//      this.column_low=l2;
//   }
//
//   /**
//    *
//    * @return ArrayList of grid terrain points found
//    */
//   @Override
//   protected ArrayList<String>compute() {
//      ArrayList basins=new ArrayList();
//      if((row_high-row_low)<=COLUMN_CUTOFF &&(column_high-column_low)<=COLUMN_CUTOFF){
//         boolean flag =false;
//         float cut = (float)0.01;
//         ArrayList<String> basin_point = new ArrayList<String>();
//         for (int y = 1; y < row_high-1; y++) {
//            for (int x = 1; x < column_high - 1; x++) {
//               String point = y+ " " + x;
//               Float height = grid[y][x] + cut;
//               float a, b, d, e, f, g, h, i;
//               a = grid[y][x + 1];
//               b = grid[y + 1][x];
//               d = grid[y + 1][x + 1];
//               e = grid[y][x - 1];
//               f = grid[y + 1][x - 1];
//               g = grid[y - 1][x + 1];
//               h = grid[y - 1][x - 1];
//               i = grid[y - 1][x];
//               if (((a >= height) & (b >= height)) & (d >= height)) {
//                  if ((e >= height) & (f >= height)) {
//                     if (((g >= height) & (h >= height)) & (i >= height)) {
//                        flag= true;
//                     }
//                  }
//               }
//               if (flag == true) {
//                  basin_point.add(point);
//               }
//               flag=false;
//            }
//         }
//         return basin_point;
//      }
//      else {
//         int row_mid=row_low+((row_high-row_low));
//         int column_mid=column_low+((column_high));
//         Basins top_left = new Basins(grid, row_low, row_mid,column_low,column_mid);
//         Basins top_right = new Basins(grid, row_mid,row_high,column_low,column_mid);
//         // order of next 4 lines
//         // essential â€“ why?
//         top_left.fork();
//         ArrayList rightAns = top_right.compute();
//         ArrayList leftAns = top_left.join();
//         leftAns.addAll(rightAns);
//         return leftAns;
//      }
//
//   }
//
//
//}
public class Basins extends RecursiveTask<Integer>
{
   float[][]grid;
   int row_low;
   int row_high;
   int column_low;
   int column_high;
   static final int ROW_CUTOFF=1500;
   static final int COLUMN_CUTOFF=1500;


   /**
    * @param h
    * @param l1
    * @param hi1
    * @param l2
    * @param hi2
    */
   Basins(float[][]h ,int l1,int hi1,int l2,int hi2 ){
      this.grid=h;
      this.row_low=l1;
      this.row_high=hi1;
      this.column_high=hi2;
      this.column_low=l2;
   }

   /**
    *
    * @return ArrayList of grid terrain points found
    */
   @Override
   protected Integer compute() {
      ArrayList basins=new ArrayList();
      if((row_high-row_low)<=COLUMN_CUTOFF &&(column_high-column_low)<=COLUMN_CUTOFF){
         boolean flag =false;
         float cut = (float)0.01;
         Integer basin_point = 0;
         for (int y = 1; y < row_high-1; y++) {
            for (int x = 1; x < column_high - 1; x++) {
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
                        flag= true;
                     }
                  }
               }
               if (flag == true) {
                  basin_point+=1;
               }
               flag=false;
            }
         }
         
         return basin_point;
      }
      else {
         int row_mid=row_low+((row_high-row_low));
         int column_mid=column_low+((column_high));
         Basins top_left = new Basins(grid, row_low, row_mid,column_low,column_mid);
         Basins top_right = new Basins(grid, row_mid,row_high,column_low,column_mid);
         // order of next 4 lines
         // essential â€“ why?
         top_left.fork();
         int rightAns = top_right.compute();
         int leftAns = top_left.join();
         
         return leftAns+rightAns;
      }

   }


}