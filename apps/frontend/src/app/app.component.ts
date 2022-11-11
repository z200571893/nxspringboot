import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'nx-root',
  standalone: true,
  imports: [CommonModule, RouterModule],
  template: `
    <div class="flex h-screen">
      <router-outlet></router-outlet>
    </div>
  `,
})
export class AppComponent {}
