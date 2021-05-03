import { Component, OnInit } from "@angular/core";

@Component({
  selector: "app-smart",
  template: `
    <div>
      <p>Countries of students attending MWA class:</p>
      <ul *ngFor="let country of countries">
        <app-dumb [country]="country"></app-dumb>
      </ul>
    </div>
    <p>Custom directive isVisible:</p>
    <div [isVisible]="true">Set isVisible to false to hide me :)</div>

    <p>Custom directive makeMeBigger:</p>
    <div makeMeBigger [ngStyle]="{ fontSize: '14px' }">
      Double-click on me to make me bigger :)
    </div>

    <p>Custom pipe (multi) applied on:</p>
    <div #custPipe>Hello Angular</div>
    Displaying :
    <em>{{ custPipe | multi: 3 }}</em>
  `,
  styles: [
    "p {color:#b00200; font-size:24px; font-family:arial; background:#f4f4f4; padding:15px}"
  ]
})
export class SmartComponent implements OnInit {
  countries = [
    { name: "Ethiopia", flag: "et" },
    { name: "Vietnam", flag: "vn" },
    { name: "Turkey", flag: "tr" },
    { name: "Mongolia", flag: "mn" },
    { name: "Uganda", flag: "ug" },
    { name: "Nigeria", flag: "ng" },
    { name: "Rwanda", flag: "rw" },
    { name: "Morocco", flag: "ma" },
    { name: "Egypt", flag: "eg" },
    { name: "Uzbekistan", flag: "uz" },
    { name: "Kazakhstan", flag: "kz" },
    { name: "Bangladesh", flag: "bd" },
    { name: "China", flag: "cn" }
  ];

  constructor() {}

  ngOnInit() {}
}
