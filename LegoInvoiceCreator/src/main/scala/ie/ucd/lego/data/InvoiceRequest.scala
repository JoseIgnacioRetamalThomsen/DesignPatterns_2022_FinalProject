package ie.ucd.lego.data

import ie.ucd.lego.data.ComponentRequest

case class InvoiceRequest(invoiceId:String,components : List[ComponentRequest])

case class ComponentRequest(id:String, amount: Int)
