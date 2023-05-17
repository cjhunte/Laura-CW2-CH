package Company;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class Testaccounts
{
static Scanner scany = new Scanner(System.in);
static Scanner numScany = new Scanner(System.in);
static Scanner Dscan = new Scanner(System.in);

   public static boolean isNumeric(String strNum) {
      if (strNum == null)
      {
         return false;
      }
      try {
         int num = Integer.parseInt(strNum);
      } catch (NumberFormatException | NoSuchElementException exception)
      {
         System.out.print("not a number");//prints a message to the user
         return false;
      }
      return true;

   }

   public static String gettext(String message)//stores the message for later use to be overridden
   {
   System.out.print(message);//prints the message to ask for input

   return scany.nextLine();//takes a string value and stores it as whatever value is declared

   }

   public static int getnumber(String message)//stores the message for later use to be overridden
   {
      System.out.print(message);//prints the message to ask for input


      return numScany.nextInt();//takes a string value and stores it as whatever value is declared

   }
   public static double getdouble(String message)//stores the message for later use to be overridden
   {
      System.out.print(message);//prints the message to ask for input

      return Dscan.nextDouble();//takes a string value and stores it as whatever value is declared

   }


   public static void main(String[]args)
   {
      String Newname, nAddress ;
      double Discount = 0.1;
      int choice, choice2, choice3;
      boolean stats = false;
      AccountsArray myarray = new AccountsArray();
      DecimalFormat df = new DecimalFormat("0,000.00");





            do//do loop for the whole program and the main menu meaning the user cannot exit until they have confirmed it.

            {

         System.out.print("************************************\n");//prints a message to the user

         System.out.print("1 - create a new account\n");//prints a message to the user
         System.out.print("2 - search for an existing account\n");//prints a message to the user
         System.out.print("0 - To Exit program.\n");//prints a message to the user
         System.out.print("************************************\n");//prints a message to the user

         choice = (getnumber("please select a choice from the menu\n"));//takes user input for the first menu as choice.


         switch (choice)///this sets up the main option's menu.
         {

            case 1:///if case one is chosen then create a new account
            {

               do {
                  System.out.print("************************************\n");//prints a message to the user
                  System.out.print("1 - create a new personal account\n");//prints a message to the user
                  System.out.print("2 - create a new business account\n");//prints a message to the user
                  System.out.print("0 - Exit to Create or search accounts menu\n");//prints a message to the user
                  System.out.print("**********************************\n");//prints a message to the user

                  choice2 = (getnumber("please select a choice from the menu\n"));//takes user input for the first menu as choice.

                  switch (choice2) //switch statement for the second menu of account creation choose business or personal
                  {
                     case 1: //personal account option
                     {

                        Newname = gettext("Customer name\n");//uses the gettext method to set the new customer name.

                        nAddress = gettext("customer address\n");//uses the gettext method to set the new customer address.



                        PersonalCustomerAccounts PCustomer = new PersonalCustomerAccounts(Newname, nAddress);//creates a Personal customer account and stores the related values
                        myarray.insertAcc(PCustomer);//inserts the object PCustomer into the array


                     }
                     break;
                     case 2: //business account option.
                     {

                        Newname = gettext("Customer name\n");//uses the gettext method to set the new customer name.

                        nAddress = gettext("customer address\n");//uses the gettext method to set the new customer address.

                        System.out.println("Business Discount is "+Discount);//prints the discount available to the business user


                        BussinessAccounts BCustomer = new BussinessAccounts(Newname, nAddress, Discount);//creates a business customer account and stores the related values
                        myarray.insertAcc(BCustomer);//inserts the object BCustomer into the array


                     }break;



                     default:
                        if (choice2 < 0 || choice2 > 2 || choice == 3) {//if the choice is more than 2 or less than 0 print the selection is invalid
                           System.out.println("Selection invalid");//print text to the user
                        }


                  }
               } while (choice2 != 0);//runs the second menu until the user exits the menu to

               break;
            }


            case 2:///if case 2 is chosen then we can search for, view and edit the users account

               int index = 0; //initializes the value index to be used throughout case two.


               do//do search while an account has not been found.
               {
                  try//try the search and catch ArrayIndexOutOfBoundsException and NumberFormatException exceptions.
                  {
                     System.out.print("*************************************************************************\n");//print text to the user

                     System.out.print("please enter the account number you wish to find starting with 1XXX or 2XXX\n");//print text to the user

                     System.out.print("Press 0 to return if you have no account\n");//print text to the user


                     System.out.print("*************************************************************************\n");//print text to the user


                     int AccRefSearch = Integer.parseInt(scany.next());//takes the value to be used in the array search.

                     if(myarray.customerAccountlist.size() > 0)//if the array is empty prints and error to the user.
                     {



                        for (int i = 0; i < myarray.Getaccountsamount(); i++)//searches the arrays elements until an account is found.
                        {
                           if (myarray.getCurrent(i).getAccRefNo() == AccRefSearch)//if the search finds a matching account continue.
                           {
                              System.out.println(myarray.getCurrent(i).ToString());//prints the users details
                              stats = true;//sets the value that runs our do loop to the exit value.
                              index = i;//holds the position in the array as index
                           }else //if the search fails then account is not found
                           {
                              System.out.print("Account not in array\n");//print text to the user
                              break;
                           }
                        }
                     }
                     else
                     {
                        System.out.print("Error: Cannot search an empty array\n");//print text to the user

                     }break;
                  } catch (ArrayIndexOutOfBoundsException | NumberFormatException exception)//handles all other search related errors.
                  {
                     System.out.println("Error: Index is out of bounds or you need to try\n starting with 1XXX or 2XXX and fill in your details");//print text to the user

                  }break;

               }while (!stats);//ends the do while statement when stats is true
               if (stats) //if stats is true continue
               {

                  do//do the code while the user has not selected 0
                  {

                     System.out.print("**********************************\n");//print text to the user

                     System.out.print("1 - Make a sale \n");//print text to the user

                     System.out.print("2 - Make a payment\n");//print text to the user

                     System.out.print("3 - Display balance \n");//print text to the user

                     System.out.print("4 - Display details \n");//print text to the user

                     System.out.print("5 - Change Discount For Business only\n");//print text to the user

                     System.out.print("Press 0 to exit to main menu. \n");//print text to the user

                     System.out.print("**********************************\n");//print text to the user


                     choice3 = (getnumber("please select your action for this account\n"));//takes the value of the account editing menu



                     switch (choice3) //starts the account editing menu
                     {


                        case 1://allows the user to enter a sale so money gets added to the account.
                        {
                           try //try entering a sale amount and print error if not a double.
                           {
                              System.out.print("**********************************\n");//print text to the user


                              double SaleAmount = (getdouble("Please enter the amount paid to you\n"));//takes a double value for sale amount.

                              myarray.getCurrent(index).RecordSale(SaleAmount);//gets the current account and adds the sale amount to the balance.

                              System.out.print("**********************************\n");//print text to the user

                              System.out.println(myarray.getCurrent(index).DisplayBalance());//prints the users balance to confirm money was added to the account

                           } catch (TypeNotPresentException | InputMismatchException exception) //catch error if user enters the wrong value in sale amount such as letters.
                           {
                              System.out.print("Error: Please enter a valid value\n");//print text to the user

                              break;

                           }

                        }
                        break;


                        case 2: //allows the user to deduct money for a purchase
                        {
                           try //try entering a PaymentAmount and print error if not a double
                           {

                              double PaymentAmount = (getdouble("please enter the amount you paid.\n"));// takes payment amount and stores it as a double.

                              char[] bus = Arrays.toString(new int[]{myarray.getCurrent(index).getAccRefNo()}).toCharArray();//converts the account reference number into a Char array like this [XXXX]
                              char first = bus[1];//selects the second element of the character array and stores it as a character

                              if (first == '2')//if the account is business continue
                              {
                                 myarray.getCurrent(index).getDiscount(PaymentAmount);//gets the discount to be applied
                                 myarray.getCurrent(index).Payment(PaymentAmount-myarray.getCurrent(index).getDiscount(PaymentAmount));//takes the discounted amount off the balance
                              } else if (first == '1')//default function for personal accounts
                              {
                                 myarray.getCurrent(index).Payment(PaymentAmount);//takes the payment amount off the balance
                              }

                              System.out.println(myarray.getCurrent(index).DisplayBalance());// prints the users balance.
                           } catch (IndexOutOfBoundsException| TypeNotPresentException | InputMismatchException e) //catch error if user enters the wrong value in Payment amount such as letters.
                           {
                              System.out.println("Error: Please enter a valid value");//print text to the user

                              break;

                           }
                           break;
                        }

                        case 3: {
                           System.out.println("**********************");//print text to the user

                           System.out.println(myarray.getCurrent(index).DisplayBalance());// prints the users balance.
                        }
                        break;

                        case 4: {
                           System.out.println("**********************");//print text to the user

                           System.out.println(myarray.getCurrent(index).ToString());//prints the users details.
                        }
                        break;

                        case 5:
                        {
                           char[] bus = Arrays.toString(new int[]{myarray.getCurrent(index).getAccRefNo()}).toCharArray();//converts the account reference number into a Char array like this [XXXX]
                           char first = bus[1];//selects the second element of the character array and stores it as a character

                           if (first == '2')//if business enter new discount
                           {
                              System.out.println("**********************");//print text to the user

                              double NewDiscount = (getdouble("Please enter your new Discount\n"));//print text to the user and stores new discount as a double

                              System.out.println("Updated Discount is "+ NewDiscount+(myarray.getCurrent(index).setdiscount(NewDiscount)));//sets the discount to new discount
                           } else if (first == '1')//if personal print error and exit to menu
                           {
                              System.out.println("**********************");//print text to the user

                              System.out.println("Please only use with business accounts");//print text to the user

                           }
                        }break;
                        default:
                           if ((choice3 < 0) || (choice3 >=5))//if edit menu is not within range print error
                              System.out.println("Selection invalid");//print text to the user


                     }
                  } while (choice3 != 0);//while the user has not selected exit menu loop menu
               }



            case 0:///allows the user to exit the program.
               break;



            default:
               if ((choice < 0) || (choice >= 2))//if edit menu is not within range print error
                  System.out.println("Selection invalid");//print text to the user




         }



      }while (0 != choice) ;//while the user has not selected exit program loop program


   }
}







