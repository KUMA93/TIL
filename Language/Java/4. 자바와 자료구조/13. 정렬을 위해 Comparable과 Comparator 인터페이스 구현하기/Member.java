package ch13;

import java.util.Comparator;

public class Member implements Comparator<Member> { // Comparable<>, Comparator<>

    private int memberId;
    private String memberName;

    public Member() {}

    public Member(int memberId, String memberName) {
        this.memberId = memberId;
        this.memberName = memberName;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

//    @Override
//    public int compareTo(Member member) {
//
////        if( this.memberId > member.memberId)
////            return -1; // compareTo의 양수, 음수값에 따라 오름차순, 내림차순이 결정된다.
////        else if( this.memberId < member.memberId)
////            return 1;
////        else return 0;
//
//        return (this.memberId - member.memberId); // 위 코드를 간단화하면 한줄로 이렇다.
//    }

    @Override
    public int compare(Member member1, Member member2) {
        return (member2.memberId - member1.memberId)*(-1);
    }


    @Override
    public String toString() {
        return memberName + " 회원님의 아이디는 " + memberId + "입니다.";
    }
}
