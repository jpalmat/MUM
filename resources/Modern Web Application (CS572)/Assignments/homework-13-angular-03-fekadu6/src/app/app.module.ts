import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";
import { HttpClientModule } from "@angular/common/http";
import { AppComponent } from "./app.component";
import { RouterModule } from "@angular/router";

import { UsersModule } from "./users/users.module";
import { PageNotFoundComponent } from "./page-not-found/page-not-found.component";

@NgModule({
  declarations: [AppComponent, PageNotFoundComponent],
  imports: [
    BrowserModule,
    UsersModule,
    HttpClientModule,
    RouterModule.forRoot([
      { path: "users", loadChildren: () => import("./users/users.module") },
      { path: "", redirectTo: "users", pathMatch: "full" },
      { path: "**", component: PageNotFoundComponent }
    ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {}
