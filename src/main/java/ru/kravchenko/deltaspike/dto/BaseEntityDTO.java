package ru.kravchenko.deltaspike.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.Nullable;
import ru.kravchenko.deltaspike.entity.StatusProjectTask;

import java.util.Date;

/**
 * @author Roman Kravchenko
 */

@Getter
@Setter
@NoArgsConstructor
public class BaseEntityDTO extends AbstractEntityDTO {

    @Nullable
    protected Date dateBegin = new Date();

    @Nullable
    protected Date dateEnd = null;

    @Nullable
    protected String userId = "";

    @Getter
    protected StatusProjectTask status = StatusProjectTask.PLANNED;

}
