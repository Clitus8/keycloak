import { KeycloakAngularModule, KeycloakService } from 'keycloak-angular';
import { APP_INITIALIZER, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AccessDeniedComponent } from './access-denied/access-denied.component';
import { AdminComponent } from './admin/admin.component';
import { ManagerComponent } from './manager/manager.component';
import { initializer } from './service/keycloak-init';
import { AuthGuard } from './service/auth.guard';
import { AuthService } from './service/auth.service';
import { CommonService } from './service/common.service';

@NgModule({
  declarations: [
    AppComponent,
    AccessDeniedComponent,
    AdminComponent,
    ManagerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    KeycloakAngularModule,
    HttpClientModule
  ],
  providers: [
    {
      provide: APP_INITIALIZER,
      useFactory: initializer,
      deps: [KeycloakService],
      multi: true,
    },
    AuthGuard,
    AuthService,
    CommonService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
