package com.codecool.lifeofants.ants;

import com.codecool.lifeofants.Animal;
import com.codecool.lifeofants.Position;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@AllArgsConstructor
public abstract class Ant implements Animal {
    @Getter @Setter @NonNull
    private Position position;
}
