package com.example.pbogdanov.testprojectfive_fragments;

/**
 * Created by p.bogdanov on 13.12.2016.
 */

public class Workout {
    private String name;
    private String description;

    static Workout[] workouts = {
            new Workout("The Limb Loosener", "5 handstand push-ups\n10 1-legged squats\n15 pull-ups"),
            new Workout("Core Agony", "100 pull-ups\n100 push-ups\n100 sit-ups\n100 squats"),
            new Workout("Strength and Length", "21 x 1.5 pood kettlebell swing\n21 x push-ups")
    };

    public Workout(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
