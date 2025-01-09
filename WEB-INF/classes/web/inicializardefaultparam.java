package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class inicializardefaultparam extends GXProcedure
{
   public inicializardefaultparam( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( inicializardefaultparam.class ), "" );
   }

   public inicializardefaultparam( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( int aP0 )
   {
      inicializardefaultparam.this.AV8CliCod = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV12Pgmname, httpContext.getMessage( "inicializar parametros 1", "")) ;
      GXv_char1[0] = "" ;
      new web.defaultparametros(remoteHandle, context).execute( AV8CliCod, new web.cantreplicasprocesos_codigoparam(remoteHandle, context).executeUdp( ), true, httpContext.getMessage( "Cantidad total de contenedores disponibles", ""), GXv_char1) ;
      GXv_char1[0] = "" ;
      new web.defaultparametros(remoteHandle, context).execute( AV8CliCod, new web.cantloteporliq_codigoparam(remoteHandle, context).executeUdp( ), true, httpContext.getMessage( "Cantidad lotes por liquidación para procesar en paralelo", ""), GXv_char1) ;
      GXv_char1[0] = "" ;
      new web.defaultparametros(remoteHandle, context).execute( AV8CliCod, new web.cantlegporloteliq_codigoparam(remoteHandle, context).executeUdp( ), true, httpContext.getMessage( "Cantidad de legajos por lote en liquidación para procesar en paralelo", ""), GXv_char1) ;
      GXv_char1[0] = "" ;
      new web.defaultparametros(remoteHandle, context).execute( AV8CliCod, new web.usarurls3sinvpc_codigoparam(remoteHandle, context).executeUdp( ), true, httpContext.getMessage( "Usar URL S3 Sin VPC", ""), GXv_char1) ;
      GXv_char1[0] = "" ;
      new web.defaultparametros(remoteHandle, context).execute( AV8CliCod, new web.niveldebug_codigoparam(remoteHandle, context).executeUdp( ), true, httpContext.getMessage( "Nivel de debug", ""), GXv_char1) ;
      GXv_char1[0] = "" ;
      new web.defaultparametros(remoteHandle, context).execute( AV8CliCod, new web.nodebaseurl_codigoparam(remoteHandle, context).executeUdp( ), true, httpContext.getMessage( "Base URL de NodeJs", ""), GXv_char1) ;
      GXv_char1[0] = "" ;
      new web.defaultparametros(remoteHandle, context).execute( AV8CliCod, new web.redondeo_codigoparam(remoteHandle, context).executeUdp( ), true, httpContext.getMessage( "Scrape CUIL en importación de legajo por LSD", ""), GXv_char1) ;
      GXv_char1[0] = "" ;
      new web.defaultparametros(remoteHandle, context).execute( AV8CliCod, new web.redondeo_codigoparam(remoteHandle, context).executeUdp( ), true, httpContext.getMessage( "Liquidar redondeo", ""), GXv_char1) ;
      GXv_char1[0] = "" ;
      new web.defaultparametros(remoteHandle, context).execute( AV8CliCod, new web.importarleggooglelink_codigoparam(remoteHandle, context).executeUdp( ), true, httpContext.getMessage( "Link de template de google sheet para importación de legajos", ""), GXv_char1) ;
      GXv_char1[0] = "" ;
      new web.defaultparametros(remoteHandle, context).execute( AV8CliCod, new web.conceptos_aux_metodo_codigoparam(remoteHandle, context).executeUdp( ), true, httpContext.getMessage( "Método de ejecución de conceptos auxiliares: CALL o SUBMIT", ""), GXv_char1) ;
      GXv_char1[0] = "" ;
      new web.defaultparametros(remoteHandle, context).execute( AV8CliCod, new web.modoahorros3_codigoparam(remoteHandle, context).executeUdp( ), true, httpContext.getMessage( "Modo de ahorro para S3 activado", ""), GXv_char1) ;
      GXv_char1[0] = "" ;
      new web.defaultparametros(remoteHandle, context).execute( AV8CliCod, new web.a3lutilitiesesdocker_codigoparam(remoteHandle, context).executeUdp( ), true, httpContext.getMessage( "NodeJs de A3L Utilities es un contenedor de docker", ""), GXv_char1) ;
      GXv_char1[0] = "" ;
      new web.defaultparametros(remoteHandle, context).execute( AV8CliCod, new web.a3lutilitieshost_codigoparam(remoteHandle, context).executeUdp( ), true, httpContext.getMessage( "Host de nodejs", ""), GXv_char1) ;
      GXv_char1[0] = "" ;
      new web.defaultparametros(remoteHandle, context).execute( AV8CliCod, new web.hostnodepublico_codigoparam(remoteHandle, context).executeUdp( ), true, httpContext.getMessage( "Host de nodejs público", ""), GXv_char1) ;
      GXv_char1[0] = "" ;
      new web.defaultparametros(remoteHandle, context).execute( AV8CliCod, new web.htmlapdf_puerto_codigoparam(remoteHandle, context).executeUdp( ), true, httpContext.getMessage( "Puerto de nodejs", ""), GXv_char1) ;
      GXv_char1[0] = "" ;
      new web.defaultparametros(remoteHandle, context).execute( AV8CliCod, new web.bucketname_codigoparam(remoteHandle, context).executeUdp( ), true, httpContext.getMessage( "Bucket name para imágenes", ""), GXv_char1) ;
      GXv_char1[0] = "" ;
      new web.defaultparametros(remoteHandle, context).execute( AV8CliCod, new web.bucketnamepdf_codigo(remoteHandle, context).executeUdp( ), true, httpContext.getMessage( "Bucket name para pdfs", ""), GXv_char1) ;
      GXv_char1[0] = "" ;
      new web.defaultparametros(remoteHandle, context).execute( AV8CliCod, new web.s3awsregion_codigoparam(remoteHandle, context).executeUdp( ), true, httpContext.getMessage( "Region AWS para S3", ""), GXv_char1) ;
      GXv_char1[0] = httpContext.getMessage( "false", "") ;
      new web.defaultparametros(remoteHandle, context).execute( AV8CliCod, new web.grabarpreliquidacion_codigoparam(remoteHandle, context).executeUdp( ), true, httpContext.getMessage( "Grabar tablas de preliquidación", ""), GXv_char1) ;
      GXv_char1[0] = "" ;
      new web.defaultparametros(remoteHandle, context).execute( AV8CliCod, new web.monacosugcalckind_codigoparam(remoteHandle, context).executeUdp( ), true, httpContext.getMessage( "Propiedad \"Kind\" para ícono de sugerencia de monaco para los cálculos", ""), GXv_char1) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV12Pgmname, httpContext.getMessage( "inicializar parametros 2", "")) ;
      GXv_char1[0] = "" ;
      new web.defaultparametros(remoteHandle, context).execute( AV8CliCod, new web.monacosugcalckind_codigoparam(remoteHandle, context).executeUdp( ), true, httpContext.getMessage( "Propiedad \"Kind\" para ícono de sugerencia de monaco para los parámetros de cálculos", ""), GXv_char1) ;
      GXv_char1[0] = "" ;
      new web.defaultparametros(remoteHandle, context).execute( AV8CliCod, new web.monacosugvarkind_codigoparam(remoteHandle, context).executeUdp( ), true, httpContext.getMessage( "Propiedad \"Kind\" para ícono de sugerencia de monaco para las variables", ""), GXv_char1) ;
      GXv_char1[0] = "" ;
      new web.defaultparametros(remoteHandle, context).execute( AV8CliCod, new web.metododesgloseformula_codigoparam(remoteHandle, context).executeUdp( ), true, httpContext.getMessage( "Método de desgloce de fórmula en proceso de liquidación. \"SDT\" o \"TABLA\"", ""), GXv_char1) ;
      GXv_char1[0] = "" ;
      new web.defaultparametros(remoteHandle, context).execute( AV8CliCod, new web.algoritmoequivimportleg_codigo(remoteHandle, context).executeUdp( ), true, httpContext.getMessage( "Algoritmo para calcular equivalencias de tablas al importar legajos", ""), GXv_char1) ;
      GXv_char1[0] = "" ;
      new web.defaultparametros(remoteHandle, context).execute( AV8CliCod, new web.textonomostrara_codigoparam(remoteHandle, context).executeUdp( ), true, httpContext.getMessage( "Texto que aparece cuando tildan \"No mostrar mas\" en el cuadro de bienvenida", ""), GXv_char1) ;
      GXv_char1[0] = "" ;
      new web.defaultparametros(remoteHandle, context).execute( AV8CliCod, new web.desglosaradicional_codigoparam(remoteHandle, context).executeUdp( ), true, httpContext.getMessage( "Liquidar adicional de categoría en un concepto aparte del sueldo básico", ""), GXv_char1) ;
      GXv_char1[0] = "" ;
      new web.defaultparametros(remoteHandle, context).execute( AV8CliCod, new web.meses30dias_codigoparam(remoteHandle, context).executeUdp( ), true, httpContext.getMessage( "Todos los meses asumir 30 días", ""), GXv_char1) ;
      GXv_char1[0] = "" ;
      new web.defaultparametros(remoteHandle, context).execute( AV8CliCod, new web.logfallidos_codigoparam(remoteHandle, context).executeUdp( ), true, httpContext.getMessage( "Loguear intentos fallidos de cálculo", ""), GXv_char1) ;
      GXv_char1[0] = "" ;
      new web.defaultparametros(remoteHandle, context).execute( AV8CliCod, new web.horas_default_feriado_param(remoteHandle, context).executeUdp( ), true, httpContext.getMessage( "Cantidad de horas para día feriado, y horas extras (Si se establece en 0 se calcula de la siguiente manera: Si las horas trabajadas (en caso de especificarlas por día) son mayor o igual a las máximas permitidas por país (por ejemplo 9), se calculan 9 horas, y si son menores, se calculan las horas normales por país (por ejemplo 8). Si se establece valor mayor a 0 en este parámetro, se usará siempre ese valor.", ""), GXv_char1) ;
      GXv_char1[0] = "" ;
      new web.defaultparametros(remoteHandle, context).execute( AV8CliCod, new web.modotest_codigoparam(remoteHandle, context).executeUdp( ), true, httpContext.getMessage( "Modo test (se visualizan funciones extras)", ""), GXv_char1) ;
      GXv_char1[0] = "" ;
      new web.defaultparametros(remoteHandle, context).execute( AV8CliCod, new web.auto_imprimir_pdfliqleg_codigoparam(remoteHandle, context).executeUdp( ), true, httpContext.getMessage( "Generar en paralelo los pdfs de liquidacion por legajo", ""), GXv_char1) ;
      GXv_char1[0] = "" ;
      new web.defaultparametros(remoteHandle, context).execute( AV8CliCod, new web.pdf_automatico_estilo_codigoparam(remoteHandle, context).executeUdp( ), true, httpContext.getMessage( "Estilo de pdf para el proceso de generación automática", ""), GXv_char1) ;
      GXv_char1[0] = "" ;
      new web.defaultparametros(remoteHandle, context).execute( AV8CliCod, new web.esperarauxiliares_codigoparam(remoteHandle, context).executeUdp( ), true, httpContext.getMessage( "Esperar que terminen de procesar conceptos auxiliares para liquidar una nueva", ""), GXv_char1) ;
      GXv_char1[0] = "" ;
      new web.defaultparametros(remoteHandle, context).execute( AV8CliCod, new web.liquidarauxparalelos_param(remoteHandle, context).executeUdp( ), true, httpContext.getMessage( "Correr procesos de liquidación de conceptos auxiliares y generación de pdfs inmediatamente después de liquidación", ""), GXv_char1) ;
      GXv_char1[0] = "" ;
      new web.defaultparametros(remoteHandle, context).execute( AV8CliCod, new web.encoding_importar_param(remoteHandle, context).executeUdp( ), true, httpContext.getMessage( "Encoding para importar archivo de conceptos externos", ""), GXv_char1) ;
      GXv_char1[0] = "" ;
      new web.defaultparametros(remoteHandle, context).execute( AV8CliCod, new web.antiguedad_fraccion_aniomes_codigoparam(remoteHandle, context).executeUdp( ), true, httpContext.getMessage( "Cantidad de meses que se consideran como 1 año para calcular antiguedad en indemnización", ""), GXv_char1) ;
      GXv_char1[0] = "" ;
      new web.defaultparametros(remoteHandle, context).execute( AV8CliCod, new web.proporcion_habitual_param(remoteHandle, context).executeUdp( ), true, httpContext.getMessage( "Proporción de incurrencia en liquidación de un concepto para considerarlo habitual", ""), GXv_char1) ;
      GXv_char1[0] = "" ;
      new web.defaultparametros(remoteHandle, context).execute( AV8CliCod, new web.liquidar_adelanto_retencion(remoteHandle, context).executeUdp( ), true, httpContext.getMessage( "Liquidar adelanto de retención de ganancias para primera quincena o adelanto de vacaciones", ""), GXv_char1) ;
      GXv_char1[0] = "" ;
      new web.defaultparametros(remoteHandle, context).execute( AV8CliCod, new web.meses_liquidar_sac_param(remoteHandle, context).executeUdp( ), true, httpContext.getMessage( "Meses de liquidación de SAC", ""), GXv_char1) ;
      GXv_char1[0] = "" ;
      new web.defaultparametros(remoteHandle, context).execute( AV8CliCod, new web.monacocolortokenvariables_codigoparam(remoteHandle, context).executeUdp( ), true, httpContext.getMessage( "Color para las variables en el editor de fórmulas", ""), GXv_char1) ;
      GXv_char1[0] = "" ;
      new web.defaultparametros(remoteHandle, context).execute( AV8CliCod, new web.monacocolortokencalculos_codigoparam(remoteHandle, context).executeUdp( ), true, httpContext.getMessage( "Color para los cálculos en el editor de fórmulas", ""), GXv_char1) ;
      GXv_char1[0] = "" ;
      new web.defaultparametros(remoteHandle, context).execute( AV8CliCod, new web.monacocolortokenconceptos_codigoparam(remoteHandle, context).executeUdp( ), true, httpContext.getMessage( "Color para los conceptos en el editor de fórmulas", ""), GXv_char1) ;
      GXv_char1[0] = "" ;
      new web.defaultparametros(remoteHandle, context).execute( AV8CliCod, new web.monacocolortokennumeros_codigoparam(remoteHandle, context).executeUdp( ), true, httpContext.getMessage( "Color para los números en el editor de fórmulas", ""), GXv_char1) ;
      GXv_char1[0] = "" ;
      new web.defaultparametros(remoteHandle, context).execute( AV8CliCod, httpContext.getMessage( "monaco_tokens", ""), true, httpContext.getMessage( "Definición de tokens para monaco editor", ""), GXv_char1) ;
      GXv_char1[0] = "" ;
      new web.defaultparametros(remoteHandle, context).execute( AV8CliCod, httpContext.getMessage( "monaco_brackets", ""), true, httpContext.getMessage( "Definición de brackets para monaco editor", ""), GXv_char1) ;
      GXv_char1[0] = "" ;
      new web.defaultparametros(remoteHandle, context).execute( AV8CliCod, new web.monacourlsug_codigoparam(remoteHandle, context).executeUdp( ), true, httpContext.getMessage( "WS sugerencias monaco", ""), GXv_char1) ;
      GXv_char1[0] = "" ;
      new web.defaultparametros(remoteHandle, context).execute( AV8CliCod, new web.actividad_codigoparam(remoteHandle, context).executeUdp( ), true, httpContext.getMessage( "Actividad AFIP por defecto", ""), GXv_char1) ;
      GXv_char1[0] = "" ;
      new web.defaultparametros(remoteHandle, context).execute( AV8CliCod, new web.tipoliqanticipo_codigoparam(remoteHandle, context).executeUdp( ), true, httpContext.getMessage( "Tipo de liquidación anticipo", ""), GXv_char1) ;
      GXv_char1[0] = "" ;
      new web.defaultparametros(remoteHandle, context).execute( AV8CliCod, new web.tipoliqvarios_codigoparam(remoteHandle, context).executeUdp( ), true, httpContext.getMessage( "Tipo de liquidación varios", ""), GXv_char1) ;
      GXv_char1[0] = "" ;
      new web.defaultparametros(remoteHandle, context).execute( AV8CliCod, new web.tipoliqaguinaldo_codigoparam(remoteHandle, context).executeUdp( ), true, httpContext.getMessage( "Tipo de liquidación aguinaldo", ""), GXv_char1) ;
      GXv_char1[0] = "" ;
      new web.defaultparametros(remoteHandle, context).execute( AV8CliCod, new web.tipoliqmensual_codigoparam(remoteHandle, context).executeUdp( ), true, httpContext.getMessage( "Tipo de liquidación mensual", ""), GXv_char1) ;
      GXv_char1[0] = "" ;
      new web.defaultparametros(remoteHandle, context).execute( AV8CliCod, new web.tipoliqquincena_codigoparam(remoteHandle, context).executeUdp( ), true, httpContext.getMessage( "Tipo de liquidación quincena", ""), GXv_char1) ;
      cleanup();
   }

   protected void cleanup( )
   {
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12Pgmname = "" ;
      GXv_char1 = new String[1] ;
      AV12Pgmname = "inicializarDefaultParam" ;
      /* GeneXus formulas. */
      AV12Pgmname = "inicializarDefaultParam" ;
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV8CliCod ;
   private String AV12Pgmname ;
   private String GXv_char1[] ;
}

