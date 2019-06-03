package ru.kravchenko.deltaspike.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.Nullable;

/**
 * @author Roman Kravchenko
 */

@Getter
@Setter
@NoArgsConstructor
public class ProjectDTO extends BaseEntityDTO {

    public ProjectDTO(
            @Nullable final String name,
            @Nullable final String description,
            @Nullable final String userId) {
        this.name = name;
        this.description = description;
        this.userId = userId;
    }

}
