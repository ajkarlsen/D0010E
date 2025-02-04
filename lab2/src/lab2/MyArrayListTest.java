package lab2;
/**
 * Håkan Jonsson, LTU
 */
public class MyArrayListTest {
	private static MyArrayList<Integer> data;
	private static void insert(int n) {
		for (int i = 0; i < n; i++) {
			data.add(i);
		}
	}
	public static void testAvMyArrayList() {
		System.out.println("Test av MyArrayList() starts");
		try {
			data = new MyArrayList<Integer>(-1);
		} catch (IllegalArgumentException e) {
// fungerar; det ska bli IllegalArgumentException
		} catch (Exception e) {
			throw new RuntimeException("MyArrayList 1: " + e);
		}
		data = new MyArrayList<Integer>();
		int N = 100;
		try {
			insert(N);
		} catch (Exception e) {
			System.out.println(e);
			throw new RuntimeException("MyArrayList 2, N==" + N);
		}
		System.out.println("Test av MyArrayList() OK");
	}
	public static void testAvSize() {
		System.out.println("Test av size() starts");
		data = new MyArrayList<Integer>();
		assert data.size() == 0 : "size() 1";
		data.add(1);
		data.add(1);
		data.add(1);
		assert data.size() != 0 : "size() 2";
		System.out.println("Test av size() OK");
	}
	public static void testAvIsEmpty() {
		System.out.println("Test av isEmpty() starts");
		data = new MyArrayList<Integer>();
		assert data.isEmpty() : "isEmpty() 1";
		data.add(1);
		assert !data.isEmpty() : "isEmpty() 2";
		System.out.println("Test av isEmpty() OK");
	}
	public static void testAvClear() {
		System.out.println("Test av clear() starts");
		data = new MyArrayList<Integer>();
		data.add(1);
		assert data.size() > 0 : "clear() 1";
		data.clear();
		assert data.size() == 0 : "clear() 2";
		System.out.println("Test av clear() OK");
	}
	// -- 2 --
// -- 3 --
	public static void testAvAddindex() {
		System.out.println("Test av add(index) startar");
		data = new MyArrayList<Integer>(100);
		try {
			data.add(-1, null);
		} catch (IndexOutOfBoundsException e) {
// fungerar; det ska bli IndexOutOfBoundsException
		} catch (Exception e) {
			throw new RuntimeException("add(index) 1");
		}
		assert data.size() == 0 : "add(index) 2";
		data.add(0, 10);
		data.add(1, 11);
		data.add(2, 12);
		data.add(1, 21);
		data.add(0, 20);
		assert data.get(0) == 20 : "add(index) 3";
		assert data.get(1) == 10 : "add(index) 4";
		assert data.get(2) == 21 : "add(index) 5";
		assert data.get(3) == 11 : "add(index) 6";
		assert data.get(4) == 12 : "add(index) 7";
		System.out.println("Test av add(index) OK");
	}
	public static void testAvAddE() {
		System.out.println("Test av add(E) startar");
		data = new MyArrayList<Integer>();
		insert(4);
		data.add(100);
		assert data.size() == 5 : "add(E) 1";
		assert data.get(4).equals(new Integer(100)) : "add(E) 2";
		System.out.println("Test av add(E) OK");
	}
	// -- 4 --
	public static void testAvGetindex() {
		System.out.println("Test av get(index) startar");
		data = new MyArrayList<Integer>();
		insert(4);
		assert data.get(2).equals(new Integer(2)) : "get(index) 1";
		System.out.println("Test av get(index) OK");
	}
	public static void testAvSetindex() {
		System.out.println("Test av set(index) startar");
		data = new MyArrayList<Integer>();
		insert(5);
		Integer i = data.set(3, new Integer(100));
		assert i.equals(new Integer(3)) : "set(index) 1";
		assert data.get(3).equals(new Integer(100)) : "set(index) 2";
		System.out.println("Test av set(int index, E element) OK");
	}
	// -- 5 --
	public static void testAvRemoveindex() {
		System.out.println("Test av remove(index) startar");
		data = new MyArrayList<Integer>();
		insert(7);
		Integer i = data.remove(2);
		assert data.size() == 6 : "remove(index) 1";
		assert i.equals(new Integer(2)) : "remove(index) 2";
		System.out.println("Test av remove(int index) OK");
	}
	protected static void testAvRemoveRange() {
		System.out.println("Test av removeRange() startar");
		data = new MyArrayList<Integer>();
		insert(6); // 0 .. 5
		data.removeRange(2, 4);
		assert data.contains(0) : "removeRange 1";
		assert data.contains(1) : "removeRange 2";
		assert !data.contains(2) : "removeRange 3";
		assert !data.contains(3) : "removeRange 4";
		assert data.contains(4) : "removeRange 5";
		assert data.contains(5) : "removeRange 6";
		assert !data.contains(6) : "removeRange 7";
		System.out.println("Test av removeRange() OK");
	}
	// -- 6 --
	public static void testAvIndexOf() {
		System.out.println("Test av indexOf(Object o) startar");
		data = new MyArrayList<Integer>();
		insert(5);
		assert data.indexOf(0) == 0 : "";
		assert data.indexOf(4) == 4 : "";
		assert data.indexOf(2) == 2 : "";
		assert data.indexOf(-100) == -1 : "";
		assert data.indexOf(100) == -1 : "";
		System.out.println("Test av indexOf(Object o) OK");
	}
	public static void testAvRemoveobject() {
		System.out.println("Test av remove(Object o) startar");
		data = new MyArrayList<Integer>();
		insert(5);
		assert data.remove(new Integer(0)) : "remove(Object o) 1";
		assert data.remove(new Integer(4)) : "remove(Object o) 2";
		assert !data.remove(new Integer(-100)) : "remove(Object o) 3";
		assert !data.remove(new Integer(100)) : "remove(Object o) 4";
		System.out.println("Test av remove(Object o) OK");
	}
	public static void testAvContainsobject() {
		System.out.println("Test av contains(Object o) startar");
		data = new MyArrayList<Integer>();
		insert(3);
		assert data.contains(0) : "contains(Object o) 1";
		assert data.contains(1) : "contains(Object o) 2";
		assert data.contains(2) : "contains(Object o) 3";
		assert !data.contains(-1) : "contains(Object o) 4";
		assert !data.contains(4) : "contains(Object o) 5";
		System.out.println("Test av contains(Object o) OK");
	}
	// -- 7 --
	private static class IntegerBox {
		int x;
		IntegerBox(int x) {
			this.x = x;
		}
		public boolean equals(IntegerBox box) {
			return this.x == box.x;
		}
	}
	public static void testAvClone() {
		System.out.println("Test av clone() startar");
		data = new MyArrayList<Integer>();
		int N = 3;
		insert(3);
		MyArrayList<Integer> clone = (MyArrayList<Integer>) data.clone();
		assert clone.get(0).equals(data.get(0)) : "clone() 1";
		assert clone.get(1).equals(data.get(1)) : "clone() 2";
		assert clone.get(2).equals(data.get(2)) : "clone() 3";
		clone.set(1, N + 1);
		assert !data.get(1).equals(N + 1) : "clone() 4";
		data.set(2, N + 2);
		assert !clone.get(1).equals(N + 2) : "clone() 5";
		assert data.size() == clone.size() : "clone() 6";
		MyArrayList<IntegerBox> box = new MyArrayList<IntegerBox>();
		box.add(new IntegerBox(10));
		MyArrayList<IntegerBox> box2 = (MyArrayList<IntegerBox>) box.clone();
		assert box.get(0).equals(box2.get(0)) : "clone() 7";
		box.get(0).x = 30;
		assert box.get(0).equals(box2.get(0)) : "clone() 8";
		System.out.println("Test av clone() OK");
	}
	public static void testAvToArray() {
		System.out.println("Test av toArray() startar");
		data = new MyArrayList<Integer>();
		int N = 4;
		insert(4);
		Object[] tmp = (Object[]) data.toArray();
		assert tmp.length == N : "toArray() 1";
		assert (Integer) tmp[1] == 1 : "toArray() 2";
		assert data.get(0) == 0 : "toArray() 3";
		assert data.get(2) == 2 : "toArray() 4";
		assert data.get(3) == 3 : "toArray() 5";
		System.out.println("Test av toArray() OK");
	}
	public static void main(String[] args) {
		System.out.println("MyArrayListTest Version: 2025-02-04");
// Avkommentera nedan de tester du vill genomföra.
// Kom ihåg att aktivera assertions med "-ea" i Eclipse (annars
// fungerar testerna inte.
//
// Innan rättningen/presentationen ska alla tester ge OK.
		testAvMyArrayList();
		testAvSize();
		testAvIsEmpty();
		testAvClear();
		testAvAddindex();
		testAvAddE();
		testAvGetindex();
		testAvSetindex();
		testAvRemoveindex();
		testAvRemoveRange();
		testAvIndexOf();
		testAvRemoveobject();
		testAvContainsobject();
		testAvClone();
		testAvToArray();
	}
}