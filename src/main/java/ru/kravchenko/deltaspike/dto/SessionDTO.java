package ru.kravchenko.deltaspike.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.Nullable;

import java.util.Date;

/**
 * @author Roman Kravchenko
 */

@Getter
@Setter
@NoArgsConstructor
public class SessionDTO extends AbstractEntityDTO {

    @Nullable
    private Date timestamp;

    @Nullable
    private String signature;

    @Nullable
    private String userId;

}
