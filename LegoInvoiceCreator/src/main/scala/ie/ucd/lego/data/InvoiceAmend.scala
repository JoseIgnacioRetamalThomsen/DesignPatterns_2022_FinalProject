package ie.ucd.lego.data

case class InvoiceAmend(amount: Double, description: String):
  override def toString: String = s"${description} amount: €${amount}"
