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
    }//removeAcc



}

