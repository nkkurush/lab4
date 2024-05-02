/*
    Задание №2:
    Простое рехэширование
    Рехэширование с помощью
    псевдослучайных чисел
    Метод цепочек
    №3
    Расставить на стандартной 64-клеточной шахматной доске 8 ферзей так,
    чтобы ни один из них не находился под боем другого». Подразумевается, что ферзь бьёт все клетки,
    расположенные по вертикалям, горизонталям и обеим диагоналям
    Написать программу,  которая находит хотя бы один способ решения задач
*/
public class Task3 {
    final int N = 8;

    void printSolution(int board[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(" " + board[i][j] + " ");
            }
            System.out.println();
        }
    }

    boolean isSafe(int board[][], int row, int col) {
        int i, j;

        for (i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;

        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        for (i = row, j = col; j >= 0 && i < N; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    boolean solveNQUtil(int board[][], int col) {
        if (col >= N)
            return true;

        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 1;

                if (solveNQUtil(board, col + 1))
                    return true;

                board[i][col] = 0;
            }
        }

        return false;
    }

    boolean solveNQ() {
        int board[][] = new int[N][N];

        if (!solveNQUtil(board, 0)) {
            System.out.print("Решение не существует");
            return false;
        }

        printSolution(board);
        return true;
    }

    public static void main(String args[]) {
        Task3 queen = new Task3();
        queen.solveNQ();
    }
}
