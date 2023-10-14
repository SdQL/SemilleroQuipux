package launch;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerResponse;
import com.sun.jersey.spi.container.ContainerResponseFilter;

@Provider
public class CORSFilter implements ContainerResponseFilter {

    public ContainerResponse filter(ContainerRequest request,ContainerResponse response) {

        response.getHttpHeaders().add("Access-Control-Allow-Origin", "*");
        response.getHttpHeaders().add("Access-Control-Allow-Headers","origin, content-type, accept, authorization");
        response.getHttpHeaders().add("Access-Control-Max-Age", "602");
        response.getHttpHeaders().add("Access-Control-Allow-Credentials", "true");
        response.getHttpHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
        response.getHttpHeaders().add("X-Content-Type-Options", "nosniff");
		response.getHttpHeaders().add("x-permitted-cross-domain-policies", "none");
		
       MediaType type = response.getMediaType();
        if (type != null) {
            String contentType = type.toString();
            if (!contentType.contains("charset")) {
                contentType = contentType + ";charset=utf-8";
                response.getHttpHeaders().putSingle("Content-Type", contentType);
            }
        }
        
        return response;
    }
}
