package Sort;

/**
 * jhChoi - 201116
 * <p>
 * Heap을 구현한 클래스 이며
 * Array를 사용해 구현했습니다.
 * <p>
 * (Max, Min) Heap 형태로 정렬이 가능합니다.
 */
public class HeapArray extends Heap {
    static final int ROOT = 1;
    final int sortType;
    int[] tree;
    int index = 1;

    public HeapArray(int size, int sortType) {
        this.tree = new int[size + 1];
        this.tree[0] = 0;
        this.sortType = sortType;
    }

    public HeapArray(int[] tree, int sortType) {
        this.tree = new int[tree.length + 1];
        this.tree[0] = 0;
        this.sortType = sortType;

        for (int i = 1; i < this.tree.length; i++) {
            add(tree[i - 1], index);
        }
    }

    @Override
    public boolean isEmpty() {
        return tree[ROOT] == -1;
    }

    @Override
    public int pop() {
        if (tree[ROOT] == -1) {   //더이상 요소가 존재 하지 않는 경우
            return -1;
        }

        --index;
        int root = tree[ROOT];
        int lastNode = tree[index];
        tree[index] = -1;

        if (tree[ROOT] == -1) {
            return root;
        }

        tree[ROOT] = lastNode;
        int curIndex = ROOT;
        while (true) {
            int lCIndex = curIndex * 2;
            int rCIndex = lCIndex + 1;
            int nextIndex;

            if (index > lCIndex && index > rCIndex) {
                nextIndex = getNextIndex(lCIndex, rCIndex);
            } else if (index > lCIndex) {
                nextIndex = lCIndex;
            } else {
                break;
            }

            int minChild = tree[nextIndex];
            int current = tree[curIndex];

            if (isSortEnd(minChild, current,sortType)) {
                break;
            } else {
                swap(nextIndex, curIndex);
                curIndex = nextIndex;
            }
        }

        return root;
    }

    @Override
    int getNextIndex(int lCIndex, int rCIndex) {
        if (sortType == Heap.HEAP_TYPE_MAX) return tree[lCIndex] <= tree[rCIndex] ? rCIndex : lCIndex;
        else return tree[lCIndex] >= tree[rCIndex] ? rCIndex : lCIndex;
    }

    public void add(int value, int addIndex) {
        tree[addIndex] = value;
        index++;

        if (addIndex == ROOT) {   //루트 노드만 존재 하는 경우
            return;
        }

        while ((addIndex / 2) > 0) {
            if (isCorrect(addIndex)) {
                break;
            } else {
                swap(addIndex, addIndex / 2);
                addIndex = addIndex / 2;
            }
        }
    }

    @Override
    boolean isCorrect(int addIndex) {
        if (sortType == Heap.HEAP_TYPE_MAX) return tree[addIndex] < tree[addIndex / 2];
        else return tree[addIndex] > tree[addIndex / 2];
    }

    @Override
    void swap(int curIndex, int parentIndex) {
        int parentTemp = tree[parentIndex];
        tree[parentIndex] = tree[curIndex];
        tree[curIndex] = parentTemp;
    }
}
