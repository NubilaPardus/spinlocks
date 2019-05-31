import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Test-and-test-and-set (TTAS) Lock
 * 
 * @author NubilaPardus
 * @name TTASLock
 * @implements Lock
 * @class
 */
public class TTASLock implements Lock {
	AtomicBoolean atomicBoolean = new AtomicBoolean(false);

	@Override
	public void lock() {
		while (true) {
			while (atomicBoolean.get()) {
			}
			if (!atomicBoolean.getAndSet(true)) {
				// System.out.println(Thread.currentThread().getName() + " locked");
				return;
			}
		}
	}

	@Override
	public void unlock() {
		// System.out.println(Thread.currentThread().getName() + " unlocked");
		atomicBoolean.set(false);
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