
/**
 * PolynomialDriver.java: 
 *
 * @version 1.0
 *
 */


class Main {

    public static void main(String[] args) {
        Term[] UNIQUE_TERMS1 
            = {new Term(5, 7),
               new Term(5, 9),
               new Term(-2, 2),
               new Term(-4, -3)};

        Term[] UNIQUE_TERMS2 
            = {new Term(15, 5),
               new Term(145, 9),
               new Term(-5, 7)};

        Polynomial poly1 = new Polynomial(UNIQUE_TERMS1);
        Polynomial poly2 = new Polynomial(UNIQUE_TERMS2);

        poly1.add(poly2);
        System.out.println(poly1);
             
    }
}