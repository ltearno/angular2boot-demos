package fr.lteconsulting.client;

import fr.lteconsulting.angular2gwt.client.interop.ng.forms.FormsModule;
import fr.lteconsulting.angular2gwt.client.interop.ng.http.HttpModule;
import fr.lteconsulting.angular2gwt.client.interop.ng.platformBrowser.BrowserModule;
import fr.lteconsulting.angular2gwt.ng.core.NgModule;
import fr.lteconsulting.client.animations.AnimationsComponent;
import fr.lteconsulting.client.countdown.CountdownLocalVarParentComponent;
import fr.lteconsulting.client.countdown.CountdownTimerComponent;
import fr.lteconsulting.client.countdown.CountdownViewChildParentComponent;
import fr.lteconsulting.client.directives.DirectivesComponent;
import fr.lteconsulting.client.herobio.HeroBioComponent;
import fr.lteconsulting.client.herobio.HeroBiosAndContactsComponent;
import fr.lteconsulting.client.herobio.HeroContactComponent;
import fr.lteconsulting.client.mainchild.ChildComponent;
import fr.lteconsulting.client.mainchild.MainComponent;
import fr.lteconsulting.client.missioncontrol.AstronautMissionComponent;
import fr.lteconsulting.client.missioncontrol.MissionControlComponent;
import fr.lteconsulting.client.versions.VersionChildComponent;
import fr.lteconsulting.client.versions.VersionParentComponent;
import jsinterop.annotations.JsType;

@NgModule(
		imports = {
				BrowserModule.class,
				FormsModule.class,
				HttpModule.class
		},
		declarations = {
				ApplicationComponent.class,

				MainComponent.class,
				ChildComponent.class,

				VersionParentComponent.class,
				VersionChildComponent.class,

				CountdownTimerComponent.class,
				CountdownLocalVarParentComponent.class,
				CountdownViewChildParentComponent.class,

				MissionControlComponent.class,
				AstronautMissionComponent.class,

				HeroBiosAndContactsComponent.class,
				HeroBioComponent.class,
				HeroContactComponent.class,

				DirectivesComponent.class,

				AnimationsComponent.class
		},
		providers = {
				LoggerService.class
		},
		bootstrap = ApplicationComponent.class )
@JsType
public class ApplicationModule
{
}
