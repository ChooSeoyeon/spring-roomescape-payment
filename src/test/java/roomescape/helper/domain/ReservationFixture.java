package roomescape.helper.domain;

import java.time.LocalDate;
import java.util.List;
import roomescape.domain.member.Member;
import roomescape.domain.reservation.Reservation;
import roomescape.domain.reservation.ReservationRepository;
import roomescape.domain.reservationtime.ReservationTime;
import roomescape.domain.theme.Theme;

public class ReservationFixture {
    private final ReservationRepository reservationRepository;

    public ReservationFixture(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Reservation createPastReservation(ReservationTime reservationTime, Theme theme, Member member) {
        Reservation reservation = new Reservation(LocalDate.of(2000, 4, 1), reservationTime, theme, member);
        return reservationRepository.save(reservation);
    }

    public Reservation createFutureReservation(ReservationTime reservationTime, Theme theme, Member member) {
        Reservation reservation = new Reservation(LocalDate.of(2000, 4, 8), reservationTime, theme, member);
        return reservationRepository.save(reservation);
    }

    public List<Reservation> findAllReservation() {
        return reservationRepository.findAll();
    }
}
