package fr.pa1007.chess.ai.guess.part;

import com.google.common.base.Objects;
import fr.pa1007.chess.ai.guess.Reward;
import fr.pa1007.chess.chessman.ChessMan;
import fr.pa1007.chess.utils.Place;
import fr.pa1007.chess.utils.Player;

public class MoveGuessPart extends GuessPart {

    protected String   meta;
    protected ChessMan from;
    protected Place    place;
    private   Reward   reward;
    private   boolean  compete;

    public MoveGuessPart(Player playerFrom, ChessMan from, Place place) {
        super(playerFrom);
        this.from = from;
        this.place = place;
        compete = false;
    }

    public MoveGuessPart(Player playerFrom, String meta, ChessMan from, Place place) {
        super(playerFrom);
        this.meta = meta;
        this.from = from;
        this.place = place;
        compete = false;
    }

    public MoveGuessPart(Player playerFrom, Reward reward, String meta, ChessMan from, Place place) {
        super(playerFrom);
        this.reward = reward;
        this.meta = meta;
        this.from = from;
        this.place = place;
        compete = true;
    }

    public String getMeta() {
        return meta;
    }

    public ChessMan getFrom() {
        return from;
    }

    public Place getPlace() {
        return place;
    }

    public Reward getReward() {
        return reward;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("meta", meta)
                .add("from", from)
                .add("place", place)
                .add("reward", reward)
                .add("compete", compete)
                .add("game", game)
                .add("playerFrom", playerFrom)
                .toString();
    }
}
