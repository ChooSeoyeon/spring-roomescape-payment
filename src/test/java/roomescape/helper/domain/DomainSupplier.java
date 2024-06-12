package roomescape.helper.domain;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import roomescape.domain.member.MemberRepository;
import roomescape.domain.payment.ReservationPaymentRepository;
import roomescape.domain.reservation.ReservationRepository;
import roomescape.domain.reservationtime.ReservationTimeRepository;
import roomescape.domain.reservationwaiting.ReservationWaitingRepository;
import roomescape.domain.theme.ThemeRepository;

@SpringBootTest
public abstract class DomainSupplier {
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private ReservationTimeRepository reservationTimeRepository;

    @Autowired
    private ThemeRepository themeRepository;

    @Autowired
    private ReservationWaitingRepository reservationWaitingRepository;

    @Autowired
    private ReservationPaymentRepository reservationPaymentRepository;

    protected MemberFixture memberFixture;

    protected ReservationFixture reservationFixture;

    protected ReservationTimeFixture reservationTimeFixture;

    protected ThemeFixture themeFixture;

    protected ReservationWaitingFixture reservationWaitingFixture;

    protected ReservationPaymentFixture reservationPaymentFixture;

    @BeforeEach
    protected void setUpDomainSupplier() {
        memberFixture = new MemberFixture(memberRepository);
        reservationFixture = new ReservationFixture(reservationRepository);
        reservationTimeFixture = new ReservationTimeFixture(reservationTimeRepository);
        themeFixture = new ThemeFixture(themeRepository);
        reservationWaitingFixture = new ReservationWaitingFixture(reservationWaitingRepository);
        reservationPaymentFixture = new ReservationPaymentFixture(reservationPaymentRepository);
    }
}
