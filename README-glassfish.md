# odisee-web

## GlassFish

Version: Open Source Edition 3.1.2.2

### Setup Domain

    --portbase
          o Administration port
            portbase + 48
          o HTTP listener port
            portbase + 80
          o HTTPS listener port
            portbase + 81
          o JMS port
            portbase + 76
          o IIOP listener port
            portbase + 37
          o Secure IIOP listener port
            portbase + 38
          o Secure IIOP with mutual authentication port
            portbase + 39
          o JMX port
            portbase + 86
          o JPDA debugger port:
            portbase + 9
          o Felix shell service port for OSGi module management:
            portbase + 66
    
    --domainproperties
    
    --nopassword
    --savemasterpassword
    --usemasterpassword

#### Example

    asadmin create-domain --domaindir /usr/home/rbe/glassfish --portbase 9100 --user odisee --savelogin=true odisee-prod
    cd /usr/local/glassfish3122/glassfish/domains
    ln -s /usr/home/rbe/glassfish/odisee-prod
    asadmin start-domain odisee-prod
    asadmin --port 9148 --user odisee enable-secure-admin
    asadmin --port 9148 --user odisee create-file-user --authrealmname admin-realm --groups asadmin odisee-admin
    asadmin --port 9148 --user odisee create-password-alias odisee-admin-pwdalias
    asadmin --port 9148 --user odisee enable-secure-admin-internal-user --passwordalias odisee-admin-pwdalias odisee-admin
    asadmin stop-domain odisee-prod
    asadmin start-domain odisee-prod

### Instance Configuration

    asadmin --port 9048 --user odisee add-resources glassfish-resources.xml
