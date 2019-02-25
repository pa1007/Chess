package fr.pa1007.chess.utils;

import fr.pa1007.chess.ai.guess.part.CompleteGuessPart;
import fr.pa1007.chess.ai.guess.part.GuessPart;
import fr.pa1007.chess.ai.guess.part.TeamGuessPart;

public class PatternReader {

    public static GuessPart[] explodePattern(CompleteGuessPart comp, Player p) {
        GuessPart[] all = new GuessPart[4];
        all[0] = comp;
        TeamGuessPart teamPart = new TeamGuessPart(p);
       /* for (int i = 0; i < 8; i++) {
            Part part = comp.getGame().get(i);
            for (String string : part.getPieceOnIt()) {
                if (string.contains(p.getTeamName())) {
                }
            }

        }*/
        return all;
    }
}