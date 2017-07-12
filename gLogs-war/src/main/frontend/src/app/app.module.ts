import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { ListLogsComponent } from './list-logs/list-logs.component';
import { DisplayLogContentComponent } from './display-log-content/display-log-content.component';
import { HeaderComponent } from './header/header.component';
import { LoginComponent } from './login/login.component';

@NgModule({
  declarations: [
    ListLogsComponent,
    DisplayLogContentComponent,
    HeaderComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [ListLogsComponent,HeaderComponent,DisplayLogContentComponent,LoginComponent]
})
export class AppModule { }
