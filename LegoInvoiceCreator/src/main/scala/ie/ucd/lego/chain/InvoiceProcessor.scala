package ie.ucd.lego.chain

import ie.ucd.lego.composite.*

trait InvoiceProcessor:
  def addProcess(process: Process) : Unit
  def removeAllProcess : Unit

  def process(invoice : Invoice) : Invoice



