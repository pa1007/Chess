package fr.pa1007.chess.ai.builder;

import fr.pa1007.chess.ai.guess.Guess;
import fr.pa1007.chess.ai.guess.Reward;
import fr.pa1007.chess.chessman.ChessMan;
import fr.pa1007.chess.utils.MovePattern;
import fr.pa1007.chess.utils.Place;

public class GuessBuilder {

    private int[][]     rawResult;
    private ChessMan    piece;
    private MovePattern movePattern;
    private Place       end;
    private Place       start;
    private int         guessNumber;
    private Reward      reward;

    public GuessBuilder setRawResult(int[][] rawResult) {
        this.rawResult = rawResult;
        return this;
    }

    public GuessBuilder setPiece(ChessMan piece) {
        this.piece = piece;
        return this;
    }

    public GuessBuilder setMovePattern(MovePattern movePattern) {
        this.movePattern = movePattern;
        return this;
    }

    public GuessBuilder setEnd(Place end) {
        this.end = end;
        return this;
    }

    public GuessBuilder setStart(Place start) {
        this.start = start;
        return this;
    }

    public GuessBuilder setGuessNumber(int guessNumber) {
        this.guessNumber = guessNumber;
        return this;
    }

    public GuessBuilder setReward(Reward reward) {
        this.reward = reward;
        return this;
    }

    public Guess createGuess() {
        return new Guess(rawResult, piece, movePattern, end, start, guessNumber, reward);
    }
}