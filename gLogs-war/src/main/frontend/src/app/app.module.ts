import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { ListLogsComponent } from './list-logs/list-logs.component';
import { DisplayLogContentComponent } from './display-log-content/display-log-content.component';
import { HeaderComponent } from './header/header.component';

@NgModule({
  declarations: [
    ListLogsComponent,
    DisplayLogContentComponent,
    HeaderComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [ListLogsComponent,HeaderComponent,DisplayLogContentComponent]
})
export class AppModule { }
