import {
  Directive,
  ElementRef,
  Renderer2,
  OnInit,
  HostListener
} from "@angular/core";

@Directive({
  selector: "[makeMeBigger]"
})
export class MakeMeBiggerDirective implements OnInit {
  @HostListener("dblclick") doubleClicked(eventData: Event) {
    const newSize =
      parseInt(this.element.nativeElement.style.fontSize, 10) + 2 + "px";
    this.renderer.setStyle(this.element.nativeElement, "font-size", newSize);
  }

  ngOnInit(): void {}
  constructor(private element: ElementRef, private renderer: Renderer2) {}
}
