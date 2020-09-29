package boot.intellij.seok;

import boot.intellij.seok.repository.JdbcMemberRepository;
import boot.intellij.seok.repository.MemberRepository;
import boot.intellij.seok.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    public SpringConfig(MemberRepository memberRepository){
        this.memberRepository=memberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }


}
