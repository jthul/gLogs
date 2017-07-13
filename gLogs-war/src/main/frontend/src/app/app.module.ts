import { BrowserModule, Title  } from '@angular/platform-browser';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { NgModule } from '@angular/core';

import { ListLogsComponent } from './list-logs/list-logs.component';
import { DisplayLogContentComponent } from './display-log-content/display-log-content.component';
import { HeaderComponent } from './header/header.component';
import { RootComponent } from './root/root.component';
import { LoginComponent } from './login/login.component';
import { DesignerComponent } from './designer/designer.component';
import { Error404Component } from './error404/error404.component';

const appRoutes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'designer', component: DesignerComponent },
  { path: '', redirectTo: 'login',pathMatch: 'full'},
  { path: '**', component: Error404Component }
];

@NgModule({
  bootstrap: [RootComponent],
  declarations: [
    ListLogsComponent,
    DisplayLogContentComponent,
    HeaderComponent,
    RootComponent,
    LoginComponent,
    DesignerComponent,
    Error404Component
  ],
  imports: [
    BrowserModule,
          RouterModule.forRoot(
            appRoutes,
            { enableTracing: true } // <-- debugging purposes only
          ),
          // other imports here
        FormsModule,
        ReactiveFormsModule
  ],
  providers: [Title],

})
export class AppModule { }
