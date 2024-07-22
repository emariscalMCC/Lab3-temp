public class Term implements Comparable {
  private int coef;
  private int exponent;

  public Term(int coef, int exponent) {
    this.coef = coef;
    this.exponent = exponent;
  }

  public Term() {
    this(1,1);
  }

  public Term(Term other) {
    this(other.getCoef(), other.getExponent());
  }

  public Term(String termString) {
    if (termString == null) {
      coef = 0;
      exponent = 0;
      return;
    }
    if (termString.equals("")) {
      coef = 0;
      exponent = 0;
      return;
    }
    if (termString.indexOf("x") == -1) { //something's wrong, i give up
      exponent = 0;
      coef = Integer.valueOf(termString);
    } else {
      String[] s = termString.split("x");
      if (s[0].equals("-")) coef = -1;
      else if (s[0].equals("")) coef = 1;
      else if (s[0].equals("+")) coef = 1;
      else coef = Integer.valueOf(s[0]);

      if (s.length < 2) exponent = 1;
      else exponent = Integer.valueOf(s[1].substring(1));
      
    }
  }

  public int getCoef() {
    return coef;
  }

  public int getCoefficient() {
    return getCoef();
  }

  public int getExponent() {
    return exponent;
  }

  public void setCoef(int coef) {
    this.coef = coef;
  }

  public void setCoefficient(int coef) {
    setCoef(coef);
  }

  public void setAll(int c, int e) {
    setCoef(c);
    setExponent(e);
  }

  public void setExponent(int exponent) {
    this.exponent = exponent;
  }

  @Override 
  public boolean equals(Object o) {
    if (o == null) {
      return false;
    }
    if (o instanceof Term) {
      Term t = (Term) o;
      return (t.getCoef() == this.coef) && (t.getExponent() == this.exponent);
    }
    return false;
  }

  public Term add(Term o) {
    coef += o.getCoef();
    return this;
  }

  @Override
  public String toString() {
    String s = "";
    String c = "";
    String e = "";
    if (coef == 0) {
      return "";
    }
    if (exponent == 0) e = "";
    else if (exponent == 1) e = "x";
    else e = String.format("x^%d", exponent);

    if (coef == 1 && exponent != 0) c = "+";
    else if (coef == -1 && exponent != 0) c = "-";
    else if (coef > 0) c = String.format("+%d", coef);
    else if (coef < 0) c = String.format("%d", coef);
    return(c+e);
  }

  @Override
  public int compareTo(Object o){
    // if (!(o instanceof Term)) {
    //   return 0;
    // }
    Term other = (Term) o;
    return this.exponent - other.exponent;
  }

  @Override
  public Object clone() {
    return new Term(this.coef, this.exponent);
  }
}

