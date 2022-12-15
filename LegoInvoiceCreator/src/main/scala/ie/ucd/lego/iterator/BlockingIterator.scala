package ie.ucd.lego.iterator

import ie.ucd.lego.composite.Invoice

import java.util.concurrent.BlockingQueue
import scala.collection.mutable.*
import scala.concurrent.Future

trait BlockingIteratorComponent[T]:
  val blockingIterator: BlockingIterator[T]

trait BlockingIterator[T]():
  def setQueue(outQueue: BlockingQueue[Future[T]]):Unit
  def next: Future[T]

class BlockingIteratorImp[T]() extends BlockingIterator[T]() :

  var q1: Queue[Future[T]] = Queue[Future[T]]()
  var outQueue : BlockingQueue[Future[T]] = null

  override def setQueue(outQueue: BlockingQueue[Future[T]]):Unit =
    this.outQueue = outQueue

  override def next: Future[T] =
    var isFutureReady = false
    var toReturn: Future[T] = null
    while (!isFutureReady) {

      var isBlockingQueueEmpty = outQueue.isEmpty
      var isQ1Empty = q1.isEmpty
      if (isQ1Empty) {
        toReturn = outQueue.take()
      } else if (isBlockingQueueEmpty) {
        toReturn = q1.dequeue()
      } else {
        if (math.random() > 0.5) {
          toReturn = outQueue.take()
        } else {
          toReturn = q1.dequeue()
        }
      }
      if (toReturn.isCompleted) {
        isFutureReady = true
      } else {
        q1.enqueue(toReturn)
      }
    }
    toReturn




