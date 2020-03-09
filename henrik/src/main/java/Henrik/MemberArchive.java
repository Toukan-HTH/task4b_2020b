package Henrik;
import java.time.*;
import java.util.*;
class MemberArchive{
    ArrayList<BonusMember> members;

    public MemberArchive() {
        members = new ArrayList<BonusMember>();
    }

    public boolean registerPoints(int membernr, int poeng){
        boolean result = true;
        for(int i =0;i<members.size();i++){
            if(membernr==members.get(i).getMemberNo()){
                members.get(i).registerPoints(poeng);
                result = false;
            }
        }
        if(!result){
            return true;
        }else{
            return false;
        }
    }

    public int newMember(Personals personalstuff, LocalDate enrollmentDate) {
        int membernr = findAvailableNo();
        members.add(new BasicMember(membernr, personalstuff, enrollmentDate));
        return membernr;
    }

    private int findAvailableNo(){
        boolean loop = true;
        int random =0;
        while(loop){
            random = (int)(Math.random() * ((99999-0+1)))+0;
            for(int i =0; i<members.size();i++){
                if(random==members.get(i).getMemberNo()){
                    loop = false;;
                }
            }
            if(!loop){
                loop=true;
            }else{
                loop=false;
            }
        }
        return random;
    }

    public int findPoints(String password, int membernr){
        int result = -1;
        for(int i = 0; i<members.size();i++){
            if(membernr==members.get(i).getMemberNo()){
                if(members.get(i).okPassword(password)){
                    result=members.get(i).getPoints();
                }
            }
        }
        return result;
    }






    public void checkMembers(){
        for(int i = 0; i<members.size();i++){
            System.out.println("Through member nr " + i);
            if(members.get(i) instanceof BasicMember){
                if(members.get(i).findQualificationPoints(LocalDate.now())>=25000 && members.get(i).findQualificationPoints(LocalDate.now())<=74999){
                    System.out.println("Upgrading basicmember nr " + i + " to Silver");
                    members.set(i, new SilverMember(members.get(i).getMemberNo(), members.get(i).getPersonals(), members.get(i).getEnrolledDate(), members.get(i).getPoints()));
                }
    
                if(members.get(i).findQualificationPoints(LocalDate.now())>=75000){
                    System.out.println("Upgrading basicmember nr " + i + " to Gold");
                    members.set(i, new GoldMember(members.get(i).getMemberNo(), members.get(i).getPersonals(), members.get(i).getEnrolledDate(), members.get(i).getPoints()));
                }
            }

            if(members.get(i) instanceof SilverMember){
                if(members.get(i).findQualificationPoints(LocalDate.now())>=75000){
                    System.out.println("Upgrading silvermember nr " + i + " to Gold");
                    members.set(i, new GoldMember(members.get(i).getMemberNo(), members.get(i).getPersonals(), members.get(i).getEnrolledDate(), members.get(i).getPoints()));
                }
            }
        }
    }



    public static void main(String[] args) throws Exception{
        MemberArchive poop = new MemberArchive();

        boolean start = true;
        while(start){
            Scanner bp = new Scanner(System.in);
            Scanner sc = new Scanner(System.in);
            int svar =0;
            boolean inputrecieved = false;
            System.out.println("\n1: Register new member\n2: Find points of member\n3: Register points to member\n4: Check and upgrade every member that qualifies\n9: Quit");
            String catchAns = sc.nextLine();
            try{
                svar = Integer.parseInt(catchAns);
                if(svar>=5 && svar<9 || svar<=0 || svar>9){
                    System.out.println("Input er ikke et valid alternativ, vennligst input poo nytt");
                }
                if(svar<=4 && svar>0 || svar==9){
                    inputrecieved=true;
                }
            }catch (Exception e){
                System.out.println("ERROR: Feil input. velg et nummer");
            }

            if(inputrecieved){
                if(svar==1){
                    System.out.println("Surname?");
                    String surname = sc.nextLine();
                    System.out.println("Firstname?");
                    String firstname = sc.nextLine();
                    System.out.println("Email adress?");
                    String emailadr = sc.nextLine();
                    System.out.println("Password?");
                    String password = sc.nextLine();
                    System.out.println("Year?");
                    int year = sc.nextInt();
                    System.out.println("Month?");
                    int month = sc.nextInt();
                    System.out.println("Day?");
                    int day = sc.nextInt();
                    System.out.println("memberid = " + poop.newMember(new Personals(surname,firstname,emailadr,password), LocalDate.of(year, month, day)));
                    inputrecieved=false;
                }

                if(svar==2){
                    System.err.println("Member ID?");
                    int membernr = sc.nextInt();
                    System.out.println("Password");
                    String password = bp.nextLine();
                    System.out.println("This member has " + poop.findPoints(password, membernr) + " Points");
                    inputrecieved=false;
                }

                if(svar==3){
                    System.out.println("Member ID?");
                    int membernr = sc.nextInt();
                    System.out.println("Points to add?");
                    int points = bp.nextInt();
                    System.out.println(poop.registerPoints(membernr, points));
                    inputrecieved=false;
                }

                if(svar==4){
                    poop.checkMembers();
                    inputrecieved=false;
                }

                if(svar==9){
                    bp.close();
                    sc.close();
                    start=false;
                }
            }
        }



    }
}