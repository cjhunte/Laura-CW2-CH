package Company;

public class PersonalCustomerAccounts extends CustomerAccounts
{




   public void welcome() {
     super.welcome();
   }

   public static int getPerAccNum (int pAccRefNo, int NewAccNum)
   {
      return pAccRefNo = NewAccNum + 1;
   }
   public PersonalCustomerAccounts()
   {
      super();
   }

   public PersonalCustomerAccounts(String Newname,  int NewAccNum, String nAddress)
   {
      super(Newname,  NewAccNum, nAddress);
   }

   @Override


   protected String getstatus()
   {
      return ("personal accounts");
   }




}




