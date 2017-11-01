package Tzadikim;
/*
* adir abargil
* and yosef simhony
*/

import java.net.SocketTimeoutException;
import java.util.*;

public class Community {//class to create all community members and make calculates
    private static List<CommunityMember> communityMembers = new ArrayList<>();
    private static Map<Volunteering, Integer> volunteeringIntegerMap = new HashMap<>();
    private static int count=0;

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

    public static Map<Volunteering, Integer> calcVolunteeringHours() {
        int physical = 0,
            spiritual = 0,
            musical = 0;
        for (Iterator<CommunityMember> memberIterator = communityMembers.iterator(); memberIterator.hasNext(); ) {
            CommunityMember nextMember = memberIterator.next();
            switch (nextMember.getVolunteering()) {
                case PHYSICAL: physical+= nextMember.getVolunteeringHours();
                    break;
                case SPIRITUAL: spiritual+= nextMember.getVolunteeringHours();
                    break;
                case MUSICAL: musical+= nextMember.getVolunteeringHours();
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
        SingleMember shimon = new SingleMember(302, Gender.MALE,"Shimon","21/03/1999",45,
                          30,5000,0,Volunteering.SPIRITUAL,20,12);
        communityMembers.add(shimon);
        MarriedMember david = new MarriedMember(303,Gender.MALE,"David","25/03/1993",20,70,
                13000,400,Volunteering.MUSICAL,14,404,4);
        communityMembers.add(david);
        SingleMember dana = new SingleMember(300, Gender.FEMALE,"Dana","02/07/1991",15,
                35,3000,0,Volunteering.PHYSICAL,37,13);
        communityMembers.add(dana);
        MarriedMember yosefa = new MarriedMember(321,Gender.FEMALE,"Yosefa","12/04/1998",3,100,
                10000,0,Volunteering.MUSICAL,5,404,4);
        communityMembers.add(yosefa);
        printAllDitails();
    }
    public static void printAllDitails(){
        System.out.println("_________________Community:_________________");
        System.out.println("");
        for (Iterator<CommunityMember> membersIt = communityMembers.iterator();membersIt.hasNext();) {
            CommunityMember member = membersIt.next();
            printMemberDetails(member);
        }
        calcVolunteeringHours();
        int physical = volunteeringIntegerMap.get(Volunteering.PHYSICAL);
        int musical = volunteeringIntegerMap.get(Volunteering.MUSICAL);
        int spiritual = volunteeringIntegerMap.get(Volunteering.SPIRITUAL);
        System.out.println("_____________Volunteering_hours_____________");
        System.out.println("Total of Volunteering hours in community:");
        System.out.println("Physical: "+ physical);
        System.out.println("Musical: "+ musical);
        System.out.println("Spiritual: "+ spiritual);
        System.out.println( "");


    }

    private static void printMemberDetails(CommunityMember member){
        System.out.println("--------------Community-member"+ count++ +"-------------");
        System.out.println("Name: "+ member.getName()+"\nTax: "+ member.taxForMember() + " ILs.");
        System.out.println("Rights of the Gmach: " + member.maxRightsValue() +" ILs.");
        System.out.println("Reccomended volunteering hours: " + member.recommendedVolunteerHours() +" ILs." );
        System.out.println("");

    }
}