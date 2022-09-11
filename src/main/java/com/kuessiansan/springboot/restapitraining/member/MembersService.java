package com.kuessiansan.springboot.restapitraining.member;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;


@Service
public class MembersService {

    private static List<Member> members = new ArrayList<>();

    static {
        Member mb1 = new Member("ALAWO", "Adéshina", "Developer","ade@adiling.com", LocalDate.of(1998, Month.APRIL, 12));
        Member mb2 = new Member("SENA", "Eugène", "Developer", "eugene@adiling.com", LocalDate.of(1998, Month.OCTOBER, 26));
        Member mb3 = new Member("KARABOU", "Manzama", "Developer","manzama@adiling.com", LocalDate.of(1996, Month.APRIL, 17));
        Member mb4 = new Member("ADIGO", "Marc","BA", "marc@adiling.com", LocalDate.of(1993, Month.JANUARY, 24));
        Member mb5 = new Member("DJIYEHOUE", "Kuessi-Ansan","Intern", "manuel@adiling.com", LocalDate.of(2001, Month.SEPTEMBER, 30));
        Member mb6 = new Member("Eva", "Eva", "BA", "eva@adiling.com", LocalDate.of(1998, Month.APRIL, 17));
        Member mb7 = new Member("ADIGO", "Axel", "CEO", "eva@adiling.com", LocalDate.of(1987, Month.APRIL, 19));




        //Arrays.asList(el, el2, el3) returns a fixed list that cannot be modified, so it makes it difficult to add or remove elements from the list



        members.add(mb1);
        members.add(mb2);
        members.add(mb3);
        members.add(mb4);
        members.add(mb5);
        members.add(mb6);
        members.add(mb7);

//        MembersBundle membersBundle = new MembersBundle(gonnaAdd);

//        members.add(membersBundle);

    }


    public List<Member> getAllMembers() {
        return members;
    }

    public Member getMemberByName(String memberName) {
        Predicate<? super Member> predicate = member -> member.getName().equals(memberName);
        Optional<Member> optionalMember = members.stream().filter(predicate).findFirst();

        if (optionalMember.isEmpty())
            return null;
        return optionalMember.get();
    }

    public Member getMemberByProfession(String memberProfession) {

        Optional<Member>optionalMember= members.stream().filter(member -> member.getProfession().equals(memberProfession)).findAny();

        if (optionalMember.isEmpty()){
            return null;
        }
        return optionalMember.get();
    }

    public void addMember(Member member) {
        List<Member>members = getAllMembers();
        members.add(member);
    }

    public String deleteMember(String memberName) {
        List<Member>members = getAllMembers();

        Predicate<? super Member> predicate = member -> member.getName().equals(memberName);
        Optional<Member> optionalMember = members.stream().filter(predicate).findFirst();

        if (optionalMember.isEmpty())
            return null;
        members.remove(optionalMember.get());

        return memberName;
    }



    public List<Member> updateMember(String memberName, Member member) {
        List<Member>members = getAllMembers();

        Predicate<? super Member> predicate = member1 -> member1.getName().equals(memberName);
        Optional<Member> optionalMember = members.stream().filter(predicate).findFirst();

        if (optionalMember.isEmpty())
            return null;
        members.remove(optionalMember.get());
        members.add(member);
        return members;
    }

    public List<Member> updateProfessionMember(String memberName, String memberProfession) {
        List<Member>members = getAllMembers();

        Predicate<? super Member> predicate = member -> member.getName().equals(memberName);
        Optional<Member> optionalMember = members.stream().filter(predicate).findFirst();

        if (optionalMember.isEmpty()){
            return null;
        }
        members.remove(optionalMember.get().setProfession(memberProfession));
        return members;
    }
}