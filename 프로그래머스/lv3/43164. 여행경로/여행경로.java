import java.util.*;
class Solution {
  /*
    항상 icn 공항에서 출발

    */

    static List<String> routes = new ArrayList<>();
    static boolean[] visited;
    static String[] solution(String[][] tickets) {

        visited = new boolean[tickets.length];

        dfs(tickets, "ICN", "ICN ", 0);

        routes.sort(Comparator.naturalOrder());

//        System.out.println(routes);
        return routes.get(0).split(" ");
    }

    static void dfs(String[][] tickets,String startAirport,String route,int depth)
    {
        if (depth == tickets.length) {
            routes.add(route);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (startAirport.equals(tickets[i][0]) && !visited[i]) {
                visited[i] = true;
                dfs(tickets,tickets[i][1],route + tickets[i][1] +" ",depth+1);
                visited[i] = false;
            }
        }


    }
    
}