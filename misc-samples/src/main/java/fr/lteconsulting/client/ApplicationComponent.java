package fr.lteconsulting.client;

import fr.lteconsulting.angular2gwt.ng.core.Component;
import jsinterop.annotations.JsType;

@Component(
		selector = "my-app",
		template = ""
				+ "<div class='row'>"
				+ "<div class='col med'>"
				+ "Choose your demo:"
				+ "<ul class='items'>"
				+ "<li (click)='selected=0'>main</li>"
				+ "<li (click)='selected=1'>versions</li>"
				+ "<li (click)='selected=2'>countdown local var</li>"
				+ "<li (click)='selected=3'>countdown viewchild</li>"
				+ "<li (click)='selected=4'>mission control</li>"
				+ "<li (click)='selected=5'>hero bios and contacts (ngContent and hosted services)</li>"
				+ "<li (click)='selected=6'>directives</li>"
				+ "<li (click)='selected=7'>animations</li>"
				+ "</ul>"
				+ "</div>"
				+ "<div class='col'>"
				+ "<main *ngIf='selected==0'></main>"
				+ "<version-parent *ngIf='selected==1'></version-parent>"
				+ "<countdown-parent-lv *ngIf='selected==2'></countdown-parent-lv>"
				+ "<countdown-parent-vc *ngIf='selected==3'></countdown-parent-vc>"
				+ "<mission-control *ngIf='selected==4'></mission-control>"
				+ "<hero-bios-and-contacts *ngIf='selected==5'></hero-bios-and-contacts>"
				+ "<directives *ngIf='selected==6'></directives>"
				+ "<animations *ngIf='selected==7'></animations>"
				+ "</div>"
				+ "</div>",
		styleUrls = "application.component.css" )
@JsType
public class ApplicationComponent
{
	public int selected = 0;
}
