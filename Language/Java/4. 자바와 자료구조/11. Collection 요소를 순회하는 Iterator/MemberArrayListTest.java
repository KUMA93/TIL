package ch11;

import ch10.Member;
import ch10.MemberArrayList;

public class MemberArrayListTest {

    public static void main(String[] args) {

        ch10.MemberArrayList memberArrayList = new MemberArrayList();

        ch10.Member memberLee = new ch10.Member(1001, "이순신");
        ch10.Member memberKim = new ch10.Member(1002, "김유신");
        ch10.Member memberKang = new ch10.Member(1003, "강감찬");
        ch10.Member memberHong = new Member(1004, "홍길동");

        memberArrayList.addMember(memberLee);
        memberArrayList.addMember(memberKim);
        memberArrayList.addMember(memberKang);
        memberArrayList.addMember(memberHong);

        memberArrayList.showAllMember();
        memberArrayList.removeMember(memberKim.getMemberId());
        memberArrayList.showAllMember();

    }
}
