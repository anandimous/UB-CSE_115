package queues;

import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class QueueTest {

	@Test public void test() {
		QueueByCompositionWithLRStruct<String> q = new QueueByCompositionWithLRStruct<String>();
		String expectedValue = "Fred";
		try {
			q.enqueue(expectedValue);
			q.dequeue();
			q.enqueue(expectedValue);
			String actualValue = q.peek();
			assertTrue("I enqueued "+expectedValue+", dequeued, then re-enqueued "+expectedValue+", expecting peek to return "+expectedValue+", but instead it returned "+actualValue,
				expectedValue.equals(actualValue));
		}
		catch (EmptyQueueException e) {
			assertTrue("I enqueued "+expectedValue+", dequeued, then re-enqueued "+expectedValue+", expecting peek to return "+expectedValue+", but instead the queue was empty!",
					false);
		}
	}
}
