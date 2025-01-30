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

    	// ---------------------------------------------------------------

	public static void main(String[] args) {
		MyArrayList<String> strlist = new MyArrayList<String>(4);
		// testa metoder härifrån
		strlist.add(0, "A");
		strlist.add(1, "B");
		strlist.add(2, "C");
		strlist.add(3, "D");
		strlist.add(4, "C");
		strlist.add(5, "F");
		strlist.MyArrayList();

	}

    	// ---------------------------------------------------------------
    
	public MyArrayList(int initialCapacity) {
		/* ska implementeras */
		array = (E[]) new Object[initialCapacity];
	}

	public void MyArrayList() {
		/* ska implementeras */
		System.out.println(array[0]);
		System.out.println(array[1]);
		System.out.println(array[2]);
		System.out.println(array[3]);
		System.out.println(array[4]);
		System.out.println(array[5]);

	}

	// -- 1 --

	@Override
	public int size() {
		/* ska implementeras */
		int storlek = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] != null) {
				storlek++;
			}
		}
		return storlek;
	}

	@Override
	public boolean isEmpty() {
		/* ska implementeras */
		if (this.size() == 0) {
			return true;
		} else {
			return false; /* bara med för att Eclipse inte ska klaga */
	}
}
	@Override
	public void clear() {
		/* ska implementeras */
		for (int i = 0; i < array.length; i++) {
			array[i] = null;
		}
	}

	// -- 2 --

	public void ensureCapacity(int minCapacity) {
		/* ska implementeras */
		if (minCapacity > array.length) {
			int nyKap = array.length * 2;
			E[] newArray = (E[]) new Object[nyKap];

			for (int i = 0; i < this.size(); i++) {
				newArray[i] = this.array[i];
			}
			this.array = newArray;
		}
	}

	public void trimToSize() {
		/* ska implementeras */
		int nyKap = this.size();
		E[] newArray = (E[]) new Object[nyKap];
		for (int i = 0; i < array.length; i++) {
			if (array[i] != null) {
				newArray[i] = array[i];
			}
		}
		this.array = newArray;
	}
    
	// -- 3 --
    
	@Override
	public void add(int index, E element) {
		this.ensureCapacity(this.size() + 1);

		if (index < 0 || index > this.size()) {
			throw new IndexOutOfBoundsException();
		}

		if (array[index] == null) {
			array[index] = element;
		} else {
			for (int i = this.size(); i > index; i--) {
				array[i] = array[i-1];
			}
		}
		array[index] = element;
	}

	@Override
	public boolean add(E e) {
		/* ska implementeras */
		this.add(size(), e);
		return true; /* bara med för att Eclipse inte ska klaga */
	}

        // -- 4 --
    
	@Override
	public E get(int index) {
		/* ska implementeras */
		if ((index < 0 || index >= size())) {
			throw new IndexOutOfBoundsException();
		}
		return this.array[index]; /* bara med för att Eclipse inte ska klaga */
	}

	@Override
	public E set(int index, E element) {
		/* ska implementeras */
		if ((index < 0 || index >= size())) {
			throw new IndexOutOfBoundsException();
		}
		E old = this.array[index];
		array[index] = element;
		return old; /* bara med för att Eclipse inte ska klaga */
	}

	// -- 5 --

	@Override
	public E remove(int index) {
		/* ska implementeras */
		if ((index < 0 || index >= size())) {
			throw new IndexOutOfBoundsException();
		}
		E old = this.array[index];
		for (int i = index; i < size() - 1; i++) {
			array[i] = array[i+1];
		}
		array[size()-1] = null;
		return old; /* bara med för att Eclipse inte ska klaga */
	}

	protected void removeRange(int fromIndex, int toIndex) {
		/* ska implementeras */
		if ((fromIndex < 0 || fromIndex >= size() || toIndex > size() || toIndex < fromIndex)) {
			throw new IndexOutOfBoundsException();
		}
		for (int i = fromIndex; i < toIndex; i++) {
			this.remove(fromIndex);
		}

	}

	// -- 6 --

	@Override
	public int indexOf(Object o) {
		/* ska implementeras */
		for (int i = 0; i < this.size(); i++) {
			if (array[i] == o) {
				return i;
			}
		}
		return -1; /* bara med för att Eclipse inte ska klaga */
	}

	@Override
	public boolean remove(Object o) {
		/* ska implementeras */
		if (this.indexOf(o) == -1) {
			return false;
		} else {
			this.remove(this.indexOf(o));
			return true; /* bara med för att Eclipse inte ska klaga */
		}

	}
    
	@Override
	public boolean contains(Object o) {
		/* ska implementeras */
		if (this.indexOf(o) == -1) {
			return false;
		} else {
			return true; /* bara med för att Eclipse inte ska klaga */
		}
	}

	// -- 7 --

	@Override
	public Object clone() {
		/* ska implementeras */
		E[] klon = (E[]) new Object[this.size()];
		for (int i = 0; i < this.size(); i++) {
			klon[i] = array[i];
		}

		return klon; /* bara med för att Eclipse inte ska klaga */
	}

	@Override
	public Object[] toArray() {
		/* ska implementeras */

		return null; /* bara med för att Eclipse inte ska klaga */
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
