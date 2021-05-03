import { Component } from "@angular/core";

@Component({
  selector: "app-root",
  template: `
    <div>
      <app-counter
        [counter]="ChildCounterValue"
        (counterChange)="showCounterValue($event)"
      ></app-counter>
      <hr />
      <h3>
        Component counter value = <strong>{{ ChildCounterValue }}</strong>
      </h3>
    </div>
  `,
  styleUrls: ["./app.component.css"]
})
export class AppComponent {
  title = "homework11";
  ChildCounterValue = 0;

  showCounterValue(counter) {
    this.ChildCounterValue = counter;
  }
}
