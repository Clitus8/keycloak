import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/ennviroment.ts/enviroment';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class CommonService {

  constructor(private http: HttpClient, private authService: AuthService) { }

  getAdminData(){
    
    var url = environment.baseUrl + '/api/v1/admin'
    
    this.authService.addTokenToHeader();

    return this.http.get(url);
  }

  getManagerData(){
    
    var url = environment.baseUrl + '/api/v1/manager'
    
    const headers = new HttpHeaders({
      'Authorization': 'Bearer '+this.authService.getToken()
    });

    return this.http.get(url, { headers: headers });
  }

}
