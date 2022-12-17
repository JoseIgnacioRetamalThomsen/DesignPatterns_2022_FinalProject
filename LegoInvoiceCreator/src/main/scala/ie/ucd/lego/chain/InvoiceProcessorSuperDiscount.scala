package ie.ucd.lego.chain

class InvoiceProcessorSuperDiscount extends InvoiceProcessor :
  addProcess(MinimumOrderProcess(Option.empty, 100.0, 25.0))
  addProcess(DiscountProcess(Option.empty, 100, 0.05))
  addProcess(DiscountProcess(Option.empty, 150, 0.1))
