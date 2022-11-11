import { Routes } from '@angular/router';

export const APP_ROUTES: Routes = [
  {
    path: '',
    redirectTo: 'dashboard',
    pathMatch: 'full',
  },
  {
    path: 'dashboard',
    loadComponent: () =>
      import('./views/dashboard.component').then((c) => c.DashboardComponent),
  },
  // {
  //   path: 'search',
  //   loadComponent: () => import('./views/search').then((c) => c.Search),
  // },
  // {
  //   path: 'customer',
  //   loadComponent: () => import('./views/customer').then((c) => c.Customer),
  // },
];
