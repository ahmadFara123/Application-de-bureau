/*
 * javadoc g&eacute;n&eacute;r&eacute; avec :
 * -locale fr -header '<script type="text/javascript" src="http://cdn.mathjax.org/mathjax/latest/MathJax.js?config=TeX-AMS-MML_HTMLorMML"></script>'
 */

import java.util.*;

/**
 * La classe {@code Contrainte} est utilis&eacute; pour construire des ensembles
 * d'{@code Intervalle} exclusif.
 * <p>
 * Cette classe contient une liste de \(n\) {@code Intervalle}.
 * </p><p>
 * \( \{[d_0..f_0[, [d_1..f_1[, \ldots, [d_{n-1}..f_{n-1}[\} \)
 * </p><p>
 * Les &eacute;l&eacute;ments de la liste sont exclusifs, c'est &agrave; dire que l'intersection
 * entre deux intervalles de la m&ecirc;me liste donne un intervalle vide :
 * </p><p>
 * invariant : \( \forall i \in [0..n-1], \forall j \in [0..n-1], i \neq j \rightarrow [d_i..f_i[ \cap [d_j..f_j[ = \emptyset \)
 * </p><p>
 * Les &eacute;l&eacute;ments de cette liste sont en ordre croissant :
 * </p><p>
 * invariant : \( \forall i \in [0..n-2], f_i < d_{i+1} \)
 * </p>
 *
 * @author -- Remplacer par vos noms --
 * @author -- Remplacer par vos noms --
 * @author Bruno Malenfant
 * @see Intervalle
 */
@SuppressWarnings("serial")
public class Contrainte extends ArrayList<Intervalle> {
    /**
     * Constructeur
     * <p>
     * Construis une liste vide.
     * </p>
     */
    public Contrainte() {
        super();
    }


    /**
     * Constructeur
     * <p>
     * Construit une liste d'{@code Intervalle} contenant tous les &eacute;l&eacute;ments de
     * la {@code Collection}.  Les &eacute;l&eacute;ments de la {@code Collection} ne respecte
     * pas n&eacute;cessairement les invariants d'une {@code Contrainte}.  Il faut
     * donc, s'assurer que le r&eacute;sultat de la construction respecte les
     * invariants d'une {@code Contrainte}.
     * </p>
     *
     * @param intervalles La {@code Collection} contenant les &eacute;l&eacute;ments utilis&eacute;s
     *                    pour construire la {@code Contrainte}.
     * @throws NullPointerException si l'argument {@code collection} est
     *                              {@code null}.
     */
    public Contrainte(Collection<Intervalle> intervalles) {
        for (Intervalle intervalle : intervalles) {
            add(intervalle);
        }
    }


    /**
     * Ajoute un {@code Intervalle} dans la {@code Contrainte}.
     * <p>
     * Ajoute un {@code Intervalle}.  Cet ajout ne doit pas briser les
     * invariants de la {@code Constrainte}.
     * </p>
     * <ul>
     * <li> Toutes les valeurs qui appartenaient &agrave; la {@code Contrainte} avant
     * l'ajout doivent encore appartenir &agrave; la {@code Contrainte} apr&egrave;s l'ajout.
     * </li>
     * <li>Toutes les valeurs qui appartiennent &agrave; l'{@code Intervalle} ajout&eacute;
     * doivent appartenir &agrave; la {@code Contrainte} r&eacute;sultante.
     * </li>
     * </ul>
     *
     * @param intervalle l'intervalle ajout&eacute; dans la liste.
     *                   <p>
     *                   pr&eacute;alable : {@code null != intervalle}
     *                   </p>
     * @return {@code true}.
     */
    public boolean add(Intervalle intervalle) {
        int a = position(intervalle.debut, true);
        int b = position(intervalle.fin, true);
        Contrainte contrainte;
        if (a == -1 && b == -1) {
            addfinal(intervalle);
        } else {
            if (a != b) {
                if (b == -1) {
                    contrainte = get(a).union(intervalle);
                    this.remove(get(a));
                } else if (a == -1) {
                    contrainte = get(b).union(intervalle);
                    contrainte = this.union(contrainte);
                    this.clear();
                } else {
                    Intervalle intervalle1 = get(a);
                    Intervalle intervalle2 = get(b);
                    contrainte = intervalle1.union(intervalle);
                    this.remove(intervalle1);

                    contrainte = contrainte.get(0).union(intervalle2);
                    this.remove(intervalle2);
                }
                for (Intervalle range : contrainte) {
                    addfinal(range);
                }
            }
        }

        return true;
    }


    /**
     * Enl&egrave;ve un {@code Intervalle} de la {@code Contrainte}.
     * <p>
     * Enl&egrave;ve un {@code Intervalle}.  Cette suppression ne doit pas briser les
     * invariants de la {@code Constrainte}.
     * </p>
     * <ul>
     * <li> Toutes les valeurs qui appartenaient &agrave; la {@code Contrainte} avant
     * et qui n'appartiennent pas &agrave; l'{@code Intervalle} supprim&eacute; doivent encore
     * appartenir &agrave; la {@code Contrainte} apr&egrave;s la suppression.
     * </li>
     * </ul>
     *
     * @param intervalle l'intervalle supprim&eacute; de la liste.
     *                   <p>
     *                   pr&eacute;alable : {@code null != intervalle}
     *                   </p>
     */
    public void remove(Intervalle intervalle) {
        Iterator itr = this.iterator();
        List<Intervalle> temp = new ArrayList<>();
        while (itr.hasNext()) {
            Intervalle x = (Intervalle) itr.next();
            if (x.equals(intervalle)) {
                itr.remove();
            } else if (x.intersection(intervalle).size() == 1) {
                Contrainte d = x.soustraction(intervalle);
                itr.remove();
                temp.addAll(d);
            }
        }
        for (Intervalle i : temp) {
            addfinal(i);
        }
    }


    /**
     * V&eacute;rifie si une valeur est incluse dans une contrainte.
     * <p>
     * Soit une contrainte \(c = \{[d_0..f_0[, [d_1..f_1[, \ldots, [d_{n-1}..f_{n-1}[\}\),
     * alors l'appartenance (\(v \in c\))
     * est d&eacute;finie comme suit :
     * </p><p>
     * \(v \in c \leftrightarrow \exists i \in [0..n-1], v \in [d_i..f_i[\).
     * </p>
     *
     * @param v la valeur &agrave; tester.
     * @return {@code true} si la valeur est incluse dans la contrainte,
     * {@code false} sinon.
     */
    public boolean appartient(int v) {
        boolean a = false;
        int i = 0;
        while (i < this.size()) {
            if (this.get(i).appartient(v)) {
                a = true;
            }
            i++;
        }
        return a;
    }


    /**
     * Calcule le nombre d'&eacute;l&eacute;ments diff&eacute;rents appartenant &agrave; la
     * {@code Contrainte}.
     * <p>
     * Remarque : utilisez la m&eacute;thode {@code size} pour obtenir le nombre
     * d'{@code Intervalle} que contient la {@code Contrainte}.
     * </p><p>
     * Soit \(c\) la {@code Contrainte} r&eacute;f&eacute;r&eacute; par {@code this}.
     * </p>
     *
     * @return \(|[v|v \in c]|\)
     */
    public int taille() {
        int grandeur = 0;
        for (Intervalle a : this) {
            grandeur = grandeur + (a.fin - a.debut);
        }
        return grandeur;
    }


    /**
     * Construis l'union de deux contraintes.
     * <p>
     * Soit \(c_1\) la {@code Contrainte} r&eacute;f&eacute;r&eacute; par {@code this} et
     * \(c_2\) la {@code Contrainte} en argument.
     * Une {@code Contrainte} \(c\) est construite de telle sorte que le pr&eacute;dicat
     * suivant, soit vrai :
     * </p><p>
     * \(\forall n, n \in c \leftrightarrow ( n \in c_1 \vee n \in c_2 )\)
     * </p>
     *
     * @param contrainte La {@code Contrainte} avec laquelle l'union est faite.
     *                   <p>
     *                   pr&eacute;alable : {@code null != contrainte}
     *                   </p>
     * @return une {@code Constrainte} contenant le r&eacute;sultat.
     */
    public Contrainte union(Contrainte contrainte) {
        Iterator itr = this.iterator();
        List<Intervalle> temp = new ArrayList<>();
        while (itr.hasNext()) {
            Intervalle x = (Intervalle) itr.next();
            for (Intervalle i : contrainte) {
                Contrainte inter = x.union(i);
                temp.addAll(inter);
            }
        }

        if(contrainte.isEmpty()){
            temp.addAll(this);
        }

        if(this.isEmpty()){
            temp.addAll(contrainte);
        }

        return new Contrainte(temp);
    }


    /**
     * Construis l'intersection de deux contraintes.
     * <p>
     * Soit \(c_1\) la {@code Contrainte} r&eacute;f&eacute;r&eacute; par {@code this} et
     * \(c_2\) la {@code Contrainte} en argument.
     * Une {@code Contrainte} \(c\) est construite de telle sorte que le pr&eacute;dicat
     * suivant, soit vrai :
     * </p><p>
     * \(\forall n, n \in c \leftrightarrow ( n \in c_1 \wedge n \in c_2 )\)
     * </p>
     *
     * @param contrainte La {@code Contrainte} avec laquelle l'intersection est faite.
     *                   <p>
     *                   pr&eacute;alable : {@code null != contrainte}
     *                   </p>
     * @return une {@code Constrainte} contenant le r&eacute;sultat.
     */
    public Contrainte intersection(Contrainte contrainte) {
        Iterator itr = this.iterator();
        List<Intervalle> temp = new ArrayList<>();
        while (itr.hasNext()) {
            Intervalle x = (Intervalle) itr.next();
            for (Intervalle i : contrainte) {
                Contrainte inter = x.intersection(i);
                if (inter.size() > 0) {
                    temp.add(inter.get(0));
                }
            }
        }
        return new Contrainte(temp);
    }


    /**
     * Soustrais la contrainte en argument.
     * <p>
     * Soit \(c_1\) la {@code Contrainte} r&eacute;f&eacute;r&eacute; par {@code this} et
     * \(c_2\) la {@code Contrainte} en argument.
     * Une {@code Contrainte} \(c\) est construite de telle sorte que le pr&eacute;dicat
     * suivant, soit vrai :
     * </p><p>
     * \(\forall n, n \in c \leftrightarrow ( n \in c_1 \wedge n \notin c_2 )\)
     * </p>
     *
     * @param contrainte La {@code Contrainte} soustraite de {@code this}.
     *                   <p>
     *                   pr&eacute;alable : {@code null != contrainte}
     *                   </p>
     * @return une {@code Constrainte} contenant le r&eacute;sultat.
     */
    public Contrainte soustraction(Contrainte contrainte) {
        Iterator itr = this.iterator();
        List<Intervalle> temp = new ArrayList<>();

        while (itr.hasNext()) {
            Intervalle x = (Intervalle) itr.next();
            boolean dirty = false;
            for (Intervalle i : contrainte) {
                if (x.fin >= i.debut) {
                    dirty = true;
                    Contrainte inter = x.soustraction(i);
                    temp.addAll(inter);
                }
            }
            if (!dirty) {
                temp.add(x);
            }
        }

        if (contrainte.isEmpty()) {
            temp.addAll(this);
        }
        return new Contrainte(temp);
    }

    public int position(int b, boolean verifierInclusion) {
        int a = -1;
        int i = 0;
        while (i < size()) {
            if (get(i).appartient(b) || (verifierInclusion && get(i).appartient(b - 1))) {
                a = i;
                i = size();
            }
            i++;

        }
        return a;
    }

    private boolean addfinal(Intervalle intervalle) {
        int i = 0;
        int position = 0;
        while (i < size()) {
            position++;
            if (intervalle.fin < get(i).debut) {
                position = i;
                i = size();
            }
            i++;
        }
        add(position, intervalle);
        return true;
    }

}
