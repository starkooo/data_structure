public class SegmentTree<E> {

    private E[] data;
    private E[] tree;
    private Merger<E> merger;

    public SegmentTree(E[] arr,Merger<E> merger){

        this.merger = merger;

        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }

        tree = (E[]) new Object[4 * arr.length];
        buildSegmentTree(0, 0, data.length - 1);
    }

    //treeIndex：根节点对应在数组中的索引
    //在treeIndex的位置创建表示区间[l...r]的线段树
    private void buildSegmentTree(int treeIndex, int l, int r) {
        if (l == r){
            tree[treeIndex] = data[l];
            return;
        }
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        int mid = l + (r - l) / 2;
        buildSegmentTree(leftTreeIndex, l, mid);
        buildSegmentTree(rightTreeIndex, mid + 1, r);

        tree[treeIndex] = merger.merge(tree[leftTreeIndex],tree[rightTreeIndex]);
    }

    public E get(int index){
        if (index < 0 || index >= data.length)
            throw new IllegalArgumentException("Index is illegal.");
        return data[index];
    }

    public int getSize(){
        return data.length;
    }

    //返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
    private int leftChild(int index){
        return 2 * index + 1;
    }

    private int rightChild(int index){
        return 2 * index + 2;
    }

    //返回区间[queryL,queryR]的值
    public E query(int queryL,int queryR){
        if (queryL < 0 || queryL >= data.length || queryR < 0 || queryR >= data.length)
            throw new IllegalArgumentException("Index is illegal.");

        return query(0,0,data.length - 1, queryL,queryR);
    }


    //在以treeIndex为根的线段树中[l...r]的范围里，搜索区间[queryL...queryR]的值
    private E query(int treeIndex, int l, int r, int queryL, int queryR){
        if (l == queryL && r == queryR)
            return tree[treeIndex];

        int mid = l + (r - l) / 2;
        int leftChildIndex = leftChild(treeIndex);
        int rightChildIndex = rightChild(treeIndex);

        if (queryL >= mid + 1)
            return query(rightChildIndex,mid + 1, r,queryL,queryR);
        else if (queryR <= mid)
            return query(leftChildIndex, l, mid, queryL,queryR);
        E leftResult = query(leftChildIndex,l,mid,queryL,mid);
        E rightResult = query(rightChildIndex,mid + 1,r,mid + 1,queryR);
        return merger.merge(leftResult,rightResult);

    }

    //将索引为index上的值更新为e
    public void set(int index, E e){
        if (index < 0 || index >= data.length)
            throw new IllegalArgumentException("Index is illegal.");

        data[index] = e;
        set(0,0,data.length - 1,index,e);
    }

    private void set(int treeIndex, int l, int r,int index,E e){
        if (l == r){
            tree[treeIndex] = e;
            return;
        }
        int mid = l + (r - l) / 2;
        int leftChildIndex = leftChild(treeIndex);
        int rightChildIndex = rightChild(treeIndex);

        if (index >= mid + 1)
            set(rightChildIndex,mid + 1,r,index,e);
        else
            set(leftChildIndex,l,mid,index,e);

        tree[treeIndex] = merger.merge(tree[leftChildIndex],tree[rightChildIndex]);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append('[');
        for(int i = 0 ; i < tree.length ; i ++){
            if(tree[i] != null)
                res.append(tree[i]);
            else
                res.append("null");

            if(i != tree.length - 1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }
}
