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
      String Newname, nAddress ;
      double Discount = 0;
      int choice, choice2, choice3;
      boolean stats = false;
      AccountsArray myarray = new AccountsArray();
      DecimalFormat df = new DecimalFormat("0,000.00");


      do {

         System.out.print("************************************\n");
         System.out.print("please select a choice from the menu\n");
         System.out.print("1 - create a new account\n");
         System.out.print("2 - search for an existing account\n");
         System.out.print("0 - exit the terminal\n");
         System.out.print("************************************\n");
         choice = scany.nextInt();

         switch (choice)///this sets up the main option's menu.
         {
            case 1:///if case one is chosen then create a new account
            {

               do {
                  System.out.print("************************************\n");
                  System.out.print("please select a choice from the menu\n");
                  System.out.print("1 - create a new personal account\n");
                  System.out.print("2 - create a new business account\n");
                  System.out.print("0 - exit the terminal\n");
                  System.out.print("**********************************\n");
                  choice2 = scany.nextInt();
                  switch (choice2) {
                     case 1: {

                        Newname = gettext("Customer name\n");

                        nAddress = gettext("customer address\n");



                        PersonalCustomerAccounts PCustomer = new PersonalCustomerAccounts(Newname, nAddress);
                        myarray.insertAcc(PCustomer);


                     }
                     break;
                     case 2: {

                        Newname = gettext("Customer name\n");

                        nAddress = gettext("customer address\n");

                        Discount = Double.parseDouble(gettext("Discount to be used\n"));


                        BussinessAccounts BCustomer = new BussinessAccounts(Newname, nAddress, Discount);
                        myarray.insertAcc(BCustomer);


                     }break;



                     default:
                        if (choice2 < 0 || choice2 > 2) {
                           System.out.println("Selection invalid");
                        }


                  }
               } while (choice2 != 0);

               break;
            }


            case 2:///if case 2 is chosen then we can search for and view a property

               int index = 0;

               do {
                  try {
                     System.out.print("*************************************************************************\n");

                     System.out.print("please enter the account number you wish to find starting with 1XXX or 2XXX\n");

                     System.out.print("*************************************************************************\n");

                     int AccRefSearch = Integer.parseInt(scany.next());



                     myarray.findAccByNumber(AccRefSearch);
                     for (int i = 0; i < myarray.Getaccountsamount(); i++)
                     {
                        if (myarray.getCurrent(i).getAccRefNo() == AccRefSearch)
                        {
                           System.out.println(myarray.getCurrent(i).AccDetails());
                           stats = true;
                           index = i;
                        }
                     }

                  } catch (ArrayIndexOutOfBoundsException |NumberFormatException e)
                  {
                     System.out.println("Error: Index is out of bounds.\nAccount does not exist");


                  }

               }while (!stats) ;
               if (stats) {

                  do {
                     System.out.print("**********************************\n");
                     System.out.print("1 - Make a sale \n");
                     System.out.print("2 - Make a payment\n");
                     System.out.print("3 - Display balance \n");
                     System.out.print("4 - Display details \n");
                     System.out.print("Press 0 to exit to main menu. \n");
                     System.out.print("**********************************\n");

                     choice3 = Integer.parseInt(gettext("please select your action for this account\n"));



                     switch (choice3) {


                        case 1: {
                           try {
                              System.out.print("**********************************\n");

                              double SaleAmount = Double.parseDouble(gettext("Please enter the amount payed to you\n"));

                              myarray.getCurrent(index).RecordSale(SaleAmount);

                              System.out.print("**********************************\n");
                              System.out.println(myarray.getCurrent(index).DisplayBalance());

                           } catch (IndexOutOfBoundsException e) {
                              System.out.println("Error: Please enter a valid value");
                              break;

                           }

                        }
                        break;


                        case 2: {
                           try {
                              double PaymentAmount = Double.parseDouble(gettext("please enter the amount you paid.\n"));

                              myarray.getCurrent(index).Payment(PaymentAmount);

                              System.out.println(myarray.getCurrent(index).DisplayBalance());
                           } catch (IndexOutOfBoundsException e) {
                              System.out.println("Error: Please enter a valid value");
                              break;

                           }break;
                        }

                        case 3: {
                           System.out.println("**********************");
                           System.out.println(myarray.getCurrent(index).DisplayBalance());
                        }break;

                        case 4: {
                           System.out.println("**********************");
                           System.out.println(myarray.getCurrent(index).AccDetails());
                        }break;
                        default:
                           if ((choice3 < 0) || (choice3 > 4))
                              System.out.println("Selection invalid");


                     }
                  }while(choice3 != 0);
               }


            case 3:///allows the user to exit the program.
               if (choice == -1) ;
               break;
            default:
               if ((choice < 0) || (choice > 5))
                  System.out.println("Selection invalid");
               else
                  java.lang.System.exit(-1);


         }

      }while (choice != -1) ;
   }
}







