package gov.usgs.cida.dsas.uncy;

import com.google.common.collect.ImmutableMap;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang.StringUtils;
import org.geotools.data.FeatureWriter;
import org.geotools.data.Transaction;
import org.geotools.data.postgis.PostgisNGJNDIDataStoreFactory;
import org.geotools.jdbc.JDBCDataStore;
import org.geotools.jdbc.JDBCDataStoreFactory;
import org.geotools.jdbc.JDBCJNDIDataStoreFactory;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author isuftin
 */
public class PostGISJNDIOutputXploder extends DatabaseOutputXploder {

	private static final Logger LOGGER = LoggerFactory.getLogger(PostGISJNDIOutputXploder.class);
	public final static String JNDI_PARAM = JDBCJNDIDataStoreFactory.JNDI_REFNAME.key;

	public PostGISJNDIOutputXploder(Map<String, String> config) {
		super(mergeMaps(config, ImmutableMap.of(JDBCDataStoreFactory.DBTYPE.key, "postgis")));

		String[] requiredConfigs = new String[]{
			JNDI_PARAM
		};

		for (String requiredConfig : requiredConfigs) {
			if (!config.containsKey(requiredConfig)) {
				throw new IllegalArgumentException(String.format("Configuration map for PostGISJNDIOutputXploder must include parameter %s", requiredConfig));
			}
			if (StringUtils.isBlank(config.get(requiredConfig))) {
				throw new IllegalArgumentException(String.format("Configuration map for H2DaPostGISJNDIOutputXplodertabaseOutputExplorer must include value for parameter %s", requiredConfig));
			}
		}
		dbConfig.put(JDBCDataStoreFactory.DBTYPE.key, dbType);
		dbConfig.putAll(config);
	}

	@Override // TODO- Get this from the database - This is too specific right now 
	protected SimpleFeatureType createOutputFeatureType(String outputTypeName) throws IOException {
		JDBCDataStore createDataStore = null;
		try {
			createDataStore = new PostgisNGJNDIDataStoreFactory().createDataStore(dbConfig);
			return createDataStore.getSchema(outputTypeName);
		} finally {
			if (createDataStore != null) {
				createDataStore.dispose();
			}
		}
	}

	@Override
	FeatureWriter<SimpleFeatureType, SimpleFeature> createFeatureWriter(Transaction tx) throws IOException {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
}
