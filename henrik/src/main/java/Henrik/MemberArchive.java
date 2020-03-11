package Henrik;
import java.time.*;
import java.util.*;
import java.util.logging.*;
class MemberArchive{
    Log logger;
    ArrayList<BonusMember> members;
    Random r = new Random();

    public MemberArchive() {
        members = new ArrayList<BonusMember>();
        try{
            logger = new Log("App.log");
        }catch(Exception e){
            e.printStackTrace();
        }
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
        try{
            members.add(new BasicMember(membernr, personalstuff, enrollmentDate));
        }catch(IllegalArgumentException e){
            logger.logNewWarning("New member not added. members cannot have empty personal inputs");
        }catch(Exception e){
            e.printStackTrace();
        }
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
            try{
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
            }catch(IllegalArgumentException e){
                logger.logNewWarning("The input LocalDate was of a null value");
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}