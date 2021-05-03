import { Component } from "@angular/core";

@Component({
  selector: "app-root",
  template: `
    <div>
      <ul>
        <app-smart></app-smart>
      </ul>
    </div>
  `,
  styleUrls: ["./app.component.css"]
})
export class AppComponent {
  title = "homework12";
}
