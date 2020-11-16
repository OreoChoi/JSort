package Sort;

public abstract class Heap {
    public static final int HEAP_TYPE_MAX = 1;
    public static final int HEAP_TYPE_MIN = 2;

    public abstract boolean isEmpty();

    public abstract int pop();

    abstract void swap(int curIndex, int parentIndex);

    /**
     * pop() 실행 중
     * 정렬 끝났으면 true
     * 정렬 종료되지 않으면 false
     * @param child
     * @param current
     * @return
     */
    boolean isSortEnd(int child, int current,int sortType) {
        if (Heap.HEAP_TYPE_MAX == sortType) {
            return child < current;
        } else {
            return child > current;
        }
    }

    /**
     * add() 실행 중
     * 정렬 끝났으면 true
     * 정렬이 종료되지 않았으면 false
     *
     * @param addIndex
     * @return
     */
    abstract boolean isCorrect(int addIndex);

    /**
     * pop() 실행 중
     * (좌측 Node or 우측 Node) 중
     * 접근할 노드의 index를 return하는 메서드 입니다.
     *
     * @param lCIndex 좌측 노드 인덱스
     * @param rCIndex 우측 노드 인덱스
     * @return 접근할 노드의 index (좌, 우 둘중 택 1)
     */
    abstract int getNextIndex(int lCIndex, int rCIndex);
}
