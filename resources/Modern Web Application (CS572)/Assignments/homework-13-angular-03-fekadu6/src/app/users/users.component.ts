import { Component, AfterViewInit, AfterContentChecked } from "@angular/core";
import { OnlineServiceService } from "../online-service.service";

@Component({
  selector: "appUsers",
  template: `
    <div *ngIf="(data | async)?.length; else loading">
      <div *ngFor="let user of data | async" class="users">
        <a [routerLink]="['userdetails', user.login.uuid]" class="detail"
          >Detail</a
        >
        -
        <span
          >{{ user.name.first | titlecase }}
          {{ user.name.last | titlecase }}</span
        >
      </div>
    </div>

    <ng-template #loading>
      <div>Loading...</div>
    </ng-template>
  `,
  styles: [
    ".users{padding:10px; font-family:arial; font-size:20px} a.detail{color:#a60000} a.detail:hover{text-decoration:none}"
  ]
})
export class UsersComponent implements AfterContentChecked {
  data;
  constructor(private onlineService: OnlineServiceService) {}

  ngAfterContentChecked(): void {
    this.data = this.onlineService.getCachedData();
  }
}
