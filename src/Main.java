import java.util.ArrayList;
import java.util.List;

public class Main {
    public static  int  cal(int [][]m){
        int count = 0;
        int []res = new int[m.length];
        for(int i =0  ; i < res.length ; i++){
            res[i] = 0;
        }
        int x = -1,y=-1;
        List<Integer> list = new ArrayList<>();
        for(int i  = 0 ; i < m.length ; i++){
            for(int j = 0 ; j  < m[0].length ; j++){
                if(m[i][j] ==1 ){
                    if(x!= i && y!=j ) {
                        if(!list.contains(i) && ! list.contains(j))
                            count++;
                    }
                    x = i;
                    y = j;
                    list.add(x);
                    list.add(y);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
//        int[][]s=  {{1,0,1,0,0,0},
//                {0,1,0,0,0,0},{1,0,1,0,0,0},{0,0,0,1,0,1},{0,0,0,0,1,0},
//                {0,0,0,1,1,0,1}};
//        int[][]s = {{1,1},{0,1}};
        int[][]s = {{0}};
        System.out.println(Main.cal(s));
    }
}
