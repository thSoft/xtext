package org.eclipse.xtext.xbase.scoping.batch;

import java.util.List;
import java.util.Set;
import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;
import org.eclipse.xtext.xbase.scoping.batch.TypeBucket;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceHint;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc
 */
@Data
@SuppressWarnings("all")
public class SynonymTypeBucket extends TypeBucket {
  private final Set<ConformanceHint> _hints;
  
  public Set<ConformanceHint> getHints() {
    return this._hints;
  }
  
  public SynonymTypeBucket(final int id, final List<JvmType> types, final Set<ConformanceHint> hints) {
    super(id, types);
    this._hints = hints;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((_hints== null) ? 0 : _hints.hashCode());
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
    if (!super.equals(obj))
      return false;
    SynonymTypeBucket other = (SynonymTypeBucket) obj;
    if (_hints == null) {
      if (other._hints != null)
        return false;
    } else if (!_hints.equals(other._hints))
      return false;
    return true;
  }
  
  @Override
  public String toString() {
    String result = new ToStringHelper().toString(this);
    return result;
  }
}