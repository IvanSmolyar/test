package com.test.ivan.app.ui.activity;

public class SyncSparseArray<E> implements Cloneable {
    private static final int[] EMPTY_INTS = new int[0];
    private static final Object[] EMPTY_OBJECTS = new Object[0];
    private static final Object DELETED = new Object();

    private boolean mGarbage = false;

    private int[] mKeys;
    private Object[] mValues;
    private int mSize;

    public SyncSparseArray() {
        this(10);
    }

    public SyncSparseArray(int initialCapacity) {
        if (initialCapacity == 0) {
            mKeys = EMPTY_INTS;
            mValues = EMPTY_OBJECTS;
        } else {
            initialCapacity = idealIntArraySize(initialCapacity);
            mKeys = new int[initialCapacity];
            mValues = new Object[initialCapacity];
        }
        mSize = 0;
    }

    @Override
    @SuppressWarnings("unchecked")
    public synchronized SyncSparseArray<E> clone() {
        SyncSparseArray<E> clone = null;
        try {
            clone = (SyncSparseArray<E>) super.clone();
            clone.mKeys = mKeys.clone();
            clone.mValues = mValues.clone();
        } catch (CloneNotSupportedException ignored) {
        }
        return clone;
    }

    public synchronized E get(int key) {
        return get(key, null);
    }

    @SuppressWarnings("unchecked")
    public synchronized E get(int key, E valueIfKeyNotFound) {
        int i = binarySearch(mKeys, mSize, key);

        if (i < 0 || mValues[i] == DELETED) {
            return valueIfKeyNotFound;
        } else {
            return (E) mValues[i];
        }
    }

    public synchronized void delete(int key) {
        int i = binarySearch(mKeys, mSize, key);

        if (i >= 0) {
            if (mValues[i] != DELETED) {
                mValues[i] = DELETED;
                mGarbage = true;
            }
        }
    }

    public synchronized void remove(int key) {
        delete(key);
    }

    public synchronized void removeAt(int index) {
        if (mValues[index] != DELETED) {
            mValues[index] = DELETED;
            mGarbage = true;
        }
    }

    public synchronized void removeAtRange(int index, int size) {
        final int end = Math.min(mSize, index + size);
        for (int i = index; i < end; i++) {
            removeAt(i);
        }
    }

    private synchronized void gc() {
        int n = mSize;
        int o = 0;
        int[] keys = mKeys;
        Object[] values = mValues;

        for (int i = 0; i < n; i++) {
            Object val = values[i];

            if (val != DELETED) {
                if (i != o) {
                    keys[o] = keys[i];
                    values[o] = val;
                    values[i] = null;
                }

                o++;
            }
        }

        mGarbage = false;
        mSize = o;
    }

    public synchronized void add(int key, E value) {
        int i = binarySearch(mKeys, mSize, key);

        if (i >= 0) {
            mValues[i] = value;
        } else {
            i = ~i;

            if (i < mSize && mValues[i] == DELETED) {
                mKeys[i] = key;
                mValues[i] = value;
                return;
            }

            if (mGarbage && mSize >= mKeys.length) {
                gc();

                i = ~binarySearch(mKeys, mSize, key);
            }

            if (mSize >= mKeys.length) {
                int n = idealIntArraySize(mSize + 1);

                int[] nkeys = new int[n];
                Object[] nvalues = new Object[n];

                System.arraycopy(mKeys, 0, nkeys, 0, mKeys.length);
                System.arraycopy(mValues, 0, nvalues, 0, mValues.length);

                mKeys = nkeys;
                mValues = nvalues;
            }

            if (mSize - i != 0) {
                System.arraycopy(mKeys, i, mKeys, i + 1, mSize - i);
                System.arraycopy(mValues, i, mValues, i + 1, mSize - i);
            }

            mKeys[i] = key;
            mValues[i] = value;
            mSize++;
        }
    }

    public synchronized int size() {
        if (mGarbage) {
            gc();
        }

        return mSize;
    }

    public synchronized int keyAt(int index) {
        if (mGarbage) {
            gc();
        }

        return mKeys[index];
    }

    @SuppressWarnings("unchecked")
    public synchronized E valueAt(int index) {
        if (mGarbage) {
            gc();
        }

        return (E) mValues[index];
    }

    public synchronized void setValueAt(int index, E value) {
        if (mGarbage) {
            gc();
        }

        mValues[index] = value;
    }

    public synchronized int indexOfKey(int key) {
        if (mGarbage) {
            gc();
        }

        return binarySearch(mKeys, mSize, key);
    }

    public synchronized int indexOfValue(E value) {
        if (mGarbage) {
            gc();
        }

        for (int i = 0; i < mSize; i++) {
            if (mValues[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public synchronized void clear() {
        int n = mSize;
        Object[] values = mValues;

        for (int i = 0; i < n; i++) {
            values[i] = null;
        }

        mSize = 0;
        mGarbage = false;
    }

    public synchronized void append(int key, E value) {
        if (mSize != 0 && key <= mKeys[mSize - 1]) {
            add(key, value);
            return;
        }

        if (mGarbage && mSize >= mKeys.length) {
            gc();
        }

        int pos = mSize;
        if (pos >= mKeys.length) {
            int n = idealIntArraySize(pos + 1);

            int[] nkeys = new int[n];
            Object[] nvalues = new Object[n];

            System.arraycopy(mKeys, 0, nkeys, 0, mKeys.length);
            System.arraycopy(mValues, 0, nvalues, 0, mValues.length);

            mKeys = nkeys;
            mValues = nvalues;
        }

        mKeys[pos] = key;
        mValues[pos] = value;
        mSize = pos + 1;
    }

    @Override
    public synchronized String toString() {
        if (size() <= 0) {
            return "SyncSparseArray{}";
        }

        StringBuilder buffer = new StringBuilder(mSize * 2);
        buffer.append("SyncSparseArray{");
        for (int i = 0; i < mSize; i++) {
            if (i > 0) {
                buffer.append(", ");
            }
            int key = keyAt(i);
            buffer.append(key);
            buffer.append('=');
            Object value = valueAt(i);
            buffer.append(value);
        }
        buffer.append('}');
        return buffer.toString();
    }

    private static int idealIntArraySize(int need) {
        return idealByteArraySize(need * 4) / 4;
    }

    private static int idealByteArraySize(int need) {
        for (int i = 4; i < 32; i++) {
            if (need <= (1 << i) - 12) {
                return (1 << i) - 12;

            }
        }
        return need;
    }

    private int binarySearch(int[] array, int size, int value) {
        int lo = 0;
        int hi = size - 1;

        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            int midVal = array[mid];

            if (midVal < value) {
                lo = mid + 1;
            } else if (midVal > value) {
                hi = mid - 1;
            } else {
                return mid;  // value found
            }
        }
        return ~lo;  // value not present
    }

}
