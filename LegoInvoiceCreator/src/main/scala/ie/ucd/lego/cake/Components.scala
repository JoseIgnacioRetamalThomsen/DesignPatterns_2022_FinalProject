package ie.ucd.lego.cake

import ie.ucd.lego.composite.Invoice
import ie.ucd.lego.iterator.BlockingIteratorComponent
import ie.ucd.lego.service.{InvoiceParserServiceComponent, InvoiceProcessorServiceComponent, QueueComponent}

trait Components
  extends InvoiceProcessorComponent
    with InvoiceProcessorServiceComponent
    with QueueComponent
    with InvoiceParserServiceComponent
    with BlockingIteratorComponent[Invoice]
