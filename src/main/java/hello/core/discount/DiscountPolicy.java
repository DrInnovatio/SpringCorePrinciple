package hello.core.discount;

import hello.core.member.Member;

public interface DiscountPolicy {

    /**
     * @return discount rate.
     * **/

    int discount(Member member, int price);


}
