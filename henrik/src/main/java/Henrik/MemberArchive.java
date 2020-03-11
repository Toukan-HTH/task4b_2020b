package Henrik;
import java.time.*;
import java.util.*;
class MemberArchive{
    ArrayList<BonusMember> members;
    Random r = new Random();

    public MemberArchive() {
        members = new ArrayList<BonusMember>();
    }

    public void removeMember(int index){
        members.remove(index);
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
            random = r.nextInt(9999998)+1;
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

    public ArrayList<BonusMember> getArray(){
        return members;
    }

    public void setArray(ArrayList<BonusMember> newmembers){
        this.members=newmembers;
    }






    public void checkMembers(){
        for(int i = 0; i<members.size();i++){
            if(members.get(i) instanceof BasicMember){
                if(members.get(i).findQualificationPoints(LocalDate.now())>=25000 && members.get(i).findQualificationPoints(LocalDate.now())<=74999){
                    members.set(i, new SilverMember(members.get(i).getMemberNo(), members.get(i).getPersonals(), members.get(i).getEnrolledDate(), members.get(i).getPoints()));
                }
    
                if(members.get(i).findQualificationPoints(LocalDate.now())>=75000){
                    members.set(i, new GoldMember(members.get(i).getMemberNo(), members.get(i).getPersonals(), members.get(i).getEnrolledDate(), members.get(i).getPoints()));
                }
            }

            if(members.get(i) instanceof SilverMember){
                if(members.get(i).findQualificationPoints(LocalDate.now())>=75000){
                    members.set(i, new GoldMember(members.get(i).getMemberNo(), members.get(i).getPersonals(), members.get(i).getEnrolledDate(), members.get(i).getPoints()));
                }
            }
        }
    }
}