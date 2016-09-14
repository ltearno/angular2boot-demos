package fr.lteconsulting.client.missioncontrol;

import fr.lteconsulting.angular2gwt.client.interop.angular.rxjs.Observable;
import fr.lteconsulting.angular2gwt.client.interop.angular.rxjs.Subject;
import fr.lteconsulting.angular2gwt.ng.core.Injectable;
import jsinterop.annotations.JsType;

@Injectable
@JsType
public class MissionService
{
	// Observable string sources
	private Subject<String> missionAnnouncedSource = new Subject<>();

	private Subject<String> missionConfirmedSource = new Subject<>();

	// Observable string streams
	public Observable<String> missionAnnounced$ = missionAnnouncedSource.asObservable();

	public Observable<String> missionConfirmed$ = missionConfirmedSource.asObservable();

	// Service message commands
	public void announceMission( String mission )
	{
		missionAnnouncedSource.next( mission );
	}

	public void confirmMission( String astronaut )
	{
		missionConfirmedSource.next( astronaut );
	}
}
