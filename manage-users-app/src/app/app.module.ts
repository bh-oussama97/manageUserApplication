import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import { UserComponent } from './user/user.component';
import { ShowUsersComponent } from './user/show-users/show-users.component';
import { AppEditUserComponent } from './user/app-edit-user/app-edit-user.component';

@NgModule({
  declarations: [
    AppComponent,
    UserComponent,
    ShowUsersComponent,
    AppEditUserComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
