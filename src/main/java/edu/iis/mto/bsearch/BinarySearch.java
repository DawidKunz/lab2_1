/**
 *
 */
package edu.iis.mto.bsearch;

/**
 * Klasa implementująca wyszukiwanie binarne
 *
 */
public class BinarySearch {

    private BinarySearch() {
    }

    /**
     * Metoda realizujaca wyszukiwanie binarne
     *
     * @param key
     *            - szukany obiekt
     * @param seq
     *            - rosnaco uporzadkowana niepusta sekwencja
     * @return obiekt rezultatu o polach: - found (true jezeli znaleziony) - position (jezeli znaleziony - pozycja w
     *         sekwencji, jezeli nie znaleziony -1)
     */
    public static SearchResult search(int key, int[] seq) throws IllegalArgumentException {
        validateInput(seq);
        int start = 0;
        int end = seq.length - 1;
        int center;
        SearchResult result = new SearchResult();

        while (start <= end) {
            center = (start + end) / 2;
            if (seq[center] == key) {
                result.setPosition(center);
                break;
            } else {
                if (seq[center] < key) {
                    start = center + 1;
                } else {
                    end = center - 1;
                }
            }
        }
        return result;
    }

    private static void validateInput(int[] seq) {
        if (seq.length == 0) throw new IllegalArgumentException("At last 1 element expected!");
        if (!isSeqSortedAscendingWithoutDuplicates(seq))
            throw new IllegalArgumentException("Seq should bo sorted asc without duplicates!");
    }

    private static boolean isSeqSortedAscendingWithoutDuplicates(int[] seq) {
        int prevI = seq[0] - 1;
        for (int i : seq) {
            if (i <= prevI) return false;
            prevI = i;
        }
        return true;
    }
}
