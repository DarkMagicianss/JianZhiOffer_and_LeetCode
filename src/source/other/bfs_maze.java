package source.other;


import java.util.concurrent.LinkedBlockingQueue;

public class bfs_maze {
    char[][] maze = new char[50][50];
    boolean[][] vis = new boolean[10][10];
    int[] dx = new int[]{1,0,-1,0};
    int[] dy = new int[]{0,1,0,-1};
    public static class Point{
        public int x;
        public int y;
        public int step;
        public Point(int x, int y, int step) {
            this.x = x;
            this.y = y;
            this.step = step;
        }
    }
    public void bfs(Point start,Point end,char[][] test) throws InterruptedException {
        Point p = new Point(start.x,start.y,start.step);
        LinkedBlockingQueue<Point> lq = new LinkedBlockingQueue<Point>();
        lq.put(p);
        vis[p.x][p.y] = true;
        while(!lq.isEmpty()){
            Point tp = lq.take();
            if(tp.x == end.x && tp.y == end.y){
                System.out.println(tp.step);
                return;
            }
            for(int i=0;i<4;i++){
                int xx = tp.x+dx[i];
                int yy = tp.y+dy[i];
                if(xx>=0 && yy>=0 && xx<=4 && yy<=4 && test[xx][yy]!='#' &&  vis[xx][yy] != true ){
                    System.out.println("x:"+xx+"     "+"y:"+yy+"     "+(tp.step+1));
                    Point temp= new Point(xx,yy,tp.step+1);
                    vis[xx][yy]=true;
                    lq.put(temp);
                }
            }
        }
        System.out.println("走不出去");
    }
    public static void main(String[] arg){
        bfs_maze t = new bfs_maze();
        char[][] test = new char[][]{{'#','S','.','.','#'},{'.','.','#','.','.'},{'#','.','#','.','#'},{'.','.','#','.','#'},{'.','.','G','.','#'}};
        try {
            t.bfs(new Point(0,1,0),new Point(4,2,0),test);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
