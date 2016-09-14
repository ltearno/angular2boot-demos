package fr.lteconsulting.client.missioncontrol;

import fr.lteconsulting.angular2gwt.client.interop.angular.rxjs.Subscription;
import fr.lteconsulting.angular2gwt.client.interop.ng.core.OnDestroy;
import fr.lteconsulting.angular2gwt.ng.core.Component;
import fr.lteconsulting.angular2gwt.ng.core.Input;
import jsinterop.annotations.JsType;

@Component(
		selector = "my-astronaut",
		template = "<p>"
				+ "{{astronaut}}: <strong>{{mission}}</strong>"
				+ "<button (click)='confirm()' [disabled]='!announced || confirmed'>Confirm</button>"
				+ "</p>" )
@JsType
public class AstronautMissionComponent implements OnDestroy
{
	@Input
	public String astronaut;
	public String mission = "<no mission announced>";
	public boolean confirmed = false;
	public boolean announced = false;

	private Subscription subscription;
	private MissionService missionService;

	public AstronautMissionComponent( MissionService missionService )
	{
		this.missionService = missionService;

		subscription = missionService.missionAnnounced$.subscribe( mission -> {
			this.mission = mission;
			announced = true;
			confirmed = false;
		} );
	}

	public void confirm()
	{
		confirmed = true;
		missionService.confirmMission( astronaut );
	}

	@Override
	public void ngOnDestroy()
	{
		subscription.unsubscribe();
	}
}
