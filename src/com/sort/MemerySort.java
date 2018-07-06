package com.sort;

/**
 * Created by sqy on 2018/7/5.
 */
public class MemerySort {
    public static void main(String[] args){
        int[] a = {23,3,14,25,9,21,53};
        int left = 0;
        int right = a.length -1;
        MemerySort memerySort = new MemerySort();
        memerySort.mergeSort(a,left,right);
        for(int i = 0;i<a.length;i++){
            System.out.println(a[i]+" ");
        }
    }

    private static void mergeSort(int[] a, int left, int right) {
        if(left<right){
            int middle = (left+right)/2;
            //对左边进行递归
            mergeSort(a, left, middle);
            //对右边进行递归
            mergeSort(a, middle+1, right);
            //合并
            merge(a,left,middle,right);
        }
    }

    private static void merge(int[] a, int left, int middle, int right) {

        int[] tmpArr = new int[a.length];
        int mid = middle+1; //右边的起始位置
        int tmp = left;
        int third = left;
        while(left<=middle && mid<=right){
            //从两个数组中选取较小的数放入中间数组
            if(a[left]<=a[mid]){
                tmpArr[third++] = a[left++];
            }else{
                tmpArr[third++] = a[mid++];
            }
        }
        //将剩余的部分放入中间数组
        while(left<=middle){
            tmpArr[third++] = a[left++];
        }
        while(mid<=right){
            tmpArr[third++] = a[mid++];
        }
        //将中间数组复制回原数组
        while(tmp<=right){
            a[tmp] = tmpArr[tmp++];
        }

    }

    /*public void sort(int[] a,int left,int right){
        if(left >= right){
            return;
        }

        int middle = (left+right)/2;
        sort(a,left,middle);
        sort(a,middle+1,right);
        merge(a,left,middle,right);

    }

    public void merge(int[] a ,int left,int middle,int right){

        int[] temp = new int[a.length];
        int k = left;
        while (left <=middle && (middle+1)<=right){
            if(a[left] <= a[middle+1]){
                temp[k++] = a[left++];
            }else {
                temp[k++] = a[right++];
            }
        }

        while (left <= middle){
            temp[k++] = a[left++];
        }
        while ((middle+1)<=right){
            temp[k++] = a[right++];
        }

        while (k <= right){
            a[k] = temp[k++];
        }
    }
*/

}
