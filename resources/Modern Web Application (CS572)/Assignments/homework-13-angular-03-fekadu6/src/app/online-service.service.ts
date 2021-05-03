import { Injectable, OnInit } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { from } from "rxjs";
import { filter } from "rxjs/operators";

@Injectable({
  providedIn: "root"
})
export class OnlineServiceService {
  localStorage = [];

  constructor(private http: HttpClient) {}

  getOnlineData() {
    this.http.get("https://randomuser.me/api/?results=10").subscribe(data => {
      this.localStorage.push(data["results"]);
    });
  }

  getCachedData() {
    return from(this.localStorage);
  }

  getUserDetails(uuid: string) {
    let users;
    this.getCachedData().subscribe(u => (users = u));

    return users.filter(element => element.login.uuid === uuid)[0];
  }
}
