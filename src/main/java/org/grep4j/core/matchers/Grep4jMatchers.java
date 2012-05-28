package org.grep4j.core.matchers;

import java.util.List;

import org.grep4j.core.matchers.misc.GrepOccurrency;
import org.grep4j.core.matchers.misc.GrepOccurrencyBuilder;
import org.grep4j.core.matchers.misc.GrepOccurrencyType;
import org.grep4j.core.model.Profile;
import org.hamcrest.Matcher;

/**
 * Facade class for all the core matchers
 * @author Marco Castigliego
 * @author Giovanni Gargiulo
 */
public class Grep4jMatchers {

	/**
	 * Assert that the expression is present in the list of profiles provided for the frequency of times specified
	 * Example usage:
	 * 
	 * assertThat("ID12354", appears(exactly(2).times(), on(profiles)));
	 * 
	 * @param frequency of occurrences @see {@link GrepOccurrencyType}  
	 * @param profiles where to search for occurrences
	 * @return matcher {@link GrepResultAppears}
	 */
	public static <T> Matcher<String> appears(GrepOccurrency frequency,
			List<Profile> profiles) {
		return org.grep4j.core.matchers.GrepResultAppears.appears(frequency,
				profiles);
	}

	/**
	 * Assert that the expression is not present in the list of profiles provided
	 * Example usage:
	 * 
	 * assertThat("ID12354", neverAppears(on(profiles)));
	 * 
	 * @param profiles where to search for occurrences
	 * @return matcher {@link GrepResultAppears}
	 */
	public static <T> Matcher<String> neverAppears(List<Profile> profiles) {
		return org.grep4j.core.matchers.GrepResultAppears.appears(zero().times(),
				profiles);
	}

	/**
	 * Assert that the expression is present in the list of profiles provided
	 * Example usage:
	 * 
	 * assertThat("ID12354", appears(on(profiles)));
	 * 
	 * @param profiles where to search for occurrences
	 * @return matcher {@link GrepResultAppears}
	 */
	public static <T> Matcher<String> appears(List<Profile> profiles) {
		return org.grep4j.core.matchers.GrepResultAppears.appears(atLeast(1).times(),
				profiles);
	}

	/**
	 * Use this if you want to test that the pattern appears in the profiles exactly (value == threshold) x times
	 * @param times
	 * @return {@link GrepOccurrencyBuilder}
	 */
	public static GrepOccurrencyBuilder exactly(int times) {
		return new GrepOccurrencyBuilder(times, GrepOccurrencyType.EXACTLY);
	}

	/**
	 * Use this if you want to test that the pattern appears in the profiles at least (value >=threshold) x times
	 * @param times
	 * @return {@link GrepOccurrencyBuilder}
	 */
	public static GrepOccurrencyBuilder atLeast(int times) {
		return new GrepOccurrencyBuilder(times, GrepOccurrencyType.AT_LEAST);
	}

	/**
	 * Use this if you want to test that the pattern appears in the profiles at most (value <= threshold) x times
	 * @param times
	 * @return {@link GrepOccurrencyBuilder}
	 */
	public static GrepOccurrencyBuilder atMost(int times) {
		return new GrepOccurrencyBuilder(times, GrepOccurrencyType.AT_MOST);
	}

	/**
	 * Use this if you want to test that the pattern appears in the profiles at most (value <= threshold) x times
	 * @param times
	 * @return {@link GrepOccurrencyBuilder}
	 */
	public static GrepOccurrencyBuilder zero() {
		return new GrepOccurrencyBuilder(0, GrepOccurrencyType.EXACTLY);
	}

}