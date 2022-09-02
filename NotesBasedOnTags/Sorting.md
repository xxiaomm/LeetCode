
- [Merge Sort](#merge-sort)
  - [算法过程](#算法过程)
  - [Implement](#implement)
- [Quick Sort](#quick-sort)
  - [](#)
  - [Implement](#implement-1)
  - [Quick Select](#quick-select)
- [Bucket Sort](#bucket-sort)
  - [算法过程](#算法过程-1)
  - [Implement](#implement-2)

<img src="../images/Sorting/Sorting总结图.png" width="700px">

[菜鸟](https://github.com/hustcc/JS-Sorting-Algorithm)

## Merge Sort

[labuladong](https://labuladong.github.io/algo/2/21/41/)   

分治法（Divide and Conquer）的一个非常典型的应用。
归并排序其实就是二叉树的后序遍历。

两种实现方法：
- 自上而下的递归（所有递归的方法都可以用迭代重写，所以就有了第 2 种方法）；
- 自下而上的迭代；   

### 算法过程

1. 使用一个同等大小的辅助数组, 用来保存每次已排序的结果;
2. 每次把数组对半分, 分别排序两个子数组;
3. 利用双指针技巧, 分别指向两个子数组的起始位置, 像合并两个 sorted list的过程一样, 将两个已排序数组合并成完整的排序数组;
4. 若有一个指针先一步到达子数组末尾, 则把另一个子数组剩下的全部元素直接合并过去;
   

<img src="../images/Sorting/mergeSort.gif" width="700px">

### Implement


```java
// 自下而上的迭代
class Merge {

    // 用于辅助合并有序数组
    private static int[] temp;

    public static void sort(int[] nums) {
        // 先给辅助数组开辟内存空间
        temp = new int[nums.length];
        // 排序整个数组（原地修改）
        sort(nums, 0, nums.length - 1);
    }

    // 定义：将子数组 nums[lo..hi] 进行排序, O(n)
    private static void sort(int[] nums, int lo, int hi) {
        if (lo == hi) {
            // 单个元素不用排序
            return;
        }
        // 这样写是为了防止溢出，效果等同于 (hi + lo) / 2
        int mid = lo + (hi - lo) / 2;
        // 先对左半部分数组 nums[lo..mid] 排序
        sort(nums, lo, mid);
        // 再对右半部分数组 nums[mid+1..hi] 排序
        sort(nums, mid + 1, hi);
        // 将两部分有序数组合并成一个有序数组
        merge(nums, lo, mid, hi);
    }

    // 将 nums[lo..mid] 和 nums[mid+1..hi] 这两个有序数组合并成一个有序数组, 执行 logn 次 -> O(nlogn)
    private static void merge(int[] nums, int lo, int mid, int hi) {
        // 先把 nums[lo..hi] 复制到辅助数组中
        // 以便合并后的结果能够直接存入 nums
        for (int i = lo; i <= hi; i++) 
            temp[i] = nums[i];

        // 数组双指针技巧，合并两个有序数组
        int i = lo, j = mid + 1;
        for (int p = lo; p <= hi; p++) {
            if (i == mid + 1) {     // 左半边数组已全部被合并
                nums[p] = temp[j++];
            } else if (j == hi + 1) {   // 右半边数组已全部被合并
                nums[p] = temp[i++];
            } else if (temp[i] > temp[j]) {
                nums[p] = temp[j++];
            } else {
                nums[p] = temp[i++];
            }
        }
    }
}

```


```java
// 自上而下的递归
public class MergeSort implements IArraySort {

    @Override
    public int[] sort(int[] sourceArray) throws Exception {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        if (arr.length < 2) {
            return arr;
        }
        int middle = (int) Math.floor(arr.length / 2);

        int[] left = Arrays.copyOfRange(arr, 0, middle);
        int[] right = Arrays.copyOfRange(arr, middle, arr.length);

        return merge(sort(left), sort(right));
    }

    protected int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0;
        while (left.length > 0 && right.length > 0) {
            if (left[0] <= right[0]) {
                result[i++] = left[0];
                left = Arrays.copyOfRange(left, 1, left.length);
            } else {
                result[i++] = right[0];
                right = Arrays.copyOfRange(right, 1, right.length);
            }
        }

        while (left.length > 0) {
            result[i++] = left[0];
            left = Arrays.copyOfRange(left, 1, left.length);
        }

        while (right.length > 0) {
            result[i++] = right[0];
            right = Arrays.copyOfRange(right, 1, right.length);
        }

        return result;
    }

}
```


## Quick Sort

[labuladong](https://labuladong.github.io/algo/2/21/45/)

快速排序就是一个二叉树的前序遍历。

### 

1. 从所有元素中挑出一个元素, 称为 “基准”（pivot）, 一般是数组的第一个元素;
2. 对数组进行排序, “基准”先不动, 采用一个index = pivot + 1, index及其前面是所有比 “基准” 小的, index后面是所有比 “基准” 大的, 最后“基准”和index处的元素交换, 此时, “基准”前面的元素都比它小, 后面的元素都比它大, “基准” 处在其正确位置;
3. 

<img src="../images/Sorting/quickSort.gif" width="700px">

### Implement

```java
public class QuickSort implements IArraySort {

    @Override
    public int[] sort(int[] sourceArray) throws Exception {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        return quickSort(arr, 0, arr.length - 1);
    }

    private int[] quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(arr, left, right);
            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }
        return arr;
    }

    private int partition(int[] arr, int left, int right) {
        // 设定基准值（pivot）
        int pivot = left;
        int index = pivot + 1;  // index及其前面都是比基准小的
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index - 1);    // 交换基准和index
        return index - 1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
```

### Quick Select




## Bucket Sort

### 算法过程   


### Implement

```java

```