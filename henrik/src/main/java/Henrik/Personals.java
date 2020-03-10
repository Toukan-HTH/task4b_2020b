package Henrik;
import javafx.beans.property.*;
class Personals{
    private final String surname;
    private final String firstname;
    private final String ePostadr;
    private String password;
    /**
     * 
     * @param surname
     * @param firstname
     * @param ePostadr
     * @param password
     * throws exception if the arguments are of a null value. there should not be a personals object created
     * without these parameters of a valid input. Personals are supposed to be a complete list of a persons 
     * information. an incomplete one is just messy and takes up space and could brick other processes down the line
     */
    public Personals(String surname, String firstname, String ePostadr, String password){
        if(firstname== null||surname==null||ePostadr==null||password==null||firstname.trim().equals("")||surname.trim().equals("")||ePostadr.trim().equals("")||password.trim().equals("")){
            throw new IllegalArgumentException("et eller flere kontruktør argumenter er null og/eller blanke.");
        }
        this.surname=surname;
        this.firstname=firstname;
        this.ePostadr=ePostadr;
        this.password=password;
    }



    public String getFirstname(){
        return firstname;
    }

    public String getSurname(){
        return surname;
    }

    public String getEPostadr(){
        return ePostadr;
    }

    public String getPassword(){
        return password;
    }

    public boolean okPassword(String password){
        return this.password.equalsIgnoreCase(password);
    }
}