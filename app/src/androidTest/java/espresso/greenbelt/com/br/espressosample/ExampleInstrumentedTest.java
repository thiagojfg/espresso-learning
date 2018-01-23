package espresso.greenbelt.com.br.espressosample;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.hamcrest.CoreMatchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


import android.support.test.espresso.matcher.RootMatchers;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Rule
    public ActivityTestRule rule = new ActivityTestRule(MainActivity.class);

    @Test
    public void testMustShowToastMissingNumber1(){

        Espresso.onView(ViewMatchers.withId(R.id.editTextNumero1))
                .perform(ViewActions.typeText(""), ViewActions.closeSoftKeyboard());

        Espresso.onView(ViewMatchers.withId(R.id.editTextNumero2))
                .perform(ViewActions.typeText("10"), ViewActions.closeSoftKeyboard());

        Espresso.onView(ViewMatchers.withId(R.id.buttonSomar))
                .perform(ViewActions.click())
                .inRoot(RootMatchers.withDecorView(CoreMatchers.not(CoreMatchers.is(rule.getActivity().getWindow().getDecorView()))))
                .check(ViewAssertions.matches(isDisplayed()));
    }

    @Test
    public void testMustShowToastMissingNumber2(){

        Espresso.onView(ViewMatchers.withId(R.id.editTextNumero1))
                .perform(ViewActions.typeText("10"), ViewActions.closeSoftKeyboard());

        Espresso.onView(ViewMatchers.withId(R.id.editTextNumero2))
                .perform(ViewActions.typeText(""), ViewActions.closeSoftKeyboard());

        Espresso.onView(ViewMatchers.withId(R.id.buttonSomar))
                .perform(ViewActions.click())
                .inRoot(RootMatchers.withDecorView(CoreMatchers.not(CoreMatchers.is(rule.getActivity().getWindow().getDecorView()))))
                .check(ViewAssertions.matches(isDisplayed()));
    }

    @Test
    public void testMustBe20(){

        Espresso.onView(ViewMatchers.withId(R.id.editTextNumero1))
                .perform(ViewActions.typeText("10"), ViewActions.closeSoftKeyboard());

        Espresso.onView(ViewMatchers.withId(R.id.editTextNumero2))
                .perform(ViewActions.typeText("10"), ViewActions.closeSoftKeyboard());

        Espresso.onView(ViewMatchers.withId(R.id.buttonSomar))
                .perform(ViewActions.click());

        Espresso.onView(ViewMatchers.withId(R.id.textViewResultado))
                .check(ViewAssertions.matches(ViewMatchers.withText("20")));
    }
}
