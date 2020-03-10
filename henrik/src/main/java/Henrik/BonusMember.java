package Henrik;
import java.beans.Transient;
import java.time.*;
class BonusMember{
    private final int memberNo;
    private final LocalDate enrolledDate;
    private final Personals personals;
    private int point = 0;
    public BonusMember(int memberNo, Personals personals, LocalDate enrolledDate){
        if(personals==null||enrolledDate==null){
            throw new IllegalArgumentException("personals cannot be null");
        }
        this.memberNo = memberNo;
        this.enrolledDate=enrolledDate;
        this.personals=personals;
    }

    public int getMemberNo(){
        return memberNo;
    }

    public LocalDate getEnrolledDate(){
        return enrolledDate;
    }

    public int getPoints(){
        return point;
    }

    public void registerPoints(int pointss){
        this.point=point+pointss;
    }

    public Personals getPersonals(){
        return personals;
    }
    /**
     * Throws exception if somehow the input LocalDate was of a null value.
     * If the localDate in this method was null there could be issues with a important feature,
     * namely the upgrading of members. this is serious enough to prepare for even though the localdate is usually
     * input as LocalDate.now();
     * @param idag
     * @return
     */
    public int findQualificationPoints(LocalDate idag){
        if(idag==null){
            throw new IllegalArgumentException("LocalDate idag cannot be of null value");
        }
        int dagerMellom = Period.between(idag, enrolledDate).getDays();
        int monthsMellom = Period.between(idag, enrolledDate).getMonths();
        int yearsMellom = Period.between(idag, enrolledDate).getYears();
        int totalDays = -(dagerMellom+(monthsMellom*31)+(yearsMellom*365));
        if(totalDays<=365){
            return point;
        }else{
            return 0;
        }
    }


    public boolean okPassword(String password){
        return this.personals.okPassword(password);
    }
}