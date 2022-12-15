package ie.ucd.lego.iterator

trait BlockingIteratorComponent[T]:
  val blockingIterator: BlockingIterator[T]
