package Datastrukturer.Eksempelklasser;

@FunctionalInterface
public interface Komparator<T>      // et funksjonsgrensesnitt
{
    // Den abstrakte metoden:

    int compare(T o1, T o2);

    // Statiske metoder:

    public static <T extends Comparable<? super T>> Komparator<T> naturligOrden()
    {
        return (x,y) -> x.compareTo(y);
    }

    public static <T extends Comparable<? super T>> Komparator<T> omvendtOrden()
    {
        return (x, y) -> y.compareTo(x);
    }

    public static <T, R extends Comparable<? super R>>
    Komparator<T> orden(Funksjon<? super T, ? extends R> velger)
    {
        return (x, y) -> velger.anvend(x).compareTo(velger.anvend(y));
    }

    public static <T>
    Komparator<T> intorden(IntFunksjon<? super T> velger)
    {
        return (x, y) ->
        {
            int a = velger.anvend(x);
            int b = velger.anvend(y);
            if (a < b) return -1;
            else if (a == b) return 0;
            else return 1;
        };
    }

    public static <T, R> Komparator<T> orden
            (Funksjon<? super T, ? extends R> velger, Komparator<? super R> c)
    {
        return (x, y) -> c.compare(velger.anvend(x), velger.anvend(y));
    }

    public static <T extends Comparable<? super T>> Komparator<T>
    orden(IntFunksjon<? super T> velger)
    {
        return (x,y) ->
        {
            int a = velger.anvend(x);
            int b = velger.anvend(y);
            if (a < b) return -1;
            else if (a == b) return 0;
            else return 1;
        };
    }

    // Default-metoder:

    default Komparator<T> deretter(Komparator<? super T> c)
    {
        return (x,y) ->
        {
            int cmp = compare(x,y);
            return cmp != 0 ? cmp : c.compare(x, y);
        };
    }

    default <R extends Comparable<? super R>> Komparator<T> deretter(Funksjon<? super T,? extends R> velger)
    {
        return (x,y) ->
        {
            int cmp = compare(x,y);
            if (cmp != 0) return cmp;
            return velger.anvend(x).compareTo(velger.anvend(y));
        };
    }

    default <R> Komparator<T>
    deretter(Funksjon<? super T, ? extends R> velger, Komparator<? super R> c)
    {
        return (x, y) ->
        {
            int k = compare(x, y);
            return k != 0 ? k : c.compare(velger.anvend(x), velger.anvend(y));
        };
    }

    default Komparator<T> omvendt()

    return (x, y) -> compare(y, x);  // bytter x og y
}

} // class Komparator