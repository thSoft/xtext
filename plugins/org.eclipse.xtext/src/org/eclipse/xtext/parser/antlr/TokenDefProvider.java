/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.antlr;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class TokenDefProvider implements ITokenDefProvider {

	private final ImmutableMap<Integer, String> index;

	protected TokenDefProvider(ImmutableMap<Integer, String> index) {
		this.index = index;
	}

	public static ITokenDefProvider from(String[] tokens) {
		List<String> interestingTokens = Arrays.asList(tokens).subList(4, tokens.length);
		ImmutableMap<Integer,String> index = Maps.uniqueIndex(interestingTokens, new Function<String, Integer>() {

			private int current = 4;
			
			public Integer apply(String from) {
				Integer result = current;
				current++;
				return result;
			}
			
		});
		return new TokenDefProvider(index);
	}
	
	public Map<Integer, String> getTokenDefMap() {
		return index;
	}

}
