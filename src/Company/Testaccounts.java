package Company;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Testaccounts
{
static Scanner scany = new Scanner(System.in);

public static String gettext(String message)
{
   System.out.print(message);

   return scany.next();

}

   public static void main(String[]args)
   {
      DecimalFormat df = new DecimalFormat("0,000.00");

      String Newname, nAddress;
      double balance, pay;
      int hours, choice = -2,choice2 = -1,NewAccNum,AccRefNo = 1001,bAccRefNo = 2001;


      do
      {


         System.out.print("please select a choice from the menu\n");
         System.out.print("1 - create a new account\n");
         System.out.print("2 - search for an existing account\n");
         System.out.print("-1 - exit the terminal\n");
         choice = scany.nextInt();

         switch (choice)///this sets up the main option's menu.
         {
            case 1:///if case one is chosen then create a new account.
               if (choice == 1) ;
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

                     NewAccNum = PersonalCustomerAccounts.getPerAccNum(AccRefNo);
                     System.out.print(NewAccNum+"\n");

                     nAddress = gettext("customer address\n");

                     PersonalCustomerAccounts Customer1 = new PersonalCustomerAccounts(Newname, NewAccNum, nAddress);


                  }
                  break;
                  case 2:
                  {
                     Newname = gettext("Customer name\n");

                     NewAccNum = BussinessAccount.getBusAccNum(bAccRefNo);
                     System.out.print(NewAccNum+"\n");

                     nAddress = gettext("customer address\n");

                     BussinessAccount Customer1 = new BussinessAccount(Newname, NewAccNum, nAddress);


                  }
                  break;


                  default:
                     if ((choice < 0) || (choice > 2))
                        System.out.println("Selection invalid");


               }
            }while (choice != 0);

            }
            break;


            case 2:///if case 2 is chosen then we can search for and view a property

            if (choice == 2) ;
            {


            }
            break;
            case 3:///allows the user to exit the program.
               if (choice == 0) ;
               break;
            default:
               if ((choice < 0) || (choice > 5))
                  System.out.println("Selection invalid");
               else
                  java.lang.System.exit(0);


         }


      } while (choice != -1);



   }


}

