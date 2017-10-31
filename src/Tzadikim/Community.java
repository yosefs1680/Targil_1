package Tzadikim;

import java.util.*;

public class Community {
    private List<CommunityMember> communityMembers = new ArrayList<>();
    private Map<Volunteering, Integer> volunteeringIntegerMap = new HashMap<>();

    public void addCommunityMember(CommunityMember communityMember){
        communityMembers.add(communityMember);
    }
    public int calcSumOfTax(){
        int taxSum = 0;
        for (Iterator<CommunityMember> memberIterator = communityMembers.iterator(); memberIterator.hasNext();) {
            CommunityMember nextMember = memberIterator.next();
            taxSum += nextMember.taxForMember();
        }
        return taxSum;
    }
    public int askForGmach(CommunityMember communityMember){
        return communityMember.maxRightsValue() - communityMember.getGmachUsed();
    }

    public Map<Volunteering, Integer> calcVolunteeringHours() {
        int physical = 0,
            spiritual = 0,
            musical = 0;
        for (Iterator<CommunityMember> memberIterator = communityMembers.iterator(); memberIterator.hasNext(); ) {
            CommunityMember nextMember = memberIterator.next();
            switch (nextMember.getVolunteering()) {
                case PHYSICAL: physical++;
                    break;
                case SPIRITUAL: spiritual++;
                    break;
                case MUSICAL: musical++;
                    break;
                default: break;
            }
        }
        volunteeringIntegerMap.put(Volunteering.PHYSICAL, physical);
        volunteeringIntegerMap.put(Volunteering.SPIRITUAL, spiritual);
        volunteeringIntegerMap.put(Volunteering.MUSICAL, musical);

        return volunteeringIntegerMap;
    }

    public static void main(String[] args) {

    }
}