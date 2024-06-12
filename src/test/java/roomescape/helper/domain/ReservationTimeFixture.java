package roomescape.helper.domain;

import java.time.LocalTime;
import java.util.List;
import roomescape.domain.reservationtime.ReservationTime;
import roomescape.domain.reservationtime.ReservationTimeRepository;

public class ReservationTimeFixture {
    private final ReservationTimeRepository reservationTimeRepository;

    public ReservationTimeFixture(ReservationTimeRepository reservationTimeRepository) {
        this.reservationTimeRepository = reservationTimeRepository;
    }

    public ReservationTime createFutureReservationTime() {
        ReservationTime reservationTime = new ReservationTime(LocalTime.of(2, 30));
        return reservationTimeRepository.save(reservationTime);
    }

    public ReservationTime createPastReservationTime() {
        ReservationTime reservationTime = new ReservationTime(LocalTime.of(1, 30));
        return reservationTimeRepository.save(reservationTime);
    }

    public List<ReservationTime> findAllReservationTime() {
        return reservationTimeRepository.findAll();
    }
}
