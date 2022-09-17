package nextstep.ladder.domain;

public class Player {

    private final int startColumn;
    private final String name;

    private Player(int startColumn, String name) {
        this.startColumn = startColumn;
        this.name = name;
    }

    public static Player of(int startColumn, String name) {
        return new Player(startColumn, name);
    }

    public boolean equalPlayerName(String playerName) {
        return this.name.equals(playerName);
    }

    public int startColumn() {
        return startColumn;
    }

    public String playerName() {
        return name;
    }
}
