/*
给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 */

public class Solution {
    public int[] multiply(int[] A) {
		int ji = 1;
		for(int i = 0; i < A.length; i+=2) ji *= A[i];
		int ou = 1;
		for(int i = 1; i < A.length; i+=2) ou *= A[i];
		int[] copy = new int[A.length];
		int mul = 1;
		for(int i = 0; i < A.length; i+=2, mul = 1){
			for(int j = 0; j < A.length; j+=2){
				if(j == i) continue;
				mul *= A[j];
			}
			copy[i] = mul * ou;
		}
		for(int i = 1; i < A.length; i+=2, mul = 1){
			for(int j = 1; j < A.length; j+=2){
				if(j == i) continue;
				mul *= A[j];
			}
			copy[i] = mul * ji;
		}
		return copy;
    }
}


//B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]
//从左到右算 B[i]=A[0]*A[1]*...*A[i-1]
//从右到左算B[i]*=A[i+1]*...*A[n-1]

class Solution {
public:
    vector<int> multiply(const vector<int>& A) {
     
        int n=A.size();
        vector<int> b(n);
        int ret=1;
        for(int i=0;i<n;ret*=A[i++]){
            b[i]=ret;
        }
        ret=1;
        for(int i=n-1;i>=0;ret*=A[i--]){
            b[i]*=ret;
        }
        return b;
    }
};