package fr.lteconsulting.client.versions;

import fr.lteconsulting.angular2gwt.ng.core.Component;
import jsinterop.annotations.JsType;

@Component(
		selector = "version-parent",
		template = "<h1>Source code version</h1>"
				+ "<button (click)='newMinor()'>New minor version</button>"
				+ "<button (click)='newMajor()'>New major version</button>"
				+ "<version-child [major]='major' [minor]='minor'></version-child>" )
@JsType
public class VersionParentComponent
{
	public int major = 1;
	public int minor = 23;

	public void newMinor()
	{
		minor++;
	}

	public void newMajor()
	{
		major++;
		minor = 0;
	}
}
