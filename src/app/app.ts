import { Component, signal } from '@angular/core';
// Importaciones ajustadas a tu estructura de carpetas
import { HeaderComponent } from './components/header/header';
import { Home } from './components/home/home';
import { Services } from './components/services/services';
import { Contact } from './components/contact/contact';
import { Footer} from './components/footer/footer';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    HeaderComponent,
    Home,
    Services,
    Contact,
    Footer
],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('prh-webpage');
}