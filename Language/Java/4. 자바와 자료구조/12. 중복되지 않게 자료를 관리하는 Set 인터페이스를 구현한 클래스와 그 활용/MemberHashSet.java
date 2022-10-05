package ch12;

import java.util.HashSet;
import java.util.Iterator;

public class MemberHashSet {

    private HashSet<Member> HashSet;

    public MemberHashSet() {
        HashSet = new HashSet<>();
    }

    public MemberHashSet(int size) {
        HashSet = new HashSet<>(size);
    }

    public void addMember(Member member) {
        HashSet.add(member);
    }

    public boolean removeMember(int memberId) {

        Iterator<Member> ir = HashSet.iterator();

        while(ir.hasNext()) {

            Member member = ir.next();
            int tmpId = member.getMemberId();
            if( tmpId == memberId) {
                HashSet.remove(member);
                return true;
            }
        }

        System.out.println(memberId + "가 존재하지 않습니다.");
        return false;
    }

    public void showAllMember() {

        for( Member member : HashSet) {
            System.out.println(member);
        }
        System.out.println();
    }

}
