package com.udacity.gradle.builditbigger;

import android.support.test.espresso.IdlingRegistry;
import android.support.test.espresso.IdlingResource;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

import static junit.framework.Assert.assertNotNull;

@RunWith(AndroidJUnit4.class)
public class EdnpointsTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);


    private IdlingResource resource;
    private String joke;

    @Before
    public void registerIdlingResource() {
        resource = activityTestRule.getActivity().getIdlingResource();
        IdlingRegistry.getInstance().register(resource);
    }

    @Test
    public void testJokesAsyncTaskGCE() {
        onView(withId(R.id.tell_joke_button)).perform(click());
        joke = activityTestRule.getActivity().jokeReceived;

        //if the string is not null we have a joke
        assertNotNull(joke);
    }

    @After
    public void unregisterIdlingResource() {
        IdlingRegistry.getInstance().unregister(resource);
    }
}
