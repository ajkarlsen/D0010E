package lab2;

import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

@SuppressWarnings("serial")
public class MyArrayList<E> implements Serializable, Cloneable, Iterable<E>,
		Collection<E>, List<E>, RandomAccess {
		private E[] array;
		private int size = 0;



	public static void main(String[] args) {
		MyArrayList<String> test = new MyArrayList<>();
	}

	public MyArrayList(int initialCapacity) {
		if (initialCapacity < 0) {
			throw new IllegalArgumentException();
		} else {
			array = (E[]) new Object[initialCapacity];
		}
	}

	public  MyArrayList() {
		array = (E[]) new Object[10];
	}

	// -- 1 --

	public void indexCheck(int index, int storlek){
		if ((index < 0 || index >= storlek)) {
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		} else {
			return false;
	}
}
	@Override
	public void clear() {
		size = 0;
	}

	// -- 2 --

	public void ensureCapacity(int minCapacity) {

		if (minCapacity > array.length) {
			int nyKap = array.length * 2;
			E[] newArray = (E[]) new Object[nyKap];

			for (int i = 0; i < size; i++) {
				newArray[i] = this.array[i];
			}
			this.array = newArray;
		}
	}

	public void trimToSize() {
		int nyKap = size;
		E[] newArray = (E[]) new Object[nyKap];
		for (int i = 0; i < size; i++) {
			newArray[i] = array[i];
		}
		this.array = newArray;
	}
    
	// -- 3 --
    
	@Override
	public void add(int index, E element) {
		indexCheck(index, size+1);

		this.ensureCapacity(size + 1);
		if (array[index] == null) {
			array[index] = element;
		} else {
			for (int i = size; i > index; i--) {
				array[i] = array[i-1];
			}
		}
		array[index] = element;
		size ++;
	}

	@Override
	public boolean add(E e) {
		this.add(size, e);
		return true;
	}

        // -- 4 --
    
	@Override
	public E get(int index) {
		this.indexCheck(index, size);
		return this.array[index];
	}

	@Override
	public E set(int index, E element) {
		this.indexCheck(index,size);

		E old = this.array[index];
		array[index] = element;
		return old;
	}

	// -- 5 --

	@Override
	public E remove(int index) {

		this.indexCheck(index, size);
		E old = this.array[index];
		for (int i = index; i < size - 1; i++) {
			array[i] = array[i+1];
		}
		array[size-1] = null;
		size --;
		return old;
	}

	protected void removeRange(int fromIndex, int toIndex) {
		if ((fromIndex < 0 || fromIndex >= size || toIndex > size || toIndex < fromIndex)) {
			throw new IndexOutOfBoundsException();
		}
		for (int i = fromIndex; i < toIndex; i++) {
			this.remove(fromIndex);
		}
	}

	// -- 6 --

	@Override
	public int indexOf(Object o) {

		for (int i = 0; i < size; i++) {
			if (array[i].equals(o)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public boolean remove(Object o) {
		int index = this.indexOf(o);
		if (index != -1) {
			remove(index);
			return true;
		} else {
			return false;
		}
	}
    
	@Override
	public boolean contains(Object o) {
		if (this.indexOf(o) == -1) {
			return false;
		} else {
			return true;
		}
	}

	// -- 7 --

	@Override
	public Object clone() {
		MyArrayList<E> klon = new MyArrayList<>(size);
		for (int i = 0; i < size; i++) {
			klon.array[i] = this.array[i];
		}
		klon.size = this.size;
		return klon;
	}

	@Override
	public Object[] toArray() {
		E[] newArray = (E[]) new Object[size];
		for (int i = 0; i < size; i++) {
			newArray[i] = this.array[i];
		}

		return newArray;
	}

	// --- Rör ej nedanstående kod -----------------------------------

	public MyArrayList(Collection<? extends E> c) {
		throw new UnsupportedOperationException();
	}

	private class InternalIterator implements Iterator {
		int current = 0;

		@Override
		public boolean hasNext() {
			return current < size();
		}

		@Override
		public Object next() {
			return get(current++);
		}

	}

	@Override
	public Iterator<E> iterator() {
		return new InternalIterator();
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public int lastIndexOf(Object o) {
		throw new UnsupportedOperationException();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ListIterator<E> listIterator() {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void forEach(Consumer<? super E> action) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Spliterator<E> spliterator() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean removeIf(Predicate<? super E> filter) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void replaceAll(UnaryOperator<E> operator) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void sort(Comparator<? super E> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

}
