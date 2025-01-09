package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class defaultparametros extends GXProcedure
{
   public defaultparametros( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( defaultparametros.class ), "" );
   }

   public defaultparametros( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             String aP1 ,
                             boolean aP2 ,
                             String aP3 )
   {
      defaultparametros.this.aP4 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        boolean aP2 ,
                        String aP3 ,
                        String[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             boolean aP2 ,
                             String aP3 ,
                             String[] aP4 )
   {
      defaultparametros.this.AV15CliCod = aP0;
      defaultparametros.this.AV8ParmCod = aP1;
      defaultparametros.this.AV14grabar = aP2;
      defaultparametros.this.AV20ParmDescri = aP3;
      defaultparametros.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV10sistema = httpContext.getMessage( "PagaJavaPostgreSQL", "") ;
      GXt_char1 = AV12prefijoDED ;
      GXv_char2[0] = GXt_char1 ;
      new web.prefijodeduccion(remoteHandle, context).execute( GXv_char2) ;
      defaultparametros.this.GXt_char1 = GXv_char2[0] ;
      AV12prefijoDED = GXt_char1 ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV28Pgmname, httpContext.getMessage( "&ParmCod ", "")+AV8ParmCod) ;
      if ( GXutil.strcmp(AV8ParmCod, new web.cantreplicasprocesos_codigoparam(remoteHandle, context).executeUdp( )) == 0 )
      {
         AV9ParmValue = "1" ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, new web.cantloteporliq_codigoparam(remoteHandle, context).executeUdp( )) == 0 )
      {
         AV9ParmValue = "1" ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, new web.cantlegporloteliq_codigoparam(remoteHandle, context).executeUdp( )) == 0 )
      {
         AV9ParmValue = "0" ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, new web.usarurls3sinvpc_codigoparam(remoteHandle, context).executeUdp( )) == 0 )
      {
         AV9ParmValue = httpContext.getMessage( "true", "") ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, new web.niveldebug_codigoparam(remoteHandle, context).executeUdp( )) == 0 )
      {
      }
      else if ( GXutil.strcmp(AV8ParmCod, new web.nodebaseurl_codigoparam(remoteHandle, context).executeUdp( )) == 0 )
      {
         AV9ParmValue = httpContext.getMessage( "A3LUtilities", "") ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, new web.scrapecuil_codigoparam(remoteHandle, context).executeUdp( )) == 0 )
      {
         AV9ParmValue = httpContext.getMessage( "true", "") ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, new web.redondeo_codigoparam(remoteHandle, context).executeUdp( )) == 0 )
      {
         AV9ParmValue = httpContext.getMessage( "SIEMPRE", "") ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, new web.importarleggooglelink_codigoparam(remoteHandle, context).executeUdp( )) == 0 )
      {
         AV9ParmValue = httpContext.getMessage( "https://docs.google.com/spreadsheets/d/1zATUggZM86g44Vs0g1SJMJb1Lm88Hmhw/copy", "") ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, new web.conceptos_aux_metodo_codigoparam(remoteHandle, context).executeUdp( )) == 0 )
      {
         AV9ParmValue = httpContext.getMessage( "SUBMIT", "") ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, new web.modoahorros3_codigoparam(remoteHandle, context).executeUdp( )) == 0 )
      {
         AV9ParmValue = httpContext.getMessage( "false", "") ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, new web.a3lutilitiesesdocker_codigoparam(remoteHandle, context).executeUdp( )) == 0 )
      {
         AV9ParmValue = httpContext.getMessage( "false", "") ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, new web.hostnodepublico_codigoparam(remoteHandle, context).executeUdp( )) == 0 )
      {
         AV9ParmValue = httpContext.getMessage( "localhost", "") ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, new web.a3lutilitieshost_codigoparam(remoteHandle, context).executeUdp( )) == 0 )
      {
         AV9ParmValue = httpContext.getMessage( "localhost", "") ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, new web.htmlapdf_puerto_codigoparam(remoteHandle, context).executeUdp( )) == 0 )
      {
         AV9ParmValue = "3900" ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, new web.bucketname_codigoparam(remoteHandle, context).executeUdp( )) == 0 )
      {
         AV9ParmValue = httpContext.getMessage( "us.east.1.test.img.payday.ar", "") ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, new web.bucketnamepdf_codigo(remoteHandle, context).executeUdp( )) == 0 )
      {
         AV9ParmValue = httpContext.getMessage( "us-east-1.test.pdf.payday.ar", "") ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, new web.s3awsregion_codigoparam(remoteHandle, context).executeUdp( )) == 0 )
      {
         AV9ParmValue = httpContext.getMessage( "us-east-1", "") ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, new web.monacosugcalckind_codigoparam(remoteHandle, context).executeUdp( )) == 0 )
      {
         AV9ParmValue = httpContext.getMessage( "Module", "") ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV28Pgmname, httpContext.getMessage( "hola ", "")+AV9ParmValue) ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, new web.monacosugvarkind_codigoparam(remoteHandle, context).executeUdp( )) == 0 )
      {
         AV9ParmValue = httpContext.getMessage( "File", "") ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, new web.monacosugcalckind_codigoparam(remoteHandle, context).executeUdp( )) == 0 )
      {
         AV9ParmValue = httpContext.getMessage( "EnumMember", "") ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, new web.metododesgloseformula_codigoparam(remoteHandle, context).executeUdp( )) == 0 )
      {
         AV9ParmValue = httpContext.getMessage( "SDT", "") ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, new web.algoritmoequivimportleg_codigo(remoteHandle, context).executeUdp( )) == 0 )
      {
         AV9ParmValue = "Algoritmo1" ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, new web.textonomostrara_codigoparam(remoteHandle, context).executeUdp( )) == 0 )
      {
         AV9ParmValue = httpContext.getMessage( "Hecho! Este cuadro no se mostrará más la próxima vez", "") ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, new web.grabarpreliquidacion_codigoparam(remoteHandle, context).executeUdp( )) == 0 )
      {
         AV9ParmValue = httpContext.getMessage( "false", "") ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, new web.pais_predet_codigoparam(remoteHandle, context).executeUdp( )) == 0 )
      {
         GXt_int3 = (short)(0) ;
         GXv_int4[0] = GXt_int3 ;
         new web.paisargentina(remoteHandle, context).execute( GXv_int4) ;
         defaultparametros.this.GXt_int3 = GXv_int4[0] ;
         AV9ParmValue = GXutil.trim( GXutil.str( GXt_int3, 10, 0)) ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, new web.provincia_predet_codigoparam(remoteHandle, context).executeUdp( )) == 0 )
      {
         GXt_int3 = (short)(0) ;
         GXv_int4[0] = GXt_int3 ;
         new web.provinciabuenosaires(remoteHandle, context).execute( GXv_int4) ;
         defaultparametros.this.GXt_int3 = GXv_int4[0] ;
         AV9ParmValue = GXutil.trim( GXutil.str( GXt_int3, 10, 0)) ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, new web.desglosaradicional_codigoparam(remoteHandle, context).executeUdp( )) == 0 )
      {
         AV9ParmValue = httpContext.getMessage( "true", "") ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, new web.horas_default_feriado_param(remoteHandle, context).executeUdp( )) == 0 )
      {
         AV9ParmValue = "9" ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, new web.modotest_codigoparam(remoteHandle, context).executeUdp( )) == 0 )
      {
         AV9ParmValue = httpContext.getMessage( "false", "") ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, new web.auto_imprimir_pdfliqleg_codigoparam(remoteHandle, context).executeUdp( )) == 0 )
      {
         AV9ParmValue = httpContext.getMessage( "MASIVO", "") ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, new web.pdf_automatico_estilo_codigoparam(remoteHandle, context).executeUdp( )) == 0 )
      {
         AV9ParmValue = httpContext.getMessage( "APAISADO", "") ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, new web.esperarauxiliares_codigoparam(remoteHandle, context).executeUdp( )) == 0 )
      {
         AV9ParmValue = httpContext.getMessage( "true", "") ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, new web.encoding_importar_param(remoteHandle, context).executeUdp( )) == 0 )
      {
         AV9ParmValue = httpContext.getMessage( "windows-1252", "") ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, new web.antiguedad_fraccion_aniomes_codigoparam(remoteHandle, context).executeUdp( )) == 0 )
      {
         AV9ParmValue = "3" ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, new web.metodo_resolucion_auxiliares(remoteHandle, context).executeUdp( )) == 0 )
      {
         AV9ParmValue = httpContext.getMessage( "CALL", "") ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, new web.proporcion_habitual_param(remoteHandle, context).executeUdp( )) == 0 )
      {
         AV9ParmValue = "0.5" ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, new web.liquidar_adelanto_retencion(remoteHandle, context).executeUdp( )) == 0 )
      {
         AV9ParmValue = httpContext.getMessage( "true", "") ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, new web.liquidar_auxiliares_param(remoteHandle, context).executeUdp( )) == 0 )
      {
         AV9ParmValue = httpContext.getMessage( "true", "") ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, new web.meses_liquidar_sac_param(remoteHandle, context).executeUdp( )) == 0 )
      {
         AV9ParmValue = "[6,12]" ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, new web.liquidarauxparalelos_param(remoteHandle, context).executeUdp( )) == 0 )
      {
         AV9ParmValue = httpContext.getMessage( "true", "") ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, httpContext.getMessage( "cant_leg_test", "")) == 0 )
      {
         AV9ParmValue = "0" ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, new web.defaultafipconrepetible_codigoparam(remoteHandle, context).executeUdp( )) == 0 )
      {
         AV9ParmValue = "1" ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, new web.defaultredondeoestimacion_codigoparam(remoteHandle, context).executeUdp( )) == 0 )
      {
         AV9ParmValue = "10000" ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, new web.logfallidos_codigoparam(remoteHandle, context).executeUdp( )) == 0 )
      {
         AV9ParmValue = httpContext.getMessage( "false", "") ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, new web.liquidarnousados_codigoparam(remoteHandle, context).executeUdp( )) == 0 )
      {
         AV9ParmValue = httpContext.getMessage( "false", "") ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, new web.mododeducciondescuentosley_codigoparam(remoteHandle, context).executeUdp( )) == 0 )
      {
         AV9ParmValue = httpContext.getMessage( "GRAVADO", "") ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, new web.meses30dias_codigoparam(remoteHandle, context).executeUdp( )) == 0 )
      {
         AV9ParmValue = httpContext.getMessage( "true", "") ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, new web.metodorecalculo_codigoparam(remoteHandle, context).executeUdp( )) == 0 )
      {
         AV9ParmValue = httpContext.getMessage( "MIXTO", "") ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, httpContext.getMessage( "sistema", "")) == 0 )
      {
         AV9ParmValue = GXutil.trim( AV10sistema) ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, httpContext.getMessage( "monaco_lineNumbers", "")) == 0 )
      {
         AV9ParmValue = httpContext.getMessage( "off", "") ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, httpContext.getMessage( "monaco_wordWrap", "")) == 0 )
      {
         AV9ParmValue = httpContext.getMessage( "wordWrapColumn", "") ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, httpContext.getMessage( "monaco_Columns", "")) == 0 )
      {
         AV9ParmValue = "100" ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, httpContext.getMessage( "monaco_foreground", "")) == 0 )
      {
         AV9ParmValue = "#000000" ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, httpContext.getMessage( "monaco_minimap", "")) == 0 )
      {
         AV9ParmValue = httpContext.getMessage( "false", "") ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, new web.monacocolortokenvariables_codigoparam(remoteHandle, context).executeUdp( )) == 0 )
      {
         AV9ParmValue = "#978000" ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, new web.monacocolortokencalculos_codigoparam(remoteHandle, context).executeUdp( )) == 0 )
      {
         AV9ParmValue = "#C73A00" ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, new web.monacocolortokenconceptos_codigoparam(remoteHandle, context).executeUdp( )) == 0 )
      {
         AV9ParmValue = "#3A0080" ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, new web.monacocolortokennumeros_codigoparam(remoteHandle, context).executeUdp( )) == 0 )
      {
         AV9ParmValue = "#1a8c79" ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, httpContext.getMessage( "monaco_tokens", "")) == 0 )
      {
         GXt_char1 = AV9ParmValue ;
         GXv_char2[0] = GXt_char1 ;
         new web.monaco_tokensdefault(remoteHandle, context).execute( GXv_char2) ;
         defaultparametros.this.GXt_char1 = GXv_char2[0] ;
         AV9ParmValue = GXt_char1 ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, httpContext.getMessage( "monaco_brackets", "")) == 0 )
      {
         GXt_char1 = AV9ParmValue ;
         GXv_char2[0] = GXt_char1 ;
         new web.jsmonacobracketsdefault(remoteHandle, context).execute( GXv_char2) ;
         defaultparametros.this.GXt_char1 = GXv_char2[0] ;
         AV9ParmValue = GXt_char1 ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, new web.protocolo_codigoparam(remoteHandle, context).executeUdp( )) == 0 )
      {
         AV9ParmValue = httpContext.getMessage( "http", "") ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, new web.monacourlsug_codigoparam(remoteHandle, context).executeUdp( )) == 0 )
      {
         GXt_char1 = AV9ParmValue ;
         GXv_char2[0] = GXt_char1 ;
         new web.paqueteprefijo(remoteHandle, context).execute( GXv_char2) ;
         defaultparametros.this.GXt_char1 = GXv_char2[0] ;
         AV9ParmValue = GXutil.trim( GXt_char1) + httpContext.getMessage( "wsmonacosugerenciashttp", "") ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, new web.zona_codigoparam(remoteHandle, context).executeUdp( )) == 0 )
      {
         AV9ParmValue = "07" ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, httpContext.getMessage( "LPG_DEF", "")) == 0 )
      {
         AV9ParmValue = httpContext.getMessage( "BAN", "") ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, httpContext.getMessage( "CARG_DEF", "")) == 0 )
      {
         AV9ParmValue = httpContext.getMessage( "ADM", "") ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, new web.seccion_codigoparam(remoteHandle, context).executeUdp( )) == 0 )
      {
         AV9ParmValue = "005" ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, httpContext.getMessage( "PAI_DEF", "")) == 0 )
      {
         AV9ParmValue = "12" ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, new web.situacion_codigoparam(remoteHandle, context).executeUdp( )) == 0 )
      {
         AV9ParmValue = "1" ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, new web.condicion_codigoparam(remoteHandle, context).executeUdp( )) == 0 )
      {
         AV9ParmValue = "1" ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, new web.siniestrado_codigoparam(remoteHandle, context).executeUdp( )) == 0 )
      {
         AV9ParmValue = "0" ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, httpContext.getMessage( "OS_DEF", "")) == 0 )
      {
         AV9ParmValue = httpContext.getMessage( "OPDEA", "") ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, new web.actividad_codigoparam(remoteHandle, context).executeUdp( )) == 0 )
      {
         AV9ParmValue = "49" ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, httpContext.getMessage( "PRO_DEF", "")) == 0 )
      {
         AV9ParmValue = "1" ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, httpContext.getMessage( "LOC_DEF", "")) == 0 )
      {
         AV9ParmValue = "394" ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, httpContext.getMessage( "NomDefExcCon", "")) == 0 )
      {
         AV9ParmValue = httpContext.getMessage( "Agrupado por Concepto", "") ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, httpContext.getMessage( "NomDefExcLeg", "")) == 0 )
      {
         AV9ParmValue = httpContext.getMessage( "Agrupado por Legajo", "") ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, httpContext.getMessage( "NomDefExcDet", "")) == 0 )
      {
         AV9ParmValue = httpContext.getMessage( "Liquidación Detallada", "") ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, httpContext.getMessage( "HOST_IMP_CONC", "")) == 0 )
      {
         AV9ParmValue = "127.0.0.1" ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, httpContext.getMessage( "PORT_IMP_CONC", "")) == 0 )
      {
         AV9ParmValue = "8080" ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, httpContext.getMessage( "BASEURL_IMP_CONC", "")) == 0 )
      {
         AV9ParmValue = httpContext.getMessage( "/SueldosConceptos/rest/WSGetConceptos", "") ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, httpContext.getMessage( "Conf_Title", "")) == 0 )
      {
         AV9ParmValue = httpContext.getMessage( "Configuración", "") ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, new web.monacoiconosugitems_codigoparam(remoteHandle, context).executeUdp( )) == 0 )
      {
         AV9ParmValue = httpContext.getMessage( "Keyword", "") ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, new web.monacoiconosugfunc_codigoparam(remoteHandle, context).executeUdp( )) == 0 )
      {
         AV9ParmValue = httpContext.getMessage( "Snippet", "") ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, new web.modalidad_codigoparam(remoteHandle, context).executeUdp( )) == 0 )
      {
         AV9ParmValue = "008" ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, httpContext.getMessage( "leg_ini_ejemplo", "")) == 0 )
      {
         AV9ParmValue = httpContext.getMessage( "PEPE01 José Soldán", "") ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, httpContext.getMessage( "expl_CAfip", "")) == 0 )
      {
         AV9ParmValue = httpContext.getMessage( "Para Generar el archivo de interfaz de AFIP que relaciona los conceptos del sistema con los códigos internos de AFIP, se deben parametrizar ciertos datos concepto por concepto, y al finalizar se generará un archivo TXT que deberá subir en la WEB de AFIP.", "") ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, httpContext.getMessage( "DEF_TLIQCOD", "")) == 0 )
      {
         AV9ParmValue = httpContext.getMessage( "MENSUAL", "") ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, httpContext.getMessage( "TIP_EMPL", "")) == 0 )
      {
         AV9ParmValue = "1" ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, new web.tipoliqanticipo_codigoparam(remoteHandle, context).executeUdp( )) == 0 )
      {
         AV9ParmValue = httpContext.getMessage( "ANTICIPO", "") ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, new web.tipoliqvarios_codigoparam(remoteHandle, context).executeUdp( )) == 0 )
      {
         GXt_char1 = AV9ParmValue ;
         GXv_char2[0] = GXt_char1 ;
         new web.codigovarios(remoteHandle, context).execute( GXv_char2) ;
         defaultparametros.this.GXt_char1 = GXv_char2[0] ;
         AV9ParmValue = GXt_char1 ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, new web.tipoliqaguinaldo_codigoparam(remoteHandle, context).executeUdp( )) == 0 )
      {
         GXt_char1 = AV9ParmValue ;
         GXv_char2[0] = GXt_char1 ;
         new web.codigoaguinaldo(remoteHandle, context).execute( GXv_char2) ;
         defaultparametros.this.GXt_char1 = GXv_char2[0] ;
         AV9ParmValue = GXt_char1 ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, new web.tipoliqmensual_codigoparam(remoteHandle, context).executeUdp( )) == 0 )
      {
         GXt_char1 = AV9ParmValue ;
         GXv_char2[0] = GXt_char1 ;
         new web.codigomensual(remoteHandle, context).execute( GXv_char2) ;
         defaultparametros.this.GXt_char1 = GXv_char2[0] ;
         AV9ParmValue = GXt_char1 ;
      }
      else if ( GXutil.strcmp(AV8ParmCod, new web.tipoliqquincena_codigoparam(remoteHandle, context).executeUdp( )) == 0 )
      {
         GXt_char1 = AV9ParmValue ;
         GXv_char2[0] = GXt_char1 ;
         new web.codigoquincena(remoteHandle, context).execute( GXv_char2) ;
         defaultparametros.this.GXt_char1 = GXv_char2[0] ;
         AV9ParmValue = GXt_char1 ;
      }
      if ( AV14grabar )
      {
         new web.grabaparametro(remoteHandle, context).execute( AV15CliCod, AV8ParmCod, AV9ParmValue, AV20ParmDescri) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = defaultparametros.this.AV9ParmValue;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9ParmValue = "" ;
      AV10sistema = "" ;
      AV12prefijoDED = "" ;
      AV28Pgmname = "" ;
      GXv_int4 = new short[1] ;
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      AV28Pgmname = "defaultParametros" ;
      /* GeneXus formulas. */
      AV28Pgmname = "defaultParametros" ;
      Gx_err = (short)(0) ;
   }

   private short GXt_int3 ;
   private short GXv_int4[] ;
   private short Gx_err ;
   private int AV15CliCod ;
   private String AV8ParmCod ;
   private String AV10sistema ;
   private String AV12prefijoDED ;
   private String AV28Pgmname ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private boolean AV14grabar ;
   private String AV9ParmValue ;
   private String AV20ParmDescri ;
   private String[] aP4 ;
}

