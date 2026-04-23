import { Component, signal } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-footer',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './footer.html',
  styleUrl: './footer.css'
})
export class Footer {
  isMenuOpen = signal(false); 

  toggleMenu() {
    this.isMenuOpen.set(!this.isMenuOpen()); 
  }
}