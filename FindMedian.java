package com.henry.aa;

public class FindMedian {
    public FindMedian()
    {

    }
    public int LomutoPartion(int[] A,int start,int end)
    {
        int begin = A[start];
        int result = start;
        for(int i = start+1;i <= end;i++)
        {
            if(A[i] < begin)
            {
                result = result + 1;
                swap(A,result,i);
            }
        }
        swap(A,start,result);
        return result;
    }
    private void swap(int[] array,int m,int n)
    {
        int temp = array[m];
        array[m] = array[n];
        array[n] = temp;
    }
}
