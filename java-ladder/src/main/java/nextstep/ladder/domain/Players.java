package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Players {

    private final List<Player> players = new ArrayList<>();

    private Players(List<String> playerNames) {
        for (int column = 0; column < playerNames.size(); column++) {
            players.add(Player.of(column, playerNames.get(column)));
        }
    }

    public static Players of(List<String> playerNames) {
        return new Players(playerNames);
    }

    public int participatedUserCount() {
        return this.players.size();
    }

    public Player findByPlayerName(String playerName) {
        return players.stream()
                .filter(player -> player.equalPlayerName(playerName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("사다리 게임에 참가하지 않은 사용자 입니다. * 입력된 이름 : %s", playerName)));
    }

    public List<Player> allPlayer() {
        return Collections.unmodifiableList(players);
    }
}
