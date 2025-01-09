package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class inicializarperiodoscclic extends GXProcedure
{
   public inicializarperiodoscclic( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( inicializarperiodoscclic.class ), "" );
   }

   public inicializarperiodoscclic( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        short aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             short aP3 )
   {
      inicializarperiodoscclic.this.AV9clicod = aP0;
      inicializarperiodoscclic.this.AV10EmpCod = aP1;
      inicializarperiodoscclic.this.AV44parmLegNumero = aP2;
      inicializarperiodoscclic.this.AV30desdeAnio = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV25LegCuenLicTpo = "Vacaciones" ;
      GXt_char1 = AV18mensualTLiqCod ;
      GXt_char2 = AV18mensualTLiqCod ;
      GXv_char3[0] = GXt_char2 ;
      new web.tipoliqmensual_codigoparam(remoteHandle, context).execute( GXv_char3) ;
      inicializarperiodoscclic.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV9clicod, GXt_char2, GXv_char4) ;
      inicializarperiodoscclic.this.GXt_char1 = GXv_char4[0] ;
      AV18mensualTLiqCod = GXt_char1 ;
      GXv_int5[0] = AV11EmpPerVacDes ;
      GXv_int6[0] = AV12EmpPerVacHas ;
      GXv_decimal7[0] = AV13EmpFracVacAnt ;
      new web.getemppervac(remoteHandle, context).execute( AV9clicod, AV10EmpCod, GXv_int5, GXv_int6, GXv_decimal7) ;
      inicializarperiodoscclic.this.AV11EmpPerVacDes = GXv_int5[0] ;
      inicializarperiodoscclic.this.AV12EmpPerVacHas = GXv_int6[0] ;
      inicializarperiodoscclic.this.AV13EmpFracVacAnt = GXv_decimal7[0] ;
      AV29hoy = GXutil.serverDate( context, remoteHandle, pr_default) ;
      AV28hoyAnio = (short)(GXutil.year( AV29hoy)) ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           Integer.valueOf(AV44parmLegNumero) ,
                                           Integer.valueOf(A6LegNumero) ,
                                           Integer.valueOf(AV9clicod) ,
                                           Short.valueOf(AV10EmpCod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) } ,
                                           new int[]{
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT
                                           }
      });
      /* Using cursor P02912 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV9clicod), Short.valueOf(AV10EmpCod), Integer.valueOf(AV44parmLegNumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A6LegNumero = P02912_A6LegNumero[0] ;
         A1EmpCod = P02912_A1EmpCod[0] ;
         A3CliCod = P02912_A3CliCod[0] ;
         AV41collection_LegNumero.add((int)(A6LegNumero), 0);
         pr_default.readNext(0);
      }
      pr_default.close(0);
      AV42L = (short)(1) ;
      while ( AV42L <= AV41collection_LegNumero.size() )
      {
         AV26LegNumero = ((Number) AV41collection_LegNumero.elementAt(-1+AV42L)).intValue() ;
         GXv_date8[0] = AV40primerIngFecha ;
         new web.getpermanenciaprimeringreso(remoteHandle, context).execute( AV9clicod, AV10EmpCod, ((Number) AV41collection_LegNumero.elementAt(-1+AV42L)).intValue(), GXv_date8) ;
         inicializarperiodoscclic.this.AV40primerIngFecha = GXv_date8[0] ;
         AV8i = (short)(GXutil.year( AV40primerIngFecha)) ;
         while ( AV8i <= AV28hoyAnio )
         {
            GXv_boolean9[0] = AV32LegCuLIncluir ;
            GXv_boolean10[0] = AV31LegCuLRecalc ;
            GXv_boolean11[0] = AV33existe ;
            new web.getcclicincluiryrecalc(remoteHandle, context).execute( AV9clicod, AV10EmpCod, AV25LegCuenLicTpo, ((Number) AV41collection_LegNumero.elementAt(-1+AV42L)).intValue(), AV8i, GXv_boolean9, GXv_boolean10, GXv_boolean11) ;
            inicializarperiodoscclic.this.AV32LegCuLIncluir = GXv_boolean9[0] ;
            inicializarperiodoscclic.this.AV31LegCuLRecalc = GXv_boolean10[0] ;
            inicializarperiodoscclic.this.AV33existe = GXv_boolean11[0] ;
            if ( ( ( AV32LegCuLIncluir ) && ( AV31LegCuLRecalc ) ) || ! AV33existe )
            {
               Cond_result = true ;
            }
            else
            {
               Cond_result = false ;
            }
            if ( Cond_result )
            {
               new web.leglicccagraprmanual(remoteHandle, context).execute( AV9clicod, AV10EmpCod, ((Number) AV41collection_LegNumero.elementAt(-1+AV42L)).intValue(), AV25LegCuenLicTpo, AV8i) ;
               GXv_boolean11[0] = AV38otroshay ;
               GXv_boolean10[0] = AV39iniHay ;
               new web.deletecclicencias(remoteHandle, context).execute( AV9clicod, AV10EmpCod, ((Number) AV41collection_LegNumero.elementAt(-1+AV42L)).intValue(), AV25LegCuenLicTpo, AV8i, GXv_boolean11, GXv_boolean10) ;
               inicializarperiodoscclic.this.AV38otroshay = GXv_boolean11[0] ;
               inicializarperiodoscclic.this.AV39iniHay = GXv_boolean10[0] ;
               AV22LegCuenLicPerIni = localUtil.ymdtod( AV8i, AV11EmpPerVacDes, 1) ;
               if ( AV12EmpPerVacHas > AV11EmpPerVacDes )
               {
                  Cond_result = true ;
               }
               else
               {
                  Cond_result = false ;
               }
               if ( Cond_result )
               {
                  AV23LegCuenLicPerFin = localUtil.ymdtod( AV8i, AV12EmpPerVacHas, 1) ;
               }
               else
               {
                  AV23LegCuenLicPerFin = localUtil.ymdtod( AV8i+1, AV12EmpPerVacHas, 1) ;
               }
               AV23LegCuenLicPerFin = GXutil.eomdate( AV23LegCuenLicPerFin) ;
               AV14antiguedadFecha = localUtil.ymdtod( AV8i, 12, 31) ;
               GXv_date8[0] = AV43LegFecIngreso ;
               new web.getfecingreso(remoteHandle, context).execute( AV9clicod, AV10EmpCod, ((Number) AV41collection_LegNumero.elementAt(-1+AV42L)).intValue(), GXv_date8) ;
               inicializarperiodoscclic.this.AV43LegFecIngreso = GXv_date8[0] ;
               GXv_int12[0] = AV16LegCuenAntAnios ;
               GXv_int13[0] = (short)(0) ;
               GXv_int14[0] = AV20LegCuenDiasCorres ;
               GXv_char4[0] = AV21LegCueAntTexto ;
               GXv_char3[0] = "" ;
               GXv_char15[0] = AV37LegCueAntAbr ;
               GXv_int16[0] = AV17LegCuenAntMeses ;
               GXv_int17[0] = (short)(AV15LegCuenANtDias) ;
               GXv_char18[0] = "" ;
               new web.getdiasdevacacionesporantiguedad(remoteHandle, context).execute( AV9clicod, AV10EmpCod, ((Number) AV41collection_LegNumero.elementAt(-1+AV42L)).intValue(), AV14antiguedadFecha, AV43LegFecIngreso, AV14antiguedadFecha, AV18mensualTLiqCod, "Calculo", true, false, false, GXv_int12, GXv_int13, GXv_int14, GXv_char4, GXv_char3, GXv_char15, GXv_int16, GXv_int17, GXv_char18) ;
               inicializarperiodoscclic.this.AV16LegCuenAntAnios = GXv_int12[0] ;
               inicializarperiodoscclic.this.AV20LegCuenDiasCorres = GXv_int14[0] ;
               inicializarperiodoscclic.this.AV21LegCueAntTexto = GXv_char4[0] ;
               inicializarperiodoscclic.this.AV37LegCueAntAbr = GXv_char15[0] ;
               inicializarperiodoscclic.this.AV17LegCuenAntMeses = GXv_int16[0] ;
               inicializarperiodoscclic.this.AV15LegCuenANtDias = GXv_int17[0] ;
               new web.msgdebug_prod2(remoteHandle, context).execute( AV9clicod, AV48Pgmname, httpContext.getMessage( "legnumero ", "")+GXutil.trim( GXutil.str( ((Number) AV41collection_LegNumero.elementAt(-1+AV42L)).intValue(), 8, 0))+httpContext.getMessage( " &i ", "")+GXutil.trim( GXutil.str( AV8i, 4, 0))+httpContext.getMessage( " &otroshay ", "")+GXutil.trim( GXutil.booltostr( AV38otroshay))+httpContext.getMessage( " &iniHay ", "")+GXutil.trim( GXutil.booltostr( AV39iniHay))) ;
               if ( ! AV38otroshay && ! AV39iniHay )
               {
                  if ( AV8i == GXutil.year( AV29hoy) )
                  {
                     AV34LegCuenDiasGoz = (short)(0) ;
                     AV35LegCuLiPCur = AV20LegCuenDiasCorres ;
                  }
                  else
                  {
                     AV34LegCuenDiasGoz = AV20LegCuenDiasCorres ;
                     AV35LegCuLiPCur = (short)(0) ;
                  }
               }
               else
               {
                  GXv_int17[0] = AV34LegCuenDiasGoz ;
                  new web.licccgetaproinimanual(remoteHandle, context).execute( AV9clicod, AV10EmpCod, ((Number) AV41collection_LegNumero.elementAt(-1+AV42L)).intValue(), AV25LegCuenLicTpo, AV8i, GXv_int17) ;
                  inicializarperiodoscclic.this.AV34LegCuenDiasGoz = GXv_int17[0] ;
                  new web.msgdebug_prod2(remoteHandle, context).execute( AV9clicod, AV48Pgmname, httpContext.getMessage( "legnumero ", "")+GXutil.trim( GXutil.str( ((Number) AV41collection_LegNumero.elementAt(-1+AV42L)).intValue(), 8, 0))+httpContext.getMessage( " &i ", "")+GXutil.trim( GXutil.str( AV8i, 4, 0))+httpContext.getMessage( " &LegCuenDiasGoz ", "")+GXutil.trim( GXutil.str( AV34LegCuenDiasGoz, 4, 0))+httpContext.getMessage( " &otroshay ", "")+GXutil.trim( GXutil.booltostr( AV38otroshay))) ;
                  AV35LegCuLiPCur = (short)(AV20LegCuenDiasCorres-AV34LegCuenDiasGoz) ;
               }
               new web.newlegajocuentalicencia(remoteHandle, context).execute( AV9clicod, AV10EmpCod, AV26LegNumero, AV25LegCuenLicTpo, AV8i, AV22LegCuenLicPerIni, AV23LegCuenLicPerFin, AV15LegCuenANtDias, AV16LegCuenAntAnios, AV17LegCuenAntMeses, AV20LegCuenDiasCorres, AV34LegCuenDiasGoz, (short)(0), AV21LegCueAntTexto, AV37LegCueAntAbr, AV35LegCuLiPCur, (short)(0), (short)(0), (short)(0), (short)(0), (short)(0)) ;
            }
            AV8i = (short)(AV8i+1) ;
         }
         AV42L = (short)(AV42L+1) ;
      }
      GXt_char2 = AV24vacacionesSitCodigo ;
      GXv_char18[0] = GXt_char2 ;
      new web.codigodesituacionvacaciones(remoteHandle, context).execute( AV9clicod, GXv_char18) ;
      inicializarperiodoscclic.this.GXt_char2 = GXv_char18[0] ;
      AV24vacacionesSitCodigo = GXt_char2 ;
      Application.commitDataStores(context, remoteHandle, pr_default, "inicializarperiodoscclic");
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           Integer.valueOf(AV44parmLegNumero) ,
                                           Integer.valueOf(A6LegNumero) ,
                                           Integer.valueOf(AV9clicod) ,
                                           Short.valueOf(AV10EmpCod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) } ,
                                           new int[]{
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT
                                           }
      });
      /* Using cursor P02913 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV9clicod), Short.valueOf(AV10EmpCod), Integer.valueOf(AV44parmLegNumero)});
      while ( (pr_default.getStatus(1) != 101) )
      {
         A6LegNumero = P02913_A6LegNumero[0] ;
         A1EmpCod = P02913_A1EmpCod[0] ;
         A3CliCod = P02913_A3CliCod[0] ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV9clicod, AV48Pgmname, httpContext.getMessage( "inicializa totales ", "")+GXutil.trim( GXutil.str( A6LegNumero, 8, 0))) ;
         new web.asignarconsumoscclicencias(remoteHandle, context).execute( AV9clicod, AV10EmpCod, A6LegNumero, AV27fecha, (short)(0), "inicializacion", 0) ;
         pr_default.readNext(1);
      }
      pr_default.close(1);
      Application.commitDataStores(context, remoteHandle, pr_default, "inicializarperiodoscclic");
      new web.replicavacliqimp_a_lic(remoteHandle, context).execute( AV9clicod, AV10EmpCod, AV44parmLegNumero, AV30desdeAnio) ;
      Application.commitDataStores(context, remoteHandle, pr_default, "inicializarperiodoscclic");
      pr_default.dynParam(2, new Object[]{ new Object[]{
                                           Integer.valueOf(AV44parmLegNumero) ,
                                           Integer.valueOf(A6LegNumero) ,
                                           A506LegLicSitCodigo ,
                                           AV24vacacionesSitCodigo ,
                                           Integer.valueOf(AV9clicod) ,
                                           Short.valueOf(AV10EmpCod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) } ,
                                           new int[]{
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT
                                           }
      });
      /* Using cursor P02914 */
      pr_default.execute(2, new Object[] {Integer.valueOf(AV9clicod), Short.valueOf(AV10EmpCod), AV24vacacionesSitCodigo, Integer.valueOf(AV44parmLegNumero)});
      while ( (pr_default.getStatus(2) != 101) )
      {
         A6LegNumero = P02914_A6LegNumero[0] ;
         A506LegLicSitCodigo = P02914_A506LegLicSitCodigo[0] ;
         A1EmpCod = P02914_A1EmpCod[0] ;
         A3CliCod = P02914_A3CliCod[0] ;
         A1497LegLicEstado = P02914_A1497LegLicEstado[0] ;
         A76LegLicenIni = P02914_A76LegLicenIni[0] ;
         A481LegLicenFin = P02914_A481LegLicenFin[0] ;
         if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A481LegLicenFin)) )
         {
            A501LegLicCntDias = (short)(GXutil.ddiff(A481LegLicenFin,A76LegLicenIni)+1) ;
         }
         else
         {
            A501LegLicCntDias = (short)(GXutil.ddiff(GXutil.eomdate( A76LegLicenIni),A76LegLicenIni)+1) ;
         }
         if ( GXutil.strcmp(A1497LegLicEstado, "autorizada") == 0 )
         {
            new web.msgdebug_prod2(remoteHandle, context).execute( AV9clicod, AV48Pgmname, httpContext.getMessage( "inicializa autorizadas ", "")+GXutil.trim( GXutil.str( A6LegNumero, 8, 0))) ;
            new web.asignarconsumoscclicencias(remoteHandle, context).execute( AV9clicod, AV10EmpCod, A6LegNumero, A76LegLicenIni, A501LegLicCntDias, "licencias", 0) ;
         }
         pr_default.readNext(2);
      }
      pr_default.close(2);
      Application.commitDataStores(context, remoteHandle, pr_default, "inicializarperiodoscclic");
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
      AV25LegCuenLicTpo = "" ;
      AV18mensualTLiqCod = "" ;
      GXt_char1 = "" ;
      GXv_int5 = new byte[1] ;
      GXv_int6 = new byte[1] ;
      AV13EmpFracVacAnt = DecimalUtil.ZERO ;
      GXv_decimal7 = new java.math.BigDecimal[1] ;
      AV29hoy = GXutil.nullDate() ;
      scmdbuf = "" ;
      P02912_A6LegNumero = new int[1] ;
      P02912_A1EmpCod = new short[1] ;
      P02912_A3CliCod = new int[1] ;
      AV41collection_LegNumero = new GXSimpleCollection<Integer>(Integer.class, "internal", "");
      AV40primerIngFecha = GXutil.nullDate() ;
      GXv_boolean9 = new boolean[1] ;
      GXv_boolean11 = new boolean[1] ;
      GXv_boolean10 = new boolean[1] ;
      AV22LegCuenLicPerIni = GXutil.nullDate() ;
      AV23LegCuenLicPerFin = GXutil.nullDate() ;
      AV14antiguedadFecha = GXutil.nullDate() ;
      AV43LegFecIngreso = GXutil.nullDate() ;
      GXv_date8 = new java.util.Date[1] ;
      GXv_int12 = new short[1] ;
      GXv_int13 = new short[1] ;
      GXv_int14 = new short[1] ;
      AV21LegCueAntTexto = "" ;
      GXv_char4 = new String[1] ;
      GXv_char3 = new String[1] ;
      AV37LegCueAntAbr = "" ;
      GXv_char15 = new String[1] ;
      GXv_int16 = new short[1] ;
      AV48Pgmname = "" ;
      GXv_int17 = new short[1] ;
      AV24vacacionesSitCodigo = "" ;
      GXt_char2 = "" ;
      GXv_char18 = new String[1] ;
      P02913_A6LegNumero = new int[1] ;
      P02913_A1EmpCod = new short[1] ;
      P02913_A3CliCod = new int[1] ;
      AV27fecha = GXutil.nullDate() ;
      A506LegLicSitCodigo = "" ;
      P02914_A6LegNumero = new int[1] ;
      P02914_A506LegLicSitCodigo = new String[] {""} ;
      P02914_A1EmpCod = new short[1] ;
      P02914_A3CliCod = new int[1] ;
      P02914_A1497LegLicEstado = new String[] {""} ;
      P02914_A76LegLicenIni = new java.util.Date[] {GXutil.nullDate()} ;
      P02914_A481LegLicenFin = new java.util.Date[] {GXutil.nullDate()} ;
      A1497LegLicEstado = "" ;
      A76LegLicenIni = GXutil.nullDate() ;
      A481LegLicenFin = GXutil.nullDate() ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.inicializarperiodoscclic__default(),
         new Object[] {
             new Object[] {
            P02912_A6LegNumero, P02912_A1EmpCod, P02912_A3CliCod
            }
            , new Object[] {
            P02913_A6LegNumero, P02913_A1EmpCod, P02913_A3CliCod
            }
            , new Object[] {
            P02914_A6LegNumero, P02914_A506LegLicSitCodigo, P02914_A1EmpCod, P02914_A3CliCod, P02914_A1497LegLicEstado, P02914_A76LegLicenIni, P02914_A481LegLicenFin
            }
         }
      );
      AV48Pgmname = "inicializarPeriodosCCLic" ;
      /* GeneXus formulas. */
      AV48Pgmname = "inicializarPeriodosCCLic" ;
      Gx_err = (short)(0) ;
   }

   private byte AV11EmpPerVacDes ;
   private byte GXv_int5[] ;
   private byte AV12EmpPerVacHas ;
   private byte GXv_int6[] ;
   private short AV10EmpCod ;
   private short AV30desdeAnio ;
   private short AV28hoyAnio ;
   private short A1EmpCod ;
   private short AV42L ;
   private short AV8i ;
   private short AV16LegCuenAntAnios ;
   private short GXv_int12[] ;
   private short GXv_int13[] ;
   private short AV20LegCuenDiasCorres ;
   private short GXv_int14[] ;
   private short AV17LegCuenAntMeses ;
   private short GXv_int16[] ;
   private short AV34LegCuenDiasGoz ;
   private short AV35LegCuLiPCur ;
   private short GXv_int17[] ;
   private short A501LegLicCntDias ;
   private short Gx_err ;
   private int AV9clicod ;
   private int AV44parmLegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private int AV26LegNumero ;
   private int AV15LegCuenANtDias ;
   private java.math.BigDecimal AV13EmpFracVacAnt ;
   private java.math.BigDecimal GXv_decimal7[] ;
   private String AV25LegCuenLicTpo ;
   private String AV18mensualTLiqCod ;
   private String GXt_char1 ;
   private String scmdbuf ;
   private String GXv_char4[] ;
   private String GXv_char3[] ;
   private String GXv_char15[] ;
   private String AV48Pgmname ;
   private String AV24vacacionesSitCodigo ;
   private String GXt_char2 ;
   private String GXv_char18[] ;
   private String A506LegLicSitCodigo ;
   private String A1497LegLicEstado ;
   private java.util.Date AV29hoy ;
   private java.util.Date AV40primerIngFecha ;
   private java.util.Date AV22LegCuenLicPerIni ;
   private java.util.Date AV23LegCuenLicPerFin ;
   private java.util.Date AV14antiguedadFecha ;
   private java.util.Date AV43LegFecIngreso ;
   private java.util.Date GXv_date8[] ;
   private java.util.Date AV27fecha ;
   private java.util.Date A76LegLicenIni ;
   private java.util.Date A481LegLicenFin ;
   private boolean AV32LegCuLIncluir ;
   private boolean GXv_boolean9[] ;
   private boolean AV31LegCuLRecalc ;
   private boolean AV33existe ;
   private boolean Cond_result ;
   private boolean AV38otroshay ;
   private boolean GXv_boolean11[] ;
   private boolean AV39iniHay ;
   private boolean GXv_boolean10[] ;
   private String AV21LegCueAntTexto ;
   private String AV37LegCueAntAbr ;
   private GXSimpleCollection<Integer> AV41collection_LegNumero ;
   private IDataStoreProvider pr_default ;
   private int[] P02912_A6LegNumero ;
   private short[] P02912_A1EmpCod ;
   private int[] P02912_A3CliCod ;
   private int[] P02913_A6LegNumero ;
   private short[] P02913_A1EmpCod ;
   private int[] P02913_A3CliCod ;
   private int[] P02914_A6LegNumero ;
   private String[] P02914_A506LegLicSitCodigo ;
   private short[] P02914_A1EmpCod ;
   private int[] P02914_A3CliCod ;
   private String[] P02914_A1497LegLicEstado ;
   private java.util.Date[] P02914_A76LegLicenIni ;
   private java.util.Date[] P02914_A481LegLicenFin ;
}

final  class inicializarperiodoscclic__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P02912( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          int AV44parmLegNumero ,
                                          int A6LegNumero ,
                                          int AV9clicod ,
                                          short AV10EmpCod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int19 = new byte[3];
      Object[] GXv_Object20 = new Object[2];
      scmdbuf = "SELECT LegNumero, EmpCod, CliCod FROM Legajo" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ?)");
      if ( ! (0==AV44parmLegNumero) )
      {
         addWhere(sWhereString, "(LegNumero = ?)");
      }
      else
      {
         GXv_int19[2] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, EmpCod" ;
      GXv_Object20[0] = scmdbuf ;
      GXv_Object20[1] = GXv_int19 ;
      return GXv_Object20 ;
   }

   protected Object[] conditional_P02913( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          int AV44parmLegNumero ,
                                          int A6LegNumero ,
                                          int AV9clicod ,
                                          short AV10EmpCod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int21 = new byte[3];
      Object[] GXv_Object22 = new Object[2];
      scmdbuf = "SELECT LegNumero, EmpCod, CliCod FROM Legajo" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ?)");
      if ( ! (0==AV44parmLegNumero) )
      {
         addWhere(sWhereString, "(LegNumero = ?)");
      }
      else
      {
         GXv_int21[2] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, EmpCod" ;
      GXv_Object22[0] = scmdbuf ;
      GXv_Object22[1] = GXv_int21 ;
      return GXv_Object22 ;
   }

   protected Object[] conditional_P02914( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          int AV44parmLegNumero ,
                                          int A6LegNumero ,
                                          String A506LegLicSitCodigo ,
                                          String AV24vacacionesSitCodigo ,
                                          int AV9clicod ,
                                          short AV10EmpCod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int23 = new byte[4];
      Object[] GXv_Object24 = new Object[2];
      scmdbuf = "SELECT LegNumero, LegLicSitCodigo, EmpCod, CliCod, LegLicEstado, LegLicenIni, LegLicenFin FROM LegajoLicencias" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ?)");
      addWhere(sWhereString, "(LegLicSitCodigo = ( ?))");
      if ( ! (0==AV44parmLegNumero) )
      {
         addWhere(sWhereString, "(LegNumero = ?)");
      }
      else
      {
         GXv_int23[3] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, EmpCod" ;
      GXv_Object24[0] = scmdbuf ;
      GXv_Object24[1] = GXv_int23 ;
      return GXv_Object24 ;
   }

   public Object [] getDynamicStatement( int cursor ,
                                         ModelContext context ,
                                         int remoteHandle ,
                                         com.genexus.IHttpContext httpContext ,
                                         Object [] dynConstraints )
   {
      switch ( cursor )
      {
            case 0 :
                  return conditional_P02912(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).intValue() , ((Number) dynConstraints[1]).intValue() , ((Number) dynConstraints[2]).intValue() , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).intValue() , ((Number) dynConstraints[5]).shortValue() );
            case 1 :
                  return conditional_P02913(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).intValue() , ((Number) dynConstraints[1]).intValue() , ((Number) dynConstraints[2]).intValue() , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).intValue() , ((Number) dynConstraints[5]).shortValue() );
            case 2 :
                  return conditional_P02914(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).intValue() , ((Number) dynConstraints[1]).intValue() , (String)dynConstraints[2] , (String)dynConstraints[3] , ((Number) dynConstraints[4]).intValue() , ((Number) dynConstraints[5]).shortValue() , ((Number) dynConstraints[6]).intValue() , ((Number) dynConstraints[7]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02912", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P02913", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P02914", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 4);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((java.util.Date[]) buf[5])[0] = rslt.getGXDate(6);
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDate(7);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      short sIdx;
      switch ( cursor )
      {
            case 0 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[3]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[4]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[5]).intValue());
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[3]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[4]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[5]).intValue());
               }
               return;
            case 2 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[4]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[5]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[6], 4);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[7]).intValue());
               }
               return;
      }
   }

}

