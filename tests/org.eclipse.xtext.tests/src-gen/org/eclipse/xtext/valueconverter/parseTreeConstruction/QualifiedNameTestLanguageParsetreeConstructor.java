/*
* generated by Xtext
*/
package org.eclipse.xtext.valueconverter.parseTreeConstruction;

import org.eclipse.emf.ecore.*;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parsetree.reconstr.IEObjectConsumer;

import org.eclipse.xtext.valueconverter.services.QualifiedNameTestLanguageGrammarAccess;

import com.google.inject.Inject;

@SuppressWarnings("all")
public class QualifiedNameTestLanguageParsetreeConstructor extends org.eclipse.xtext.parsetree.reconstr.impl.AbstractParseTreeConstructor {
		
	@Inject
	private QualifiedNameTestLanguageGrammarAccess grammarAccess;
	
	@Override
	protected AbstractToken getRootToken(IEObjectConsumer inst) {
		return new ThisRootNode(inst);	
	}
	
protected class ThisRootNode extends RootToken {
	public ThisRootNode(IEObjectConsumer inst) {
		super(inst);
	}
	
	@Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Element_Group(this, this, 0, inst);
			default: return null;
		}	
	}	
}
	

/************ begin Rule Element ****************
 *
 * Element:
 * 	"keyword" qualifiedName=QualifiedName;
 *
 **/

// "keyword" qualifiedName=QualifiedName
protected class Element_Group extends GroupToken {
	
	public Element_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getElementAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Element_QualifiedNameAssignment_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getElementRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// "keyword"
protected class Element_KeywordKeyword_0 extends KeywordToken  {
	
	public Element_KeywordKeyword_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getElementAccess().getKeywordKeyword_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

}

// qualifiedName=QualifiedName
protected class Element_QualifiedNameAssignment_1 extends AssignmentToken  {
	
	public Element_QualifiedNameAssignment_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getElementAccess().getQualifiedNameAssignment_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Element_KeywordKeyword_0(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("qualifiedName",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("qualifiedName");
		if(valueSerializer.isValid(obj.getEObject(), grammarAccess.getElementAccess().getQualifiedNameQualifiedNameParserRuleCall_1_0(), value, null)) {
			type = AssignmentType.DATATYPE_RULE_CALL;
			element = grammarAccess.getElementAccess().getQualifiedNameQualifiedNameParserRuleCall_1_0();
			return obj;
		}
		return null;
	}

}


/************ end Rule Element ****************/


}
