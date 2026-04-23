import { Component, signal } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './header.html',
  styleUrl: './header.css'
})
export class HeaderComponent {
  isMenuOpen = signal(false);
  toggleMenu(): void {
    this.isMenuOpen.set(!this.isMenuOpen());
  }
}