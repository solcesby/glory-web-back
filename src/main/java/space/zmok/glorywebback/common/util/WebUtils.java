package space.zmok.glorywebback.common.util;

import com.sun.istack.NotNull;
import lombok.experimental.UtilityClass;
import org.springframework.util.Assert;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@UtilityClass
public class WebUtils {

    public static @NotNull URI getByIdLocation(@NotNull Object id) {
        return UriComponentsBuilder.fromPath(getCurrentRequestPath())
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();
    }

    public static @NotNull String getCurrentRequestPath() throws IllegalStateException {
        var attrs = RequestContextHolder.getRequestAttributes();
        Assert.state(attrs instanceof ServletRequestAttributes, "No current ServletRequestAttributes");
        return ((ServletRequestAttributes) attrs).getRequest().getRequestURI();
    }
}

