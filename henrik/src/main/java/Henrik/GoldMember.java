package Henrik;
import java.time.*;
class GoldMember extends BonusMember{
    public GoldMember(int memberNo, Personals personals, LocalDate enrolledDate, int poeng){
        super(memberNo, personals, enrolledDate);
        super.registerPoints(poeng);
    }

    @Override
    public void registerPoints(int pointss){
        double point = (double)pointss;
        point = point*1.5;
        int outpoints =(int)point;
        super.registerPoints(outpoints);
    }
}