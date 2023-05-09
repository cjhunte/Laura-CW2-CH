package Company;

public class PersonalCustomerAccounts extends CustomerAccounts
{


   public static int getPerAccNum (int pAccRefNo)
   {
      return pAccRefNo = pAccRefNo + 1;
   }
   public PersonalCustomerAccounts()
   {
      super();
   }

   public PersonalCustomerAccounts(String Newname,  int NewAccNum, String nAddress)
   {
      super(Newname,  NewAccNum, nAddress);
   }

   protected String getstatus()
   {
      return ("Personal");
   }

}




