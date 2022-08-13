package hello.core.member;

public class MemberServiceImpl implements MemberService {

    /**
     * MemberServiceImpl.class
     * MemberRepository 인터페이스를 할 (추상화 의존)
     * MemoryMemberRepository 는 구현체를 할당 (구체화 의존)
     *
     */
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
