package Company;

public class PersonalCustomerAccounts extends CustomerAccounts
{

   private static int pAccRefNo = 1001;


   public void welcome() {
     super.welcome();
   }


   public PersonalCustomerAccounts(String Newname, String nAddress)
   {
      super(Newname,  pAccRefNo, nAddress);
      pAccRefNo++;
   }


   @Override
   protected String getstatus()
   {
      return ("personal accounts");
   }




}




