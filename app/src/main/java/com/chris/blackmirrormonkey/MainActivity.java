/*Based on Netflix series 'Black Mirror' season 4, episode 6 (Black Museum)

* Inspired by part of the episode where a woman's consciousness is transferred to
* a toy monkey after she dies and her only forms of communication are two buttons:

* -A happy face that make the monkey say "Monkey loves you"
* -A sad face that makes the monkey say "Monkey needs a hug"

* Summary of scenario below, taken from Wikipedia:

* In the present, Nish offers Haynes water since the museum's air conditioning is broken and
* they are both sweating profusely, and Haynes tells another story about a stuffed monkey.
* Haynes convinced a man named Jack (Aldis Hodge) to transfer the consciousness of his comatose
* wife Carrie (Alexandra Roach) into his own brain. Carrie initially enjoyed sharing the
* sensations that Jack felt in the real world, particularly hugs with their toddler son Parker.
* However, shared consciousness began to take a toll on the couple, as Jack lacked privacy and
* Carrie had no agency in the real world. Haynes allowed Jack to put Carrie on "pause",
* infuriating her whenever he allowed her consciousness again. Jack met Emily (Yasha Jackson),
* and the two began dating, to Carrie's impotent fury. Emily pressured Jack to have Haynes
* transfer the consciousness of Carrie into a stuffed monkey, which was then given to Parker.
* The toy could only speak two phrases, "Monkey loves you" and "Monkey needs a hug". Carrie
* was furious, but Emily threatened her with deletion if she did not behave. Eventually,
* Parker grew tired of the toy and abandoned it, with Carrie trapped inside. In the present,
* Haynes tells Nish that the transfer of Carrie into the stuffed monkey was declared illegal
* and led to his firing. Haynes then reveals that Carrie is still inside the stuffed monkey
* in the exhibit, since it is also illegal to delete her.

* https://en.wikipedia.org/wiki/Black_Museum_(Black_Mirror)*/

//TODO: Add summary above to a readme.txt file somewhere in project

package com.chris.blackmirrormonkey;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.media.MediaPlayer;
import android.widget.ImageButton;

public class MainActivity extends Activity {

    // Creates variables two ImageButton variables and two MediaPlayer variables
    // ImageButton variables are refering to buttons in xml
    // MediaPlayer variables are refering to audio for each button.
    ImageButton monkeyloves, monkeyhug;
    MediaPlayer monkeylovessound, monkeyhugsound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initilize audio (correct terminology?)
        monkeylovessound = MediaPlayer.create(this, R.raw.monkeylovesyousound);
        monkeyhugsound = MediaPlayer.create(this, R.raw.monkeyneedsahugsound);

        // Get ImageButton variables(?) from xml
        monkeyloves = (ImageButton) findViewById(R.id.monkeylovesbtn);
        monkeyhug = (ImageButton) findViewById(R.id.monkeyneedshugbtn);

        // Plays 'Monkey loves you' when happy face is touched.
        monkeyloves.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // Plays sound
                monkeylovessound.start();

                // Disables other button
                monkeyhug.setEnabled(false);

                // Renables other button after sounds finishes (~1.2 seconds)
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        monkeyhug.setEnabled(true);
                    }
                }, 1200);
            }
        });

        // Plays 'Monkey needs a hug' when sad face is touched.
        monkeyhug.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // Plays sound
                monkeyhugsound.start();

                // Disables other button
                monkeyloves.setEnabled(false);

                // Renables other button after sounds finishes (~1.2 seconds)
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        monkeyloves.setEnabled(true);
                    }
                }, 1200);
            }
        });
    }
}
