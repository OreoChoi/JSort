package Sort;

import java.util.Arrays;

public class MergeSort {
    public static int[] sort(int[] arr, boolean isReverse) {
        if (arr.length == 0 || arr.length == 1) {
            return arr;
        }
        int[] leftArr = Arrays.copyOfRange(arr, 0, arr.length / 2);
        int[] rightArr = Arrays.copyOfRange(arr, arr.length / 2, arr.length);

        return divAndComArr(leftArr, rightArr, isReverse);
    }

    private static int[] divAndComArr(int[] leftArr, int[] rightArr, boolean isRev) {
        int[] lArr;
        int[] rArr;

        if (leftArr.length > 1) {
            lArr = divAndComArr(Arrays.copyOfRange(leftArr, 0, leftArr.length / 2),
                    Arrays.copyOfRange(leftArr, leftArr.length / 2, leftArr.length), isRev);
        } else {
            lArr = leftArr;
        }

        if (rightArr.length > 1) {
            rArr = divAndComArr(Arrays.copyOfRange(rightArr, 0, rightArr.length / 2),
                    Arrays.copyOfRange(rightArr, rightArr.length / 2, rightArr.length), isRev);
        } else {
            rArr = rightArr;
        }

        int[] combineArr = new int[lArr.length + rArr.length];
        int lIdx = 0;
        int rIdx = 0;

        for (int i = 0; i < combineArr.length; i++) {
            if (lIdx == lArr.length) {
                combineArr[i] = rArr[rIdx];
                rIdx++;
                continue;
            } else if (rIdx == rArr.length) {
                combineArr[i] = lArr[lIdx];
                lIdx++;
                continue;
            }

            if (!isRev) {   //오름차순 정렬일 경우
                if (lArr[lIdx] <= rArr[rIdx]) {
                    combineArr[i] = lArr[lIdx];
                    lIdx++;
                } else {
                    combineArr[i] = rArr[rIdx];
                    rIdx++;
                }
            }else{
                if (lArr[lIdx] <= rArr[rIdx]) {
                    combineArr[i] = rArr[rIdx];
                    rIdx++;
                } else {
                    combineArr[i] = lArr[lIdx];
                    lIdx++;
                }
            }
        }
        return combineArr;
    }
}
