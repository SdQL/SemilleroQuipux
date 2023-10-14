import { Routes } from "@angular/router";
import { MateriasComponent } from "./components/materias/materias.component";
import { AdminMateriasComponent } from "./components/admin-materias/admin-materias.component";


export const APP_ROUTES: Routes = [
    {path: 'materias', component: MateriasComponent},
    {path: 'adminMaterias', component: AdminMateriasComponent},
    
]