package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class newlegajocuentalicencia extends GXProcedure
{
   public newlegajocuentalicencia( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( newlegajocuentalicencia.class ), "" );
   }

   public newlegajocuentalicencia( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        String aP3 ,
                        short aP4 ,
                        java.util.Date aP5 ,
                        java.util.Date aP6 ,
                        int aP7 ,
                        short aP8 ,
                        short aP9 ,
                        short aP10 ,
                        short aP11 ,
                        short aP12 ,
                        String aP13 ,
                        String aP14 ,
                        short aP15 ,
                        short aP16 ,
                        short aP17 ,
                        short aP18 ,
                        short aP19 ,
                        short aP20 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17, aP18, aP19, aP20);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String aP3 ,
                             short aP4 ,
                             java.util.Date aP5 ,
                             java.util.Date aP6 ,
                             int aP7 ,
                             short aP8 ,
                             short aP9 ,
                             short aP10 ,
                             short aP11 ,
                             short aP12 ,
                             String aP13 ,
                             String aP14 ,
                             short aP15 ,
                             short aP16 ,
                             short aP17 ,
                             short aP18 ,
                             short aP19 ,
                             short aP20 )
   {
      newlegajocuentalicencia.this.AV27CliCod = aP0;
      newlegajocuentalicencia.this.AV26EmpCod = aP1;
      newlegajocuentalicencia.this.AV25LegNumero = aP2;
      newlegajocuentalicencia.this.AV24LegCuenLicTpo = aP3;
      newlegajocuentalicencia.this.AV23LegCuenAnio = aP4;
      newlegajocuentalicencia.this.AV22LegCuenLicPerIni = aP5;
      newlegajocuentalicencia.this.AV21LegCuenLicPerFin = aP6;
      newlegajocuentalicencia.this.AV20LegCuenAntDias = aP7;
      newlegajocuentalicencia.this.AV19LegCuenAntAnios = aP8;
      newlegajocuentalicencia.this.AV18LegCuenAntMeses = aP9;
      newlegajocuentalicencia.this.AV17LegCuenDiasCorres = aP10;
      newlegajocuentalicencia.this.AV16LegCuenDiasGoz = aP11;
      newlegajocuentalicencia.this.AV15LegCuenDiasVig = aP12;
      newlegajocuentalicencia.this.AV14LegCueAntTexto = aP13;
      newlegajocuentalicencia.this.AV29LegCueAntAbr = aP14;
      newlegajocuentalicencia.this.AV13LegCuLiPCur = aP15;
      newlegajocuentalicencia.this.AV12LegCuLiPAnt = aP16;
      newlegajocuentalicencia.this.AV11LegCuLiPVen = aP17;
      newlegajocuentalicencia.this.AV10LegCuLiPSaldo = aP18;
      newlegajocuentalicencia.this.AV9LegCuLiPApr = aP19;
      newlegajocuentalicencia.this.AV8LegCuLiAprPGoce = aP20;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV37GXLvl1 = (byte)(0) ;
      /* Using cursor P02BN2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV27CliCod), Short.valueOf(AV26EmpCod), Integer.valueOf(AV25LegNumero), AV24LegCuenLicTpo, Short.valueOf(AV23LegCuenAnio)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A2266LegCuenAnio = P02BN2_A2266LegCuenAnio[0] ;
         A2243LegCuenLicTpo = P02BN2_A2243LegCuenLicTpo[0] ;
         A6LegNumero = P02BN2_A6LegNumero[0] ;
         A1EmpCod = P02BN2_A1EmpCod[0] ;
         A3CliCod = P02BN2_A3CliCod[0] ;
         A2244LegCuenLicPerIni = P02BN2_A2244LegCuenLicPerIni[0] ;
         A2245LegCuenLicPerFin = P02BN2_A2245LegCuenLicPerFin[0] ;
         A2248LegCuenDiasGoz = P02BN2_A2248LegCuenDiasGoz[0] ;
         A2302LegCuLiPCur = P02BN2_A2302LegCuLiPCur[0] ;
         A2246LegCuenAntDias = P02BN2_A2246LegCuenAntDias[0] ;
         A2299LegCuenAntAnios = P02BN2_A2299LegCuenAntAnios[0] ;
         A2300LegCuenAntMeses = P02BN2_A2300LegCuenAntMeses[0] ;
         A2247LegCuenDiasCorres = P02BN2_A2247LegCuenDiasCorres[0] ;
         A2301LegCueAntTexto = P02BN2_A2301LegCueAntTexto[0] ;
         A2328LegCueAntAbr = P02BN2_A2328LegCueAntAbr[0] ;
         A2303LegCuLiPAnt = P02BN2_A2303LegCuLiPAnt[0] ;
         A2304LegCuLiPVen = P02BN2_A2304LegCuLiPVen[0] ;
         A2305LegCuLiPSaldo = P02BN2_A2305LegCuLiPSaldo[0] ;
         A2306LegCuLiPApr = P02BN2_A2306LegCuLiPApr[0] ;
         A2313LegCuLTotCons = P02BN2_A2313LegCuLTotCons[0] ;
         A2314LegCuLTotCorr = P02BN2_A2314LegCuLTotCorr[0] ;
         A2315LegCuLActVen = P02BN2_A2315LegCuLActVen[0] ;
         AV37GXLvl1 = (byte)(1) ;
         A2244LegCuenLicPerIni = AV22LegCuenLicPerIni ;
         A2245LegCuenLicPerFin = AV21LegCuenLicPerFin ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV27CliCod, AV38Pgmname, httpContext.getMessage( "&LegNumero ", "")+GXutil.trim( GXutil.str( AV25LegNumero, 8, 0))+httpContext.getMessage( " actualiza con ", "")+GXutil.trim( GXutil.str( AV16LegCuenDiasGoz, 4, 0))+httpContext.getMessage( " para ", "")+GXutil.trim( GXutil.str( AV23LegCuenAnio, 4, 0))) ;
         A2248LegCuenDiasGoz = AV16LegCuenDiasGoz ;
         A2302LegCuLiPCur = AV13LegCuLiPCur ;
         A2246LegCuenAntDias = AV20LegCuenAntDias ;
         A2299LegCuenAntAnios = AV19LegCuenAntAnios ;
         A2300LegCuenAntMeses = AV18LegCuenAntMeses ;
         A2247LegCuenDiasCorres = AV17LegCuenDiasCorres ;
         A2301LegCueAntTexto = AV14LegCueAntTexto ;
         A2328LegCueAntAbr = AV29LegCueAntAbr ;
         A2303LegCuLiPAnt = (short)(0) ;
         A2304LegCuLiPVen = (short)(0) ;
         A2305LegCuLiPSaldo = (short)(0) ;
         A2306LegCuLiPApr = (short)(0) ;
         A2313LegCuLTotCons = 0 ;
         A2314LegCuLTotCorr = 0 ;
         GXv_int1[0] = AV32EmpPerVacDes ;
         GXv_int2[0] = AV31EmpPerVacHas ;
         GXv_decimal3[0] = AV30EmpFracVacAnt ;
         new web.getemppervac(remoteHandle, context).execute( AV27CliCod, AV26EmpCod, GXv_int1, GXv_int2, GXv_decimal3) ;
         newlegajocuentalicencia.this.AV32EmpPerVacDes = GXv_int1[0] ;
         newlegajocuentalicencia.this.AV31EmpPerVacHas = GXv_int2[0] ;
         newlegajocuentalicencia.this.AV30EmpFracVacAnt = GXv_decimal3[0] ;
         if ( AV30EmpFracVacAnt.doubleValue() >= 1 )
         {
            A2315LegCuLActVen = (short)(0) ;
         }
         else
         {
            AV34hoy = GXutil.serverDate( context, remoteHandle, pr_default) ;
            if ( A2266LegCuenAnio < GXutil.year( AV34hoy) )
            {
               if ( AV16LegCuenDiasGoz < A2247LegCuenDiasCorres )
               {
                  AV33disponiblesPorUnaje = DecimalUtil.doubleToDec(1).subtract(AV30EmpFracVacAnt) ;
                  A2315LegCuLActVen = (short)(DecimalUtil.decToDouble(GXutil.roundDecimal( DecimalUtil.doubleToDec((A2247LegCuenDiasCorres-(AV16LegCuenDiasGoz))).multiply(AV33disponiblesPorUnaje), 0))) ;
               }
            }
         }
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         /* Using cursor P02BN3 */
         pr_default.execute(1, new Object[] {A2244LegCuenLicPerIni, A2245LegCuenLicPerFin, Short.valueOf(A2248LegCuenDiasGoz), Short.valueOf(A2302LegCuLiPCur), Integer.valueOf(A2246LegCuenAntDias), Short.valueOf(A2299LegCuenAntAnios), Short.valueOf(A2300LegCuenAntMeses), Short.valueOf(A2247LegCuenDiasCorres), A2301LegCueAntTexto, A2328LegCueAntAbr, Short.valueOf(A2303LegCuLiPAnt), Short.valueOf(A2304LegCuLiPVen), Short.valueOf(A2305LegCuLiPSaldo), Short.valueOf(A2306LegCuLiPApr), Integer.valueOf(A2313LegCuLTotCons), Integer.valueOf(A2314LegCuLTotCorr), Short.valueOf(A2315LegCuLActVen), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A2243LegCuenLicTpo, Short.valueOf(A2266LegCuenAnio)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("legajo_cuenta_licencias");
         if (true) break;
         /* Using cursor P02BN4 */
         pr_default.execute(2, new Object[] {A2244LegCuenLicPerIni, A2245LegCuenLicPerFin, Short.valueOf(A2248LegCuenDiasGoz), Short.valueOf(A2302LegCuLiPCur), Integer.valueOf(A2246LegCuenAntDias), Short.valueOf(A2299LegCuenAntAnios), Short.valueOf(A2300LegCuenAntMeses), Short.valueOf(A2247LegCuenDiasCorres), A2301LegCueAntTexto, A2328LegCueAntAbr, Short.valueOf(A2303LegCuLiPAnt), Short.valueOf(A2304LegCuLiPVen), Short.valueOf(A2305LegCuLiPSaldo), Short.valueOf(A2306LegCuLiPApr), Integer.valueOf(A2313LegCuLTotCons), Integer.valueOf(A2314LegCuLTotCorr), Short.valueOf(A2315LegCuLActVen), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A2243LegCuenLicTpo, Short.valueOf(A2266LegCuenAnio)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("legajo_cuenta_licencias");
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      if ( AV37GXLvl1 == 0 )
      {
         new web.msgdebug_prod2(remoteHandle, context).execute( AV27CliCod, AV38Pgmname, httpContext.getMessage( "none", "")) ;
         /*
            INSERT RECORD ON TABLE legajo_cuenta_licencias

         */
         A3CliCod = AV27CliCod ;
         A1EmpCod = AV26EmpCod ;
         A6LegNumero = AV25LegNumero ;
         A2243LegCuenLicTpo = AV24LegCuenLicTpo ;
         A2266LegCuenAnio = AV23LegCuenAnio ;
         A2244LegCuenLicPerIni = AV22LegCuenLicPerIni ;
         A2245LegCuenLicPerFin = AV21LegCuenLicPerFin ;
         A2246LegCuenAntDias = AV20LegCuenAntDias ;
         A2299LegCuenAntAnios = AV19LegCuenAntAnios ;
         A2300LegCuenAntMeses = AV18LegCuenAntMeses ;
         A2247LegCuenDiasCorres = AV17LegCuenDiasCorres ;
         A2248LegCuenDiasGoz = AV16LegCuenDiasGoz ;
         A2249LegCuenDiasVig = AV15LegCuenDiasVig ;
         A2301LegCueAntTexto = AV14LegCueAntTexto ;
         A2328LegCueAntAbr = AV29LegCueAntAbr ;
         A2302LegCuLiPCur = AV13LegCuLiPCur ;
         A2303LegCuLiPAnt = AV12LegCuLiPAnt ;
         A2304LegCuLiPVen = AV11LegCuLiPVen ;
         A2305LegCuLiPSaldo = AV10LegCuLiPSaldo ;
         A2306LegCuLiPApr = AV9LegCuLiPApr ;
         A2307LegCuLiAprPGoce = AV8LegCuLiAprPGoce ;
         A2313LegCuLTotCons = 0 ;
         A2314LegCuLTotCorr = 0 ;
         A2315LegCuLActVen = (short)(0) ;
         A2321LegCuLIncluir = true ;
         A2322LegCuLRecalc = true ;
         /* Using cursor P02BN5 */
         pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A2243LegCuenLicTpo, Short.valueOf(A2266LegCuenAnio), A2244LegCuenLicPerIni, A2245LegCuenLicPerFin, Integer.valueOf(A2246LegCuenAntDias), Short.valueOf(A2247LegCuenDiasCorres), Short.valueOf(A2248LegCuenDiasGoz), Short.valueOf(A2249LegCuenDiasVig), Short.valueOf(A2315LegCuLActVen), Integer.valueOf(A2313LegCuLTotCons), Integer.valueOf(A2314LegCuLTotCorr), Short.valueOf(A2299LegCuenAntAnios), Short.valueOf(A2300LegCuenAntMeses), A2301LegCueAntTexto, A2328LegCueAntAbr, Short.valueOf(A2302LegCuLiPCur), Short.valueOf(A2303LegCuLiPAnt), Short.valueOf(A2304LegCuLiPVen), Short.valueOf(A2305LegCuLiPSaldo), Short.valueOf(A2306LegCuLiPApr), Short.valueOf(A2307LegCuLiAprPGoce), Boolean.valueOf(A2321LegCuLIncluir), Boolean.valueOf(A2322LegCuLRecalc)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("legajo_cuenta_licencias");
         if ( (pr_default.getStatus(3) == 1) )
         {
            Gx_err = (short)(1) ;
            Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
         }
         else
         {
            Gx_err = (short)(0) ;
            Gx_emsg = "" ;
         }
         /* End Insert */
      }
      if ( ! (0==AV16LegCuenDiasGoz) )
      {
         GXv_int4[0] = (short)(0) ;
         new web.newlegcclicconsumos(remoteHandle, context).execute( AV27CliCod, AV26EmpCod, AV25LegNumero, AV24LegCuenLicTpo, AV23LegCuenAnio, AV23LegCuenAnio, AV16LegCuenDiasGoz, "inicializacion", 0, GXv_int4) ;
         GXv_boolean5[0] = false ;
         GXv_int4[0] = (short)(0) ;
         new web.newliccc_aprobacion(remoteHandle, context).execute( AV27CliCod, AV26EmpCod, AV25LegNumero, AV24LegCuenLicTpo, AV23LegCuenAnio, AV28fecha, AV16LegCuenDiasGoz, "inicializacion", 0, GXv_boolean5, GXv_int4) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "newlegajocuentalicencia");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      scmdbuf = "" ;
      P02BN2_A2266LegCuenAnio = new short[1] ;
      P02BN2_A2243LegCuenLicTpo = new String[] {""} ;
      P02BN2_A6LegNumero = new int[1] ;
      P02BN2_A1EmpCod = new short[1] ;
      P02BN2_A3CliCod = new int[1] ;
      P02BN2_A2244LegCuenLicPerIni = new java.util.Date[] {GXutil.nullDate()} ;
      P02BN2_A2245LegCuenLicPerFin = new java.util.Date[] {GXutil.nullDate()} ;
      P02BN2_A2248LegCuenDiasGoz = new short[1] ;
      P02BN2_A2302LegCuLiPCur = new short[1] ;
      P02BN2_A2246LegCuenAntDias = new int[1] ;
      P02BN2_A2299LegCuenAntAnios = new short[1] ;
      P02BN2_A2300LegCuenAntMeses = new short[1] ;
      P02BN2_A2247LegCuenDiasCorres = new short[1] ;
      P02BN2_A2301LegCueAntTexto = new String[] {""} ;
      P02BN2_A2328LegCueAntAbr = new String[] {""} ;
      P02BN2_A2303LegCuLiPAnt = new short[1] ;
      P02BN2_A2304LegCuLiPVen = new short[1] ;
      P02BN2_A2305LegCuLiPSaldo = new short[1] ;
      P02BN2_A2306LegCuLiPApr = new short[1] ;
      P02BN2_A2313LegCuLTotCons = new int[1] ;
      P02BN2_A2314LegCuLTotCorr = new int[1] ;
      P02BN2_A2315LegCuLActVen = new short[1] ;
      A2243LegCuenLicTpo = "" ;
      A2244LegCuenLicPerIni = GXutil.nullDate() ;
      A2245LegCuenLicPerFin = GXutil.nullDate() ;
      A2301LegCueAntTexto = "" ;
      A2328LegCueAntAbr = "" ;
      AV38Pgmname = "" ;
      GXv_int1 = new byte[1] ;
      GXv_int2 = new byte[1] ;
      AV30EmpFracVacAnt = DecimalUtil.ZERO ;
      GXv_decimal3 = new java.math.BigDecimal[1] ;
      AV34hoy = GXutil.nullDate() ;
      AV33disponiblesPorUnaje = DecimalUtil.ZERO ;
      Gx_emsg = "" ;
      AV28fecha = GXutil.nullDate() ;
      GXv_boolean5 = new boolean[1] ;
      GXv_int4 = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.newlegajocuentalicencia__default(),
         new Object[] {
             new Object[] {
            P02BN2_A2266LegCuenAnio, P02BN2_A2243LegCuenLicTpo, P02BN2_A6LegNumero, P02BN2_A1EmpCod, P02BN2_A3CliCod, P02BN2_A2244LegCuenLicPerIni, P02BN2_A2245LegCuenLicPerFin, P02BN2_A2248LegCuenDiasGoz, P02BN2_A2302LegCuLiPCur, P02BN2_A2246LegCuenAntDias,
            P02BN2_A2299LegCuenAntAnios, P02BN2_A2300LegCuenAntMeses, P02BN2_A2247LegCuenDiasCorres, P02BN2_A2301LegCueAntTexto, P02BN2_A2328LegCueAntAbr, P02BN2_A2303LegCuLiPAnt, P02BN2_A2304LegCuLiPVen, P02BN2_A2305LegCuLiPSaldo, P02BN2_A2306LegCuLiPApr, P02BN2_A2313LegCuLTotCons,
            P02BN2_A2314LegCuLTotCorr, P02BN2_A2315LegCuLActVen
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
         }
      );
      AV38Pgmname = "newLegajoCuentaLIcencia" ;
      /* GeneXus formulas. */
      AV38Pgmname = "newLegajoCuentaLIcencia" ;
      Gx_err = (short)(0) ;
   }

   private byte AV37GXLvl1 ;
   private byte AV32EmpPerVacDes ;
   private byte GXv_int1[] ;
   private byte AV31EmpPerVacHas ;
   private byte GXv_int2[] ;
   private short AV26EmpCod ;
   private short AV23LegCuenAnio ;
   private short AV19LegCuenAntAnios ;
   private short AV18LegCuenAntMeses ;
   private short AV17LegCuenDiasCorres ;
   private short AV16LegCuenDiasGoz ;
   private short AV15LegCuenDiasVig ;
   private short AV13LegCuLiPCur ;
   private short AV12LegCuLiPAnt ;
   private short AV11LegCuLiPVen ;
   private short AV10LegCuLiPSaldo ;
   private short AV9LegCuLiPApr ;
   private short AV8LegCuLiAprPGoce ;
   private short A2266LegCuenAnio ;
   private short A1EmpCod ;
   private short A2248LegCuenDiasGoz ;
   private short A2302LegCuLiPCur ;
   private short A2299LegCuenAntAnios ;
   private short A2300LegCuenAntMeses ;
   private short A2247LegCuenDiasCorres ;
   private short A2303LegCuLiPAnt ;
   private short A2304LegCuLiPVen ;
   private short A2305LegCuLiPSaldo ;
   private short A2306LegCuLiPApr ;
   private short A2315LegCuLActVen ;
   private short A2249LegCuenDiasVig ;
   private short A2307LegCuLiAprPGoce ;
   private short Gx_err ;
   private short GXv_int4[] ;
   private int AV27CliCod ;
   private int AV25LegNumero ;
   private int AV20LegCuenAntDias ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private int A2246LegCuenAntDias ;
   private int A2313LegCuLTotCons ;
   private int A2314LegCuLTotCorr ;
   private int GX_INS285 ;
   private java.math.BigDecimal AV30EmpFracVacAnt ;
   private java.math.BigDecimal GXv_decimal3[] ;
   private java.math.BigDecimal AV33disponiblesPorUnaje ;
   private String AV24LegCuenLicTpo ;
   private String scmdbuf ;
   private String A2243LegCuenLicTpo ;
   private String AV38Pgmname ;
   private String Gx_emsg ;
   private java.util.Date AV22LegCuenLicPerIni ;
   private java.util.Date AV21LegCuenLicPerFin ;
   private java.util.Date A2244LegCuenLicPerIni ;
   private java.util.Date A2245LegCuenLicPerFin ;
   private java.util.Date AV34hoy ;
   private java.util.Date AV28fecha ;
   private boolean A2321LegCuLIncluir ;
   private boolean A2322LegCuLRecalc ;
   private boolean GXv_boolean5[] ;
   private String AV14LegCueAntTexto ;
   private String A2301LegCueAntTexto ;
   private String AV29LegCueAntAbr ;
   private String A2328LegCueAntAbr ;
   private IDataStoreProvider pr_default ;
   private short[] P02BN2_A2266LegCuenAnio ;
   private String[] P02BN2_A2243LegCuenLicTpo ;
   private int[] P02BN2_A6LegNumero ;
   private short[] P02BN2_A1EmpCod ;
   private int[] P02BN2_A3CliCod ;
   private java.util.Date[] P02BN2_A2244LegCuenLicPerIni ;
   private java.util.Date[] P02BN2_A2245LegCuenLicPerFin ;
   private short[] P02BN2_A2248LegCuenDiasGoz ;
   private short[] P02BN2_A2302LegCuLiPCur ;
   private int[] P02BN2_A2246LegCuenAntDias ;
   private short[] P02BN2_A2299LegCuenAntAnios ;
   private short[] P02BN2_A2300LegCuenAntMeses ;
   private short[] P02BN2_A2247LegCuenDiasCorres ;
   private String[] P02BN2_A2301LegCueAntTexto ;
   private String[] P02BN2_A2328LegCueAntAbr ;
   private short[] P02BN2_A2303LegCuLiPAnt ;
   private short[] P02BN2_A2304LegCuLiPVen ;
   private short[] P02BN2_A2305LegCuLiPSaldo ;
   private short[] P02BN2_A2306LegCuLiPApr ;
   private int[] P02BN2_A2313LegCuLTotCons ;
   private int[] P02BN2_A2314LegCuLTotCorr ;
   private short[] P02BN2_A2315LegCuLActVen ;
}

final  class newlegajocuentalicencia__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02BN2", "SELECT LegCuenAnio, LegCuenLicTpo, LegNumero, EmpCod, CliCod, LegCuenLicPerIni, LegCuenLicPerFin, LegCuenDiasGoz, LegCuLiPCur, LegCuenAntDias, LegCuenAntAnios, LegCuenAntMeses, LegCuenDiasCorres, LegCueAntTexto, LegCueAntAbr, LegCuLiPAnt, LegCuLiPVen, LegCuLiPSaldo, LegCuLiPApr, LegCuLTotCons, LegCuLTotCorr, LegCuLActVen FROM legajo_cuenta_licencias WHERE CliCod = ? and EmpCod = ? and LegNumero = ? and LegCuenLicTpo = ( ?) and LegCuenAnio = ? ORDER BY CliCod, EmpCod, LegNumero, LegCuenLicTpo, LegCuenAnio  LIMIT 1 FOR UPDATE OF legajo_cuenta_licencias",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P02BN3", "SAVEPOINT gxupdate;UPDATE legajo_cuenta_licencias SET LegCuenLicPerIni=?, LegCuenLicPerFin=?, LegCuenDiasGoz=?, LegCuLiPCur=?, LegCuenAntDias=?, LegCuenAntAnios=?, LegCuenAntMeses=?, LegCuenDiasCorres=?, LegCueAntTexto=?, LegCueAntAbr=?, LegCuLiPAnt=?, LegCuLiPVen=?, LegCuLiPSaldo=?, LegCuLiPApr=?, LegCuLTotCons=?, LegCuLTotCorr=?, LegCuLActVen=?  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegCuenLicTpo = ? AND LegCuenAnio = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P02BN4", "SAVEPOINT gxupdate;UPDATE legajo_cuenta_licencias SET LegCuenLicPerIni=?, LegCuenLicPerFin=?, LegCuenDiasGoz=?, LegCuLiPCur=?, LegCuenAntDias=?, LegCuenAntAnios=?, LegCuenAntMeses=?, LegCuenDiasCorres=?, LegCueAntTexto=?, LegCueAntAbr=?, LegCuLiPAnt=?, LegCuLiPVen=?, LegCuLiPSaldo=?, LegCuLiPApr=?, LegCuLTotCons=?, LegCuLTotCorr=?, LegCuLActVen=?  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegCuenLicTpo = ? AND LegCuenAnio = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P02BN5", "SAVEPOINT gxupdate;INSERT INTO legajo_cuenta_licencias(CliCod, EmpCod, LegNumero, LegCuenLicTpo, LegCuenAnio, LegCuenLicPerIni, LegCuenLicPerFin, LegCuenAntDias, LegCuenDiasCorres, LegCuenDiasGoz, LegCuenDiasVig, LegCuLActVen, LegCuLTotCons, LegCuLTotCorr, LegCuenAntAnios, LegCuenAntMeses, LegCueAntTexto, LegCueAntAbr, LegCuLiPCur, LegCuLiPAnt, LegCuLiPVen, LegCuLiPSaldo, LegCuLiPApr, LegCuLiAprPGoce, LegCuLIncluir, LegCuLRecalc, LegCuLLogDis) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, '');RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((java.util.Date[]) buf[5])[0] = rslt.getGXDate(6);
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDate(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               ((short[]) buf[8])[0] = rslt.getShort(9);
               ((int[]) buf[9])[0] = rslt.getInt(10);
               ((short[]) buf[10])[0] = rslt.getShort(11);
               ((short[]) buf[11])[0] = rslt.getShort(12);
               ((short[]) buf[12])[0] = rslt.getShort(13);
               ((String[]) buf[13])[0] = rslt.getLongVarchar(14);
               ((String[]) buf[14])[0] = rslt.getVarchar(15);
               ((short[]) buf[15])[0] = rslt.getShort(16);
               ((short[]) buf[16])[0] = rslt.getShort(17);
               ((short[]) buf[17])[0] = rslt.getShort(18);
               ((short[]) buf[18])[0] = rslt.getShort(19);
               ((int[]) buf[19])[0] = rslt.getInt(20);
               ((int[]) buf[20])[0] = rslt.getInt(21);
               ((short[]) buf[21])[0] = rslt.getShort(22);
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
               stmt.setString(4, (String)parms[3], 20);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               return;
            case 1 :
               stmt.setDate(1, (java.util.Date)parms[0]);
               stmt.setDate(2, (java.util.Date)parms[1]);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               stmt.setShort(8, ((Number) parms[7]).shortValue());
               stmt.setNLongVarchar(9, (String)parms[8], false);
               stmt.setVarchar(10, (String)parms[9], 40, false);
               stmt.setShort(11, ((Number) parms[10]).shortValue());
               stmt.setShort(12, ((Number) parms[11]).shortValue());
               stmt.setShort(13, ((Number) parms[12]).shortValue());
               stmt.setShort(14, ((Number) parms[13]).shortValue());
               stmt.setInt(15, ((Number) parms[14]).intValue());
               stmt.setInt(16, ((Number) parms[15]).intValue());
               stmt.setShort(17, ((Number) parms[16]).shortValue());
               stmt.setInt(18, ((Number) parms[17]).intValue());
               stmt.setShort(19, ((Number) parms[18]).shortValue());
               stmt.setInt(20, ((Number) parms[19]).intValue());
               stmt.setString(21, (String)parms[20], 20);
               stmt.setShort(22, ((Number) parms[21]).shortValue());
               return;
            case 2 :
               stmt.setDate(1, (java.util.Date)parms[0]);
               stmt.setDate(2, (java.util.Date)parms[1]);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               stmt.setShort(8, ((Number) parms[7]).shortValue());
               stmt.setNLongVarchar(9, (String)parms[8], false);
               stmt.setVarchar(10, (String)parms[9], 40, false);
               stmt.setShort(11, ((Number) parms[10]).shortValue());
               stmt.setShort(12, ((Number) parms[11]).shortValue());
               stmt.setShort(13, ((Number) parms[12]).shortValue());
               stmt.setShort(14, ((Number) parms[13]).shortValue());
               stmt.setInt(15, ((Number) parms[14]).intValue());
               stmt.setInt(16, ((Number) parms[15]).intValue());
               stmt.setShort(17, ((Number) parms[16]).shortValue());
               stmt.setInt(18, ((Number) parms[17]).intValue());
               stmt.setShort(19, ((Number) parms[18]).shortValue());
               stmt.setInt(20, ((Number) parms[19]).intValue());
               stmt.setString(21, (String)parms[20], 20);
               stmt.setShort(22, ((Number) parms[21]).shortValue());
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setString(4, (String)parms[3], 20);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setDate(6, (java.util.Date)parms[5]);
               stmt.setDate(7, (java.util.Date)parms[6]);
               stmt.setInt(8, ((Number) parms[7]).intValue());
               stmt.setShort(9, ((Number) parms[8]).shortValue());
               stmt.setShort(10, ((Number) parms[9]).shortValue());
               stmt.setShort(11, ((Number) parms[10]).shortValue());
               stmt.setShort(12, ((Number) parms[11]).shortValue());
               stmt.setInt(13, ((Number) parms[12]).intValue());
               stmt.setInt(14, ((Number) parms[13]).intValue());
               stmt.setShort(15, ((Number) parms[14]).shortValue());
               stmt.setShort(16, ((Number) parms[15]).shortValue());
               stmt.setNLongVarchar(17, (String)parms[16], false);
               stmt.setVarchar(18, (String)parms[17], 40, false);
               stmt.setShort(19, ((Number) parms[18]).shortValue());
               stmt.setShort(20, ((Number) parms[19]).shortValue());
               stmt.setShort(21, ((Number) parms[20]).shortValue());
               stmt.setShort(22, ((Number) parms[21]).shortValue());
               stmt.setShort(23, ((Number) parms[22]).shortValue());
               stmt.setShort(24, ((Number) parms[23]).shortValue());
               stmt.setBoolean(25, ((Boolean) parms[24]).booleanValue());
               stmt.setBoolean(26, ((Boolean) parms[25]).booleanValue());
               return;
      }
   }

}

