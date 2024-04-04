package nl.appiepollo14;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidRemoteException;
import org.eclipse.jgit.api.errors.TransportException;
import org.eclipse.jgit.transport.sshd.SshdSessionFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@ApplicationScoped
public class JgitService {

    @Inject
    SshdTransportConfigCallback transportConfig;

    public void checkout() throws IOException {
        File tmpDir = Files.createTempDirectory("tmpgit").toFile();
        try (Git git = Git.cloneRepository().setTransportConfigCallback(transportConfig).setDirectory(tmpDir).setURI("git@github.com:quarkiverse/quarkus-jgit.git").call()) {
            System.out.println(tmpDir.toString());
        } catch (GitAPIException e) {
            throw new RuntimeException(e);
        }
    }


}
