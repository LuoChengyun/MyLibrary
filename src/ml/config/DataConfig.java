package ml.config;
import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;


/**
 * 数据库配置
 * 
 * @author luochengyun
 * @version v1.0
 */
@Configuration
public class DataConfig {

	/**
	 * 数据源设置，采用mysql
	 * 
	 * @return
	 */
	@Bean
	public BasicDataSource dataSource() {
		BasicDataSource bds = new BasicDataSource();
		bds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		bds.setUrl("jdbc:mysql://localhost:3306/Library?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC");
		bds.setUsername("root");
		bds.setPassword("123456");
		bds.setInitialSize(5);
		bds.setMaxTotal(10);
		return bds;
	}

	/**
	 * jdbc模板配置，采用spring默认的JdbcTemplate模板
	 * 
	 * @param dataSource
	 *            数据源
	 * @return
	 */
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

}
