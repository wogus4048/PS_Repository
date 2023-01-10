import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] town;
    static int V;
    static int E;
    static int MIN;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
       
        V = Integer.parseInt(input[0]);
        E = Integer.parseInt(input[1]);
        town = new int[V+1][V+1];
        
        MIN = 1000000000;
        
        for(int i = 1; i<=V; i++) {
            for(int j = 1; j<=V; j++) {
                if (i == j) {
                    town[i][j] = 0;
                } else {
                    town[i][j] = 1000000000;
                }
            }
        }
        
        for(int i = 0; i<E; i++) {
            String[] road = br.readLine().split(" ");
            int a = Integer.parseInt(road[0]);
            int b = Integer.parseInt(road[1]);
            int c = Integer.parseInt(road[2]);
            
            town[a][b] = c;
        }
        
        // i = 거쳐가는 노드 , j-k 간의 거리
        for(int i = 1; i<=V; i++) {
            for(int j = 1; j<=V; j++) {
                for(int k = 1; k<=V; k++) {
                    town[j][k] = Math.min(town[j][k], town[j][i] + town[i][k]);
                }
            }
        }
        
        boolean check = false;
        
        for(int i = 1; i<=V; i++) {
            for(int j = 1; j<=V; j++) {
                if ( i != j && town[i][j] != 1000000000 && town[j][i] != 1000000000) {
                    MIN = Math.min(town[i][j] + town[j][i], MIN);
                    check = true;
                }
            }
        }
        
        
        System.out.println(check ? MIN : -1);
    }
}