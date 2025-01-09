package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class validarconceptoini extends GXProcedure
{
   public validarconceptoini( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( validarconceptoini.class ), "" );
   }

   public validarconceptoini( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String aP3 ,
                             String aP4 ,
                             String aP5 ,
                             String[] aP6 )
   {
      validarconceptoini.this.aP7 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
      return aP7[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String aP2 ,
                        String aP3 ,
                        String aP4 ,
                        String aP5 ,
                        String[] aP6 ,
                        String[] aP7 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String aP3 ,
                             String aP4 ,
                             String aP5 ,
                             String[] aP6 ,
                             String[] aP7 )
   {
      validarconceptoini.this.AV16CliCod = aP0;
      validarconceptoini.this.AV9SubTipoConCod1 = aP1;
      validarconceptoini.this.AV25SubTipoConCod2 = aP2;
      validarconceptoini.this.AV12ConCodigo = aP3;
      validarconceptoini.this.AV14ConFormula = aP4;
      validarconceptoini.this.AV15ConDescrip = aP5;
      validarconceptoini.this.aP6 = aP6;
      validarconceptoini.this.aP7 = aP7;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_char1 = AV22devoGananciasAnioAnteriorConCodigo ;
      GXt_char2 = AV22devoGananciasAnioAnteriorConCodigo ;
      GXv_char3[0] = GXt_char2 ;
      new web.concepto_devoluciongananciasanioanterior_codigoparam(remoteHandle, context).execute( GXv_char3) ;
      validarconceptoini.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV16CliCod, GXt_char2, GXv_char4) ;
      validarconceptoini.this.GXt_char1 = GXv_char4[0] ;
      AV22devoGananciasAnioAnteriorConCodigo = GXt_char1 ;
      GXt_char2 = AV29liquidaSACConCodigo ;
      GXt_char1 = AV29liquidaSACConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.concepto_liquidasac_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      validarconceptoini.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV16CliCod, GXt_char1, GXv_char3) ;
      validarconceptoini.this.GXt_char2 = GXv_char3[0] ;
      AV29liquidaSACConCodigo = GXt_char2 ;
      GXt_char2 = AV57haberesSACConCodigo ;
      GXt_char1 = AV57haberesSACConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.concepto_haberessac_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      validarconceptoini.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV16CliCod, GXt_char1, GXv_char3) ;
      validarconceptoini.this.GXt_char2 = GXv_char3[0] ;
      AV57haberesSACConCodigo = GXt_char2 ;
      GXt_char2 = AV30alcanzaGananciasConCodigo ;
      GXt_char1 = AV30alcanzaGananciasConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.concepto_alcanzaganancias_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      validarconceptoini.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV16CliCod, GXt_char1, GXv_char3) ;
      validarconceptoini.this.GXt_char2 = GXv_char3[0] ;
      AV30alcanzaGananciasConCodigo = GXt_char2 ;
      GXt_char2 = AV52otrosEmpleosRemuGravConCodigo ;
      GXt_char1 = AV52otrosEmpleosRemuGravConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.otroemplremugrav_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      validarconceptoini.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV16CliCod, GXt_char1, GXv_char3) ;
      validarconceptoini.this.GXt_char2 = GXv_char3[0] ;
      AV52otrosEmpleosRemuGravConCodigo = GXt_char2 ;
      AV46ConCondicion = "A0" ;
      AV47ConCondCodigo = "" ;
      GXt_char2 = AV54descuentoAdelantoVacConDescrip ;
      GXv_char4[0] = GXt_char2 ;
      new web.descripdescuentoadelantovacaciones(remoteHandle, context).execute( GXv_char4) ;
      validarconceptoini.this.GXt_char2 = GXv_char4[0] ;
      AV54descuentoAdelantoVacConDescrip = GXt_char2 ;
      GXt_char2 = AV63sueldoBrutoSinSacIncluyendoOtrosEmpleos ;
      GXv_char4[0] = GXt_char2 ;
      new web.sueldobrutosinsacincluyendootrosempleos(remoteHandle, context).execute( GXv_char4) ;
      validarconceptoini.this.GXt_char2 = GXv_char4[0] ;
      AV63sueldoBrutoSinSacIncluyendoOtrosEmpleos = GXt_char2 ;
      GXt_char2 = AV64SueldoBrutoPromUltTramoConDescrip ;
      GXv_char4[0] = GXt_char2 ;
      new web.sueldobrutopromediosinsacultimotramo(remoteHandle, context).execute( GXv_char4) ;
      validarconceptoini.this.GXt_char2 = GXv_char4[0] ;
      AV64SueldoBrutoPromUltTramoConDescrip = GXt_char2 ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV68Pgmname, httpContext.getMessage( "&ConDescrip ", "")+AV15ConDescrip) ;
      GXt_char2 = AV65sueldoDescrip ;
      GXv_char4[0] = GXt_char2 ;
      new web.getsueldodescripconcepto(remoteHandle, context).execute( (int)(DecimalUtil.decToDouble(AV69Clicod_sistema)), GXv_char4) ;
      validarconceptoini.this.GXt_char2 = GXv_char4[0] ;
      AV65sueldoDescrip = GXt_char2 ;
      if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV15ConDescrip)), httpContext.getMessage( "ADICIONAL POR ZONA DESFAVORABLE", "")) == 0 )
      {
         AV46ConCondicion = "B24" ;
      }
      else if ( ( GXutil.strSearch( GXutil.upper( AV15ConDescrip), httpContext.getMessage( "ADICIONAL POR TÍTULO", ""), 1) != 0 ) && ( GXutil.strSearch( GXutil.upper( AV15ConDescrip), httpContext.getMessage( "HABILITANTE", ""), 1) == 0 ) )
      {
         AV46ConCondicion = "B23" ;
         AV47ConCondCodigo = "" ;
         if ( GXutil.strSearch( GXutil.upper( AV15ConDescrip), httpContext.getMessage( "TERCIARIO", ""), 1) != 0 )
         {
            AV47ConCondCodigo = httpContext.getMessage( "titulo_uni", "") ;
         }
         else if ( GXutil.strSearch( GXutil.upper( AV15ConDescrip), httpContext.getMessage( "SECUNDARIO TÉCNICO", ""), 1) != 0 )
         {
            AV47ConCondCodigo = httpContext.getMessage( "titulo_sec_tec", "") ;
         }
         else if ( GXutil.strSearch( GXutil.upper( AV15ConDescrip), httpContext.getMessage( "SECUNDARIO", ""), 1) != 0 )
         {
            AV47ConCondCodigo = httpContext.getMessage( "titulo_sec", "") ;
         }
      }
      else if ( GXutil.strcmp(AV15ConDescrip, AV65sueldoDescrip) == 0 )
      {
         AV46ConCondicion = "B16" ;
      }
      else if ( ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV15ConDescrip)), httpContext.getMessage( "BENEFICIO GUARDERÍA (DESCUENTO)", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV15ConDescrip)), httpContext.getMessage( "BENEFICIO GUARDERÍA", "")) == 0 ) )
      {
         AV46ConCondicion = "B15" ;
      }
      else if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV15ConDescrip)), httpContext.getMessage( "REINTEGRO DE GUARDERÍA", "")) == 0 )
      {
         AV46ConCondicion = "B14" ;
         AV47ConCondCodigo = httpContext.getMessage( "NRE016", "") ;
      }
      else if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV15ConDescrip)), httpContext.getMessage( "REDONDEO", "")) == 0 )
      {
         AV46ConCondicion = "R1" ;
      }
      else if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV15ConDescrip)), httpContext.getMessage( "ANTIGUEDAD", "")) == 0 )
      {
         AV46ConCondicion = "B12" ;
      }
      else if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV15ConDescrip)), httpContext.getMessage( "PRESENTISMO", "")) == 0 )
      {
         AV46ConCondicion = "B13" ;
      }
      else if ( ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV15ConDescrip)), httpContext.getMessage( "INDEMNIZACIÓN ANTIGUEDAD", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV15ConDescrip)), httpContext.getMessage( "INDEMNIZACIÓN SUSTITUTIVA DEL PREAVISO", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV15ConDescrip)), httpContext.getMessage( "SAC PREAVISO", "")) == 0 ) )
      {
         AV46ConCondicion = "B9" ;
      }
      else if ( GXutil.strcmp(GXutil.trim( AV15ConDescrip), httpContext.getMessage( "CÁLCULO SAC", "")) == 0 )
      {
         AV46ConCondicion = "B11" ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV68Pgmname, httpContext.getMessage( "detectó sac", "")) ;
      }
      else if ( ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV15ConDescrip)), httpContext.getMessage( "ALCANZA GANANCIAS", "")) == 0 ) || ( GXutil.strcmp(AV15ConDescrip, AV63sueldoBrutoSinSacIncluyendoOtrosEmpleos) == 0 ) || ( GXutil.strcmp(AV15ConDescrip, AV64SueldoBrutoPromUltTramoConDescrip) == 0 ) )
      {
         AV46ConCondicion = "A13" ;
      }
      else if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV15ConDescrip)), httpContext.getMessage( "LICENCIA SIN GOCE DE SUELDO", "")) == 0 )
      {
         AV46ConCondicion = "B7" ;
      }
      else if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV15ConDescrip)), httpContext.getMessage( "AUSENCIAS INJUSTIFICADAS", "")) == 0 )
      {
         AV46ConCondicion = "AI" ;
      }
      else if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV15ConDescrip)), httpContext.getMessage( "DÍAS NO TRABAJADOS POR MES PARCIAL", "")) == 0 )
      {
         AV46ConCondicion = "MI" ;
      }
      else if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV15ConDescrip)), httpContext.getMessage( "PLUS LICENCIA", "")) == 0 )
      {
         AV46ConCondicion = "B4" ;
      }
      else if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV15ConDescrip)), httpContext.getMessage( "PLUS VACACIONES", "")) == 0 )
      {
         AV46ConCondicion = "VP" ;
      }
      else if ( ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV15ConDescrip)), httpContext.getMessage( "BASE IMPONIBLE 2 - CONTRIBUCIONES SIPA E INSSJYP", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV15ConDescrip)), httpContext.getMessage( "BASE IMPONIBLE 3 - CONTRIBUCIONES FNE, AAFF, Y RENATRE", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV15ConDescrip)), httpContext.getMessage( "BASE IMPONIBLE 8 - CONTRIBUCIONES OS Y FSR", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV15ConDescrip)), httpContext.getMessage( "BASE IMPONIBLE 9 - CONTRIBUCIONES LRT", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV15ConDescrip)), httpContext.getMessage( "IMPORTE A DETRAER", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV15ConDescrip)), httpContext.getMessage( "BASE IMPONIBLE 10", "")) == 0 ) )
      {
         AV46ConCondicion = "N01" ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV68Pgmname, httpContext.getMessage( "nunca 1", "")) ;
      }
      else if ( ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV15ConDescrip)), httpContext.getMessage( "BASE IMPONIBLE 6 - APORTES DIFERENCIALES", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV15ConDescrip)), httpContext.getMessage( "BASE IMPONIBLE 7 - APORTES PERSONAL REGIMENES ESPECIALES", "")) == 0 ) )
      {
         AV46ConCondicion = "N01" ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV68Pgmname, httpContext.getMessage( "nunca 2", "")) ;
      }
      else if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV15ConDescrip)), httpContext.getMessage( "ADELANTO RETENCIÓN GANANCIAS", "")) == 0 )
      {
         AV46ConCondicion = "A5" ;
      }
      else if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV15ConDescrip)), httpContext.getMessage( "BASE IMPONIBLE ADELANTO VACACIONES MES PRÓXIMO", "")) == 0 )
      {
         AV46ConCondicion = "A1" ;
         GXt_char2 = AV47ConCondCodigo ;
         GXt_char1 = AV47ConCondCodigo ;
         GXv_char4[0] = GXt_char1 ;
         new web.concepto_adelantovacaciones_codigoparam(remoteHandle, context).execute( GXv_char4) ;
         validarconceptoini.this.GXt_char1 = GXv_char4[0] ;
         GXv_char3[0] = GXt_char2 ;
         new web.getparametro(remoteHandle, context).execute( AV16CliCod, GXt_char1, GXv_char3) ;
         validarconceptoini.this.GXt_char2 = GXv_char3[0] ;
         AV47ConCondCodigo = GXt_char2 ;
      }
      else if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV15ConDescrip)), httpContext.getMessage( "CUOTA ALIMENTARIA", "")) == 0 )
      {
         AV46ConCondicion = "B3" ;
         AV47ConCondCodigo = httpContext.getMessage( "cuota_alimentaria", "") ;
      }
      else if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV15ConDescrip)), httpContext.getMessage( "EMBARGO EJECUTIVO", "")) == 0 )
      {
         AV46ConCondicion = "B3" ;
         AV47ConCondCodigo = httpContext.getMessage( "embargo_comun", "") ;
      }
      else if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV15ConDescrip)), httpContext.getMessage( "EMBARGO JUDICIAL", "")) == 0 )
      {
         AV46ConCondicion = "B3" ;
         AV47ConCondCodigo = httpContext.getMessage( "embargo_otros", "") ;
      }
      else if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV15ConDescrip)), httpContext.getMessage( "CUOTA DESCUENTO POR ANTICIPO", "")) == 0 )
      {
         AV46ConCondicion = "B3" ;
         AV47ConCondCodigo = httpContext.getMessage( "anticipo", "") ;
      }
      else if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV15ConDescrip)), httpContext.getMessage( "OBRA SOCIAL ADHERENTE", "")) == 0 )
      {
         AV46ConCondicion = "A9" ;
      }
      else if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV15ConDescrip)), httpContext.getMessage( "CUOTA SINDICAL", "")) == 0 )
      {
         AV46ConCondicion = "A10" ;
      }
      else if ( ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV15ConDescrip)), httpContext.getMessage( "OBRA SOCIAL DIFERENCIAL", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV15ConDescrip)), httpContext.getMessage( "BASE DE CÁLCULO DIFERENCIAL APORTES OS Y FSR", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV15ConDescrip)), httpContext.getMessage( "BASE DE CÁLCULO DIFERENCIAL CONTRIBUCIÓN OS Y FSR", "")) == 0 ) )
      {
         AV46ConCondicion = "A11" ;
      }
      else if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV15ConDescrip)), httpContext.getMessage( "APORTE ADICIONAL OBRA SOCIAL", "")) == 0 )
      {
         AV46ConCondicion = "A12" ;
      }
      else if ( ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV15ConDescrip)), httpContext.getMessage( "LEY 19032", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV15ConDescrip)), httpContext.getMessage( "OBRA SOCIAL", "")) == 0 ) )
      {
         AV46ConCondicion = "A3" ;
      }
      else if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV15ConDescrip)), httpContext.getMessage( "JUBILACIÓN", "")) == 0 )
      {
         AV46ConCondicion = "LA" ;
      }
      else if ( GXutil.strcmp(AV9SubTipoConCod1, new web.subtipocontribucion(remoteHandle, context).executeUdp( )) == 0 )
      {
         AV46ConCondicion = "N01" ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV68Pgmname, httpContext.getMessage( "nunca 3", "")) ;
      }
      else if ( ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV15ConDescrip)), httpContext.getMessage( "FERIADOS NO TRABAJADOS", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV15ConDescrip)), httpContext.getMessage( "NO LABORABLES NO TRABAJADOS", "")) == 0 ) )
      {
         if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV15ConDescrip)), httpContext.getMessage( "FERIADOS NO TRABAJADOS", "")) == 0 )
         {
            AV46ConCondicion = "B5" ;
         }
         else
         {
            AV46ConCondicion = "B6" ;
         }
      }
      else if ( ( GXutil.strcmp(GXutil.trim( AV15ConDescrip), GXutil.trim( AV54descuentoAdelantoVacConDescrip)) == 0 ) || ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV15ConDescrip)), httpContext.getMessage( "DESCUENTO POR ANTICIPO", "")) == 0 ) )
      {
         AV46ConCondicion = "A4" ;
         if ( GXutil.strcmp(GXutil.trim( AV15ConDescrip), GXutil.trim( AV54descuentoAdelantoVacConDescrip)) == 0 )
         {
            GXt_char2 = AV47ConCondCodigo ;
            GXt_char1 = AV47ConCondCodigo ;
            GXv_char4[0] = GXt_char1 ;
            new web.tipoliqvacaciones_codigoparam(remoteHandle, context).execute( GXv_char4) ;
            validarconceptoini.this.GXt_char1 = GXv_char4[0] ;
            GXv_char3[0] = GXt_char2 ;
            new web.getparametro(remoteHandle, context).execute( AV16CliCod, GXt_char1, GXv_char3) ;
            validarconceptoini.this.GXt_char2 = GXv_char3[0] ;
            AV47ConCondCodigo = GXt_char2 ;
         }
         else
         {
            GXt_char2 = AV47ConCondCodigo ;
            GXt_char1 = AV47ConCondCodigo ;
            GXv_char4[0] = GXt_char1 ;
            new web.tipoliqanticipo_codigoparam(remoteHandle, context).execute( GXv_char4) ;
            validarconceptoini.this.GXt_char1 = GXv_char4[0] ;
            GXv_char3[0] = GXt_char2 ;
            new web.getparametro(remoteHandle, context).execute( AV16CliCod, GXt_char1, GXv_char3) ;
            validarconceptoini.this.GXt_char2 = GXv_char3[0] ;
            AV47ConCondCodigo = GXt_char2 ;
         }
      }
      else if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV15ConDescrip)), httpContext.getMessage( "LICENCIA POR MATERNIDAD (DESCUENTO)", "")) == 0 )
      {
         AV46ConCondicion = "B1" ;
         AV47ConCondCodigo = "5" ;
      }
      else if ( ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV15ConDescrip)), httpContext.getMessage( "BASE IMPONIBLE SAC", "")) == 0 ) || ( ( GXutil.strcmp(AV12ConCodigo, AV29liquidaSACConCodigo) != 0 ) && ( GXutil.strcmp(AV12ConCodigo, AV57haberesSACConCodigo) != 0 ) && ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV15ConDescrip)), httpContext.getMessage( "DÍAS PARA PROPORCIONAR SAC", "")) != 0 ) && ( new web.conceptoessac(remoteHandle, context).executeUdp( AV9SubTipoConCod1) ) ) )
      {
         AV46ConCondicion = "B10" ;
      }
      else if ( ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV15ConDescrip)), httpContext.getMessage( "RETENCIÓN DE GANANCIAS AÑO ANTERIOR F1357", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV15ConDescrip)), httpContext.getMessage( "DEVOLUCIÓN DE GANANCIAS AÑO ANTERIOR F1357", "")) == 0 ) )
      {
         AV46ConCondicion = "A8" ;
         AV47ConCondCodigo = "" ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV68Pgmname, "6") ;
      }
      else if ( ( GXutil.strcmp(AV12ConCodigo, AV30alcanzaGananciasConCodigo) != 0 ) && ( ( GXutil.strcmp(AV9SubTipoConCod1, new web.subtipocalculoganancias(remoteHandle, context).executeUdp( )) == 0 ) || ( GXutil.strcmp(AV9SubTipoConCod1, new web.subtipoganancias(remoteHandle, context).executeUdp( )) == 0 ) || ( GXutil.strcmp(AV12ConCodigo, new web.conceptodevolucionganancias(remoteHandle, context).executeUdp( AV16CliCod)) == 0 ) ) )
      {
         if ( GXutil.strcmp(AV12ConCodigo, AV52otrosEmpleosRemuGravConCodigo) == 0 )
         {
            AV46ConCondicion = "B2" ;
            GXt_char2 = AV47ConCondCodigo ;
            GXt_char1 = AV47ConCondCodigo ;
            GXv_char4[0] = GXt_char1 ;
            new web.otroemplgananciabruta_codigoparam(remoteHandle, context).execute( GXv_char4) ;
            validarconceptoini.this.GXt_char1 = GXv_char4[0] ;
            GXv_char3[0] = GXt_char2 ;
            new web.getparametro(remoteHandle, context).execute( AV16CliCod, GXt_char1, GXv_char3) ;
            validarconceptoini.this.GXt_char2 = GXv_char3[0] ;
            AV47ConCondCodigo = GXt_char2 ;
         }
         else
         {
            if ( ( GXutil.strcmp(GXutil.trim( AV15ConDescrip), httpContext.getMessage( "GANANCIA NETA PARA TOPES", "")) != 0 ) && ( ( GXutil.strcmp(AV25SubTipoConCod2, new web.subtipo2deduccionesgenerales(remoteHandle, context).executeUdp( )) == 0 ) || ( GXutil.strcmp(AV25SubTipoConCod2, new web.subtipo2deduccionesgeneralesanuales(remoteHandle, context).executeUdp( )) == 0 ) || ( GXutil.strcmp(AV25SubTipoConCod2, new web.subtipo2otrosempleos(remoteHandle, context).executeUdp( )) == 0 ) || ( GXutil.strcmp(AV25SubTipoConCod2, new web.subtipo2gananciastopes(remoteHandle, context).executeUdp( )) == 0 ) ) )
            {
               Cond_result = true ;
            }
            else
            {
               Cond_result = false ;
            }
            if ( Cond_result )
            {
               AV38LegDedConCodigo = "" ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV68Pgmname, httpContext.getMessage( "es deduccion", "")) ;
               if ( GXutil.strcmp(AV25SubTipoConCod2, new web.subtipo2gananciastopes(remoteHandle, context).executeUdp( )) == 0 )
               {
                  Cond_result = true ;
               }
               else
               {
                  Cond_result = false ;
               }
               if ( Cond_result )
               {
                  GXt_char2 = AV39topeDonacionesConCodigo ;
                  GXt_char1 = AV39topeDonacionesConCodigo ;
                  GXv_char4[0] = GXt_char1 ;
                  new web.concepto_topedonaciones_codigoparam(remoteHandle, context).execute( GXv_char4) ;
                  validarconceptoini.this.GXt_char1 = GXv_char4[0] ;
                  GXv_char3[0] = GXt_char2 ;
                  new web.getparametro(remoteHandle, context).execute( AV16CliCod, GXt_char1, GXv_char3) ;
                  validarconceptoini.this.GXt_char2 = GXv_char3[0] ;
                  AV39topeDonacionesConCodigo = GXt_char2 ;
                  GXt_char2 = AV40donacionesConCodigo ;
                  GXt_char1 = AV40donacionesConCodigo ;
                  GXv_char4[0] = GXt_char1 ;
                  new web.concepto_deddonaciones_codigoparam(remoteHandle, context).execute( GXv_char4) ;
                  validarconceptoini.this.GXt_char1 = GXv_char4[0] ;
                  GXv_char3[0] = GXt_char2 ;
                  new web.getparametro(remoteHandle, context).execute( AV16CliCod, GXt_char1, GXv_char3) ;
                  validarconceptoini.this.GXt_char2 = GXv_char3[0] ;
                  AV40donacionesConCodigo = GXt_char2 ;
                  GXt_char2 = AV41topePrepagaConCodigo ;
                  GXt_char1 = AV41topePrepagaConCodigo ;
                  GXv_char4[0] = GXt_char1 ;
                  new web.concepto_topeprepaga_codigoparam(remoteHandle, context).execute( GXv_char4) ;
                  validarconceptoini.this.GXt_char1 = GXv_char4[0] ;
                  GXv_char3[0] = GXt_char2 ;
                  new web.getparametro(remoteHandle, context).execute( AV16CliCod, GXt_char1, GXv_char3) ;
                  validarconceptoini.this.GXt_char2 = GXv_char3[0] ;
                  AV41topePrepagaConCodigo = GXt_char2 ;
                  GXt_char2 = AV42prepagaConCodigo ;
                  GXt_char1 = AV42prepagaConCodigo ;
                  GXv_char4[0] = GXt_char1 ;
                  new web.concepto_dedprepaga_codigoparam(remoteHandle, context).execute( GXv_char4) ;
                  validarconceptoini.this.GXt_char1 = GXv_char4[0] ;
                  GXv_char3[0] = GXt_char2 ;
                  new web.getparametro(remoteHandle, context).execute( AV16CliCod, GXt_char1, GXv_char3) ;
                  validarconceptoini.this.GXt_char2 = GXv_char3[0] ;
                  AV42prepagaConCodigo = GXt_char2 ;
                  GXt_char2 = AV43topeMedicosConCodigo ;
                  GXt_char1 = AV43topeMedicosConCodigo ;
                  GXv_char4[0] = GXt_char1 ;
                  new web.concepto_topemedicos_codigoparam(remoteHandle, context).execute( GXv_char4) ;
                  validarconceptoini.this.GXt_char1 = GXv_char4[0] ;
                  GXv_char3[0] = GXt_char2 ;
                  new web.getparametro(remoteHandle, context).execute( AV16CliCod, GXt_char1, GXv_char3) ;
                  validarconceptoini.this.GXt_char2 = GXv_char3[0] ;
                  AV43topeMedicosConCodigo = GXt_char2 ;
                  GXt_char2 = AV44medicosConCodigo ;
                  GXt_char1 = AV44medicosConCodigo ;
                  GXv_char4[0] = GXt_char1 ;
                  new web.concepto_honomedi_codigoparam(remoteHandle, context).execute( GXv_char4) ;
                  validarconceptoini.this.GXt_char1 = GXv_char4[0] ;
                  GXv_char3[0] = GXt_char2 ;
                  new web.getparametro(remoteHandle, context).execute( AV16CliCod, GXt_char1, GXv_char3) ;
                  validarconceptoini.this.GXt_char2 = GXv_char3[0] ;
                  AV44medicosConCodigo = GXt_char2 ;
                  if ( GXutil.strcmp(AV12ConCodigo, AV39topeDonacionesConCodigo) == 0 )
                  {
                     AV38LegDedConCodigo = AV40donacionesConCodigo ;
                  }
                  else if ( GXutil.strcmp(AV12ConCodigo, AV41topePrepagaConCodigo) == 0 )
                  {
                     AV38LegDedConCodigo = AV42prepagaConCodigo ;
                  }
                  else if ( GXutil.strcmp(AV12ConCodigo, AV43topeMedicosConCodigo) == 0 )
                  {
                     AV38LegDedConCodigo = AV44medicosConCodigo ;
                  }
                  if ( ! (GXutil.strcmp("", AV38LegDedConCodigo)==0) )
                  {
                     Cond_result = true ;
                  }
                  else
                  {
                     Cond_result = false ;
                  }
                  if ( Cond_result )
                  {
                     AV46ConCondicion = "B2" ;
                     AV47ConCondCodigo = GXutil.trim( AV38LegDedConCodigo) ;
                  }
               }
               else
               {
                  AV46ConCondicion = "B2" ;
                  AV47ConCondCodigo = GXutil.trim( AV12ConCodigo) ;
               }
            }
            else
            {
               AV46ConCondicion = "A14" ;
            }
         }
         new web.msgdebug_prod(remoteHandle, context).execute( AV68Pgmname, httpContext.getMessage( "3 &validar ", "")+GXutil.trim( GXutil.booltostr( AV8validar))) ;
      }
      else if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV15ConDescrip)), httpContext.getMessage( "DÍAS NO TRABAJADOS POR VACACIONES", "")) == 0 )
      {
         AV46ConCondicion = "B19" ;
      }
      else if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV15ConDescrip)), httpContext.getMessage( "DÍAS NO TRABAJADOS POR LICENCIA", "")) == 0 )
      {
         AV46ConCondicion = "B20" ;
      }
      else if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV15ConDescrip)), httpContext.getMessage( "DÍAS NO TRABAJADOS POR FERIADO", "")) == 0 )
      {
         AV46ConCondicion = "B21" ;
      }
      else if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV15ConDescrip)), httpContext.getMessage( "DÍAS NO TRABAJADOS POR NO LABORABLES", "")) == 0 )
      {
         AV46ConCondicion = "B22" ;
      }
      else if ( ! (GXutil.strcmp("", AV15ConDescrip)==0) && ( ( GXutil.strSearch( AV15ConDescrip, httpContext.getMessage( "LICENCIA POR", ""), 1) != 0 ) || ( GXutil.strSearch( AV15ConDescrip, httpContext.getMessage( "TEMPORARIA", ""), 1) != 0 ) || ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV15ConDescrip)), httpContext.getMessage( "VACACIONES", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV15ConDescrip)), httpContext.getMessage( "RESERVA DE PUESTO", "")) == 0 ) ) && ( GXutil.strSearch( AV15ConDescrip, httpContext.getMessage( "DESCUENTO", ""), 1) == 0 ) )
      {
         AV46ConCondicion = "B1" ;
         if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV15ConDescrip)), httpContext.getMessage( "LICENCIA POR EXCEDENCIA", "")) == 0 )
         {
            AV47ConCondCodigo = "10" ;
         }
         else if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV15ConDescrip)), httpContext.getMessage( "VACACIONES", "")) == 0 )
         {
            AV47ConCondCodigo = "12" ;
         }
         else if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV15ConDescrip)), httpContext.getMessage( "LICENCIA POR ESTUDIO", "")) == 0 )
         {
            AV47ConCondCodigo = httpContext.getMessage( "E2", "") ;
         }
         else if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV15ConDescrip)), httpContext.getMessage( "LICENCIA POR MATRIMONIO", "")) == 0 )
         {
            AV47ConCondCodigo = httpContext.getMessage( "M1", "") ;
         }
         else if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV15ConDescrip)), httpContext.getMessage( "LICENCIA POR ENFERMEDAD", "")) == 0 )
         {
            AV47ConCondCodigo = httpContext.getMessage( "E1", "") ;
         }
         else if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV15ConDescrip)), httpContext.getMessage( "LICENCIA POR NACIMIENTO", "")) == 0 )
         {
            AV47ConCondCodigo = "32" ;
         }
         else if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV15ConDescrip)), httpContext.getMessage( "LICENCIA POR MATERNIDAD", "")) == 0 )
         {
            AV47ConCondCodigo = "5" ;
         }
         else if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV15ConDescrip)), httpContext.getMessage( "INCAPACIDAD LABORAL TEMPORARIA (PRIMEROS 10 DÍAS)", "")) == 0 )
         {
            AV47ConCondCodigo = "18" ;
         }
         else if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV15ConDescrip)), httpContext.getMessage( "LICENCIA POR FALLECIMIENTO DE FAMILIAR", "")) == 0 )
         {
            AV47ConCondCodigo = httpContext.getMessage( "F1", "") ;
         }
         else if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV15ConDescrip)), httpContext.getMessage( "LICENCIA POR DONACIÓN DE SANGRE", "")) == 0 )
         {
            AV47ConCondCodigo = httpContext.getMessage( "D1", "") ;
         }
         else if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV15ConDescrip)), httpContext.getMessage( "LICENCIA POR TRAMITE PREMATRIMONIAL", "")) == 0 )
         {
            AV47ConCondCodigo = httpContext.getMessage( "M2", "") ;
         }
         else if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV15ConDescrip)), httpContext.getMessage( "INCAPACIDAD LABORAL TEMPORARIA (POR ART)", "")) == 0 )
         {
            AV47ConCondCodigo = "19" ;
         }
         else if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV15ConDescrip)), httpContext.getMessage( "LICENCIA POR MUDANZA", "")) == 0 )
         {
            AV47ConCondCodigo = httpContext.getMessage( "M3", "") ;
         }
         else if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV15ConDescrip)), httpContext.getMessage( "LICENCIA POR CAUSAS PARTICULARES", "")) == 0 )
         {
            AV47ConCondCodigo = httpContext.getMessage( "LP", "") ;
         }
         else if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV15ConDescrip)), httpContext.getMessage( "RESERVA DE PUESTO", "")) == 0 )
         {
            AV47ConCondCodigo = "14" ;
         }
         new web.msgdebug_prod(remoteHandle, context).execute( AV68Pgmname, "5") ;
      }
      else
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV68Pgmname, "8") ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP6[0] = validarconceptoini.this.AV46ConCondicion;
      this.aP7[0] = validarconceptoini.this.AV47ConCondCodigo;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV46ConCondicion = "" ;
      AV47ConCondCodigo = "" ;
      AV22devoGananciasAnioAnteriorConCodigo = "" ;
      AV29liquidaSACConCodigo = "" ;
      AV57haberesSACConCodigo = "" ;
      AV30alcanzaGananciasConCodigo = "" ;
      AV52otrosEmpleosRemuGravConCodigo = "" ;
      AV54descuentoAdelantoVacConDescrip = "" ;
      AV63sueldoBrutoSinSacIncluyendoOtrosEmpleos = "" ;
      AV64SueldoBrutoPromUltTramoConDescrip = "" ;
      AV68Pgmname = "" ;
      AV65sueldoDescrip = "" ;
      AV69Clicod_sistema = DecimalUtil.ZERO ;
      AV38LegDedConCodigo = "" ;
      AV39topeDonacionesConCodigo = "" ;
      AV40donacionesConCodigo = "" ;
      AV41topePrepagaConCodigo = "" ;
      AV42prepagaConCodigo = "" ;
      AV43topeMedicosConCodigo = "" ;
      AV44medicosConCodigo = "" ;
      GXt_char2 = "" ;
      GXt_char1 = "" ;
      GXv_char4 = new String[1] ;
      GXv_char3 = new String[1] ;
      AV68Pgmname = "validarConceptoIni" ;
      /* GeneXus formulas. */
      AV68Pgmname = "validarConceptoIni" ;
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV16CliCod ;
   private java.math.BigDecimal AV69Clicod_sistema ;
   private String AV9SubTipoConCod1 ;
   private String AV25SubTipoConCod2 ;
   private String AV12ConCodigo ;
   private String AV46ConCondicion ;
   private String AV47ConCondCodigo ;
   private String AV22devoGananciasAnioAnteriorConCodigo ;
   private String AV29liquidaSACConCodigo ;
   private String AV57haberesSACConCodigo ;
   private String AV30alcanzaGananciasConCodigo ;
   private String AV52otrosEmpleosRemuGravConCodigo ;
   private String AV68Pgmname ;
   private String AV38LegDedConCodigo ;
   private String AV39topeDonacionesConCodigo ;
   private String AV40donacionesConCodigo ;
   private String AV41topePrepagaConCodigo ;
   private String AV42prepagaConCodigo ;
   private String AV43topeMedicosConCodigo ;
   private String AV44medicosConCodigo ;
   private String GXt_char2 ;
   private String GXt_char1 ;
   private String GXv_char4[] ;
   private String GXv_char3[] ;
   private boolean Cond_result ;
   private boolean AV8validar ;
   private String AV14ConFormula ;
   private String AV15ConDescrip ;
   private String AV54descuentoAdelantoVacConDescrip ;
   private String AV63sueldoBrutoSinSacIncluyendoOtrosEmpleos ;
   private String AV64SueldoBrutoPromUltTramoConDescrip ;
   private String AV65sueldoDescrip ;
   private String[] aP7 ;
   private String[] aP6 ;
}

