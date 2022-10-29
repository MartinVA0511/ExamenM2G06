package pe.unjfsc.daw.configuration;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import pe.unjfsc.daw.entity.CEPeajeDTOEntrada;
import pe.unjfsc.daw.entity.CEPeajeDTOSalida;
import pe.unjfsc.daw.listener.JobLoteMovListener;
import pe.unjfsc.daw.mapper.CLPeajeMapper;
import pe.unjfsc.daw.process.CLPeajeProcessor;
import pe.unjfsc.daw.writer.CDPeajeWriter;

@Configuration
@EnableBatchProcessing
public class DefineJobsConfiguration {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public DelimitedLineTokenizer getLostPetTokenizer() {
		DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
		tokenizer.setDelimiter(",");
		tokenizer.setNames(new String[]{
				"ID","EMPRESA_CONCESION", "RUC_CONCESION",
				"DIRECCION_CONCESION", "UBICACION_CONCESION",
				"FECHA_PEAJE", "HORA_PEAJE",
				"TIPO_DE_COMPROBANTE", "N°_DE_COMPROBANTE",
				"CATEGORIA","IMPORTE"});
		return tokenizer;
	}
	
	@Bean
	public DefaultLineMapper<CEPeajeDTOEntrada> getPeajeLineMapper(){
		DefaultLineMapper<CEPeajeDTOEntrada> lineM = new DefaultLineMapper<CEPeajeDTOEntrada>();
		lineM.setLineTokenizer(getLostPetTokenizer());
		lineM.setFieldSetMapper(getLostPetMapper());
		return lineM;
	}
	
	@Bean
	public CLPeajeMapper getLostPetMapper() {
		return new CLPeajeMapper();
	}
	
	@Bean
	public FlatFileItemReader<CEPeajeDTOEntrada> getPeajeReader() {
		FlatFileItemReader<CEPeajeDTOEntrada> reader = new FlatFileItemReader<CEPeajeDTOEntrada>();
		reader.setResource(new ClassPathResource("fuente/input/peaje.csv"));
		reader.setLineMapper(getPeajeLineMapper());
		return reader;
	}
	
	@Bean
	public Job idFirstJobBatch(JobLoteMovListener listener, Step stepOne) {
		return jobBuilderFactory.get("idFirstJobBatch")
				.listener(listener)
				.flow(stepOne)
				.end()
				.build();
	}
	
	@Bean
	public Step stepOne() {
		return stepBuilderFactory.get("stepOne")
				.<CEPeajeDTOEntrada,CEPeajeDTOSalida>chunk(89)
				.reader(getPeajeReader())
				.processor(getCLPeajeProcessor())
				.writer(getCDPeajeWriter())
				.build();
	}
	
	@Bean
	public CLPeajeProcessor getCLPeajeProcessor() {
		return new CLPeajeProcessor();
	}
	
	@Bean
	public CDPeajeWriter getCDPeajeWriter() {
		return new CDPeajeWriter();
	}
	
}