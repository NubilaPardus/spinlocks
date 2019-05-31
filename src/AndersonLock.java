import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Anderson Queue Lock
 * 
 * @author NubilaPardus
 * @name AndersonLock
 * @implements Lock
 * @class
 */
public class AndersonLock implements Lock {

	AtomicInteger tail;
	boolean[] flag;
	int size;
	ThreadLocal<Integer> threadLocalIndex = new ThreadLocal<Integer>() {
		@Override
		protected Integer initialValue() {
			return 0;
		}
	};

	/**
	 * Constructor
	 * 
	 * @param capacity max number of array slots
	 */
	public AndersonLock(int capacity) {
		size = capacity;
		tail = new AtomicInteger(0);
		flag = new boolean[capacity];
		flag[0] = true;
	}

	@Override
	public void lock() {
		int slot = tail.getAndIncrement() % size;
		threadLocalIndex.set(slot);
		while (!flag[threadLocalIndex.get()]) {
		}
		// System.out.println(Thread.currentThread().getName() + " locked");
	}

	@Override
	public void unlock() {
		// System.out.println(Thread.currentThread().getName() + " unlocked");
		flag[threadLocalIndex.get()] = false;
		flag[(threadLocalIndex.get() + 1) % size] = true;
	}

	@Override
	public Condition newCondition() {
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public boolean tryLock() {
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void lockInterruptibly() throws InterruptedException {
		throw new java.lang.UnsupportedOperationException();
	}
}