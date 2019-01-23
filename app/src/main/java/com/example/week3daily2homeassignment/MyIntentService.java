package com.example.week3daily2homeassignment;

import android.app.IntentService;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

import static com.example.week3daily2homeassignment.IntentActionConstants.CREATE_RANDOMLIST;

public class MyIntentService extends IntentService {

    MyBroadcastReceiver myBroadcastReceiver;
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */

    public MyIntentService() {
        super("");
    }


    public MyIntentService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        switch (intent.getAction()) {
            case CREATE_RANDOMLIST:
//                getAnimalList();

                Log.d("TAG", "Got The Random List");

                Intent intent1 = new Intent();
                intent1.setAction("action_be_lazy_and_sleep");
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("animalList", getAnimalList());
                intent1.putExtras(bundle);
                Log.d("TAG", "onCreate: SENDING BROADCAST");
                sendBroadcast(intent1, "permission.for.this.reciever");

                break;
        }
        stopSelf();
    }

    public ArrayList<Animal> getAnimalList() {

        ArrayList<Animal> animals = new ArrayList<>();

        Animal animal1 = new Animal("Eagle", "Bird", "Birdie", "https://images.freeimages.com/images/large-previews/25d/eagle-1523807.jpg");
        Animal animal2 = new Animal("Tiger", "Mammal", "Roar", "https://images.freeimages.com/images/large-previews/25d/eagle-1523807.jpg");
        Animal animal3 = new Animal("Tuna", "Fish", "Fishie", "https://images.freeimages.com/images/large-previews/25d/eagle-1523807.jpg");
        Animal animal4 = new Animal("Human", "Mammal", "Talk", "https://images.freeimages.com/images/large-previews/25d/eagle-1523807.jpg");
        Animal animal5 = new Animal("Dog", "Mammal", "Bark", "https://images.freeimages.com/images/large-previews/25d/eagle-1523807.jpg");
        Animal animal6 = new Animal("Cat", "Mammal", "Meow", "https://images.freeimages.com/images/large-previews/25d/eagle-1523807.jpg");
        Animal animal7 = new Animal("Blue Whale", "Fish", "Whoo", "https://images.freeimages.com/images/large-previews/25d/eagle-1523807.jpg");
        Animal animal8 = new Animal("Crocodile", "Reptile", "Croc", "https://images.freeimages.com/images/large-previews/25d/eagle-1523807.jpg");
        Animal animal9 = new Animal("Lizard", "Reptile", "Tik Tik", "https://images.freeimages.com/images/large-previews/25d/eagle-1523807.jpg");
        Animal animal10 = new Animal("Lion", "Mammal", "Roar", "https://images.freeimages.com/images/large-previews/25d/eagle-1523807.jpg");
        Animal animal11 = new Animal("StarFish", "Fish", "NA", "https://images.freeimages.com/images/large-previews/25d/eagle-1523807.jpg");

        animals.add(animal1);
        animals.add(animal2);
        animals.add(animal3);
        animals.add(animal4);
        animals.add(animal5);
        animals.add(animal8);
        animals.add(animal9);
        animals.add(animal11);

        ArrayList<Animal> randomAnimalList = new ArrayList<>();
        Random random = new Random();
        int listSize = 5;

        for (int i = 0; i < listSize; i++ ){
            int randomIndex = random.nextInt(animals.size());
            randomAnimalList.add(animals.get(randomIndex));
            animals.remove(randomIndex);
        }

        return randomAnimalList;
    }
}
