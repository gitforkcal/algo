package com.test.algo.misc;

/**
 * @author Rahul
 */
public class MatrixRotation {

    private static int[][] rotate(int[][] data) {
        int n = data[0].length;
        int[][] newData = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                newData[i][j] = data[j][n - i - 1];
            }
        }
        return newData;
    }


    public static void rotate1(int[][] matrix) {
        int n = matrix[0].length;
        for (int layer = 0; layer < n / 2; ++layer) {
            int first = layer;
            int last = n - 1 - layer;
            for (int i = first; i < last; ++i) {
                int offset = i - first;
                int top = matrix[first][i]; // save top
                // left -> top
                matrix[first][i] = matrix[last - offset][first];

                // bottom -> left
                matrix[last - offset][first] = matrix[last][last - offset];

                // right -> bottom
                matrix[last][last - offset] = matrix[i][last];

                // top -> right
                matrix[i][last] = top; // right <- saved top
            }
        }
    }

    private static int[][] rotateInPlace(int[][] data) {
        int length = data[0].length;

        for (int layer = 0; layer < length / 2; layer++) {
            int first = layer;
            int last = length - layer - 1;

            for (int i = first; i < last; i++) {
                int offset = i - first;
                int temp = data[first][i];
                data[first][i] = data[last - offset][first];
                data[last - offset][first] = data[last][last - offset];
                data[last][last - offset] = data[i][last];
                data[i][last] = temp;
            }
        }
        return data;
    }

    public static void main(String[] argv) {
        int[][] data = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        print(data);
        //data = rotate(data);
        //data = rotateInPlace(data);
        rotate1(data);
        print(data);
    }

    private static void print(int[][] data) {
        int length = data[0].length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                System.out.print(data[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
