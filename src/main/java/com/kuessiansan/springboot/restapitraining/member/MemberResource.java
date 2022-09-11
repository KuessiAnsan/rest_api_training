package com.kuessiansan.springboot.restapitraining.member;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

@RestController
public class MemberResource {

    MembersService memberService;

    public MemberResource(MembersService memberService) {
        super();
        this.memberService = memberService;
    }

    @RequestMapping("/members")
    public List<Member> getAllMembers(){
        return memberService.getAllMembers();
    }


    @RequestMapping("/members/{memberName}")
    public Member getMemberByName(@PathVariable String memberName){

        if (memberService.getMemberByName(memberName) == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return memberService.getMemberByName(memberName);
    }

//    @RequestMapping("/members/{memberProfession}")
//    public Member getMemberByProfession(@PathVariable String memberProfession){
//        return memberService.getMemberByProfession(memberProfession);
//    }


    @RequestMapping(value = "/members", method = RequestMethod.POST)
    public void addMember(@RequestBody Member member){
        memberService.addMember(member);
    }



    @RequestMapping(value = "/members/{memberName}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteMember(@PathVariable String memberName){
        memberService.deleteMember(memberName);
        return ResponseEntity.noContent().build();
    }




    @RequestMapping(value = "/members/{memberName}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateMember(@PathVariable String memberName, @RequestBody Member member){
        memberService.updateMember(memberName, member);

        return ResponseEntity.noContent().build();
    }


    @RequestMapping(value = "/members/{memberName}", method = RequestMethod.PATCH)
    public ResponseEntity<Object> updateProfessionMember(@PathVariable String memberName, @RequestBody String memberProfession){
        memberService.updateProfessionMember(memberName, memberProfession);

        return ResponseEntity.noContent().build();
    }
}
