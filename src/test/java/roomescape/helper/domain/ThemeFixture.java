package roomescape.helper.domain;

import java.util.List;
import roomescape.domain.theme.Theme;
import roomescape.domain.theme.ThemeName;
import roomescape.domain.theme.ThemeRepository;

public class ThemeFixture {
    private final ThemeRepository themeRepository;

    public ThemeFixture(ThemeRepository themeRepository) {
        this.themeRepository = themeRepository;
    }

    public Theme createFirstTheme() {
        Theme theme = new Theme(new ThemeName("레벨1"), "내용이다.", "https://www.naver.com/");
        return themeRepository.save(theme);
    }

    public Theme createSecondTheme() {
        Theme theme = new Theme(new ThemeName("레벨2"), "내용이다.", "https://www.naver.com/");
        return themeRepository.save(theme);
    }

    public List<Theme> findAllTheme() {
        return themeRepository.findAll();
    }
}
