package Henrik;
import java.time.*;
class BasicMember extends BonusMember{
    public BasicMember(int memberNo, Personals personals, LocalDate enrolledDate){
        super(memberNo, personals, enrolledDate,"BasicMember");
    }
}