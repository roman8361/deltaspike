package ru.kravchenko.deltaspike.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.Nullable;
import ru.kravchenko.deltaspike.entity.Status;

/**
 * @author Roman Kravchenko
 */

@Getter
@Setter
@NoArgsConstructor
public class UserDTO extends AbstractEntityDTO {

    @Nullable
    private String login = "";

    @Nullable
    private String password = "";

    @Nullable
    private Status role = Status.USER;

}
