import { KeycloakOptions, KeycloakService } from "keycloak-angular";
import { environment } from 'src/ennviroment.ts/enviroment';


export function initializer(keycloak: KeycloakService): () => Promise<boolean> {

    const options: KeycloakOptions = {
        config: environment.keycloak,
        loadUserProfileAtStartUp: true,
        initOptions: {
            onLoad : 'login-required',
            flow: 'standard',
            checkLoginIframe: true
        },
        bearerExcludedUrls : []
    };

    return () => keycloak.init(options);
}