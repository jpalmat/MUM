import { Component } from "@angular/core";
import { ActivatedRoute } from "@angular/router";
import { OnlineServiceService } from "../online-service.service";

@Component({
  selector: "appUserDetails",
  template: `
    <div><P class="header">Users details</P></div>
    <div class="main">
      <p>
        <strong>Full name:</strong> {{ user?.name?.title | titlecase }}
        {{ user?.name?.first | titlecase }}
        {{ user?.name?.last | titlecase }}
      </p>
      <p><strong>Gender:</strong> {{ user?.gender }}</p>
      <p><strong>Id: </strong>{{ user?.login?.uuid }}</p>
      <p><strong>Email:</strong> {{ user?.email }}</p>
      <p><strong>User name:</strong> {{ user?.login?.username }}</p>
    </div>
  `,
  styles: [
    "*{font-family:arial} p.header{color:#a60000; font-weight:bolder; font-size:24px; background:#eee; padding:15px; font-family: arial} .main{padding:10px}"
  ]
})
export class UserDetailComponent {
  uuid;
  user;
  constructor(
    private route: ActivatedRoute,
    private onlineService: OnlineServiceService
  ) {
    route.params.subscribe(params => {
      this.uuid = params["uuid"];
    });

    this.user = this.onlineService.getUserDetails(this.uuid);
  }
}
