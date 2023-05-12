package Company;

public class PersonalCustomerAccount extends CustomerAccount
{

   private static int pAccRefNo = 1000;


   public void welcome() {
     super.welcome();
   }


   public PersonalCustomerAccount(String Newname, String nAddress)
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




