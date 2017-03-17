/*
输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 
则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */

import java.util.ArrayList;
public class Solution {
    ArrayList<Integer> resultList = new ArrayList<>();
	int totalSteps = 0;
	int steped = 0;

	public ArrayList<Integer> printMatrix(int[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return null;

		int length = matrix.length;
		int width = matrix[0].length;

		totalSteps = width * length;

		walk(0, width, length, 0, -1, matrix);

		return resultList;
	}

	public void walk(int ori, int widthSteps, int lengthSteps, int x, int y,
			int[][] map) {
		switch (ori) {
		case 0:
			for (int i = 1; i <= widthSteps; i++) {
				y++;
				resultList.add(map[x][y]);
				steped++;
			}
			break;
		case 1:
			for (int i = 1; i <= lengthSteps; i++) {
				x++;
				resultList.add(map[x][y]);
				steped++;
			}
			break;
		case 2:
			for (int i = 1; i <= widthSteps; i++) {
				y--;
				resultList.add(map[x][y]);
				steped++;
			}
			break;
		case 3:
			for (int i = 1; i <= lengthSteps; i++) {
				x--;
				resultList.add(map[x][y]);
				steped++;
			}
			break;
		}
		if (steped == totalSteps) {
			return;
		} else {
			if (ori == 0 || ori == 2) {
				lengthSteps--;
			} else {
				widthSteps--;
			}
			ori++;
			ori = ori % 4;
			walk(ori, widthSteps, lengthSteps, x, y, map);
		}

	}
}

public class Solution {
    public ArrayList<Integer> printMatrix(int [][] array) {
        ArrayList<Integer> result = new ArrayList<Integer> ();
        if(array.length==0) return result;
        int n = array.length,m = array[0].length;
        if(m==0) return result;
        int layers = (Math.min(n,m)-1)/2+1;//这个是层数
        for(int i=0;i<layers;i++){
            for(int k = i;k<m-i;k++) result.add(array[i][k]);//左至右
            for(int j=i+1;j<n-i;j++) result.add(array[j][m-i-1]);//右上至右下
            for(int k=m-i-2;(k>=i)&&(n-i-1!=i);k--) result.add(array[n-i-1][k]);//右至左
            for(int j=n-i-2;(j>i)&&(m-i-1!=i);j--) result.add(array[j][i]);//左下至左上
        }
        return result;       
    }
}