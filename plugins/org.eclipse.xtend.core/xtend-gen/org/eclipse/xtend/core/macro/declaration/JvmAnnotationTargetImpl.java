/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro.declaration;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.macro.declaration.JvmNamedElementImpl;
import org.eclipse.xtend.lib.macro.declaration.AnnotationReference;
import org.eclipse.xtend.lib.macro.declaration.MutableAnnotationTarget;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmAnnotationTarget;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public abstract class JvmAnnotationTargetImpl<T extends JvmAnnotationTarget> extends JvmNamedElementImpl<T> implements MutableAnnotationTarget {
  public List<AnnotationReference> getAnnotations() {
    T _delegate = this.getDelegate();
    EList<JvmAnnotationReference> _annotations = _delegate.getAnnotations();
    final Function1<JvmAnnotationReference,AnnotationReference> _function = new Function1<JvmAnnotationReference,AnnotationReference>() {
        public AnnotationReference apply(final JvmAnnotationReference it) {
          CompilationUnitImpl _compilationUnit = JvmAnnotationTargetImpl.this.getCompilationUnit();
          AnnotationReference _annotationReference = _compilationUnit.toAnnotationReference(it);
          return _annotationReference;
        }
      };
    List<AnnotationReference> _map = ListExtensions.<JvmAnnotationReference, AnnotationReference>map(_annotations, _function);
    ImmutableList<AnnotationReference> _copyOf = ImmutableList.<AnnotationReference>copyOf(_map);
    return _copyOf;
  }
}