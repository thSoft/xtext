/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.typesystem;

import org.eclipse.xtend.core.tests.typesystem.AbstractAssignabilityTest;
import org.eclipse.xtext.xbase.lib.Pair;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("all")
public class AssignabilityTest extends AbstractAssignabilityTest {
  @Test
  public void testPrimitiveConversion_09() {
    this.isAssignableFrom("Comparable", "int");
    this.isAssignableFrom("Comparable<Integer>", "int");
    this.isAssignableFrom("Comparable<? extends Number>", "int");
    this.isNotAssignableFrom("Comparable<Number>", "int");
  }
  
  @Test
  public void testWildcardWithDefaultUpper() {
    this.isAssignableFrom("Iterable<? extends Object>", "java.util.List<?>");
    this.isAssignableFrom("Iterable", "java.util.List<?>");
    this.isAssignableFrom("Iterable<? extends Object>", "java.util.List");
    this.isAssignableFrom("Iterable", "java.util.List");
  }
  
  @Test
  public void testWildcardLowerBound_02() {
    this.isNotAssignableFrom("java.util.List<? super Integer>", "java.util.List<? super String>");
    this.isAssignableFrom("java.util.List", "java.util.List<? super String>");
    this.isAssignableFrom("java.util.List<? super Integer>", "java.util.List");
  }
  
  @Test
  public void testLeftIsRawType_01() {
    this.isAssignableFrom("java.util.Collection", "java.util.List<? super String>");
  }
  
  @Test
  public void testLeftIsRawType_02() {
    this.isAssignableFrom("java.util.Collection", "java.util.List<? extends String>");
  }
  
  @Test
  public void testLeftIsRawType_03() {
    this.isAssignableFrom("java.util.Collection", "java.util.List<String>");
  }
  
  @Test
  public void testRightIsRawType_01() {
    this.isAssignableFrom("java.util.Collection<? super String>", "java.util.List");
  }
  
  @Test
  public void testRightIsRawType_02() {
    this.isAssignableFrom("java.util.Collection<? extends String>", "java.util.List");
  }
  
  @Test
  public void testRightIsRawType_03() {
    this.isAssignableFrom("java.util.Collection<String>", "java.util.List");
  }
  
  @Test
  public void testInterfaceConformsToObject_01() {
    this.isAssignableFrom("Object", "CharSequence");
  }
  
  @Test
  public void testInterfaceConformsToObject_02() {
    this.isAssignableFrom("Object", "Iterable<CharSequence>");
  }
  
  @Test
  public void testLowerBoundTypeParameter() {
    this.isAssignableFrom("java.util.List<? super String>", "java.util.List<? super CharSequence>");
    this.isNotAssignableFrom("java.util.List<? super CharSequence>", "java.util.List<? super String>");
  }
  
  @Test
  public void testLowerBoundTypeParameterAndInvariant_01() {
    this.isAssignableFrom("Iterable<? super String>", "java.util.List<CharSequence>");
    this.isNotAssignableFrom("Iterable<? super CharSequence>", "java.util.List<? super String>");
  }
  
  @Test
  public void testLowerBoundTypeParameterAndInvariant_02() {
    this.isAssignableFrom("Iterable<? super String>", "Iterable<CharSequence>");
    this.isNotAssignableFrom("Iterable<? super CharSequence>", "Iterable<? super String>");
  }
  
  @Test
  public void testLowerBoundAndUpperBound_01() {
    this.isNotAssignableFrom("Iterable<? super CharSequence>", "Iterable<? extends String>");
    this.isNotAssignableFrom("Iterable<? extends CharSequence>", "Iterable<? super String>");
  }
  
  @Test
  public void testWildcardAndInvariant_01() {
    this.isAssignableFrom("Iterable<?>", "Iterable<String>");
    this.isAssignableFrom("Iterable<? extends Object>", "Iterable<String>");
  }
  
  @Test
  public void testWildcardAndUpperBound_01() {
    this.isAssignableFrom("Iterable<?>", "Iterable<? extends String>");
    this.isAssignableFrom("Iterable<? extends Object>", "Iterable<? extends String>");
  }
  
  @Test
  public void testWildcardAndLowerBound_01() {
    this.isAssignableFrom("Iterable<?>", "Iterable<? super String>");
    this.isAssignableFrom("Iterable<? extends Object>", "Iterable<? super String>");
  }
  
  @Test
  public void testBoundTypeParameter_01() {
    this.isAssignableFrom("Iterable<CharSequence>", "org.eclipse.xtend.core.tests.typesystem.CharIterable");
    this.isNotAssignableFrom("org.eclipse.xtend.core.tests.typesystem.CharIterable", "Iterable<Character>");
  }
  
  @Test
  public void testBoundTypeParameter_02() {
    this.isAssignableFrom("Iterable<Object>", "org.eclipse.xtend.core.tests.typesystem.CharIterable");
    this.isNotAssignableFrom("org.eclipse.xtend.core.tests.typesystem.CharIterable", "Iterable<Object>");
  }
  
  @Test
  public void testUpperBoundTypeParameter() {
    this.isNotAssignableFrom("java.util.List<? extends String>", "java.util.List<? extends CharSequence>");
    this.isAssignableFrom("java.util.List<? extends CharSequence>", "java.util.List<? extends String>");
  }
  
  @Test
  public void testUpperBoundTypeParameter_02() {
    this.isAssignableFrom("java.util.List<? extends CharSequence>", "java.util.List<? extends String>");
  }
  
  @Test
  public void testInvariantTypeParameter_01() {
    this.isNotAssignableFrom("java.util.Collection<String>", "java.util.List<CharSequence>");
    this.isAssignableFrom("java.util.Collection<String>", "java.util.List<String>");
    this.isNotAssignableFrom("java.util.Collection<CharSequence>", "java.util.List<String>");
  }
  
  @Test
  public void testInvariantTypeParameter_02() {
    this.isAssignableFrom("java.util.Map<? extends CharSequence, ? extends Number>", "java.util.Map<? extends String, ? extends Integer>");
    this.isAssignableFrom("java.util.Map<? extends CharSequence, ? extends Number>", "java.util.Map<String, Integer>");
  }
  
  @Test
  public void testInvariantTypeParameter_03() {
    this.isNotAssignableFrom("Iterable<Iterable<String>>", "Iterable<Iterable<CharSequence>>");
    this.isNotAssignableFrom("Iterable<Iterable<CharSequence>>", "Iterable<Iterable<String>>");
  }
  
  @Test
  public void testTypeParameter_08() {
    Pair<String,String> _mappedTo = Pair.<String, String>of("Iterable<T>", "T extends CharSequence");
    this.isNotAssignableFrom(_mappedTo, "org.eclipse.xtend.core.tests.typesystem.CharIterable<String>");
    Pair<String,String> _mappedTo_1 = Pair.<String, String>of("Iterable<T>", "T extends CharSequence");
    this.isNotAssignableFrom(_mappedTo_1, "org.eclipse.xtend.core.tests.typesystem.CharIterable<CharSequence>");
    Pair<String,String> _mappedTo_2 = Pair.<String, String>of("Iterable<T>", "T extends CharSequence");
    this.isNotAssignableFrom(_mappedTo_2, "org.eclipse.xtend.core.tests.typesystem.CharIterable<? extends CharSequence>");
    Pair<String,String> _mappedTo_3 = Pair.<String, String>of("Iterable<? extends T>", "T extends CharSequence");
    this.isNotAssignableFrom(_mappedTo_3, "org.eclipse.xtend.core.tests.typesystem.CharIterable<String>");
    Pair<String,String> _mappedTo_4 = Pair.<String, String>of("Iterable<? extends T>", "T extends CharSequence");
    this.isNotAssignableFrom(_mappedTo_4, "org.eclipse.xtend.core.tests.typesystem.CharIterable<CharSequence>");
    Pair<String,String> _mappedTo_5 = Pair.<String, String>of("Iterable<? extends T>", "T extends CharSequence");
    this.isNotAssignableFrom(_mappedTo_5, "org.eclipse.xtend.core.tests.typesystem.CharIterable<? extends CharSequence>");
    Pair<String,String> _mappedTo_6 = Pair.<String, String>of("Iterable<T>", "T extends CharSequence");
    this.isAssignableFrom(_mappedTo_6, "org.eclipse.xtend.core.tests.typesystem.CharIterable");
    Pair<String,String> _mappedTo_7 = Pair.<String, String>of("Iterable<T>", "T extends Number");
    this.isAssignableFrom(_mappedTo_7, "org.eclipse.xtend.core.tests.typesystem.CharIterable");
  }
  
  @Test
  public void testTwoTypeParameters_02() {
    Pair<String,String> _mappedTo = Pair.<String, String>of("Iterable<T>", "T, V extends T");
    this.isNotAssignableFrom(_mappedTo, "Iterable<V>");
    Pair<String,String> _mappedTo_1 = Pair.<String, String>of("Iterable<? extends T>", "T, V extends T");
    this.isAssignableFrom(_mappedTo_1, "Iterable<V>");
    Pair<String,String> _mappedTo_2 = Pair.<String, String>of("Iterable<? extends T>", "T, V extends T");
    this.isAssignableFrom(_mappedTo_2, "Iterable<? extends V>");
  }
  
  @Test
  public void testTwoTypeParameters_03() {
    Pair<String,String> _mappedTo = Pair.<String, String>of("Iterable<? super V>", "T, V extends T");
    this.isAssignableFrom(_mappedTo, "Iterable<? super T>");
    Pair<String,String> _mappedTo_1 = Pair.<String, String>of("Iterable<? super T>", "T, V extends T");
    this.isNotAssignableFrom(_mappedTo_1, "Iterable<? super V>");
  }
  
  @Test
  public void testFunctionTypes_01() {
    this.isAssignableFrom("(String)=>void", "(CharSequence)=>void");
    this.isAssignableFrom("(String)=>void", "(String)=>void");
    this.isNotAssignableFrom("(CharSequence)=>void", "(String)=>void");
  }
  
  @Test
  public void testFunctionTypes_02() {
    this.isAssignableFrom("(String)=>String", "(CharSequence)=>String");
    this.isAssignableFrom("(String)=>String", "(String)=>String");
    this.isNotAssignableFrom("(CharSequence)=>String", "(String)=>String");
  }
  
  @Test
  public void testFunctionTypes_03() {
    this.isAssignableFrom("(String)=>CharSequence", "(CharSequence)=>String");
    this.isAssignableFrom("(String)=>CharSequence", "(String)=>String");
    this.isNotAssignableFrom("(CharSequence)=>CharSequence", "(String)=>String");
  }
  
  @Test
  public void testFunctionTypes_07() {
    Pair<String,String> _mappedTo = Pair.<String, String>of("(T)=>T", "T extends Integer");
    this.isNotAssignableFrom(_mappedTo, "(Integer)=>Integer");
    Pair<String,String> _mappedTo_1 = Pair.<String, String>of("(T)=>T", "T extends Integer");
    this.isNotAssignableFrom(_mappedTo_1, "(int)=>int");
  }
  
  @Test
  public void testFunctionTypes_08() {
    this.isNotAssignableFrom("()=>long", "()=>int");
    this.isNotAssignableFrom("()=>int", "()=>long");
  }
  
  @Test
  public void testFunctionTypeAsParameterized_01() {
    this.isAssignableFrom("$Procedure1<String>", "(CharSequence)=>void");
    this.isAssignableFrom("$Procedure1<? super String>", "(CharSequence)=>void");
    this.isNotAssignableFrom("$Procedure1<? extends String>", "(CharSequence)=>void");
    this.isAssignableFrom("$Procedure1<String>", "(String)=>void");
    this.isAssignableFrom("$Procedure1<? super String>", "(String)=>void");
    this.isNotAssignableFrom("$Procedure1<? extends String>", "(String)=>void");
    this.isNotAssignableFrom("$Procedure1<CharSequence>", "(String)=>void");
    this.isNotAssignableFrom("$Procedure1<? super CharSequence>", "(String)=>void");
    this.isNotAssignableFrom("$Procedure1<? extends CharSequence>", "(String)=>void");
  }
  
  @Test
  public void testFunctionTypeAsParameterized_02() {
    this.isAssignableFrom("$Function1<String, String>", "(CharSequence)=>String");
    this.isAssignableFrom("$Function1<? super String, String>", "(CharSequence)=>String");
    this.isAssignableFrom("$Function1<String, ? extends String>", "(CharSequence)=>String");
    this.isAssignableFrom("$Function1<? super String, ? extends String>", "(CharSequence)=>String");
    this.isAssignableFrom("$Function1<String, String>", "(String)=>String");
    this.isAssignableFrom("$Function1<? super String, String>", "(String)=>String");
    this.isAssignableFrom("$Function1<String, ? extends String>", "(String)=>String");
    this.isAssignableFrom("$Function1<? super String, ? extends String>", "(String)=>String");
    this.isNotAssignableFrom("$Function1<CharSequence, String>", "(String)=>String");
    this.isNotAssignableFrom("$Function1<? super CharSequence, String>", "(String)=>String");
    this.isNotAssignableFrom("$Function1<CharSequence, ? extends String>", "(String)=>String");
    this.isNotAssignableFrom("$Function1<? super CharSequence, ? extends String>", "(String)=>String");
  }
  
  @Test
  public void testFunctionTypeAsParameterized_03() {
    this.isAssignableFrom("$Function1<String, CharSequence>", "(CharSequence)=>String");
    this.isAssignableFrom("$Function1<? super String, CharSequence>", "(CharSequence)=>String");
    this.isAssignableFrom("$Function1<String, ? extends CharSequence>", "(CharSequence)=>String");
    this.isAssignableFrom("$Function1<? super String, ? extends CharSequence>", "(CharSequence)=>String");
    this.isAssignableFrom("$Function1<String, CharSequence>", "(String)=>String");
    this.isAssignableFrom("$Function1<? super String, CharSequence>", "(String)=>String");
    this.isAssignableFrom("$Function1<String, ? extends CharSequence>", "(String)=>String");
    this.isAssignableFrom("$Function1<? super String, ? extends CharSequence>", "(String)=>String");
    this.isNotAssignableFrom("$Function1<CharSequence, CharSequence>", "(String)=>String");
    this.isNotAssignableFrom("$Function1<? super CharSequence, CharSequence>", "(String)=>String");
    this.isNotAssignableFrom("$Function1<CharSequence, ? extends CharSequence>", "(String)=>String");
    this.isNotAssignableFrom("$Function1<? super CharSequence, ? extends CharSequence>", "(String)=>String");
  }
  
  @Test
  public void testFunctionTypeAsParameterized_07() {
    Pair<String,String> _mappedTo = Pair.<String, String>of("$Function1<T, T>", "T extends Integer");
    this.isNotAssignableFrom(_mappedTo, "(Integer)=>Integer");
    Pair<String,String> _mappedTo_1 = Pair.<String, String>of("$Function1<? super T, T>", "T extends Integer");
    this.isNotAssignableFrom(_mappedTo_1, "(Integer)=>Integer");
    Pair<String,String> _mappedTo_2 = Pair.<String, String>of("$Function1<T, ? extends T>", "T extends Integer");
    this.isNotAssignableFrom(_mappedTo_2, "(Integer)=>Integer");
    Pair<String,String> _mappedTo_3 = Pair.<String, String>of("$Function1<? super T, ? extends T>", "T extends Integer");
    this.isNotAssignableFrom(_mappedTo_3, "(Integer)=>Integer");
    Pair<String,String> _mappedTo_4 = Pair.<String, String>of("$Function1<T, T>", "T extends Integer");
    this.isNotAssignableFrom(_mappedTo_4, "(int)=>int");
    Pair<String,String> _mappedTo_5 = Pair.<String, String>of("$Function1<? super T, T>", "T extends Integer");
    this.isNotAssignableFrom(_mappedTo_5, "(int)=>int");
    Pair<String,String> _mappedTo_6 = Pair.<String, String>of("$Function1<T, ? extends T>", "T extends Integer");
    this.isNotAssignableFrom(_mappedTo_6, "(int)=>int");
    Pair<String,String> _mappedTo_7 = Pair.<String, String>of("$Function1<? super T, ? extends T>", "T extends Integer");
    this.isNotAssignableFrom(_mappedTo_7, "(int)=>int");
  }
  
  @Test
  public void testFunctionTypeAsParameterized_08() {
    this.isAssignableFrom("(String)=>void", "$Procedure1<CharSequence>");
    this.isAssignableFrom("(String)=>void", "$Procedure1<? super CharSequence>");
    this.isAssignableFrom("(String)=>void", "$Procedure1<String>");
    this.isAssignableFrom("(String)=>void", "$Procedure1<? super String>");
    this.isNotAssignableFrom("(CharSequence)=>void", "$Procedure1<String>");
    this.isNotAssignableFrom("(CharSequence)=>void", "$Procedure1<? super String>");
  }
  
  @Test
  public void testFunctionTypeAsParameterized_09() {
    this.isAssignableFrom("(String)=>String", "$Function1<CharSequence, String>");
    this.isAssignableFrom("(String)=>String", "$Function1<? super CharSequence, String>");
    this.isAssignableFrom("(String)=>String", "$Function1<CharSequence, ? extends String>");
    this.isAssignableFrom("(String)=>String", "$Function1<? super CharSequence, ? extends String>");
    this.isAssignableFrom("(String)=>String", "$Function1<String, String>");
    this.isAssignableFrom("(String)=>String", "$Function1<? super String, String>");
    this.isAssignableFrom("(String)=>String", "$Function1<String, ? extends String>");
    this.isAssignableFrom("(String)=>String", "$Function1<? super String, ? extends String>");
    this.isNotAssignableFrom("(CharSequence)=>String", "$Function1<String, String>");
    this.isNotAssignableFrom("(CharSequence)=>String", "$Function1<? super String, String>");
    this.isNotAssignableFrom("(CharSequence)=>String", "$Function1<String, ? extends String>");
    this.isNotAssignableFrom("(CharSequence)=>String", "$Function1<? super String, ? extends String>");
  }
  
  @Test
  public void testFunctionTypeAsParameterized_10() {
    this.isAssignableFrom("(String)=>CharSequence", "$Function1<CharSequence, String>");
    this.isAssignableFrom("(String)=>CharSequence", "$Function1<? super CharSequence, String>");
    this.isAssignableFrom("(String)=>CharSequence", "$Function1<CharSequence, ? extends String>");
    this.isAssignableFrom("(String)=>CharSequence", "$Function1<? super CharSequence, ? extends String>");
    this.isAssignableFrom("(String)=>CharSequence", "$Function1<String, String>");
    this.isAssignableFrom("(String)=>CharSequence", "$Function1<? super String, String>");
    this.isAssignableFrom("(String)=>CharSequence", "$Function1<String, ? extends String>");
    this.isAssignableFrom("(String)=>CharSequence", "$Function1<? super String, ? extends String>");
    this.isNotAssignableFrom("(CharSequence)=>CharSequence", "$Function1<String, String>");
    this.isNotAssignableFrom("(CharSequence)=>CharSequence", "$Function1<? super String, String>");
    this.isNotAssignableFrom("(CharSequence)=>CharSequence", "$Function1<String, ? extends String>");
    this.isNotAssignableFrom("(CharSequence)=>CharSequence", "$Function1<? super String, ? extends String>");
  }
  
  @Test
  public void testFunctionTypeAsParameterized_14() {
    Pair<String,String> _mappedTo = Pair.<String, String>of("(T)=>T", "T extends Integer");
    this.isNotAssignableFrom(_mappedTo, "$Function1<Integer, Integer>");
    Pair<String,String> _mappedTo_1 = Pair.<String, String>of("(T)=>T", "T extends Integer");
    this.isNotAssignableFrom(_mappedTo_1, "$Function1<? super Integer, Integer>");
    Pair<String,String> _mappedTo_2 = Pair.<String, String>of("(T)=>T", "T extends Integer");
    this.isNotAssignableFrom(_mappedTo_2, "$Function1<Integer, ? extends Integer>");
    Pair<String,String> _mappedTo_3 = Pair.<String, String>of("(T)=>T", "T extends Integer");
    this.isNotAssignableFrom(_mappedTo_3, "$Function1<? super Integer, ? extends Integer>");
  }
  
  @Test
  public void testDemandConvertedFunctionType_01() {
    this.isAssignableFrom("org.eclipse.xtext.util.IAcceptor<String>", "(CharSequence)=>void");
    this.isAssignableFrom("org.eclipse.xtext.util.IAcceptor<? super String>", "(CharSequence)=>void");
    this.isAssignableFrom("org.eclipse.xtext.util.IAcceptor<String>", "(Object)=>void");
    this.isAssignableFrom("org.eclipse.xtext.util.IAcceptor<? super String>", "(Object)=>void");
    this.isAssignableFrom("org.eclipse.xtext.util.IAcceptor<String>", "(String)=>void");
    this.isAssignableFrom("org.eclipse.xtext.util.IAcceptor<? super String>", "(String)=>void");
    this.isNotAssignableFrom("org.eclipse.xtext.util.IAcceptor<CharSequence>", "(String)=>void");
    this.isNotAssignableFrom("org.eclipse.xtext.util.IAcceptor<? super CharSequence>", "(String)=>void");
  }
  
  @Test
  public void testDemandConvertedFunctionType_05() {
    this.isAssignableFrom("org.eclipse.xtext.util.IAcceptor<Integer>", "(int)=>void");
    this.isAssignableFrom("org.eclipse.xtext.util.IAcceptor<? super Integer>", "(int)=>void");
    this.isNotAssignableFrom("org.eclipse.xtext.util.IAcceptor<? extends Integer>", "(int)=>void");
    this.isNotAssignableFrom("org.eclipse.xtext.util.IAcceptor<Number>", "(int)=>void");
    this.isNotAssignableFrom("org.eclipse.xtext.util.IAcceptor<? extends Number>", "(int)=>void");
    this.isNotAssignableFrom("org.eclipse.xtext.util.IAcceptor<? super Number>", "(int)=>void");
  }
  
  @Test
  public void testDemandConvertedFunctionType_06() {
    this.isAssignableFrom("Comparable<Integer>", "(int)=>int");
    this.isAssignableFrom("Comparable<? super Integer>", "(Integer)=>Integer");
    this.isAssignableFrom("Comparable<? super Integer>", "(Number)=>Integer");
    this.isAssignableFrom("Comparable<Integer>", "(int)=>int");
    this.isAssignableFrom("Comparable<? super Integer>", "(Integer)=>int");
    this.isAssignableFrom("Comparable<? super Integer>", "(Number)=>int");
    this.isNotAssignableFrom("Comparable<String>", "(int)=>int");
  }
}