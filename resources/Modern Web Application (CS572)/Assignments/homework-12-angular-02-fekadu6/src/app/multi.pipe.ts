import { Pipe, PipeTransform } from "@angular/core";

@Pipe({
  name: "multi"
})
export class MultiPipe implements PipeTransform {
  transform(value: HTMLDivElement, ...args: number[]): string {
    let result: string = "";
    let total = args[0];
    while (total-- !== 0) {
      result = `${result} ${value.innerHTML} |`;
    }
    return result;
  }
}
