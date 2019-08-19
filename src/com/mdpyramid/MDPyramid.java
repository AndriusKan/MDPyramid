package com.mdpyramid;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class MDPyramid {

    public static void main(String[] args) {
        int numberOfRows = 15;
        int[][] data = {
                {215, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {192, 124, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {117, 269, 442, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {218, 836, 347, 235, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {320, 805, 522, 417, 345, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {229, 601, 728, 835, 133, 124, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {248, 202, 277, 433, 207, 263, 257, 0, 0, 0, 0, 0, 0, 0, 0},
                {359, 464, 504, 528, 516, 716, 871, 182, 0, 0, 0, 0, 0, 0, 0},
                {461, 441, 426, 656, 863, 560, 380, 171, 923, 0, 0, 0, 0, 0, 0},
                {381, 348, 573, 533, 448, 632, 387, 176, 975, 449, 0, 0, 0, 0, 0},
                {223, 711, 445, 645, 245, 543, 931, 532, 937, 541, 444, 0, 0, 0, 0},
                {330, 131, 333, 928, 376, 733, 017, 778, 839, 168, 197, 197, 0, 0, 0},
                {131, 171, 522, 137, 217, 224, 291, 413, 528, 520, 227, 229, 928, 0, 0},
                {223, 626, 034, 683, 839, 052, 627, 310, 713, 999, 629, 817, 410, 121, 0},
                {924, 622, 911, 233, 325, 139, 721, 218, 253, 223, 107, 233, 230, 124, 233}
        };
        int[][] dataForPath = {
                {215, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {192, 124, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {117, 269, 442, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {218, 836, 347, 235, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {320, 805, 522, 417, 345, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {229, 601, 728, 835, 133, 124, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {248, 202, 277, 433, 207, 263, 257, 0, 0, 0, 0, 0, 0, 0, 0},
                {359, 464, 504, 528, 516, 716, 871, 182, 0, 0, 0, 0, 0, 0, 0},
                {461, 441, 426, 656, 863, 560, 380, 171, 923, 0, 0, 0, 0, 0, 0},
                {381, 348, 573, 533, 448, 632, 387, 176, 975, 449, 0, 0, 0, 0, 0},
                {223, 711, 445, 645, 245, 543, 931, 532, 937, 541, 444, 0, 0, 0, 0},
                {330, 131, 333, 928, 376, 733, 017, 778, 839, 168, 197, 197, 0, 0, 0},
                {131, 171, 522, 137, 217, 224, 291, 413, 528, 520, 227, 229, 928, 0, 0},
                {223, 626, 034, 683, 839, 052, 627, 310, 713, 999, 629, 817, 410, 121, 0},
                {924, 622, 911, 233, 325, 139, 721, 218, 253, 223, 107, 233, 230, 124, 233}
        };

        for (int i = numberOfRows - 1; i > 0; i--) {
            for (int j = 0; j < numberOfRows - 1; j++) {
                if (dataForPath[i - 1][j] % 2 == 0) {
                    if (dataForPath[i][j] % 2 != 0 && dataForPath[i][j + 1] % 2 != 0) {
                        data[i - 1][j] = data[i - 1][j] + Math.max(data[i][j], data[i][j + 1]);
                    } else if (dataForPath[i][j] % 2 != 0 && dataForPath[i][j + 1] % 2 == 0) {
                        data[i - 1][j] = data[i - 1][j] + data[i][j];
                    } else if (dataForPath[i][j] % 2 == 0 && dataForPath[i][j + 1] % 2 != 0) {
                        data[i - 1][j] = data[i - 1][j] + data[i][j + 1];
                    }
                } else {
                    if (dataForPath[i][j] % 2 == 0 && dataForPath[i][j + 1] % 2 == 0) {
                        data[i - 1][j] = data[i - 1][j] + Math.max(data[i][j], data[i][j + 1]);
                    } else if (dataForPath[i][j] % 2 == 0 && dataForPath[i][j + 1] % 2 != 0) {
                        data[i - 1][j] = data[i - 1][j] + data[i][j];
                    } else if (dataForPath[i][j] % 2 != 0 && dataForPath[i][j + 1] % 2 == 0) {
                        data[i - 1][j] = data[i - 1][j] + data[i][j + 1];
                    }
                }
            }
        }
        int totalSum = data[0][0];
        System.out.println("Total sum: " + totalSum);
        List<Integer> path = new ArrayList<>();
        path.add(dataForPath[0][0]);
        for (int i = 0; i < numberOfRows - 1; i++) {
            for (int j = 0; j < numberOfRows - 1; j++) {
                if (dataForPath[i][j] == path.get(path.size() - 1)) {
                    if (totalSum == dataForPath[i][j] + data[i + 1][j]) {
                        path.add(dataForPath[i + 1][j]);
                        totalSum = data[i + 1][j];
                    } else if (totalSum == dataForPath[i][j] + data[i + 1][j + 1]) {
                        path.add(dataForPath[i + 1][j + 1]);
                        totalSum = data[i + 1][j + 1];
                    }
                }
            }
        }

        StringJoiner stringJoiner = new StringJoiner(", ");
        path.forEach(pathNode -> stringJoiner.add(pathNode.toString()));
        System.out.print("Path: " + stringJoiner);
    }
}
