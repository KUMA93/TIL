package ch13;

import java.util.Comparator;
import java.util.TreeSet;

class MyCompare implements Comparator<String> {

    @Override
    public int compare(String s1, String s2) {
        return s1.compareTo(s2) * (-1);
    }
}

public class MemberTreeSetTest {

    public static void main(String[] args) {

//        TreeSet<String> set = new TreeSet<String>();
//
//        set.add("홍길동");
//        set.add("강감찬");
//        set.add("이순신");
//
//        System.out.println(set);

//        MemberTreeSet memberTreeSet
//
//        = new MemberTreeSet();
//
//        Member memberLee = new Member(1001, "이순신");
//        Member memberKim = new Member(1002, "김유신");
//        Member memberKang = new Member(1003, "강감찬");
//        Member memberHong = new Member(1004, "홍길동");
//
//        memberTreeSet.addMember(memberHong);
//        memberTreeSet.addMember(memberLee);
//        memberTreeSet.addMember(memberKim);
//        memberTreeSet.addMember(memberKang);
//
//
//        memberTreeSet.showAllMember();


        TreeSet<String> set = new TreeSet<String>(new MyCompare());
        set.add("Park");
        set.add("Kim");
        set.add("Lee");

        System.out.println(set);
    }
}
