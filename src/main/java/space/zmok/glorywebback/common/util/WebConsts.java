package space.zmok.glorywebback.common.util;

import lombok.experimental.UtilityClass;
import org.springframework.http.HttpHeaders;

@UtilityClass
public class WebConsts {

    // HTTP Status Codes
    public static final String OK = "200";
    public static final String CREATED = "201";
    public static final String NO_CONTENT = "204";

    // HTTP Headers
    public static final String LOCATION = HttpHeaders.LOCATION;
    public static final String X_TOTAL_COUNT = "X-Total-Count";

}
