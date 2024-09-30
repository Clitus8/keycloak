import { Component } from '@angular/core';
import { CommonService } from '../service/common.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.scss']
})
export class AdminComponent {
  adminData: any;

  constructor(private commonService: CommonService){}

  ngOnInit() {
    this.commonService.getAdminData().subscribe( (event: any)=> {
      console.log(event);
      this.adminData = event;
    });
  }
}
