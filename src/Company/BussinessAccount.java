package Company;

import java.text.DecimalFormat;

public class BussinessAccount extends CustomerAccounts

{
   private double Discount = 0.1;
   private double balance = 0;
   public static int BusAccNum = 2001;
   DecimalFormat df = new DecimalFormat("0,000.00");

   public BussinessAccount()
   {
      super();
   }

   public BussinessAccount(String Newname, int NewAccNum, String nAddress)
   {
      super(Newname, NewAccNum , nAddress);
   }
   public static int getBusAccNum (int bAccRefNo)
   {
      return bAccRefNo = bAccRefNo + 1;
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
   protected void welcome()
   {
      System.out.println("welcome to Business class");
   }
   public String tostring()
   {
      return (super.tostring() + " Monthly Pay:  £" + df.format(applyDiscount(balance)) + "\n");
   }
   protected String getstatus()
   {
      return ("Business");
   }

}
