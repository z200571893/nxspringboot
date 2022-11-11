import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'nx-hello',
  standalone: true,
  imports: [CommonModule],
  template: ` <p>hello works!</p> `,
  styles: [],
})
export class HelloComponent implements OnInit {
  constructor() {
    //
  }

  ngOnInit(): void {
    console.log('ngOnInit :>> ');
  }
}
