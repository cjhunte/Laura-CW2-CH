package Company;





abstract class CustomerAccounts
{


   public static String POUND = "\u00A3";
   private String name;
   private int AccRefNo = 0000;

   private String Address;
   private double balance = 00.00;

   public CustomerAccounts()
   {

   }

   public CustomerAccounts(String Newname, int NewAccNum,String nAddress)
   {
      AccRefNo = NewAccNum;
      name = Newname;
      Address = nAddress;
   }


   public void getAccRefNo(int Newref)
   {
     AccRefNo = Newref;
   }
   protected String getName()
   {
      return name;
   }
   protected String getAddress()
   {
      return Address;
   };


   public void setname(String Newname)
   {
      this.name = Newname;
   }
   public void setnum(int NewAccNum)
   {
      this.AccRefNo = NewAccNum;
   }

   public void setAddress(String nAddress)
   {
      this.Address = nAddress;
   }

   protected void Payment (double PaymentAmount)
   {
      balance = balance - PaymentAmount;
   }

   protected double RecordSale(double SaleAmount)
   {
      balance = balance + SaleAmount;
      return balance;
   }

   protected void welcome(){
      System.out.println("welcome to the" + getstatus() + "class");
   }

   public String tostring()
   {
      return "Customer number " + AccRefNo + " is called " + name + " \n " +" and lives at " + Address;
   }
   public String DisplayBalance()
   {
      return "the customer has a balance of " + POUND + balance + "\n";
   }

   abstract protected String getstatus();



}

