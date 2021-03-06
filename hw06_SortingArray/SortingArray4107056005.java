public class SortingArray4107056005 extends SortingArray {
	int temp = 0;
	int[] A;

	public SortingArray4107056005() {
	}

	@Override
	public int[] sorting(int[] A) {
		this.A = A;
		compute(0, A.length);
		return A;
	}

	protected void compute(int low, int high) {
		if (high - low < 30) {
			for (int i = low + 1; i < high; ++i)
				for (int j = i; j > low; --j)
					if (A[j] < A[j - 1]) {
						temp = A[j];
						A[j] = A[j - 1];
						A[j - 1] = temp;
					} else
						break;
		} else {
			int mid = ((high + low) >> 1);
			compute(low, mid);
			compute(mid, high);
			merge(low, mid, high);
		}
	}

	private void merge(int low, int middle, int high) {
		if (A[middle - 1] <= A[middle])
			return;
		int[] copy = new int[high - low];
		System.arraycopy(A, low, copy, 0, copy.length);
		int copyLow = 0, copyHigh = high - low, copyMiddle = middle - low;
		for (int i = low, p = copyLow, q = copyMiddle; i < high; i++)
			if (q >= copyHigh || (p < copyMiddle && copy[p] < copy[q]))
				A[i] = copy[p++];
			else
				A[i] = copy[q++];
	}
}
