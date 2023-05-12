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




/*
   public static void main(String[]args)
   {








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


            switch (choice3)
            {
            case 1:
            {
              saleamount = Double.parseDouble(gettext("please enter the total amount of the sale. \n"));


            }


            case 2:
            {

            }




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
*/


   public static void main(String[]args)
   {



   String Newname = "", nAddress= "";
   double balance, pay, saleamount, Discount = 0;
   int hours, choice , choice2 = -1,choice3,choice4;
   boolean stats = false;
   AccountsArray myarray = new AccountsArray();
   DecimalFormat df = new DecimalFormat("0,000.00");






   do {
      System.out.print("***************************************************************************\n");

      choice = Integer.parseInt(gettext("Is your account business or personal. "+"Please press 1 for personal and 2 for Business\n"));

      System.out.print("***************************************************************************\n");


      switch (choice)
      {


         case 1://contains personal account code.
         {
            PersonalCustomerAccounts defaultcus = new PersonalCustomerAccounts(Newname, nAddress);
            defaultcus.welcome();


            do {
               System.out.print("******************************************\n");
            System.out.print("please select a choice from the menu\n");
            System.out.print("1 - create a new account\n");
            System.out.print("2 - search for an existing account\n");
            System.out.print("0 - exit the terminal\n");

            choice2 = scany.nextInt();


               switch (choice2)
               {

                  case 1:
                  {

                     Newname = gettext("Customer name\n");

                     nAddress = gettext("customer address\n");

                     PersonalCustomerAccounts PCustomer = new PersonalCustomerAccounts(Newname, nAddress);
                     myarray.insertAcc(PCustomer);

                  }break;

                  case 2:///////case 2 start.
                  {


                     int i = 0;

                           do {
                              try {
                              System.out.print("please enter the account number you wish to find starting with 1XXX");

                           int AccRefSearch = Integer.parseInt(scany.next());

                           myarray.findAccByNumber(AccRefSearch);
                              for (i = 0; i < myarray.Getaccountsamount(); i++)
                              {
                                 if (myarray.getCurrent(i).getAccRefNo() == AccRefSearch)
                                 {
                                    System.out.println(myarray.getCurrent(i).tostring());
                                    stats = true;
                                 }
                              }

                        } catch (ArrayIndexOutOfBoundsException |NumberFormatException e)
                        {
                           System.out.println("Error: Index is out of bounds.\nAccount does not exist");


                        }

                        }while (!stats) ;
                        if (stats){




                     System.out.print("Make a sale \n");
                     System.out.print("Make a payment\n");
                     System.out.print("Display balance \n");
                     System.out.print("Display details \n");


                     choice4 = Integer.parseInt(gettext("please select your action for this account\n"));


                     switch (choice4)
                     {


                     case 1:
                     {
                        try{
                           double SaleAmount = Double.parseDouble(gettext("please enter the amount payed to you\n"));
                           System.out.println(i);
                           myarray.getCurrent(i).RecordSale(SaleAmount);
                           myarray.getCurrent(i).DisplayBalance();

                        }catch (IndexOutOfBoundsException e)
                        {
                           System.out.println("Error: Please enter a valid value");
                           break;

                        }

                     }
                     break;

                     case 2:
                     {
                        double PaymentAmount = Double.parseDouble(gettext("please enter the amount payed\n"));

                        myarray.getCurrent(i).Payment(PaymentAmount);
                     }
                     break;

                     }while (choice4 != 0);

                        }

                  }//////case 2 end

                     default:
                     {
                        if ((choice2 < 0) ||(choice2 > 2))
                        System.out.println("Selection invalid");
                        break;
                     }
               }

               }while (choice2 != 0);
               break;

            }









            case 2:
            {

               BussinessAccounts DefBcus = new BussinessAccounts(Newname, nAddress, Discount);
               DefBcus.welcome();


               do {
                  System.out.print("******************************************\n");
                  System.out.print("please select a choice from the menu?\n");
                  System.out.print("1 - create a new account\n");
                  System.out.print("2 - search for an existing account\n");
                  System.out.print("0 - exit the terminal\n");

                  choice3 = scany.nextInt();


                  switch (choice3)
                  {

                     case 1:
                     {


                        Newname = gettext("Customer name\n");

                        nAddress = gettext("customer address\n");

                        Discount = Double.parseDouble(gettext("Discount to be used\n"));

                        BussinessAccounts BCustomer = new BussinessAccounts(Newname, nAddress, Discount );
                        myarray.insertAcc(BCustomer);


                     }

                     case 2:
                     {
                        do {

                           System.out.print("please enter the account number you wish to find starting with 2XXX");

                           int AccRefSearch = Integer.parseInt(scany.next());
                           myarray.findAccByNumber(AccRefSearch);
                           for (int i=0; i < myarray.Getaccountsamount(); i++)
                              if (myarray.getCurrent(i).getAccRefNo() == AccRefSearch)
                              {
                                 System.out.println(myarray.getCurrent(i).tostring());
                                 stats = true;
                              }
                        }while (!stats);
                     }

                     default:
                     {
                        if ((choice3 < 0) ||(choice3 > 2))
                           System.out.println("Selection invalid");
                     }
                  }

               }while (choice3 != 0);
               break;

            }
            default:
               if ((choice < 0) || (choice > 2))
                  System.out.println("Selection invalid");


            }
            }while (choice != 0);


            }



}

