import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component, inject } from '@angular/core';

@Component({
  selector: 'nx-dashboard',
  standalone: true,
  imports: [CommonModule],
  template: `
    <div class="flex flex-col w-screen h-screen">
      <p class="mt-2 text-blue-600">{{ name }}</p>
      <div class="bg-blue-200">main</div>
      <div class="flex h-12 bg-blue-50 items-center justify-between">
        <div>logo</div>
        <div>logo2</div>
      </div>
    </div>
  `,
  styles: [],
})
export class DashboardComponent {
  http = inject(HttpClient);

  name!: string;

  constructor() {
    this.http
      .get('http://localhost:8080/ch01', { responseType: 'text' })
      .subscribe((res) => {
        console.log('res :>> ', res);
        this.name = res;
      });
  }
}
