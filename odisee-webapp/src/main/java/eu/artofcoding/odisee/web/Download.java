package eu.artofcoding.odisee.web;

import eu.artofcoding.beetlejuice.web.jsf.FacesHelper;

import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.IOException;

@Named("download")
public class Download {

    private final String odiseeVersion = "2_2_3_18";

    public String getOdiseeVersion() {
        return odiseeVersion;
    }

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
                // $(uname -s)_$(uname -m)
                // facesHelper.jsfRedirect(String.format("http://www.odisee.de/download/odisee-server/Odisee_%s_%s_%s.exe", odiseeVersion, platform, bits));
                switch (id) {
                    case "windows-64-installer":
                        facesHelper.jsfRedirect(String.format("http://www.odisee.de/download/odisee-server/Odisee_%s_Windows_x64.exe", odiseeVersion));
                        break;
                    case "windows-32-installer":
                        facesHelper.jsfRedirect(String.format("http://www.odisee.de/download/odisee-server/Odisee_%s_Windows_x86.exe", odiseeVersion));
                        break;
                    case "linux-64-deb":
                        facesHelper.jsfRedirect(String.format("http://www.odisee.de/download/odisee-server/Odisee_%s_Linux_x86_64.deb", odiseeVersion));
                        break;
                    case "linux-64-rpm":
                        facesHelper.jsfRedirect(String.format("http://www.odisee.de/download/odisee-server/Odisee_%s_Linux_x86_64.rpm", odiseeVersion));
                        break;
                    case "linux-32-tgz":
                        facesHelper.jsfRedirect(String.format("http://www.odisee.de/download/odisee-server/Odisee_%s_Linux_x86.tar.gz", odiseeVersion));
                        break;
                    case "linux-64-tgz":
                        facesHelper.jsfRedirect(String.format("http://www.odisee.de/download/odisee-server/Odisee_%s_Linux_x86_64.tar.gz", odiseeVersion));
                        break;
                    case "freebsd-64-tgz":
                        facesHelper.jsfRedirect(String.format("http://www.odisee.de/download/odisee-server/Odisee_%s_FreeBSD_amd64.tar.gz", odiseeVersion));
                        break;
                    case "freebsd-32-tgz":
                        facesHelper.jsfRedirect(String.format("http://www.odisee.de/download/odisee-server/Odisee_%s_FreeBSD_i386.tar.gz", odiseeVersion));
                        break;
                    case "osx-64-dmg":
                        facesHelper.jsfRedirect(String.format("http://www.odisee.de/download/odisee-server/Odisee_%s_OSX_x86_64.dmg", odiseeVersion));
                        break;
                    case "osx-64-tgz":
                        facesHelper.jsfRedirect(String.format("http://www.odisee.de/download/odisee-server/Odisee_%s_OSX_x86_64.tar.gz", odiseeVersion));
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
