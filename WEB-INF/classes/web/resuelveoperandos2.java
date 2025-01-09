package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class resuelveoperandos2 extends GXProcedure
{
   public resuelveoperandos2( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( resuelveoperandos2.class ), "" );
   }

   public resuelveoperandos2( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              int aP2 ,
                              int aP3 ,
                              int aP4 ,
                              String aP5 ,
                              java.util.Date aP6 ,
                              int aP7 ,
                              String aP8 ,
                              String aP9 ,
                              String aP10 ,
                              boolean aP11 ,
                              boolean aP12 ,
                              java.math.BigDecimal aP13 ,
                              java.util.Date aP14 ,
                              GXBaseCollection<web.SdtSDTOperandosFormula>[] aP15 ,
                              boolean[] aP16 ,
                              String[] aP17 ,
                              java.math.BigDecimal[] aP18 ,
                              boolean[] aP19 ,
                              java.math.BigDecimal[] aP20 ,
                              java.math.BigDecimal[] aP21 ,
                              boolean[] aP22 ,
                              String[] aP23 ,
                              java.math.BigDecimal[] aP24 )
   {
      resuelveoperandos2.this.aP25 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17, aP18, aP19, aP20, aP21, aP22, aP23, aP24, aP25);
      return aP25[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        int aP4 ,
                        String aP5 ,
                        java.util.Date aP6 ,
                        int aP7 ,
                        String aP8 ,
                        String aP9 ,
                        String aP10 ,
                        boolean aP11 ,
                        boolean aP12 ,
                        java.math.BigDecimal aP13 ,
                        java.util.Date aP14 ,
                        GXBaseCollection<web.SdtSDTOperandosFormula>[] aP15 ,
                        boolean[] aP16 ,
                        String[] aP17 ,
                        java.math.BigDecimal[] aP18 ,
                        boolean[] aP19 ,
                        java.math.BigDecimal[] aP20 ,
                        java.math.BigDecimal[] aP21 ,
                        boolean[] aP22 ,
                        String[] aP23 ,
                        java.math.BigDecimal[] aP24 ,
                        boolean[] aP25 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17, aP18, aP19, aP20, aP21, aP22, aP23, aP24, aP25);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             int aP4 ,
                             String aP5 ,
                             java.util.Date aP6 ,
                             int aP7 ,
                             String aP8 ,
                             String aP9 ,
                             String aP10 ,
                             boolean aP11 ,
                             boolean aP12 ,
                             java.math.BigDecimal aP13 ,
                             java.util.Date aP14 ,
                             GXBaseCollection<web.SdtSDTOperandosFormula>[] aP15 ,
                             boolean[] aP16 ,
                             String[] aP17 ,
                             java.math.BigDecimal[] aP18 ,
                             boolean[] aP19 ,
                             java.math.BigDecimal[] aP20 ,
                             java.math.BigDecimal[] aP21 ,
                             boolean[] aP22 ,
                             String[] aP23 ,
                             java.math.BigDecimal[] aP24 ,
                             boolean[] aP25 )
   {
      resuelveoperandos2.this.AV25CliCod = aP0;
      resuelveoperandos2.this.AV54EmpCod = aP1;
      resuelveoperandos2.this.AV84LiqNro = aP2;
      resuelveoperandos2.this.AV182LiqRelNro = aP3;
      resuelveoperandos2.this.AV79LegNumero = aP4;
      resuelveoperandos2.this.AV129TLiqCod = aP5;
      resuelveoperandos2.this.AV168parmLiqPeriodo = aP6;
      resuelveoperandos2.this.AV149ActualLiqNro = aP7;
      resuelveoperandos2.this.AV30ConCodigo = aP8;
      resuelveoperandos2.this.AV145ProcesoLiquidacion = aP9;
      resuelveoperandos2.this.AV180llamador = aP10;
      resuelveoperandos2.this.AV147insertandoConceptos = aP11;
      resuelveoperandos2.this.AV159simulacionEs = aP12;
      resuelveoperandos2.this.AV161LiqDCanti = aP13;
      resuelveoperandos2.this.AV176DAgeFecDes = aP14;
      resuelveoperandos2.this.AV122SDTOperandos = aP15[0];
      this.aP15 = aP15;
      resuelveoperandos2.this.aP16 = aP16;
      resuelveoperandos2.this.aP17 = aP17;
      resuelveoperandos2.this.aP18 = aP18;
      resuelveoperandos2.this.aP19 = aP19;
      resuelveoperandos2.this.aP20 = aP20;
      resuelveoperandos2.this.aP21 = aP21;
      resuelveoperandos2.this.aP22 = aP22;
      resuelveoperandos2.this.aP23 = aP23;
      resuelveoperandos2.this.aP24 = aP24;
      resuelveoperandos2.this.aP25 = aP25;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod2(remoteHandle, context).execute( AV25CliCod, AV185Pgmname, httpContext.getMessage( "#*1 &concodigo ", "")+GXutil.trim( AV30ConCodigo)) ;
      AV40dependenciasResueltas = true ;
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV168parmLiqPeriodo)) )
      {
         AV85LiqPeriodo = AV168parmLiqPeriodo ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV25CliCod, AV185Pgmname, httpContext.getMessage( "saca de parametro ", "")+GXutil.trim( localUtil.dtoc( AV168parmLiqPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
      }
      else
      {
         if ( ! (0==AV84LiqNro) )
         {
            GXv_date1[0] = AV85LiqPeriodo ;
            new web.getperiodoliquidacion(remoteHandle, context).execute( AV25CliCod, AV54EmpCod, AV84LiqNro, GXv_date1) ;
            resuelveoperandos2.this.AV85LiqPeriodo = GXv_date1[0] ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV25CliCod, AV185Pgmname, httpContext.getMessage( "saca de proc ", "")+GXutil.trim( localUtil.dtoc( AV85LiqPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
         }
         else
         {
            AV85LiqPeriodo = GXutil.serverDate( context, remoteHandle, pr_default) ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV25CliCod, AV185Pgmname, httpContext.getMessage( "saca de server date ", "")+GXutil.trim( localUtil.dtoc( AV85LiqPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
         }
      }
      new web.msgdebug_prod2(remoteHandle, context).execute( AV25CliCod, AV185Pgmname, httpContext.getMessage( "&SDTOperandos ", "")+AV122SDTOperandos.toJSonString(false)) ;
      AV186GXV1 = 1 ;
      while ( AV186GXV1 <= AV122SDTOperandos.size() )
      {
         AV123SDTOperandosItem = (web.SdtSDTOperandosFormula)((web.SdtSDTOperandosFormula)AV122SDTOperandos.elementAt(-1+AV186GXV1));
         GXt_dtime2 = AV172comienzo2 ;
         GXv_dtime3[0] = GXt_dtime2 ;
         new web.getahora(remoteHandle, context).execute( AV25CliCod, GXv_dtime3) ;
         resuelveoperandos2.this.GXt_dtime2 = GXv_dtime3[0] ;
         AV172comienzo2 = GXt_dtime2 ;
         if ( (GXutil.strcmp("", AV123SDTOperandosItem.getgxTv_SdtSDTOperandosFormula_Operandocambiado())==0) )
         {
            GXv_char4[0] = AV94Operando ;
            GXv_char5[0] = AV117primeraPalabra ;
            new web.opeformulaapalabramayuscula(remoteHandle, context).execute( AV123SDTOperandosItem.getgxTv_SdtSDTOperandosFormula_Operandooriginal(), GXv_char4, GXv_char5) ;
            resuelveoperandos2.this.AV94Operando = GXv_char4[0] ;
            resuelveoperandos2.this.AV117primeraPalabra = GXv_char5[0] ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV25CliCod, AV185Pgmname, httpContext.getMessage( "&LiqPeriodo ", "")+GXutil.trim( localUtil.dtoc( AV85LiqPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
            GXv_SdtSDTOperandosFormula6[0] = AV123SDTOperandosItem;
            GXv_boolean7[0] = AV39dependenciaResuelta ;
            GXv_char5[0] = AV160operandoError ;
            GXv_decimal8[0] = AV154AuxConOpeEsCant ;
            GXv_boolean9[0] = AV175AuxAlicuotaEs ;
            GXv_decimal10[0] = AV156cantidadCalculadaAux ;
            GXv_decimal11[0] = AV163baseImportesAux ;
            GXv_boolean12[0] = AV166alMenos1CalculoHay ;
            GXv_char4[0] = AV165auxLiqDLog ;
            GXv_decimal13[0] = AV177auxLiqDPlus ;
            GXv_boolean14[0] = AV178auxDependenciaConceptoEs ;
            new web.resuelveoperando(remoteHandle, context).execute( AV25CliCod, AV54EmpCod, AV84LiqNro, AV182LiqRelNro, AV79LegNumero, AV129TLiqCod, AV149ActualLiqNro, AV30ConCodigo, AV94Operando, AV117primeraPalabra, AV145ProcesoLiquidacion, AV180llamador, AV147insertandoConceptos, AV159simulacionEs, GXv_SdtSDTOperandosFormula6, AV85LiqPeriodo, AV148ActualLiqPeriodo, AV161LiqDCanti, AV176DAgeFecDes, GXv_boolean7, GXv_char5, GXv_decimal8, GXv_boolean9, GXv_decimal10, GXv_decimal11, GXv_boolean12, GXv_char4, GXv_decimal13, GXv_boolean14) ;
            AV123SDTOperandosItem = GXv_SdtSDTOperandosFormula6[0] ;
            resuelveoperandos2.this.AV39dependenciaResuelta = GXv_boolean7[0] ;
            resuelveoperandos2.this.AV160operandoError = GXv_char5[0] ;
            resuelveoperandos2.this.AV154AuxConOpeEsCant = GXv_decimal8[0] ;
            resuelveoperandos2.this.AV175AuxAlicuotaEs = GXv_boolean9[0] ;
            resuelveoperandos2.this.AV156cantidadCalculadaAux = GXv_decimal10[0] ;
            resuelveoperandos2.this.AV163baseImportesAux = GXv_decimal11[0] ;
            resuelveoperandos2.this.AV166alMenos1CalculoHay = GXv_boolean12[0] ;
            resuelveoperandos2.this.AV165auxLiqDLog = GXv_char4[0] ;
            resuelveoperandos2.this.AV177auxLiqDPlus = GXv_decimal13[0] ;
            resuelveoperandos2.this.AV178auxDependenciaConceptoEs = GXv_boolean14[0] ;
            if ( ! AV179dependenciConceptoEs )
            {
               AV179dependenciConceptoEs = AV178auxDependenciaConceptoEs ;
            }
            if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV169LiqDPlus)==0) )
            {
               AV169LiqDPlus = AV177auxLiqDPlus ;
            }
            if ( ! (GXutil.strcmp("", AV164LiqDLog)==0) )
            {
               AV164LiqDLog += ". " ;
            }
            AV164LiqDLog += AV165auxLiqDLog ;
            if ( ! AV39dependenciaResuelta )
            {
               new web.msgdebug_prod2(remoteHandle, context).execute( AV25CliCod, AV185Pgmname, httpContext.getMessage( "dependencia no resuelta ", "")+AV94Operando) ;
               AV40dependenciasResueltas = false ;
               if ( (GXutil.strcmp("", AV160operandoError)==0) )
               {
                  if ( ! (GXutil.strcmp("", AV55error)==0) )
                  {
                     AV55error += ", " + AV94Operando ;
                  }
                  else
                  {
                     AV55error += httpContext.getMessage( "No se pudo calcular concepto por falta de resolución de dependencia en ", "") + GXutil.trim( AV94Operando) ;
                  }
               }
            }
            AV55error += GXutil.trim( AV160operandoError) ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV25CliCod, AV185Pgmname, httpContext.getMessage( "&operandoError ", "")+GXutil.trim( AV160operandoError)+httpContext.getMessage( " &error ", "")+GXutil.trim( AV55error)+httpContext.getMessage( " &cantidadCalculada ", "")+GXutil.trim( GXutil.str( AV155cantidadCalculada, 14, 2))+httpContext.getMessage( " cantaux ", "")+GXutil.trim( GXutil.str( AV156cantidadCalculadaAux, 14, 2))) ;
            if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV155cantidadCalculada)==0) && ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV156cantidadCalculadaAux)==0) )
            {
               AV155cantidadCalculada = AV156cantidadCalculadaAux ;
               new web.msgdebug_prod2(remoteHandle, context).execute( AV25CliCod, AV185Pgmname, httpContext.getMessage( "&cantidadCalculada ", "")+GXutil.trim( GXutil.str( AV155cantidadCalculada, 14, 2))) ;
            }
            if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV162baseImportes)==0) && ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV163baseImportesAux)==0) )
            {
               AV162baseImportes = AV163baseImportesAux ;
            }
            if ( GXutil.strcmp(AV30ConCodigo, httpContext.getMessage( "REM051", "")) == 0 )
            {
               new web.msgdebug_prod2(remoteHandle, context).execute( AV25CliCod, AV185Pgmname, httpContext.getMessage( "&AuxConOpeEsCant ", "")+GXutil.trim( GXutil.str( AV154AuxConOpeEsCant, 14, 2))+httpContext.getMessage( " operando ", "")+AV94Operando) ;
            }
            if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV154AuxConOpeEsCant)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV153ConOpeEsCant)==0) )
            {
               AV153ConOpeEsCant = AV154AuxConOpeEsCant ;
               if ( GXutil.strcmp(AV30ConCodigo, httpContext.getMessage( "REM051", "")) == 0 )
               {
                  new web.msgdebug_prod2(remoteHandle, context).execute( AV25CliCod, AV185Pgmname, httpContext.getMessage( "&ConOpeEsCant ", "")+GXutil.trim( GXutil.str( AV153ConOpeEsCant, 14, 2))) ;
               }
            }
            new web.msgdebug_prod2(remoteHandle, context).execute( AV25CliCod, AV185Pgmname, httpContext.getMessage( "&&AuxAlicuotaEs ", "")+GXutil.trim( GXutil.booltostr( AV175AuxAlicuotaEs))+httpContext.getMessage( " &alicuotaEs ", "")+GXutil.trim( GXutil.booltostr( AV174alicuotaEs))) ;
            if ( ! (false==AV175AuxAlicuotaEs) && (false==AV174alicuotaEs) )
            {
               AV174alicuotaEs = AV175AuxAlicuotaEs ;
               new web.msgdebug_prod2(remoteHandle, context).execute( AV25CliCod, AV185Pgmname, httpContext.getMessage( "iguala ", "")+GXutil.trim( GXutil.booltostr( AV174alicuotaEs))) ;
            }
         }
         GXt_dtime2 = AV170AHORA ;
         GXv_dtime3[0] = GXt_dtime2 ;
         new web.getahora(remoteHandle, context).execute( AV25CliCod, GXv_dtime3) ;
         resuelveoperandos2.this.GXt_dtime2 = GXv_dtime3[0] ;
         AV170AHORA = GXt_dtime2 ;
         AV173segundos = DecimalUtil.doubleToDec(GXutil.dtdiffms( AV170AHORA, AV172comienzo2)) ;
         AV186GXV1 = (int)(AV186GXV1+1) ;
      }
      new web.msgdebug_prod2(remoteHandle, context).execute( AV25CliCod, AV185Pgmname, httpContext.getMessage( "&alicuotaEs ", "")+GXutil.trim( GXutil.booltostr( AV174alicuotaEs))) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV25CliCod, AV185Pgmname, httpContext.getMessage( "&SDTOperandos 2 ", "")+AV122SDTOperandos.toJSonString(false)) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV25CliCod, AV185Pgmname, httpContext.getMessage( "&dependenciasResueltas ", "")+GXutil.booltostr( AV40dependenciasResueltas)) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP15[0] = resuelveoperandos2.this.AV122SDTOperandos;
      this.aP16[0] = resuelveoperandos2.this.AV40dependenciasResueltas;
      this.aP17[0] = resuelveoperandos2.this.AV55error;
      this.aP18[0] = resuelveoperandos2.this.AV153ConOpeEsCant;
      this.aP19[0] = resuelveoperandos2.this.AV174alicuotaEs;
      this.aP20[0] = resuelveoperandos2.this.AV155cantidadCalculada;
      this.aP21[0] = resuelveoperandos2.this.AV162baseImportes;
      this.aP22[0] = resuelveoperandos2.this.AV166alMenos1CalculoHay;
      this.aP23[0] = resuelveoperandos2.this.AV164LiqDLog;
      this.aP24[0] = resuelveoperandos2.this.AV169LiqDPlus;
      this.aP25[0] = resuelveoperandos2.this.AV179dependenciConceptoEs;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV55error = "" ;
      AV153ConOpeEsCant = DecimalUtil.ZERO ;
      AV155cantidadCalculada = DecimalUtil.ZERO ;
      AV162baseImportes = DecimalUtil.ZERO ;
      AV164LiqDLog = "" ;
      AV169LiqDPlus = DecimalUtil.ZERO ;
      AV185Pgmname = "" ;
      AV85LiqPeriodo = GXutil.nullDate() ;
      GXv_date1 = new java.util.Date[1] ;
      AV123SDTOperandosItem = new web.SdtSDTOperandosFormula(remoteHandle, context);
      AV172comienzo2 = GXutil.resetTime( GXutil.nullDate() );
      AV94Operando = "" ;
      AV117primeraPalabra = "" ;
      GXv_SdtSDTOperandosFormula6 = new web.SdtSDTOperandosFormula[1] ;
      AV148ActualLiqPeriodo = GXutil.nullDate() ;
      GXv_boolean7 = new boolean[1] ;
      AV160operandoError = "" ;
      GXv_char5 = new String[1] ;
      AV154AuxConOpeEsCant = DecimalUtil.ZERO ;
      GXv_decimal8 = new java.math.BigDecimal[1] ;
      GXv_boolean9 = new boolean[1] ;
      AV156cantidadCalculadaAux = DecimalUtil.ZERO ;
      GXv_decimal10 = new java.math.BigDecimal[1] ;
      AV163baseImportesAux = DecimalUtil.ZERO ;
      GXv_decimal11 = new java.math.BigDecimal[1] ;
      GXv_boolean12 = new boolean[1] ;
      AV165auxLiqDLog = "" ;
      GXv_char4 = new String[1] ;
      AV177auxLiqDPlus = DecimalUtil.ZERO ;
      GXv_decimal13 = new java.math.BigDecimal[1] ;
      GXv_boolean14 = new boolean[1] ;
      AV170AHORA = GXutil.resetTime( GXutil.nullDate() );
      GXt_dtime2 = GXutil.resetTime( GXutil.nullDate() );
      GXv_dtime3 = new java.util.Date[1] ;
      AV173segundos = DecimalUtil.ZERO ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.resuelveoperandos2__default(),
         new Object[] {
         }
      );
      AV185Pgmname = "ResuelveOperandos2" ;
      /* GeneXus formulas. */
      AV185Pgmname = "ResuelveOperandos2" ;
      Gx_err = (short)(0) ;
   }

   private short AV54EmpCod ;
   private short Gx_err ;
   private int AV25CliCod ;
   private int AV84LiqNro ;
   private int AV182LiqRelNro ;
   private int AV79LegNumero ;
   private int AV149ActualLiqNro ;
   private int AV186GXV1 ;
   private java.math.BigDecimal AV161LiqDCanti ;
   private java.math.BigDecimal AV153ConOpeEsCant ;
   private java.math.BigDecimal AV155cantidadCalculada ;
   private java.math.BigDecimal AV162baseImportes ;
   private java.math.BigDecimal AV169LiqDPlus ;
   private java.math.BigDecimal AV154AuxConOpeEsCant ;
   private java.math.BigDecimal GXv_decimal8[] ;
   private java.math.BigDecimal AV156cantidadCalculadaAux ;
   private java.math.BigDecimal GXv_decimal10[] ;
   private java.math.BigDecimal AV163baseImportesAux ;
   private java.math.BigDecimal GXv_decimal11[] ;
   private java.math.BigDecimal AV177auxLiqDPlus ;
   private java.math.BigDecimal GXv_decimal13[] ;
   private java.math.BigDecimal AV173segundos ;
   private String AV129TLiqCod ;
   private String AV30ConCodigo ;
   private String AV145ProcesoLiquidacion ;
   private String AV180llamador ;
   private String AV185Pgmname ;
   private String AV117primeraPalabra ;
   private String GXv_char5[] ;
   private String GXv_char4[] ;
   private java.util.Date AV172comienzo2 ;
   private java.util.Date AV170AHORA ;
   private java.util.Date GXt_dtime2 ;
   private java.util.Date GXv_dtime3[] ;
   private java.util.Date AV168parmLiqPeriodo ;
   private java.util.Date AV176DAgeFecDes ;
   private java.util.Date AV85LiqPeriodo ;
   private java.util.Date GXv_date1[] ;
   private java.util.Date AV148ActualLiqPeriodo ;
   private boolean AV147insertandoConceptos ;
   private boolean AV159simulacionEs ;
   private boolean AV40dependenciasResueltas ;
   private boolean AV174alicuotaEs ;
   private boolean AV166alMenos1CalculoHay ;
   private boolean AV179dependenciConceptoEs ;
   private boolean AV39dependenciaResuelta ;
   private boolean GXv_boolean7[] ;
   private boolean AV175AuxAlicuotaEs ;
   private boolean GXv_boolean9[] ;
   private boolean GXv_boolean12[] ;
   private boolean AV178auxDependenciaConceptoEs ;
   private boolean GXv_boolean14[] ;
   private String AV164LiqDLog ;
   private String AV165auxLiqDLog ;
   private String AV55error ;
   private String AV94Operando ;
   private String AV160operandoError ;
   private boolean[] aP25 ;
   private GXBaseCollection<web.SdtSDTOperandosFormula>[] aP15 ;
   private boolean[] aP16 ;
   private String[] aP17 ;
   private java.math.BigDecimal[] aP18 ;
   private boolean[] aP19 ;
   private java.math.BigDecimal[] aP20 ;
   private java.math.BigDecimal[] aP21 ;
   private boolean[] aP22 ;
   private String[] aP23 ;
   private java.math.BigDecimal[] aP24 ;
   private IDataStoreProvider pr_default ;
   private GXBaseCollection<web.SdtSDTOperandosFormula> AV122SDTOperandos ;
   private web.SdtSDTOperandosFormula AV123SDTOperandosItem ;
   private web.SdtSDTOperandosFormula GXv_SdtSDTOperandosFormula6[] ;
}

final  class resuelveoperandos2__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
      }
   }

}

