package Tzadikim;

import java.util.Date;

public class SingleMember extends CommunityMember {
    private int studyYears;

    public SingleMember(int id, Gender gender, String name, String birthday,
                        int toraHoursInWeek, int businessHoursInWeek,
                        int income, int gmachUsage, Volunteering volunteering,
                        int volunteeringHours, int studyYears)
    {
        super(id, gender, name, birthday, toraHoursInWeek, businessHoursInWeek, income, gmachUsage, volunteering,volunteeringHours);
        this.studyYears=studyYears;

    }

    public int getStudyYears() {
        return studyYears;
    }
    public void setStudyYears(int studyYears) {
        this.studyYears = studyYears;
    }

    @Override
    public int maxRightsValue() {// returns 0 because its a single member
        return 0;
    }
}