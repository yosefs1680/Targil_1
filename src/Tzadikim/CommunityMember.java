package Tzadikim;

import java.util.Date;

public abstract class CommunityMember implements DebtsAndRights {
    private int id;
    private Gender gender;
    private String name;
    private Date birthday;
    private int toraHoursInWeek;
    private int businessHoursInWeek;
    private int income;
    private int gmachUsed;
    private Volunteering volunteering;
    private int volunteeringHours;

    //c-tor
    public CommunityMember(int id, Gender gender, String name, Date birthday, int toraHoursInWeek,
                           int businessHoursInWeek, int income, int gmachUsed, Volunteering volunteering,
                           int volunteeringHours) {
        try {
            if (toraHoursInWeek + businessHoursInWeek < (6*5))
                throw new Exception("Not enough hours of activity per week to sign in");
            }
        catch (Exception ex){
            return;
        }

        this.id = id;
        this.gender = gender;
        this.name = name;
        this.birthday = new Date(String.valueOf(birthday));
        this.toraHoursInWeek = toraHoursInWeek;
        this.businessHoursInWeek = businessHoursInWeek;
        this.income = income;
        this.gmachUsed = gmachUsed;
        this.volunteering = volunteering;
        this.volunteeringHours = volunteeringHours;
    }

    //Getter & Setter
    public Volunteering getVolunteering() {
        return volunteering;
    }
    public void setVolunteering(Volunteering volunteering) {
        this.volunteering = volunteering;
    }

    public int getVolunteeringHours() { return volunteeringHours; }
    public void setVolunteeringHours(int volunteeringHours) {
        this.volunteeringHours = volunteeringHours; }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Gender getGender() {
        return gender;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(Date birthday) {
        this.birthday = new Date(String.valueOf(birthday));
    }

    public int getToraHoursInWeek() {
        return toraHoursInWeek;
    }
    public void setToraHoursInWeek(int toraHoursInWeek) {
        this.toraHoursInWeek = toraHoursInWeek;
    }

    public int getBusinessHoursInWeek() {
        return businessHoursInWeek;
    }
    public void setBusinessHoursInWeek(int businessHoursInWeek) {
        this.businessHoursInWeek = businessHoursInWeek;
    }

    public int getIncome() {
        return income;
    }
    public void setIncome(int income) {
        this.income = income;
    }

    public int getGmachUsed() {
        return gmachUsed;
    }
    public void setGmachUsed(int gmachUsed) {
        this.gmachUsed = gmachUsed;
    }


    public TaxLevel taxCase(){
        if (this.income <= 5280)
            return TaxLevel.FIRST;
        if (this.income <9010 )
            return TaxLevel.SECOND;
        if (this.income <14000 )
            return TaxLevel.THIRD;
        if (this.income <20000 )
            return TaxLevel.FORTH;
        if (this.income <41830 )
            return TaxLevel.FIFTH;
        if (this.income <67630 )
            return TaxLevel.SIXTH;
        return TaxLevel.MAX;
    }

    //the calculate of the taxes is by the internet;
    @Override
    public int taxForMember() {
        if (this.getToraHoursInWeek() >= 40)// = Talmid Chaham: 8 hours in a day for 5 days
            return 0;
        else {
            TaxLevel thisLevel = taxCase();
            int sumOfTaxes = 0;
            switch (thisLevel) {
                case FIRST: {
                    sumOfTaxes += this.getIncome()*0.1;
                    return sumOfTaxes;
                }
                case SECOND: {
                    sumOfTaxes += (this.getIncome()-thisLevel.levelToTax())*0.14 + 528;
                    return sumOfTaxes;
                }
                case THIRD: {
                    sumOfTaxes += (this.getIncome()-thisLevel.levelToTax())*0.21 + 1050;
                    return sumOfTaxes;
                }
                case FORTH: {
                    sumOfTaxes += (this.getIncome()-thisLevel.levelToTax())*0.31 + 2098;
                    return sumOfTaxes;
                }
                case FIFTH: {
                    sumOfTaxes += (this.getIncome()-thisLevel.levelToTax())*0.34 + 3958;
                    return sumOfTaxes;
                }
                case SIXTH: {
                    sumOfTaxes += (this.getIncome()-thisLevel.levelToTax())*0.48 + 11380;
                    return sumOfTaxes;
                }
                case MAX: {
                    sumOfTaxes += (this.getIncome()-thisLevel.levelToTax())*0.50 + 37180;
                    return sumOfTaxes;
                }
                default:
                    return sumOfTaxes;
            }
        }
    }

    @Override
    public int recommendedVolunteerHours() {
        if (this.birthday.getYear()<1960)return 0;
        int recoValunteer= 0;
        recoValunteer+= (24*7 - toraHoursInWeek - businessHoursInWeek)*0.2;
        if (gender == Gender.FEMALE)
            recoValunteer/=2;
        switch (volunteering){
            case SPIRITUAL: {
                recoValunteer *= (1/2);
                break;
            }
            case MUSICAL:{
                recoValunteer *= (1/3);
                break;
            }
            case PHYSICAL:{
                recoValunteer *= (1/4);
                break;
            }
        }
        return recoValunteer;
    }
}
