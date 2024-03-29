package com.ll.level2.p1844;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    int dx[] = {1, -1, 0, 0};
    int dy[] = {0, 0, 1, -1};

    int depth = 0;

    int endCheck = 0;

    public int solution(int[][] maps) {
        int answer = 0;

//        bfs(maps);

        int n = maps.length;
        int m = maps[0].length;

        if(n == 1 && m == 1){
            return 1;
        }

        try{
            if(maps[n-1][m-2] == 0 && maps[n-2][m-1] == 0){
                return -1;
            }
        }catch (Exception e1){
            System.out.println("에러");
        }


        Queue<Point> q = new LinkedList<>();

        boolean visited[][] = new boolean[n][m];

//        Point startPoint = new Point(0, 0);
//        startPoint.cost = 0;

        q.add(new Point(0,0,0));

        visited[0][0] = true;


        while(!q.isEmpty()){
            Point nowPoint = q.poll();

            int x = nowPoint.x;
            System.out.println(x);
            int y = nowPoint.y;
            System.out.println(y);
            int nowCost = nowPoint.cost+1;

            System.out.println("[" + x + "]" + " [" + y + "]" );

            if(x == n-1 && y == m-1){
                q.clear();
                depth = nowCost;
                endCheck = 1;
                break;
            }

//            visited[x][y] = true;

            for(int i = 0; i < dx.length; i++){
                int newX = x + dx[i];
                int newY = y + dy[i];

                if(newX > -1 && newY > -1 && newY < m && newX < n){
                    if(maps[newX][newY] == 1 && !visited[newX][newY]){
//                        Point nextPoint = new Point(newX, newY, nowCost);
                        q.add(new Point(newX, newY, nowCost));
                        visited[newX][newY] = true;
                    }
                }

            }
        }

        if(endCheck != 1){
            return -1;
        }

        return depth;
    }


    /*void bfs(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        if(n == 1 && m == 1){
            depth = 1;
            return;
        }

        if(maps[n-1][m-2] == 0 && maps[n-2][m-1] == 0){
            depth = -1;
            return;
        }

        Queue<Point> q = new LinkedList<>();

        boolean visited[][] = new boolean[n][m];

//        Point startPoint = new Point(0, 0);
//        startPoint.cost = 0;

        q.add(new Point(0,0,0));

        visited[0][0] = true;


        while(!q.isEmpty()){
            Point nowPoint = q.poll();

            int x = nowPoint.x;
            System.out.println(x);
            int y = nowPoint.y;
            System.out.println(y);
            int nowCost = nowPoint.cost+1;

            System.out.println("[" + x + "]" + " [" + y + "]" );

            if(x == n-1 && y == m-1){
                q.clear();
                depth = nowCost;
                endCheck = 1;
                break;
            }

            visited[x][y] = true;

            for(int i = 0; i < dx.length; i++){
                int newX = x + dx[i];
                int newY = y + dy[i];

                if(newX > -1 && newY > -1 && newY < m && newX < n){
                    if(maps[newX][newY] == 1 && !visited[newX][newY]){
//                        Point nextPoint = new Point(newX, newY, nowCost);
                        q.add(new Point(newX, newY, nowCost));
                    }
                }

            }
        }

        if(endCheck != 1){
            depth = -1;
        }
    }*/

    class Point{
        int x;
        int y;

        int cost;

        public Point(){
            ;
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Point(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

    }
}


