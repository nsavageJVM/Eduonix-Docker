package eduonix.dockerphaseone;

import eduonix.dockerphaseone.unittwo.LabSolutionServlet;
import eduonix.dockerphaseone.unittwo.ShutdownHook;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import java.io.File;

/**
 * Server for the Unit 2 Lab solution
 */
public class LabSolutionServer {

    public static void main(String[] args) throws LifecycleException {

        String webappDirLocation = "src/main/webapp/";
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        System.out.println("Go to http://localhost:8080/ ");

        File base = new File(System.getProperty("java.io.tmpdir"));
        Context ctx = tomcat.addContext("", base.getAbsolutePath());
        Tomcat.addServlet(ctx, "lab", new LabSolutionServlet());
        ctx.addServletMapping("/*", "lab");
        // Add the 'killer switch' servlet (used to shut down the server) to the context
        Tomcat.addServlet(ctx, "ShutdownHook", new ShutdownHook());
        ctx.addServletMapping("/shutdown", "ShutdownHook");
        
        
        tomcat.start();
        tomcat.getServer().await();
    }
    }
    
