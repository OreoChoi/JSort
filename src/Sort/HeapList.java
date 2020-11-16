package Sort;

import java.util.ArrayList;

/**
 * jhChoi - 201116
 *
 * Heap을 구현한 클래스 이며
 * ArrayList를 사용해 구현했습니다.
 *
 * (Max, Min) Heap 형태로 정렬이 가능합니다.
 * */
public class HeapList extends Heap {
    ArrayList<Integer> tree;
    final int ROOT = 1;
    final int sortType;

    public HeapList(int sortType) {
        tree = new ArrayList<>();
        tree.add(0);
        this.sortType = sortType;
    }

    public HeapList(int[] arr, int sortType) {
        tree = new ArrayList<>();
        tree.add(0);
        this.sortType = sortType;

        for (int value : arr) {
            add(value);
        }
    }

    public void add(int value) {
        tree.add(value);

        if (tree.size() == ROOT) {   //루트 노드만 존재 하는 경우
            return;
        }

        int curIndex = tree.size() - 1;
        while ((curIndex / 2) > 0) {
            if (isCorrect(curIndex)) {
                break;
            } else {
                swap(curIndex, curIndex / 2);
                curIndex = curIndex / 2;
            }
        }
    }

    public int size() {
        return tree.size() - 1;
    }

    @Override
    public boolean isEmpty(){
        return tree.size() == 1;
    }

    @Override
    public int pop() {
        if (tree.size() == 1) {   //더이상 요소가 존재 하지 않는 경우
            return -1;
        }

        int root = tree.get(ROOT);
        int lastNode = tree.get(tree.size() - 1);
        tree.remove(tree.size() - 1);

        if (tree.size() == 1) {
            return lastNode;
        }

        tree.set(ROOT, lastNode);
        int curIndex = ROOT;

        while (true) {
            int lCIndex = curIndex * 2;
            int rCIndex = lCIndex + 1;
            int minIndex;

            if (tree.size() > lCIndex) {
                if (tree.size() > rCIndex) {
                    minIndex = getNextIndex(lCIndex,rCIndex);
                } else {
                    minIndex = lCIndex;
                }
            } else {
                break;
            }

            int minChild = tree.get(minIndex);
            int current = tree.get(curIndex);

            if (isSortEnd(minChild,current,sortType)) {
                break;
            } else {
                swap(minIndex, curIndex);
                curIndex = minIndex;
            }
        }
        return root;
    }

    @Override
    int getNextIndex(int lCIndex, int rCIndex) {
        if (sortType == Heap.HEAP_TYPE_MAX) return tree.get(lCIndex) <= tree.get(rCIndex) ? rCIndex : lCIndex;
        else return tree.get(lCIndex) >= tree.get(rCIndex) ? rCIndex : lCIndex;
    }

    @Override
    boolean isCorrect(int addIndex) {
        if (sortType == Heap.HEAP_TYPE_MAX) return tree.get(addIndex) < tree.get(addIndex / 2);
        else return tree.get(addIndex) > tree.get(addIndex / 2);
    }

    @Override
    void swap(int curIndex, int parentIndex) {
        int parentTemp = tree.get(parentIndex);
        tree.set(parentIndex, tree.get(curIndex));
        tree.set(curIndex, parentTemp);
    }
}
