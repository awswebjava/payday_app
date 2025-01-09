package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class legajodevuelvelicencia2 extends GXProcedure
{
   public legajodevuelvelicencia2( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( legajodevuelvelicencia2.class ), "" );
   }

   public legajodevuelvelicencia2( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             boolean aP4 ,
                             java.util.Date aP5 ,
                             boolean aP6 ,
                             java.util.Date aP7 ,
                             String aP8 ,
                             boolean aP9 ,
                             boolean aP10 ,
                             boolean aP11 ,
                             String[] aP12 ,
                             short[] aP13 ,
                             java.util.Date[] aP14 ,
                             java.util.Date[] aP15 ,
                             java.util.Date[] aP16 ,
                             java.math.BigDecimal[] aP17 ,
                             boolean[] aP18 )
   {
      legajodevuelvelicencia2.this.aP19 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17, aP18, aP19);
      return aP19[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        boolean aP4 ,
                        java.util.Date aP5 ,
                        boolean aP6 ,
                        java.util.Date aP7 ,
                        String aP8 ,
                        boolean aP9 ,
                        boolean aP10 ,
                        boolean aP11 ,
                        String[] aP12 ,
                        short[] aP13 ,
                        java.util.Date[] aP14 ,
                        java.util.Date[] aP15 ,
                        java.util.Date[] aP16 ,
                        java.math.BigDecimal[] aP17 ,
                        boolean[] aP18 ,
                        String[] aP19 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17, aP18, aP19);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             boolean aP4 ,
                             java.util.Date aP5 ,
                             boolean aP6 ,
                             java.util.Date aP7 ,
                             String aP8 ,
                             boolean aP9 ,
                             boolean aP10 ,
                             boolean aP11 ,
                             String[] aP12 ,
                             short[] aP13 ,
                             java.util.Date[] aP14 ,
                             java.util.Date[] aP15 ,
                             java.util.Date[] aP16 ,
                             java.math.BigDecimal[] aP17 ,
                             boolean[] aP18 ,
                             String[] aP19 )
   {
      legajodevuelvelicencia2.this.AV9CliCod = aP0;
      legajodevuelvelicencia2.this.AV10EmpCod = aP1;
      legajodevuelvelicencia2.this.AV11LegNumero = aP2;
      legajodevuelvelicencia2.this.AV46LiqNro = aP3;
      legajodevuelvelicencia2.this.AV35chequearExistencia = aP4;
      legajodevuelvelicencia2.this.AV12LiqPeriodo = aP5;
      legajodevuelvelicencia2.this.AV31conGoce = aP6;
      legajodevuelvelicencia2.this.AV13fin_periodo = aP7;
      legajodevuelvelicencia2.this.AV17LegLicSitCodigo = aP8;
      legajodevuelvelicencia2.this.AV18distinto = aP9;
      legajodevuelvelicencia2.this.AV29LegLicConPlus = aP10;
      legajodevuelvelicencia2.this.AV48devolverPlus = aP11;
      legajodevuelvelicencia2.this.aP12 = aP12;
      legajodevuelvelicencia2.this.aP13 = aP13;
      legajodevuelvelicencia2.this.aP14 = aP14;
      legajodevuelvelicencia2.this.aP15 = aP15;
      legajodevuelvelicencia2.this.aP16 = aP16;
      legajodevuelvelicencia2.this.aP17 = aP17;
      legajodevuelvelicencia2.this.aP18 = aP18;
      legajodevuelvelicencia2.this.aP19 = aP19;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV57Pgmname, httpContext.getMessage( "&LiqPeriodo ", "")+GXutil.trim( localUtil.dtoc( AV12LiqPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV57Pgmname, httpContext.getMessage( "&LiqPeriodo ", "")+GXutil.trim( localUtil.dtoc( AV12LiqPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " &fin_periodo ", "")+GXutil.trim( localUtil.dtoc( AV13fin_periodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " &CliCod ", "")+GXutil.trim( GXutil.str( AV9CliCod, 6, 0))+httpContext.getMessage( " empcod ", "")+GXutil.trim( GXutil.str( AV10EmpCod, 4, 0))+httpContext.getMessage( " legnumero ", "")+GXutil.trim( GXutil.str( AV11LegNumero, 8, 0))+httpContext.getMessage( " distinto ", "")+GXutil.trim( GXutil.booltostr( AV18distinto))+httpContext.getMessage( " &LegLicSitCodigo \"", "")+AV17LegLicSitCodigo+httpContext.getMessage( "\" &LegLicConPlus ", "")+GXutil.trim( GXutil.booltostr( AV29LegLicConPlus))) ;
      GXt_char1 = AV50vacasSitCodigo ;
      GXv_char2[0] = GXt_char1 ;
      new web.codigodesituacionvacaciones(remoteHandle, context).execute( AV9CliCod, GXv_char2) ;
      legajodevuelvelicencia2.this.GXt_char1 = GXv_char2[0] ;
      AV50vacasSitCodigo = GXt_char1 ;
      AV43conGoceNum = (byte)((AV31conGoce ? 1 : 0)) ;
      AV58GXLvl13 = (byte)(0) ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           AV17LegLicSitCodigo ,
                                           Boolean.valueOf(AV18distinto) ,
                                           Boolean.valueOf(AV29LegLicConPlus) ,
                                           A506LegLicSitCodigo ,
                                           Boolean.valueOf(A1218LegLicConPlus) ,
                                           A481LegLicenFin ,
                                           AV12LiqPeriodo ,
                                           A1497LegLicEstado ,
                                           Integer.valueOf(AV9CliCod) ,
                                           Short.valueOf(AV10EmpCod) ,
                                           Integer.valueOf(AV11LegNumero) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Integer.valueOf(A6LegNumero) ,
                                           A76LegLicenIni ,
                                           AV13fin_periodo } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT,
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.DATE, TypeConstants.DATE
                                           }
      });
      /* Using cursor P01IR2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV9CliCod), Short.valueOf(AV10EmpCod), Integer.valueOf(AV11LegNumero), AV12LiqPeriodo, AV13fin_periodo, AV17LegLicSitCodigo, AV17LegLicSitCodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1218LegLicConPlus = P01IR2_A1218LegLicConPlus[0] ;
         A506LegLicSitCodigo = P01IR2_A506LegLicSitCodigo[0] ;
         A481LegLicenFin = P01IR2_A481LegLicenFin[0] ;
         A76LegLicenIni = P01IR2_A76LegLicenIni[0] ;
         A6LegNumero = P01IR2_A6LegNumero[0] ;
         A1EmpCod = P01IR2_A1EmpCod[0] ;
         A3CliCod = P01IR2_A3CliCod[0] ;
         A1497LegLicEstado = P01IR2_A1497LegLicEstado[0] ;
         A1643LegSitCuenTrab = P01IR2_A1643LegSitCuenTrab[0] ;
         A1288LegSitEsAu = P01IR2_A1288LegSitEsAu[0] ;
         A1287LegSitEsLic = P01IR2_A1287LegSitEsLic[0] ;
         A1810LegLicRemCorr = P01IR2_A1810LegLicRemCorr[0] ;
         A517LegLicSitDescrip = P01IR2_A517LegLicSitDescrip[0] ;
         AV58GXLvl13 = (byte)(1) ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV57Pgmname, "1!!!") ;
         if ( ! (GXutil.strcmp("", AV17LegLicSitCodigo)==0) )
         {
            AV32aplica = true ;
         }
         else
         {
            new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV57Pgmname, httpContext.getMessage( "2 LegLicSitCodigo ", "")+GXutil.trim( A506LegLicSitCodigo)+httpContext.getMessage( " LegSitEsLic ", "")+GXutil.trim( GXutil.str( A1287LegSitEsLic, 1, 0))+httpContext.getMessage( " LegSitEsAu ", "")+GXutil.trim( GXutil.str( A1288LegSitEsAu, 1, 0))+httpContext.getMessage( " LegSitCuenTrab ", "")+GXutil.trim( GXutil.str( A1643LegSitCuenTrab, 1, 0))+httpContext.getMessage( " &conGoceNum ", "")+GXutil.trim( GXutil.str( AV43conGoceNum, 1, 0))+httpContext.getMessage( " congoce ", "")+GXutil.trim( GXutil.booltostr( AV31conGoce))) ;
            if ( ( A1287LegSitEsLic == 1 ) && ( A1643LegSitCuenTrab == AV43conGoceNum ) )
            {
               AV32aplica = true ;
               new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV57Pgmname, httpContext.getMessage( "2b", "")) ;
               if ( ! AV31conGoce )
               {
                  AV44condicionLicencia = "B1" ;
                  AV47auxLegLicSitCodigo = A506LegLicSitCodigo ;
                  new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV57Pgmname, httpContext.getMessage( "3 &CliCod ", "")+GXutil.trim( GXutil.str( AV9CliCod, 6, 0))+httpContext.getMessage( " &EmpCod ", "")+GXutil.trim( GXutil.str( AV10EmpCod, 4, 0))+httpContext.getMessage( " &LegNumero ", "")+GXutil.trim( GXutil.str( AV11LegNumero, 8, 0))+httpContext.getMessage( " &condicionLicencia ", "")+GXutil.trim( AV44condicionLicencia)+httpContext.getMessage( " &LiqNro ", "")+GXutil.trim( GXutil.str( AV46LiqNro, 8, 0))+httpContext.getMessage( " &auxLegLicSitCodigo ", "")+GXutil.trim( AV47auxLegLicSitCodigo)) ;
                  /* Execute user subroutine: 'APLICA SIN GOCE' */
                  S111 ();
                  if ( returnInSub )
                  {
                     pr_default.close(0);
                     returnInSub = true;
                     cleanup();
                     if (true) return;
                  }
               }
            }
            else
            {
               AV32aplica = false ;
            }
         }
         if ( AV32aplica )
         {
            if ( GXutil.strcmp(A506LegLicSitCodigo, AV50vacasSitCodigo) == 0 )
            {
               AV49vacacionesHay = true ;
            }
            AV14SitCodigo = A506LegLicSitCodigo ;
            AV21LegLicenIni = A76LegLicenIni ;
            AV22LegLicenFin = A481LegLicenFin ;
            GXv_int3[0] = AV39LegClase ;
            new web.getlegajoclase(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, AV11LegNumero, GXv_int3) ;
            legajodevuelvelicencia2.this.AV39LegClase = GXv_int3[0] ;
            if ( ( A1218LegLicConPlus ) && ( AV48devolverPlus ) )
            {
               GXv_int4[0] = AV37PaiCod ;
               new web.empresagetpais(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, GXv_int4) ;
               legajodevuelvelicencia2.this.AV37PaiCod = GXv_int4[0] ;
               GXv_char2[0] = AV38ConveCodigo ;
               new web.empleadogetconvenio(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, AV11LegNumero, GXv_char2) ;
               legajodevuelvelicencia2.this.AV38ConveCodigo = GXv_char2[0] ;
               GXv_decimal5[0] = AV28LiqDPlus ;
               new web.getplusdebasedecalculo(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, AV46LiqNro, AV11LegNumero, AV37PaiCod, AV38ConveCodigo, AV39LegClase, "licencia", AV14SitCodigo, "", GXv_decimal5) ;
               legajodevuelvelicencia2.this.AV28LiqDPlus = GXv_decimal5[0] ;
            }
            else
            {
               AV28LiqDPlus = DecimalUtil.doubleToDec(0) ;
            }
            AV34cantLic = (short)(AV34cantLic+1) ;
            if ( AV35chequearExistencia )
            {
               AV15LegLicCntDias = (short)(AV15LegLicCntDias+1) ;
               if ( ! AV29LegLicConPlus || ( AV28LiqDPlus.doubleValue() > 0 ) )
               {
                  /* Exit For each command. Update data (if necessary), close cursors & exit. */
                  if (true) break;
               }
            }
            else
            {
               AV51EstadoRemCorr = ((A1810LegLicRemCorr==1) ? true : false) ;
               GXv_char2[0] = AV53tipo_tarifa ;
               new web.gettipodetarifa(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, AV46LiqNro, AV11LegNumero, (short)(0), "", "", GXv_char2) ;
               legajodevuelvelicencia2.this.AV53tipo_tarifa = GXv_char2[0] ;
               GXv_int4[0] = AV33auxLegLicCntDias ;
               GXv_date6[0] = AV27usoDesdeFecha ;
               GXv_date7[0] = AV26usoHastaFecha ;
               new web.calculadias(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, AV11LegNumero, AV53tipo_tarifa, AV51EstadoRemCorr, AV21LegLicenIni, AV22LegLicenFin, AV12LiqPeriodo, AV13fin_periodo, GXv_int4, GXv_date6, GXv_date7) ;
               legajodevuelvelicencia2.this.AV33auxLegLicCntDias = GXv_int4[0] ;
               legajodevuelvelicencia2.this.AV27usoDesdeFecha = GXv_date6[0] ;
               legajodevuelvelicencia2.this.AV26usoHastaFecha = GXv_date7[0] ;
               new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV57Pgmname, httpContext.getMessage( "4 &auxLegLicCntDias ", "")+GXutil.trim( GXutil.str( AV33auxLegLicCntDias, 4, 0))) ;
               AV15LegLicCntDias = (short)(AV15LegLicCntDias+AV33auxLegLicCntDias) ;
               AV36LiqDLog += " " + GXutil.trim( GXutil.str( AV33auxLegLicCntDias, 4, 0)) + httpContext.getMessage( " días de ", "") + GXutil.trim( A517LegLicSitDescrip) + "." ;
            }
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV58GXLvl13 == 0 )
      {
         new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV57Pgmname, httpContext.getMessage( "none", "")) ;
      }
      new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV57Pgmname, httpContext.getMessage( "log ", "")+GXutil.trim( AV36LiqDLog)) ;
      if ( AV34cantLic > 1 )
      {
         AV27usoDesdeFecha = GXutil.nullDate() ;
         AV26usoHastaFecha = GXutil.nullDate() ;
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'APLICA SIN GOCE' Routine */
      returnInSub = false ;
      AV59GXLvl107 = (byte)(0) ;
      /* Using cursor P01IR3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV9CliCod), AV44condicionLicencia, AV47auxLegLicSitCodigo});
      while ( (pr_default.getStatus(1) != 101) )
      {
         A954ConCondCodigo = P01IR3_A954ConCondCodigo[0] ;
         A953ConCondicion = P01IR3_A953ConCondicion[0] ;
         n953ConCondicion = P01IR3_n953ConCondicion[0] ;
         A3CliCod = P01IR3_A3CliCod[0] ;
         A26ConCodigo = P01IR3_A26ConCodigo[0] ;
         AV59GXLvl107 = (byte)(1) ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV57Pgmname, httpContext.getMessage( "encuentra!", "")) ;
         AV32aplica = false ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(1);
      }
      pr_default.close(1);
      if ( AV59GXLvl107 == 0 )
      {
         new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV57Pgmname, httpContext.getMessage( "none!", "")) ;
      }
   }

   protected void cleanup( )
   {
      this.aP12[0] = legajodevuelvelicencia2.this.AV14SitCodigo;
      this.aP13[0] = legajodevuelvelicencia2.this.AV15LegLicCntDias;
      this.aP14[0] = legajodevuelvelicencia2.this.AV21LegLicenIni;
      this.aP15[0] = legajodevuelvelicencia2.this.AV27usoDesdeFecha;
      this.aP16[0] = legajodevuelvelicencia2.this.AV26usoHastaFecha;
      this.aP17[0] = legajodevuelvelicencia2.this.AV28LiqDPlus;
      this.aP18[0] = legajodevuelvelicencia2.this.AV49vacacionesHay;
      this.aP19[0] = legajodevuelvelicencia2.this.AV36LiqDLog;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV14SitCodigo = "" ;
      AV21LegLicenIni = GXutil.nullDate() ;
      AV27usoDesdeFecha = GXutil.nullDate() ;
      AV26usoHastaFecha = GXutil.nullDate() ;
      AV28LiqDPlus = DecimalUtil.ZERO ;
      AV36LiqDLog = "" ;
      AV57Pgmname = "" ;
      AV50vacasSitCodigo = "" ;
      GXt_char1 = "" ;
      scmdbuf = "" ;
      A506LegLicSitCodigo = "" ;
      A481LegLicenFin = GXutil.nullDate() ;
      A1497LegLicEstado = "" ;
      A76LegLicenIni = GXutil.nullDate() ;
      P01IR2_A1218LegLicConPlus = new boolean[] {false} ;
      P01IR2_A506LegLicSitCodigo = new String[] {""} ;
      P01IR2_A481LegLicenFin = new java.util.Date[] {GXutil.nullDate()} ;
      P01IR2_A76LegLicenIni = new java.util.Date[] {GXutil.nullDate()} ;
      P01IR2_A6LegNumero = new int[1] ;
      P01IR2_A1EmpCod = new short[1] ;
      P01IR2_A3CliCod = new int[1] ;
      P01IR2_A1497LegLicEstado = new String[] {""} ;
      P01IR2_A1643LegSitCuenTrab = new byte[1] ;
      P01IR2_A1288LegSitEsAu = new byte[1] ;
      P01IR2_A1287LegSitEsLic = new byte[1] ;
      P01IR2_A1810LegLicRemCorr = new byte[1] ;
      P01IR2_A517LegLicSitDescrip = new String[] {""} ;
      A517LegLicSitDescrip = "" ;
      AV44condicionLicencia = "" ;
      AV47auxLegLicSitCodigo = "" ;
      AV22LegLicenFin = GXutil.nullDate() ;
      GXv_int3 = new byte[1] ;
      AV38ConveCodigo = "" ;
      GXv_decimal5 = new java.math.BigDecimal[1] ;
      AV53tipo_tarifa = "" ;
      GXv_char2 = new String[1] ;
      GXv_int4 = new short[1] ;
      GXv_date6 = new java.util.Date[1] ;
      GXv_date7 = new java.util.Date[1] ;
      P01IR3_A954ConCondCodigo = new String[] {""} ;
      P01IR3_A953ConCondicion = new String[] {""} ;
      P01IR3_n953ConCondicion = new boolean[] {false} ;
      P01IR3_A3CliCod = new int[1] ;
      P01IR3_A26ConCodigo = new String[] {""} ;
      A954ConCondCodigo = "" ;
      A953ConCondicion = "" ;
      A26ConCodigo = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.legajodevuelvelicencia2__default(),
         new Object[] {
             new Object[] {
            P01IR2_A1218LegLicConPlus, P01IR2_A506LegLicSitCodigo, P01IR2_A481LegLicenFin, P01IR2_A76LegLicenIni, P01IR2_A6LegNumero, P01IR2_A1EmpCod, P01IR2_A3CliCod, P01IR2_A1497LegLicEstado, P01IR2_A1643LegSitCuenTrab, P01IR2_A1288LegSitEsAu,
            P01IR2_A1287LegSitEsLic, P01IR2_A1810LegLicRemCorr, P01IR2_A517LegLicSitDescrip
            }
            , new Object[] {
            P01IR3_A954ConCondCodigo, P01IR3_A953ConCondicion, P01IR3_n953ConCondicion, P01IR3_A3CliCod, P01IR3_A26ConCodigo
            }
         }
      );
      AV57Pgmname = "LegajodevuelveLicencia2" ;
      /* GeneXus formulas. */
      AV57Pgmname = "LegajodevuelveLicencia2" ;
      Gx_err = (short)(0) ;
   }

   private byte AV43conGoceNum ;
   private byte AV58GXLvl13 ;
   private byte A1643LegSitCuenTrab ;
   private byte A1288LegSitEsAu ;
   private byte A1287LegSitEsLic ;
   private byte A1810LegLicRemCorr ;
   private byte AV39LegClase ;
   private byte GXv_int3[] ;
   private byte AV59GXLvl107 ;
   private short AV10EmpCod ;
   private short AV15LegLicCntDias ;
   private short A1EmpCod ;
   private short AV37PaiCod ;
   private short AV34cantLic ;
   private short AV33auxLegLicCntDias ;
   private short GXv_int4[] ;
   private short Gx_err ;
   private int AV9CliCod ;
   private int AV11LegNumero ;
   private int AV46LiqNro ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private java.math.BigDecimal AV28LiqDPlus ;
   private java.math.BigDecimal GXv_decimal5[] ;
   private String AV17LegLicSitCodigo ;
   private String AV14SitCodigo ;
   private String AV57Pgmname ;
   private String AV50vacasSitCodigo ;
   private String GXt_char1 ;
   private String scmdbuf ;
   private String A506LegLicSitCodigo ;
   private String A1497LegLicEstado ;
   private String AV44condicionLicencia ;
   private String AV47auxLegLicSitCodigo ;
   private String AV38ConveCodigo ;
   private String AV53tipo_tarifa ;
   private String GXv_char2[] ;
   private String A954ConCondCodigo ;
   private String A953ConCondicion ;
   private String A26ConCodigo ;
   private java.util.Date AV12LiqPeriodo ;
   private java.util.Date AV13fin_periodo ;
   private java.util.Date AV21LegLicenIni ;
   private java.util.Date AV27usoDesdeFecha ;
   private java.util.Date AV26usoHastaFecha ;
   private java.util.Date A481LegLicenFin ;
   private java.util.Date A76LegLicenIni ;
   private java.util.Date AV22LegLicenFin ;
   private java.util.Date GXv_date6[] ;
   private java.util.Date GXv_date7[] ;
   private boolean AV35chequearExistencia ;
   private boolean AV31conGoce ;
   private boolean AV18distinto ;
   private boolean AV29LegLicConPlus ;
   private boolean AV48devolverPlus ;
   private boolean AV49vacacionesHay ;
   private boolean A1218LegLicConPlus ;
   private boolean AV32aplica ;
   private boolean returnInSub ;
   private boolean AV51EstadoRemCorr ;
   private boolean n953ConCondicion ;
   private String AV36LiqDLog ;
   private String A517LegLicSitDescrip ;
   private String[] aP19 ;
   private String[] aP12 ;
   private short[] aP13 ;
   private java.util.Date[] aP14 ;
   private java.util.Date[] aP15 ;
   private java.util.Date[] aP16 ;
   private java.math.BigDecimal[] aP17 ;
   private boolean[] aP18 ;
   private IDataStoreProvider pr_default ;
   private boolean[] P01IR2_A1218LegLicConPlus ;
   private String[] P01IR2_A506LegLicSitCodigo ;
   private java.util.Date[] P01IR2_A481LegLicenFin ;
   private java.util.Date[] P01IR2_A76LegLicenIni ;
   private int[] P01IR2_A6LegNumero ;
   private short[] P01IR2_A1EmpCod ;
   private int[] P01IR2_A3CliCod ;
   private String[] P01IR2_A1497LegLicEstado ;
   private byte[] P01IR2_A1643LegSitCuenTrab ;
   private byte[] P01IR2_A1288LegSitEsAu ;
   private byte[] P01IR2_A1287LegSitEsLic ;
   private byte[] P01IR2_A1810LegLicRemCorr ;
   private String[] P01IR2_A517LegLicSitDescrip ;
   private String[] P01IR3_A954ConCondCodigo ;
   private String[] P01IR3_A953ConCondicion ;
   private boolean[] P01IR3_n953ConCondicion ;
   private int[] P01IR3_A3CliCod ;
   private String[] P01IR3_A26ConCodigo ;
}

final  class legajodevuelvelicencia2__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01IR2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV17LegLicSitCodigo ,
                                          boolean AV18distinto ,
                                          boolean AV29LegLicConPlus ,
                                          String A506LegLicSitCodigo ,
                                          boolean A1218LegLicConPlus ,
                                          java.util.Date A481LegLicenFin ,
                                          java.util.Date AV12LiqPeriodo ,
                                          String A1497LegLicEstado ,
                                          int AV9CliCod ,
                                          short AV10EmpCod ,
                                          int AV11LegNumero ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A6LegNumero ,
                                          java.util.Date A76LegLicenIni ,
                                          java.util.Date AV13fin_periodo )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[7];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT LegLicConPlus, LegLicSitCodigo, LegLicenFin, LegLicenIni, LegNumero, EmpCod, CliCod, LegLicEstado, LegSitCuenTrab, LegSitEsAu, LegSitEsLic, LegLicRemCorr," ;
      scmdbuf += " LegLicSitDescrip FROM LegajoLicencias" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ? and LegNumero = ?)");
      addWhere(sWhereString, "(LegLicenFin >= ?)");
      addWhere(sWhereString, "(LegLicEstado = ( 'autorizada'))");
      addWhere(sWhereString, "(LegLicenIni <= ?)");
      if ( ! (GXutil.strcmp("", AV17LegLicSitCodigo)==0) && ! AV18distinto )
      {
         addWhere(sWhereString, "(LegLicSitCodigo = ( ?))");
      }
      else
      {
         GXv_int8[5] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV17LegLicSitCodigo)==0) && ( AV18distinto ) )
      {
         addWhere(sWhereString, "(LegLicSitCodigo <> ( ?))");
      }
      else
      {
         GXv_int8[6] = (byte)(1) ;
      }
      if ( AV29LegLicConPlus )
      {
         addWhere(sWhereString, "(LegLicConPlus = TRUE)");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, EmpCod, LegNumero, LegLicenIni" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
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
                  return conditional_P01IR2(context, remoteHandle, httpContext, (String)dynConstraints[0] , ((Boolean) dynConstraints[1]).booleanValue() , ((Boolean) dynConstraints[2]).booleanValue() , (String)dynConstraints[3] , ((Boolean) dynConstraints[4]).booleanValue() , (java.util.Date)dynConstraints[5] , (java.util.Date)dynConstraints[6] , (String)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).shortValue() , ((Number) dynConstraints[10]).intValue() , ((Number) dynConstraints[11]).intValue() , ((Number) dynConstraints[12]).shortValue() , ((Number) dynConstraints[13]).intValue() , (java.util.Date)dynConstraints[14] , (java.util.Date)dynConstraints[15] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01IR2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01IR3", "SELECT ConCondCodigo, ConCondicion, CliCod, ConCodigo FROM Concepto WHERE (CliCod = ? and ConCondicion = ( ?)) AND (ConCondCodigo = ( ?)) ORDER BY CliCod, ConCondicion  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 4);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 20);
               ((byte[]) buf[8])[0] = rslt.getByte(9);
               ((byte[]) buf[9])[0] = rslt.getByte(10);
               ((byte[]) buf[10])[0] = rslt.getByte(11);
               ((byte[]) buf[11])[0] = rslt.getByte(12);
               ((String[]) buf[12])[0] = rslt.getVarchar(13);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((int[]) buf[3])[0] = rslt.getInt(3);
               ((String[]) buf[4])[0] = rslt.getString(4, 10);
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
                  stmt.setInt(sIdx, ((Number) parms[7]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[8]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[9]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[10]);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[11]);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[12], 4);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[13], 4);
               }
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 4);
               return;
      }
   }

}

