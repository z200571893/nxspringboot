import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component, inject } from '@angular/core';

@Component({
  selector: 'nx-dashboard',
  standalone: true,
  imports: [CommonModule],
  template: ` <p class="mt-2 text-blue-600">{{ name }}</p> `,
  styles: [],
})
export class DashboardComponent {
  http = inject(HttpClient);

  name!: string;

  constructor() {
    this.http
      .get('http://localhost:8080/hello', { responseType: 'text' })
      .subscribe((res) => {
        console.log('res :>> ', res);
        this.name = res;
      });
  }
  // ngOnInit(): void {}
}
