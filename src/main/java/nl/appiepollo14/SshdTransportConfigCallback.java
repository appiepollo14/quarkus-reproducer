package nl.appiepollo14;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.jgit.api.TransportConfigCallback;
import org.eclipse.jgit.transport.SshTransport;
import org.eclipse.jgit.transport.Transport;

@ApplicationScoped
public class SshdTransportConfigCallback implements TransportConfigCallback {

    @Inject
    SshSessionFactory sshSessionFactory;

    @Override
    public void configure(Transport transport) {
        if (transport instanceof SshTransport) {
            ((SshTransport) transport).setSshSessionFactory(sshSessionFactory);
        }
    }
}
