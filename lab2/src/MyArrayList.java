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
		strlist.add(1, "A");
		strlist.add(1, "B");
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

		if (array[index] == null) {
			array[index] = element;
		} else {
			array[index+1] = array[index];
		}
		array[index] = element;
	}

	@Override
	public boolean add(E e) {
		/* ska implementeras */
		return false; /* bara med för att Eclipse inte ska klaga */
	}

        // -- 4 --
    
	@Override
	public E get(int index) {
		/* ska implementeras */
		return null; /* bara med för att Eclipse inte ska klaga */
	}

	@Override
	public E set(int index, E element) {
		/* ska implementeras */
		return null; /* bara med för att Eclipse inte ska klaga */
	}

	// -- 5 --

	@Override
	public E remove(int index) {
		/* ska implementeras */
		return null; /* bara med för att Eclipse inte ska klaga */
	}

	protected void removeRange(int fromIndex, int toIndex) {
		/* ska implementeras */
	}

	// -- 6 --

	@Override
	public int indexOf(Object o) {
		/* ska implementeras */
		return -1; /* bara med för att Eclipse inte ska klaga */
	}

	@Override
	public boolean remove(Object o) {
		/* ska implementeras */
		return false; /* bara med för att Eclipse inte ska klaga */
	}
    
	@Override
	public boolean contains(Object o) {
		/* ska implementeras */
		return false; /* bara med för att Eclipse inte ska klaga */
	}

	// -- 7 --

	@Override
	public Object clone() {
		/* ska implementeras */
		return null; /* bara med för att Eclipse inte ska klaga */
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
