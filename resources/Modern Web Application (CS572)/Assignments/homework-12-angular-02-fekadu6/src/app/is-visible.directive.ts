import { Directive, ElementRef, Renderer2, Input, OnInit } from "@angular/core";

@Directive({
  selector: "[isVisible]"
})
export class IsVisibleDirective implements OnInit {
  @Input() isVisible;

  constructor(public element: ElementRef, public renderer: Renderer2) {}

  ngOnInit() {
    this.renderer.setStyle(
      this.element.nativeElement,
      "display",
      this.isVisible ? "block" : "none"
    );
  }
}
