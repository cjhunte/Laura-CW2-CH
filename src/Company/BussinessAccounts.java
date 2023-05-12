package Company;

import java.text.DecimalFormat;

public class BussinessAccounts extends CustomerAccounts

{
   private static int bAccRefNo = 2000;
   public static double Discount = 0.1;
   private double balance = 00.00;
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


   protected double applyDiscount(double balance)
   {
      return balance * Discount;
   }

   protected void setdiscount(double NewDiscount)
   {
      Discount = NewDiscount;
   }

   protected double calculateDiscount()
   {
      return balance + applyDiscount(balance);
   }

   @Override

   public String tostring()
   {
      return (super.tostring() + " Monthly Pay:  £" + df.format(applyDiscount(balance)) + "\n");
   }
   protected String getstatus()
   {
      return ("Business Accounts");
   }

}
