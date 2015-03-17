/*
Compare Version Numbers
Compare two version numbers version1 and version1.
If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.
*/

public int compareVersion(String version1, String version2){
	if (version1.equals(version2))
		return 0;

	int curr1, curr2;
	String rest1, rest2;
	if (version1.contains(".")){
		int index = version1.indexOf(".");
		curr1 = Integer.parseInt(version1.substring(0, index));
		rest1 = version1.substring(index + 1);
	}
	else{
		curr1 = Integer.parseInt(version1);
		rest1 = "0";
	}

	if (version2.contains(".")){
		int index = version2.indexOf(".");
		curr2 = Integer.parseInt(version2.substring(0, index));
		rest2 = version2.substring(index + 1);
	}
	else{
		curr2 = Integer.parseInt(version2);
		rest2 = "0";
	}

	if (sversion1 > sversion2)
		return 1;
	if (sversio1 < sverion2)
		return -1;
	else
		return compareVersion(rversion1, rversion2);

}
public void getUpdate(String str, int curr, String rest){
	if (str.contains(".")){
		int index = str.indexOf(".");
		curr = Integer.parseInt(str.substring(0, index));
		rest = str.substring(index + 1);
	}
	else{
		curr = Integer.parseInt(str);
		rest = "0";
	}
}