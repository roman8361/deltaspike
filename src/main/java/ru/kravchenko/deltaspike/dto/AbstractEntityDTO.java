package ru.kravchenko.deltaspike.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

/**
 * @author Roman Kravchenko
 */

@Getter
@Setter
@NoArgsConstructor
public abstract class AbstractEntityDTO {

    @NotNull
    protected String id = UUID.randomUUID().toString();

    @Nullable
    protected String name;

    @Nullable
    protected String description;

}
