package com.example.witssocial_;
import static android.service.autofill.Validators.not;
//import static android.support.test.InstrumentationRegistry.getInstrumentation;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.test.platform.app.InstrumentationRegistry;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static junit.framework.TestCase.assertNotNull;
import android.app.Instrumentation;
import android.support.test.rule.ActivityTestRule;
import android.widget.EditText;
import android.widget.TextView;

import androidx.test.espresso.Espresso;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class commTest {
    @Rule
    public ActivityScenarioRule<Comment_Section> activityScenarioRule = new ActivityScenarioRule<>(Comment_Section.class);
    Instrumentation.ActivityMonitor monitor = InstrumentationRegistry.getInstrumentation().addMonitor(Comment_Section.class.getName(),null,false);

    @Test
    public void AllPostscheck(){
        activityScenarioRule.getScenario().onActivity(activity -> {
            AppCompatEditText addComment = activity.findViewById(R.id.add_a_comment);

            assertNotNull(addComment);
        });

    }


    @Test
    public void enterComment(){
        Espresso.onView(withId(R.id.add_a_comment)).perform(typeText("A comment")).perform(closeSoftKeyboard());
        Espresso.onView(withId(R.id.upload_comment)).perform(click());
    }




}
