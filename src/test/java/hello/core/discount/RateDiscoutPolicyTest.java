package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscoutPolicyTest {
    RateDiscoutPolicy rateDiscoutPolicy = new RateDiscoutPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용 되어야 한다")
    void vip_0(){
        //given
        Member member = new Member(1L, "camel", Grade.VIP);
        //when
        int discount = rateDiscoutPolicy.discount(member, 10000);
        //then
        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용 되지 않아야 한다")
    void vip_x(){
        //given
        Member member = new Member(2L, "camelBasic", Grade.BASIC);
        //when
        int discount = rateDiscoutPolicy.discount(member, 10000);
        //then
        assertThat(discount).isEqualTo(0);
    }
}


