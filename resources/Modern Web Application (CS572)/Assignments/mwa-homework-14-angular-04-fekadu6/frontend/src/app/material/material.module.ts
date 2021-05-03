import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";
import {
  MatToolbarModule,
  MatInputModule,
  MatFormFieldModule,
  MatCardModule
} from "@angular/material";
import { MatMenuModule } from "@angular/material/menu";
import { MatButtonModule } from "@angular/material/button";
import { MatChipsModule } from "@angular/material/chips";

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    MatToolbarModule,
    MatInputModule,
    MatButtonModule,
    MatMenuModule,
    MatFormFieldModule,
    MatCardModule,
    MatChipsModule
  ],
  exports: [
    MatToolbarModule,
    MatInputModule,
    MatButtonModule,
    MatMenuModule,
    MatFormFieldModule,
    MatCardModule,
    MatChipsModule
  ]
})
export class MaterialModule {}
