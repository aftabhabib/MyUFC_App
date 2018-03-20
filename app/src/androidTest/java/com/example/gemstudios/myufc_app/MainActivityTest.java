package com.example.gemstudios.myufc_app;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.runner.RunWith;

import static android.support.test.espresso.contrib.DrawerMatchers.isClosed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


/**
 * Created by TAE on 15-Mar-18.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule =
            new ActivityTestRule(MainActivity.class);
}


  //  @Test
  //  public void shouldBeAbleToLaunchMainActivity()
   // {
      //  onView(withText("NEWS FEED")).check(ViewAssertions.matches(isDisplayed()));

   // }
/*
    @Test
    public void clickOnYourNavigationItem_ShowsYourScreen() {
        // Open Drawer to click on navigation.
        onView(withId(R.id.drawer_layout))
                .check(matches(isClosed(Gravity.LEFT))) // Left Drawer should be closed.
                .perform(DrawerActions.open()); // Open Drawer

        // Start the screen of your activity.
        onView(withId(R.id.nav_view))
                .perform(NavigationViewActions.navigateTo(R.id.nav_view));

        // Check that you Activity was opened.
        //String expectedNoStatisticsText = InstrumentationRegistry.getTargetContext()
         //       .getString(R.string.item);
      //  onView(withId(R.id.no_statistics)).check(matches(withText(expectedNoStatisticsText)));
    }


}*/
