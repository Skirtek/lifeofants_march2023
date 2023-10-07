package com.codecool.lifeofants.bee;

import com.codecool.lifeofants.Animal;
import com.codecool.lifeofants.Position;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@AllArgsConstructor
public abstract class Bee implements Animal {
    @Getter
    @Setter
    @NonNull
    private Position position;
}
