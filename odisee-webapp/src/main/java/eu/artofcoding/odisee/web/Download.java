package eu.artofcoding.odisee.web;

import eu.artofcoding.beetlejuice.web.jsf.FacesHelper;

import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Named("download")
public class Download {

    private final String odiseeVersion = "2.2.3.18";

    private static final Map<String, String> DROPBOX = new HashMap<String, String>() {{
        put("Odisee_2_2_3_18_FreeBSD.tar.gz", "https://www.dropbox.com/s/3j191b6hl66crcv/Odisee_2_2_3_18_FreeBSD.tar.gz");
        put("Odisee_2_2_3_18_FreeBSD_amd64.tar.gz", "https://www.dropbox.com/s/wavln7wzwxjs4eu/Odisee_2_2_3_18_FreeBSD_amd64.tar.gz");
        put("Odisee_2_2_3_18_FreeBSD_i386.tar.gz", "https://www.dropbox.com/s/0l5axobnjl0a6ys/Odisee_2_2_3_18_FreeBSD_i386.tar.gz");
        put("Odisee_2_2_3_18_Linux_x86.tar.gz", "https://www.dropbox.com/s/lhc6j0odlek0btf/Odisee_2_2_3_18_Linux_x86.tar.gz");
        put("Odisee_2_2_3_18_Linux_x86_64.deb", "https://www.dropbox.com/s/wqyi7z86ay8lozx/Odisee_2_2_3_18_Linux_x86_64.deb");
        put("Odisee_2_2_3_18_Linux_x86_64.rpm", "https://www.dropbox.com/s/euxfo0pw3vun0i3/Odisee_2_2_3_18_Linux_x86_64.rpm");
        put("Odisee_2_2_3_18_Linux_x86_64.tar.gz", "https://www.dropbox.com/s/scl1ekiwakgxe7h/Odisee_2_2_3_18_Linux_x86_64.tar.gz");
        put("Odisee_2_2_3_18_OSX_x86_64.dmg", "https://www.dropbox.com/s/zm5g81o32c8re8g/Odisee_2_2_3_18_OSX_x86_64.dmg");
        put("Odisee_2_2_3_18_OSX_x86_64.tar.gz", "https://www.dropbox.com/s/lq4876teb6lzutw/Odisee_2_2_3_18_OSX_x86_64.tar.gz");
        put("Odisee_2_2_3_18_Windows_x64.exe", "https://www.dropbox.com/s/iymozgguzcxu4v4/Odisee_2_2_3_18_Windows_x64.exe");
        put("Odisee_2_2_3_18_Windows_x64.zip", "https://www.dropbox.com/s/vq7ugf2un4agcro/Odisee_2_2_3_18_Windows_x64.zip");
        put("Odisee_2_2_3_18_Windows_x86.exe", "https://www.dropbox.com/s/2g3sw1bpl1md9n4/Odisee_2_2_3_18_Windows_x86.exe");
        put("Odisee_2_2_3_18_Windows_x86.zip", "https://www.dropbox.com/s/9ukgywz83k7n6s6/Odisee_2_2_3_18_Windows_x86.zip");
    }};

    public String getOdiseeVersion() {
        return odiseeVersion;
    }

    private void redirect(String n, String v) throws IOException {
        // $(uname -s)_$(uname -m)
        FacesHelper facesHelper = FacesHelper.getInstance(FacesContext.getCurrentInstance());
        String filename = String.format(n, v);
        String externalURL = DROPBOX.get(filename); //String.format("http://www.odisee.de/download/odisee-server/%s", filename);
        facesHelper.jsfRedirect(externalURL);
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
                String v = odiseeVersion.replaceAll("[.]", "_");
                switch (id) {
                    case "windows-64-installer":
                        redirect("Odisee_%s_Windows_x64.exe", v);
                        break;
                    case "windows-32-installer":
                        redirect("Odisee_%s_Windows_x86.exe", v);
                        break;
                    case "linux-64-deb":
                        redirect("Odisee_%s_Linux_x86_64.deb", v);
                        break;
                    case "linux-64-rpm":
                        redirect("Odisee_%s_Linux_x86_64.rpm", v);
                        break;
                    case "linux-32-tgz":
                        redirect("Odisee_%s_Linux_x86.tar.gz", v);
                        break;
                    case "linux-64-tgz":
                        redirect("Odisee_%s_Linux_x86_64.tar.gz", v);
                        break;
                    case "freebsd-64-tgz":
                        redirect("Odisee_%s_FreeBSD_amd64.tar.gz", v);
                        break;
                    case "freebsd-32-tgz":
                        redirect("Odisee_%s_FreeBSD_i386.tar.gz", v);
                        break;
                    case "osx-64-dmg":
                        redirect("Odisee_%s_OSX_x86_64.dmg", v);
                        break;
                    case "osx-64-tgz":
                        redirect("Odisee_%s_OSX_x86_64.tar.gz", v);
                        break;
                }
                break;
        }
        return null;
    }

}
