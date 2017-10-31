package Tzadikim;

import java.util.Date;

public class MarriedMember extends CommunityMember{
    private int partnerId;
    private int numOfKids;

    public MarriedMember(int id, Gender gender, String name, Date birthday, int toraHoursInWeek,
                         int businessHoursInWeek, int income, int gmachUsable, Volunteering volunteering,
                         int volunteeringHours, int partnerId, int numOfKids) {
        super(id, gender, name, birthday, toraHoursInWeek, businessHoursInWeek, income, gmachUsable, volunteering,volunteeringHours);
        this.partnerId = partnerId;
        this.numOfKids = numOfKids;

    }

    public int getPartnerId() {
        return partnerId;
    }
    public void setPartnerId(int partnerId) {
        this.partnerId = partnerId;
    }

    public int getNumOfKids() {
        return numOfKids;
    }
    public void setNumOfKids(int numOfKids) {
        this.numOfKids = numOfKids;
    }

    @Override
    //calculate the max sum of Gmach the member can recieve
    public int maxRightsValue() {
        int gmachValue=2000;
        gmachValue+= getNumOfKids()*1500;//1500 for each kid
        gmachValue+= this.getToraHoursInWeek()*100;//100 for each hour tora in a week
        if (this. getIncome()>=5280)
            gmachValue-= (this.getIncome()-5280)*0.1;//reduce 10% of income that higher than minimum
        if (this.getBusinessHoursInWeek()>50)
            gmachValue+= (this.getBusinessHoursInWeek()-50)* 80;
        if (gmachValue<0)
            return 0;
        return gmachValue;
    }

    @Override
    public int recommendedVolunteerHours() {
        int reccoValunteer =super.recommendedVolunteerHours();
        reccoValunteer*= (1/numOfKids);
        reccoValunteer*= (2/3);//because he is married

        return reccoValunteer;
    }
}
