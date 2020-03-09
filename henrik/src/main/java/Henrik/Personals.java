package Henrik;
class Personals{
    private final String surname;
    private final String firstname;
    private final String ePostadr;
    private String password;
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

    public boolean okPassword(String password){
        return this.password.equalsIgnoreCase(password);
    }
}