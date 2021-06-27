import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { RegisterComponent } from './register/register.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { HomeComponent } from './home/home.component';
import { Routes, RouterModule } from '@angular/router';
import { NotfoundComponent } from './notfound/notfound.component';
import { SampleWishComponent } from './sample-wish/sample-wish.component';
import { NewsComponent } from './news/news.component';
import { HomeAdminComponent } from './home-admin/home-admin.component';
import { PostsComponent } from './posts/posts.component';
import { UserOperationComponent } from './user-operation/user-operation.component';
import { AdvertiseComponent } from './advertise/advertise.component';

import { UserDetailsComponent } from './user-details/user-details.component';
import { FollowingComponent } from './following/following.component';

import { TableComponent } from './table/table.component';
import { FileUploadModule } from 'ng2-file-upload';
import { UserblockComponent } from './userblock/userblock.component';
import { ManageUserComponent } from './manage-user/manage-user.component';
import { RequestActivateComponent } from './request-activate/request-activate.component';

import { InfiniteScrollModule } from 'ngx-infinite-scroll';

const appRoutes: Routes = [
  { path: '', component: WelcomeComponent },
  {
    path: 'home',
    component: HomeComponent,
    children: [
      { path: 'userdetails', component: UserDetailsComponent },
      { path: 'following', component: FollowingComponent },
      { path: 'news', component: NewsComponent },
      { path: 'home-admin', component: HomeAdminComponent },
      { path: 'app-table', component: TableComponent },
      { path: 'manage-user', component: ManageUserComponent },
      { path: 'request-activate', component: RequestActivateComponent },
    ],
  },

  // { path: 'following', component: FollowingComponent },
  { path: 'user', component: UserDetailsComponent },
  //{ path: '**', component: NotfoundComponent },
];

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    RegisterComponent,
    WelcomeComponent,
    HomeComponent,
    NotfoundComponent,
    SampleWishComponent,
    NewsComponent,
    HomeAdminComponent,
    PostsComponent,
    UserOperationComponent,
    AdvertiseComponent,

    UserDetailsComponent,
    FollowingComponent,
    TableComponent,
    UserblockComponent,
    ManageUserComponent,
    RequestActivateComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes),
    FileUploadModule,
    InfiniteScrollModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
