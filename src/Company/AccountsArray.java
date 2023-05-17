package Company;
import java.util.List;
import java.util.ArrayList;

public class AccountsArray
{
   public List<CustomerAccounts> customerAccountlist;

    // Constructor to create an array of references to Property objects
    public AccountsArray() {
       customerAccountlist = new ArrayList<CustomerAccounts>();
    }//ArrayOfProprties

    // Returns the index of a users account
    protected CustomerAccounts getCurrent(int i) {

        return customerAccountlist.get(i);
    }//getCurrent

    // Return the number of properties registered by the Estate Agent
    protected int Getaccountsamount() {
       return customerAccountlist.size();
    }//getNoOfProperties

    // Return first line of the address of a property at a particular index position


    // Add Property object to the array
    protected void insertAcc(CustomerAccounts newacc) {
       this.customerAccountlist.add(newacc);
       System.out.println(newacc.ToString() + " and the account has been Added"+newacc.getstatus());
    }//insert property

    // Remove Property object from the array
    protected void removeAcc(int position) {
       System.out.println(getCurrent(position) + " Removed");
       customerAccountlist.remove(position);
    }//removeProperty



    // **************
    // SEARCH METHODS
    // **************

    // Return index position of property or number = -1 if not found
    protected int findAccByNumber(int AccRefNo) {
       boolean  stats = false;
       int i = 0, index = -1;
       // Keep checking until the street is found or all properties have been checked
       do {
          // Check if the street at the index position equals the street passed as the parameter
          if (customerAccountlist.get(i).equals(AccRefNo)) {
              stats = true;
             index = i;
          }
          i++;
       } while ((! stats) && (i < customerAccountlist.size()));
       // Return the index position of the property with the required street (or -1 if not found)
       return AccRefNo;
    }//findPropertyByStreet



}

