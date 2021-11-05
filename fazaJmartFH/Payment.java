package fazaJmartFH;

public class Payment extends Invoice
{
   public int productCount;
   Shipment shipment;
   
   public Payment (int id, int buyerId, int productId, int productCount,Shipment shipment)
   {
       super(id, buyerId, productId);
       this.productCount = productCount;
       this.shipment = shipment;
   }
   
   public double getTotalPay()
   {
       return 0;    
   }
}
