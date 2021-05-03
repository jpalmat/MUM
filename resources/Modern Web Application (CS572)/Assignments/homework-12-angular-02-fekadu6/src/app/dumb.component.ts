import { Component, OnInit, Input } from "@angular/core";

@Component({
  selector: "app-dumb",
  template: `
    <li>
      <span
        class="flag-icon flag-icon-{{ country.flag }} flag-icon-squared"
      ></span>
      <span class="cname">{{ country.name }} </span>
    </li>
  `,
  styles: [
    "span.cname{font-size:24px; padding:15px},li{list-style-type:'none'}"
  ]
})
export class DumbComponent implements OnInit {
  @Input() country;
  constructor() {}

  ngOnInit() {}
}
