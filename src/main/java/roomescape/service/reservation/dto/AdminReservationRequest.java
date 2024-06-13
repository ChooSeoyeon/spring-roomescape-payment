package roomescape.service.reservation.dto;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public class AdminReservationRequest {
    @NotNull(message = "날짜를 입력해주세요.")
    private final LocalDate date;

    @NotNull(message = "시간 id를 입력해주세요.")
    private final Long timeId;

    @NotNull(message = "테마 id를 입력해주세요.")
    private final Long themeId;

    @NotNull(message = "회원 id를 입력해주세요.")
    private final Long memberId;

    public AdminReservationRequest(LocalDate date, Long timeId, Long themeId, Long memberId) {
        this.date = date;
        this.timeId = timeId;
        this.themeId = themeId;
        this.memberId = memberId;
    }

    public ReservationSaveInput toReservationSaveInput() {
        return new ReservationSaveInput(date, timeId, themeId);
    }

    public LocalDate getDate() {
        return date;
    }

    public Long getTimeId() {
        return timeId;
    }

    public Long getThemeId() {
        return themeId;
    }

    public Long getMemberId() {
        return memberId;
    }
}
