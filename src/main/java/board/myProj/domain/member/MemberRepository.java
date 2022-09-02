package board.myProj.domain.member;

import board.myProj.domain.member.member.Member;

import java.util.List;

public interface MemberRepository {
    List<Member> findAll();

    Member save(Member member);

    Member findById(int id);


    Member findByLoginId(String loginId);

    void update(String password, String address, String phoneNumber,String loginId);

    void delete(Long id);


}
