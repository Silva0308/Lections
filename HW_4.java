
import java.util.LinkedList;
import java.util.Queue;

class desk {
    int x, y, distance;

    desk
(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.distance = dist;
    }
}

public class HW_4 {
    static int M = 5;
    static int N = 5;

    static boolean isValid(int mat[][], boolean visit[][], int row, int col) {
        return ((row >= 0) && (row < M)) && ((col >= 0) && (col < N)) && (mat[row][col] == 1) && (!visit[row][col]);
    }

    private static void rate(int matrix[][], int i, int j, int x, int y) {
        int row[] = { -1, 0, 0, 1 };
        int col[] = { 0, -1, 1, 0 };

        boolean[][] visit = new boolean[M][N];
        Queue<desk
    > q = new LinkedList<desk
    >();
        visit[i][j] = true;
        q.add(new desk
    (i, j, 0));
        int minDist = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            desk
         desk
         = q.poll();
            i = desk
        .x;
            j = desk
        .y;
            int dist = desk
        .distance;
            if (i == x && j == y) {
                minDist = dist;
                break;
            }

            for (int k = 0; k < 4; k++) {
                if (isValid(matrix, visit, i + row[k], j + col[k])) {
                    visit[i + row[k]][j + col[k]] = true;
                    desk
                 n = new desk
                (i + row[k], j + col[k], dist + 1);
                    q.add(n);
                }
            }
        }

        if (minDist == Integer.MAX_VALUE) {
            System.out.print("Невозможно дойти");
        } else {
            System.out.print("Кратчайщий путь: " + minDist+" шагов");
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 0, 1, 1, 1 },
                { 1, 0, 1, 0, 1 },
                { 1, 1, 1, 0, 1 },
                { 0, 0, 0, 0, 1 },
                { 1, 1, 1, 0, 1 },
                { 1, 1, 0, 0, 0 } };
        rate(matrix, 1, 1, 3, 4);
    }
}
