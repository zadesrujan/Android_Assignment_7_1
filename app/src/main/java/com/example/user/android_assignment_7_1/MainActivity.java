package com.example.user.android_assignment_7_1;
//Package objects contain version information about the implementation and specification of a Java package.
import android.app.SearchManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    //public is a method and fields can be accessed by the members of any class.
    //class is a collections of objects.
    //created MainActivity and extends with AppCompatActivity which is Parent class.

    EditText editText;
    //giving edit text file
    @Override
    //we use override to tells the compiler that the following method overrides a method of its superclass.
    protected void onCreate(Bundle savedInstanceState) {
        //protected can be accessed by within the package and class and subclasses
        //The Void class is an uninstantiable placeholder class to hold a reference to the Class object
        //representing the Java keyword void.
        //The savedInstanceState is a reference to a Bundle object that is passed into the onCreate method of every Android Activity
        // Activities have the ability, under special circumstances, to restore themselves to a previous state using the data stored in this bundle.
        super.onCreate(savedInstanceState);
        //Android class works in same.You are extending the Activity class which have onCreate(Bundle bundle) method in which meaningful code is written
        //So to execute that code in our defined activity. You have to use super.onCreate(bundle)
        setContentView(R.layout.activity_main);
        //R means Resource
        //layout means design
        //main is the xml you have created under res->layout->main.xml
        //Whenever you want to change your current Look of an Activity or when you move from one Activity to another .
        //he other Activity must have a design to show . So we call this method in onCreate and this is the second statement to set
        //the design

        editText = (EditText) findViewById(R.id.editText);
        //giving edit text and it will find the text from activity what ur giving.
        Button button = (Button)findViewById(R.id.button);
        //it will find the button as we created in the activity
        button.setOnClickListener(new View.OnClickListener() {
            //we use set on click listner method because if we click on event then listener then the method is called.
            @Override
            public void onClick(View view) {
                //we use onclick to invoke the button
                try {
                    Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                    //we are using intent to perform one operation,it can be use as activity or to launch,
                    //here we are using as action web search to launch the search engine.
                    String term = editText.getText().toString();
                    //we are giving string and the object as term so that we can type any type of matter that we want to search
                    intent.putExtra(SearchManager.QUERY, term);
                    //is the text to search for. If it is a url starts with http or https,the site will be opened.If it is plain text,
                    // Google search will be applied.
                    startActivity(intent);
                    //start the activity.
                }
                catch (Exception e){
                    //if any errors will be the exception will catch.

                }
            }
        });

    }
}
