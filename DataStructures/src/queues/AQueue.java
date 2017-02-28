package queues;


public class AQueue<E>
//  	  extends QueueByCompositionWithArrayList<E>
    extends QueueByCompositionWithLRStruct<E>
//    extends HeapByCompositionWithArray<E>
//    extends HeapByCompositionWithBRStruct<E>
    implements IQueue<E> {}

