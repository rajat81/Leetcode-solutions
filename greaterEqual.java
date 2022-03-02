    void solve(int TC) throws Exception {
        int[] a = new int[] {2,5,10,11,18,20,21,25,30,31,32,33,38,50,61,80,91,93};

        pl(greaterEqual(a, 35));
    }

    int greaterEqual(int[] a, int find) {
        int n = a.length-1;
        return binSearch(a, 0, n, find);
    }

    int binSearch(int[] a, int low, int high, int find) {
        if(low == high) return a[low] >= find ? a[low] : a[low-1];
        {
            int mid = low+(high-low)/2;

            if(a[mid] > find) {
                return binSearch(a, low, mid, find);
            } else {
                return binSearch(a, mid+1, high, find);
            }
        }

    }
