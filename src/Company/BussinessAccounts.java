package Company;

import java.text.DecimalFormat;

public class BussinessAccounts extends CustomerAccounts

{
   private static int bAccRefNo = 2000;
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

   protected double setdiscount(double NewDiscount)
   {
     return Discount = NewDiscount;
   }

   public double getDiscount(double PaymentAmount)
   {
      return PaymentAmount * Discount;
   }

   @Override

   public String ToString()
   {
      return (super.ToString() + "\n"+"The discount available to the user is "+ Discount +"\n");
   }
   protected String getstatus()
   {
      return ("\nTo Business Accounts");
   }



}
