package Company;

public class PersonalCustomerAccounts extends CustomerAccounts
{



   @Override
   public void getAccRefNo()
   {
      super.getAccRefNo(

              int 

      );
   }
/*
   static int getAccRefNo (int pAccRefNo)
   {
      return pAccRefNo + 1;
   }*/
   public PersonalCustomerAccounts()
   {
      super();
   }

   public PersonalCustomerAccounts(String Newname,  int NewAccNum, String nAddress)
   {
      super(Newname,  NewAccNum, nAddress);
   }

   @Override
   protected void welcome() {
      super.welcome();
   }

   protected String getstatus()
   {
      return ("Personal Accounts");
   }

}




