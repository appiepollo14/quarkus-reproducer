package nl.appiepollo14;

import jakarta.enterprise.context.ApplicationScoped;
import org.apache.sshd.common.config.keys.FilePasswordProvider;
import org.apache.sshd.common.config.keys.loader.KeyPairResourceLoader;
import org.apache.sshd.common.keyprovider.KeyIdentityProvider;
import org.apache.sshd.common.session.SessionContext;
import org.apache.sshd.common.util.security.SecurityUtils;
import org.eclipse.jgit.transport.sshd.SshdSessionFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.util.Iterator;

// Class inspired by spring cloud
@ApplicationScoped
public class SshSessionFactory extends SshdSessionFactory {

    @Override
    protected File getSshConfig(File sshDir) {
        return null;
    }

    @Override
    protected Iterable<KeyPair> getDefaultKeys(File sshDir) {
        return new SingleKeyIdentityProvider();
    }

    private final static class SingleKeyIdentityProvider implements KeyIdentityProvider, Iterable<KeyPair> {

        @Override
        public Iterator<KeyPair> iterator() {
            return null;
        }

        @Override
        public Iterable<KeyPair> loadKeys(SessionContext sessionContext) throws IOException, GeneralSecurityException {

            KeyPairResourceLoader loader = SecurityUtils.getKeyPairResourceParser();
            return loader.loadKeyPairs(sessionContext, Paths.get("/keylocation"), FilePasswordProvider.EMPTY);
        }
    }
}
