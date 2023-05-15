package Company;

import java.text.DecimalFormat;

public class BussinessAccounts extends CustomerAccounts

{
   private static int bAccRefNo = 2001;
   public static double Discount = 0.1;
   private double balance = 00.00;
   private double SaleAmount = 0;
   DecimalFormat df = new DecimalFormat("0,000.00");

   public BussinessAccounts()
   {
      super();
   }

   public BussinessAccounts(String Newname, String nAddress, double Discount)
   {
      super(Newname, bAccRefNo , nAddress);
      bAccRefNo++;
   }

   protected void setdiscount(double NewDiscount)
   {
      Discount = NewDiscount;
   }

   public double calculateDiscount(double SaleAmount)
   {
      return SaleAmount * Discount;
   }

   @Override

   public String AccDetails()
   {
      return (super.AccDetails() + " Monthly Pay:  £" + (calculateDiscount(balance)) + "\n");
   }
   protected String getstatus()
   {
      return ("\n to Business Accounts");
   }



}
