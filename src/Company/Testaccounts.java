package Company;

import java.text.DecimalFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Testaccounts
{
static Scanner scany = new Scanner(System.in);

public static String gettext(String message)
{
   System.out.print(message);

   return scany.next();

}
   static int pAccRefNo = 1000,bAccRefNo = 2000;
   public static void main(String[]args)
   {


      AccountsArray myarray = new AccountsArray();



      DecimalFormat df = new DecimalFormat("0,000.00");

      String Newname, nAddress;
      double balance, pay;
      int hours, choice ,choice2 = -1,choice3,NewAccNum;
      boolean stats = false;



      do
      {


         System.out.print("please select a choice from the menu\n");
         System.out.print("1 - create a new account\n");
         System.out.print("2 - search for an existing account\n");
         System.out.print("-1 - exit the terminal\n");
         choice = scany.nextInt();

         switch (choice)///this sets up the main option's menu.
         {
            case 1:///if case one is chosen then create a new account
            {

               do
               {
                  System.out.print("please select a choice from the menu\n");
                  System.out.print("1 - create a new personal account\n");
                  System.out.print("2 - create a new business account\n");
                  System.out.print("0 - exit the terminal\n");
                  choice2 = scany.nextInt();
               switch (choice2)
               {
                  case 1:
                  {

                     Newname = gettext("Customer name\n");

                     NewAccNum = PersonalCustomerAccounts.getPerAccNum(pAccRefNo);
                     System.out.print(NewAccNum+"\n");

                     nAddress = gettext("customer address\n");

                     PersonalCustomerAccounts PCustomer1 = new PersonalCustomerAccounts(Newname, NewAccNum, nAddress);
                     myarray.insertAcc(PCustomer1);

                  }
                  break;
                  case 2:
                  {
                     Newname = gettext("Customer name\n");

                     NewAccNum = BussinessAccount.getBusAccNum(bAccRefNo);
                     System.out.print(NewAccNum+"\n");

                     nAddress = gettext("customer address\n");

                     BussinessAccount BCustomer1 = new BussinessAccount(Newname, NewAccNum, nAddress);
                     myarray.insertAcc(BCustomer1);

                  }
                  break;


                  default:
                     if (choice2 == 0)
                     {break;}
                     else
                        System.out.println("Selection invalid");


               }
            }while (choice2 != 0);

               break;
            }



            case 2:///if case 2 is chosen then we can search for and view a property

               do {

                  System.out.print("please enter the account number you wish to find");

                  int AccRefSearch = Integer.parseInt(scany.next());
                  myarray.findAccByNumber(AccRefSearch);
                  for (int i=0; i < myarray.Getaccountsamount(); i++)
                     if (myarray.getCurrent(i).getAccRefNo() == AccRefSearch)
                     {
                        System.out.println(myarray.getCurrent(i).tostring());
                        stats = true;
                     }
               }while (!stats);


            System.out.print("please select a choice from the menu \n");

            System.out.print("1 - Record a new sale \n");

            System.out.print("2 - Make a payment \n");

            System.out.print("3 - Display the current balance \n");

            System.out.print("4 - Check account details \n");

            System.out.print("5 - For business change discount\n");

            System.out.print("-1 - exit the terminal\n");

            choice3 = scany.nextInt();


            switch

            (choice3)
            {
            case 1:



            }////switch end
            break;





            case 3:///allows the user to exit the program.
               if (choice == -1) ;
               break;
            default:
               if ((choice < 0) || (choice > 5))
                  System.out.println("Selection invalid");
               else
                  java.lang.System.exit(-1);


         }


      } while (choice != -1);



   }


}

