package eu.artofcoding.odisee.web;

import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named("state")
public class State {

    private String idFromRequest;

    public String getIdFromRequest() {
        return idFromRequest;
    }

    public void setIdFromRequest(String idFromRequest) {
        this.idFromRequest = idFromRequest;
    }

    /**
     * Process pre-render-view event.
     * E.g. use it to provide a request to managed bean:
     * <p>
     * &lt;f:metadata><br/>
     * &lt;f:viewParam name="id" value="#{bean.idFromRequest}"/><br/>
     * &lt;f:event type="preRenderView" listener="#{bean.preRenderView}"/><br/>
     * &lt;/f:metadata>
     * </p>
     */
    public void preRenderView() throws IllegalAccessException, InstantiationException {
    }

    public String getViewId() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        String viewId = facesContext.getViewRoot().getViewId();
        if (null != viewId) {
            String[] split = viewId.split("\\.");
            String n = split[0].substring(1).replace('/', '-');
            return n;
        } else {
            return "unknown";
        }
    }

}
