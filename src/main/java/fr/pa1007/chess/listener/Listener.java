package fr.pa1007.chess.listener;

public interface Listener {

    /**
     * The name of the event
     *
     * @return the name of the event
     */
    String name();

    /**
     * The "Fired" event by the game itself
     *
     * @param objects all the object the Event need
     */
    void fire(Object... objects);
}
