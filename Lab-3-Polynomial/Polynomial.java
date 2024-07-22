import java.util.LinkedList;

public class Polynomial {
  private LinkedList<Term> terms;
  private int numTerms;

  public Polynomial(Term ... t) {
    terms = new LinkedList<Term>();
    for(Term t1 : t) {
      addTerm(t1);
    }
  }

  public Polynomial() {
    terms = new LinkedList<Term>();
    numTerms = 0;
  }

  public Polynomial(Polynomial other) {
    this();
    for (int i = 0; i < other.numTerms; i++) {
      Term t = other.getTerm(i);
      addTerm((Term) t.clone());
    }
  }

  public void clear() {
    numTerms = 0;
    terms.clear();
  }

  public int getNumTerms() {
    return numTerms;
  }

  public Term getTerm(int i) {
    return terms.get(i);
  }

  public void add (Polynomial p) {
    for (Term t : p.terms) {
      addTerm(t);
    }
  }

  public void addTerm(Term t) {
    if (t.getCoef() == 0) return;
    numTerms++;
    if (terms.isEmpty()) terms.add(t);
    else {
      int i = 0;
      while (i < terms.size()) {
        if (t.compareTo(terms.get(i)) > 0) {
          terms.add(i, t);
          return;
        } else if (t.compareTo(terms.get(i)) == 0) {
          Term sum = new Term(t.getCoef() + terms.get(i).getCoef(), t.getExponent());
          terms.set(i, sum);
          numTerms--;
          if (terms.get(i).getCoef() == 0) {
            terms.remove(i);
            numTerms--;
          }
          return;
        }
        i++;
      }
      terms.addLast(t);
    }
  }

  public Term pop() {
    numTerms -= 1;
    return terms.pop();
    
  }

  public void removeFirst() {
    terms.removeFirst();
  }

  @Override
  public String toString() {
    String s = "";
    if (terms.isEmpty()) {
      return "0";
    }
    s = terms.getFirst().toString().substring(1);
    for (int i = 1; i < numTerms; i++) {
      if (terms.get(i).getCoef() != 0) s += terms.get(i).toString();
    }
    return s;
  }
  
}