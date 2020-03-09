package Henrik;
import java.time.*;
class SilverMember extends BonusMember{
    public SilverMember(int memberNo, Personals personals, LocalDate enrolledDate, int poeng){
        super(memberNo, personals, enrolledDate);
        super.registerPoints(poeng);
    }

    @Override
    public void registerPoints(int pointss){
        double point = (double)pointss;
        point = point*1.2;
        int outpoints = (int)point;
        super.registerPoints(outpoints);
    }
}