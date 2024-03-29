package fr.pa1007.chess.chessman.utils;

import fr.pa1007.chess.chessman.ChessMan;
import fr.pa1007.chess.chessman.pieces.Paw;
import fr.pa1007.chess.game.Game;
import fr.pa1007.chess.utils.Place;
import fr.pa1007.chess.utils.Player;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is for simplifying the "Can this piece go here or not", this help to be more clear and do only 1 time all the finding of enemy and moving state
 */
public class Move {

    public static Place[] getBishopPossibleMove(Game game, Place startPlace, Player player) {
        Place[] p = startPlace.getDiagonal();
        return getPlaces(game, player, p);
    }

    public static Place[] getKingPossibleMove(Game game, Place startPlace, Player player) {
        Place[]     p      = startPlace.getPlaceAround();
        List<Place> places = new ArrayList<>();
        for (Place place : p) {
            if (!place.is("P6") && !place.is("P8")) {
                int r = game.pieceAtThisPlace(place);
                if (r == 0) {
                    places.add(place);
                }
                else {
                    if (player.getNumber() != r) {
                        places.add(place);
                    }
                }
            }
        }
        return places.toArray(new Place[0]);
    }

    public static Place[] getKnightPossibleMove(Game game, Place startPlace, Player player) {
        Place[] p = startPlace.getKnightMove();
        return getPlaces(game, player, p);
    }

    public static Place[] getPawPossibleMove(Game game, Paw paw) {
        if (!paw.isPromoted()) {
            List<Place> p = new ArrayList<>();
            switch (paw.movePattern().getPattern()) {
                case "|":
                    if (paw.getPlayer().getTeamName().equalsIgnoreCase("black")) {
                        p.add(paw.place().more(-1, 0));
                    }
                    else {
                        p.add(paw.place().more(1, 0));
                    }
                    break;
                case "||":
                    if (paw.getPlayer().getTeamName().equalsIgnoreCase("black")) {
                        p.add(paw.place().more(-1, 0));
                        p.add(paw.place().more(-2, 0));
                    }
                    else {
                        p.add(paw.place().more(1, 0));
                        p.add(paw.place().more(2, 0));
                    }
                    break;
                default:
                    throw new NullPointerException("No movement pattern");
            }

            List<Place> pl = new ArrayList<>();
            for (Place temp : p) {
                if (!temp.is("P8")) {
                    if (!temp.is("P6")) {
                        int r = game.pieceAtThisPlace(temp);
                        if (r == 0) {
                            pl.add(temp);
                        }
                    }
                }
            }

            for (Place place : paw.getDiagonal()) {
                ChessMan m = game.getPieceAt(place);
                if (m != null && m.getPlayer() != paw.getPlayer()) {
                    if (!pl.contains(place)) {
                        pl.add(place);
                    }
                }
            }
            return pl.toArray(new Place[0]);
        }
        else {
            switch (paw.getPromotedType()) {
                case QUEEN:
                    return Move.getQueenPossibleMove(game, paw.place(), paw.getPlayer());
                case KNIGHT:
                    return Move.getKnightPossibleMove(game, paw.place(), paw.getPlayer());
                case BISHOP:
                    return getBishopPossibleMove(game, paw.place(), paw.getPlayer());
                case ROOKS:
                    return getRookPossibleMove(game, paw.place(), paw.getPlayer());
                default:
                    throw new NullPointerException("No movement pattern");

            }
        }

    }

    public static Place[] getQueenPossibleMove(Game game, Place startPlace, Player player) {
        Place[] p = startPlace.getQueenMove();
        return getPlaces(game, player, p);
    }

    public static Place[] getRookPossibleMove(Game game, Place startPlace, Player player) {
        Place[] p = startPlace.getLines();
        return getPlaces(game, player, p);
    }

    private static List<Place> getPlacesList(Game game, Player player, Place[] allPossiblePlace) {
        List<Place> places = new ArrayList<>();
        boolean     behind = false;
        for (Place place : allPossiblePlace) {
            if (!place.is("P8")) {
                if (!place.is("P6")) {
                    if (!behind) {
                        int r = game.pieceAtThisPlace(place);
                        if (r == 0) {
                            places.add(place);
                        }
                        else {
                            if (player.getNumber() != r) {
                                places.add(place);
                                behind = true;
                            }
                            else {
                                behind = true;
                            }
                        }
                    }
                }
                else {
                    behind = false;
                }
            }
        }
        return places;

    }

    private static Place[] getPlaces(Game game, Player player, Place[] allPossiblePlace) {
        return getPlacesList(game, player, allPossiblePlace).toArray(new Place[0]);
    }
}
