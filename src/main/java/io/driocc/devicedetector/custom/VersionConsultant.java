/**
 * 
 */
package io.driocc.devicedetector.custom;

/**
 * @author kyon
 *
 */
public class VersionConsultant {

	/**
     * Indicates how deep versioning will be detected
     * if $maxMinorParts is 0 only the major version will be returned
     * @var int
     */
    protected Integer maxMinorParts = 1;
    /**
     * Versioning constant used to set max versioning to major version only
     * Version examples are: 3, 5, 6, 200, 123, ...
     */
    public static final Integer VERSION_TRUNCATION_MAJOR = 0;
    /**
     * Versioning constant used to set max versioning to minor version
     * Version examples are: 3.4, 5.6, 6.234, 0.200, 1.23, ...
     */
    public static final Integer VERSION_TRUNCATION_MINOR = 1;
    /**
     * Versioning constant used to set max versioning to path level
     * Version examples are: 3.4.0, 5.6.344, 6.234.2, 0.200.3, 1.2.3, ...
     */
    public static final Integer VERSION_TRUNCATION_PATCH = 2;
    /**
     * Versioning constant used to set versioning to build number
     * Version examples are: 3.4.0.12, 5.6.334.0, 6.234.2.3, 0.200.3.1, 1.2.3.0, ...
     */
    public static final Integer VERSION_TRUNCATION_BUILD = 3;
    /**
     * Versioning constant used to set versioning to unlimited (no truncation)
     */
    public static final Integer VERSION_TRUNCATION_NONE  = null;
    
    public void setVersionTruncation(Integer type){
        this.maxMinorParts = type;
    }

	/**
	 * @return the maxMinorParts
	 */
	public Integer getMaxMinorParts() {
		return maxMinorParts;
	}

	/**
	 * @param maxMinorParts the maxMinorParts to set
	 */
	public void setMaxMinorParts(Integer maxMinorParts) {
		this.maxMinorParts = maxMinorParts;
	}
}
