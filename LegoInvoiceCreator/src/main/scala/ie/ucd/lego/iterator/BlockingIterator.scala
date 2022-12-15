package ie.ucd.lego.iterator

import ie.ucd.lego.composite.Invoice

import java.util.concurrent.BlockingQueue
import scala.collection.mutable.*
import scala.concurrent.Future

trait BlockingIterator[T]():
  def setQueue(outQueue: BlockingQueue[Future[T]]): Unit

  def next: Future[T]






