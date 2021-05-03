import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";
import { UsersComponent } from "./users.component";
import { UserDetailComponent } from "./user-detail.component";
import { Routes, RouterModule } from "@angular/router";
import { BrowserModule } from "@angular/platform-browser";
import { UserdetailsGuardGuard } from "../userdetails-guard.guard";
import { PageNotFoundComponent } from "../page-not-found/page-not-found.component";
const routes: Routes = [
  {
    path: "users/userdetails/:uuid",
    canActivate: [UserdetailsGuardGuard],
    component: UserDetailComponent
  },
  {
    path: "users",
    component: UsersComponent
  },
  {
    path: "",
    redirectTo: "users",
    pathMatch: "full"
  },
  {
    path: "**",
    component: PageNotFoundComponent
  }
];

@NgModule({
  declarations: [UsersComponent, UserDetailComponent],
  providers: [UserdetailsGuardGuard],
  imports: [CommonModule, BrowserModule, RouterModule.forChild(routes)]
})
export class UsersModule {}
