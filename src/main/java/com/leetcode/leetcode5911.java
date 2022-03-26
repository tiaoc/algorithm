package com.leetcode;

public class leetcode5911 {
    //只会在圈上走
    class Robot {
        int width, height, circle, x, y;
        int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {0, -1}};
        String[] dirr = new String[]{"East", "North", "West", "South"};
        int curDir = 0;
        boolean moveFlag = false;
        int pos;

        public Robot(int width, int height) {
            this.width = width;
            this.height = height;
            this.x = 0;
            this.y = 0;
            this.circle = (width + height - 2) * 2;
            this.pos = 0;
        }

        public void move(int num) {
            moveFlag = true;
            pos = (pos + num) % circle;
            System.out.println(pos);
        }
    //33+17 51 33-2=31 31*2=62 62-51=11
        public int[] getPos() {
            pos = pos% circle;
            if(pos<width){
                x=0;
                y=pos;
            }else if(pos>=width+height-1&&pos<=circle-height+1){
                x=height-1;
                y=width-2-(pos-width-height+1);
            }else if(pos>=width&&pos<width+height-1){
                x=pos-width+1;
                y=width-1;
            }else {
                x=height-(pos-2*width-height+3);
                y=0;
            }
            return new int[]{y,x};
        }

        public String getDir() {
            if (!moveFlag) {
                return "East";
            }
            if(pos == 0){
                return "South";
            }
            if(pos<width){
                return "East";
            }else if(pos>=width+height-1&&pos<=circle-height+1){
                return "West";
            }else if(pos>=width&&pos<width+height-1){
                return "North";
            }else {
                return "South";
            }
        }
    }
}
