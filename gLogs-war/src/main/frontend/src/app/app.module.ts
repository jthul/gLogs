import { BrowserModule, Title  } from '@angular/platform-browser';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { NgModule } from '@angular/core';

import { RootComponent } from './root/root.component';
import { LoginComponent } from './login/login.component';
import { DesignerComponent } from './designer/designer.component';
import { Error404Component } from './error404/error404.component';
import { AuthguardComponent } from './shared/authguard/authguard.component';

import {AuthenticateService} from './login/_service/authenticate.service';
import {UserService} from './shared/_service/user.service';
import { HeaderComponent } from './designer/header/header.component';

const appRoutes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'designer', component: DesignerComponent, canActivate:[AuthguardComponent] },
  { path: '', redirectTo: 'login',pathMatch: 'full'},
  { path: '**', component: Error404Component }
];

@NgModule({
  bootstrap: [RootComponent],
  declarations: [
    RootComponent,
    LoginComponent,
    DesignerComponent,
    Error404Component,
    AuthguardComponent,
    HeaderComponent
  ],
  imports: [
    BrowserModule,
          RouterModule.forRoot(
            appRoutes,
            { enableTracing: true } // <-- debugging purposes only
          ),
          // other imports here
        FormsModule,
        ReactiveFormsModule,
        HttpModule
  ],
  providers: [Title,AuthguardComponent,AuthenticateService,UserService],

})
export class AppModule { }
