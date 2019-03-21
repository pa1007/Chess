package fr.pa1007.chess.ai.guess.part;

import com.google.common.base.Objects;
import fr.pa1007.chess.ai.guess.Reward;
import fr.pa1007.chess.chessman.ChessMan;
import fr.pa1007.chess.utils.Place;
import fr.pa1007.chess.utils.Player;
import fr.pa1007.chess.utils.exception.UnFinishException;

public class MoveGuessPartIncomplete extends MoveGuessPart {

    private int     possibleReward;
    private int     possibleLost;
    private int     possibleWin;
    private boolean checked;
    private boolean eat;
    private boolean makeCheck;


    public MoveGuessPartIncomplete(Player playerFrom, ChessMan from, Place place) {
        super(playerFrom, from, place);
    }

    public MoveGuessPartIncomplete(Player playerFrom, String meta, ChessMan from, Place place) {
        super(playerFrom, meta, from, place);
    }


    public MoveGuessPart complete() throws UnFinishException {
        calPossibleReward();
        if (checked && -possibleLost + possibleWin == possibleReward) {
            return new MoveGuessPart(playerFrom, new Reward(possibleLost, possibleWin), this.toString(), from, place);
        }
        throw new UnFinishException(this);
    }

    public void setChecked() {
        this.checked = !this.checked;
    }

    public void setEat() {
        this.eat = !this.eat;
    }

    public void setMakeCheck() {
        this.makeCheck = !this.makeCheck;
    }

    public void setPossibleWin(int possibleWin) {
        this.possibleWin = possibleWin;
    }

    public void setPossibleLost(int possibleLost) {
        this.possibleLost = possibleLost;
    }

    public void addPossibleWin(int possibleWin) {
        this.possibleWin += possibleWin;
    }

    public void addPossibleLost(int possibleLost) {
        this.possibleLost += possibleLost;
    }


    public int calPossibleReward() {
        this.possibleReward = -possibleLost + possibleWin;
        return possibleReward;
    }

    public MoveGuessPart forceCompete() {
        return new MoveGuessPart(playerFrom, new Reward(possibleLost, possibleWin), this.toString(), from, place);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("possibleReward", possibleReward)
                .add("possibleLost", possibleLost)
                .add("possibleWin", possibleWin)
                .add("checked", checked)
                .add("eat", eat)
                .add("makeCheck", makeCheck)
                .add("meta", meta)
                .add("from", from)
                .add("place", place)
                .toString();
    }
}
