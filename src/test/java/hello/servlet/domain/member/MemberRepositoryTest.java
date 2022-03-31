package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    @DisplayName("회원 저장")
    public void save(){
        //given
        Member member = new Member("goodman", 20);

        //when
        Member saveMember = memberRepository.save(member);

        //then
        Member findMember = memberRepository.findById(saveMember.getId());
        assertThat(findMember).isEqualTo(saveMember);

        System.out.println("뭔데");
    }


    @Test
    @DisplayName("findAll")
    public void findAll() {
        //given
        Member member1 = new Member("goodman", 21);
        Member member2 = new Member("goodwo", 31);

        memberRepository.save(member1);
        memberRepository.save(member2);

        //when

        List<Member> members = memberRepository.findAll();

        //then
        assertThat(members.size()).isEqualTo(2);
    }

}