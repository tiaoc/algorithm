package com.leetcode;

public class leetcode5203 {
    // 挖完之后，考虑哪些零件被挖出来了，visited数组，零件遍历自己的内容
    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        boolean[][] map = new boolean[n][n];
        int count = 0;
        for (int[] d : dig) {
            map[d[0]][d[1]] = true;
        }
        for (int[] art :artifacts){
            if(checkArtifact(art, map)){
                ++count;
            }
        }
        return count;
    }

    private boolean checkArtifact(int[] artifact, boolean[][] map) {
        for (int r = artifact[0]; r <= artifact[2]; r++) {
            for (int c = artifact[1]; c <= artifact[3]; c++) {
                if(!map[r][c]){
                    return false;
                }
            }
        }
        return true;
    }
}
