package eu.artofcoding.odisee.web;

import eu.artofcoding.beetlejuice.web.jsf.FacesHelper;

import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.IOException;

@Named("download")
public class Download {

    private static final String ODISEE_VERSION = "2_2_3";

    public String start(String category, String id) throws IOException {
        FacesHelper facesHelper = FacesHelper.getInstance(FacesContext.getCurrentInstance());
        switch (category) {
            case "odisee-client":
                switch (id) {
                    case "client-vbnet":
                        facesHelper.jsfRedirect("http://www.odisee.de/download/odisee-client/windows/vbnet/setup.exe");
                        break;
                }
                break;
            case "odisee-server":
                switch (id) {
                    case "windows-x64-installer":
                        facesHelper.jsfRedirect(String.format("http://www.odisee.de/download/odisee-server/Odisee_%s_Windows_x64.exe", ODISEE_VERSION));
                        break;
                    case "windows-x86-installer":
                        facesHelper.jsfRedirect(String.format("http://www.odisee.de/download/odisee-server/Odisee_%s_Windows_x86.exe", ODISEE_VERSION));
                        break;
                    case "linux-tgz":
                        facesHelper.jsfRedirect(String.format("http://www.odisee.de/download/odisee-server/Odisee_%s_Linux.tar.gz", ODISEE_VERSION));
                        break;
                    case "linux-deb":
                        facesHelper.jsfRedirect(String.format("http://www.odisee.de/download/odisee-server/Odisee_%s_Linux.deb", ODISEE_VERSION));
                        break;
                    case "linux-rpm":
                        facesHelper.jsfRedirect(String.format("http://www.odisee.de/download/odisee-server/Odisee_%s_Linux.rpm", ODISEE_VERSION));
                        break;
                    case "freebsd-tgz":
                        facesHelper.jsfRedirect(String.format("http://www.odisee.de/download/odisee-server/Odisee_%s_FreeBSD.tar.gz", ODISEE_VERSION));
                        break;
                    case "osx-tgz":
                        facesHelper.jsfRedirect(String.format("http://www.odisee.de/download/odisee-server/Odisee_%s_OSX.tar.gz", ODISEE_VERSION));
                        break;
                    case "osx-dmg":
                        facesHelper.jsfRedirect(String.format("http://www.odisee.de/download/odisee-server/Odisee_%s_OSX.dmg", ODISEE_VERSION));
                        break;
                }
                break;
        }
        /*
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        externalContext.setResponseHeader("Content-Type", photo.getContentType());
        externalContext.setResponseHeader("Content-Length", String.valueOf(photo.getContent().length));
        //externalContext.setResponseHeader("Content-Disposition", "attachment; filename=\"" + photo.getFileName() + "\"");
        try {
            externalContext.getResponseOutputStream().write(photo.getContent());
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        facesContext.responseComplete();
        */
        return null;
    }

}
