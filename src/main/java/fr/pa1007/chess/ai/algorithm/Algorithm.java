package fr.pa1007.chess.ai.algorithm;

import fr.pa1007.chess.ai.guess.part.MoveGuessPart;
import fr.pa1007.chess.ai.guess.part.MoveGuessPartIncomplete;
import fr.pa1007.chess.chessman.ChessMan;
import fr.pa1007.chess.chessman.pieces.King;
import fr.pa1007.chess.game.Game;
import fr.pa1007.chess.utils.GameStatePattern;
import fr.pa1007.chess.utils.Place;
import fr.pa1007.chess.utils.Player;
import fr.pa1007.chess.utils.exception.UnFinishException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Algorithm {

    private       Game                 game;
    private final Map<Place, ChessMan> smallMap;
    private       GameStatePattern     pattern;
    private final ChessMan             man;

    private       List<MoveGuessPartIncomplete> allPossibleMove;
    private final int                           malus;

    public Algorithm(Game game, ChessMan man, int malus) {
        this.game = game;
        this.smallMap = new HashMap<>();
        this.pattern = new GameStatePattern(game, man);
        this.man = man;
        this.malus = man instanceof King ? 0 : malus;
        Map<Place, ChessMan> tr = pattern.getPlaceMap();
        Place[]              ps = man.generateMovePlace();
        for (Place p : ps) {
            smallMap.put(p, tr.get(p));
        }
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public GameStatePattern getPattern() {
        return pattern;
    }

    public void setPattern(GameStatePattern pattern) {
        this.pattern = pattern;
    }

    public MoveGuessPart getBestMove() {
        Map<Integer, MoveGuessPartIncomplete> temp = new HashMap<>();
        if (allPossibleMove == null) {
            getAllPossibleMove();
        }
        if (allPossibleMove.size() != 0) {
            for (MoveGuessPartIncomplete i : allPossibleMove) {
                if (i.getFrom() instanceof King) {
                    i.addPossibleLost(2);
                }
                temp.put(i.calPossibleReward(), i);
            }
            Simultation best = game.simulate(temp.values());
            int         max  = -1;
            for (int i : temp.keySet()) {
                if (i >= max) {
                    max = i;
                    temp.get(i).setChecked();
                }
            }
            MoveGuessPart           part = null;
            MoveGuessPartIncomplete f    = temp.get(max);
            try {
                if (best != null && best.getFrom() == f) {
                    if (f != null) {
                        part = f.complete();
                    }
                    else {
                        System.out.println(temp);
                        return null;
                    }
                }
            }
            catch (UnFinishException e) {
                // e.printStackTrace();
                part = f.forceCompete();
            }
            return part;
        }
        return null;
    }

    private void getAllPossibleMove() {
        List<MoveGuessPartIncomplete> lis = new ArrayList<>();
        Player                        p   = man.getPlayer();
        for (Place pl : man.generateMovePlace()) {
            MoveGuessPartIncomplete part = new MoveGuessPartIncomplete(p, man, pl);
            part.addPossibleLost(malus);
            ChessMan m;
            if ((m = smallMap.get(pl)) != null) {
                part.setEat();
                part.addPossibleWin(m.getValue());
            }
            lis.add(part);
        }
        allPossibleMove = lis;
    }

}
