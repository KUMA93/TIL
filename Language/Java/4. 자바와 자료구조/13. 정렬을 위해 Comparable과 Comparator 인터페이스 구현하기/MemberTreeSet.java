package ch13;

import java.util.TreeSet;
import java.util.Iterator;

public class MemberTreeSet {

    private TreeSet<Member> TreeSet;

    public MemberTreeSet() {
        TreeSet = new TreeSet<Member>(new Member()); // comparator를 사용하려면 형을 명시해줘야 한다.
//        TreeSet = new TreeSet<Member>();
    }

    public void addMember(Member member) {
        TreeSet.add(member);
    }

    public boolean removeMember(int memberId) {

        Iterator<Member> ir = TreeSet.iterator();

        while(ir.hasNext()) {

            Member member = ir.next();
            int tmpId = member.getMemberId();
            if( tmpId == memberId) {
                TreeSet.remove(member);
                return true;
            }
        }

        System.out.println(memberId + "가 존재하지 않습니다.");
        return false;
    }

    public void showAllMember() {

        for( Member member : TreeSet) {
            System.out.println(member);
        }
        System.out.println();
    }

}
