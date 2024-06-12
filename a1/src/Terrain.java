public class Terrain {
   private final int row;
   private final int column;
   private final float[][] heights;

   public Terrain(int r,int c){
      this.column=c;
      this.row=r;
      this.heights=new float[r][c];
   }
   public float getHeight(int x,int y){
      float h;
      h=this.heights[y][x];
      return h;
   
   }

   public void setHeight(int x,int y,float h) {
      this.heights[y][x] = h;
   }
   public void display(){
       System.out.print(this.row+" ");
       System.out.println(this.column);
       for (int y = 0; y < this.row; y++) {
           for (int x = 0; x < this.column; x++) {
              System.out.print( getHeight(x, y)+" ");
           }
           System.out.println();
       }

   }
   public float[][] Grid(){
       return this.heights;
   }


}
