package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getdiasdevacacionesporantiguedad extends GXProcedure
{
   public getdiasdevacacionesporantiguedad( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getdiasdevacacionesporantiguedad.class ), "" );
   }

   public getdiasdevacacionesporantiguedad( int remoteHandle ,
                                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.util.Date aP3 ,
                             java.util.Date aP4 ,
                             java.util.Date aP5 ,
                             String aP6 ,
                             String aP7 ,
                             boolean aP8 ,
                             boolean aP9 ,
                             boolean aP10 ,
                             short[] aP11 ,
                             short[] aP12 ,
                             short[] aP13 ,
                             String[] aP14 ,
                             String[] aP15 ,
                             String[] aP16 ,
                             short[] aP17 ,
                             short[] aP18 )
   {
      getdiasdevacacionesporantiguedad.this.aP19 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17, aP18, aP19);
      return aP19[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        java.util.Date aP3 ,
                        java.util.Date aP4 ,
                        java.util.Date aP5 ,
                        String aP6 ,
                        String aP7 ,
                        boolean aP8 ,
                        boolean aP9 ,
                        boolean aP10 ,
                        short[] aP11 ,
                        short[] aP12 ,
                        short[] aP13 ,
                        String[] aP14 ,
                        String[] aP15 ,
                        String[] aP16 ,
                        short[] aP17 ,
                        short[] aP18 ,
                        String[] aP19 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17, aP18, aP19);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.util.Date aP3 ,
                             java.util.Date aP4 ,
                             java.util.Date aP5 ,
                             String aP6 ,
                             String aP7 ,
                             boolean aP8 ,
                             boolean aP9 ,
                             boolean aP10 ,
                             short[] aP11 ,
                             short[] aP12 ,
                             short[] aP13 ,
                             String[] aP14 ,
                             String[] aP15 ,
                             String[] aP16 ,
                             short[] aP17 ,
                             short[] aP18 ,
                             String[] aP19 )
   {
      getdiasdevacacionesporantiguedad.this.AV18CliCod = aP0;
      getdiasdevacacionesporantiguedad.this.AV19EmpCod = aP1;
      getdiasdevacacionesporantiguedad.this.AV20LegNumero = aP2;
      getdiasdevacacionesporantiguedad.this.AV8LiqPeriodo = aP3;
      getdiasdevacacionesporantiguedad.this.AV10LegFecIngreso = aP4;
      getdiasdevacacionesporantiguedad.this.AV15LegFecEgreso = aP5;
      getdiasdevacacionesporantiguedad.this.AV21mensualTLiqCod = aP6;
      getdiasdevacacionesporantiguedad.this.AV23ProcesoLiquidacion = aP7;
      getdiasdevacacionesporantiguedad.this.AV24insertandoConceptos = aP8;
      getdiasdevacacionesporantiguedad.this.AV49validarCompletado = aP9;
      getdiasdevacacionesporantiguedad.this.AV50forzarCalcJornadas = aP10;
      getdiasdevacacionesporantiguedad.this.aP11 = aP11;
      getdiasdevacacionesporantiguedad.this.aP12 = aP12;
      getdiasdevacacionesporantiguedad.this.aP13 = aP13;
      getdiasdevacacionesporantiguedad.this.aP14 = aP14;
      getdiasdevacacionesporantiguedad.this.aP15 = aP15;
      getdiasdevacacionesporantiguedad.this.aP16 = aP16;
      getdiasdevacacionesporantiguedad.this.aP17 = aP17;
      getdiasdevacacionesporantiguedad.this.aP18 = aP18;
      getdiasdevacacionesporantiguedad.this.aP19 = aP19;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV15LegFecEgreso)) )
      {
         AV9antiguedadFecha = localUtil.ymdtod( GXutil.year( AV15LegFecEgreso), 12, 31) ;
      }
      else
      {
         AV9antiguedadFecha = localUtil.ymdtod( GXutil.year( AV8LiqPeriodo), 12, 31) ;
      }
      AV52hoy = GXutil.serverDate( context, remoteHandle, pr_default) ;
      if ( GXutil.year( AV9antiguedadFecha) == GXutil.year( AV52hoy) )
      {
         AV51hastaFecha = AV46vaciaFecha ;
      }
      else
      {
         AV51hastaFecha = AV9antiguedadFecha ;
      }
      GXv_int1[0] = AV11aniosAntiguedad ;
      GXv_int2[0] = AV41mesesAntiguedad ;
      GXv_int3[0] = AV36diasAntiguedad ;
      GXv_char4[0] = AV12LiqDLog ;
      GXv_char5[0] = AV39LegCueAntAbr ;
      GXv_int6[0] = AV40Limite ;
      GXv_int7[0] = (short)(0) ;
      new web.obtantiguedad(remoteHandle, context).execute( AV18CliCod, AV19EmpCod, AV20LegNumero, AV46vaciaFecha, AV9antiguedadFecha, AV51hastaFecha, (short)(0), true, GXv_int1, GXv_int2, GXv_int3, GXv_char4, GXv_char5, GXv_int6, GXv_int7) ;
      getdiasdevacacionesporantiguedad.this.AV11aniosAntiguedad = GXv_int1[0] ;
      getdiasdevacacionesporantiguedad.this.AV41mesesAntiguedad = GXv_int2[0] ;
      getdiasdevacacionesporantiguedad.this.AV36diasAntiguedad = GXv_int3[0] ;
      getdiasdevacacionesporantiguedad.this.AV12LiqDLog = GXv_char4[0] ;
      getdiasdevacacionesporantiguedad.this.AV39LegCueAntAbr = GXv_char5[0] ;
      getdiasdevacacionesporantiguedad.this.AV40Limite = GXv_int6[0] ;
      GXt_char8 = AV13finalTLiqCod ;
      GXt_char9 = AV13finalTLiqCod ;
      GXv_char5[0] = GXt_char9 ;
      new web.tipoliqegreso_codigoparam(remoteHandle, context).execute( GXv_char5) ;
      getdiasdevacacionesporantiguedad.this.GXt_char9 = GXv_char5[0] ;
      GXv_char4[0] = GXt_char8 ;
      new web.getparametro(remoteHandle, context).execute( AV18CliCod, GXt_char9, GXv_char4) ;
      getdiasdevacacionesporantiguedad.this.GXt_char8 = GXv_char4[0] ;
      AV13finalTLiqCod = GXt_char8 ;
      GXt_char9 = AV14quincenaTLiqCod ;
      GXt_char8 = AV14quincenaTLiqCod ;
      GXv_char5[0] = GXt_char8 ;
      new web.tipoliqquincena_codigoparam(remoteHandle, context).execute( GXv_char5) ;
      getdiasdevacacionesporantiguedad.this.GXt_char8 = GXv_char5[0] ;
      GXv_char4[0] = GXt_char9 ;
      new web.getparametro(remoteHandle, context).execute( AV18CliCod, GXt_char8, GXv_char4) ;
      getdiasdevacacionesporantiguedad.this.GXt_char9 = GXv_char4[0] ;
      AV14quincenaTLiqCod = GXt_char9 ;
      GXt_char9 = AV54egresoTLiqCod ;
      GXt_char8 = AV54egresoTLiqCod ;
      GXv_char5[0] = GXt_char8 ;
      new web.tipoliqegreso_codigoparam(remoteHandle, context).execute( GXv_char5) ;
      getdiasdevacacionesporantiguedad.this.GXt_char8 = GXv_char5[0] ;
      GXv_char4[0] = GXt_char9 ;
      new web.getparametro(remoteHandle, context).execute( AV18CliCod, GXt_char8, GXv_char4) ;
      getdiasdevacacionesporantiguedad.this.GXt_char9 = GXv_char4[0] ;
      AV54egresoTLiqCod = GXt_char9 ;
      GXt_char9 = AV33ParmValue ;
      GXt_char8 = AV33ParmValue ;
      GXv_char5[0] = GXt_char8 ;
      new web.meses30dias_codigoparam(remoteHandle, context).execute( GXv_char5) ;
      getdiasdevacacionesporantiguedad.this.GXt_char8 = GXv_char5[0] ;
      GXv_char4[0] = GXt_char9 ;
      new web.getparametro(remoteHandle, context).execute( AV18CliCod, GXt_char8, GXv_char4) ;
      getdiasdevacacionesporantiguedad.this.GXt_char9 = GXv_char4[0] ;
      AV33ParmValue = GXt_char9 ;
      AV31todosLosMeses30 = GXutil.boolval( AV33ParmValue) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV57Pgmname, httpContext.getMessage( " egreso ", "")+GXutil.trim( localUtil.dtoc( AV15LegFecEgreso, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " &aniosAntiguedad ", "")+GXutil.trim( GXutil.str( AV11aniosAntiguedad, 4, 0))+httpContext.getMessage( " &auxLegFecIngreso ", "")+GXutil.trim( localUtil.dtoc( AV16auxLegFecIngreso, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
      if ( ( AV50forzarCalcJornadas ) || ( AV41mesesAntiguedad <= AV40Limite ) )
      {
         GXt_char9 = AV37diasSacConCodigo ;
         GXt_char8 = AV37diasSacConCodigo ;
         GXv_char5[0] = GXt_char8 ;
         new web.concepto_diasproporsac_codigoparam(remoteHandle, context).execute( GXv_char5) ;
         getdiasdevacacionesporantiguedad.this.GXt_char8 = GXv_char5[0] ;
         GXv_char4[0] = GXt_char9 ;
         new web.getparametro(remoteHandle, context).execute( AV18CliCod, GXt_char8, GXv_char4) ;
         getdiasdevacacionesporantiguedad.this.GXt_char9 = GXv_char4[0] ;
         AV37diasSacConCodigo = GXt_char9 ;
         AV16auxLegFecIngreso = localUtil.ymdtod( GXutil.year( AV10LegFecIngreso), GXutil.month( AV10LegFecIngreso), 1) ;
         while ( (( GXutil.resetTime(AV16auxLegFecIngreso).before( GXutil.resetTime( AV9antiguedadFecha )) ) || ( GXutil.dateCompare(GXutil.resetTime(AV16auxLegFecIngreso), GXutil.resetTime(AV9antiguedadFecha)) )) )
         {
            AV58GXLvl73 = (byte)(0) ;
            /* Using cursor P01E52 */
            pr_default.execute(0, new Object[] {Integer.valueOf(AV18CliCod), Short.valueOf(AV19EmpCod), Integer.valueOf(AV20LegNumero), AV37diasSacConCodigo, AV16auxLegFecIngreso, AV21mensualTLiqCod, AV14quincenaTLiqCod, AV54egresoTLiqCod});
            while ( (pr_default.getStatus(0) != 101) )
            {
               A400DTLiqCod = P01E52_A400DTLiqCod[0] ;
               A397DLiqPeriodo = P01E52_A397DLiqPeriodo[0] ;
               A394DConCodigo = P01E52_A394DConCodigo[0] ;
               A6LegNumero = P01E52_A6LegNumero[0] ;
               A1EmpCod = P01E52_A1EmpCod[0] ;
               A3CliCod = P01E52_A3CliCod[0] ;
               A507LiqDCalculado = P01E52_A507LiqDCalculado[0] ;
               A393DConDescrip = P01E52_A393DConDescrip[0] ;
               A275LiqDImpCalcu = P01E52_A275LiqDImpCalcu[0] ;
               n275LiqDImpCalcu = P01E52_n275LiqDImpCalcu[0] ;
               A31LiqNro = P01E52_A31LiqNro[0] ;
               A81LiqDSecuencial = P01E52_A81LiqDSecuencial[0] ;
               AV58GXLvl73 = (byte)(1) ;
               if ( ( AV49validarCompletado ) && ( A507LiqDCalculado == 0 ) )
               {
                  AV48error = httpContext.getMessage( "Concepto ", "") + GXutil.trim( A393DConDescrip) + httpContext.getMessage( " no calculado", "") ;
                  pr_default.close(0);
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
               AV35dias = (short)(DecimalUtil.decToDouble(A275LiqDImpCalcu)) ;
               AV26jornadasTrabajadas = (short)(AV26jornadasTrabajadas+AV35dias) ;
               if ( ! (GXutil.strcmp("", AV28jorTraLiqDLog)==0) )
               {
                  AV28jorTraLiqDLog += ". " ;
               }
               GXv_char5[0] = AV43TliqDesc ;
               new web.gettipoliqdesc(remoteHandle, context).execute( AV18CliCod, A400DTLiqCod, GXv_char5) ;
               getdiasdevacacionesporantiguedad.this.AV43TliqDesc = GXv_char5[0] ;
               AV28jorTraLiqDLog += GXutil.trim( GXutil.str( AV35dias, 4, 0)) + httpContext.getMessage( " días de liquidación ", "") + GXutil.trim( AV43TliqDesc) + httpContext.getMessage( " de ", "") + GXutil.trim( localUtil.cmonth( A397DLiqPeriodo, httpContext.getLanguage( ))) + " " + GXutil.trim( GXutil.str( GXutil.year( A397DLiqPeriodo), 10, 0)) ;
               pr_default.readNext(0);
            }
            pr_default.close(0);
            if ( AV58GXLvl73 == 0 )
            {
               if ( ! AV50forzarCalcJornadas )
               {
                  if ( ! (GXutil.strcmp("", AV28jorTraLiqDLog)==0) )
                  {
                     AV28jorTraLiqDLog += ". " ;
                  }
                  GXv_int7[0] = AV35dias ;
                  new web.diasmes(remoteHandle, context).execute( AV18CliCod, AV16auxLegFecIngreso, GXv_int7) ;
                  getdiasdevacacionesporantiguedad.this.AV35dias = GXv_int7[0] ;
                  if ( ( GXutil.month( AV16auxLegFecIngreso) == GXutil.month( AV10LegFecIngreso) ) && ( GXutil.year( AV16auxLegFecIngreso) == GXutil.year( AV10LegFecIngreso) ) )
                  {
                     AV53restar = (short)(GXutil.day( AV10LegFecIngreso)-1) ;
                     AV35dias = (short)(AV35dias-AV53restar) ;
                  }
                  AV26jornadasTrabajadas = (short)(AV26jornadasTrabajadas+AV35dias) ;
                  AV28jorTraLiqDLog += GXutil.trim( GXutil.str( AV35dias, 4, 0)) + httpContext.getMessage( " días (sin liquidar)  de ", "") + GXutil.trim( localUtil.cmonth( AV16auxLegFecIngreso, httpContext.getLanguage( ))) + " " + GXutil.trim( GXutil.str( GXutil.year( AV16auxLegFecIngreso), 10, 0)) ;
               }
            }
            AV16auxLegFecIngreso = GXutil.addmth( AV16auxLegFecIngreso, (short)(1)) ;
         }
         if ( AV26jornadasTrabajadas < AV36diasAntiguedad )
         {
            GXv_char5[0] = AV38jorTrabTooltip ;
            new web.armatooltip(remoteHandle, context).execute( AV18CliCod, DecimalUtil.doubleToDec(AV26jornadasTrabajadas), AV28jorTraLiqDLog, true, GXv_char5) ;
            getdiasdevacacionesporantiguedad.this.AV38jorTrabTooltip = GXv_char5[0] ;
            AV12LiqDLog += " (" + GXutil.trim( AV38jorTrabTooltip) + httpContext.getMessage( " jornadas trabajadas)", "") ;
         }
      }
      GXv_int7[0] = AV27LegLicCntDias ;
      GXv_char5[0] = AV47auxLiqDLog ;
      new web.diasdevacacionesporantiguedad(remoteHandle, context).execute( AV18CliCod, AV19EmpCod, AV20LegNumero, AV8LiqPeriodo, AV10LegFecIngreso, AV11aniosAntiguedad, AV41mesesAntiguedad, AV26jornadasTrabajadas, AV40Limite, AV8LiqPeriodo, GXv_int7, GXv_char5) ;
      getdiasdevacacionesporantiguedad.this.AV27LegLicCntDias = GXv_int7[0] ;
      getdiasdevacacionesporantiguedad.this.AV47auxLiqDLog = GXv_char5[0] ;
      AV12LiqDLog += ". " + GXutil.trim( AV47auxLiqDLog) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP11[0] = getdiasdevacacionesporantiguedad.this.AV11aniosAntiguedad;
      this.aP12[0] = getdiasdevacacionesporantiguedad.this.AV26jornadasTrabajadas;
      this.aP13[0] = getdiasdevacacionesporantiguedad.this.AV27LegLicCntDias;
      this.aP14[0] = getdiasdevacacionesporantiguedad.this.AV12LiqDLog;
      this.aP15[0] = getdiasdevacacionesporantiguedad.this.AV28jorTraLiqDLog;
      this.aP16[0] = getdiasdevacacionesporantiguedad.this.AV39LegCueAntAbr;
      this.aP17[0] = getdiasdevacacionesporantiguedad.this.AV41mesesAntiguedad;
      this.aP18[0] = getdiasdevacacionesporantiguedad.this.AV36diasAntiguedad;
      this.aP19[0] = getdiasdevacacionesporantiguedad.this.AV48error;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12LiqDLog = "" ;
      AV28jorTraLiqDLog = "" ;
      AV39LegCueAntAbr = "" ;
      AV48error = "" ;
      AV9antiguedadFecha = GXutil.nullDate() ;
      AV52hoy = GXutil.nullDate() ;
      AV51hastaFecha = GXutil.nullDate() ;
      AV46vaciaFecha = GXutil.nullDate() ;
      GXv_int1 = new short[1] ;
      GXv_int2 = new short[1] ;
      GXv_int3 = new short[1] ;
      GXv_int6 = new short[1] ;
      AV13finalTLiqCod = "" ;
      AV14quincenaTLiqCod = "" ;
      AV54egresoTLiqCod = "" ;
      AV33ParmValue = "" ;
      AV57Pgmname = "" ;
      AV16auxLegFecIngreso = GXutil.nullDate() ;
      AV37diasSacConCodigo = "" ;
      GXt_char9 = "" ;
      GXt_char8 = "" ;
      GXv_char4 = new String[1] ;
      scmdbuf = "" ;
      P01E52_A400DTLiqCod = new String[] {""} ;
      P01E52_A397DLiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      P01E52_A394DConCodigo = new String[] {""} ;
      P01E52_A6LegNumero = new int[1] ;
      P01E52_A1EmpCod = new short[1] ;
      P01E52_A3CliCod = new int[1] ;
      P01E52_A507LiqDCalculado = new byte[1] ;
      P01E52_A393DConDescrip = new String[] {""} ;
      P01E52_A275LiqDImpCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01E52_n275LiqDImpCalcu = new boolean[] {false} ;
      P01E52_A31LiqNro = new int[1] ;
      P01E52_A81LiqDSecuencial = new int[1] ;
      A400DTLiqCod = "" ;
      A397DLiqPeriodo = GXutil.nullDate() ;
      A394DConCodigo = "" ;
      A393DConDescrip = "" ;
      A275LiqDImpCalcu = DecimalUtil.ZERO ;
      AV43TliqDesc = "" ;
      AV38jorTrabTooltip = "" ;
      GXv_int7 = new short[1] ;
      AV47auxLiqDLog = "" ;
      GXv_char5 = new String[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getdiasdevacacionesporantiguedad__default(),
         new Object[] {
             new Object[] {
            P01E52_A400DTLiqCod, P01E52_A397DLiqPeriodo, P01E52_A394DConCodigo, P01E52_A6LegNumero, P01E52_A1EmpCod, P01E52_A3CliCod, P01E52_A507LiqDCalculado, P01E52_A393DConDescrip, P01E52_A275LiqDImpCalcu, P01E52_n275LiqDImpCalcu,
            P01E52_A31LiqNro, P01E52_A81LiqDSecuencial
            }
         }
      );
      AV57Pgmname = "getDiasDeVacacionesPorAntiguedad" ;
      /* GeneXus formulas. */
      AV57Pgmname = "getDiasDeVacacionesPorAntiguedad" ;
      Gx_err = (short)(0) ;
   }

   private byte AV58GXLvl73 ;
   private byte A507LiqDCalculado ;
   private short AV19EmpCod ;
   private short AV11aniosAntiguedad ;
   private short AV26jornadasTrabajadas ;
   private short AV27LegLicCntDias ;
   private short AV41mesesAntiguedad ;
   private short AV36diasAntiguedad ;
   private short GXv_int1[] ;
   private short GXv_int2[] ;
   private short GXv_int3[] ;
   private short AV40Limite ;
   private short GXv_int6[] ;
   private short A1EmpCod ;
   private short AV35dias ;
   private short AV53restar ;
   private short GXv_int7[] ;
   private short Gx_err ;
   private int AV18CliCod ;
   private int AV20LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private int A31LiqNro ;
   private int A81LiqDSecuencial ;
   private java.math.BigDecimal A275LiqDImpCalcu ;
   private String AV21mensualTLiqCod ;
   private String AV23ProcesoLiquidacion ;
   private String AV13finalTLiqCod ;
   private String AV14quincenaTLiqCod ;
   private String AV54egresoTLiqCod ;
   private String AV57Pgmname ;
   private String AV37diasSacConCodigo ;
   private String GXt_char9 ;
   private String GXt_char8 ;
   private String GXv_char4[] ;
   private String scmdbuf ;
   private String A400DTLiqCod ;
   private String A394DConCodigo ;
   private String GXv_char5[] ;
   private java.util.Date AV8LiqPeriodo ;
   private java.util.Date AV10LegFecIngreso ;
   private java.util.Date AV15LegFecEgreso ;
   private java.util.Date AV9antiguedadFecha ;
   private java.util.Date AV52hoy ;
   private java.util.Date AV51hastaFecha ;
   private java.util.Date AV46vaciaFecha ;
   private java.util.Date AV16auxLegFecIngreso ;
   private java.util.Date A397DLiqPeriodo ;
   private boolean AV24insertandoConceptos ;
   private boolean AV49validarCompletado ;
   private boolean AV50forzarCalcJornadas ;
   private boolean AV31todosLosMeses30 ;
   private boolean n275LiqDImpCalcu ;
   private boolean returnInSub ;
   private String AV12LiqDLog ;
   private String AV28jorTraLiqDLog ;
   private String AV33ParmValue ;
   private String AV47auxLiqDLog ;
   private String AV39LegCueAntAbr ;
   private String AV48error ;
   private String A393DConDescrip ;
   private String AV43TliqDesc ;
   private String AV38jorTrabTooltip ;
   private String[] aP19 ;
   private short[] aP11 ;
   private short[] aP12 ;
   private short[] aP13 ;
   private String[] aP14 ;
   private String[] aP15 ;
   private String[] aP16 ;
   private short[] aP17 ;
   private short[] aP18 ;
   private IDataStoreProvider pr_default ;
   private String[] P01E52_A400DTLiqCod ;
   private java.util.Date[] P01E52_A397DLiqPeriodo ;
   private String[] P01E52_A394DConCodigo ;
   private int[] P01E52_A6LegNumero ;
   private short[] P01E52_A1EmpCod ;
   private int[] P01E52_A3CliCod ;
   private byte[] P01E52_A507LiqDCalculado ;
   private String[] P01E52_A393DConDescrip ;
   private java.math.BigDecimal[] P01E52_A275LiqDImpCalcu ;
   private boolean[] P01E52_n275LiqDImpCalcu ;
   private int[] P01E52_A31LiqNro ;
   private int[] P01E52_A81LiqDSecuencial ;
}

final  class getdiasdevacacionesporantiguedad__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01E52", "SELECT DTLiqCod, DLiqPeriodo, DConCodigo, LegNumero, EmpCod, CliCod, LiqDCalculado, DConDescrip, LiqDImpCalcu, LiqNro, LiqDSecuencial FROM LiquidacionDetalle WHERE (CliCod = ? and EmpCod = ? and LegNumero = ? and DConCodigo = ( ?) and DLiqPeriodo = ?) AND (DTLiqCod = ( ?) or DTLiqCod = ( ?) or DTLiqCod = ( ?)) ORDER BY CliCod, EmpCod, LegNumero, DConCodigo, DLiqPeriodo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((byte[]) buf[6])[0] = rslt.getByte(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(9,2);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((int[]) buf[10])[0] = rslt.getInt(10);
               ((int[]) buf[11])[0] = rslt.getInt(11);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setString(4, (String)parms[3], 10);
               stmt.setDate(5, (java.util.Date)parms[4]);
               stmt.setString(6, (String)parms[5], 20);
               stmt.setString(7, (String)parms[6], 20);
               stmt.setString(8, (String)parms[7], 20);
               return;
      }
   }

}

