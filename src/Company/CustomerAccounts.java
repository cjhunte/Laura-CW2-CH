package Company;





abstract class CustomerAccounts
{


   public static String POUND = "\u00A3";
   private String name;
   private int AccRefNo;

   private String Address;
   private double balance = 00.00;

   public CustomerAccounts()
   {



   }

   public CustomerAccounts(String Newname, int NewAccNum, String nAddress)
   {
      AccRefNo = NewAccNum;
      name = Newname;
      Address = nAddress;

   }


   protected int getAccRefNo()
   {
     return this.AccRefNo;
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
   public void setaccnum(int NewAccNum)
   {
      AccRefNo = NewAccNum + 1;
   }

   public void setAddress(String nAddress)
   {
      this.Address = nAddress;
   }

   protected void Payment (double PaymentAmount)

   {
      balance = balance - PaymentAmount;
   }

   protected void RecordSale(double SaleAmount)
   {
      balance = balance + SaleAmount;
   }

   protected void welcome(){
      System.out.println(getstatus() + " Array");
   }

   public String AccDetails()
   {
      return "******************************"+"\n"+"Customer number " + AccRefNo + " is called " + name+ "\n"+"and lives at " + Address;
   }
   public String DisplayBalance()
   {
      return  "The customer has a balance of " + POUND + balance + "\n";
   }

   abstract protected String getstatus();



}

