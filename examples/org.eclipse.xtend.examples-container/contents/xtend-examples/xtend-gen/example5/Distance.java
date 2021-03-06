/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Author - Sven Efftinge
 */
package example5;

import java.math.BigDecimal;
import java.math.MathContext;
import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;

@Data
@SuppressWarnings("all")
public class Distance {
  private final BigDecimal _mm;
  
  public BigDecimal getMm() {
    return this._mm;
  }
  
  public Distance operator_plus(final Distance other) {
    BigDecimal _mm = this.getMm();
    BigDecimal _mm_1 = other.getMm();
    BigDecimal _plus = _mm.add(_mm_1);
    return new Distance(_plus);
  }
  
  public Distance operator_minus(final Distance other) {
    BigDecimal _mm = this.getMm();
    BigDecimal _mm_1 = other.getMm();
    BigDecimal _minus = _mm.subtract(_mm_1);
    return new Distance(_minus);
  }
  
  public Distance operator_multiply(final int times) {
    BigDecimal _mm = this.getMm();
    BigDecimal _bigDecimal = new BigDecimal(times);
    BigDecimal _multiply = _mm.multiply(_bigDecimal);
    return new Distance(_multiply);
  }
  
  public Distance operator_divide(final int times) {
    BigDecimal _mm = this.getMm();
    BigDecimal _bigDecimal = new BigDecimal(times);
    BigDecimal _divide = _mm.divide(_bigDecimal, MathContext.DECIMAL128);
    return new Distance(_divide);
  }
  
  public static Distance mm(final int millimeters) {
    BigDecimal _bigDecimal = new BigDecimal(millimeters);
    return new Distance(_bigDecimal);
  }
  
  public static Distance cm(final int centimeters) {
    return Distance.mm((centimeters * 10));
  }
  
  public static Distance m(final int meters) {
    return Distance.cm((meters * 100));
  }
  
  public static Distance km(final int kilometers) {
    return Distance.m((kilometers * 1000));
  }
  
  public Distance(final BigDecimal mm) {
    super();
    this._mm = mm;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((_mm== null) ? 0 : _mm.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Distance other = (Distance) obj;
    if (_mm == null) {
      if (other._mm != null)
        return false;
    } else if (!_mm.equals(other._mm))
      return false;
    return true;
  }
  
  @Override
  public String toString() {
    String result = new ToStringHelper().toString(this);
    return result;
  }
}
