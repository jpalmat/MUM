import { Component, OnInit } from "@angular/core";
import { OnlineServiceService } from "./online-service.service";

@Component({
  selector: "app-root",
  template: `
    <br /><br />
    <a class="mainLink" [routerLink]="['users']">Users</a>
    <!--a [routerLink]="['userdetails']">User Details</!--a>-->
    <br /><br />
    <router-outlet></router-outlet>
  `,
  styleUrls: ["./app.component.css"]
})
export class AppComponent implements OnInit {
  title = "homework13";

  constructor(private onlineService: OnlineServiceService) {}

  ngOnInit() {
    this.onlineService.getOnlineData();
  }
}
