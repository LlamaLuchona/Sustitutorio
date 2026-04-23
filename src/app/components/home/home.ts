import { Component, OnInit, ElementRef, ViewChild, Inject, PLATFORM_ID } from '@angular/core';
import { isPlatformBrowser } from '@angular/common';
import Typed from 'typed.js';

@Component({
  selector: 'app-home',
  standalone: true,
  templateUrl: './home.html',
  styleUrl: './home.css'
})
export class Home implements OnInit {
  @ViewChild('typedElement', { static: true }) typedElement!: ElementRef;
  constructor(@Inject(PLATFORM_ID) private platformId: Object) {}
  ngOnInit() {
    if (isPlatformBrowser(this.platformId)) { 
      const options = {
        strings: ['Seguridad', 'Experiencia', 'Compromiso', 'Confianza','RH Soluciones'],
        typeSpeed: 100,
        backSpeed: 50,
        loop: true,
        showCursor: true,
        cursorChar: '|'
      };
      new Typed(this.typedElement.nativeElement, options);
    } 
  }
}