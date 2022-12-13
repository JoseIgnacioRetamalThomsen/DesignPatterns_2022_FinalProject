package ie.ucd.lego

case class InvoiceRequest(invoiceId:String,components : List[ComponentRequest])

case class ComponentRequest(id:String, amount: Int)
