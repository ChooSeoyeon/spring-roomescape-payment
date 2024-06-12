package roomescape.helper.domain;

import java.util.List;
import roomescape.domain.member.Member;
import roomescape.domain.reservation.Reservation;
import roomescape.domain.reservationwaiting.ReservationWaiting;
import roomescape.domain.reservationwaiting.ReservationWaitingRepository;

public class ReservationWaitingFixture {
    private final ReservationWaitingRepository reservationWaitingRepository;

    public ReservationWaitingFixture(ReservationWaitingRepository reservationWaitingRepository) {
        this.reservationWaitingRepository = reservationWaitingRepository;
    }

    public ReservationWaiting createWaiting(Reservation reservation, Member member) {
        ReservationWaiting reservationWaiting = new ReservationWaiting(reservation, member);
        return reservationWaitingRepository.save(reservationWaiting);
    }

    public List<ReservationWaiting> findAllWaiting() {
        return reservationWaitingRepository.findAll();
    }
}
