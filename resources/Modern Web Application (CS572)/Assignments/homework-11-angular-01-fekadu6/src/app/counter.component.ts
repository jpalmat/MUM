import { Component, Input, Output, EventEmitter } from "@angular/core";

@Component({
  selector: "app-counter",
  template: `
    <div>
      <button (click)="decrement()" class="dec">-</button>
      <span>{{ counter || counterValue }}</span>
      <button (click)="increment()" class="inc">+</button>
    </div>
  `,
  styleUrls: ["./counter.component.css"]
})
export class CounterComponent {
  counterValue = 0;
  @Input() counter;
  @Output() counterChange = new EventEmitter();

  decrement() {
    this.counterValue--;
    this.counterChange.emit(this.counterValue);
  }
  increment() {
    this.counterValue++;
    this.counterChange.emit(this.counterValue);
  }
}
