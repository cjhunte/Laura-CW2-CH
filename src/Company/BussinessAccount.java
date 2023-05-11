package Company;

import java.text.DecimalFormat;

public class BussinessAccount extends CustomerAccounts

{
   private double Discount = 0.1;
   private double balance = 00.00;
   DecimalFormat df = new DecimalFormat("0,000.00");

   public BussinessAccount()
   {
      super();
   }

   public BussinessAccount(String Newname, int NewAccNum, String nAddress)
   {
      super(Newname, NewAccNum , nAddress);
   }
   public static int getBusAccNum (int bAccRefNo, int NaccNum)
   {
      return NaccNum = bAccRefNo + 1;
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
