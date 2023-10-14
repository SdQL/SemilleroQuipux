import { Component, OnInit } from '@angular/core';
import { EstudiantesService } from 'src/app/_services/estudiantes.service';
import { DatePipe } from '@angular/common';
import { Estudiante } from 'src/app/_models/estudiantes';
import { first } from 'rxjs';
import { MateriasService } from 'src/app/_services/materias.service';
import { Materia } from 'src/app/_models/materias';

@Component({
  selector: 'app-admin-materias',
  templateUrl: './admin-materias.component.html',
  styleUrls: ['./admin-materias.component.css'],
  providers: [
    DatePipe,
    EstudiantesService,
    MateriasService
  ]
})
export class AdminMateriasComponent implements OnInit {
  listaEstudiantes: Estudiante[] = [];
  listaMaterias: Materia[] = []
  public page: number = 1;


  constructor(private estudiantesService: EstudiantesService, private materiaService: MateriasService) { }

  ngOnInit(): void {
    this.estudiantesService
    .getEstudiantes()
    .pipe(first())
    .subscribe((data) => {
      this.listaEstudiantes = data;
    })


    this.materiaService
    .getMaterias()
    .pipe(first())
    .subscribe((data) => {
      this.listaMaterias = data;
    })
  }


}