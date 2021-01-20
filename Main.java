import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Intervalle a = new Intervalle(4, 5);
        Intervalle b = new Intervalle(6, 7);
        Intervalle c = new Intervalle(1, 7);
        List<Intervalle> xs = Arrays.asList(a, b, c);
        Contrainte contrainte = new Contrainte(xs);

        System.out.print(contrainte);


    }
}
