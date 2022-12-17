package ie.ucd.lego.data

import ie.ucd.lego.data.LegoRequest

case class InvoiceRequest(invoiceId:String,components : List[LegoRequest])

case class LegoRequest(id:String, amount: Int)
